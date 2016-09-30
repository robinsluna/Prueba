/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoIncumplContractDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoIncumplContract;
import co.gov.coljuegos.siicol.ejb.vo.EstadoIncumplContractVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Estados de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
public class AdminEstadoIncumplContractBean implements AdminEstadoIncumplContract 
{
    @EJB
    private EstadoIncumplContractDAO estadoIncumplContractDao;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoIncumplContractBean() { }
    
    
    @Override
    public EstadoIncumplContractVO buscarEstadoIncumplContractPorCodigo(Long eicCodigo) throws ExcepcionDAO {
        EstadoIncumplContractVO resultado = null;
        SiiEstadoIncumplContract siiEstadoIncumplContract = estadoIncumplContractDao.buscarPorCodigo(eicCodigo);
        if (siiEstadoIncumplContract!=null)
            resultado = new EstadoIncumplContractVO(siiEstadoIncumplContract);
        
        return (resultado);
    }
    
    
    @Override
    public List<EstadoIncumplContractVO> buscarTodoEstadoIncumplContract() throws ExcepcionDAO {
        List<EstadoIncumplContractVO> resultado = null;
        List<SiiEstadoIncumplContract> lista = estadoIncumplContractDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<EstadoIncumplContractVO>();
            for (SiiEstadoIncumplContract siiEstadoIncumplContract: lista) {
                resultado.add(new EstadoIncumplContractVO(siiEstadoIncumplContract));
            }
        }
        
        return (resultado);
    }
}
