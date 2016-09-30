package co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOperadoresPSE;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE.PagoOperadoresPseVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
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
public class PagoOperadoresPseDAO {
    
    @PersistenceContext(unitName = "psePU")
    private EntityManager manager;
    private Recursos recursos;
    
    public PagoOperadoresPseDAO() {
        recursos = new Recursos();
    }
    
    public List<PagoOperadoresPseVO> buscarTodoDiaAnteriorPagoPse(Date fechaActual) throws ExcepcionDAO {

        //----Para ejecucion manual ----------------
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaActual);
        cal.add(Calendar.DATE, 1);
        Date date=cal.getTime();
        DateFormat fechas = new SimpleDateFormat("yyyyMMdd");
        String fechafin = fechas.format(date);
        String fechaini = fechas.format(fechaActual);
       //--------------
        List<PagoOperadoresPseVO> listaRecaudoPse= new ArrayList<PagoOperadoresPseVO>();
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("            select id,FechaInicio,ValorPagado,CodigoTransaccion,SUBSTRING(Referencia1,0,13) as RefDerechos,SUBSTRING(Referencia1,14,12) as RefGastos from (\n" + 
            "            select p.id, \n" + 
            "            (case when  Fechaestado > FechaInicio then FechaInicio else Fechaestado end )as FechaInicio ,ValorPagado,CodigoTransaccion, TransaccionPagoEstado,\n" + 
            "            p.Referencia1 \n" + 
            "            from BotonPagosPSE p\n" + 
            "            )sub1\n" + 
            "            where TransaccionPagoEstado=1 and FechaInicio BETWEEN '" + fechaini + "' and '" + fechafin +"' ");
            
 
            Query query = manager.createNativeQuery(sql.toString());   
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
               PagoOperadoresPseVO pagoOperadoresPseVo= new PagoOperadoresPseVO();
               pagoOperadoresPseVo.setRpsCodigo(((Integer) object[0]).longValue());
               Date fecha=(Date) object[1];
             //  SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               // try {
               //     java.util.Date d = sdf.parse(fecha);
                    pagoOperadoresPseVo.setRpsFechaEstado(fecha);
               // } catch (ParseException e) {
               // }
               pagoOperadoresPseVo.setValorPagado((BigDecimal) object[2]);
               pagoOperadoresPseVo.setRpsCodigoTrans((String) object[3]);
               pagoOperadoresPseVo.setRpsReferencia1((String) object[4]);
               pagoOperadoresPseVo.setRpsReferencia2((String) object[5]);

            
                listaRecaudoPse.add(pagoOperadoresPseVo);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRecaudoPse;
    }
    
    
    
    
    
    
    
}
