package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAlcanceInvitacion;

import java.util.Date;
import java.util.List;


public class AlcanceInvitacionVO {
    private Long aliCodigo;
    private Date aliFechaVencim;
    private String aliFormaPago;
    private String aliObligacContrat;
    private String aliOtroTipAlcan;
    private Integer aliTiempoDurac;
    private String aliUnidadDurac;
    private Date aliFecha;
    private Long aliValor;
    private EstadoAlcanceInvVO estadoAlcanceInvVo;
    private ProcesoContratacionVO procesoContratacionVo;
    private List<ReqAlcanceInvVO> reqAlcanceInvListVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private InvitacionProcesoVO invitacionProcesoVo; // no corresponde a al base de datos, se usa en el MB de alcance.
    private Long idEstadoAnterior;

    public AlcanceInvitacionVO() {

    }

    /**
     * @author Modifica Giovanni
     * @param alcanceInvitacion
     */
    public AlcanceInvitacionVO(SiiAlcanceInvitacion alcanceInvitacion) {
        this.aliCodigo = alcanceInvitacion.getAliCodigo();
        this.aliFechaVencim = alcanceInvitacion.getAliFechaVencim();
        this.aliFormaPago = alcanceInvitacion.getAliFormaPago();
        this.aliObligacContrat = alcanceInvitacion.getAliObligacContrat();
        this.aliOtroTipAlcan = alcanceInvitacion.getAliOtroTipAlcan();
        this.aliTiempoDurac = alcanceInvitacion.getAliTiempoDurac();
        this.aliUnidadDurac = alcanceInvitacion.getAliUnidadDurac();
        this.aliValor = alcanceInvitacion.getAliValor();
        this.aliFecha = alcanceInvitacion.getAliFecha();

        //Padres:
        //Archivo Fisico
        if (alcanceInvitacion.getSiiArchivoFisico1() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(alcanceInvitacion.getSiiArchivoFisico1());
        }
        //Estado Alcance
        if (alcanceInvitacion.getSiiEstadoAlcanceInv() != null) {
            this.estadoAlcanceInvVo = new EstadoAlcanceInvVO(alcanceInvitacion.getSiiEstadoAlcanceInv());
            this.idEstadoAnterior = alcanceInvitacion.getSiiEstadoAlcanceInv().getEaiCodigo();
        }
        //Proceso Contratacion
        if (alcanceInvitacion.getSiiProcesoContratacion() != null) {
            this.procesoContratacionVo = new ProcesoContratacionVO(alcanceInvitacion.getSiiProcesoContratacion());
        }
        this.invitacionProcesoVo = new InvitacionProcesoVO(); // no corresponde a la base de datos
    }


    public void setAliCodigo(Long aliCodigo) {
        this.aliCodigo = aliCodigo;
    }

    public void setAliFecha(Date aliFecha) {
        this.aliFecha = aliFecha;
    }

    public Date getAliFecha() {
        return aliFecha;
    }

    public Long getAliCodigo() {
        return aliCodigo;
    }

    public void setAliFechaVencim(Date aliFechaVencim) {
        this.aliFechaVencim = aliFechaVencim;
    }

    public Date getAliFechaVencim() {
        return aliFechaVencim;
    }

    public void setAliFormaPago(String aliFormaPago) {
        this.aliFormaPago = aliFormaPago;
    }

    public String getAliFormaPago() {
        return aliFormaPago;
    }

    public void setAliObligacContrat(String aliObligacContrat) {
        this.aliObligacContrat = aliObligacContrat;
    }

    public String getAliObligacContrat() {
        return aliObligacContrat;
    }

    public void setAliOtroTipAlcan(String aliOtroTipAlcan) {
        this.aliOtroTipAlcan = aliOtroTipAlcan;
    }

    public String getAliOtroTipAlcan() {
        return aliOtroTipAlcan;
    }

    public void setAliTiempoDurac(Integer aliTiempoDurac) {
        this.aliTiempoDurac = aliTiempoDurac;
    }

    public Integer getAliTiempoDurac() {
        return aliTiempoDurac;
    }

    public void setAliUnidadDurac(String aliUnidadDurac) {
        this.aliUnidadDurac = aliUnidadDurac;
    }

    public String getAliUnidadDurac() {
        return aliUnidadDurac;
    }

    public void setAliValor(Long aliValor) {
        this.aliValor = aliValor;
    }

    public Long getAliValor() {
        return aliValor;
    }

    public void setEstadoAlcanceInvVo(EstadoAlcanceInvVO estadoAlcanceInvVo) {
        this.estadoAlcanceInvVo = estadoAlcanceInvVo;
    }

    public EstadoAlcanceInvVO getEstadoAlcanceInvVo() {
        return estadoAlcanceInvVo;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }

    public void setReqAlcanceInvListVo(List<ReqAlcanceInvVO> reqAlcanceInvListVo) {
        this.reqAlcanceInvListVo = reqAlcanceInvListVo;
    }

    public List<ReqAlcanceInvVO> getReqAlcanceInvListVo() {
        return reqAlcanceInvListVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setInvitacionProcesoVo(InvitacionProcesoVO invitacionProcesoVo) {
        this.invitacionProcesoVo = invitacionProcesoVo;
    }

    public InvitacionProcesoVO getInvitacionProcesoVo() {
        return invitacionProcesoVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
