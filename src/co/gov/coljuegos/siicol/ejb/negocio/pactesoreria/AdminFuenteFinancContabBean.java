/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinancContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinancContabVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminFuenteFinancContabBean implements AdminFuenteFinancContab 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private FuenteFinancContabDAO fuenteFinancContabDAO;
    
    
    /**
     * Constructor.
     */
    public AdminFuenteFinancContabBean() {
        super();
    }

    
    public FuenteFinancContabVO buscarPorCodigoFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO {
        SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDAO.buscarPorCodigo(ffcCodigo);
        return ( new FuenteFinancContabVO(siiFuenteFinancContab) );
    }

    
    public FuenteFinancContabVO insertarFuenteFinancContab(FuenteFinancContabVO fuenteFinancContabVO) throws ExcepcionDAO {
        SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDAO.insertar(conversionVoEntidad.convertir(fuenteFinancContabVO));
        return ( new FuenteFinancContabVO(siiFuenteFinancContab) );
    }

    
    public FuenteFinancContabVO actualizarFuenteFinancContab(FuenteFinancContabVO fuenteFinancContabVO) throws ExcepcionDAO {
        SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDAO.actualizar(conversionVoEntidad.convertir(fuenteFinancContabVO));
        return ( new FuenteFinancContabVO(siiFuenteFinancContab) );
    }

    
    public void borrarFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO {
        fuenteFinancContabDAO.eliminar(ffcCodigo);
    }

    
    public List<FuenteFinancContabVO> buscarTodaFuenteFinancContab() throws ExcepcionDAO {
        List<FuenteFinancContabVO> listaFuenteFinancContab = null;
        List<SiiFuenteFinancContab> lista = fuenteFinancContabDAO.buscarTodo();
        if (lista!=null) {
            listaFuenteFinancContab = new ArrayList<FuenteFinancContabVO>();
            for (SiiFuenteFinancContab siiFuenteFinancContab: lista) {
                listaFuenteFinancContab.add(new FuenteFinancContabVO(siiFuenteFinancContab));
            }
        }
        return (listaFuenteFinancContab);
    }

    
    public List<FuenteFinancContabVO> buscarFuenteFinancContabPorRp(Long rpCodigo) throws ExcepcionDAO {
        List<FuenteFinancContabVO> listaFuenteFinancContab = null;
        List<SiiFuenteFinancContab> lista = fuenteFinancContabDAO.buscarFuenteFinancContabPorRp(rpCodigo);
        if (lista!=null) {
            listaFuenteFinancContab = new ArrayList<FuenteFinancContabVO>();
            for (SiiFuenteFinancContab siiFuenteFinancContab: lista) {
                listaFuenteFinancContab.add(new FuenteFinancContabVO(siiFuenteFinancContab));
            }
        }
        return (listaFuenteFinancContab);
    }
}
