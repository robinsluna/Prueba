/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 19-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioWebVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionDemasJuegosAutorizadosVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionMesasCasinoAutorizadasVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionMetAutorizadaVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionSillasBingoAutorizadasVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ValorMensualPorApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.ConsultaInventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.establecimientos.DetalleEstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.BingoConsultaVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.ConsultaInventarioNitVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.MesaConsultaVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.MetConsultaVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.OperadorConsultaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoUbicacionWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.UbicacionWSVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SolicitudAutorizaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public SolicitudAutorizaDAO() {
        recursos = new Recursos();
    }

    public SiiSolicitudAutoriza buscarSolicitudAutorizacionPorCodigo(Long idCodigoSolicitudAutorizacion) throws ExcepcionDAO {
        SiiSolicitudAutoriza retorno = null;
        try {
            retorno = manager.find(SiiSolicitudAutoriza.class, idCodigoSolicitudAutorizacion);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;

    }

    public SiiSolicitudAutoriza insertarSiiSolicitudAutoriza(SiiSolicitudAutoriza solicitaAutorizacion) throws ExcepcionDAO {
        try {
            manager.persist(solicitaAutorizacion);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return solicitaAutorizacion;
    }

    public SiiSolicitudAutoriza actualizarSiiSolicitudAutoriza(SiiSolicitudAutoriza solicitaAutorizacion) throws ExcepcionDAO {
        try {
            manager.merge(solicitaAutorizacion);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return solicitaAutorizacion;
    }

    public void borrarSiiSolicitudAutoriza(Long idCodigoSolicitudAutoriza) throws ExcepcionDAO {
        SiiSolicitudAutoriza solicitudAutoriza = null;
        try {
            solicitudAutoriza = manager.find(SiiSolicitudAutoriza.class, idCodigoSolicitudAutoriza);
            manager.remove(solicitudAutoriza);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    public List<SiiSolicitudAutoriza> buscarTodoSiiSolicitudAutoriza() throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiSolicitudAutoriza o");
            Query query = manager.createQuery(sql.toString());
            listaSolAutoriza = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    //Por Gatopardo:
    //Buscar solicitudes en proceso
    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionPorNit(String nit) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau where sau.sauNit = :nit " +
                "and sau.siiEstadoSolicAutoriz.esaCodigo in (1,2,3,4,8,9,10,11,13,14) " +
                "and sau.siiTipoSolicAutoriza.tsaCodigo in (10,20,30,80,90)" +
                " UNION ALL " +
                " SELECT sau FROM SiiSolicitudAutoriza sau where sau.sauNit = :nit " + 
                " and sau.siiEstadoSolicAutoriz.esaCodigo in (6) " + 
                " and sau.siiTipoSolicAutoriza.tsaCodigo not in (30)");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nit", nit);
            listaSolAutoriza = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<ConsultaInventarioVO> consultarInventario(SolicitudAutorizaWSVO sol) throws ExcepcionDAO {

        List<ConsultaInventarioVO> retorno = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT  ");
            sql.append("sol.sau_codigo as uno,sol.sau_numero_siito as dos, clase.cju_codigo as tres, ");
            sql.append("perso.per_num_identificacion as cuatro, ");
            sql.append("contra.con_numero as cinco, perso.per_jur_nombre_largo as seis, perso.per_direccion as siete, perso.per_telefono as ocho, ");
            sql.append("perso.per_email as nueve,  ");
            sql.append("est.est_codigo as diez, '' as once, ubi.ubi_nombre as doce,est.est_nombre as trece, est.est_direccion as catorce, ");
            sql.append("est.ubi_codigo as quince, inst.ins_codigo as dieciseis,tipoj.tju_codigo as diecisiete, ");
            sql.append("met.met_codigo as dieciocho, met.met_nuid as diecinueve,met.met_serial as veinte, marca.mar_codigo as veintiuno, ");
            sql.append("met.mar_codigo as veintidos, met.met_modelo as veintitres, met.met_fecha_fab as veinticuatro,'','', ");
            sql.append("case when met.met_homologado = 'S' then 1 else 0 end as veintisiete, tipoa.tap_codigo as ventiocho ,inv.inv_sillas AS ventinueve,'',1,'','',1,1");
            sql.append(" FROM ");
            sql.append("SII_ESTABLECIMIENTO est,SII_INVENTARIO inv, ");
            sql.append("SII_UBICACION ubi,SII_TIPO_APUESTA tipoa, ");
            sql.append("SII_CLASE_JUEGO clase,SII_TIPO_JUEGO tipoj, ");
            sql.append("SII_NOVEDAD nove,SII_SOLICITUD_AUTORIZA sol, ");
            sql.append("SII_CONTRATO contra,SII_INSTRUMENTO inst, ");
            sql.append("SII_MET met, SII_OPERADOR ope, SII_PERSONA perso, SII_MARCA marca ");
            sql.append("WHERE ");
            sql.append("est.ubi_codigo = ubi.ubi_codigo ");
            sql.append("AND inv.est_codigo = est.est_codigo ");
            //sql.append("AND inv.inv_estado = 'A' ");
            sql.append("AND tipoa.tap_codigo = inv.tap_codigo ");
            sql.append("AND clase.cju_codigo = tipoa.cju_codigo ");
            sql.append("AND tipoj.tju_codigo = tipoa.tju_codigo ");
            sql.append("AND nove.nov_codigo = inv.nov_codigo ");
            sql.append("AND nove.sau_codigo = sol.sau_codigo ");
            sql.append("AND contra.con_codigo = nove.con_codigo ");
            sql.append("AND inst.ins_codigo = inv.ins_codigo ");
            sql.append("AND met.met_codigo = inst.met_codigo ");
            sql.append("AND met.mar_codigo = marca.mar_codigo ");
            sql.append("AND ope.ope_codigo = inst.ope_codigo ");
            sql.append("AND ope.ope_codigo = est.ope_codigo ");
            sql.append("AND ope.per_codigo = perso.per_codigo ");
            sql.append("AND contra.con_fecha_fin > sysdate ");

            if(sol.nit != null && !sol.nit.equals("")) {
                sql.append("AND perso.per_num_identificacion = #Nit ");
            }
            if(sol.numeroContrato != null && !sol.numeroContrato.equals("")) {
                sql.append("AND contra.con_numero = #Contrato ");
            }
            Query query = manager.createNativeQuery(sql.toString());
            if(sol.nit != null && !sol.nit.equals("")) {
                query.setParameter("Nit", sol.nit);
            }
            if(sol.numeroContrato != null && !sol.numeroContrato.equals("")) {
                query.setParameter("Contrato", sol.numeroContrato);
            }
            List<Object[]> results = query.getResultList();


            for(Object[] object : results) {
                ConsultaInventarioVO elemento = new ConsultaInventarioVO();

                elemento.numMovimiento = (BigDecimal) object[0];
                elemento.numSolicitudSiito = (String) object[1];
                elemento.modalidadJuego = (BigDecimal) object[2];

                elemento.nitOperador = (String) object[3];
                elemento.contratoOperador = (String) object[4];
                elemento.razonSocial = (String) object[5];
                elemento.direccion = (String) object[6];
                elemento.telefono = (String) object[7];
                elemento.email = (String) object[8];
                elemento.municipioDane = (BigDecimal) object[9] + "";
                elemento.email2 = (String) object[10];
                elemento.codigoLocal = (String) object[11];
                elemento.nombreLocal = (String) object[12];
                elemento.direccionLocal = (String) object[13];
                elemento.codigoMunicipioLocal = (String) object[14];
                elemento.tipoElemento = (BigDecimal) object[15];

                elemento.tipoJuego = (BigDecimal) object[16];
                elemento.idColjuegosMet = (BigDecimal) object[17];
                elemento.idUnicaDigitalNUID = (String) object[18];
                elemento.serialMET = (String) object[19];
                elemento.numeroRegFabrcanteMET = (BigDecimal) object[20];

                elemento.codMarca = (BigDecimal) object[21];
                //elemento.setCodModelo=(BigDecimal)object[22];
                //elemento.setAnoFrabicacion=(Date)object[23];
                elemento.registroFabricante = (BigDecimal) object[24];
                elemento.indicadorConexionLinea = (BigDecimal) object[25];
                elemento.indicadorMETHomologada = (BigDecimal) object[26];

                elemento.codigoApuesta = (BigDecimal) object[27];
                elemento.cantidadSillas = (BigDecimal) object[28];
                //elemento.setValorCarton=(Long)object[29];
                elemento.estadoUbicacionInstrumento = (BigDecimal) object[30];
                elemento.latitudEstablecimiento = (String) object[31];
                elemento.longitudEstablecimiento = (String) object[32];
                elemento.estadoDireccion = (BigDecimal) object[33];
                elemento.estadoSerial = (BigDecimal) object[34];

                retorno.add(elemento);
            }

            return retorno;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public ConsultaInventarioNitVO consultarInventarioNit(String nit) throws ExcepcionDAO {
        ConsultaInventarioNitVO retorno = new ConsultaInventarioNitVO();

        if(nit != null && !nit.equals("")) {
            List<OperadorConsultaVO> operadores = this.consultarOperadoresNit(nit);
            retorno.operadores = operadores;
            List<MetConsultaVO> met = this.consultarMetNit(nit);
            retorno.met = met;
            List<BingoConsultaVO> bingos = this.consultarBingosNit(nit);
            retorno.bingos = bingos;
            List<MesaConsultaVO> mesas = this.consultarMesasNit(nit);
            retorno.mesas = mesas;
        }

        return retorno;
    }

    public List<OperadorConsultaVO> consultarOperadoresNit(String nit) throws ExcepcionDAO {
        List<OperadorConsultaVO> listaOperadores = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT  ");
            sql.append("contra.con_numero as contrato,perso.per_jur_nombre_largo as razonSocial,perso.per_direccion as direccion, ");
            sql.append("(select ub.ubi_nombre from SII_UBICACION ub where ubica.ubi_codigo_padre = ub.ubi_codigo) as ciudad, ");
            sql.append("perso.per_telefono as telefono, perso.per_email as email, ope.ope_tipo_poblac as tipo ");
            sql.append("FROM  ");
            sql.append("SII_CONTRATO contra,SII_OPERADOR ope, SII_PERSONA perso, sii_establecimiento esta, SII_UBICACION ubica ");
            sql.append("WHERE ");
            sql.append("contra.ope_codigo = ope.ope_codigo ");
            sql.append("AND ope.per_codigo = perso.per_codigo ");
            sql.append("AND ope.ope_codigo = esta.ope_codigo ");
            sql.append("AND esta.ubi_codigo = ubica.ubi_codigo ");
            sql.append("AND contra.con_fecha_fin > sysdate ");

            if(nit != null && !nit.equals("")) {
                sql.append("AND perso.per_num_identificacion = #Nit ");
            }
            sql.append("order by  2 ");
            Query query = manager.createNativeQuery(sql.toString());
            if(nit != null && !nit.equals("")) {
                query.setParameter("Nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                OperadorConsultaVO elemento = new OperadorConsultaVO();

                elemento.numContrato = (String) object[0];
                elemento.razonSocial = (String) object[1];
                elemento.direccion = (String) object[2];
                elemento.departamento = (String) object[3];
                elemento.telefono = (String) object[4];
                elemento.email = (String) object[5];
                elemento.tipoOperador = (String) object[6];
                listaOperadores.add(elemento);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaOperadores;
    }

    public List<MetConsultaVO> consultarMetNit(String nit) throws ExcepcionDAO {
        List<MetConsultaVO> listaMetConsultaVo = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select  ");
            sql.append("DISTINCT (tipoa.tap_apuesta) as apuesta, ");
            sql.append("met.met_codigo as consecutivo, perso.per_num_identificacion as nit,  contra.con_numero as contrato, ");
            sql.append("esta.est_codigo as codigoLocal, esta.est_nombre as nombreLocal, met.met_nuid as nuid, ");
            sql.append("met.met_serial as serial, marca.mar_nombre as marca ");
            sql.append("from  ");
            sql.append("sii_inventario inven, SII_OPERADOR ope, SII_PERSONA perso, sii_establecimiento esta, ");
            sql.append("sii_instrumento inst, sii_met met, sii_marca marca, sii_tipo_apuesta tipoa, sii_novedad nove,SII_CONTRATO contra ");
            sql.append("where inven.est_codigo = esta.est_codigo ");
            sql.append("AND ope.ope_codigo = esta.ope_codigo ");
            sql.append("AND ope.per_codigo = perso.per_codigo ");
            sql.append("AND inst.ins_codigo = inven.ins_codigo ");
            sql.append("AND nove.nov_codigo = inven.nov_codigo ");
            sql.append("AND met.met_codigo = inst.met_codigo ");
            sql.append("AND met.mar_codigo = marca.mar_codigo ");
            sql.append("AND tipoa.tap_codigo = inven.tap_codigo ");
            sql.append("AND contra.con_codigo = nove.con_codigo ");
            sql.append("AND contra.con_fecha_fin > sysdate ");
            //sql.append("AND inven.inv_estado = 'A' ");
            //sql.append("AND inven.tap_codigo = 1 ");


            if(nit != null && !nit.equals("")) {
                sql.append("AND perso.per_num_identificacion = #Nit ");
            }
            sql.append("order by  2 ");
            Query query = manager.createNativeQuery(sql.toString());
            if(nit != null && !nit.equals("")) {
                query.setParameter("Nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                MetConsultaVO metConsultaVo = new MetConsultaVO();

                metConsultaVo.consecutivo = (BigDecimal) object[1];
                metConsultaVo.nitOperador = (String) object[2];
                metConsultaVo.contrato = (String) object[3];
                metConsultaVo.codLocal = (BigDecimal) object[4];
                metConsultaVo.nombreLocal = (String) object[5];
                metConsultaVo.nuid = (String) object[6];
                metConsultaVo.numSerial = (String) object[7];
                metConsultaVo.marca = (String) object[8];
                metConsultaVo.apuesta = (String) object[0];

                listaMetConsultaVo.add(metConsultaVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaMetConsultaVo;
    }

    public List<BingoConsultaVO> consultarBingosNit(String nit) throws ExcepcionDAO {
        List<BingoConsultaVO> listaBingoConsultaVo = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT P.PER_NUM_IDENTIFICACION,i.inv_sillas,ta.tap_apuesta ");
            sql.append("FROM PR.SII_MESA_CASINO M, ");
            sql.append("PR.SII_JUEGO_MESA L, ");
            sql.append("PR.SII_INSTRUMENTO N, ");
            sql.append("PR.SII_OPERADOR O, ");
            sql.append("PR.SII_PERSONA P, ");
            sql.append("PR.SII_INVENTARIO I, ");
            sql.append("PR.SII_TIPO_APUESTA TA, ");
            sql.append("PR.SII_TIPO_JUEGO TJ ");
            sql.append("WHERE L.JME_CODIGO = M.JME_CODIGO ");
            sql.append("AND M.MCA_CODIGO   = N.MCA_CODIGO ");
            sql.append("AND O.OPE_CODIGO   = N.OPE_CODIGO ");
            sql.append("AND P.PER_CODIGO   = O.PER_CODIGO ");
            sql.append("AND I.INS_CODIGO = N.INS_CODIGO ");
            sql.append("AND TA.TAP_CODIGO = I.TAP_CODIGO ");
            sql.append("AND TA.tju_codigo = TJ.tju_codigo ");
            sql.append("AND TJ.tju_codigo = 4 ");


            if(nit != null && !nit.equals("")) {
                sql.append("AND P.per_num_identificacion = #Nit ");
            }
            sql.append("order by  2 ");
            Query query = manager.createNativeQuery(sql.toString());
            if(nit != null && !nit.equals("")) {
                query.setParameter("Nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                BingoConsultaVO bingoConsultaVo = new BingoConsultaVO();

                bingoConsultaVo.apuesta = (String) object[2];
                bingoConsultaVo.nitOperador = (String) object[0];
                bingoConsultaVo.numSillas = (BigDecimal) object[1];


                listaBingoConsultaVo.add(bingoConsultaVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaBingoConsultaVo;
    }


    public List<MesaConsultaVO> consultarMesasNit(String nit) throws ExcepcionDAO {
        List<MesaConsultaVO> mesas = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT  ");
            sql.append("Z.PER_NUM_IDENTIFICACION, ");
            sql.append("COUNT(w.ins_codigo),t.tju_nombre ");
            sql.append("FROM PR.SII_TIPO_APUESTA U, ");
            sql.append("PR.SII_TIPO_JUEGO T, ");
            sql.append("PR.SII_INVENTARIO W, ");
            sql.append("PR.SII_INSTRUMENTO V, ");
            sql.append("PR.SII_MESA_CASINO X, ");
            sql.append("PR.SII_OPERADOR Y, ");
            sql.append("PR.SII_PERSONA Z ");
            sql.append("WHERE T.TJU_CODIGO = U.TJU_CODIGO ");
            sql.append("AND V.INS_CODIGO   = W.INS_CODIGO ");
            sql.append("AND U.TAP_CODIGO   = W.TAP_CODIGO ");
            sql.append("AND X.MCA_CODIGO   = V.MCA_CODIGO ");
            sql.append("AND Y.OPE_CODIGO   = V.OPE_CODIGO ");
            sql.append("AND Z.PER_CODIGO   = Y.PER_CODIGO ");

            if(nit != null && !nit.equals("")) {
                sql.append("AND Z.PER_NUM_IDENTIFICACION = #Nit ");
            }
            sql.append("GROUP BY Z.PER_NUM_IDENTIFICACION,t.tju_nombre ");
            Query query = manager.createNativeQuery(sql.toString());
            if(nit != null && !nit.equals("")) {
                query.setParameter("Nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                MesaConsultaVO elemento = new MesaConsultaVO();

                elemento.nitOperador = (String) object[0];
                elemento.numMesas = (BigDecimal) object[1];
                elemento.tipoJuego = (String) object[2];


                mesas.add(elemento);
            }
 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return mesas;
    }


    public List<UbicacionWSVO> municipiosPorDepartamento(String numeroDepto) throws ExcepcionDAO {
        List<UbicacionWSVO> listaUbicacionWsVo = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select  ubi_codigo,  ubi_codigo_padre, ubi_descripcion, ubi_nombre " + "from sii_ubicacion  where ubi_codigo_padre = #numeroDepto ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("numeroDepto", numeroDepto);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionWSVO ubicacionWsVo = new UbicacionWSVO();

                ubicacionWsVo.tipoUbicacionVo = new TipoUbicacionWSVO();
                ubicacionWsVo.ubiCodigo = (String) object[0];
                ubicacionWsVo.ubiCodigoPadre = (String) object[1];
                ubicacionWsVo.ubiDescripcion = (String) object[2];
                ubicacionWsVo.ubiNombre = (String) object[3];

                listaUbicacionWsVo.add(ubicacionWsVo);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaUbicacionWsVo;
    }

    public List<UbicacionWSVO> obtenerDepartamentos() throws ExcepcionDAO {
        List<UbicacionWSVO> retorno = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select  ubi_codigo, ubi_codigo_padre, " + "ubi_descripcion, ubi_nombre from sii_ubicacion " + "where ubi_codigo_padre = 'CO' ORDER BY ubi_nombre");
            Query query = manager.createNativeQuery(sql.toString());

            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionWSVO elemento = new UbicacionWSVO();

                elemento.tipoUbicacionVo = new TipoUbicacionWSVO();
                elemento.ubiCodigo = (String) object[0];
                elemento.ubiCodigoPadre = (String) object[1];
                elemento.ubiDescripcion = (String) object[2];
                elemento.ubiNombre = (String) object[3];

                retorno.add(elemento);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;
    }

    public List<EstablecimientoVO> establecimientosPorCodUbicacion(String codUbicacion) throws ExcepcionDAO {
        List<EstablecimientoVO> retorno = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT " + 
            " DISTINCT(E.EST_CODIGO), e.*" + 
            " FROM SII_ESTABLECIMIENTO E " + 
            " INNER JOIN SII_UBICACION U ON U.UBI_CODIGO = E.UBI_CODIGO " + 
            " INNER JOIN SII_INVENTARIO I ON I.EST_CODIGO = E.EST_CODIGO " + 
            " INNER JOIN SII_NOVEDAD N ON I.NOV_CODIGO = N.NOV_CODIGO " + 
            " INNER JOIN sii_contrato c ON N.CON_CODIGO    = c.CON_CODIGO " + 
            " WHERE  u.ubi_codigo =#codUbicacion " +
            " AND c.con_vigente = 'S' " + 
            " AND e.est_estado ='A' "  +
            " AND i.inv_estado='A' ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codUbicacion", codUbicacion);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                EstablecimientoVO elemento = new EstablecimientoVO();
                UbicacionVO ubica = new UbicacionVO();
                ubica.setUbiCodigo((String) object[2]);

                elemento.setEstCodigo(((BigDecimal) object[1]).longValue());
                elemento.setEstCodInterno((String) object[4] + "");

                elemento.setEstDireccion((String) object[3]);
                elemento.setEstNombre((String) object[6]);
                elemento.setUbicacionVo(ubica);

                retorno.add(elemento);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;
    }

    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionPorNombreEstado(Long estado, Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT sau FROM SiiSolicitudAutoriza sau INNER JOIN sau.siiEstadoSolicAutoriz estadoOficio ");
            sql.append(" Inner Join sau.siiUsuario usu");
            sql.append(" Inner Join sau.siiNovedadList nov");
            sql.append(" where estadoOficio.esaCodigo = :estado and usu.usuCodigo = :usuarioLogueado");
            sql.append(" ORDER BY sau.sauCodigo desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("usuarioLogueado", usuarioLogueado);
            listaSolAutoriza = query.getResultList();
            if(listaSolAutoriza.size() > 0) {
                List<SiiNovedad> listaNovedades = new ArrayList();
                for(SiiSolicitudAutoriza sol : listaSolAutoriza) {
                    listaNovedades = buscarNovedadesPorSolicitudAutorizacion(sol.getSauCodigo());
                    sol.setSiiNovedadList(listaNovedades);
                }
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionPorEstadoPorTipoSol(Long estado, Long tipoSol) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau ");
            sql.append("WHERE sau.siiEstadoSolicAutoriz.esaCodigo = :estado AND sau.siiTipoSolicAutoriza.tsaCodigo = :tipoSol ");
            sql.append("AND NOT (sau.sauAmpliacion = 2 AND sau.siiEstadoSolicAutoriz.esaCodigo = " + EnumEstadoSolicitudAutoriza.APROBADO.getId() + ") "); 
            sql.append("ORDER BY sau.sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("tipoSol", tipoSol);
            listaSolAutoriza = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public SiiSolicitudAutoriza buscarSolicitudAutorizacionPorNumeroSiito(String sauMovimientoSiito) throws ExcepcionDAO {
        SiiSolicitudAutoriza solAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau ");
            sql.append("where sau.sauMovimientoSiito = :sauMovimientoSiito");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("sauMovimientoSiito", Integer.parseInt(sauMovimientoSiito));
            solAutoriza = (SiiSolicitudAutoriza) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return solAutoriza;
    }
        

    public List<SiiSolicitudAutoriza> solicitudesAutorizacionPorEstadoPorTipoSolPorUsuario(Long estado, Long tipoSol, Long usuCodigo) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau " + 
                       "WHERE sau.siiEstadoSolicAutoriz.esaCodigo = :estado " + 
                       "AND sau.siiTipoSolicAutoriza.tsaCodigo = :tipoSol " +
                       "AND NOT (sau.sauAmpliacion = 2 AND sau.siiEstadoSolicAutoriz.esaCodigo = " + EnumEstadoSolicitudAutoriza.APROBADO.getId()+ ") " +
                       "AND sau.siiUsuario.usuCodigo =:usuCodigo " + 
                       "ORDER BY sau.sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("tipoSol", tipoSol);
            query.setParameter("usuCodigo", usuCodigo);
            listaSolAutoriza = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<SiiSolicitudAutoriza> solicitudesAutorizacionAprobadasQueNoModificanValor(Long usuCodigo) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau " + "WHERE sau.siiEstadoSolicAutoriz.esaNombre = 'APROBADO' " +
                       "AND (sau.siiTipoSolicAutoriza.tsaNombre = 'Traslado Automático' " +
                            " OR (sau.siiTipoSolicAutoriza.tsaNombre = 'Otras Novedades' AND (sau.sauAmpliacion is null or sau.sauAmpliacion = 2) )) " + 
                       "AND sau.siiUsuario.usuCodigo =:usuCodigo " +
//                       "AND NOT (sau.sauAmpliacion = 2 AND sau.siiEstadoSolicAutoriz.esaCodigo = " + EnumEstadoSolicitudAutoriza.APROBADO.getId() + ") " +
                       "ORDER BY sau.sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("usuCodigo", usuCodigo);
            listaSolAutoriza = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<SiiSolicitudAutoriza> solicitudesAutorizacionAprobadasQueNoModificanValor() throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau " + "WHERE sau.siiEstadoSolicAutoriz.esaNombre = 'APROBADO' AND sau.sauValorEstimado = 0 " +
                       "AND (sau.siiTipoSolicAutoriza.tsaNombre = 'Traslado Automático'" +
                          "OR sau.siiTipoSolicAutoriza.tsaNombre = 'Otras Novedades'  AND (sau.sauAmpliacion is null or sau.sauAmpliacion = 2)) " + "ORDER BY sau.sauCodigo");
            Query query = manager.createQuery(sql.toString());
            listaSolAutoriza = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<DetalleEstablecimientoVO> detalleEstablecimientosPorCodUbicacion(Long codEstablecimiento) throws ExcepcionDAO {
        List<DetalleEstablecimientoVO> listaDetalleEstablecimientoVo = new ArrayList();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.per_num_identificacion, con.con_numero , p.per_jur_nombre_largo, est.est_cod_interno, est.est_nombre, " +
            " p.per_direccion, ubi.ubi_codigo, ubi.ubi_nombre, ins.ins_codigo, p.per_telefono, " + 
            " p.per_email,  met.met_uid, mar.mar_codigo, mar.mar_nombre, met.met_serial, tap.tap_codigo, tap.tap_nombre, met.met_online " + 
            " FROM sii_inventario inv " + 
            " left join sii_instrumento ins on inv.ins_codigo = ins.ins_codigo " + 
            " left join sii_met met on ins.met_codigo = met.met_codigo " + 
            " left join sii_marca mar on met.mar_codigo = mar.mar_codigo " + 
            " left join sii_establecimiento est on inv.est_codigo = est.est_codigo " + 
            " left JOIN sii_ubicacion ubi ON est.UBI_CODIGO = ubi.UBI_CODIGO " + 
            " left JOIN sii_ubicacion ubi2 ON ubi.UBI_CODIGO_PADRE = ubi2.UBI_CODIGO " + 
            " left join sii_novedad n on inv.nov_codigo = n.nov_codigo " + 
            " left join sii_contrato con on con.con_codigo = n.con_codigo " + 
            " left join sii_tipo_apuesta tap on inv.tap_codigo = tap.tap_codigo " + 
            " left join sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo " + 
            " left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo " + 
            " left join sii_operador ope on ope.ope_codigo = con.ope_codigo " + 
            " left join sii_persona p on p.per_codigo = ope.per_codigo " + 
            " where " + 
            //" con.eco_codigo in (3, 6, 15, 21) " + 
            " con.con_vigente = 'S'  " + 
            " AND est.est_estado ='A' " + 
            //" AND ins.ins_activo='S' " + 
            " AND inv.inv_estado = 'A' " + 
            " AND est.est_codigo = #estCodigo");    
            Query query = manager.createNativeQuery(sql.toString());                
            query.setParameter("estCodigo", codEstablecimiento);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                DetalleEstablecimientoVO detalleEstablecimientoVo = new DetalleEstablecimientoVO();                    
                detalleEstablecimientoVo.numIdentificacionOperador = (String) object[0];
                detalleEstablecimientoVo.numContrato = (String) object[1];
                detalleEstablecimientoVo.nombreOperador = (String) object[2];
                detalleEstablecimientoVo.codigoEstablecimiento = (String) object[3];
                detalleEstablecimientoVo.nombreEstablecimiento = (String) object[4];
                detalleEstablecimientoVo.direccionEstablecimiento = (String) object[5];
                detalleEstablecimientoVo.codigoUbicacion = (String) object[6];
                detalleEstablecimientoVo.nombreUbicacion = (String) object[7];
                detalleEstablecimientoVo.codigoInstrumento = (BigDecimal) object[8];
                detalleEstablecimientoVo.telefonoOperador = (String) object[9];
                detalleEstablecimientoVo.emailOperador = (String) object[10];
                detalleEstablecimientoVo.nucMet = (String) object[11];
                detalleEstablecimientoVo.codigoMarca = (BigDecimal) object[12];
                detalleEstablecimientoVo.nombreMarca = (String) object[13];
                detalleEstablecimientoVo.serialMet = (String) object[14];
                detalleEstablecimientoVo.tipoApuesta = (BigDecimal) object[15];
                detalleEstablecimientoVo.nombreApuesta = (String) object[16];                    
                detalleEstablecimientoVo.metOnline = (String) object[17];
                listaDetalleEstablecimientoVo.add(detalleEstablecimientoVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaDetalleEstablecimientoVo;
    }
    
    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionOficioLiq(Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = new ArrayList<SiiSolicitudAutoriza>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select Sau.Sau_Codigo,Sau.Sau_Fecha,Sau.edo_codigo,Sau.Sau_Nit,");
            sql.append(" NVL(Sau.Sau_Tiempo_Contr,0),");
            sql.append("NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' '||per.per_segundo_apellido)");
            sql.append(" ,Sau.Esa_Codigo,Esa.Esa_Nombre from Sii_Solicitud_Autoriza sau");
            sql.append(" Inner Join sii_persona per on Sau.Sau_Nit = per.per_num_identificacion");
            sql.append(" Inner Join Sii_Estado_Solic_Autoriz esa on sau.esa_codigo = esa.esa_codigo");
            sql.append(" where Sau.Esa_Codigo in (8,9) ");
            sql.append(" and sau.usu_codigo = #usuarioLogueado");
            sql.append(" order by Sau.edo_codigo desc");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("usuarioLogueado", usuarioLogueado);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                SiiSolicitudAutoriza solicitud = new SiiSolicitudAutoriza();
                SiiEstadoSolicAutoriz siiEstado = new SiiEstadoSolicAutoriz();
                SiiPersona persona = new SiiPersona();
                solicitud.setSauCodigo(((BigDecimal) object[0]).longValue());
                solicitud.setSauFecha((Date) object[1]);
                SiiExpedienteDocum siiExp = new SiiExpedienteDocum();
                siiExp.setEdoCodigo((String) object[2]);
                solicitud.setSiiExpedienteDocum(siiExp);
                solicitud.setSauNit((String) object[3]);
                solicitud.setSauTiempoContr(((BigDecimal) object[4]).intValue());
                persona.setPerJurNombreLargo((String) object[5]);
                solicitud.setSiiPersonaRifaProm(persona);
                //solicitud.setSauRadicado((String) object[5]);
                siiEstado.setEsaCodigo(((BigDecimal) object[6]).longValue());
                siiEstado.setEsaNombre((String) object[7]);
                solicitud.setSiiEstadoSolicAutoriz(siiEstado);

                listaSolAutoriza.add(solicitud);
            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionPorNumeroSolicitudSIITO(String numeroSolicitud) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sau FROM SiiSolicitudAutoriza sau ");
            sql.append(" inner join sau.siiExpedienteDocum exp");
            sql.append(" where exp.edoCodigo = :numeroSolicitud");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroSolicitud", numeroSolicitud);
            listaSolAutoriza = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public String inventarioElementos(Long sauCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ListAgg(REPLACE(REPLACE(numtoletras(SUM(ota.OTA_NUM_ELEM)), ' PESOS M/CTE.'), ' PESO M/CTE.')\n" + 
            "  || ' ('\n" + 
            "  || SUM(ota.OTA_NUM_ELEM)\n" + 
            "  || ') '\n" + 
            "  || ' '\n" + 
            "  || REPLACE(tap.TAP_NOMBRE, '(Ver Nota 2)')\n" + 
            "  || ', ') Within GROUP (\n" + 
            "ORDER BY tap.TAP_NOMBRE)\n" + 
            "FROM sii_oficio_liquidacion ofi\n" + 
            "INNER JOIN sii_ofic_liq_tipo_apuesta ota\n" + 
            "ON ofi.OLI_CODIGO = ota.OLI_CODIGO\n" + 
            "INNER JOIN SII_TIPO_APUESTA tap\n" + 
            "ON tap.TAP_CODIGO         = ota.TAP_CODIGO\n" + 
            "WHERE ofi.SAU_CODIGO      = #sauCodigo\n" + 
            "AND ota.ota_indicador_liq = 'N'\n" + 
            "GROUP BY tap.TAP_NOMBRE");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            String s = (String) query.getSingleResult();
            
            return s == null? "**** No se encontro invenario de elementos con marca N en la liquidacion ****" : s; 

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaDAO");
        }
    }

    public List<UbicacionMetAutorizadaVO> ubicacionMetsAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        List<UbicacionMetAutorizadaVO> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT RowNum no,\n" + "  i.serial,\n" + "  i.marca,\n" + "  i.apuesta,\n" + "  i.loc,\n" + "  i.direccion,\n" + "  i.municipio,\n" + "  i.departamento\n" + "FROM (\n" +
                       "SELECT\n" + "  sii_met.MET_SERIAL serial,\n" + "  mar.MAR_NOMBRE marca,\n" + "  tap.TAP_NOMBRE apuesta,\n" + "  est.EST_NOMBRE loc,\n" + "  est.EST_DIRECCION direccion,\n" +
                       "  mun.UBI_NOMBRE municipio,\n" + "  dep.UBI_NOMBRE departamento,sau.sau_codigo\n" + "FROM sii_inventario inv\n" + "INNER JOIN sii_tipo_apuesta tap\n" +
                       "ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "INNER JOIN sii_instrumento ins\n" + "ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "INNER JOIN sii_met\n" +
                       "ON ins.MET_CODIGO = sii_met.MET_CODIGO\n" + "INNER JOIN sii_marca mar\n" + "ON sii_met.MAR_CODIGO = mar.MAR_CODIGO\n" + "INNER JOIN sii_establecimiento est\n" +
                       "ON inv.EST_CODIGO = est.EST_CODIGO\n" + "INNER JOIN sii_ubicacion mun\n" + "ON est.UBI_CODIGO = mun.UBI_CODIGO\n" + "INNER JOIN sii_ubicacion dep\n" +
                       "ON mun.UBI_CODIGO_PADRE = dep.UBI_CODIGO\n" + "INNER JOIN sii_novedad nov\n" + "ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "INNER JOIN sii_solicitud_autoriz sau\n" +
                       "ON nov.SAU_CODIGO    = sau.SAU_CODIGO\n" + "WHERE sau.sau_codigo =#sauCodigo\n" + "order by est.EST_NOMBRE,tap.TAP_NOMBRE ,sii_met.MET_SERIAL) i");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionMetAutorizadaVO ubicacion = new UbicacionMetAutorizadaVO();

                ubicacion.no = (BigDecimal) object[0];
                ubicacion.serial = (String) object[1];
                ubicacion.marca = (String) object[2];
                ubicacion.apuesta = (String) object[3];
                ubicacion.loc = (String) object[4];
                ubicacion.direccion = (String) object[5];
                ubicacion.municipio = (String) object[6];
                ubicacion.departamento = (String) object[7];

                lista.add(ubicacion);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return lista;
    }

    public List<UbicacionSillasBingoAutorizadasVO> ubicacionSillasBingoAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        List<UbicacionSillasBingoAutorizadasVO> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT RowNum no,\n" + "  i.*\n" + "FROM\n" + "  (SELECT RowNum no,\n" + "    inv.INV_SILLAS CANTIDAD,\n" + "    tap.TAP_NOMBRE apuesta,\n" + "    est.EST_NOMBRE loc,\n" +
                       "    est.EST_DIRECCION direccion,\n" + "    mun.UBI_NOMBRE municipio,\n" + "    dep.UBI_NOMBRE departamento\n" + "\n" + "  FROM sii_inventario inv\n" +
                       "  INNER JOIN sii_tipo_apuesta tap\n" + "  ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "  INNER JOIN sii_instrumento ins\n" + "  ON inv.INS_CODIGO = ins.INS_CODIGO\n" +
                       "  INNER JOIN sii_establecimiento est\n" + "  ON inv.EST_CODIGO = est.EST_CODIGO\n" + "  INNER JOIN sii_ubicacion mun\n" + "  ON est.UBI_CODIGO = mun.UBI_CODIGO\n" +
                       "  INNER JOIN sii_ubicacion dep\n" + "  ON mun.UBI_CODIGO_PADRE = dep.UBI_CODIGO\n" + "  INNER JOIN sii_novedad nov\n" + "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" +
                       "  INNER JOIN sii_solicitud_autoriz sau\n" + "  ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "  INNER JOIN sii_tipo_juego tju\n" + "  ON tap.TJU_CODIGO = tju.TJU_CODIGO\n" +
                       "  where tju.tju_nombre like 'SALONES DE BINGO%' AND sau.SAU_CODIGO = #sauCodigo\n" + "order by est.EST_NOMBRE,tap.TAP_NOMBRE) i");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionSillasBingoAutorizadasVO ubicacion = new UbicacionSillasBingoAutorizadasVO();

                ubicacion.no = (BigDecimal) object[0];
                ubicacion.cantidad = (BigDecimal) object[2];
                ubicacion.apuesta = (String) object[3];
                ubicacion.loc = (String) object[4];
                ubicacion.direccion = (String) object[5];
                ubicacion.municipio = (String) object[6];
                ubicacion.departamento = (String) object[7];

                lista.add(ubicacion);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return lista;
    }

    public List<UbicacionMesasCasinoAutorizadasVO> ubicacionMesasCasinoAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        List<UbicacionMesasCasinoAutorizadasVO> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT RowNum no,\n" + "  i.*\n" + "FROM\n" + "  (SELECT RowNum no,\n" + "    1 CANTIDAD,\n" + "    tap.TAP_NOMBRE apuesta,\n" + "    est.EST_NOMBRE loc,\n" +
                       "    est.EST_DIRECCION direccion,\n" + "    mun.UBI_NOMBRE municipio,\n" + "    dep.UBI_NOMBRE departamento,\n" + "   jme.JME_NOMBRE marca\n" + " --   mar.MAR_NOMBRE marca\n" +
                       "  FROM sii_inventario inv\n" + "  INNER JOIN sii_tipo_apuesta tap\n" + "  ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "  INNER JOIN sii_instrumento ins\n" +
                       "  ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "  INNER JOIN sii_establecimiento est\n" + "  ON inv.EST_CODIGO = est.EST_CODIGO\n" + "  INNER JOIN sii_ubicacion mun\n" +
                       "  ON est.UBI_CODIGO = mun.UBI_CODIGO\n" + "  INNER JOIN sii_ubicacion dep\n" + "  ON mun.UBI_CODIGO_PADRE = dep.UBI_CODIGO\n" + "  INNER JOIN sii_novedad nov\n" +
                       "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "  INNER JOIN sii_solicitud_autoriz sau\n" + "  ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "  INNER JOIN sii_tipo_juego tju\n" +
                       "  ON tap.TJU_CODIGO = tju.TJU_CODIGO\n" + "  INNER JOIN sii_mesa_casino mca\n" + "  ON ins.MCA_CODIGO = mca.MCA_CODIGO\n" + "  INNER JOIN sii_juego_mesa jme\n" +
                       "  ON mca.JME_CODIGO    = jme.JME_CODIGO\n" + "  WHERE tju.TJU_NOMBRE LIKE 'JUEGOS DE CASINO%' AND sau.SAU_CODIGO = #sauCodigo\n" + "  ORDER BY est.EST_NOMBRE,\n" +
                       "    tap.TAP_NOMBRE\n" + "  ) i");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionMesasCasinoAutorizadasVO ubicacion = new UbicacionMesasCasinoAutorizadasVO();

                ubicacion.no = (BigDecimal) object[0];
                ubicacion.cantidad = (BigDecimal) object[2];
                ubicacion.apuesta = (String) object[3];
                ubicacion.loc = (String) object[4];
                ubicacion.direccion = (String) object[5];
                ubicacion.municipio = (String) object[6];
                ubicacion.departamento = (String) object[7];
                ubicacion.marca = (String) object[8];

                lista.add(ubicacion);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return lista;
    }

    public List<UbicacionDemasJuegosAutorizadosVO> ubicacionEsferodromosAutorizados(Long sauCodigo) throws ExcepcionDAO {
        List<UbicacionDemasJuegosAutorizadosVO> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT RowNum no,\n" + "  i.*\n" + "FROM\n" + "  (SELECT RowNum no,\n" + "    inv.INV_SILLAS CANTIDAD,\n" + "    tin.TIN_NOMBRE marca,\n" + "    tap.TAP_NOMBRE apuesta,\n" +
                       "    est.EST_NOMBRE loc,\n" + "    est.EST_DIRECCION direccion,\n" + "    mun.UBI_NOMBRE municipio,\n" + "    dep.UBI_NOMBRE departamento\n" + "\n" +
                       "  FROM sii_inventario inv\n" + "  INNER JOIN sii_tipo_apuesta tap\n" + "  ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "  INNER JOIN sii_instrumento ins\n" +
                       "  ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "  INNER JOIN sii_establecimiento est\n" + "  ON inv.EST_CODIGO = est.EST_CODIGO\n" + "  INNER JOIN sii_ubicacion mun\n" +
                       "  ON est.UBI_CODIGO = mun.UBI_CODIGO\n" + "  INNER JOIN sii_ubicacion dep\n" + "  ON mun.UBI_CODIGO_PADRE = dep.UBI_CODIGO\n" + "  INNER JOIN sii_novedad nov\n" +
                       "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "  INNER JOIN sii_solicitud_autoriz sau\n" + "  ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "  INNER JOIN sii_tipo_juego tju\n" +
                       "  ON tap.TJU_CODIGO = tju.TJU_CODIGO\n" + "  INNER JOIN sii_tipo_instrumento tin\n" + "  ON ins.TIN_CODIGO = tin.TIN_CODIGO\n" +
                       "  where tju.tju_nombre like 'DEMAS JUEGOS%' AND sau.SAU_CODIGO = #sauCodigo\n" + "order by est.EST_NOMBRE,tap.TAP_NOMBRE) i");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                UbicacionDemasJuegosAutorizadosVO ubicacion = new UbicacionDemasJuegosAutorizadosVO();

                ubicacion.no = (BigDecimal) object[0];
                ubicacion.cantidad = (BigDecimal) object[2];
                ubicacion.marca = (String) object[3];
                ubicacion.apuesta = (String) object[4];
                ubicacion.loc = (String) object[5];
                ubicacion.direccion = (String) object[6];
                ubicacion.municipio = (String) object[7];
                ubicacion.departamento = (String) object[8];

                lista.add(ubicacion);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return lista;
    }

    public List<ValorMensualPorApuestaVO> valorMensualPorApuesta(Long sauCodigo) throws ExcepcionDAO {
        List<ValorMensualPorApuestaVO> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT tap.TAP_NOMBRE instrumento,\n" + "  ota.OTA_NUM_ELEM cantidad,\n" + "  pr.fn_calcula_de(tap.TAP_DER_EXPL_FORMULA)  as tarifa_mes,\n" +
                       "  ota.OTA_DER_EXPL_MES valor_mes\n" + "FROM sii_ofic_liq_tipo_apuesta ota\n" + "INNER JOIN sii_tipo_apuesta tap\n" + "ON ota.TAP_CODIGO = tap.TAP_CODIGO\n" +
                       "INNER JOIN sii_oficio_liquidacion ofi\n" + "ON ofi.OLI_CODIGO = ota.OLI_CODIGO\n" + "INNER JOIN sii_solicitud_autoriz sau\n" + "ON ofi.SAU_CODIGO    = sau.SAU_CODIGO\n" +
                       "WHERE sau.sau_codigo = #sauCodigo");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            List<Object[]> results = query.getResultList();

            for(Object[] object : results) {
                ValorMensualPorApuestaVO valor = new ValorMensualPorApuestaVO();

                valor.instrumento = (String) object[0];
                valor.cantidad = (BigDecimal) object[1];
                valor.tarifa_mes = (BigDecimal) object[2];
                valor.valor_mes = (BigDecimal) object[3];

                lista.add(valor);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return lista;
    }


    /**
     * @param movimiento alguno de las novedades (Adición Elemento,CADUCIDAD,Cambio de Apuesta,Creación Local,Creación licencia ACDV,Elementos en Bodega,Novedad cambio de estado MET en linea,PRORROGA CONTRATO,Reemplazo Elementos,Reinicio,Retiro Elemento,Traslado Elementos)
     * @param listaEstados estado de los elementos en el inventario (PA,A,PR,R,I)
     * @param sauCodigo
     * @return la cantidad de elementos correspondientes al tipo de novedad, al estado del inventario para la solicitud de autorizacion.
     * @throws ExcepcionDAO
     */
    public BigDecimal contarElementosPorTipoNovedadPorSolicitud(String movimiento, String listaEstados, Long sauCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(ELEMENTOS)\n" + "FROM\n" + "  (SELECT SUM(INV.INV_SILLAS) ELEMENTOS\n" + "  FROM sii_inventario inv\n" + "  INNER JOIN sii_instrumento ins\n" +
                       "  ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "  INNER JOIN sii_novedad nov\n" + "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "  INNER JOIN sii_solicitud_autoriz sau\n" +
                       "  ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "  INNER JOIN sii_tipo_novedad tno\n" + "  ON nov.TNO_CODIGO = tno.TNO_CODIGO\n" + "  INNER JOIN sii_tipo_apuesta tap\n" +
                       "  ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "  WHERE tno.TNO_NOMBRE LIKE #movimiento\n" + "  AND inv.INV_ESTADO IN " + listaEstados + "\n" +
                       "  AND sau.SAU_CODIGO  = #sauCodigo\n" + "  AND tap.tap_nombre LIKE '%SILLAS%'\n" + "  UNION\n" + "  SELECT COUNT(*)\n" + "  FROM sii_inventario inv\n" +
                       "  INNER JOIN sii_instrumento ins\n" + "  ON inv.INS_CODIGO = ins.INS_CODIGO\n" + "  INNER JOIN sii_novedad nov\n" + "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" +
                       "  INNER JOIN sii_solicitud_autoriz sau\n" + "  ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + "  INNER JOIN sii_tipo_novedad tno\n" + "  ON nov.TNO_CODIGO = tno.TNO_CODIGO\n" +
                       "  INNER JOIN sii_tipo_apuesta tap\n" + "  ON inv.TAP_CODIGO = tap.TAP_CODIGO\n" + "  WHERE tno.TNO_NOMBRE LIKE #movimiento\n" + "  AND inv.INV_ESTADO IN " + listaEstados +
                       "\n" + "  AND sau.SAU_CODIGO  = #sauCodigo\n" + "  AND tap.tap_nombre NOT LIKE '%SILLAS%'\n" + "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            query.setParameter("movimiento", movimiento);
            return (BigDecimal) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaDAO");
        }

    }

    public List<SiiNovedad> buscarNovedadesPorSolicitudAutorizacion(Long idSolicitud) throws ExcepcionDAO {
        List<SiiNovedad> listaNovedades = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nov FROM SiiNovedad nov Inner Join nov.siiSolicitudAutoriza sol ");
            sql.append("where sol.sauCodigo = :idSolicitud ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idSolicitud", idSolicitud);

            listaNovedades = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaNovedades;
    }


    public List<InventarioWebVO> consultarInventarioNitWeb(String nit) throws ExcepcionDAO{
        List<InventarioWebVO> listaInventarioWebVO = new ArrayList();
        if(nit != null && !nit.equals("")){
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT  " + 
                " per.per_num_identificacion, cont.con_numero , per.per_jur_nombre_largo, est.est_cod_interno, est.est_nombre, per.per_direccion, ubi.ubi_codigo, ubi.ubi_nombre, ins.ins_codigo,  " + 
                " per.per_telefono, per.per_email,  met.met_uid, mar.mar_codigo, mar.mar_nombre, met.met_serial, tia.tap_codigo, tia.tap_nombre, met.met_online, ope.ope_codigo  " + 
                " from sii_inventario inv  " + 
                " left join sii_instrumento ins on inv.ins_codigo = ins.ins_codigo " + 
                " left join sii_met met on ins.met_codigo = met.met_codigo  " + 
                " left join sii_marca mar on met.mar_codigo = mar.mar_codigo  " + 
                " left join sii_establecimiento est on inv.est_codigo = est.est_codigo  " + 
                " left join sii_novedad n on inv.nov_codigo = n.nov_codigo  " + 
                " left join sii_contrato cont on cont.con_codigo = n.con_codigo  " + 
                " left join sii_tipo_apuesta tia on inv.tap_codigo = tia.tap_codigo  " + 
                " left join sii_tipo_instrumento tin on ins.tin_codigo = tin.tin_codigo  " + 
                " left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo " + 
                " left join sii_operador ope on ope.ope_codigo = cont.ope_codigo " + 
                " left join sii_persona per on per.per_codigo = ope.per_codigo " + 
                " left JOIN sii_ubicacion ubi ON est.UBI_CODIGO = ubi.UBI_CODIGO " + 
                " left JOIN sii_ubicacion ubi2 ON ubi.UBI_CODIGO_PADRE = ubi2.UBI_CODIGO " + 
                " WHERE " + 
                " cont.eco_codigo in (3, 6, 15, 21)  " + 
                " AND inv.inv_estado = 'A' " + 
                " AND per.per_num_identificacion = #identificacion");
                Query query = manager.createNativeQuery(sql.toString());
                query.setParameter("identificacion", nit);
                List<Object[]> results = query.getResultList();

                for(Object[] object : results){
                    InventarioWebVO inventarioWebVo = new InventarioWebVO();
                    inventarioWebVo.numIdentificacionOperador = (String) object[0];
                    inventarioWebVo.numContrato = (String) object[1];
                    inventarioWebVo.nombreOperador = (String) object[2];
                    inventarioWebVo.codigoEstablecimiento = (String) object[3];
                    inventarioWebVo.nombreEstablecimiento = (String) object[4];
                    inventarioWebVo.direccionEstablecimiento = (String) object[5];
                    inventarioWebVo.codigoUbicacion = (String) object[6];
                    inventarioWebVo.nombreUbicacion = (String) object[7];
                    inventarioWebVo.codigoInstrumento = (BigDecimal) object[8];
                    inventarioWebVo.telefonoOperador = (String) object[9];
                    inventarioWebVo.emailOperador = (String) object[10];
                    inventarioWebVo.nucMet = (String) object[11];
                    inventarioWebVo.codigoMarca = (BigDecimal) object[12];
                    inventarioWebVo.nombreMarca = (String) object[13];
                    inventarioWebVo.serialMet = (String) object[14];
                    inventarioWebVo.tipoApuesta = (BigDecimal) object[15];
                    inventarioWebVo.nombreApuesta = (String) object[16];
                    inventarioWebVo.metOnline = (String) object[17];
                    listaInventarioWebVO.add(inventarioWebVo);
                }
            } catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex){
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        }

        return listaInventarioWebVO;
    }


    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionOficioPorEstado(Long estado, Long estado2, Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT distinct sau FROM SiiSolicitudAutoriza sau INNER JOIN sau.siiEstadoSolicAutoriz estadoOficio ");
            sql.append(" Inner Join sau.siiUsuario usu");
            sql.append(" Inner Join sau.siiNovedadList nov");
            sql.append(" Inner Join sau.siiTipoSolicAutoriza ts");
            sql.append(" Inner Join sau.siiExpedienteDocum exp  ");
            sql.append(" where (estadoOficio.esaCodigo = :estado or estadoOficio.esaCodigo = :estado2) and usu.usuCodigo = :usuarioLogueado ");
            sql.append(" and (ts.tsaCodigo =30 or (ts.tsaCodigo = 90 and sau.sauAmpliacion > 0 )) ");
            sql.append(" ORDER BY exp.edoCodigo desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("estado2", estado2);
            query.setParameter("usuarioLogueado", usuarioLogueado);
            listaSolAutoriza = query.getResultList();
            if(listaSolAutoriza.size() > 0) {
                List<SiiNovedad> listaNovedades = new ArrayList();
                for(SiiSolicitudAutoriza sol : listaSolAutoriza) {
                    listaNovedades = buscarNovedadesPorSolicitudAutorizacion(sol.getSauCodigo());
                    sol.setSiiNovedadList(listaNovedades);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }

    public String localesExcluidosContrato(Long conCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT listagg(est1.EST_NOMBRE||', '||\n" + "  est1.EST_DIRECCION||', '||\n" + "  mun.UBI_NOMBRE ||', '||\n" + "  dpto.UBI_NOMBRE ,';') within group (order by 1)\n" +
                       "FROM sii_ubicacion mun\n" + "INNER JOIN sii_ubicacion dpto\n" + "ON mun.UBI_CODIGO_PADRE = dpto.UBI_CODIGO\n" + "INNER JOIN sii_establecimiento est1\n" +
                       "ON est1.UBI_CODIGO     = mun.UBI_CODIGO\n" + "WHERE est1.EST_CODIGO IN\n" + "  (SELECT DISTINCT est.EST_CODIGO\n" + "  FROM sii_inventario inv\n" +
                       "  INNER JOIN sii_novedad nov\n" + "  ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "  INNER JOIN sii_establecimiento est\n" + "  ON inv.EST_CODIGO     = est.EST_CODIGO\n" +
                       "  WHERE inv.INV_ESTADO IN ('A', 'PA')\n" + "  AND nov.CON_CODIGO    = #conCodigo\n" + "  MINUS\n" + "  SELECT DISTINCT EST_CODIGO\n" + "  FROM\n" +
                       "    (SELECT est.EST_CODIGO,\n" + "      inv.INS_CODIGO,\n" + "      nov.CON_CODIGO\n" + "    FROM sii_inventario inv\n" + "    INNER JOIN sii_novedad nov\n" +
                       "    ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + "    INNER JOIN sii_establecimiento est\n" + "    ON inv.EST_CODIGO    = est.EST_CODIGO\n" +
                       "    WHERE nov.CON_CODIGO = #conCodigo\n" + "    AND inv.INV_ESTADO  IN ('A', 'PA')\n" + "    MINUS\n" + "    SELECT est.EST_CODIGO,\n" + "      inv.INS_CODIGO,\n" +
                       "      nov.CON_CODIGO\n" + "    FROM sii_inventario inv\n" + "    INNER JOIN sii_novedad nov\n" + "    ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" +
                       "    INNER JOIN sii_establecimiento est\n" + "    ON inv.EST_CODIGO    = est.EST_CODIGO\n" + "    WHERE nov.CON_CODIGO = #conCodigo\n" + "    AND inv.INV_ESTADO   = 'PR'\n" +
                       "    )\n" + "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            return (String) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaDAO");
        }
    }

    /**
     * @param accion 'LA ADICION DE ','EL REEMPLAZO DE', 'EL RETIRO DE','EL TRASLADO DE', 'EL CAMBIO DE APUESTA DE'
     * @param listaEstados 'A','PR','R','PA'
     * @param sauCodigo
     * @return el texto con la cantidad de elementos que corresponden a la accion dada, si la accion es nula muestra el texto de todas las acciones
     * @throws ExcepcionDAO
     */
    public String textoCantidadElementosPorAccionPorSolicitud(String accion, String listaEstados, Long sauCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT listagg(accion\n" + 
            "  ||' '\n" + 
            "  ||inventario,'; ') within GROUP (\n" + 
            "ORDER BY accion)\n" + 
            "FROM\n" + 
            "  (SELECT accion,\n" + 
            "    listagg (REPLACE(REPLACE(numtoletras(elementos),' PESOS M/CTE.',''),' PESO M/CTE.','')\n" + 
            "    ||' ('\n" + 
            "    ||elementos\n" + 
            "    ||') '\n" + 
            "    ||tap_nombre,', ') within GROUP (\n" + 
            "  ORDER BY tap_nombre) AS inventario\n" + 
            "  FROM\n" + 
            "    (SELECT SUM(ELEMENTOS) elementos,\n" + 
            "      tap_nombre,\n" + 
            "      CASE tno_nombre\n" + 
            "        WHEN 'Adición Elemento'\n" + 
            "        THEN 'LA ADICION DE '\n" + 
            "        WHEN 'Reemplazo Elementos'\n" + 
            "        THEN 'EL REEMPLAZO DE'\n" + 
            "        WHEN 'Retiro Elemento'\n" + 
            "        THEN 'EL RETIRO DE'\n" + 
            "        WHEN 'Traslado Elementos'\n" + 
            "        THEN 'EL TRASLADO DE'\n" + 
            "        WHEN 'Cambio de Apuesta'\n" + 
            "        THEN 'EL CAMBIO DE APUESTA DE'\n" + 
            "        ELSE tno_nombre\n" + 
            "      END AS accion\n" + 
            "    FROM\n" + 
            "      (SELECT SUM(INV.INV_SILLAS) ELEMENTOS,\n" + 
            "        tap.tap_nombre,\n" + 
            "        tno.TNO_NOMBRE\n" + 
            "      FROM sii_inventario inv\n" + 
            "      INNER JOIN sii_instrumento ins\n" + 
            "      ON inv.INS_CODIGO = ins.INS_CODIGO\n" + 
            "      INNER JOIN sii_novedad nov\n" + 
            "      ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + 
            "      INNER JOIN sii_solicitud_autoriz sau\n" + 
            "      ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + 
            "      INNER JOIN sii_tipo_novedad tno\n" + 
            "      ON nov.TNO_CODIGO = tno.TNO_CODIGO\n" + 
            "      INNER JOIN sii_tipo_apuesta tap\n" + 
            "      ON inv.TAP_CODIGO     = tap.TAP_CODIGO\n" + 
            "      WHERE inv.INV_ESTADO IN " + listaEstados + "\n "+
            "      AND sau.SAU_CODIGO  = #sauCodigo\n" + 
            "      AND tap.tap_nombre LIKE '%SILLAS%'\n" + 
            "      GROUP BY tap.tap_nombre,\n" + 
            "        tno.TNO_NOMBRE\n" + 
            "      UNION\n" + 
            "      SELECT COUNT(*),\n" + 
            "        tap.tap_nombre,\n" + 
            "        tno.TNO_NOMBRE\n" + 
            "      FROM sii_inventario inv\n" + 
            "      INNER JOIN sii_instrumento ins\n" + 
            "      ON inv.INS_CODIGO = ins.INS_CODIGO\n" + 
            "      INNER JOIN sii_novedad nov\n" + 
            "      ON inv.NOV_CODIGO = nov.NOV_CODIGO\n" + 
            "      INNER JOIN sii_solicitud_autoriz sau\n" + 
            "      ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + 
            "      INNER JOIN sii_tipo_novedad tno\n" + 
            "      ON nov.TNO_CODIGO = tno.TNO_CODIGO\n" + 
            "      INNER JOIN sii_tipo_apuesta tap\n" + 
            "      ON inv.TAP_CODIGO     = tap.TAP_CODIGO\n" + 
            "      WHERE inv.INV_ESTADO IN " + listaEstados + "\n "+
            "      AND sau.SAU_CODIGO  = #sauCodigo\n" + 
            "      AND tap_nombre NOT LIKE '%SILLAS%'\n" + 
            "      GROUP BY tap.tap_nombre,\n" + 
            "        tno.TNO_NOMBRE\n" + 
            "      )\n" + 
            "    GROUP BY tno_nombre,\n" + 
            "      tap_nombre\n" + 
            "    ORDER BY 2\n" + 
            "    )\n" + 
            "    where accion like #accion\n" + 
            "  GROUP BY accion\n" + 
            "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("accion", accion);
            query.setParameter("sauCodigo", sauCodigo);
            String resultado = (String) query.getSingleResult();
            System.out.println(accion);
            System.out.println(resultado);
            return resultado;
            
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaDAO");
        }
    }
   
    
    //public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionOficioLiqPorTipoSolicitud(Long usuarioLogueado, Long tipoSolicitud) throws ExcepcionDAO {
    public List<SiiSolicitudAutoriza> buscarSolicitudAutorizacionOficioLiqPorTipoSolicitud(Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSolAutoriza = new ArrayList<SiiSolicitudAutoriza>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select Sau.Sau_Codigo,Sau.Sau_Fecha,Sau.edo_codigo,Sau.Sau_Nit,");
            sql.append(" NVL(Sau.Sau_Tiempo_Contr,0),");
            sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' '||per.per_segundo_apellido),");
            sql.append(" Sau.Esa_Codigo,Esa.Esa_Nombre from Sii_Solicitud_Autoriza sau");
            sql.append(" Inner Join sii_persona per on Sau.Sau_Nit = per.per_num_identificacion");
            sql.append(" Inner Join Sii_Estado_Solic_Autoriz esa on sau.esa_codigo = esa.esa_codigo");
            sql.append(" Inner Join Sii_Tipo_Solic_Autoriza tsa on (sau.tsa_codigo = tsa.tsa_codigo)");
            sql.append(" where Sau.Esa_Codigo in (8,9) and tsa.tsa_codigo in (10,20)");
            sql.append(" and sau.usu_codigo = #usuarioLogueado");
            //sql.append(" and UPPER(per.per_tipo_persona) = 'J'");            
            sql.append(" order by Sau.edo_codigo desc");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("usuarioLogueado", usuarioLogueado);
            //query.setParameter("tipoSolicitud", tipoSolicitud);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                SiiSolicitudAutoriza solicitud = new SiiSolicitudAutoriza();
                SiiEstadoSolicAutoriz siiEstado = new SiiEstadoSolicAutoriz();
                SiiPersona persona = new SiiPersona();
                solicitud.setSauCodigo(((BigDecimal) object[0]).longValue());
                solicitud.setSauFecha((Date) object[1]);
                SiiExpedienteDocum siiExp = new SiiExpedienteDocum();
                siiExp.setEdoCodigo((String) object[2]);
                solicitud.setSiiExpedienteDocum(siiExp);
                solicitud.setSauNit((String) object[3]);
                solicitud.setSauTiempoContr(((BigDecimal) object[4]).intValue());
                persona.setPerJurNombreLargo((String) object[5]);
                solicitud.setSiiPersonaRifaProm(persona);
                //solicitud.setSauRadicado((String) object[5]);
                siiEstado.setEsaCodigo(((BigDecimal) object[6]).longValue());
                siiEstado.setEsaNombre((String) object[7]);
                solicitud.setSiiEstadoSolicAutoriz(siiEstado);

                listaSolAutoriza.add(solicitud);
            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolAutoriza;
    }
}
