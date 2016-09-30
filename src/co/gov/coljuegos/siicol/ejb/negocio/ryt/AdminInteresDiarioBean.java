package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;

import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminInteresDiarioBean implements AdminInteresDiario {
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    InteresCuotaDAO interesCuotaDao;
    @EJB
    DocumentoContableDAO documentoContableDAO;
    
    public AdminInteresDiarioBean() {
       
    }
    
    public InteresCuotaVO insertarInteresCuota(InteresCuotaVO interesVo) throws ExcepcionDAO {
        SiiInteresCuota siiInteresCuota = conversionVoEntidad.convertir(interesVo);
        SiiInteresCuota siiInteresCuotaResult = interesCuotaDao.insertarSiiInteresCuota(siiInteresCuota);
        
        return new InteresCuotaVO(siiInteresCuotaResult);    
    }

    public Integer buscarConsecutivoDocumento(String tipoDoc) throws ExcepcionDAO {
        return documentoContableDAO.buscarConsecutivoDocumentoContable(tipoDoc);
    }
    
    public List<ValidacionInteresVO>  BuscarInteresTotal(String fechaCorte) throws ExcepcionDAO{ 
        Calendar cal = new GregorianCalendar();
        String fechaFin;
        String mesAño= fechaCorte.substring(1,8);
        fechaFin= cal.getActualMaximum(Calendar.DAY_OF_MONTH)+mesAño;
       List<ValidacionInteresVO> listaValidacionInteresVo=  interesCuotaDao.buscarInteresTotal(fechaCorte,fechaFin);
      /* for (ValidacionInteresVO unValidacionInteresVo: listaValidacionInteresVo){
           
           for(int i=0;        cal.getActualMaximum(Calendar.DAY_OF_MONTH)> i;i++ ){
               String fechaDia= Integer.toString(i+1)+mesAño;
               ValidacionInteresVO undiaValidacionInteresVo= interesCuotaDao.BuscarPagoXdiaCodigoCuota(unValidacionInteresVo.getCodigoCuota(),fechaDia);
               unValidacionInteresVo.getDiasMes().add(undiaValidacionInteresVo.getDia());
           }
          
       }*/
      
        return listaValidacionInteresVo;
    }
    
}
