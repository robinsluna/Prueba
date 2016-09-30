package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import java.util.ArrayList;
import java.util.List;

public class ProcesoContratacionVO implements Comparable<ProcesoContratacionVO>{
//    private static final long serialVersionUID = 5811837850455567845L;
    private Long prcCodigo;
    private String prcObjeto;
    private EstadoProcContratVO estadoProcContrat;
    private ExpedienteFisicoVO expedienteFisicoVo;
    private List<SolicitudEstMercadoVO> solicitudEstMercadoListVo;
    private List<EstudioMercadoVO> estudioMercadoListVo;
    private List<ItemPlanContratacVO> itemPlanContratacListVo;
    private List<RecepcionPropuestasVO> recepcionPropuestasList;
    private List<EvaluacionJurTecFinVO> evaluacionJurTecFinList;
    private List<OficioAdjudicaVO> oficioAdjudicaList;
    private List<InvitacionProcesoVO> InvitacionProcesoListVo;
    private Long idEstadoAnterior;
    private List<PolizaContProvVO> polizaContProvList;
    private List<OficioDesigSupervVO> oficioDesigSupervListVo;
    private List<EstudioPrevioVO> estudioPrevioListVo;
    private List<InvitacionProcesoVO> invitacionProcesoListVo;
    private List<CdpVO> cdpListVo;
    //    private List<TerminosReferenciaVO> siiTerminosReferenciaList;
    private List<AlcanceInvitacionVO> alcanceInvitacionListVo;
    private List<RecepcionPropuestasVO> recepcionPropuestasListVo;
    private List<EvaluacionJurTecFinVO> evaluacionJurTecFinListVo;
    private List<OficioAdjudicaVO> oficioAdjudicaListVo;
    private List<ActaIniContratoVO> actaIniContratoListVo;
    private List<PolizaContProvVO> polizaContProvListVo;
    private ActaIniContratoVO actaIniContratoVo; // campo calculado


    public ProcesoContratacionVO() {
    }

    public ProcesoContratacionVO(SiiProcesoContratacion procesoContratacion) {
        this.prcCodigo = procesoContratacion.getPrcCodigo();
        this.prcObjeto = procesoContratacion.getPrcObjeto();
        if (procesoContratacion.getSiiEstadoProcContrat() != null) {
            this.estadoProcContrat = new EstadoProcContratVO(procesoContratacion.getSiiEstadoProcContrat());
            idEstadoAnterior = procesoContratacion.getSiiEstadoProcContrat().getEpcCodigo();
        }
        if (procesoContratacion.getSiiExpedienteFisico() != null) {
            this.expedienteFisicoVo = new ExpedienteFisicoVO(procesoContratacion.getSiiExpedienteFisico());
        }
        if (actaIniContratoListVo!= null) {
            this.actaIniContratoVo = actaIniContratoListVo.get(0);
        }       
    }

    public void setExpedienteFisicoVo(ExpedienteFisicoVO expedienteFisicoVo) {
        this.expedienteFisicoVo = expedienteFisicoVo;
    }

    public ExpedienteFisicoVO getExpedienteFisicoVo() {
        return expedienteFisicoVo;
    }

    public void setPrcCodigo(Long prcCodigo) {
        this.prcCodigo = prcCodigo;
    }

    public Long getPrcCodigo() {
        return prcCodigo;
    }

    public void setPrcObjeto(String prcObjeto) {
        this.prcObjeto = prcObjeto;
    }

    public String getPrcObjeto() {
        return prcObjeto;
    }

    public void setSolicitudEstMercadoListVo(List<SolicitudEstMercadoVO> solicitudEstMercadoListVo) {
        this.solicitudEstMercadoListVo = solicitudEstMercadoListVo;
    }

    public List<SolicitudEstMercadoVO> getSolicitudEstMercadoListVo() {
        return solicitudEstMercadoListVo;
    }

    public void setItemPlanContratacListVo(List<ItemPlanContratacVO> itemPlanContratacListVo) {
        this.itemPlanContratacListVo = itemPlanContratacListVo;
    }

    public List<ItemPlanContratacVO> getItemPlanContratacListVo() {
        return itemPlanContratacListVo;
    }

    public void setEstadoProcContrat(EstadoProcContratVO estadoProcContrat) {
        this.estadoProcContrat = estadoProcContrat;
    }

    public EstadoProcContratVO getEstadoProcContrat() {
        return estadoProcContrat;
    }


    public void setRecepcionPropuestasList(List<RecepcionPropuestasVO> recepcionPropuestasList) {
        this.recepcionPropuestasList = recepcionPropuestasList;
    }

    public List<RecepcionPropuestasVO> getRecepcionPropuestasList() {
        return recepcionPropuestasList;
    }

    public void setInvitacionProcesoListVo(List<InvitacionProcesoVO> InvitacionProcesoListVo) {
        this.InvitacionProcesoListVo = InvitacionProcesoListVo;
    }

    public List<InvitacionProcesoVO> getInvitacionProcesoListVo() {
        return InvitacionProcesoListVo;
    }

    public void setOficioDesigSupervListVo(List<OficioDesigSupervVO> oficioDesigSupervListVo) {
        this.oficioDesigSupervListVo = oficioDesigSupervListVo;
    }

    public List<OficioDesigSupervVO> getOficioDesigSupervListVo() {
        return oficioDesigSupervListVo;
    }

    public void setEstudioPrevioListVo(List<EstudioPrevioVO> estudioPrevioListVo) {
        this.estudioPrevioListVo = estudioPrevioListVo;
    }

    public List<EstudioPrevioVO> getEstudioPrevioListVo() {
        return estudioPrevioListVo;
    }

    public void setInvitacionProcesoListVo1(List<InvitacionProcesoVO> invitacionProcesoListVo) {
        this.invitacionProcesoListVo = invitacionProcesoListVo;
    }

    public List<InvitacionProcesoVO> getInvitacionProcesoListVo1() {
        return invitacionProcesoListVo;
    }

    public void setCdpListVo(List<CdpVO> cdpListVo) {
        this.cdpListVo = cdpListVo;
    }

    public List<CdpVO> getCdpListVo() {
        return cdpListVo;
    }

    public void setAlcanceInvitacionListVo(List<AlcanceInvitacionVO> alcanceInvitacionListVo) {
        this.alcanceInvitacionListVo = alcanceInvitacionListVo;
    }

    public List<AlcanceInvitacionVO> getAlcanceInvitacionListVo() {
        return alcanceInvitacionListVo;
    }

    public void setRecepcionPropuestasListVo(List<RecepcionPropuestasVO> recepcionPropuestasListVo) {
        this.recepcionPropuestasListVo = recepcionPropuestasListVo;
    }

    public List<RecepcionPropuestasVO> getRecepcionPropuestasListVo() {
        return recepcionPropuestasListVo;
    }

    public void setEvaluacionJurTecFinListVo(List<EvaluacionJurTecFinVO> evaluacionJurTecFinListVo) {
        this.evaluacionJurTecFinListVo = evaluacionJurTecFinListVo;
    }

    public List<EvaluacionJurTecFinVO> getEvaluacionJurTecFinListVo() {
        return evaluacionJurTecFinListVo;
    }

    public void setOficioAdjudicaListVo(List<OficioAdjudicaVO> oficioAdjudicaListVo) {
        this.oficioAdjudicaListVo = oficioAdjudicaListVo;
    }

    public List<OficioAdjudicaVO> getOficioAdjudicaListVo() {
        return oficioAdjudicaListVo;
    }

    public void setActaIniContratoListVo(List<ActaIniContratoVO> actaIniContratoListVo) {
        this.actaIniContratoListVo = actaIniContratoListVo;
    }

    public List<ActaIniContratoVO> getActaIniContratoListVo() {
        return actaIniContratoListVo;
    }

    public void setPolizaContProvListVo(List<PolizaContProvVO> polizaContProvListVo) {
        this.polizaContProvListVo = polizaContProvListVo;
    }

    public List<PolizaContProvVO> getPolizaContProvListVo() {
        return polizaContProvListVo;
    }

    /**
     * Adiciona una Solicitud de Estudio Mercado VO.
     * @param solicitudEstMercadoVO
     * @return adicionado?
     */
    public boolean addSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVO) {
        boolean adicionado = false;

        if (solicitudEstMercadoListVo == null)
            solicitudEstMercadoListVo = new ArrayList<SolicitudEstMercadoVO>();

        if (solicitudEstMercadoVO != null) {
            adicionado = solicitudEstMercadoListVo.add(solicitudEstMercadoVO);

            if (adicionado)
                solicitudEstMercadoVO.setProcesoContratacionVo(this);
        }
        return (adicionado);
    }

    /**
     * Elimina una Solicitud de  Estudio de Mercado.
     * @param solicitudEstMercadoVO
     * @return eliminado?
     */
    public boolean removeSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVO) {
        boolean eliminado = false;

        if (solicitudEstMercadoVO != null && solicitudEstMercadoListVo != null) {
            eliminado = solicitudEstMercadoListVo.remove(solicitudEstMercadoVO);

            if (eliminado)
                solicitudEstMercadoVO.setProcesoContratacionVo(null);
        }

        return (eliminado);
    }


    /**
     * Obtiene la Solicitud de Estudio de Mercado asociado al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, s&oacute;lamente existe una (1) Solicitud de Estudio de Mercado por Proceso de Contrataci&oacute;n).
     * @return solicitudEstMercadoListVo[0]
     */
    public SolicitudEstMercadoVO getSolicitudEstMercado() {
        return (solicitudEstMercadoListVo != null && !solicitudEstMercadoListVo.isEmpty() ?
                solicitudEstMercadoListVo.get(0) : null);
    }


    /**
     * Establece la Solicitud de Estudio de Mercado.
     * (En la pr&aacute;ctica, s&oacute;lamente existe una (1) Solicitud de Estudio de Mercado por Proceso de Contrataci&oacute;n).
     * @param solicitudEstMercadoVO
     */
    public void setSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVO) {
        if (solicitudEstMercadoListVo != null)
            solicitudEstMercadoListVo.clear();

        this.addSolicitudEstMercado(solicitudEstMercadoVO);
    }


    public void setEstudioMercadoListVo(List<EstudioMercadoVO> estudioMercadoListVo) {
        this.estudioMercadoListVo = estudioMercadoListVo;
    }

    public List<EstudioMercadoVO> getEstudioMercadoListVo() {
        return estudioMercadoListVo;
    }

    /**
     * Adiciona un Estudio Mercado VO.
     * @param estudioMercadoVO
     * @return adicionado?
     */
    public boolean addEstudioMercado(EstudioMercadoVO estudioMercadoVO) {
        boolean adicionado = false;

        if (estudioMercadoListVo == null)
            estudioMercadoListVo = new ArrayList<EstudioMercadoVO>();

        if (estudioMercadoVO != null) {
            adicionado = estudioMercadoListVo.add(estudioMercadoVO);

            if (adicionado)
                estudioMercadoVO.setProcesoContratacionVO(this);
        }
        return (adicionado);
    }

    /**
     * Elimina un Estudio de Mercado.
     * @param estudioMercadoVO
     * @return eliminado?
     */
    public boolean removeEstudioMercado(EstudioMercadoVO estudioMercadoVO) {
        boolean eliminado = false;

        if (estudioMercadoVO != null && estudioMercadoListVo != null) {
            eliminado = estudioMercadoListVo.remove(estudioMercadoVO);

            if (eliminado)
                estudioMercadoVO.setProcesoContratacionVO(null);
        }

        return (eliminado);
    }


    /**
     * Obtiene el Estudio de Mercado asociado al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Estudio de Mercado por Proceso de Contrataci&oacute;n).
     * @return estudioMercadoListVo[0]
     */
    public EstudioMercadoVO getEstudioMercado() {
        return (estudioMercadoListVo != null && !estudioMercadoListVo.isEmpty() ? estudioMercadoListVo.get(0) : null);
    }


    /**
     * Establece el Estudio de Mercado.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Estudio de Mercado por Proceso de Contrataci&oacute;n).
     * @param estudioMercadoVO
     */
    public void setEstudioMercado(EstudioMercadoVO estudioMercadoVO) {
        if (estudioMercadoListVo != null)
            estudioMercadoListVo.clear();

        this.addEstudioMercado(estudioMercadoVO);
    }

    /**
     * Adiciona una Recepci&oacute;n Propuestas VO.
     * @param recepcionPropuestasVO
     * @return adicionado?
     */
    public boolean addRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestasVO) {
        boolean adicionado = false;

        if (recepcionPropuestasList == null)
            recepcionPropuestasList = new ArrayList<RecepcionPropuestasVO>();

        if (recepcionPropuestasVO != null) {
            adicionado = getRecepcionPropuestasList().add(recepcionPropuestasVO);

            if (adicionado)
                recepcionPropuestasVO.setProcesoContratacion(this);
        }
        return (adicionado);
    }


    /**
     * Elimina una Recepci&oacute;n Propuestas.
     * @param recepcionPropuestasVO
     * @return eliminado?
     */
    public boolean removeRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestasVO) {
        boolean eliminado = false;

        if (recepcionPropuestasVO != null && recepcionPropuestasList != null) {
            eliminado = getRecepcionPropuestasList().remove(recepcionPropuestasVO);

            if (eliminado)
                recepcionPropuestasVO.setProcesoContratacion(null);
        }

        return (eliminado);
    }


    /**
     * Obtiene la Recepci&oacute;n Propuestas asociada al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe una (1) recepci&oacute;n propuestas por proceso de contrataci&oacute;n).
     * @return recepcionPropuestasList.first
     */
    public RecepcionPropuestasVO getRecepcionPropuestas() {
        return (recepcionPropuestasList != null && !recepcionPropuestasList.isEmpty() ? recepcionPropuestasList.get(0) :
                null);
    }


    /**
     * Establece la Recepci&oacute;n Propuestas asociada al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe una (1) recepci&oacute;n propuestas por proceso de contrataci&oacute;n).
     * @param recepcionPropuestasVO
     */
    public void setRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestasVO) {
        if (recepcionPropuestasList != null)
            recepcionPropuestasList.clear();
        else
            recepcionPropuestasList = new ArrayList<RecepcionPropuestasVO>();

        this.addRecepcionPropuestas(recepcionPropuestasVO);
    }


    /**
     * Establece el listado de Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera.
     * @param evaluacionJurTecFinList
     */
    public void setEvaluacionJurTecFinList(List<EvaluacionJurTecFinVO> evaluacionJurTecFinList) {
        this.evaluacionJurTecFinList = evaluacionJurTecFinList;
    }


    /**
     * Obtiene el listado de Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera.
     * @return evaluacionJurTecFinList
     */
    public List<EvaluacionJurTecFinVO> getEvaluacionJurTecFinList() {
        return evaluacionJurTecFinList;
    }


    /**
     * Adiciona una Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera VO.
     * @param evaluacionJurTecFinVO
     * @return adicionado?
     */
    public boolean addEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO) {
        boolean adicionado = false;

        if (evaluacionJurTecFinList == null)
            evaluacionJurTecFinList = new ArrayList<EvaluacionJurTecFinVO>();

        if (evaluacionJurTecFinVO != null) {
            adicionado = getEvaluacionJurTecFinList().add(evaluacionJurTecFinVO);

            if (adicionado)
                evaluacionJurTecFinVO.setProcesoContratacion(this);
        }
        return (adicionado);
    }


    /**
     * Elimina una Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera VO.
     * @param evaluacionJurTecFinVO
     * @return eliminado?
     */
    public boolean removeEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO) {
        boolean eliminado = false;

        if (evaluacionJurTecFinVO != null && evaluacionJurTecFinList != null) {
            eliminado = getEvaluacionJurTecFinList().remove(evaluacionJurTecFinVO);

            if (eliminado)
                evaluacionJurTecFinVO.setProcesoContratacion(null);
        }

        return (eliminado);
    }


    /**
     * Obtiene la Evaluaci&oacute;n de Propuestas asociada al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe una (1) evaluaci&oacute;n de propuestas por proceso de contrataci&oacute;n).
     * @return evaluacionJurTecFinList.first
     */
    public EvaluacionJurTecFinVO getEvaluacionJurTecFin() {
        return (evaluacionJurTecFinList != null && !evaluacionJurTecFinList.isEmpty() ? evaluacionJurTecFinList.get(0) :
                null);
    }


    /**
     * Establece la Evaluaci&oacute;n de Propuestas asociada al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe una (1) evaluaci&oacute;n propuestas por proceso de contrataci&oacute;n).
     * @param evaluacionJurTecFinVO
     */
    public void setEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO) {
        if (evaluacionJurTecFinList != null)
            evaluacionJurTecFinList.clear();
        else
            evaluacionJurTecFinList = new ArrayList<EvaluacionJurTecFinVO>();

        this.addEvaluacionJurTecFin(evaluacionJurTecFinVO);
    }


    /**
     * Obtiene el Nombre del Estado de Evaluaci&oacute;n asociada al Proceso de Contrataci&oacute;n.
     * @return procesoContratacion.evaluacion.estado
     */
    public String getNombreEstadoEvaluacionJurTecFin() {
        String estado = null;

        EvaluacionJurTecFinVO evaluacion = this.getEvaluacionJurTecFin();

        if (evaluacion != null) {
            EstadoEvaluacionJtfVO estadoVO = evaluacion.getEstadoEvaluacionJtf();
            if (estadoVO != null) {
                estado = estadoVO.getEejNombre();
            }
        }

        return (estado);
    }


    public void setOficioAdjudicaList(List<OficioAdjudicaVO> oficioAdjudicaList) {
        this.oficioAdjudicaList = oficioAdjudicaList;
    }

    public List<OficioAdjudicaVO> getOficioAdjudicaList() {
        return oficioAdjudicaList;
    }


    /**
     * Adiciona un Oficio de Adjudicaci&oacute;n VO.
     * @param oficioAdjudicaVO
     * @return adicionado?
     */
    public boolean addOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) {
        boolean adicionado = false;

        if (oficioAdjudicaList == null)
            oficioAdjudicaList = new ArrayList<OficioAdjudicaVO>();

        if (oficioAdjudicaVO != null) {
            adicionado = getOficioAdjudicaList().add(oficioAdjudicaVO);

            if (adicionado)
                oficioAdjudicaVO.setProcesoContratacion(this);
        }
        return (adicionado);
    }


    /**
     * Elimina un Oficio de Adjudicaci&oacute;n.
     * @param oficioAdjudicaVO
     * @return eliminado?
     */
    public boolean removeOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) {
        boolean eliminado = false;

        if (oficioAdjudicaVO != null && oficioAdjudicaList != null) {
            eliminado = getOficioAdjudicaList().remove(oficioAdjudicaVO);

            if (eliminado)
                oficioAdjudicaVO.setProcesoContratacion(null);
        }

        return (eliminado);
    }


    /**
     * Obtiene el Oficio de Adjudicaci&oacute;n asociado al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe un (1) Oficio de Adjudicaci&oacute;n por proceso de contrataci&oacute;n).
     * @return oficioAdjudicaList.first
     */
    public OficioAdjudicaVO getOficioAdjudica() {
        return (oficioAdjudicaList != null && !oficioAdjudicaList.isEmpty() ? oficioAdjudicaList.get(0) : null);
    }


    /**
     * Establece el Oficio de Adjudicaci&oacute;n asociado al Proceso de Contrataci&oacute;n.
     * (En la pr&aacute;ctica, solamente existe un (1) Oficio de Adjudicaci&oacute;n por proceso de contrataci&oacute;n).
     * @param oficioAdjudicaVO
     */
    public void setOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) {
        if (oficioAdjudicaList != null)
            oficioAdjudicaList.clear();
        else
            oficioAdjudicaList = new ArrayList<OficioAdjudicaVO>();

        this.addOficioAdjudica(oficioAdjudicaVO);
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }


    /**
     * Obtiene el Nombre del Estado del Oficio de Adjudicaci&oacute;n asociado al Proceso de Contrataci&oacute;n.
     * @return procesoContratacion.oficioAdjudica.estado
     */
    public String getNombreEstadoOficioAdjudica() {
        String estado = null;

        OficioAdjudicaVO adjudicacion = this.getOficioAdjudica();

        if (adjudicacion != null) {
            String idEstado = adjudicacion.getOadEstado();
            if (idEstado != null) {
                estado = EnumEstado.getNombreById(idEstado);
            }
        }

        return (estado);
    }


    public String getTipoContratoMinuta() {
        String tipoContrato = null;
        OficioAdjudicaVO oficioAdjudicaVo = this.getOficioAdjudica();
        if (oficioAdjudicaVo.getOadTipoContr() != null) {
            tipoContrato = oficioAdjudicaVo.getOadTipoContr();
        }
        return tipoContrato;
    }

    public String getNumeroContratoMinuta() {
        String numeroContrato = null;
        OficioAdjudicaVO oficioAdjudicaVo = this.getOficioAdjudica();
        if (oficioAdjudicaVo.getOadConsecContr() != null && oficioAdjudicaVo.getOadVigenciaContr() != null) {
            numeroContrato =
                oficioAdjudicaVo.getOadConsecContr().toString() + " - " + oficioAdjudicaVo.getOadVigenciaContr();
        }
        return numeroContrato;
    }

    public String getEstadoMinuta() {
        String estadoMinuta = null;
        OficioAdjudicaVO oficioAdjudicaVo = this.getOficioAdjudica();
        if (oficioAdjudicaVo.getOadEstado() != null) {
            if (oficioAdjudicaVo.getOadEstado().equals("A")) {
                estadoMinuta = "APROBADO";
            } else if (oficioAdjudicaVo.getOadEstado().equals("B")) {
                estadoMinuta = "BORRADOR";
            }
        }
        return estadoMinuta;
    }

    public void setPolizaContProvList(List<PolizaContProvVO> polizaContProvList) {
        this.polizaContProvList = polizaContProvList;
    }

    public List<PolizaContProvVO> getPolizaContProvList() {
        return polizaContProvList;
    }

    public boolean addPolizaContProv(PolizaContProvVO polizaContProvVo) {
        boolean adicionado = false;
        if (polizaContProvList == null) {
            polizaContProvList = new ArrayList<PolizaContProvVO>();
        }
        if (polizaContProvVo != null) {
            adicionado = getPolizaContProvList().add(polizaContProvVo);
            if (adicionado) {
                polizaContProvVo.setProcesoContratacionVo(this);
            }
        }
        return (adicionado);
    }

    public boolean removePolizaContProv(PolizaContProvVO polizaContProvVo) {
        boolean eliminado = false;
        if (polizaContProvVo != null && polizaContProvList != null) {
            eliminado = getPolizaContProvList().remove(polizaContProvVo);
        }
        if (eliminado) {
            polizaContProvVo.setProcesoContratacionVo(null);
        }
        return eliminado;
    }

    public PolizaContProvVO getPolizaContProv() {
        return (polizaContProvList != null && !polizaContProvList.isEmpty() ? polizaContProvList.get(0) : null);
    }

    public void setPolizaContProv(PolizaContProvVO polizaContProvVo) {
        if (polizaContProvList != null) {
            polizaContProvList.clear();
        } else {
            polizaContProvList = new ArrayList<PolizaContProvVO>();
        }
        this.addPolizaContProv(polizaContProvVo);
    }

    public String getNumeroPolizaProveedor() {
        String numeroPoliza = null;
        PolizaContProvVO polizaContProvVo = this.getPolizaContProv();
        if (polizaContProvVo != null) {
            numeroPoliza = polizaContProvVo.getPcpNumero();
        }
        return numeroPoliza;
    }

    public String getEstadoPolizaProveedor() {
        String estadoPoliza = null;
        PolizaContProvVO polizaContProvVo = this.getPolizaContProv();
        if (polizaContProvVo != null) {
            if (polizaContProvVo.getPcpEstado().equals("A")) {
                estadoPoliza = "APROBADO";
            } else if (polizaContProvVo.getPcpEstado().equals("B")) {
                estadoPoliza = "BORRADOR";
            }
        }
        return estadoPoliza;
    }


    public boolean addOficioDesigSuperv(OficioDesigSupervVO oficioDesigSupervVo) {
        boolean adicionado = false;
        if (oficioDesigSupervListVo == null) {
            oficioDesigSupervListVo = new ArrayList<OficioDesigSupervVO>();
        }
        if (oficioDesigSupervVo != null) {
            adicionado = getOficioDesigSupervListVo().add(oficioDesigSupervVo);
            if (adicionado) {
                oficioDesigSupervVo.setProcesoContratacionVo(this);
            }
        }
        return (adicionado);
    }

    public boolean removeOficioDesigSuperv(OficioDesigSupervVO oficioDesigSupervVo) {
        boolean eliminado = false;
        if (oficioDesigSupervVo != null && oficioDesigSupervListVo != null) {
            eliminado = getOficioDesigSupervListVo().remove(oficioDesigSupervVo);
        }
        if (eliminado) {
            oficioDesigSupervVo.setProcesoContratacionVo(null);
        }
        return eliminado;
    }

    public OficioDesigSupervVO getOficioDesigSuperv() {
        return (oficioDesigSupervListVo != null && !oficioDesigSupervListVo.isEmpty() ? oficioDesigSupervListVo.get(0) :
                null);
    }

    public void setOficioDesigSuperv(OficioDesigSupervVO oficioDesigSupervVo) {
        if (oficioDesigSupervListVo != null) {
            oficioDesigSupervListVo.clear();
        } else {
            oficioDesigSupervListVo = new ArrayList<OficioDesigSupervVO>();
        }
        this.addOficioDesigSuperv(oficioDesigSupervVo);
    }

    public String getEstadoDesignacionSupervisor() {
        String estadoDesignacionSupervisor = null;
        OficioDesigSupervVO oficioDesigSupervVo = this.getOficioDesigSuperv();
        if (oficioDesigSupervVo != null) {
            if (oficioDesigSupervVo.getOdsEstado().equals("A")) {
                estadoDesignacionSupervisor = "APROBADO";
            } else if (oficioDesigSupervVo.getOdsEstado().equals("B")) {
                estadoDesignacionSupervisor = "BORRADOR";
            }
        }
        return estadoDesignacionSupervisor;
    }

    public Long getNumeroDesignacionSupervisor() {
        Long numeroDesignacionSupervisor = 0L;
        OficioDesigSupervVO oficioDesigSupervVo = this.getOficioDesigSuperv();
        if (oficioDesigSupervVo != null) {
            numeroDesignacionSupervisor = oficioDesigSupervVo.getOdsCodgo();
        }
        return numeroDesignacionSupervisor;
    }

    public void setActaIniContratoVo(ActaIniContratoVO actaIniContratoVo) {
        this.actaIniContratoVo = actaIniContratoVo;
    }

    public ActaIniContratoVO getActaIniContratoVo() {
        return actaIniContratoVo;
    }
    
    public int compareTo(ProcesoContratacionVO compareProcesoVO) {

        //descending order 
        if (compareProcesoVO.getPrcCodigo() != null )
            return compareProcesoVO.getPrcCodigo().compareTo(this.getPrcCodigo());        
        else if (this.getPrcCodigo() != null)
            return -1;
        else
            return 0;

    }
}

