package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleCorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CorteCarteraVO;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCorteCarteraBean implements AdminCorteCartera{
    
    @EJB
    private CorteCarteraDAO corteCarteraDao;
    @EJB
    private DetalleCorteCarteraDAO detalleCorteCarteraDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminCorteCarteraBean() {
    }
    
    public CorteCarteraVO buscarCorteCarteraPorVigenciaPorMes(int vigencia, int mes) throws ExcepcionDAO{
        CorteCarteraVO corteCarteraVo = null;
        SiiCorteCartera siiCorteCartera = corteCarteraDao.buscarCorteCarteraPorVigenciaPorMes(vigencia, mes);
        if(siiCorteCartera != null){
            corteCarteraVo = new CorteCarteraVO(siiCorteCartera);
        }
        return corteCarteraVo;
    }
    
    public CorteCarteraVO insertarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO{
        SiiCorteCartera siiCorteCartera = conversionVoEntidad.convertir(corteCarteraVo);
        siiCorteCartera = corteCarteraDao.insertarCorteCartera(siiCorteCartera);
        return new CorteCarteraVO(siiCorteCartera);
    }
    
    public CorteCarteraVO actualizarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO{
        SiiCorteCartera siiCorteCartera = conversionVoEntidad.convertir(corteCarteraVo);
        siiCorteCartera = corteCarteraDao.actualizarCorteCartera(siiCorteCartera);
        return new CorteCarteraVO(siiCorteCartera);
    }
    
    public CorteCarteraVO buscarCorteCarteraPorId(Long idCorteCartera) throws ExcepcionDAO{
        CorteCarteraVO corteCarteraVo = null;
        SiiCorteCartera siiCorteCartera = corteCarteraDao.buscarCorteCarteraPorId(idCorteCartera);
        if(siiCorteCartera != null){
            corteCarteraVo = new CorteCarteraVO(siiCorteCartera);
        }
        return corteCarteraVo;
    }
    
    public void realizarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO{
        int vigencia = corteCarteraVo.getCcaVigencia();
        MesVO mesVo = corteCarteraVo.getMesVo();
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,vigencia);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH,mesVo.getMesCodigo() - 1);  //Está basado en 0
        cal.add(Calendar.MONTH, 1); //Siguiente mes a la 0 horas
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date fechaCorte = cal.getTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(formatter.format(fechaCorte));
        
        corteCarteraVo.setCcaVigencia(null);
        corteCarteraVo.setMesVo(null);
        corteCarteraVo.setCcaFecha(new Date());
        //SiiCorteCartera siiCorteCartera = conversionVoEntidad.convertir(corteCarteraVo);
        corteCarteraVo = insertarCorteCartera(corteCarteraVo);
        detalleCorteCarteraDao.crearDetallesCorte(corteCarteraVo.getCcaCodigo(), fechaCorte);
        corteCarteraVo.setMesVo(mesVo);
        corteCarteraVo.setCcaVigencia(vigencia);
        corteCarteraVo = actualizarCorteCartera(corteCarteraVo);
    }

}
