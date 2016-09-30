/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPresDetRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPresDetRubro;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ModPresDetRubroVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminModPresDetRubroBean implements AdminModPresDetRubro {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ModPresDetRubroDAO modPresDetRubroDao;
    
    
    /**
     * Constructor.
     */
    public AdminModPresDetRubroBean() { }
    
    
    
    
    public ModPresDetRubroVO buscarModPresDetRubroPorId(Long idMpdCodigo) throws ExcepcionDAO {
        SiiModPresDetRubro siiModPresDetRubro = modPresDetRubroDao.buscarModPresDetRubroPorId(idMpdCodigo);
        return ( new ModPresDetRubroVO(siiModPresDetRubro) );
    }

    
    public ModPresDetRubroVO insertarModPresDetRubro(ModPresDetRubroVO modPresDetRubroVo) throws ExcepcionDAO {
        SiiModPresDetRubro siiModPresDetRubro = modPresDetRubroDao.insertarModPresDetRubro(conversionVoEntidad.convertir(modPresDetRubroVo));
        if (siiModPresDetRubro!=null)
            modPresDetRubroVo.setMpdCodigo(siiModPresDetRubro.getMpdCodigo());
        
        return ( new ModPresDetRubroVO(siiModPresDetRubro) );
    }

    
    public ModPresDetRubroVO actualizarModPresDetRubro(ModPresDetRubroVO modPresDetRubroVo) throws ExcepcionDAO {
        SiiModPresDetRubro siiModPresDetRubro = modPresDetRubroDao.actualizarModPresDetRubro(conversionVoEntidad.convertir(modPresDetRubroVo));
        return ( new ModPresDetRubroVO(siiModPresDetRubro) );
    }
    
    
    public void borrarModPresDetRubro(Long mpdCodigo) throws ExcepcionDAO {
        modPresDetRubroDao.borrarModPresDetRubro(mpdCodigo);
    }
    
    
    public List<ModPresDetRubroVO> buscarPorCodigoModificPresup(Long mprCodigo) throws ExcepcionDAO {
        List<ModPresDetRubroVO>  listaVo = new ArrayList<ModPresDetRubroVO>();
        List<SiiModPresDetRubro> lista = modPresDetRubroDao.buscarPorCodigoModificPresup(mprCodigo);
        
        if (lista!=null) {
            for (SiiModPresDetRubro siiModPresDetRubro : lista){
                listaVo.add(new ModPresDetRubroVO(siiModPresDetRubro));
            }
        }
        
        return (listaVo);
    }
    
    
    public Long consultarValorCreditos(Long druCodigo) throws ExcepcionDAO {
        return ( modPresDetRubroDao.consultarValorCreditos(druCodigo) );
    }
    
    
    public Long consultarValorContracreditos(Long druCodigo) throws ExcepcionDAO {
        return ( modPresDetRubroDao.consultarValorContracreditos(druCodigo) );
    }

    public Long consultarValorAdiciones(Long druCodigo) throws ExcepcionDAO {
        return ( modPresDetRubroDao.consultarValorAdiciones(druCodigo) );
    }

    public Long consultarValorReducciones(Long druCodigo) throws ExcepcionDAO {
        return ( modPresDetRubroDao.consultarValorReducciones(druCodigo) );
    }
}
