package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestPolizaRenovacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuestPolizaRenovac;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestPolizaRenovacVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoApuestPolizaRenovacionBean implements AdminTipoApuestPolizaRenovacion {
    
    @EJB
    TipoApuestPolizaRenovacDAO tipoApuestPolizaRenovacDao;
    
    public AdminTipoApuestPolizaRenovacionBean() {
    }
    
    public List<TipoApuestPolizaRenovacVO> buscarTipoApuestaPolizaRenovacionPorPoliza(Long idPoliza) throws ExcepcionDAO{
        List<TipoApuestPolizaRenovacVO> listaTipoApuestPolizaRenovacVo = null;
        List<SiiTipoApuestPolizaRenovac> listaTipoApuestaPolizaRenovacion = tipoApuestPolizaRenovacDao.buscarTipoApuestaPolizaRenovacionPorPoliza(idPoliza);
        if(listaTipoApuestaPolizaRenovacion != null && listaTipoApuestaPolizaRenovacion.size() > 0){
            listaTipoApuestPolizaRenovacVo = new ArrayList<>();
            for(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac : listaTipoApuestaPolizaRenovacion){
                listaTipoApuestPolizaRenovacVo.add(new TipoApuestPolizaRenovacVO(siiTipoApuestPolizaRenovac));
            }
        }
        return listaTipoApuestPolizaRenovacVo;
    }
}
