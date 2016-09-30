/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 16-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioProcSan;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InventarioProcSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona el inventario del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminInventarioProcSanBean implements AdminInventarioProcSan {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private InventarioProcSanDAO inventarioProcSanDao;
    
    /**
     * Constructor.
     */
    
    public AdminInventarioProcSanBean() {
        super();
    }
    
    /**
     * Buscar inventario del proceso sancionatorio según id.
     * @param ipsCodigo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    
    public InventarioProcSanVO buscarInventarioProcSanPorId(Long ipsCodigo) throws ExcepcionDAO {
        InventarioProcSanVO resultado = null;
        SiiInventarioProcSan siiInventarioProcSan = inventarioProcSanDao.buscarPorCodigo(ipsCodigo);
        if (siiInventarioProcSan != null)
            resultado = new InventarioProcSanVO(siiInventarioProcSan);

        return (resultado);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Inventario del Proceso Sancionatorio por medio del c&oacute;digo del Proceso Sancionatorio.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
     * @return Listado de relaciones de Inventario con Proceso Sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<InventarioProcSanVO> buscarInventarioProcSanPorIdProceso (Long psaCodigo) throws ExcepcionDAO {
        
        List<InventarioProcSanVO> resultado = null;
        List<SiiInventarioProcSan> lista = inventarioProcSanDao.buscarInventarioProcSanPorIdProceso(psaCodigo);
        
        if (lista != null) {
            resultado = new ArrayList<InventarioProcSanVO>();
            for (SiiInventarioProcSan siiInventarioProcSan : lista) {
                if (siiInventarioProcSan != null)
                    resultado.add(new InventarioProcSanVO(siiInventarioProcSan));
            }
        }

        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioProcSanDAO#buscarInventarioProcSanPorIdProceso(java.lang.Long, boolean)
     */
    @Override
    public List<InventarioProcSanVO> buscarInventarioProcSanPorIdProceso (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO 
    {
        List<InventarioProcSanVO> resultado = null;
        List<SiiInventarioProcSan> lista = inventarioProcSanDao.buscarInventarioProcSanPorIdProceso(psaCodigo, soloActivos);
        
        if (lista != null) {
            resultado = new ArrayList<InventarioProcSanVO>();
            for (SiiInventarioProcSan siiInventarioProcSan : lista) {
                if (siiInventarioProcSan != null)
                    resultado.add(new InventarioProcSanVO(siiInventarioProcSan));
            }
        }

        return (resultado);
    }
    
    
    
    /**
     * Busca todos los registros  del inventario del proceso sancionatorio.
     * @return resultado - Lista del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<InventarioProcSanVO> buscarTodoInventarioProcSan() throws ExcepcionDAO {
        List<InventarioProcSanVO> resultado = null;
        List<SiiInventarioProcSan> lista = inventarioProcSanDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<InventarioProcSanVO>();
            for (SiiInventarioProcSan siiInventarioProcSan: lista) {
                if (siiInventarioProcSan!=null)
                    resultado.add(new InventarioProcSanVO(siiInventarioProcSan));
            }
        }
        
        return (resultado);
    }

    /**
     * Insertar el inventario del proceso sancionatorio.
     * @param inventarioProcSanVo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public InventarioProcSanVO insertarInventarioProcSan(InventarioProcSanVO inventarioProcSanVo) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion {
        InventarioProcSanVO resultado = null;

        try {
            SiiInventarioProcSan siiInventarioProcSan =
                inventarioProcSanDao.insertar(conversionVoEntidad.convertir(inventarioProcSanVo));
            if (siiInventarioProcSan != null) {
                resultado = new InventarioProcSanVO(siiInventarioProcSan);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar el Inventario del Proceso Sancionatorio: " + e.getMessage());
        }

        return (resultado);
    }
    
    /**
     * Actualizar el inventario del proceso sancionatorio.
     * @param inventarioProcSanVo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public InventarioProcSanVO actualizarInventarioProcSan(InventarioProcSanVO inventarioProcSanVo) throws ExcepcionDAO, ExcepcionAplicacion {
        InventarioProcSanVO resultado = null;
        
        try {

            SiiInventarioProcSan siiInventarioProcSan = inventarioProcSanDao.actualizar(conversionVoEntidad.convertir(inventarioProcSanVo));
            if (siiInventarioProcSan!=null) {
                resultado = new InventarioProcSanVO(siiInventarioProcSan);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el Inventario del Proceso Sancionatorio: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.gct.AdminInventarioProcSan#eliminarInventarioProcSan(java.lang.Long)
     */
    @Override
    public void eliminarInventarioProcSan (Long ipsCodigo) throws ExcepcionDAO {
        inventarioProcSanDao.eliminar(ipsCodigo);
    }
}
