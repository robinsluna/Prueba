package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponsabilidadDianDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabilidadDian;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ResponsabilidadDianVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminResponsabilidadDianBean implements AdminResponsabilidadDian {
    @Resource
    SessionContext sessionContext;
    @EJB
    ResponsabilidadDianDAO adminResponsabilidadDianDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminResponsabilidadDianBean() {        
    }
    
    public ResponsabilidadDianVO buscarResponsabilidadDianPorId (ResponsabilidadDianVO responsabilidadDianVo) throws ExcepcionDAO{
        SiiResponsabilidadDian siiResponsabilidadDian = adminResponsabilidadDianDao.buscarResponsabilidadDianPorId(responsabilidadDianVo.getRdiCodigo());
        return new ResponsabilidadDianVO(siiResponsabilidadDian);
    }
    
    public List<ResponsabilidadDianVO> buscarTodosResponsabilidadDian() throws ExcepcionDAO{
        List<SiiResponsabilidadDian> listaResponsabilidadDian = adminResponsabilidadDianDao.buscarTodosResponsabilidadDian();
        List<ResponsabilidadDianVO> listaResponsabilidadDianVo = new ArrayList<ResponsabilidadDianVO>();
        for (SiiResponsabilidadDian siiResponsabilidadDian : listaResponsabilidadDian){
            listaResponsabilidadDianVo.add(new ResponsabilidadDianVO(siiResponsabilidadDian));
        }
        return listaResponsabilidadDianVo;
    }
}

