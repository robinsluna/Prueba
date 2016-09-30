/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 16-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOmisProcSanc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOmisProcSancVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las cuotas de omisión del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminCuotaOmisProcSancBean implements AdminCuotaOmisProcSanc {

    /**
     * Constructor.
     */
    @EJB
    private CuotaOmisProcSancDAO cuotaOmisProcSancDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public AdminCuotaOmisProcSancBean() {
        super();
    }

    /**
     * Buscar cuotas de omisión del proceso sancionatorio según id
     * @param cosCodigo
     * @return resultado - Value object de la cuota de omisión del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    public CuotaOmisProcSancVO buscarCuotaOmisProcSancPorId(Long cosCodigo) throws ExcepcionDAO {
        CuotaOmisProcSancVO resultado = null;
        SiiCuotaOmisProcSanc siiCuotaOmisProcSanc = cuotaOmisProcSancDao.buscarPorCodigo(cosCodigo);
        if (siiCuotaOmisProcSanc != null)
            resultado = new CuotaOmisProcSancVO(siiCuotaOmisProcSanc);

        return (resultado);
    }

    /**
     * Buscar todas las cuotas de omisión del proceso sancionatorio.
     * @return resultado - Lista de cuotas de omisión del proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<CuotaOmisProcSancVO> buscarTodoCuotaOmisProcSanc() throws ExcepcionDAO {
        List<CuotaOmisProcSancVO> resultado = null;
        List<SiiCuotaOmisProcSanc> lista = cuotaOmisProcSancDao.buscarTodo();
        if (lista != null) {
            resultado = new ArrayList<CuotaOmisProcSancVO>();
            for (SiiCuotaOmisProcSanc siiCuotaOmisProcSanc : lista) {
                if (siiCuotaOmisProcSanc != null)
                    resultado.add(new CuotaOmisProcSancVO(siiCuotaOmisProcSanc));
            }
        }

        return (resultado);
    }

    /**
     * Insertar la cuota de omisión del proceso sancionatorio.
     * @param cuotaOmisProcSancVo
     * @return resultado - Value Object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public CuotaOmisProcSancVO insertarCuotaOmisProcSanc(CuotaOmisProcSancVO cuotaOmisProcSancVo) throws ExcepcionDAO,
                                                                                                         ExcepcionAplicacion {
        CuotaOmisProcSancVO resultado = null;

        try {
            SiiCuotaOmisProcSanc siiCuotaOmisProcSanc =
                cuotaOmisProcSancDao.insertar(conversionVoEntidad.convertir(cuotaOmisProcSancVo));
            if (siiCuotaOmisProcSanc != null) {
                resultado = new CuotaOmisProcSancVO(siiCuotaOmisProcSanc);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Cuota de Omisión del Proceso Sancionatorio: " +
                                          e.getMessage());
        }

        return (resultado);
    }

    /**
     * Actualizar la cuota de omisión del proceso sancionatorio.
     * @param cuotaOmisProcSancVo
     * @return resultado - Value object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public CuotaOmisProcSancVO actualizarCuotaOmisProcSanc(CuotaOmisProcSancVO cuotaOmisProcSancVo) throws ExcepcionDAO,
                                                                                                           ExcepcionAplicacion {
        CuotaOmisProcSancVO resultado = null;

        try {

            SiiCuotaOmisProcSanc siiCuotaOmisProcSanc =
                cuotaOmisProcSancDao.actualizar(conversionVoEntidad.convertir(cuotaOmisProcSancVo));
            if (siiCuotaOmisProcSanc != null) {
                resultado = new CuotaOmisProcSancVO(siiCuotaOmisProcSanc);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Cuota de Omisión del Proceso Sancionatorio: " +
                                          e.getMessage());
        }

        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO#buscarCuotaOmisProcSancPorIdProcesoSancionatorio(java.lang.Long)
     */
    @Override
    public List<CuotaOmisProcSancVO> buscarCuotaOmisProcSancPorIdProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO 
    {
        List<CuotaOmisProcSancVO> resultado = null;
        List<SiiCuotaOmisProcSanc> lista = cuotaOmisProcSancDao.buscarCuotaOmisProcSancPorIdProcesoSancionatorio(psaCodigo);
        if (lista != null) {
            resultado = new ArrayList<CuotaOmisProcSancVO>();
            for (SiiCuotaOmisProcSanc siiCuotaOmisProcSanc : lista) {
                if (siiCuotaOmisProcSanc != null)
                    resultado.add(new CuotaOmisProcSancVO(siiCuotaOmisProcSanc));
            }
        }

        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO#buscarCuotaOmisProcSancPorIdProcesoSancionatorio(java.lang.Long, boolean)
     */
    @Override
    public List<CuotaOmisProcSancVO> buscarCuotaOmisProcSancPorIdProcesoSancionatorio(Long psaCodigo, boolean soloActivos) throws ExcepcionDAO 
    {
        List<CuotaOmisProcSancVO> resultado = null;
        List<SiiCuotaOmisProcSanc> lista = cuotaOmisProcSancDao.buscarCuotaOmisProcSancPorIdProcesoSancionatorio(psaCodigo, soloActivos);
        if (lista != null) {
            resultado = new ArrayList<CuotaOmisProcSancVO>();
            for (SiiCuotaOmisProcSanc siiCuotaOmisProcSanc : lista) {
                if (siiCuotaOmisProcSanc != null)
                    resultado.add(new CuotaOmisProcSancVO(siiCuotaOmisProcSanc));
            }
        }

        return (resultado);
    }
}
