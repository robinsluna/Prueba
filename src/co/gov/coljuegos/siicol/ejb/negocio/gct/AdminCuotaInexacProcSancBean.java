/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaInexacProcSanc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuotaInexacProcSancVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las cuotas inexactas del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminCuotaInexacProcSancBean implements AdminCuotaInexacProcSanc {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private CuotaInexacProcSancDAO cuotaInexacProcSancDao;

    /**
     * Constructor.
     */
    
    public AdminCuotaInexacProcSancBean() {
        super();
    }
    
    /**
     * Buscar cuota inexacta del proceso sancionatorio por id.
     * @param cipsCodigo
     * @return resultado - Cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public CuotaInexacProcSancVO buscarCuotaInexacProcSancPorId(Long cipsCodigo) throws ExcepcionDAO {
        CuotaInexacProcSancVO resultado = null;
        SiiCuotaInexacProcSanc siiCuotaInexacProcSanc = cuotaInexacProcSancDao.buscarPorCodigo(cipsCodigo);
        if (siiCuotaInexacProcSanc != null)
            resultado = new CuotaInexacProcSancVO(siiCuotaInexacProcSanc);

        return (resultado);
    }
    
    /**
     * Buscar todos las cuotas inexactas del proceso sancionatorio.
     * @return resultado - Value object de las cuotas inexactas de proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<CuotaInexacProcSancVO> buscarTodoCuotaInexacProcSanc() throws ExcepcionDAO {
        List<CuotaInexacProcSancVO> resultado = null;
        List<SiiCuotaInexacProcSanc> lista = cuotaInexacProcSancDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<CuotaInexacProcSancVO>();
            for (SiiCuotaInexacProcSanc siiCuotaInexacProcSanc: lista) {
                if (siiCuotaInexacProcSanc!=null)
                    resultado.add(new CuotaInexacProcSancVO(siiCuotaInexacProcSanc));
            }
        }
        
        return (resultado);
    }

    /**
     * Insertar cuota inexacta de proceso sancionatorio.
     * @param cuotaInexacProcSancVo
     * @return resultado - value object de la cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CuotaInexacProcSancVO insertarCuotaInexacProcSanc(CuotaInexacProcSancVO cuotaInexacProcSancVo) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion {
        CuotaInexacProcSancVO resultado = null;

        try {
            SiiCuotaInexacProcSanc siiCuotaInexacProcSanc =
                cuotaInexacProcSancDao.insertar(conversionVoEntidad.convertir(cuotaInexacProcSancVo));
            if (siiCuotaInexacProcSanc != null) {
                resultado = new CuotaInexacProcSancVO(siiCuotaInexacProcSanc);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Cuota Inexacta del Proceso Sancionatorio: " + e.getMessage());
        }

        return (resultado);
    }
    
    /**
     * Actualizar la cuota inexacta del proceso sancionatorio.
     * @param cuotaInexacProcSancVo
     * @return resultado - Value object de la cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public CuotaInexacProcSancVO actualizarCuotaInexacProcSanc(CuotaInexacProcSancVO cuotaInexacProcSancVo) throws ExcepcionDAO, ExcepcionAplicacion {
        CuotaInexacProcSancVO resultado = null;
        
        try {

            SiiCuotaInexacProcSanc siiCuotaInexacProcSanc = cuotaInexacProcSancDao.actualizar(conversionVoEntidad.convertir(cuotaInexacProcSancVo));
            if (siiCuotaInexacProcSanc!=null) {
                resultado = new CuotaInexacProcSancVO(siiCuotaInexacProcSanc);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Cuota Inexacta del Proceso Sancionatorio: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO#buscarCuotaInexacProcSancPorIdProcesoSancionatorio(java.lang.Long)
     */
    @Override
    public List<CuotaInexacProcSancVO> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<CuotaInexacProcSancVO> resultado = null;
        List<SiiCuotaInexacProcSanc> lista = cuotaInexacProcSancDao.buscarCuotaInexacProcSancPorIdProcesoSancionatorio(psaCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuotaInexacProcSancVO>();
            for (SiiCuotaInexacProcSanc siiCuotaInexacProcSanc: lista) {
                if (siiCuotaInexacProcSanc!=null)
                    resultado.add(new CuotaInexacProcSancVO(siiCuotaInexacProcSanc));
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO#buscarCuotaInexacProcSancPorIdProcesoSancionatorio(java.lang.Long, boolean)
     */
    @Override
    public List<CuotaInexacProcSancVO> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO 
    {
        List<CuotaInexacProcSancVO> resultado = null;
        List<SiiCuotaInexacProcSanc> lista = cuotaInexacProcSancDao.buscarCuotaInexacProcSancPorIdProcesoSancionatorio(psaCodigo, soloActivos);
        if (lista!=null) {
            resultado = new ArrayList<CuotaInexacProcSancVO>();
            for (SiiCuotaInexacProcSanc siiCuotaInexacProcSanc: lista) {
                if (siiCuotaInexacProcSanc!=null)
                    resultado.add(new CuotaInexacProcSancVO(siiCuotaInexacProcSanc));
            }
        }
        
        return (resultado);
    }
}
