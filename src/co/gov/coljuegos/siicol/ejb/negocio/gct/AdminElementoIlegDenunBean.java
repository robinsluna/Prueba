/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoIlegDenunDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegDenun;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegDenunVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminElementoIlegDenunBean implements AdminElementoIlegDenun {
    
    @EJB
    private ElementoIlegDenunDAO  elementoIlegDenunDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminElementoIlegDenunBean() {
        super();
    }
    
    public List<ElementoIlegDenunVO> buscarElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO {
            List<ElementoIlegDenunVO> resultado = null;
            List<SiiElementoIlegDenun> listaElem = elementoIlegDenunDao.buscarElementoIlegDenunXCodDenuncia(denCodigo);

            if (listaElem != null) {
                resultado = new ArrayList<ElementoIlegDenunVO>();
                for (SiiElementoIlegDenun elem : listaElem) {
                    if (elem != null) {
                        resultado.add(new ElementoIlegDenunVO(elem));
                    }
                }
            }

            return (resultado);
        }
    
    public List<ElementoIlegDenunVO> buscarTodoElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO  {
        List<ElementoIlegDenunVO> resultado = null;
        List<SiiElementoIlegDenun> listaElem = elementoIlegDenunDao.buscarTodoElementoIlegDenunXCodDenuncia(denCodigo);

        if (listaElem != null) {
            resultado = new ArrayList<ElementoIlegDenunVO>();
            for (SiiElementoIlegDenun elem : listaElem) {
                if (elem != null) {
                    resultado.add(new ElementoIlegDenunVO(elem));
                }
            }
        }

        return  (resultado);
        
    }

    @Override
    public ElementoIlegDenunVO insertarElementoIlegDenun(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO {
        ElementoIlegDenunVO resultado = null;
        ElementoIlegDenunVO elementoVo = new ElementoIlegDenunVO(elementoIlegDenunDao.buscarElementoInactivo(elementoIlegDenunVo));
        if(elementoVo != null) {
            elementoVo.setEidActivo("S");
            return actualizarElementoIlegDenun(elementoVo);
        }
        else {
            SiiElementoIlegDenun siiElementoIlegDenun = elementoIlegDenunDao.insertar(conversionVoEntidad.convertir(elementoIlegDenunVo));
            if(siiElementoIlegDenun != null)
                resultado = new ElementoIlegDenunVO(siiElementoIlegDenun);
            return resultado;
        }

    }

    @Override
    public ElementoIlegDenunVO actualizarElementoIlegDenun(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO {
        ElementoIlegDenunVO resultado = null;
        SiiElementoIlegDenun siiElementoIlegDenun = elementoIlegDenunDao.actualizar(conversionVoEntidad.convertir(elementoIlegDenunVo));
        if (siiElementoIlegDenun!=null)
            resultado = new ElementoIlegDenunVO(siiElementoIlegDenun);
        return resultado;
    }
    
    public ElementoIlegDenunVO buscarElementoInactivo(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO {
        return new ElementoIlegDenunVO(elementoIlegDenunDao.buscarElementoInactivo(elementoIlegDenunVo));
    }
        
}
