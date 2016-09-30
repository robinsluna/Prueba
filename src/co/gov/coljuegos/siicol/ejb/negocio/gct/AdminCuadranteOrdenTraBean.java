/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AuditorOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuadranteOrdenTraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AuditorOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdenTraVO;

import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los cuadrantes de la orden de trabajo de visita
 * @author PAOLA ANDREA RUEDA LEÓN
 */
@Stateless
public class AdminCuadranteOrdenTraBean implements AdminCuadranteOrdenTra {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    @EJB
    private CuadranteOrdenTraDAO cuadranteOrdenTraDao;

    /**
     * Constructor
     */
    public AdminCuadranteOrdenTraBean() {
        super();
    }

    /**
     * Insertar el cuadrante de la orden de trabajo de visita
     * @param cuadranteOrdenTraVo
     * @return resultado - Cuadrante que se insertó en la BD
     * @throws ExcepcionDAO
     */
    public CuadranteOrdenTraVO insertarCuadranteOrdenTra(CuadranteOrdenTraVO cuadranteOrdenTraVo) throws ExcepcionDAO {
        CuadranteOrdenTraVO resultado = null;
        SiiCuadranteOrdenTra siiCuadranteOrdenTra =
            cuadranteOrdenTraDao.insertar(conversionVoEntidad.convertir(cuadranteOrdenTraVo));
        if (siiCuadranteOrdenTra != null)
            resultado = new CuadranteOrdenTraVO(siiCuadranteOrdenTra);

        return (resultado);
    }

    /**
     * Actualizar el cuadrante de la orden de trabajo de visita
     * @param cuadranteOrdenTraVo
     * @return resultado - Cuadrante que se actualizó en la BD
     * @throws ExcepcionDAO
     */
    public CuadranteOrdenTraVO actualizarCuadranteOrdenTra(CuadranteOrdenTraVO cuadranteOrdenTraVo, String limite1,
                                                           String limite2, String limite3,
                                                           String limite4) throws ExcepcionDAO {
        CuadranteOrdenTraVO resultado = null;

/*        if (!cuadranteOrdenTraDao.existeCuadranteOrdenTraXCodOrden(cuadranteOrdenTraVo.getOrdenTrabajoVisitaVO().getOtvCodigo(),
                                                                   limite1, limite2, limite3, limite4)) {*/
            SiiCuadranteOrdenTra siiCuadranteOrdenTra =
                cuadranteOrdenTraDao.actualizar(conversionVoEntidad.convertir(cuadranteOrdenTraVo));
            if (siiCuadranteOrdenTra != null)
                resultado = new CuadranteOrdenTraVO(siiCuadranteOrdenTra);
     //   }

        return (resultado);
    }

    public List<CuadranteOrdenTraVO> buscarCuadranteOrdenTraXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO {
        List<CuadranteOrdenTraVO> resultado = new ArrayList();
        List<SiiCuadranteOrdenTra> listaCuadranteOrdenTra =
            cuadranteOrdenTraDao.buscarTodoCuadranteXOrdenTrab(codOrdenTrabajo);

        if (listaCuadranteOrdenTra != null) {
            for (SiiCuadranteOrdenTra cua : listaCuadranteOrdenTra) {
                resultado.add(new CuadranteOrdenTraVO(cua));
            }
        }

        return resultado;
    }
}
