package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoCalleDireccionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSectorDirecDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSufijo1CalleDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSufijo2CalleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCalleDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSectorDirec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo1Calle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo2Calle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DireccionVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoCalleDireccionVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoElemenIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSectorDirecVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSufijo1CalleVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSufijo2CalleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDireccionBean implements AdminDireccion {

    @EJB
    private TipoCalleDireccionDAO tipoCalleDireccionDao;
    @EJB
    private TipoSectorDirecDAO tipoSectorDirecDao;
    @EJB
    private TipoSufijo1CalleDAO tipoSufijo1CalleDao;
    @EJB
    private TipoSufijo2CalleDAO tipoSufijo2CalleDao;
    @EJB
    private DireccionDAO direccionDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public AdminDireccionBean() {
        super();
    }
    
    public List<TipoCalleDireccionVO> buscarTipoCalleDireccionTodos() throws ExcepcionDAO{
        List<TipoCalleDireccionVO> resultado = null;
        List<SiiTipoCalleDireccion> lista = tipoCalleDireccionDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoCalleDireccionVO>();
            for (SiiTipoCalleDireccion sii: lista) {
                if (sii!=null) {
                    resultado.add(new TipoCalleDireccionVO(sii));
                }
            }
        }
        return resultado;
    }
    
    /**
     * Buscar el tipo de callde de dirección por código del tipo
     * @param tcdCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoCalleDireccionVO buscarTipoCalleDireccionXId(Long tcdCodigo) throws ExcepcionDAO {
        TipoCalleDireccionVO resultado = null;
        SiiTipoCalleDireccion siiTipoCalleDireccion = tipoCalleDireccionDao.buscarPorCodigo(tcdCodigo);
        resultado = new TipoCalleDireccionVO();
        if(siiTipoCalleDireccion != null) {
            resultado = new TipoCalleDireccionVO(siiTipoCalleDireccion);
        }

        return resultado;
    }
    
    /**
     * Buscar el tipo de sufijo 1 de la calle según id
     * @param tscCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSufijo1CalleVO buscarTipoSufijo1CalleXId(Long tscCodigo) throws ExcepcionDAO {
        TipoSufijo1CalleVO resultado = null;
        SiiTipoSufijo1Calle siiTipoSufijo1Calle = tipoSufijo1CalleDao.buscarPorCodigo(tscCodigo);
        resultado = new TipoSufijo1CalleVO();
        if(siiTipoSufijo1Calle != null) {
            resultado = new TipoSufijo1CalleVO(siiTipoSufijo1Calle);
        }

        return resultado;
    }
    
    /**
     * Buscar por tipo de sector de la dirección según id
     * @param tsdCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSectorDirecVO buscarTipoSectorDirecXId(Long tsdCodigo) throws ExcepcionDAO {
        TipoSectorDirecVO resultado = null;
        SiiTipoSectorDirec siiTipoSectorDirec = tipoSectorDirecDao.buscarPorCodigo(tsdCodigo);
        resultado = new TipoSectorDirecVO();
        if(siiTipoSectorDirec != null) {
            resultado = new TipoSectorDirecVO(siiTipoSectorDirec);
        }

        return resultado;
    }
    
    /**
     * Buscar el tipo de sufijo 2 de la calle según su id (BIS)
     * @param tsuCodigo
     * @return
     * @throws ExcepcionDAO
     */
    
    public TipoSufijo2CalleVO buscarTipoSufijo2CalleXId(Long tsuCodigo) throws ExcepcionDAO {
        TipoSufijo2CalleVO resultado = null;
        SiiTipoSufijo2Calle siiTipoSufijo2Calle = tipoSufijo2CalleDao.buscarPorCodigo(tsuCodigo);
        resultado = new TipoSufijo2CalleVO();
        if(siiTipoSufijo2Calle != null) {
            resultado = new TipoSufijo2CalleVO(siiTipoSufijo2Calle);
        }

        return resultado;
    }

    public List<TipoSectorDirecVO> buscarTipoSectorDirecTodos() throws ExcepcionDAO{
        List<TipoSectorDirecVO> resultado = null;
        List<SiiTipoSectorDirec> lista = tipoSectorDirecDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoSectorDirecVO>();
            for (SiiTipoSectorDirec sii: lista) {
                if (sii!=null) {
                    resultado.add(new TipoSectorDirecVO(sii));
                }
            }
        }
        return resultado;
    }
    
    public List<TipoSufijo1CalleVO> buscarTipoSufijo1CalleTodos() throws ExcepcionDAO{
        List<TipoSufijo1CalleVO> resultado = null;
        List<SiiTipoSufijo1Calle> lista = tipoSufijo1CalleDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoSufijo1CalleVO>();
            for (SiiTipoSufijo1Calle sii: lista) {
                if (sii!=null) {
                    resultado.add(new TipoSufijo1CalleVO(sii));
                }
            }
        }
        return resultado;
    }
    
    public List<TipoSufijo2CalleVO> buscarTipoSufijo2CalleTodos() throws ExcepcionDAO{
        List<TipoSufijo2CalleVO> resultado = null;
        List<SiiTipoSufijo2Calle> lista = tipoSufijo2CalleDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoSufijo2CalleVO>();
            for (SiiTipoSufijo2Calle sii: lista) {
                if (sii!=null) {
                    resultado.add(new TipoSufijo2CalleVO(sii));
                }
            }
        }
        return resultado;
    }
    
    /**
     * Buscar la dirección completa según el id de la dirección
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */
    
    public String buscarDireccionCompletaXIdDenuncia(Long denCodigo) throws ExcepcionDAO{
        return direccionDao.buscarDireccionCompletaXIdDenuncia(denCodigo);
    }

    /**
     * Insertar la dirección en la base de datos
     * @param direccionVo
     * @return resultado - DireccionVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DireccionVO insertarDireccion(DireccionVO direccionVo) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionVO resultado = null;
        
        try {
            SiiDireccion siiDireccion = direccionDao.insertar(conversionVoEntidad.convertir(direccionVo));
            if (siiDireccion!=null) {
                resultado = new DireccionVO(siiDireccion);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la dirección: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    /**
     * Actualizar la dirección
     * @param direccionVo
     * @return resultado - La dirección que fue agregada a la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DireccionVO actualizarDireccion(DireccionVO direccionVo) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionVO resultado = null;
        
        try {
            SiiDireccion siiDireccion = direccionDao.actualizar(conversionVoEntidad.convertir(direccionVo));
            if (siiDireccion!=null) {
                resultado = new DireccionVO(siiDireccion);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Dirección: "+e.getMessage());
        }
        
        return (resultado);
    }
}
