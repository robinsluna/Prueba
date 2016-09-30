package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoConsultaInvSiicol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueInventario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaInventarioWSVO;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.enterprise.inject.New;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
//@Stateful
@LocalBean
public class SiitoConsultaInvSiicolDAO {

    @PersistenceContext(unitName = "siitoPU") //, type = PersistenceContextType.EXTENDED)
    private EntityManager manager;
    private Recursos recursos;


    /**
     * Permite insertar los elementos del inventario en las tabla SIITO_CONSULTA_INV_SIICOL de SIITO
     * @param inventario
     * @return mensaje de exito con la cantidad de registros o mensaje de error
     * @throws ExcepcionDAO
     */
    public String insertarInventarioTablaIntermediaConsultaSiito(List<ConsultaInventarioWSVO> inventario,
                                                                 String acure) throws ExcepcionDAO {
        String mensaje = "";

        try {
            /********************************************************
             * Borramos el inventario anterior de ese contrato
             ********************************************************/
            try {
                if (!inventario.isEmpty() && inventario.size() > 0) {
                    StringBuilder sql = new StringBuilder();
                    if (inventario.get(0).tipoSolicitud == 100L) {
                        sql.append("DELETE FROM SiitoConsultaInvSiicol inv WHERE inv.movCargueInvTipSolCodigo = :tiposol");
                    } else if (inventario.get(0).tipoSolicitud == 101L) {
                        sql.append("DELETE FROM SiitoMovCargueInventario inv WHERE inv.codAcure = :acure");
                    }
                    Query consulta = manager.createQuery(sql.toString());
                    if (inventario.get(0).tipoSolicitud == 100L) {
                        consulta.setParameter("tiposol", 100L);
                    } else if (inventario.get(0).tipoSolicitud == 101L) {
                        consulta.setParameter("acure", acure);
                    }

                    consulta.executeUpdate();
                }
            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "SiitoConsultaInvSiicolDAO");
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }

            /********************************************************
             * Insertamos el nuevo inventario de ese contrato
             ********************************************************/
            if (!inventario.isEmpty()) {
                for (ConsultaInventarioWSVO elemento : inventario) {                    

                    SiitoMovCargueInventario entidad = new SiitoMovCargueInventario();
                    entidad.setCodAcure(acure);
                    entidad.setMovCargueInvAnoFab(elemento.annoFabricacion);
                    entidad.setMovCargueInvCantSillas(elemento.cantidadSillas);
                    entidad.setMovCargueInvCantTerm(elemento.cantTerminalesLicencia);
                    entidad.setMovCargueInvCodApuesta(elemento.codApuesta);
                    entidad.setMovCargueInvCodLocal(elemento.codigoLocal);
                    entidad.setMovCargueInvCodMarca(Integer.valueOf(elemento.codigoMarca.equals("") ? "0" :
                                                                    elemento.codigoMarca));
                    entidad.setMovCargueInvCodModelo(elemento.modelo);
                    entidad.setMovCargueInvCont(elemento.contratoOperador);
                    entidad.setMovCargueInvDirDesc(elemento.direccion);
                    //entidad.setMovCargueInvEstElem(elemento.getEstadoElemento());
                    entidad.setMovCargueInvEstUbiInst(elemento.estadoUbicacionElemento);
                    //entidad.setMovCargueInvFecFinele(new Timestamp(elemento.getFechaFinElemento().getTime()));
                    //entidad.setMovCargueInvFecInicioele(new Timestamp(elemento.getFechaInicioElemento().getTime()));
                    entidad.setMovCargueInvFechSol(new Timestamp(System.currentTimeMillis()));
                    entidad.setMovCargueInvIndInstHomo(elemento.indicadorMetHomo.equalsIgnoreCase("N") ? 0l : 1l);
                    entidad.setMovCargueInvIndInstSclmIn(0l); //******************
                    entidad.setMovCargueInvIucAd(Long.valueOf(elemento.nuc == null ? "0" :
                                                              elemento.nuc.equals("") ? "0" : elemento.nuc));
                    entidad.setMovCargueInvLatEstableci(elemento.latitud + "");
                    entidad.setMovCargueInvLonEstableci(elemento.longitud + "");
                    entidad.setMovCargueInvModJuego(elemento.modalidadJuego);
                    entidad.setMovCargueInvModLic(elemento.modalidadLicencia + "");
                    entidad.setMovCargueInvNit(elemento.nitOperador);
                    entidad.setMovCargueInvNomLocal(elemento.nombreLocal);
                    entidad.setMovCargueInvNuidAd(elemento.nuid);
                    entidad.setMovCargueInvNumFab(elemento.numRegistroFabMET);
                    entidad.setMovCargueInvNumFabSclm(elemento.annoFabricacion); //**********************
                    entidad.setMovCargueInvNumLic(elemento.numLicencia);
                    entidad.setMovCargueInvSerialInstAd(elemento.serial);
                    entidad.setMovCargueInvTenLegal(elemento.tenenciaLegal);
                    entidad.setMovCargueInvTipInst(elemento.tipoElemento + "");
                    entidad.setMovCargueInvTipJuegos(elemento.tipoJuego + "");
                    entidad.setMovCargueInvTipSolCodigo(elemento.tipoSolicitud);
                    entidad.setMovCargueInvVlrCarton(elemento.valorCarton);
                    //entidad.set
                    entidad.setMovSolSiito(elemento.numeroSolicitud);
                    entidad.setMovSolCodigo(Long.parseLong(elemento.numeroSolicitud));

                    manager.persist(entidad);

                    manager.flush();
                }
            }
            mensaje = inventario.size() + "";
        } catch (PersistenceException e) {
            mensaje =
                "Error al persistir la información -- " + recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensaje + " : " + e.getMessage(), "SiitoConsultaInvSiicolDAO");
        }
        return mensaje;
    }

    public boolean borrarInventarioSiicolASincronizar() throws Exception,ExcepcionDAO {
        try {
            /********************************************************
             * Borramos el inventario anterior de ese contrato
             ********************************************************/
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM Siito_Consulta_Inv_Siicol;");
            //sql.append("DBCC CHECKIDENT (Siito_Consulta_Inv_Siicol, RESEED,0);");
            Query consulta = manager.createNativeQuery(sql.toString());
            consulta.executeUpdate();
            return true;
        } finally {
            manager.clear();
        }
    }


    public boolean insertarSiitoConsultaInvSiicol(SiitoConsultaInvSiicol entidad) throws ExcepcionDAO {
        String mensaje = "";

        try { /********************************************************
             * Insertamos el nuevo SiitoConsultaInvSiicol
             ********************************************************/
            manager.persist(entidad);
            manager.flush();
            return true;
        } finally {
            manager.clear();
        }
    }

    public boolean insertarSiitoConsultaInvSiicol(List<SiiInventario> inventarios) throws Exception,ExcepcionDAO {


        try { /********************************************************
                 * Insertamos el nuevo SiitoConsultaInvSiicol
                 ********************************************************/
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            for (SiiInventario elemento : inventarios) {
                //System.out.println("codinv:"+elemento.getInvCodigo());
                SiitoConsultaInvSiicol entidad = new SiitoConsultaInvSiicol();
                entidad.setMovSolSiito(null);
                entidad.setMovCargueInvModJuego(null);
                entidad.setMovCargueInvTipSolCodigo(100L);
                entidad.setMovCargueInvFechSol(timestamp);
                //Long cargueInvNit =
                entidad.setMovCargueInvNit(elemento.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion());
                entidad.setMovCargueInvCont(elemento.getSiiNovedad().getSiiContrato().getConNumero());
                entidad.setMovCargueInvCodLocal(elemento.getSiiEstablecimiento().getEstCodInterno());
                entidad.setMovCargueInvNomLocal(elemento.getSiiEstablecimiento().getEstNombre());
                entidad.setMovCargueInvDirDesc(elemento.getSiiEstablecimiento().getEstDireccion());
                Long tipoElemento=elemento.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo();
                entidad.setMovCargueInvTipInst(tipoElemento.toString());
                Long codApuesta=elemento.getSiiTipoApuesta()!=null?Long.parseLong(elemento.getSiiTipoApuesta().getTapCodigoApuesta()):0L;
                entidad.setMovCargueInvCodApuesta(codApuesta);                
                if (tipoElemento == 1L || tipoElemento==5L) {
                    entidad.setMovCargueInvTipJuegos("0"); //12
                } else if (tipoElemento == 2L){
                    if(codApuesta==6L || codApuesta==7L || codApuesta==8L || codApuesta==9L || codApuesta==10L){
                        entidad.setMovCargueInvTipJuegos("13");
                    }else if(codApuesta==13L || codApuesta==14L || codApuesta==15L){
                        entidad.setMovCargueInvTipJuegos("12");
                    }else if(codApuesta==12L || codApuesta==11L){ //tipo de apuestas que no estan resolucion.
                        entidad.setMovCargueInvTipJuegos("12");
                    }
                } else if (tipoElemento == 3L) {
                    String TipojuegoMesa=elemento.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa()!=null?elemento.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString():null;
                    entidad.setMovCargueInvTipJuegos(TipojuegoMesa); //12
                } else if (tipoElemento == 4L) {
                    //String TipojuegoOtro=elemento.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa()!=null?elemento.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString():null;
                    entidad.setMovCargueInvTipJuegos("10");//Esferodromo
                }else{
                    entidad.setMovCargueInvTipJuegos(null);
                }
                //entidad.setMovCargueInvTipJuegos(elemento.getSiiTipoApuesta().getSiiTipoJuego().getTjuCodigo().toString());
                entidad.setMovCargueInvIucAd(elemento.getSiiInstrumento().getSiiMet() != null ?
                                             (elemento.getSiiInstrumento().getSiiMet().getMetUid() != null ?
                                              Long.parseLong(elemento.getSiiInstrumento().getSiiMet().getMetUid()) :
                                              null) : null);
                entidad.setMovCargueInvNuidAd(elemento.getSiiInstrumento().getSiiMet() != null ?
                                              elemento.getSiiInstrumento().getSiiMet().getMetNuid() : null);
                entidad.setMovCargueInvSerialInstAd(elemento.getSiiInstrumento().getSiiMet() != null ?
                                                    elemento.getSiiInstrumento().getSiiMet().getMetSerial() : null);
                entidad.setMovCargueInvCodMarca(elemento.getSiiInstrumento().getSiiMet() != null ?
                                                elemento.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo().intValue() :
                                                null);
                entidad.setMovCargueInvCodModelo(elemento.getSiiInstrumento().getSiiMet() != null ?
                                                 elemento.getSiiInstrumento().getSiiMet().getMetModelo() : null);

                Calendar cal = Calendar.getInstance();
                Long anoFab = null;
                if (elemento.getSiiInstrumento().getSiiMet() != null &&
                    elemento.getSiiInstrumento().getSiiMet().getMetFechaFab() != null) {
                    cal.setTime(elemento.getSiiInstrumento().getSiiMet().getMetFechaFab());
                    anoFab = (long) cal.get(Calendar.YEAR);
                }
                entidad.setMovCargueInvAnoFab(anoFab);
                entidad.setMovCargueInvNumFabSclm(0L);
                entidad.setMovCargueInvIndInstSclmIn(elemento.getSiiInstrumento().getSiiMet() != null ?
                                                     (elemento.getSiiInstrumento().getSiiMet().getMetOnline().equalsIgnoreCase("S") ?
                                                      1L : 0L) : null);
                entidad.setMovCargueInvNumFab(null);
                entidad.setMovCargueInvIndInstHomo(elemento.getSiiInstrumento().getSiiMet() != null ?
                                                   (elemento.getSiiInstrumento().getSiiMet().getMetHomologado().equalsIgnoreCase("S") ?
                                                    1L : 0L) : null);
                
                entidad.setMovCargueInvCantSillas(elemento.getInvSillas() != null ?
                                                  elemento.getInvSillas().longValue() : null);
                entidad.setMovCargueInvVlrCarton(null);
                entidad.setMovCargueInvEstUbiInst(Long.parseLong(elemento.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo()));
                entidad.setMovCargueInvLatEstableci(null);
                entidad.setMovCargueInvLonEstableci(null);
                entidad.setMovCargueInvTenLegal(null);
                entidad.setMovCargueInvDirBarrio(null);
                entidad.setMovCargueInvNumLic(null);
                entidad.setMovCargueInvModLic(null);
                entidad.setMovCargueInvCantTerm(0L);
                entidad.setMovCargueInvEstElem(elemento.getInvEstado());


                entidad.setMovCargueInvFecInicioele(new Timestamp(elemento.getSiiNovedad().getSiiContrato().getConFechaIni().getTime()));
                entidad.setMovCargueInvFecFinele(new Timestamp(elemento.getSiiNovedad().getSiiContrato().getConFechaFinDefin()!=null?elemento.getSiiNovedad().getSiiContrato().getConFechaFinDefin().getTime():elemento.getSiiNovedad().getSiiContrato().getConFechaFin().getTime()));

                entidad.setMovCargueInvFechIniLiq(new Timestamp(elemento.getInvFechaIniLiq().getTime()));
                entidad.setMovCargueInvFechFinLiq(new Timestamp(elemento.getInvFechaFinLiq().getTime()));

                //System.out.println("codinv:"+elemento.getInvCodigo());
                manager.persist(entidad);
                manager.flush();


            }
            return true;
        } finally {
            manager.clear();            
        }
    }

}
