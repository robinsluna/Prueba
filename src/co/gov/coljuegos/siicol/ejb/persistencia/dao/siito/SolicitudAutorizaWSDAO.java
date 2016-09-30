package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.siito.ConsultaInventarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ContratoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.EstablecimientoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.OperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.UbicacionWSVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class SolicitudAutorizaWSDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager manager;
    private Recursos recursos;

    public SolicitudAutorizaWSDAO() {
        recursos = new Recursos();
    }

    public String insertarInventario(ConsultaInventarioVO inventario) throws ExcepcionDAO {
        String retorno = "";
        try {
            manager.persist(inventario);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaWSDAO");
        }
        return retorno;
    }

    public String insertarInventario(List<ConsultaInventarioVO> inventario) throws ExcepcionDAO {

        String resultado = "";
        try {
            for (ConsultaInventarioVO object : inventario) {
                StringBuilder sql = new StringBuilder();

                sql.append("INSERT INTO SIITO_INVENTARIO_AUTORIZADO  " + "(" + "INV_AUT_MOD_JUEGO" +
                           ",INV_AUT_NIT_OPER" + ",INV_AUT_CONT_OPER" + ",INV_AUT_DIR" + ",INV_AUT_TEL" +
                           ",INV_AUT_EMAIL" + ",INV_AUT_COD_DANE_MUN" +
                           //",INV_AUT_COD_LOCAL" +
                           ",INV_AUT_NOM_LOCAL" + ",INV_AUT_TIP_INST" + ",INV_AUT_TIP_JUEGO" + ",INV_AUT_IUC" +
                           ",INV_AUT_NUID" + ",INV_AUT_SERIAL" + ",INV_AUT_NUM_FAB" + ",INV_AUT_COD_MARCA" +
                           ",INV_AUT_COD_MODELO" +
                           //",INV_AUT_ANO_FAB" +


                    //",INV_AUT_NUM_REG_SCLM" +
                    ",INV_AUT_IND_EN_LINEA_SCLM" + ",INV_AUT_IND_HOMO_MET" + ",INV_AUT_COD_APUESTA" +
                    //",INV_AUT_VLR_CARTON" +
                    ",INV_AUT_EST_UBI_MET" + ",INV_AUT_LAT_ESTA" + ",INV_AUT_LONG_ESTA" +
                    ",INV_AUT_ESTA_DIR_LOCAL_OPER" + ",INV_AUT_ESTA_SERIAL_REP_OPER" +
                    //",INV_AUT_FECHA_REGISTRO" +
                    ",INV_AUT_MOV_SOL_CODIGO" + ",INV_AUT_SOL_CODIGO)" + "VALUES ( " + "#INV_AUT_MOD_JUEGO" +
                    ",#INV_AUT_NIT_OPER" + ",#INV_AUT_CONT_OPER" + ",#INV_AUT_DIR" + ",#INV_AUT_TEL" +
                    ",#INV_AUT_EMAIL" + ",#INV_AUT_COD_DANE_MUN" +
                    //",#INV_AUT_COD_LOCAL" +
                    ",#INV_AUT_NOM_LOCAL" + ",#INV_AUT_TIP_INST" + ",#INV_AUT_TIP_JUEGO" + ",#INV_AUT_IUC" +
                    ",#INV_AUT_NUID" + ",#INV_AUT_SERIAL" + ",#INV_AUT_NUM_FAB" + ",#INV_AUT_COD_MARCA" +
                    ",#INV_AUT_COD_MODELO" +
                    //",#INV_AUT_ANO_FAB" +


                    //",#INV_AUT_NUM_REG_SCLM" +
                    ",#INV_AUT_IND_EN_LINEA_SCLM" + ",#INV_AUT_IND_HOMO_MET" + ",#INV_AUT_COD_APUESTA" +
                    //",#INV_AUT_VLR_CARTON" +
                    ",#INV_AUT_EST_UBI_MET" + ",#INV_AUT_LAT_ESTA" + ",#INV_AUT_LONG_ESTA" +
                    ",#INV_AUT_ESTA_DIR_LOCAL_OPER" + ",#INV_AUT_ESTA_SERIAL_REP_OPER" +
                    //",#INV_AUT_FECHA_REGISTRO" +
                    ",#INV_AUT_MOV_SOL_CODIGO" + ",#INV_AUT_SOL_CODIGO)");
                System.out.println(sql.toString());
                Query query = manager.createNativeQuery(sql.toString());

                /* query.setParameter("INV_AUT_MOD_JUEGO", object.getModalidadJuego()==null?"":object.getModalidadJuego());
                query.setParameter("INV_AUT_NIT_OPER", object.getNitOperador()==null?"":object.getNitOperador());
                query.setParameter("INV_AUT_CONT_OPER", object.getContratoOperador()==null?"":object.getContratoOperador());
                query.setParameter("INV_AUT_DIR", object.getDireccion()==null?"":object.getDireccion());
                query.setParameter("INV_AUT_TEL", object.getTelefono()==null?"":object.getTelefono());
                query.setParameter("INV_AUT_EMAIL", object.getEmail()==null?"":object.getEmail());
                query.setParameter("INV_AUT_COD_DANE_MUN", object.getMunicipioDane()==null?"":object.getMunicipioDane());
                //---query.setParameter("INV_AUT_COD_LOCAL", object.getCodigoLocal()==null?"":object.getCodigoLocal());
                query.setParameter("INV_AUT_NOM_LOCAL" , object.getNombreLocal()==null?"":object.getNombreLocal());

                query.setParameter("INV_AUT_TIP_INST" , object.getTipoElemento()==null?new BigDecimal(0):object.getTipoElemento());
                query.setParameter("INV_AUT_TIP_JUEGO" , object.getTipoJuego()==null?new BigDecimal(0):object.getTipoJuego());
                query.setParameter("INV_AUT_IUC" , object.getIdColjuegosMet()==null?new BigDecimal(0):object.getIdColjuegosMet());

                query.setParameter("INV_AUT_NUID" , object.getIdUnicaDigitalNUID()==null?"":object.getIdUnicaDigitalNUID());
                query.setParameter("INV_AUT_SERIAL" , object.getSerialMET()==null?"":object.getSerialMET());

                query.setParameter("INV_AUT_NUM_FAB", object.getNumeroRegFabrcanteMET()==null?new BigDecimal(0):object.getNumeroRegFabrcanteMET());
                query.setParameter("INV_AUT_COD_MARCA" , object.getCodMarca()==null?new BigDecimal(0):object.getCodMarca());
                query.setParameter("INV_AUT_COD_MODELO" , object.getCodModelo()==null?new BigDecimal(0):object.getCodModelo());
                //query.setParameter("INV_AUT_ANO_FAB" , object.getAnoFrabicacion()==null?new BigDecimal(0):object.getAnoFrabicacion());
                //query.setParameter("INV_AUT_NUM_REG_SCLM" , null);
                query.setParameter("INV_AUT_IND_EN_LINEA_SCLM" , object.getIndicadorConexionLinea()==null?new BigDecimal(0):object.getIndicadorConexionLinea());
                query.setParameter("INV_AUT_IND_HOMO_MET" , object.getIndicadorMETHomologada()==null?new BigDecimal(0):object.getIndicadorMETHomologada());
                query.setParameter("INV_AUT_COD_APUESTA" , object.getCodigoApuesta()==null?new BigDecimal(0):object.getCodigoApuesta());
                //query.setParameter("INV_AUT_VLR_CARTON" , object.getValorCarton());
                query.setParameter("INV_AUT_EST_UBI_MET" , object.getEstadoUbicacionInstrumento()==null?new BigDecimal(0):object.getEstadoUbicacionInstrumento());

                query.setParameter("INV_AUT_LAT_ESTA" , object.getLatitudEstablecimiento()==null?"":object.getLatitudEstablecimiento());
                query.setParameter("INV_AUT_LONG_ESTA" , object.getLongitudEstablecimiento()==null?"":object.getLongitudEstablecimiento());

                query.setParameter("INV_AUT_ESTA_DIR_LOCAL_OPER" , object.getEstadoDireccion()==null?"":object.getEstadoDireccion());
                query.setParameter("INV_AUT_ESTA_SERIAL_REP_OPER" , object.getEstadoSerial()==null?"":object.getEstadoSerial());

                //query.setParameter("INV_AUT_FECHA_REGISTRO", );
                query.setParameter("INV_AUT_MOV_SOL_CODIGO", object.getNumMovimiento()==null?new BigDecimal(0):object.getNumMovimiento());
                query.setParameter("INV_AUT_SOL_CODIGO", object.getNumSolicitudSiito()==null?"":object.getNumSolicitudSiito());
                query.executeUpdate();*/

            }
            return resultado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }


    public EstablecimientoWSVO consultarOperador(String numSolSIITO) throws ExcepcionDAO {

        EstablecimientoWSVO retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select * from dbo.SIITO_MOV_CARGUE_INVENTARIO inv where inv.MOV_SOL_CODIGO = #numSolSIITO");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("numSolSIITO", numSolSIITO);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                retorno = new EstablecimientoWSVO();

                //retorno.estCodigo = 1L;
                retorno.estCodigo = "";
                retorno.estCodInterno = "";
                retorno.estDireccion = "";
                retorno.ubicacionVo = new UbicacionWSVO();
                retorno.operador = new OperadorWSVO();
                retorno.estNombre = "";
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaWSDAO");
        }
        return retorno;
    }

    public EstablecimientoWSVO consultarEstablecimiento(String numSolSIITO) throws ExcepcionDAO {
        EstablecimientoWSVO retorno = new EstablecimientoWSVO();
        try {
            StringBuilder sql = new StringBuilder();
            //sql.append(" select * from dbo.SIITO_MOV_CARGUE_INVENTARIO inv where inv.MOV_SOL_CODIGO = #numSolSIITO ");
            sql.append(" SELECT TOP 1 ");
            sql.append(" MOV_CARGUE_INV_NIT, ");
            sql.append(" MOV_CARGUE_INV_CONT, ");
            sql.append(" MOV_CARGUE_INV_COD_LOCAL, ");
            sql.append(" MOV_CARGUE_INV_NOM_LOCAL, ");
            sql.append(" MOV_CARGUE_INV_COD_MUN_LOC, ");
            sql.append(" CONCAT(MOV_CARGUE_INV_DIR_DESC,MOV_CARGUE_INV_DIR_NUM_VIA_P,MOV_CARGUE_INV_DIR_SUFI_VIA_P, ");
            sql.append(" MOV_CARGUE_INV_DIR_SEC_CIU,MOV_CARGUE_INV_DIR_NUM_VIA_G,MOV_CARGUE_INV_DIR_SUFI_VIA_G,MOV_CARGUE_INV_DIR_NUM_PRE, ");
            sql.append(" MOV_CARGUE_INV_DIR_INFO_ADI,MOV_CARGUE_INV_DIR_VIA_PRI_COD) as direccion, ");
            sql.append(" MOV_CARGUE_INV_COD_LOCAL_DEST, ");
            sql.append(" MOV_CARGUE_INV_COD_MUN_LOC_DEST ");
            sql.append(" FROM DB_SIITO_P.dbo.SIITO_MOV_CARGUE_INVENTARIO WHERE MOV_SOL_CODIGO = #numSolSIITO ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("numSolSIITO", numSolSIITO);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {

                OperadorWSVO operador = new OperadorWSVO();
                ContratoWSVO contrato = new ContratoWSVO();

                retorno.estCodInterno = (String) object[2];
                retorno.estCodigo = ((String) object[4]);
                retorno.estDireccion = (String) object[5];
                retorno.estNombre = (String) object[3];
                contrato.conNumero = (String) object[1];
                operador.contrato = contrato;
                retorno.operador = operador;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudAutorizaWSDAO");
        }
        return retorno;
    }

}
