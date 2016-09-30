package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificaVentasMetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReporteVentasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.VentasMetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.MovCargueVentasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueVentas;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminVentasMetBean implements AdminVentasMet {

    @EJB
    private VentasMetDAO ventasMetDao;
    @EJB
    private MovCargueVentasDAO movCargueVentasDAO;
    @EJB
    private InventarioDAO inventarioDAO;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private MetDAO metDao;
    @EJB
    private ReporteVentasDAO reporteVentasDao;
    @EJB
    private ModificaVentasMetDAO modificaVentasMetDao;
    @EJB
    private AdminLiquidacionMes adminLiquidacionMes;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    
    /**
     * @author El Gatopardo
     * @return
     * @throws ExcepcionDAO
     */
    @EJB
    private MesDAO mesDao;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public String cargarInformacionReporteMETLinea(Long movSolicitud, String tipoReporte, int numRegistros, Long totalVentas) throws ExcepcionDAO, ExcepcionAplicacion {
        String retorno = null;
        
        try{
            //TODO: Verificar el tipo de reporte para permitir o no la modificación
            
            String letraTipoReporte = tipoReporte.substring(0, 1);
            /*String strNumeroReporte = tipoReporte.substring(1, tipoReporte.length());
            if(strNumeroReporte != null && !"".equals(strNumeroReporte)){
                Integer numeroReporte = Integer.parseInt(strNumeroReporte);
            }*/
            
            if(!"P".equals(letraTipoReporte) && !"M".equals(letraTipoReporte) && !"C".equals(letraTipoReporte) && !"Q".equals(letraTipoReporte)){
                throw new ExcepcionAplicacion("-1 El tipo de reporte solo puede ser P, Mxx, Cxx o Q. tipoReporte recibido: " + tipoReporte);
            }
            /*
             * Buscamos las ventas de la tabla intermedia por el numero de siito
             */
            List<SiitoMovCargueVentas> listaSiitoMovCargueVentas = movCargueVentasDAO.consultarMovCargueVentasXMovCarVentMovSol(movSolicitud);
            if(listaSiitoMovCargueVentas != null){
                System.out.println("Número de ventas leídas en SIITO: " + listaSiitoMovCargueVentas.size());
            }
            else{
                System.out.println("La consulta de ventas en SIITO devolvió NULL");
            }
            
            if (listaSiitoMovCargueVentas != null && !listaSiitoMovCargueVentas.isEmpty()) {
                SiitoMovCargueVentas primerCargueVentas = listaSiitoMovCargueVentas.get(0);
                //Verificamos el número de registros
                /*if(listaSiitoMovCargueVentas.size() != numRegistros){
                    throw new ExcepcionAplicacion("-2 " + "Número de registros incorrecto. " + listaSiitoMovCargueVentas.size() + " registros leidos de la base de datos");
                }
                //Verificamos los totales
                Long totalVentasCalc = 0L;
                for (SiitoMovCargueVentas siitoMovCargueVenta : listaSiitoMovCargueVentas) {
                    if(siitoMovCargueVenta.getMovCarVentValorTotalVentas() < 0){
                        siitoMovCargueVenta.setMovCarVentValorTotalVentas(100000L);
                    }
                    totalVentasCalc += siitoMovCargueVenta.getMovCarVentValorTotalVentas();
                }
                if(!totalVentasCalc.equals(totalVentas)){
                    throw new ExcepcionAplicacion("-3 " + "Total ventas incorrecto. " + totalVentasCalc + " total ventas calculado de la base de datos");
                }*/
                
                String strFechaVenta = primerCargueVentas.getMovCarVentFechaVenta();
                String strVigencia = strFechaVenta.substring(0, 4);
                String strMes = strFechaVenta.substring(4, 6);
                SiiMes siiMes = mesDao.buscarMesPorId(Integer.parseInt(strMes));
                Integer vigencia = Integer.parseInt(strVigencia);
                Integer mesActual = new Integer(strMes);
                
                String contratoAnterior = "";
                String nitAnterior = "";
                
                if("P".equals(letraTipoReporte)){
                    //Validamos que no se haya realizado la carga
                    System.out.println("El tipo de reporte para la carga es P");
                    List<SiiReporteVentas> listaReporteVentas = reporteVentasDao.buscarReportesVentasPorMovimiento(movSolicitud);
                    
                    if(listaReporteVentas != null && listaReporteVentas.size() > 0){
                        System.out.println("Ya se registraron las ventas para el movimiento " + movSolicitud);
                    }
                    
                    else{
                        SiiReporteVentas siiReporteVentas = null;
                        int ventasLeidas = 0;
                        int reportesCargados = 0;
                        int ventasCargadas = 0;
                        int ventasCargadasPorInventario = 0;
                        int ventasNoCargadas = 0;
                        int contratosCargados = 0;
                        int contratosNoCargados = 0;
                        SiiContrato siiContrato = null;
                        
                        for(SiitoMovCargueVentas siitoMovCargueVenta : listaSiitoMovCargueVentas) {
                            ventasLeidas++;

                            if(!siitoMovCargueVenta.getMovCarVentContrato().equals(contratoAnterior) || !siitoMovCargueVenta.getMovCarVentNit().equals(nitAnterior)) {
                                //Buscamos el contrato
                                siiContrato = contratoDao.buscarContratoPorNumeroPorNit(siitoMovCargueVenta.getMovCarVentNit(), siitoMovCargueVenta.getMovCarVentContrato());
                                if(siiContrato == null) {
                                    System.out.println("No se encontró el contrato " + siitoMovCargueVenta.getMovCarVentContrato() + " del NIT " + siitoMovCargueVenta.getMovCarVentNit());
                                    contratosNoCargados++;
                                    ventasNoCargadas++;
                                    contratoAnterior = siitoMovCargueVenta.getMovCarVentContrato();
                                    nitAnterior = siitoMovCargueVenta.getMovCarVentNit();
                                    continue;
                                }
                                
                                contratosCargados++;
                                //Creamos el registro de reporte_ventas
                                siiReporteVentas = new SiiReporteVentas();
                                siiReporteVentas.setRveFecha(primerCargueVentas.getMovCarVentFechaSolicitud());
                                siiReporteVentas.setRveMovimiento(movSolicitud);
                                siiReporteVentas.setRveNumRegistros(numRegistros);
                                siiReporteVentas.setRveTipoReporte(tipoReporte);
                                siiReporteVentas.setRveValorTotVentas(new BigDecimal(totalVentas));
                                siiReporteVentas.setRveVigencia(vigencia);
                                siiReporteVentas.setSiiMes(siiMes);
                                siiReporteVentas.setSiiContrato(siiContrato);
                                reporteVentasDao.insertar(siiReporteVentas);
                                System.out.println("Insertando reporte " + ++reportesCargados + ". venta MET " + ventasLeidas);
                                
                                //Registro de las MET presentes en el inventario
                                Calendar rangoInicialLiquidar = Calendar.getInstance();
                                Calendar rangoFinalLiquidar = Calendar.getInstance();
                                rangoFinalLiquidar.set(vigencia, mesActual, 1);
                                rangoFinalLiquidar.set(Calendar.HOUR,23);
                                rangoFinalLiquidar.set(Calendar.MINUTE,59);
                                rangoFinalLiquidar.set(Calendar.SECOND,59);
                                rangoFinalLiquidar = (Calendar)rangoInicialLiquidar.clone();
                                rangoFinalLiquidar.add(Calendar.MONTH, -1);

                                //Consultamos el inventario del contrato e insertamos las máquinas online
                                List<OficioLiquidacionPrevioVO> listaOficioLiquidacion = liquidacionMesDao.buscarInventarioPorContratoYRangoOperacion(siiContrato.getConCodigo(), sdf.format(rangoInicialLiquidar.getTime()), sdf.format(rangoFinalLiquidar.getTime()),
                                                                            EnumTipoNovedad.RETIRO_ELEMENTOS.getId(), vigencia);

                                if(listaOficioLiquidacion != null && listaOficioLiquidacion.size() > 0){
                                    for(OficioLiquidacionPrevioVO oficioLiquidacionPrevioVo : listaOficioLiquidacion){
                                        if(oficioLiquidacionPrevioVo.getIdMet() != null && oficioLiquidacionPrevioVo.getNuc() != null && "S".equals(oficioLiquidacionPrevioVo.getIndicadorOnLine())){
                                            //Insertamos el registro de venta met con valor 0
                                            SiiVentasMet siiVentasMet = new SiiVentasMet();
                                            siiVentasMet.setSiiContrato(siiContrato);
                                            siiVentasMet.setVmeVigencia(vigencia);
                                            siiVentasMet.setSiiMes(siiMes);
                                            siiVentasMet.setVmeValorInicial(BigDecimal.ZERO);
                                            siiVentasMet.setSiiReporteVentas(siiReporteVentas);
                                            SiiMet siiMet = metDao.buscarPorCodigoMet(oficioLiquidacionPrevioVo.getIdMet());
                                            siiVentasMet.setSiiMet(siiMet);
                                            ventasMetDao.insertarSiiVentasMet(siiVentasMet);
                                            ventasCargadasPorInventario++;
                                        }
                                    }
                                }

                                contratoAnterior = siitoMovCargueVenta.getMovCarVentContrato();
                                nitAnterior = siitoMovCargueVenta.getMovCarVentNit();
                            }
                            
                            if(siiContrato == null) {
                                ventasNoCargadas++;
                                continue;
                            }
                            
                            //Buscamos la venta previamente insertada
                            SiiVentasMet siiVentasMetActual = ventasMetDao.buscarVentasMetPorVigenciaMesNuc(vigencia, siiMes.getMesCodigo(), siitoMovCargueVenta.getMovCarVentNuc().toString(), siiReporteVentas.getRveCodigo());
                            if(siiVentasMetActual != null){
                                //Solo actualiza el valor y NUID
                                siiVentasMetActual.setVmeValorInicial(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));
                                if(siitoMovCargueVenta.getMovCarVentNuid() != null && !siitoMovCargueVenta.getMovCarVentNuid().equals(siiVentasMetActual.getSiiMet().getMetUid())) {
                                    siiVentasMetActual.getSiiMet().setMetNuid(siitoMovCargueVenta.getMovCarVentNuid().toString());
                                    metDao.actualizarSiiMet(siiVentasMetActual.getSiiMet());
                                }
                                ventasMetDao.actualizar(siiVentasMetActual);
                                ventasCargadas++;
                                continue;
                            }
                            
                            //Si no se encontró, se agrega (probablemente en el inventario no estaba marcada como OnLine)
                            SiiVentasMet siiVentasMet = new SiiVentasMet();
                            siiVentasMet.setSiiContrato(siiContrato);
                            siiVentasMet.setVmeVigencia(vigencia);
                            siiVentasMet.setSiiMes(siiMes);
                            siiVentasMet.setVmeValorInicial(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));
                            siiVentasMet.setSiiReporteVentas(siiReporteVentas);

                            SiiMet siiMet = metDao.buscarMetPorNuc(siitoMovCargueVenta.getMovCarVentNuc().toString());
                            if(siiMet == null) {
                                System.out.println("No se encontró el NUC: " + siitoMovCargueVenta.getMovCarVentNuc());
                                ventasNoCargadas++;
                                continue;
                            }
                            if(!"S".equals(siiMet.getMetOnline())) {
                                siiMet.setMetOnline("S");
                                siiMet.setMetFechaMarcOnline(new Date());
                                metDao.actualizarSiiMet(siiMet);
                            }
                            if(siitoMovCargueVenta.getMovCarVentNuid() != null && !siitoMovCargueVenta.getMovCarVentNuid().equals(siiMet.getMetNuid())) {
                                siiMet.setMetNuid(siitoMovCargueVenta.getMovCarVentNuid().toString());
                                metDao.actualizarSiiMet(siiMet);
                            }
                            siiVentasMet.setSiiMet(siiMet);
                            siiVentasMet.setVmeDiasRepor(siitoMovCargueVenta.getMovCarVentCantDiasReportados());

                            ventasMetDao.insertarSiiVentasMet(siiVentasMet);
                            ventasCargadas++;
                        }
                        
                        System.out.println("Ventas leidas: " + ventasLeidas);
                        System.out.println("Ventas cargadas por inventario online: " + ventasCargadasPorInventario);
                        System.out.println("Ventas cargadas: " + ventasCargadas);
                        System.out.println("Ventas no cargadas: " + ventasNoCargadas);
                        System.out.println("Contratos cargados: " + contratosCargados);
                        System.out.println("Contratos no cargados: " + contratosNoCargados);
                        System.out.println("Reportes cargados: " + reportesCargados);
                        //Ejecutamos la liquidación mensual
                        //adminLiquidacionMes.ejecutarLiquidacionMensualOperadores("P", vigencia, siiMes.getMesCodigo(), null, null);
                    }
                    retorno = strFechaVenta;
                }
                
                else if("M".equals(letraTipoReporte)){
                    //Buscamos el contrato
                    SiiContrato siiContrato = contratoDao.buscarContratoPorNumeroPorNit(primerCargueVentas.getMovCarVentNit(), primerCargueVentas.getMovCarVentContrato());
                    
                    if(siiContrato == null){
                        throw new ExcepcionAplicacion("El contrato " + primerCargueVentas.getMovCarVentContrato() + " no existe o no se encuentra vigente");
                    }
                    
                    //Creamos el registro de reporte_ventas
                    SiiReporteVentas siiReporteVentas = new SiiReporteVentas();
                    siiReporteVentas.setRveFecha(primerCargueVentas.getMovCarVentFechaSolicitud());
                    siiReporteVentas.setRveMovimiento(movSolicitud);
                    siiReporteVentas.setRveNumRegistros(numRegistros);
                    siiReporteVentas.setRveTipoReporte(tipoReporte);
                    siiReporteVentas.setRveValorTotVentas(new BigDecimal(totalVentas));
                    siiReporteVentas.setRveVigencia(vigencia);
                    siiReporteVentas.setSiiMes(siiMes);
                    siiReporteVentas.setSiiContrato(siiContrato);
                    reporteVentasDao.insertar(siiReporteVentas);
                    
                                      
                    //Buscamos el reporte ventas para la vigencia, mes, contrato y nit
                    SiiReporteVentas siiReporteVentasPrimero = reporteVentasDao.buscarReporteVentasPorVigenciaMesContratoNitTipo(vigencia,siiMes.getMesCodigo(),listaSiitoMovCargueVentas.get(0).getMovCarVentContrato(),listaSiitoMovCargueVentas.get(0).getMovCarVentNit(),"P");
                    
                    if(siiReporteVentasPrimero == null){
                        throw new ExcepcionAplicacion("No se encontró el reporte de ventas P para vigencia: " + vigencia + " - mes: " + siiMes.getMesCodigo() + " - contrato: " + listaSiitoMovCargueVentas.get(0).getMovCarVentContrato() + " - nit: " + listaSiitoMovCargueVentas.get(0).getMovCarVentNit());
                    }
                    
                                       
                    //Buscamos todos los registros de ventas para el contrato, vigencia y mes que se está modificando
                    List<SiiVentasMet> listaSiiVentasMetActualizar = ventasMetDao.buscarVentasMetPorReporteVentas(siiReporteVentasPrimero.getRveCodigo());
                    if(listaSiiVentasMetActualizar != null && !listaSiiVentasMetActualizar.isEmpty()){
                        for(SiiVentasMet siiVentasMetActualizar : listaSiiVentasMetActualizar){    
                            
                                siiVentasMetActualizar.setVmeValorModif(siiVentasMetActualizar.getVmeValorInicial());                            
                                ventasMetDao.actualizar(siiVentasMetActualizar);
                            
                        }
                    }
                    
                    
                    for (SiitoMovCargueVentas siitoMovCargueVenta : listaSiitoMovCargueVentas) {
                        SiiVentasMet siiVentasMet = new SiiVentasMet();
                        //Buscamos el registro de ventas met por met, vigencia y mes
                        siiVentasMet = ventasMetDao.buscarVentasMetPorVigenciaMesNuc(vigencia, siiMes.getMesCodigo(), siitoMovCargueVenta.getMovCarVentNuc().toString(), siiReporteVentasPrimero.getRveCodigo());
                        
                         
                        if (siiVentasMet != null){
                            //Actualizamos los valores de la venta   
                            siiVentasMet.setVmeValorModif(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));
                            ventasMetDao.actualizar(siiVentasMet);
                       
                            //Creamos un nuevo registro en modificacion ventas met
                            SiiModificaVentasMet siiModificaVentasMet = new SiiModificaVentasMet();
                            siiModificaVentasMet.setMvmFecha(new Date()/* siiReporteVentas.getRveFecha() */);
                            siiModificaVentasMet.setMvmValorVentas(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));
                            siiModificaVentasMet.setSiiReporteVentas(siiReporteVentas);
                            siiModificaVentasMet.setSiiVentasMet(siiVentasMet);
                            siiModificaVentasMet.setMvmLiqEfectiva(BigDecimal.ZERO) ;
                            siiModificaVentasMet.setMvmLiqTarifaFija(BigDecimal.ZERO);
                            siiModificaVentasMet.setMvmLiqTarifaVar(BigDecimal.ZERO); 
                            modificaVentasMetDao.insertar(siiModificaVentasMet);
                        }
                        
                    }
                    //Ejecutamos la liquidación M
                    retorno = adminLiquidacionMes.ejecutarLiquidacionMensualOperadores("M", vigencia, siiMes.getMesCodigo(), listaSiitoMovCargueVentas.get(0).getMovCarVentContrato(),listaSiitoMovCargueVentas.get(0).getMovCarVentNit());                    
                    retorno = "" + movSolicitud;
                }
                
                else if("Q".equals(letraTipoReporte)){
                    //Buscamos el contrato
                    SiiContrato siiContrato = contratoDao.buscarContratoPorNumeroPorNit(primerCargueVentas.getMovCarVentNit(), primerCargueVentas.getMovCarVentContrato());
                    if(siiContrato == null){
                        throw new ExcepcionAplicacion("El contrato " + primerCargueVentas.getMovCarVentContrato() + " no existe o no se encuentra vigente");
                    }
                    
                    //Creamos el registro de reporte_ventas
                    SiiReporteVentas siiReporteVentas = new SiiReporteVentas();
                    siiReporteVentas.setRveFecha(primerCargueVentas.getMovCarVentFechaSolicitud());
                    siiReporteVentas.setRveMovimiento(movSolicitud);
                    siiReporteVentas.setRveNumRegistros(numRegistros);
                    siiReporteVentas.setRveTipoReporte(tipoReporte);
                    siiReporteVentas.setRveValorTotVentas(new BigDecimal(totalVentas));
                    siiReporteVentas.setRveVigencia(vigencia);
                    siiReporteVentas.setSiiMes(siiMes);
                    siiReporteVentas.setSiiContrato(siiContrato);
                    reporteVentasDao.insertar(siiReporteVentas);                    
                    
                    //Buscamos el reporte ventas para la vigencia, mes, contrato y nit
                    SiiReporteVentas siiReporteVentasPrimero = reporteVentasDao.buscarReporteVentasPorVigenciaMesContratoNitTipo(vigencia,siiMes.getMesCodigo(),listaSiitoMovCargueVentas.get(0).getMovCarVentContrato(),listaSiitoMovCargueVentas.get(0).getMovCarVentNit(),"P");
                    if(siiReporteVentasPrimero == null){
                        throw new ExcepcionAplicacion("No se encontró el reporte de ventas P para vigencia: " + vigencia + " - mes: " + siiMes.getMesCodigo() + " - contrato: " + listaSiitoMovCargueVentas.get(0).getMovCarVentContrato() + " - nit: " + listaSiitoMovCargueVentas.get(0).getMovCarVentNit());
                    }
                    
                    //Buscamos todos los registros de ventas para el contrato, vigencia y mes que se está modificando
                    List<SiiVentasMet> listaSiiVentasMetActualizar = ventasMetDao.buscarVentasMetPorReporteVentas(siiReporteVentasPrimero.getRveCodigo());
                    if(listaSiiVentasMetActualizar != null && !listaSiiVentasMetActualizar.isEmpty()){
                        for(SiiVentasMet siiVentasMetActualizar : listaSiiVentasMetActualizar){
                            siiVentasMetActualizar.setVmeValorConsulta(siiVentasMetActualizar.getVmeValorInicial());                                                               
                            ventasMetDao.actualizar(siiVentasMetActualizar);
                            
                        }
                    }
                    
                    for (SiitoMovCargueVentas siitoMovCargueVenta : listaSiitoMovCargueVentas) {
                        SiiVentasMet siiVentasMet = new SiiVentasMet();
                        //Buscamos el registro de ventas met por met, vigencia y mes
                        siiVentasMet = ventasMetDao.buscarVentasMetPorVigenciaMesNuc(vigencia, siiMes.getMesCodigo(), siitoMovCargueVenta.getMovCarVentNuc().toString(), siiReporteVentasPrimero.getRveCodigo());
                        if (siiVentasMet != null){
                            //Actualizamos los valores de la venta
                            
                            siiVentasMet.setVmeValorConsulta(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));                        
                            ventasMetDao.actualizar(siiVentasMet);
                            
                            //Creamos un nuevo registro en modificacion ventas met
                             SiiModificaVentasMet siiModificaVentasMet = new SiiModificaVentasMet();
                             siiModificaVentasMet.setMvmFecha(new Date()/* siiReporteVentas.getRveFecha() */);
                             siiModificaVentasMet.setMvmValorVentas(new BigDecimal(siitoMovCargueVenta.getMovCarVentValorTotalVentas()));                        
                             siiModificaVentasMet.setSiiReporteVentas(siiReporteVentas);
                             siiModificaVentasMet.setSiiVentasMet(siiVentasMet);  
                             siiModificaVentasMet.setMvmLiqEfectiva(BigDecimal.ZERO) ;
                             siiModificaVentasMet.setMvmLiqTarifaFija(BigDecimal.ZERO);
                             siiModificaVentasMet.setMvmLiqTarifaVar(BigDecimal.ZERO); 
                             modificaVentasMetDao.insertar(siiModificaVentasMet);
                        }
                                           
                    }
                    
                    
                    //Ejecutamos la liquidación Q
                    retorno = adminLiquidacionMes.ejecutarLiquidacionMensualOperadores("Q", vigencia, siiMes.getMesCodigo(), listaSiitoMovCargueVentas.get(0).getMovCarVentContrato(),listaSiitoMovCargueVentas.get(0).getMovCarVentNit());                    
                    //throw new ExcepcionAplicacion("Your mother in ball");
                    
                }
            }
        } catch(ExcepcionDAO ex){
            throw ex;
        } catch(ExcepcionAplicacion ex){
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }
        return retorno;
    }

}
