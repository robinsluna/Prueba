/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DescargoProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcSan;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los descargos del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminDescargoProcSanBean implements AdminDescargoProcSan {

    @EJB
    private DescargoProcSanDAO descargoProcSanDao;

    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor
     */
    public AdminDescargoProcSanBean() {
        super();
    }

    /**
     * Buscar descargo proceso sancionatorio por id.
     * @param dpsCodigo
     * @return resultado - Descargo del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public DescargoProcSanVO buscarDescargoProcSanPorId(Long dpsCodigo) throws ExcepcionDAO {
        DescargoProcSanVO resultado = null;
        SiiDescargoProcSan siiDescargoProcSan = descargoProcSanDao.buscarPorCodigo(dpsCodigo);
        if (siiDescargoProcSan != null)
            resultado = new DescargoProcSanVO(siiDescargoProcSan);

        return (resultado);
    }
    
    /**
     * Buscar todos los descargos de proceso sancionatorio.
     * @return resultado - Value object de descargo de proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<DescargoProcSanVO> buscarTodoDescargoProcSan() throws ExcepcionDAO {
        List<DescargoProcSanVO> resultado = null;
        List<SiiDescargoProcSan> lista = descargoProcSanDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<DescargoProcSanVO>();
            for (SiiDescargoProcSan siiDescargoProcSan: lista) {
                if (siiDescargoProcSan!=null)
                    resultado.add(new DescargoProcSanVO(siiDescargoProcSan));
            }
        }
        
        return (resultado);
    }

    /**
     * Insertar el descargo de proceso sancionatorio.
     * @param descargoProcSanVo
     * @return resultado - Value Object Descargo proceso sancionatorio
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public DescargoProcSanVO insertarDescargoProcSan(DescargoProcSanVO descargoProcSanVo) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion {
        DescargoProcSanVO resultado = null;

        try {
            SiiDescargoProcSan siiDescargoProcSan =
                descargoProcSanDao.insertar(conversionVoEntidad.convertir(descargoProcSanVo));
            if (siiDescargoProcSan != null) {
                resultado = new DescargoProcSanVO(siiDescargoProcSan);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar el Descargo del Proceso Sancionatorio: " + e.getMessage());
        }

        return (resultado);
    }
    
    /**
     * Actualizar el descargo del proceso sancionatorio.
     * @param descargoProcSanVo
     * @return resultado - Value object del descargo del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DescargoProcSanVO actualizarDescargoProcSan(DescargoProcSanVO descargoProcSanVo) throws ExcepcionDAO, ExcepcionAplicacion {
        DescargoProcSanVO resultado = null;
        
        try {

            SiiDescargoProcSan siiDescargoProcSan = descargoProcSanDao.actualizar(conversionVoEntidad.convertir(descargoProcSanVo));
            if (siiDescargoProcSan!=null) {
                resultado = new DescargoProcSanVO(siiDescargoProcSan);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el Descargo del Proceso Sancionatorio: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<DescargoProcSanVO> buscarDescargoProcSanPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<DescargoProcSanVO> resultado = null;
        List<SiiDescargoProcSan> lista = descargoProcSanDao.buscarDescargoProcSanPorIdProcesoSancionatorio(psaCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DescargoProcSanVO>();
            for (SiiDescargoProcSan siiDescargoProcSan: lista) {
                if (siiDescargoProcSan!=null)
                    resultado.add(new DescargoProcSanVO(siiDescargoProcSan));
            }
        }
        
        return (resultado);
    }
}
