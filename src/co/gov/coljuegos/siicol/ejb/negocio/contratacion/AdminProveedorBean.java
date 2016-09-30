package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminProveedorBean implements AdminProveedor {
    @EJB
    private ProveedorDAO proveedorDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public ProveedorVO insertarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO {

        return new ProveedorVO(proveedorDAO.insertarProveedor(conversionVoEntidad.convertir(proveedorVO)));
    }


    public ProveedorVO buscarProveedorPorId(ProveedorVO proveedorVO) throws ExcepcionDAO {

        return new ProveedorVO(proveedorDAO.buscarProveedorPorId(proveedorVO.getProCodigo()));
    }


    public ProveedorVO actualizarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO {
        return new ProveedorVO(proveedorDAO.actualizarProveedor(conversionVoEntidad.convertir(proveedorVO)));
    }


    public void eliminarProveedor(ProveedorVO proveedorVO) throws ExcepcionDAO {
        proveedorDAO.eliminarProveedor(proveedorVO.getProCodigo());
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ProveedorVO> buscarTodoProveedor() throws ExcepcionDAO {
        List<ProveedorVO> proveedorVOs = new ArrayList<ProveedorVO>();
        List<SiiProveedor> siiProveedors = new ArrayList<SiiProveedor>();
        siiProveedors = proveedorDAO.buscarTodoProveedor();

        for (SiiProveedor siiProveedor : siiProveedors) {
            ProveedorVO proveedorVO = new ProveedorVO(siiProveedor);            
            proveedorVOs.add(proveedorVO);
        }
        return proveedorVOs;
    }

    public List<ProveedorVO> buscarProveedorPorNombre(String nombre) throws ExcepcionDAO {
        List<SiiProveedor> listaProveedor = proveedorDAO.buscarProveedorPorNombre(nombre);
        List<ProveedorVO> listaProveedorVO = new ArrayList();
        for (SiiProveedor unProveedor : listaProveedor) {
            listaProveedorVO.add(new ProveedorVO(unProveedor));
        }
        return listaProveedorVO;
    }

    public List<ProveedorVO> buscarProveedorPorIdentificacion(String numeroId) throws ExcepcionDAO {
        List<SiiProveedor> listaProveedor = proveedorDAO.buscarProveedorPorIdentificacion(numeroId);
        List<ProveedorVO> listaProveedorVO = new ArrayList();
        for (SiiProveedor unProveedor : listaProveedor) {
            listaProveedorVO.add(new ProveedorVO(unProveedor));
        }
        return listaProveedorVO;
    }

    public ProveedorVO buscarProveedorPorPersona(PersonaVO personaVo) throws ExcepcionDAO {
        SiiProveedor proveedor = proveedorDAO.buscarProveedorPorPersona(personaVo);
        if (proveedor == null) {
            return null;
        } else {
            return new ProveedorVO(proveedor);
        }
    }

    public void actualizarListaProveedor(List<ProveedorVO> listaProveedorVO) throws ExcepcionDAO {
        if (listaProveedorVO != null) {
            for (ProveedorVO miProveedorVo : listaProveedorVO) {
                proveedorDAO.actualizarProveedor(conversionVoEntidad.convertir(miProveedorVo));
            }
        }
    }

    public List<ProveedorVO> buscarProveedoresCotizacion(long idproceso) throws ExcepcionDAO {
        List<ProveedorVO> listaProveedoresCotiza = proveedorDAO.buscarProveedoresCotizacion(idproceso);
        return listaProveedoresCotiza;
    }
}
