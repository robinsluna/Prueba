/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucSanConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucSanCon;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucSanConVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Estados de Resoluci&oacute;n Sin Sanci&oacute;n.
 * @author Camilo Miranda
 */
@Stateless
public class AdminEstadoResolucSanConBean implements AdminEstadoResolucSanCon 
{
    @EJB
    private EstadoResolucSanConDAO estadoResolucSanConDao;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoResolucSanConBean() { }
    
    
    @Override
    public EstadoResolucSanConVO buscarEstadoResolucSanConPorCodigo(Long ersCodigo) throws ExcepcionDAO {
        EstadoResolucSanConVO resultado = null;
        SiiEstadoResolucSanCon siiEstadoResolucSanCon = estadoResolucSanConDao.buscarPorCodigo(ersCodigo);
        if (siiEstadoResolucSanCon!=null)
            resultado = new EstadoResolucSanConVO(siiEstadoResolucSanCon);
        
        return (resultado);
    }
    
    
    @Override
    public List<EstadoResolucSanConVO> buscarTodoEstadoResolucSanCon() throws ExcepcionDAO {
        List<EstadoResolucSanConVO> resultado = null;
        List<SiiEstadoResolucSanCon> lista = estadoResolucSanConDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<EstadoResolucSanConVO>();
            for (SiiEstadoResolucSanCon siiEstadoResolucSanCon: lista) {
                if (siiEstadoResolucSanCon!=null)
                    resultado.add(new EstadoResolucSanConVO(siiEstadoResolucSanCon));
            }
        }
        
        return (resultado);
    }
}
