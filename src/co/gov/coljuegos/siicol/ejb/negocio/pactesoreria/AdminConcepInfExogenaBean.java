/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConcepInfExogenaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepInfExogena;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ConcepInfExogenaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminConcepInfExogenaBean implements AdminConcepInfExogena 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ConcepInfExogenaDAO concepInfExogenaDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminConcepInfExogenaBean() {
        super();
    }

    @Override
    public ConcepInfExogenaVO buscarPorCodigoConcepInfExogena(Long cieCodigo) throws ExcepcionDAO {
        SiiConcepInfExogena siiConcepInfExogena = concepInfExogenaDao.buscarPorCodigo(cieCodigo);
        if (siiConcepInfExogena==null) return null;
        return ( new ConcepInfExogenaVO(siiConcepInfExogena) );
    }

    @Override
    public ConcepInfExogenaVO insertarConcepInfExogena(ConcepInfExogenaVO concepInfExogenaVO) throws ExcepcionDAO {
        SiiConcepInfExogena siiConcepInfExogena = concepInfExogenaDao.insertar(conversionVoEntidad.convertir(concepInfExogenaVO));
        if (siiConcepInfExogena==null) return null;
        return ( new ConcepInfExogenaVO(siiConcepInfExogena) );
    }

    @Override
    public ConcepInfExogenaVO actualizarConcepInfExogena(ConcepInfExogenaVO concepInfExogenaVO) throws ExcepcionDAO {
        SiiConcepInfExogena siiConcepInfExogena = concepInfExogenaDao.actualizar(conversionVoEntidad.convertir(concepInfExogenaVO));
        if (siiConcepInfExogena==null) return null;
        return ( new ConcepInfExogenaVO(siiConcepInfExogena) );
    }

    @Override
    public void borrarConcepInfExogena(Long cieCodigo) throws ExcepcionDAO {
        concepInfExogenaDao.eliminar(cieCodigo);
    }

    @Override
    public List<ConcepInfExogenaVO> buscarTodoConcepInfExogena() throws ExcepcionDAO {
        List<ConcepInfExogenaVO> listaConcepInfExogena = null;
        List<SiiConcepInfExogena> lista = concepInfExogenaDao.buscarTodo();
        if (lista!=null) {
            listaConcepInfExogena = new ArrayList<ConcepInfExogenaVO>();
            for (SiiConcepInfExogena siiConcepInfExogena: lista) {
                listaConcepInfExogena.add(new ConcepInfExogenaVO(siiConcepInfExogena));
            }
        }
        return (listaConcepInfExogena);
    }
}
