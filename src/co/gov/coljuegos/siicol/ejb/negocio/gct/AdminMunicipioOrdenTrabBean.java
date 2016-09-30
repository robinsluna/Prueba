/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MunicipioOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;

import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los municipios de las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminMunicipioOrdenTrabBean implements AdminMunicipioOrdenTrab {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private MunicipioOrdenTrabDAO municipioOrdenTrabDao;

    /**
     * Constructor.
     */
    public AdminMunicipioOrdenTrabBean() {
        super();
    }

    /**
     * Insertar el municipio de la orden de trabajo de visita
     * @param municipioOrdenTrabVo - Value Object
     * @return resultado - municipio insertado en la bd
     * @throws ExcepcionDAO
     */
    public MunicipioOrdenTrabVO insertarMunicipioOrdenTrab(MunicipioOrdenTrabVO municipioOrdenTrabVo) throws ExcepcionDAO {
        MunicipioOrdenTrabVO resultado = null;
        SiiMunicipioOrdenTrab siiMunicipioOrdenTrab =
            municipioOrdenTrabDao.insertar(conversionVoEntidad.convertir(municipioOrdenTrabVo));
        if (siiMunicipioOrdenTrab != null)
            resultado = new MunicipioOrdenTrabVO(siiMunicipioOrdenTrab);

        return (resultado);
    }

    /**
     * Actualizar el municipio de la orden de trabajo de visita
     * @param municipioOrdenTrabVo - Value Object
     * @return resultado - municipio actualizado en la bd
     * @throws ExcepcionDAO
     */
    public MunicipioOrdenTrabVO actualizarMunicipioOrdenTrab(MunicipioOrdenTrabVO municipioOrdenTrabVo) throws ExcepcionDAO {
        MunicipioOrdenTrabVO resultado = null;

      /*  if (!municipioOrdenTrabDao.existeMunicipioOrdenTrabXCodOrdenXCodUbicacion(municipioOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo(),
                                                                                  municipioOrdenTrabVo.getUbicacionMunicipioVO().getUbiCodigo())) {*/
            SiiMunicipioOrdenTrab siiMunicipioOrdenTrab =
                municipioOrdenTrabDao.actualizar(conversionVoEntidad.convertir(municipioOrdenTrabVo));
            if (siiMunicipioOrdenTrab != null)
                resultado = new MunicipioOrdenTrabVO(siiMunicipioOrdenTrab);
    //    }
        return (resultado);
    }

    /**
     * Buscar municipio con orden de trabajo según código de orden de trabajo de visita.
     * @param codOrdenTrabajo
     * @return resultado - Lista de municipios
     * @throws ExcepcionDAO
     */
    public List<MunicipioOrdenTrabVO> buscarMunicipioOrdenTrabXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO {
        List<MunicipioOrdenTrabVO> resultado = new ArrayList();
        List<SiiMunicipioOrdenTrab> listaMunicipioOrdenTrab =
            municipioOrdenTrabDao.buscarTodoMunicipioOrdenTrabXCodigoOrdenTrab(codOrdenTrabajo);

        if (listaMunicipioOrdenTrab != null) {
            for (SiiMunicipioOrdenTrab mun : listaMunicipioOrdenTrab) {
                resultado.add(new MunicipioOrdenTrabVO(mun));
            }
        }

        return resultado;
    }

}
