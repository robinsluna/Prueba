package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionResultVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CuentasContablesDAO  {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CuentasContablesDAO() {
        
        recursos = new Recursos();}
    
    public List<ImputacionResultVO> buscarCuentasPorCodigosConceptos(List<Long> codigosConceptos) throws ExcepcionDAO {
        
        try {
            int size = codigosConceptos.size();
            
            StringBuilder sql = new StringBuilder();
            Query query = manager.createNativeQuery(sql.toString());
                sql.append("SELECT CCO_NIVEL1|| \'.\' ||CCO_NIVEL2|| \'.\' ||CCO_NIVEL3|| \'.\' ||CCO_NIVEL4|| \'.\' ||CCO_NIVEL5 as cuenta, "); 
                sql.append("CCO_DESCRIPCION, "); 
                sql.append("CASE WHEN CCO_CENTRO_COST = 'N' THEN 'NO' else 'SI'  end as ccosto, "); 
                sql.append("CASE WHEN CCO_FTE_FINANC = 'N' THEN 'NO' else 'SI'  end as fuente, "); 
                sql.append("CASE WHEN CCO_REFERENCIA_1 = 'N' THEN 'NO' else 'SI'  end as ref1, "); 
                sql.append("CASE WHEN CCO_REFERENCIA_2 = 'N' THEN 'NO' else 'SI'  end as ref2, "); 
                sql.append("CCO_NATURALEZA,'' "); 
                sql.append("FROM SII_CUENTAS_CONTABLES ");
            
            if(size == 1){
                sql.append("where cco_codigo = #codigosConceptos");
                query = manager.createNativeQuery(sql.toString());
                query.setParameter("codigosConceptos", codigosConceptos.get(0));
            }else{
                int cont = 0;
                for(Long unConcepto: codigosConceptos){
                    if (cont == 0){
                        sql.append("where cco_codigo = #codigosConceptos"+cont);
                        cont++;
                    }else{
                        sql.append(" OR cco_codigo = #codigosConceptos"+cont);
                        cont++;
                    }
                }
                query = manager.createNativeQuery(sql.toString());
                cont = 0;
                for(Long unConcepto: codigosConceptos){
                        query.setParameter("codigosConceptos"+cont, unConcepto);
                        cont++;
                }
            }
            
            
            List<Object[]> cuentas = query.getResultList();
            
            List<ImputacionResultVO> resultado = new ArrayList();
            
            for(Object[] nObject: cuentas){
                ImputacionResultVO imp = new ImputacionResultVO();
                imp.setCuenta((String)nObject[0]);
                imp.setNombreCuenta((String)nObject[1]);
                imp.setCentroCosto((String)nObject[2]);
                imp.setFuenteFinanciacion((String)nObject[3]);
                imp.setRef1((String)nObject[4]);
                imp.setRef2((String)nObject[5]);
                imp.setNaturaleza((String)nObject[6]);
                //imp.setValor((String)nObject[7]);
                    
                resultado.add(imp);
            }

            return resultado;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicitudPagoDAO");
        }
    
    }
    
    public SiiCuentasContables buscarPorCodigo(Long idCodigo) throws ExcepcionDAO {
        SiiCuentasContables cuentaRetorno = null;
        try {
            cuentaRetorno = manager.find(SiiCuentasContables.class, idCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
        return cuentaRetorno;

    }
    
    public SiiCuentasContables insertarSiiCuentasContables(SiiCuentasContables cuenta) throws ExcepcionDAO {
        try {
            manager.persist(cuenta); 
            manager.flush(); 
            return cuenta; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
    }
    
    public SiiCuentasContables actualizarSiiCuentasContables(SiiCuentasContables adenda) throws ExcepcionDAO {
        try {
            manager.merge(adenda); 
            manager.flush(); 
            return adenda; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
    }
    public void borrar(Long idCodigo) throws ExcepcionDAO {
        SiiCuentasContables cuentaBorrar = null;
        try {
            cuentaBorrar = manager.find(SiiCuentasContables.class, idCodigo);
            manager.remove(cuentaBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
    }
    
    
    /**
     * Consulta el listado de Cuentas Contables de las cuales se desagrega la cuenta contable hija especificada, de acuerdo a la jerarqu&iacute;a de niveles.
     *   Ejemplo: Cuenta hija: 1.1.03.02  => Cuentas padre: {1, 1.1, 1.1.02}
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable hija.
     * @return List of SiiCuentasContables
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarCuentasContablesPadre (Long ccoCodigo) throws ExcepcionDAO 
    {
        List<SiiCuentasContables> resultado = null;
        
        try {
            StringBuffer sql = new StringBuffer();
            
            String encabezado = "SELECT  cc.CCO_CODIGO, \n" + 
            "        TO_CHAR(cc.CCO_NIVEL1) ||\n" + 
            "            (case when cc.CCO_NIVEL2 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL2) end) ||\n" + 
            "            (case when cc.CCO_NIVEL3 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL3) end) ||\n" + 
            "            (case when cc.CCO_NIVEL4 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL4) end) ||\n" + 
            "            (case when cc.CCO_NIVEL5 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL5) end) AS CUENTA_CONTABLE, \n" + 
            "        cc.CCO_NIVEL1, \n" + 
            "        cc.CCO_NIVEL2, \n" + 
            "        cc.CCO_NIVEL3, \n" + 
            "        cc.CCO_NIVEL4, \n" + 
            "        cc.CCO_NIVEL5 \n" + 
            "FROM SII_CUENTAS_CONTABLES cc, \n" + 
            "    (SELECT cco.CCO_NIVEL1, cco.CCO_NIVEL2, cco.CCO_NIVEL3, cco.CCO_NIVEL4, cco.CCO_NIVEL5 \n" + 
            "    FROM SII_CUENTAS_CONTABLES cco \n" + 
            "    WHERE cco.CCO_CODIGO = #ccoCodigo) Y\n";
            
            sql.append(encabezado);
            sql.append("WHERE   cc.CCO_NIVEL1 = Y.CCO_NIVEL1 "); 
            sql.append("AND     cc.CCO_NIVEL2 = Y.CCO_NIVEL2 "); 
            sql.append("AND     cc.CCO_NIVEL3 = Y.CCO_NIVEL3 "); 
            sql.append("AND     cc.CCO_NIVEL4 = Y.CCO_NIVEL4 "); 
            sql.append("AND     cc.CCO_NIVEL5 IS NULL "); 
            sql.append("AND     cc.CCO_CODIGO <> #ccoCodigo "); 
            sql.append("UNION ");

            sql.append(encabezado);
            sql.append("WHERE   cc.CCO_NIVEL1 = Y.CCO_NIVEL1 ");
            sql.append("AND     cc.CCO_NIVEL2 = Y.CCO_NIVEL2 ");
            sql.append("AND     cc.CCO_NIVEL3 = Y.CCO_NIVEL3 "); 
            sql.append("AND     cc.CCO_NIVEL4 IS NULL "); 
            sql.append("AND     cc.CCO_NIVEL5 IS NULL ");
            sql.append("AND     cc.CCO_CODIGO <> #ccoCodigo "); 
            sql.append("UNION ");
            
            sql.append(encabezado);
            sql.append("WHERE   cc.CCO_NIVEL1 = Y.CCO_NIVEL1 "); 
            sql.append("AND     cc.CCO_NIVEL2 = Y.CCO_NIVEL2 "); 
            sql.append("AND     cc.CCO_NIVEL3 IS NULL "); 
            sql.append("AND     cc.CCO_NIVEL4 IS NULL "); 
            sql.append("AND     cc.CCO_NIVEL5 IS NULL "); 
            sql.append("AND     cc.CCO_CODIGO <> #ccoCodigo ");
            sql.append("UNION ");
            
            sql.append(encabezado);
            sql.append("WHERE   cc.CCO_NIVEL1 = Y.CCO_NIVEL1 "); 
            sql.append("AND     cc.CCO_NIVEL2 IS NULL ");
            sql.append("AND     cc.CCO_NIVEL3 IS NULL "); 
            sql.append("AND     cc.CCO_NIVEL4 IS NULL "); 
            sql.append("AND     cc.CCO_NIVEL5 IS NULL "); 
            sql.append("AND     cc.CCO_CODIGO <> #ccoCodigo ");
            
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("ccoCodigo", ccoCodigo);
            
            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                resultado = new ArrayList<SiiCuentasContables>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        Long idCuentaContable = ((BigDecimal) row[0]).longValue();
                        // buscar la cuenta contable a traves del codigo
                        SiiCuentasContables siiCuentasContables = this.buscarPorCodigo(idCuentaContable);
                        if (siiCuentasContables!=null)
                            resultado.add(siiCuentasContables);
                    }
                }
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta de TODAS las Cuentas Contables.
     * @return List of SiiCuentasContables.
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarTodoCuentasContables () throws ExcepcionDAO {
        List<SiiCuentasContables> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCuentasContables o ");
            sql.append("ORDER BY o.ccoNivel1, o.ccoNivel2, o.ccoNivel3, o.ccoNivel4, o.ccoNivel5 ");
            
            Query query = manager.createQuery(sql.toString());
            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }


    public List<SiiCuentasContables> buscarCuentasPorNaturalezaYDocumentoContable(String naturaleza,
                                                                                            String docContable) throws ExcepcionDAO {
        List<SiiCuentasContables> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            Query query = null;
            sql.append("SELECT o FROM SiiCuentasContables o  WHERE o.ccoCodigo IN ");
            sql.append("( SELECT p.siiCuentasContables.ccoCodigo FROM SiiCuentaContTipoDocCont p WHERE p.siiTipoDocContable.tdcCodigo = :docContable )");
            if(naturaleza != null){
                sql.append(" and o.ccoNaturaleza = :naturaleza ");
                query = manager.createQuery(sql.toString());
                query.setParameter("docContable",docContable); 
                query.setParameter("naturaleza",naturaleza);
            }else{
                query = manager.createQuery(sql.toString());
                query.setParameter("docContable",docContable); 
            }
            
            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    public SiiCuentasContables BuscarCuentaContableXCuentaBancaria (Long idCuentaBancaria) throws ExcepcionDAO{ 
        SiiCuentasContables siiCuentasContables= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cb from  SiiCuentaBancaria cc");
            sql.append(" inner join cc.siiCuentasContables cb");
            sql.append(" where cc.cbaCodigo= :idCuentaBancaria ");
          
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCuentaBancaria", idCuentaBancaria);
          
             List<SiiCuentasContables>  listaSiiCuentasContables = query.getResultList();  
            
            if (listaSiiCuentasContables != null && !listaSiiCuentasContables.isEmpty()) {
                siiCuentasContables = listaSiiCuentasContables.get(0);
            }

            
            return siiCuentasContables;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SiiCuentasContablesDAO");
        }
      
    
    }
    
    
    
    /**
     * Realiza la consulta de las Cuentas Contables cuyo n&uacute;mero de cuenta se encuentre dentro del rango de cuentas especificado.
     * @param cuentaInicial - Cuenta Inicial.
     * @param cuentaFinal - Cuenta Final.
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarPorRangoCuentas (String cuentaInicial, String cuentaFinal) throws ExcepcionDAO {
        List<SiiCuentasContables> resultado = null;
        
        if (cuentaInicial!=null && cuentaFinal!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT Y.CCO_CODIGO, "); 
                sql.append("       Y.CUENTA_CONTABLE, ");
                sql.append("       Y.CCO_DESCRIPCION ");
                sql.append("FROM (  SELECT  cc.CCO_CODIGO,  "); 
                sql.append("                TO_CHAR(cc.CCO_NIVEL1) ||   "); 
                sql.append("                    (case when cc.CCO_NIVEL2 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL2) end) ||   "); 
                sql.append("                    (case when cc.CCO_NIVEL3 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL3) end) ||   "); 
                sql.append("                    (case when cc.CCO_NIVEL4 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL4) end) ||   "); 
                sql.append("                    (case when cc.CCO_NIVEL5 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL5) end) AS CUENTA_CONTABLE, "); 
                sql.append("                cc.CCO_DESCRIPCION "); 
                sql.append("        FROM SII_CUENTAS_CONTABLES cc "); 
                sql.append("        ORDER BY cc.CCO_CODIGO) Y "); 
                sql.append("WHERE Y.CUENTA_CONTABLE BETWEEN #cuentaInicial AND #cuentaFinal ");
                
                
                Query query = manager.createNativeQuery(sql.toString());
                query.setParameter("cuentaInicial", cuentaInicial);
                query.setParameter("cuentaFinal", cuentaFinal);
                
                
                List<Object[]> rows = query.getResultList();
                
                if (rows!=null) {
                    resultado = new ArrayList<SiiCuentasContables>();
                    
                    for (Object[] row: rows) {
                        if (row[0]!=null) {
                            Long idCuentaContable = ((BigDecimal) row[0]).longValue();
                            // buscar la cuenta contable a traves del codigo
                            SiiCuentasContables siiCuentasContables = this.buscarPorCodigo(idCuentaContable);
                            if (siiCuentasContables!=null)
                                resultado.add(siiCuentasContables);
                        }
                    }
                }
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Cuentas Contables que se encuentran relacionadas a la Fuente de Financiaci&oacute;n Contable especificada.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiCuentasContables
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarCuentasPorFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO {
        List<SiiCuentasContables> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            if (ffcCodigo!=null) {
                sql.append("SELECT cco FROM SiiCuentasContables cco ");
                sql.append("INNER JOIN SiiCuentaContTipoDocCont cct  ON  cct.siiCuentasContables.ccoCodigo = cco.ccoCodigo ");
                sql.append("WHERE cct.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("ffcCodigo", ffcCodigo);
                
                resultado = query.getResultList();
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }

    
    public SiiCuentasContables BuscarCuentaContablesXGrecaudo (Integer grupoRecaudo) throws ExcepcionDAO{ 
        SiiCuentasContables siiCuentasContables= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cc from  SiiCuentasContables cc");
            sql.append(" inner join cc.siiCuentaBancariaList cb");
            sql.append(" where cb.cbaGrupoRecaudo = :grupoRecaudo ");
          
            Query query = manager.createQuery(sql.toString());
            query.setParameter("grupoRecaudo", grupoRecaudo);
          
             List<SiiCuentasContables>  listaSiiCuentasContables = query.getResultList();  
            
            if (listaSiiCuentasContables != null && !listaSiiCuentasContables.isEmpty()) {
                siiCuentasContables = listaSiiCuentasContables.get(0);
            }

            
            return siiCuentasContables;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SiiCuentasContablesDAO");
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Excepcion DAO : " + ex.getMessage(),"SiiCuentasContablesDAO");
        }
      
    
    }
    

    
    
    
    /**
     * Realiza la consulta de las Cuentas Contables asociadas a Conceptos Cuota en la Categor&iacute;a de Distribuci&oacute;n especificada.
     * @param cadCodigo - C&oacute;digo de la Categor&iacute;a de Distribuci&oacute;n (Modalidad del Concepto Cuota).
     * @return List of SiiCuentasContables.
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarCuentasContablesPorCategoriaDistribucion (Long cadCodigo) throws ExcepcionDAO
    {
        List<SiiCuentasContables> resultado = null;
        
        try {
            if (cadCodigo!=null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cco FROM SiiCuentasContables cco ");
                sql.append("WHERE EXISTS (SELECT null FROM SiiConceptoCuota ccu, SiiCtaContabConcepCuota ccc, SiiCategoriaDistrib cad ");
                sql.append("              WHERE ccc.siiCuentasContables.ccoCodigo = cco.ccoCodigo ");
                sql.append("              AND ccu.ccuCodigo = ccc.siiConceptoCuota.ccuCodigo ");
                sql.append("              AND ccu.siiCategoriaDistrib.cadCodigo = cad.cadCodigo ");
                sql.append("              AND cad.cadCodigo = :cadCodigo) ");
                
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("cadCodigo", cadCodigo);
                
                resultado = query.getResultList();
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }

    
    
    /**
     * Realiza la b&uacute;squeda de la Cuenta Contable asociada a la cadena de niveles especificada.
     * @param cadenaNiveles - Cadena de Niveles (<i>Ejemplo: 2.4.25.26.01</i>).
     * @return Instance of SiiCuentasContables.
     * @throws ExcepcionDAO
     */
    public SiiCuentasContables buscarPorCadenaNiveles (String cadenaNiveles) throws ExcepcionDAO 
    {
        SiiCuentasContables siiCuentasContables = null;
        
        if (cadenaNiveles!=null) {
            // calcular el numero de niveles
            StringTokenizer tokenizer = new StringTokenizer(cadenaNiveles, ".");
            int numeroNiveles = tokenizer.countTokens();
            
            // validar que las cuenta contable contenga entre 1 y 'MAX_CANTIDAD_NIVELES_CCO' niveles
            if (numeroNiveles>0 && numeroNiveles<=CuentasContablesVO.MAX_CANTIDAD_NIVELES_CCO) {
                String cadenaBusqueda = "WHERE ";
                for (int i=1; i<=numeroNiveles; i++) {
                    cadenaBusqueda += "cco_nivel"+i;
                    if (i<numeroNiveles)
                        cadenaBusqueda += "||'.'||";
                }
                cadenaBusqueda += " = #cadenaNiveles ";
                
                if (numeroNiveles<CuentasContablesVO.MAX_CANTIDAD_NIVELES_CCO) {
                    for (int i=numeroNiveles+1; i<=CuentasContablesVO.MAX_CANTIDAD_NIVELES_CCO; i++) {
                        cadenaBusqueda += "AND cco_nivel"+i+" IS NULL ";
                    }
                }
                
                try {
                    StringBuilder sql = new StringBuilder();
                    sql.append("SELECT  cco_codigo "); 
                    sql.append("FROM SII_CUENTAS_CONTABLES cco ");
                    sql.append(cadenaBusqueda);
                    
                    Query query = manager.createNativeQuery(sql.toString());
                    query.setParameter("cadenaNiveles", cadenaNiveles);
                    
                    BigDecimal result = (BigDecimal) query.getSingleResult();
                    if (result!=null) {
                        Long ccoCodigo = result.longValueExact();
                        siiCuentasContables = this.buscarPorCodigo(ccoCodigo);
                    }
                }
                catch (NoResultException e) {
                    siiCuentasContables = null;
                }
                catch (PersistenceException pe) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
                }
            }
        }
        
        return (siiCuentasContables);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de Cuentas Contables Acreedoras que se encuentran relacionadas a la Fuente de Financiaci&oacute;n Contable especificada.
     * @return List of SiiCuentasContables
     * @throws ExcepcionDAO
     */
    public List<SiiCuentasContables> buscarCuentasContablesAcreedoras() throws ExcepcionDAO {
        List<SiiCuentasContables> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT cco FROM SiiCuentasContables cco ");
            sql.append("WHERE cco.ccoCtaAcreedora = :ccoCtaAcreedora and cco.ccoNivel5 is not null ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ccoCtaAcreedora", EnumDecision.SI.getId());
            
            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
