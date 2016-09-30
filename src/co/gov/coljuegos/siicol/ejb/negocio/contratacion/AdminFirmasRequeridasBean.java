package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmasRequeridasDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasDocumentosVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminFirmasRequeridasBean implements AdminFirmasRequeridas {
    @EJB
    FirmasRequeridasDAO firmasRequeridasDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminFirmasRequeridasBean() {
    }
    public FirmasRequeridasVO insertarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO{
        SiiFirmasRequeridas firmaRequerida = conversionVoEntidad.convertir(firmasRequeridasVO);
        firmaRequerida = firmasRequeridasDao.insertarFirmasRequeridas(firmaRequerida);
        return new FirmasRequeridasVO(firmaRequerida);
    }

    public FirmasRequeridasVO buscarFirmasRequeridasPorId(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO {
        return new FirmasRequeridasVO(firmasRequeridasDao.buscarFirmasRequeridasPorId(firmasRequeridasVO.getFreCodigo()));
    }

    public FirmasRequeridasVO actualizarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO {
        SiiFirmasRequeridas firmaRequerida = conversionVoEntidad.convertir(firmasRequeridasVO);
        firmaRequerida = firmasRequeridasDao.actualizarFirmasRequeridas(firmaRequerida);
        return new FirmasRequeridasVO(firmaRequerida);
    }

    public void eliminarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO {
        firmasRequeridasDao.eliminarFirmasRequeridas(firmasRequeridasVO.getFreCodigo());
    }
    
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento) throws ExcepcionDAO{
        return firmasRequeridasDao.consultarFirmasRequeridas(idTipoDocumento);
    }

    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento, Long idDocumento) throws ExcepcionDAO{
        return firmasRequeridasDao.consultarFirmasRequeridas(idTipoDocumento, idDocumento);
    }
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridasUsuario(Long idTipoDocumento, Long idUsuario) throws ExcepcionDAO{
        return firmasRequeridasDao.consultarFirmasRequeridasUsuario(idTipoDocumento, idUsuario);
    }
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmasRequeridasDAO#buscarFirmasRequeridasPorIdTipoDocColjuegos(java.lang.Long)
     */
    public List<FirmasRequeridasVO> buscarFirmasRequeridasPorIdTipoDocColjuegos(Long idTipoDocumento) 
        throws ExcepcionDAO 
    {
        List<FirmasRequeridasVO> listaFirmasRequeridasVO = null;
        
        List<SiiFirmasRequeridas> lista = firmasRequeridasDao.buscarFirmasRequeridasPorIdTipoDocColjuegos(idTipoDocumento);
        if (lista!=null) {
            listaFirmasRequeridasVO = new ArrayList<FirmasRequeridasVO>();
            for (SiiFirmasRequeridas siiFirmasRequeridas: lista) {
                listaFirmasRequeridasVO.add(new FirmasRequeridasVO(siiFirmasRequeridas));
            }
        }
        
        return (listaFirmasRequeridasVO);
    }
    
}
