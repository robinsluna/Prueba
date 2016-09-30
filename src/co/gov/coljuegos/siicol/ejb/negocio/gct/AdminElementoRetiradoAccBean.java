package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumElementoRetiradoACC;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoRetiradoAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoRetiradoAcc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ElementoRetiradoAccVO;

import co.gov.coljuegos.siicol.ejb.vo.OrdenTrabajoVisitaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminElementoRetiradoAccBean implements AdminElementoRetiradoAcc {
    @EJB
    private ElementoRetiradoAccDAO elementoRetiradoAccDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public AdminElementoRetiradoAccBean() {
    }

    public List<ElementoRetiradoAccVO> buscarElementoRetiradoPorAccionControl(Long accCodigo) throws ExcepcionDAO {
        List<ElementoRetiradoAccVO> listaElementosVo = new ArrayList<ElementoRetiradoAccVO>();
        List<SiiElementoRetiradoAcc> listaElementosSii = new ArrayList<SiiElementoRetiradoAcc>();
        listaElementosSii = elementoRetiradoAccDao.buscarElementoRetiradoPorAccionControl(accCodigo);
        
        for(SiiElementoRetiradoAcc elemento : listaElementosSii) {
            ElementoRetiradoAccVO elementoRetiradoAccVo = new ElementoRetiradoAccVO(elemento);

            if(elemento.getElrAccion() != null) {

                if(elemento.getElrAccion().equals(EnumElementoRetiradoACC.DEVOLUCION_DECOMISO_Y_DESTRUCCION.getId())) {
                    elementoRetiradoAccVo.setAccionDevolucion(true);
                    elementoRetiradoAccVo.setAccionDecomisoDestruccion(true);
                }
                else if(elemento.getElrAccion().equals("D")) {
                    elementoRetiradoAccVo.setAccionDevolucion(true);
                }
                else if(elemento.getElrAccion().equals("DD")) {
                    elementoRetiradoAccVo.setAccionDecomisoDestruccion(true);
                }
            }

            listaElementosVo.add(elementoRetiradoAccVo);
        }
        return listaElementosVo;
    }

    public ElementoRetiradoAccVO buscarElementoPorCodigo(Long elrCodigo) throws ExcepcionDAO {

        return new ElementoRetiradoAccVO(elementoRetiradoAccDao.buscarPorCodigo(elrCodigo));
    }

    /**
     * Buscar elementos retirados según Id de acción control
     * @param accCodigo
     * @return resultaod - lista de elementos retirados
     * @throws ExcepcionDAO
     */

    public List<ElementoRetiradoAccVO> buscarElementoRetiradoAccVOXIdAccionControl(Long accCodigo) throws ExcepcionDAO {
        List<ElementoRetiradoAccVO> resultado = null;
        List<SiiElementoRetiradoAcc> lista = elementoRetiradoAccDao.buscarElementoRetiradoAccXIdAccionControl(accCodigo);
        if(lista != null) {
            resultado = new ArrayList<ElementoRetiradoAccVO>();
            for(SiiElementoRetiradoAcc siiElementoRetiradoAcc : lista) {
                if(siiElementoRetiradoAcc != null){
                   ElementoRetiradoAccVO elementoRetiradoAccVo = new ElementoRetiradoAccVO(siiElementoRetiradoAcc);
                   if(elementoRetiradoAccVo.getElrDestruido() == null)
                       elementoRetiradoAccVo.setElrDestruido("NO");
                    if(elementoRetiradoAccVo.getElrDestruido().equals("S") )
                        elementoRetiradoAccVo.setElrDestruido("SI");
                    if(elementoRetiradoAccVo.getElrDestruido().equals("N") )
                        elementoRetiradoAccVo.setElrDestruido("SI");
                   resultado.add(elementoRetiradoAccVo);
                }
            }
        }

        return (resultado);
    }

    /**
     * Actualizar el elemento retirado de acción control
     * @param elementoRetiradoAccVo
     * @return siiElementoRetiradoAcc - Value Object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ElementoRetiradoAccVO actualizarElementoRetiradoAccVo(ElementoRetiradoAccVO elementoRetiradoAccVo) throws ExcepcionDAO,
                                                                                                                     ExcepcionAplicacion {
        try {
            SiiElementoRetiradoAcc siiElementoRetiradoAcc = conversionVoEntidad.convertir(elementoRetiradoAccVo);

            //  this.persistirHijos(elementoRetiradoAccVo);

            siiElementoRetiradoAcc = elementoRetiradoAccDao.actualizar(siiElementoRetiradoAcc);
            return new ElementoRetiradoAccVO(siiElementoRetiradoAcc);
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el Elemento Retirado de la Acción de Control: " +
                                          e.getMessage());
        }


    }
}
