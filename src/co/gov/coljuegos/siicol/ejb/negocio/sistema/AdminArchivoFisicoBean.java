package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedArchFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedArchFisicoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminArchivoFisicoBean implements AdminArchivoFisico{
    
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    ExpedArchFisicoDAO expedArchFisicoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminArchivoFisicoBean(){
    }
    
    public ArchivoFisicoVO insertarArchivoFisico(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO{
        SiiArchivoFisico siiArchivoFisico = conversionVoEntidad.convertir(archivoFisicoVo);
        siiArchivoFisico = archivoFisicoDao.insertarArchivoFisico(siiArchivoFisico);
        //Buscamos expedientes asociados al archivo
        if(archivoFisicoVo.getListaExpedArchFisicoVo() != null && archivoFisicoVo.getListaExpedArchFisicoVo().size() > 0){
            for(ExpedArchFisicoVO unExpedArchFisicoVo : archivoFisicoVo.getListaExpedArchFisicoVo()){
                SiiExpedArchFisico siiExpedArchFisico = conversionVoEntidad.convertir(unExpedArchFisicoVo);
                expedArchFisicoDao.insertarExpedArchivoFisico(siiExpedArchFisico);
            }
        }
        return new ArchivoFisicoVO(siiArchivoFisico);
    }
    public ArchivoFisicoVO buscarArchivoFisicoPorId(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO{
        SiiArchivoFisico unArchivoFisico = archivoFisicoDao.buscarArchivoFisicoPorId(archivoFisicoVo.getAfiCodigo());
        return new ArchivoFisicoVO(unArchivoFisico);
    }
 /*   
    public ArchivoFisicoVO actualizarArchivoFisico(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO{
        SiiArchivoFisico archivoFisico = conversionVoEntidad.convertir(archivoFisicoVo);
        SiiArchivoFisico unArchivoFisico = archivoFisicoDao.actualizarArchivoFisico(archivoFisico);
        return new ArchivoFisicoVO(unArchivoFisico);
    }
    */
    public List<ArchivoFisicoVO> buscarTodoArchivoFisico() throws ExcepcionDAO{
        List<SiiArchivoFisico> listaArchivoFisico = archivoFisicoDao.buscarTodoArchivoFisico();
        List<ArchivoFisicoVO> listaArchivoFisicoVo = new ArrayList();
        for(SiiArchivoFisico unArchivoFisico : listaArchivoFisico){
            listaArchivoFisicoVo.add(new ArchivoFisicoVO(unArchivoFisico));
        }
        return listaArchivoFisicoVo;
    }
    public List<ArchivoFisicoVO> buscarArchivoFisicoPorNombre(String afiNombre) throws ExcepcionDAO{
        List<SiiArchivoFisico> listaArchivoFisico = archivoFisicoDao.buscarArchivoFisicoPorNombre(afiNombre);
        List<ArchivoFisicoVO> listaArchivoFisicoVo = new ArrayList();
        for(SiiArchivoFisico unArchivoFisico : listaArchivoFisico){
            listaArchivoFisicoVo.add(new ArchivoFisicoVO(unArchivoFisico));
        }
        return listaArchivoFisicoVo;
    }
}
