/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolSanConDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolSanCon;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolSanConVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTramiteResolSanConBean implements AdminTramiteResolSanCon 
{
    @EJB
    private TramiteResolSanConDAO tramiteResolSanConDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTramiteResolSanConBean() { }
    
    
    @Override
    public TramiteResolSanConVO buscarTramiteResolSanConPorCodigo(Long trsCodigo) throws ExcepcionDAO {
        TramiteResolSanConVO resultado = null;
        SiiTramiteResolSanCon siiTramiteResolSanCon = tramiteResolSanConDao.buscarPorCodigo(trsCodigo);
        if (siiTramiteResolSanCon!=null)
            resultado = new TramiteResolSanConVO(siiTramiteResolSanCon);
        
        return (resultado);
    }
    
    
    @Override
    public List<TramiteResolSanConVO> buscarTodoTramiteResolSanCon() throws ExcepcionDAO {
        List<TramiteResolSanConVO> resultado = null;
        List<SiiTramiteResolSanCon> lista = tramiteResolSanConDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TramiteResolSanConVO>();
            for (SiiTramiteResolSanCon siiTramiteResolSanCon: lista) {
                if (siiTramiteResolSanCon!=null)
                    resultado.add(new TramiteResolSanConVO(siiTramiteResolSanCon));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<TramiteResolSanConVO> buscarTramiteResolSanConPorIdResolucion (Long rcoCodigo) throws ExcepcionDAO {
        List<TramiteResolSanConVO> resultado = null;
        List<SiiTramiteResolSanCon> lista = tramiteResolSanConDao.buscarTramiteResolSanConPorIdResolucion(rcoCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TramiteResolSanConVO>();
            for (SiiTramiteResolSanCon siiTramiteResolSanCon: lista) {
                if (siiTramiteResolSanCon!=null)
                    resultado.add(new TramiteResolSanConVO(siiTramiteResolSanCon));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public TramiteResolSanConVO insertarTramiteResolSanCon (TramiteResolSanConVO tramiteResolSanConVo) throws ExcepcionDAO {
        TramiteResolSanConVO resultado = null;
        SiiTramiteResolSanCon siiTramiteResolSanCon = tramiteResolSanConDao.insertar(conversionVoEntidad.convertir(tramiteResolSanConVo));
        if (siiTramiteResolSanCon!=null)
            resultado = new TramiteResolSanConVO(siiTramiteResolSanCon);
        
        return (resultado);
    }
    
    
    @Override
    public TramiteResolSanConVO actualizarTramiteResolSanCon (TramiteResolSanConVO tramiteResolSanConVo) throws ExcepcionDAO {
        TramiteResolSanConVO resultado = null;
        SiiTramiteResolSanCon siiTramiteResolSanCon = tramiteResolSanConDao.actualizar(conversionVoEntidad.convertir(tramiteResolSanConVo));
        if (siiTramiteResolSanCon!=null)
            resultado = new TramiteResolSanConVO(siiTramiteResolSanCon);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTramiteResolSanCon (Long trsCodigo) throws ExcepcionDAO {
        tramiteResolSanConDao.eliminar(trsCodigo);
    }
}
