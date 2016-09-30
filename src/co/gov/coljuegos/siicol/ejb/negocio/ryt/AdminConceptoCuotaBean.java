/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-08-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoCuotaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminConceptoCuotaBean implements AdminConceptoCuota 
{
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    
    
    /**
     * Constructor.
     */
    public AdminConceptoCuotaBean() { }
    
    

    @Override
    public ConceptoCuotaVO buscarConceptoCuotaXId(Long idConceptoCuota) throws ExcepcionDAO {
        ConceptoCuotaVO resultado = null;
        SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(idConceptoCuota);
        if (siiConceptoCuota!=null)
            resultado = new ConceptoCuotaVO(siiConceptoCuota);
        
        return (resultado);
    }

    @Override
    public List<ConceptoCuotaVO> buscarTodoConceptoCuota() throws ExcepcionDAO {
        List<ConceptoCuotaVO> resultado = null;
        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuota();
        if (listaSiiConceptoCuota!=null) {
            resultado = new ArrayList<ConceptoCuotaVO>();
            for (SiiConceptoCuota siiConceptoCuota: listaSiiConceptoCuota) {
                if (siiConceptoCuota!=null)
                    resultado.add(new ConceptoCuotaVO(siiConceptoCuota));
            }
        }
        
        return (resultado);
    }

    @Override
    public List<ConceptoCuotaVO> buscarConceptoCuotaPorModalidades(String modalidad1, String modalidad2, String modalidad3) throws ExcepcionDAO {
        List<ConceptoCuotaVO> resultado = null;
        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarSiiConceptoCuotaPorModalidades(modalidad1, modalidad2, modalidad3);
        if (listaSiiConceptoCuota!=null) {
            resultado = new ArrayList<ConceptoCuotaVO>();
            for (SiiConceptoCuota siiConceptoCuota: listaSiiConceptoCuota) {
                if (siiConceptoCuota!=null)
                    resultado.add(new ConceptoCuotaVO(siiConceptoCuota));
            }
        }
        
        return (resultado);
    }
    
    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXCategoria(String  cadNombre) throws ExcepcionDAO {
        List<ConceptoCuotaVO> resultado = null;
        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXCategoria(cadNombre);
        if (listaSiiConceptoCuota!=null) {
            resultado = new ArrayList<ConceptoCuotaVO>();
            for (SiiConceptoCuota siiConceptoCuota: listaSiiConceptoCuota) {
                if (siiConceptoCuota!=null)
                    resultado.add(new ConceptoCuotaVO(siiConceptoCuota));
            }
        }
        return (resultado);
    }
    
    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXNombre(String  ccuNombre) throws ExcepcionDAO {
        List<ConceptoCuotaVO> resultado = null;
        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(ccuNombre);
        resultado = new ArrayList<ConceptoCuotaVO>();
        for (SiiConceptoCuota siiConceptoCuota: listaSiiConceptoCuota) {
            if (siiConceptoCuota!=null)
                resultado.add(new ConceptoCuotaVO(siiConceptoCuota));
        }
        return (resultado);        
    }
    

    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXAbreviatura(String  ccuAbreviatura) throws ExcepcionDAO {
        List<ConceptoCuotaVO> resultado = null;
        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura(ccuAbreviatura);
        if (listaSiiConceptoCuota!=null) {
            resultado = new ArrayList<ConceptoCuotaVO>();
            for (SiiConceptoCuota siiConceptoCuota: listaSiiConceptoCuota) {
                if (siiConceptoCuota!=null)
                    resultado.add(new ConceptoCuotaVO(siiConceptoCuota));
            }
        }
        return (resultado);
    }

}
