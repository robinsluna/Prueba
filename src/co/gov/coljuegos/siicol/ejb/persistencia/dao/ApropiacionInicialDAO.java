/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 11-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.NivelRubroDetFuenteValorVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ApropiacionInicialDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ApropiacionInicialDAO() {
        recursos = new Recursos();
    }

    public SiiApropiacionInicial buscarApropiacionInicialPorId(Long idCodigo) throws ExcepcionDAO {
        SiiApropiacionInicial siiApropiacionInicialRetorno = null;
        try {
            siiApropiacionInicialRetorno = manager.find(SiiApropiacionInicial.class, idCodigo);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiApropiacionInicialRetorno;
    }

    public SiiApropiacionInicial insertarApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) throws ExcepcionDAO {
        try {
            manager.persist(siiApropiacionInicial); //La guarda en el almacen
            manager.flush(); //Pasa a la Bd
            //Retorna la Entidad
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiApropiacionInicial;
    }

    public SiiApropiacionInicial actualizarApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) throws ExcepcionDAO{
        try{
            manager.merge(siiApropiacionInicial);
            manager.flush();
            return siiApropiacionInicial;
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
            }
    }

    public List<SiiApropiacionInicial> buscarTodaApropiacionInicial() throws ExcepcionDAO {
        List<SiiApropiacionInicial> listaEntidadesApropIni = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT apropIni FROM SiiApropiacionInicial apropIni");
            Query query = manager.createQuery(sql.toString());
            listaEntidadesApropIni = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaEntidadesApropIni;
    }

    public List<SiiApropiacionInicial> buscarApropiacionIniPorVigencia(SiiApropiacionInicial siiApropiacionInicial) throws ExcepcionDAO {
        List<SiiApropiacionInicial> listaApropiacionIni = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT apropiacionIni FROM SiiApropiacionInicial apropiacionIni");
            sql.append(" WHERE apropiacionIni.ainVigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", siiApropiacionInicial.getAinVigencia());
            listaApropiacionIni = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaApropiacionIni;
    }

    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigencia(Integer vigencia) throws ExcepcionDAO {
        List<NivelRubroDetFuenteValorVO> listaNivelRubroDetFuenteValorVo = new ArrayList<NivelRubroDetFuenteValorVO>();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" select * from (select");
            sql.append(" Nivel1.Codigo as codigo1,Nivel2.Codigo as codigo2,Nivel3.Codigo as codigo3,Nivel4.Codigo as codigo4,");
            sql.append(" Nivel5.Codigo as codigo5,Nivel6.Codigo as codigo6,Nivel7.Codigo as codigo7,");
            sql.append(" Rubro.Descripcion, Rubro.Interno, Rubro.Tipo_Plan, Nvl(Det_Rubro.Dru_Valor, 0), Det_Rubro.Dru_Codigo,\n");
            sql.append(" Det_Fte_Finan.Dff_Codigo_Recurso, Det_Fte_Finan.Dff_Codigo, Fuente_Finan.Ffi_Codigo_Fuente,");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append(" (case when length(Nivel1.Codigo) = 1 or Nivel1.Codigo is null then '0' || Nivel1.Codigo else Nivel1.Codigo end) as digitNivel1,");
            sql.append(" (case when length(Nivel2.Codigo) = 1 or Nivel2.Codigo is null then '0' || Nivel2.Codigo else Nivel2.Codigo end) as digitNivel2,");
            sql.append(" (case when length(Nivel3.Codigo) = 1 or Nivel3.Codigo is null then '0' || Nivel3.Codigo else Nivel3.Codigo end) as digitNivel3,");
            sql.append(" (case when length(Nivel4.Codigo) = 1 or Nivel4.Codigo is null then '0' || Nivel4.Codigo else Nivel4.Codigo end) as digitNivel4,");
            sql.append(" (case when length(Nivel5.Codigo) = 1 or Nivel5.Codigo is null then '0' || Nivel5.Codigo else Nivel5.Codigo end) as digitNivel5,");
            sql.append(" (case when length(Nivel6.Codigo) = 1 or Nivel6.Codigo is null then '0' || Nivel6.Codigo else Nivel6.Codigo end) as digitNivel6,");
            sql.append(" (case when length(Nivel7.Codigo) = 1 or Nivel7.Codigo is null then '0' || Nivel7.Codigo else Nivel7.Codigo end) as digitNivel7");
            sql.append(" From Pr_Rubro Rubro");
            sql.append(" Left Join Sii_Detalle_Rubro Det_Rubro On Rubro.Vigencia = Det_Rubro.Vigencia And Rubro.Interno = Det_Rubro.Interno");
            sql.append(" Left Join Sii_Dtlle_Fuente_Financiacion Det_Fte_Finan On Det_Rubro.Dff_Codigo = Det_Fte_Finan.Dff_Codigo");
            sql.append(" Left Join Sii_Fuente_Financiacion Fuente_Finan On Fuente_Finan.Ffi_Codigo = Det_Fte_Finan.Ffi_Codigo");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");
            sql.append(" Where Rubro.Vigencia = #vigencia    )");
            sql.append(" order by digitNivel1,digitNivel2,digitNivel3,digitNivel4,digitNivel5,digitNivel6,digitNivel7,Ffi_Codigo_Fuente,Dff_Codigo_Recurso asc");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);

            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                NivelRubroDetFuenteValorVO nrdvVo = new NivelRubroDetFuenteValorVO();
                nrdvVo.setCodigoNive1((String) object[0]); //Nivel 1
                nrdvVo.setCodigoNive2((String) object[1]); //Nivel 2
                nrdvVo.setCodigoNive3((String) object[2]); //Nivel 3
                nrdvVo.setCodigoNive4((String) object[3]); //Nivel 4
                nrdvVo.setCodigoNive5((String) object[4]); //Nivel 5
                nrdvVo.setCodigoNive6((String) object[5]); //Nivel 6
                nrdvVo.setCodigoNive7((String) object[6]); //Nivel 7
                nrdvVo.setDesRubro((String) object[7]); //Descripción Rubro
                nrdvVo.setIdRubro(((BigDecimal) object[8]).longValue()); //Id Rubro
                nrdvVo.setNivelAut((String) object[9]); //Nivel Autorización
                if((BigDecimal) object[10] != null) {
                    nrdvVo.setValor((BigDecimal) object[10]); //Valor
                }
                if((BigDecimal) object[11] != null) {
                    nrdvVo.setIdDetalleRubro(((BigDecimal) object[11]).longValue());
                } //Id Detalle Rubro
                if((BigDecimal) object[12] != null) {
                    nrdvVo.setDtlleFuente(((BigDecimal) object[12]).intValue());
                }
                if((BigDecimal) object[13] != null) { //Código Detalle Fuente Financiación
                    nrdvVo.setIdDetalleFuente(((BigDecimal) object[13]).longValue());
                }
                if((BigDecimal) object[14] != null) { //Id Detalle Fuente Financiación
                    nrdvVo.setFuente(((BigDecimal) object[14]).intValue());
                } //Código Fuente Financiación
                nrdvVo.setCadenaNiveles((String) object[15]);

                listaNivelRubroDetFuenteValorVo.add(nrdvVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return listaNivelRubroDetFuenteValorVo;
    }


    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigenciaFuenteFin(Integer vigencia, String fuenteFin) throws ExcepcionDAO {
        List<NivelRubroDetFuenteValorVO> listaNivelRubroDetFuenteValorVo = new ArrayList<NivelRubroDetFuenteValorVO>();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" select * from (select");
            sql.append(" Nivel1.Codigo as codigo1,Nivel2.Codigo as codigo2,Nivel3.Codigo as codigo3,Nivel4.Codigo as codigo4,");
            sql.append(" Nivel5.Codigo as codigo5,Nivel6.Codigo as codigo6,Nivel7.Codigo as codigo7,");
            sql.append(" Rubro.Descripcion, Rubro.Interno, Rubro.Tipo_Plan, Nvl(Det_Rubro.Dru_Valor, 0), Det_Rubro.Dru_Codigo,\n");
            sql.append(" Det_Fte_Finan.Dff_Codigo_Recurso, Det_Fte_Finan.Dff_Codigo, Fuente_Finan.Ffi_Codigo_Fuente,");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append(" (case when length(Nivel1.Codigo) = 1 or Nivel1.Codigo is null then '0' || Nivel1.Codigo else Nivel1.Codigo end) as digitNivel1,");
            sql.append(" (case when length(Nivel2.Codigo) = 1 or Nivel2.Codigo is null then '0' || Nivel2.Codigo else Nivel2.Codigo end) as digitNivel2,");
            sql.append(" (case when length(Nivel3.Codigo) = 1 or Nivel3.Codigo is null then '0' || Nivel3.Codigo else Nivel3.Codigo end) as digitNivel3,");
            sql.append(" (case when length(Nivel4.Codigo) = 1 or Nivel4.Codigo is null then '0' || Nivel4.Codigo else Nivel4.Codigo end) as digitNivel4,");
            sql.append(" (case when length(Nivel5.Codigo) = 1 or Nivel5.Codigo is null then '0' || Nivel5.Codigo else Nivel5.Codigo end) as digitNivel5,");
            sql.append(" (case when length(Nivel6.Codigo) = 1 or Nivel6.Codigo is null then '0' || Nivel6.Codigo else Nivel6.Codigo end) as digitNivel6,");
            sql.append(" (case when length(Nivel7.Codigo) = 1 or Nivel7.Codigo is null then '0' || Nivel7.Codigo else Nivel7.Codigo end) as digitNivel7");
            sql.append(" From Pr_Rubro Rubro");
            sql.append(" Left Join Sii_Detalle_Rubro Det_Rubro On Rubro.Vigencia = Det_Rubro.Vigencia And Rubro.Interno = Det_Rubro.Interno");
            sql.append(" Left Join Sii_Dtlle_Fuente_Financiacion Det_Fte_Finan On Det_Rubro.Dff_Codigo = Det_Fte_Finan.Dff_Codigo");
            sql.append(" Left Join Sii_Fuente_Financiacion Fuente_Finan On Fuente_Finan.Ffi_Codigo = Det_Fte_Finan.Ffi_Codigo");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");
            sql.append(" Where Rubro.Vigencia = #vigencia and nivel1.codigo=2 and Dru_Valor>0");
            if(fuenteFin != null)
                sql.append("and fuente_finan.ffi_descripcion=#fuenteFin)");
            else
                sql.append(")");
            sql.append(" order by digitNivel1,digitNivel2,digitNivel3,digitNivel4,digitNivel5,digitNivel6,digitNivel7,Ffi_Codigo_Fuente,Dff_Codigo_Recurso asc");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);
            query.setParameter("fuenteFin", fuenteFin);

            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                NivelRubroDetFuenteValorVO nrdvVo = new NivelRubroDetFuenteValorVO();
                nrdvVo.setCodigoNive1((String) object[0]); //Nivel 1
                nrdvVo.setCodigoNive2((String) object[1]); //Nivel 2
                nrdvVo.setCodigoNive3((String) object[2]); //Nivel 3
                nrdvVo.setCodigoNive4((String) object[3]); //Nivel 4
                nrdvVo.setCodigoNive5((String) object[4]); //Nivel 5
                nrdvVo.setCodigoNive6((String) object[5]); //Nivel 6
                nrdvVo.setCodigoNive7((String) object[6]); //Nivel 7
                nrdvVo.setDesRubro((String) object[7]); //Descripción Rubro
                nrdvVo.setIdRubro(((BigDecimal) object[8]).longValue()); //Id Rubro
                nrdvVo.setNivelAut((String) object[9]); //Nivel Autorización
                if((BigDecimal) object[10] != null) {
                    nrdvVo.setValor((BigDecimal) object[10]); //Valor
                }
                if((BigDecimal) object[11] != null) {
                    nrdvVo.setIdDetalleRubro(((BigDecimal) object[11]).longValue());
                } //Id Detalle Rubro
                if((BigDecimal) object[12] != null) {
                    nrdvVo.setDtlleFuente(((BigDecimal) object[12]).intValue());
                }
                if((BigDecimal) object[13] != null) { //Código Detalle Fuente Financiación
                    nrdvVo.setIdDetalleFuente(((BigDecimal) object[13]).longValue());
                }
                if((BigDecimal) object[14] != null) { //Id Detalle Fuente Financiación
                    nrdvVo.setFuente(((BigDecimal) object[14]).intValue());
                } //Código Fuente Financiación
                nrdvVo.setCadenaNiveles((String) object[15]);

                listaNivelRubroDetFuenteValorVo.add(nrdvVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return listaNivelRubroDetFuenteValorVo;
    }


}
