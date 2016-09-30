/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumResultadoVerifDenun;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;

import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;

import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las denuncias de las ordenes de trabajo de visita
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminDenunciaOrdenTrabBean implements AdminDenunciaOrdenTrab {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    @EJB
    private DenunciaOrdenTrabDAO denunciaOrdenTrabDao;

    @EJB
    private DenunciaDAO denunciaDao;

    /**
     * Constructor
     */
    public AdminDenunciaOrdenTrabBean() {
        super();
    }

    /**
     * Insertar la denuncia de la orden de trabajo de visita
     * @param denunciaOrdenTrabVo - Value Object
     * @return resultado - denuncia insertada en la bd
     * @throws ExcepcionDAO
     */
    public DenunciaOrdenTrabVO insertarDenunciaOrdenTrab(DenunciaOrdenTrabVO denunciaOrdenTrabVo) throws ExcepcionDAO {
        DenunciaOrdenTrabVO resultado = null;
        SiiDenunciaOrdenTrab siiDenunciaOrdenTrab = denunciaOrdenTrabDao.insertar(conversionVoEntidad.convertir(denunciaOrdenTrabVo));
        if(siiDenunciaOrdenTrab != null)
            resultado = new DenunciaOrdenTrabVO(siiDenunciaOrdenTrab);

        return (resultado);
    }

    /**
     * Actualizar la denuncia de la orden de trabajo de visita
     * @param denunciaOrdenTrabVo - Value Object
     * @return resultado - denuncia insertada en la bd
     * @throws ExcepcionDAO
     */
    public DenunciaOrdenTrabVO actualizarDenunciaOrdenTrab(DenunciaOrdenTrabVO denunciaOrdenTrabVo) throws ExcepcionDAO {
        DenunciaOrdenTrabVO resultado = null;

        // if(!denunciaOrdenTrabDao.existeDenunciaOrdenTrabXCod(denunciaOrdenTrabVo.getDenunciaVO().getDenCodigo())){

        SiiDenunciaOrdenTrab siiDenunciaOrdenTrab = denunciaOrdenTrabDao.actualizar(conversionVoEntidad.convertir(denunciaOrdenTrabVo));

        if(siiDenunciaOrdenTrab != null)
            resultado = new DenunciaOrdenTrabVO(siiDenunciaOrdenTrab);

        // }


        return (resultado);
    }

    /**
     * Buscar denuncias por estado pendiente trabajo de campo
     * @return resultado - lista de denuncias
     * @throws ExcepcionDAO
     */
    private List<DenunciaVO> buscarDenunciasXPendienteTrabajoCampo() throws ExcepcionDAO {
        List<DenunciaVO> resultado = new ArrayList();
        List<SiiDenuncia> listaDenuncias = denunciaDao.buscarDenunciasPorResultadoVerif(EnumResultadoVerifDenun.PENDIENTE_TRABAJO_EN_CAMPO.getId());

        if(listaDenuncias != null) {
            for(SiiDenuncia den : listaDenuncias) {
                resultado.add(new DenunciaVO(den));
            }
        }


        return resultado;
    }

    /**
     * Buscar denuncias pendientes no agregadas
     * @param listaSeleccionDenuncia
     * @return
     * @throws ExcepcionDAO
     */

    public List<DenunciaVO> buscarDenunciasXPendienteTrabajoCampoNoAgregadas(List<DenunciaVO> listaSeleccionDenuncia) throws ExcepcionDAO {
        List<DenunciaVO> listaSeleccionDenunciasPendientes = new ArrayList<DenunciaVO>();
        List<DenunciaVO> listaDenunciasPendienteTrabCampo = buscarDenunciasXPendienteTrabajoCampo();

        if(listaDenunciasPendienteTrabCampo != null) {
            for(DenunciaVO den : listaDenunciasPendienteTrabCampo) {
                if(listaSeleccionDenuncia != null) {
                    boolean res = true;
                    if(!this.denunciaOrdenTrabDao.existeDenunciaOrdenTrabXCod(den.getDenCodigo())) {
                        for(DenunciaVO denunciaAgregada : listaSeleccionDenuncia) {
                            if(den.getDenCodigo().equals(denunciaAgregada.getDenCodigo())) {
                                res = false;
                            }
                        }

                        if(res) {
                            listaSeleccionDenunciasPendientes.add(den);
                        }
                    }

                }

            }
        }

        return listaSeleccionDenunciasPendientes;
    }

    /**
     * Buscar denuncias con orden de trabajo asociada
     * @return resultado - lista de denuncias
     * @throws ExcepcionDAO
     */
    public List<DenunciaVO> buscarDenunciasXOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO {
        List<DenunciaVO> resultado = new ArrayList();
        List<SiiDenunciaOrdenTrab> listaDenunciasOrdenTrab = denunciaOrdenTrabDao.buscarTodoDenunciaOrdenTrabXCodigoOrdenTrab(codOrdenTrabajo);

        if(listaDenunciasOrdenTrab != null) {
            for(SiiDenunciaOrdenTrab den : listaDenunciasOrdenTrab) {
                resultado.add(new DenunciaVO(den.getSiiDenuncia()));
            }
        }

        return resultado;
    }

    /**
     * Buscar todas las denuncias de orden de trabajo, según id de orden de trabajo y id de denuncia.
     * @param otvCodigo
     * @param denCodigo
     * @return resultado - Lista de denuncias de orden de trabajo
     * @throws ExcepcionDAO
     */

    public DenunciaOrdenTrabVO buscarDenunciaOrdTrabXIdOrdTrabXIdDenuncia(Long otvCodigo, Long denCodigo) throws ExcepcionDAO {
        DenunciaOrdenTrabVO resultado = null;
   
        Long idDenunciaOrdenTrab = denunciaOrdenTrabDao.buscarDenunciaOrdTrabXIdOrdTrabXIdDenuncia(otvCodigo, denCodigo);
        if(idDenunciaOrdenTrab != 0L) {
            resultado = new DenunciaOrdenTrabVO();
            SiiDenunciaOrdenTrab siiDenunciaOrdenTrab = new SiiDenunciaOrdenTrab();
            siiDenunciaOrdenTrab.setDotActivo(null);
            siiDenunciaOrdenTrab = denunciaOrdenTrabDao.buscarPorCodigo(idDenunciaOrdenTrab);

            if(siiDenunciaOrdenTrab != null) {
                resultado = new DenunciaOrdenTrabVO(siiDenunciaOrdenTrab);
            }


        }

  
        
        return (resultado);
    }
}
