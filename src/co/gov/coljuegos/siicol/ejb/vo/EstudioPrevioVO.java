package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;

import java.util.Date;
import java.util.List;

public class EstudioPrevioVO {

    private String epeAnalisiEcon;
    private Long epeCodigo;
    private String epeDescrJustif;
    private Date epeFecha;
    private String epeFormasAnaliz;
    private String epeFormaPago;
    private String epeObligacContrat;
    private Long epePresupEstim;
    private String epeRiesgo;
    private Integer epeTiempoDurac;
    private String epeUnidadDurac;
    private Long epeValorContrat;
    private Integer epeVigencia;
    private List<AmparoEstPrevVO> amparoEstPrevListVo;
    private EstadoEstPrevVO estadoEstPrevVo;
    private List<ReqEstudioPrevioVO> reqEstudioPrevioListVo;
    private UsuarioVO usuarioVo;
    private List<EstPrevDetRubroVO> estPrevDetRubroListVo;
    private TipoGarantiaVO tipoGarantiaVo;
    private UbicacionVO ubicacionVo;
    private ProcesoContratacionVO procesoContratacionVo;
    private ItemPlanContratacVO itemPlanContratacVo;
    private Long idEstadoAnterior;

    public EstudioPrevioVO() {

    }

    /**
     * @author Modifica Giovanni
     * @param siiEstudioPrevio
     */
    public EstudioPrevioVO(SiiEstudioPrevio siiEstudioPrevio) {
        this.epeAnalisiEcon = siiEstudioPrevio.getEpeAnalisiEcon();
        this.epeCodigo = siiEstudioPrevio.getEpeCodigo();
        this.epeDescrJustif = siiEstudioPrevio.getEpeDescrJustif();
        this.epeFecha = siiEstudioPrevio.getEpeFecha();
        this.epeFormaPago = siiEstudioPrevio.getEpeFormaPago();
        this.epeFormasAnaliz = siiEstudioPrevio.getEpeFormasAnaliz();
        this.epeObligacContrat = siiEstudioPrevio.getEpeObligacContrat();
        this.epePresupEstim = siiEstudioPrevio.getEpePresupEstim();
        this.epeRiesgo = siiEstudioPrevio.getEpeRiesgo();
        this.epeTiempoDurac = siiEstudioPrevio.getEpeTiempoDurac();
        this.epeUnidadDurac = siiEstudioPrevio.getEpeUnidadDurac();
        this.epeValorContrat = siiEstudioPrevio.getEpeValorContrat();
        this.epeVigencia = siiEstudioPrevio.getEpeVigencia();

        //Estado Estudio Previo
        if (siiEstudioPrevio.getSiiEstadoEstPrev() != null) {
            this.estadoEstPrevVo = new EstadoEstPrevVO(siiEstudioPrevio.getSiiEstadoEstPrev());
            this.idEstadoAnterior = siiEstudioPrevio.getSiiEstadoEstPrev().getEepCodigo();
        }

        //Usuario
        if (siiEstudioPrevio.getSiiUsuario() != null) {
            this.usuarioVo = new UsuarioVO(siiEstudioPrevio.getSiiUsuario());
        }

        //Tipo Garantia
        if (siiEstudioPrevio.getSiiTipoGarantia() != null) {
            this.tipoGarantiaVo = new TipoGarantiaVO(siiEstudioPrevio.getSiiTipoGarantia());
        }

        //Ubicacion
        if (siiEstudioPrevio.getSiiUbicacion1() != null) {
            this.ubicacionVo = new UbicacionVO(siiEstudioPrevio.getSiiUbicacion1());
        }

        //Proceso Contratacion
        if (siiEstudioPrevio.getSiiProcesoContratacion() != null) {
            this.procesoContratacionVo = new ProcesoContratacionVO(siiEstudioPrevio.getSiiProcesoContratacion());
        }

        //ItemPlan contratacion
        if (siiEstudioPrevio.getSiiItemPlanContratac() != null) {
            this.itemPlanContratacVo = new ItemPlanContratacVO(siiEstudioPrevio.getSiiItemPlanContratac());
        }
    }

    public void setItemPlanContratacVo(ItemPlanContratacVO itemPlanContratacVo) {
        this.itemPlanContratacVo = itemPlanContratacVo;
    }

    public ItemPlanContratacVO getItemPlanContratacVo() {
        return itemPlanContratacVo;
    }

    public void setEpeAnalisiEcon(String epeAnalisiEcon) {
        this.epeAnalisiEcon = epeAnalisiEcon;
    }

    public String getEpeAnalisiEcon() {
        return epeAnalisiEcon;
    }

    public void setEpeCodigo(Long epeCodigo) {
        this.epeCodigo = epeCodigo;
    }

    public Long getEpeCodigo() {
        return epeCodigo;
    }

    public void setEpeDescrJustif(String epeDescrJustif) {
        this.epeDescrJustif = epeDescrJustif;
    }

    public String getEpeDescrJustif() {
        return epeDescrJustif;
    }

    public void setEpeFecha(Date epeFecha) {
        this.epeFecha = epeFecha;
    }

    public Date getEpeFecha() {
        return epeFecha;
    }

    public void setEpeFormasAnaliz(String epeFormasAnaliz) {
        this.epeFormasAnaliz = epeFormasAnaliz;
    }

    public String getEpeFormasAnaliz() {
        return epeFormasAnaliz;
    }

    public void setEpeFormaPago(String epeFormaPago) {
        this.epeFormaPago = epeFormaPago;
    }

    public String getEpeFormaPago() {
        return epeFormaPago;
    }

    public void setEpeObligacContrat(String epeObligacContrat) {
        this.epeObligacContrat = epeObligacContrat;
    }

    public String getEpeObligacContrat() {
        return epeObligacContrat;
    }

    public void setEpePresupEstim(Long epePresupEstim) {
        this.epePresupEstim = epePresupEstim;
    }

    public Long getEpePresupEstim() {
        return epePresupEstim;
    }

    public void setEpeTiempoDurac(Integer epeTiempoDurac) {
        this.epeTiempoDurac = epeTiempoDurac;
    }

    public Integer getEpeTiempoDurac() {
        return epeTiempoDurac;
    }

    public void setEpeUnidadDurac(String epeUnidadDurac) {
        this.epeUnidadDurac = epeUnidadDurac;
    }

    public String getEpeUnidadDurac() {
        return epeUnidadDurac;
    }

    public void setEpeValorContrat(Long epeValorContrat) {
        this.epeValorContrat = epeValorContrat;
    }

    public Long getEpeValorContrat() {
        return epeValorContrat;
    }

    public void setEpeVigencia(Integer epeVigencia) {
        this.epeVigencia = epeVigencia;
    }

    public Integer getEpeVigencia() {
        return epeVigencia;
    }

    public void setAmparoEstPrevListVo(List<AmparoEstPrevVO> amparoEstPrevListVo) {
        this.amparoEstPrevListVo = amparoEstPrevListVo;
    }

    public List<AmparoEstPrevVO> getAmparoEstPrevListVo() {
        return amparoEstPrevListVo;
    }

    public void setEstadoEstPrevVo(EstadoEstPrevVO estadoEstPrevVo) {
        this.estadoEstPrevVo = estadoEstPrevVo;
    }

    public EstadoEstPrevVO getEstadoEstPrevVo() {
        return estadoEstPrevVo;
    }

    public void setReqEstudioPrevioListVo(List<ReqEstudioPrevioVO> reqEstudioPrevioListVo) {
        this.reqEstudioPrevioListVo = reqEstudioPrevioListVo;
    }

    public List<ReqEstudioPrevioVO> getReqEstudioPrevioListVo() {
        return reqEstudioPrevioListVo;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setEstPrevDetRubroListVo(List<EstPrevDetRubroVO> estPrevDetRubroListVo) {
        this.estPrevDetRubroListVo = estPrevDetRubroListVo;
    }

    public List<EstPrevDetRubroVO> getEstPrevDetRubroListVo() {
        return estPrevDetRubroListVo;
    }

    public void setTipoGarantiaVo(TipoGarantiaVO tipoGarantiaVo) {
        this.tipoGarantiaVo = tipoGarantiaVo;
    }

    public TipoGarantiaVO getTipoGarantiaVo() {
        return tipoGarantiaVo;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }

    public void setEpeRiesgo(String epeRiesgo) {
        this.epeRiesgo = epeRiesgo;
    }

    public String getEpeRiesgo() {
        return epeRiesgo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
