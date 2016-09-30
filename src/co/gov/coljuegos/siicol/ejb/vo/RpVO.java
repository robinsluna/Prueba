/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 18-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


public class RpVO {

    private Long rpCodigo;
    private Date rpFechaSolic;
    private List<RpDetRubroCdpVO> RpDetRubroCdpVoList;
    private EstadoRpVO estadoRpVo;
    private Long rpConsecutivo;
    private Date rpFechaRp;
    private String rpFechaStringRp;
    private MotivoAnulRpVO motivoAnulRpVo;
    private MotivoRechSolRpVO motivoRechSolRpVO;
    private CdpVO cdpVo;
    private ProveedorVO proveedorVo;
    private List<CdpRpVO> cdpRpListVo;
    private List<ModificacionRpVO> modificacionRpVoList;
    private List<SolicitudPagoVO> solicitudPagoVoList;
    private List<ObligacionConceptoVO> obligacionConceptoVoList;
    private BigDecimal rpSaldoAnterior;
    private Long rpNumeroSiif;
    private CargaRpVO cargaRpVo;


    public RpVO(SiiRp siiRp) {
        if(siiRp != null) {
            this.rpCodigo = siiRp.getRpCodigo();
            this.rpFechaSolic = siiRp.getRpFechaSolic();
            this.rpConsecutivo = siiRp.getRpConsecutivo();
            this.rpFechaRp = siiRp.getRpFechaRp();
            this.rpSaldoAnterior = siiRp.getRpSaldoAnterior();
            this.rpNumeroSiif = siiRp.getRpNumeroSiif();

            if(siiRp.getSiiEstadoRp() != null) {
                this.estadoRpVo = new EstadoRpVO(siiRp.getSiiEstadoRp());
            }

            if(siiRp.getSiiProveedor() != null) {
                this.proveedorVo = new ProveedorVO(siiRp.getSiiProveedor());
            }

            if(siiRp.getSiiCdp() != null) {
                this.cdpVo = new CdpVO(siiRp.getSiiCdp());
            }

            if(siiRp.getSiiMotivoAnulRp() != null) {
                this.motivoAnulRpVo = new MotivoAnulRpVO(siiRp.getSiiMotivoAnulRp());
            }

            if(siiRp.getSiiMotivoRechSolRp() != null) {
                this.motivoRechSolRpVO = new MotivoRechSolRpVO(siiRp.getSiiMotivoRechSolRp());
            }
            if(siiRp.getSiiCargaRp() != null) {
                this.cargaRpVo = new CargaRpVO(siiRp.getSiiCargaRp());
            }

        }
    }

    public RpVO() {
    }

    public void setProveedorVo(ProveedorVO proveedorVo) {
        this.proveedorVo = proveedorVo;
    }

    public ProveedorVO getProveedorVo() {
        return proveedorVo;
    }

    public void setCdpVo(CdpVO cdpVo) {
        this.cdpVo = cdpVo;
    }

    public CdpVO getCdpVo() {
        if(cdpRpListVo != null && cdpRpListVo.size() > 0)
            return cdpRpListVo.get(0).getCdpVo();
        else
            return cdpVo;
    }

    public void setRpFechaRp(Date rpFechaRp) {
        this.rpFechaRp = rpFechaRp;
    }

    public Date getRpFechaRp() {
        return rpFechaRp;
    }

    public void setRpCodigo(Long rpCodigo) {
        this.rpCodigo = rpCodigo;
    }

    public Long getRpCodigo() {
        return rpCodigo;
    }


    public void setRpFechaSolic(Date rpFechaSolic) {
        this.rpFechaSolic = rpFechaSolic;
    }

    public Date getRpFechaSolic() {
        return rpFechaSolic;
    }

    public void setRpDetRubroCdpVoList(List<RpDetRubroCdpVO> RpDetRubroCdpVoList) {
        this.RpDetRubroCdpVoList = RpDetRubroCdpVoList;
    }

    public List<RpDetRubroCdpVO> getRpDetRubroCdpVoList() {
        return RpDetRubroCdpVoList;
    }

    public void setEstadoRpVo(EstadoRpVO estadoRpVo) {
        this.estadoRpVo = estadoRpVo;
    }

    public EstadoRpVO getEstadoRpVo() {
        return estadoRpVo;
    }

    public void setRpConsecutivo(Long rpConsecutivo) {
        this.rpConsecutivo = rpConsecutivo;
    }

    /**
     * Obtiene la Persona a partir del Proveedor asociado al RP.
     * @return proveedorVo.personaVo
     */
    public PersonaVO getPersonaVo() {
        return (proveedorVo != null ? proveedorVo.getPersonaVo() : null);
    }

    public Long getRpConsecutivo() {
        return rpConsecutivo;
    }

    public void setMotivoAnulRpVo(MotivoAnulRpVO motivoAnulRpVo) {
        this.motivoAnulRpVo = motivoAnulRpVo;
    }

    public MotivoAnulRpVO getMotivoAnulRpVo() {
        return motivoAnulRpVo;
    }

    public void setMotivoRechSolRpVO(MotivoRechSolRpVO motivoRechSolRpVO) {
        this.motivoRechSolRpVO = motivoRechSolRpVO;
    }

    public MotivoRechSolRpVO getMotivoRechSolRpVO() {
        return motivoRechSolRpVO;
    }


    public void setRpFechaStringRp(String rpFechaStringRp) {

        this.rpFechaStringRp = rpFechaStringRp;
    }

    public String getRpFechaStringRp() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return (this.rpFechaRp == null ? "" : df.format(this.rpFechaRp));
    }

    public void setCdpRpListVo(List<CdpRpVO> cdpRpListVo) {
        this.cdpRpListVo = cdpRpListVo;
    }

    public List<CdpRpVO> getCdpRpListVo() {
        return cdpRpListVo;
    }

    public void setModificacionRpVoList(List<ModificacionRpVO> modificacionRpVoList) {
        this.modificacionRpVoList = modificacionRpVoList;
    }

    public List<ModificacionRpVO> getModificacionRpVoList() {
        return modificacionRpVoList;
    }

    public void setSolicitudPagoVoList(List<SolicitudPagoVO> solicitudPagoVoList) {
        this.solicitudPagoVoList = solicitudPagoVoList;
    }

    public List<SolicitudPagoVO> getSolicitudPagoVoList() {
        return solicitudPagoVoList;
    }

    public void setObligacionConceptoVoList(List<ObligacionConceptoVO> obligacionConceptoVoList) {
        this.obligacionConceptoVoList = obligacionConceptoVoList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoVoList() {
        return obligacionConceptoVoList;
    }

    public void setRpSaldoAnterior(BigDecimal rpSaldoAnterior) {
        this.rpSaldoAnterior = rpSaldoAnterior;
    }

    public BigDecimal getRpSaldoAnterior() {
        return rpSaldoAnterior;
    }

    public void setRpNumeroSiif(Long rpNumeroSiif) {
        this.rpNumeroSiif = rpNumeroSiif;
    }

    public Long getRpNumeroSiif() {
        return rpNumeroSiif;
    }

    public void setCargaRpVo(CargaRpVO cargaRpVo) {
        this.cargaRpVo = cargaRpVo;
    }

    public CargaRpVO getCargaRpVo() {
        return cargaRpVo;
    }
}
