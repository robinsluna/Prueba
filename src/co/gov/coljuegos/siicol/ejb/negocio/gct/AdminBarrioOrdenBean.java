/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BarrioOrdenDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrden;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenVO;

import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los barrios de las órdenes de trabajo de visita
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminBarrioOrdenBean implements AdminBarrioOrden {

    @EJB
    private BarrioOrdenDAO barrioOrdenDao;

    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor.
     */
    public AdminBarrioOrdenBean() {
        super();
    }

    /**
     * Insertar el barrio de la orden de trabajo de visita
     * @param barrioOrdenVo - Value Object
     * @return resultado - barrio insertado en la bd
     * @throws ExcepcionDAO
     */
    public BarrioOrdenVO insertarBarrioOrden(BarrioOrdenVO barrioOrdenVo) throws ExcepcionDAO {
        BarrioOrdenVO resultado = null;
        SiiBarrioOrden siiBarrioOrden = barrioOrdenDao.insertar(conversionVoEntidad.convertir(barrioOrdenVo));
        if (siiBarrioOrden != null)
            resultado = new BarrioOrdenVO(siiBarrioOrden);

        return (resultado);
    }

    /**
     * Actualizar el barrio de la orden de trabajo de visita
     * @param barrioOrdenVo - Value Object
     * @return resultado - barrio actualizado en la bd
     * @throws ExcepcionDAO
     */
    public BarrioOrdenVO actualizarBarrioOrden(BarrioOrdenVO barrioOrdenVo) throws ExcepcionDAO {
        BarrioOrdenVO resultado = null;

     /*   if (!barrioOrdenDao.existeBarrioOrdenXCodOrdenXNombreXMunicipio(barrioOrdenVo.getOrdenTrabajoVisitaVO().getOtvCodigo(),
                                                                        barrioOrdenVo.getBorNombre(),
                                                                        barrioOrdenVo.getUbicacionMunicipioVO().getUbiCodigo())) {*/
            SiiBarrioOrden siiBarrioOrden = barrioOrdenDao.actualizar(conversionVoEntidad.convertir(barrioOrdenVo));
            if (siiBarrioOrden != null)
                resultado = new BarrioOrdenVO(siiBarrioOrden);
   //     }

        return (resultado);
    }

    /**
     * Buscar los barrios con orden de trabajo de visita
     * @param codOrdenTrabajo
     * @return resultado - Lista de los barrios con determinado código de orden de trabajo.
     * @throws ExcepcionDAO
     */
    public List<BarrioOrdenVO> buscarBarrioOrdenXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO {
        List<BarrioOrdenVO> resultado = new ArrayList();
        List<SiiBarrioOrden> listaBarrioOrden = barrioOrdenDao.buscarTodoBarrioOrdenXCodigoOrdenTrab(codOrdenTrabajo);

        if (listaBarrioOrden != null) {
            for (SiiBarrioOrden barrio : listaBarrioOrden) {
                resultado.add(new BarrioOrdenVO(barrio));
            }
        }

        return resultado;
    }
}
