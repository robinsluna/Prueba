/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 16-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class CdpVO {

    private Long cdpCodigo;
    private Date cdpFechaSolic;
    private Date cdpFechaExpedicion;
    private String cdpJustificacion;
    private String cdpNumeroDocSop;
    private String cdpObjeto;
    private BigDecimal cdpSaldoAnterior;
    private BigDecimal cdpValorSolicit;
    private Integer cdpVigencia;
    private Integer cdpVigenciaAfectada;
    private UsuarioVO usuarioVO;
    private ProcesoContratacionVO procesoContratacionVO;
    private EstadoCdpVO estadoCdpVO;
    private AreaColjuegosVO areaColjuegosVO;
    private List<DetalleRubroCdpVO> detalleRubroCdpListVO;
    private TipoDocSoporteVO tipoDocSoporteVO;
    private ItemPlanContratacVO itemPlanContratacVO;
    private Long cdpConsecutivo;
    private List<ModificacionCdpVO> modificacionCdpVoList;
    private Long cdpNumeroSiif;
    private String cdpNumVigFut;
    private Long cdpNumContrato;
    private Date cdpFechaCont;
    private String cdpObjetoCont;
    private Date cdpFechaVigFut;
    private List<CdpRpVO> cdpRpListVo;
    private Long idEstadoAnterior;


    public CdpVO() {
    }

    public CdpVO(SiiCdp siiCdp) {
        this.cdpCodigo = siiCdp.getCdpCodigo();
        this.cdpFechaSolic = siiCdp.getCdpFechaSolic();
        this.cdpJustificacion = siiCdp.getCdpJustificacion();
        this.cdpNumeroDocSop = siiCdp.getCdpNumeroDocSop();
        this.cdpObjeto = siiCdp.getCdpObjeto();
        this.cdpSaldoAnterior = siiCdp.getCdpSaldoAnterior();
        this.cdpValorSolicit = siiCdp.getCdpValorSolicit();
        this.cdpVigencia = siiCdp.getCdpVigencia();
        this.cdpVigenciaAfectada = siiCdp.getCdpVigenciaAfectada();
        this.cdpFechaExpedicion = siiCdp.getCdpFechaExpedicion();
        this.cdpConsecutivo = siiCdp.getCdpConsecutivo();
        this.cdpNumeroSiif = siiCdp.getCdpNumeroSiif();
        this.cdpNumVigFut = siiCdp.getCdpNumVigFut();
        this.cdpNumContrato = siiCdp.getCdpNumContrato();
        this.cdpFechaCont = siiCdp.getCdpFechaCont();
        this.cdpObjetoCont = siiCdp.getCdpObjetoCont();
        this.cdpFechaVigFut = siiCdp.getCdpFechaVigFut();
        
        //Padres
        //Estado
        if(siiCdp.getSiiEstadoCdp()!= null){
            this.estadoCdpVO = new EstadoCdpVO(siiCdp.getSiiEstadoCdp());
            this.idEstadoAnterior = siiCdp.getSiiEstadoCdp().getEcdCodigo();
        }
        if(siiCdp.getSiiTipoDocSoporte() != null){
            this.tipoDocSoporteVO = new TipoDocSoporteVO(siiCdp.getSiiTipoDocSoporte());
        }
        if(siiCdp.getSiiProcesoContratacion() != null){
            this.procesoContratacionVO = new ProcesoContratacionVO(siiCdp.getSiiProcesoContratacion());
        }
        if(siiCdp.getSiiUsuario()!= null){
            this.usuarioVO = new UsuarioVO(siiCdp.getSiiUsuario());
        }
        if(siiCdp.getSiiItemPlanContratac() != null){
            this.itemPlanContratacVO = new ItemPlanContratacVO(siiCdp.getSiiItemPlanContratac());
        }
        if(siiCdp.getSiiAreaColjuegos() != null){
            this.areaColjuegosVO = new AreaColjuegosVO(siiCdp.getSiiAreaColjuegos());
        }
    }


    public void setCdpFechaExpedicion(Date cdpFechaExpedicion) {
        this.cdpFechaExpedicion = cdpFechaExpedicion;
    }

    public Date getCdpFechaExpedicion() {
        return cdpFechaExpedicion;
    }

    public void setCdpNumeroSiif(Long cdpNumeroSiif) {
        this.cdpNumeroSiif = cdpNumeroSiif;
    }

    public Long getCdpNumeroSiif() {
        return cdpNumeroSiif;
    }

    public void setModificacionCdpVoList(List<ModificacionCdpVO> modificacionCdpVoList) {
        this.modificacionCdpVoList = modificacionCdpVoList;
    }

    public List<ModificacionCdpVO> getModificacionCdpVoList() {
        return modificacionCdpVoList;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setProcesoContratacionVO(ProcesoContratacionVO procesoContratacionVO) {
        this.procesoContratacionVO = procesoContratacionVO;
    }

    public ProcesoContratacionVO getProcesoContratacionVO() {
        return procesoContratacionVO;
    }


    public void setAreaColjuegosVO(AreaColjuegosVO areaColjuegosVO) {
        this.areaColjuegosVO = areaColjuegosVO;
    }

    public AreaColjuegosVO getAreaColjuegosVO() {
        return areaColjuegosVO;
    }

    public void setDetalleRubroCdpListVO(List<DetalleRubroCdpVO> detalleRubroCdpListVO) {
        this.detalleRubroCdpListVO = detalleRubroCdpListVO;
    }

    public List<DetalleRubroCdpVO> getDetalleRubroCdpListVO() {
        return detalleRubroCdpListVO;
    }


    public void setItemPlanContratacVO(ItemPlanContratacVO itemPlanContratacVO) {
        this.itemPlanContratacVO = itemPlanContratacVO;
    }

    public ItemPlanContratacVO getItemPlanContratacVO() {
        return itemPlanContratacVO;
    }

    public void setCdpConsecutivo(Long cdpConsecutivo) {
        this.cdpConsecutivo = cdpConsecutivo;
    }

    public Long getCdpConsecutivo() {
        return cdpConsecutivo;
    }


    public void setCdpCodigo(Long cdpCodigo) {
        this.cdpCodigo = cdpCodigo;
    }

    public Long getCdpCodigo() {
        return cdpCodigo;
    }

    public void setCdpFechaSolic(Date cdpFechaSolic) {
        this.cdpFechaSolic = cdpFechaSolic;
    }

    public Date getCdpFechaSolic() {
        return cdpFechaSolic;
    }

    public void setCdpJustificacion(String cdpJustificacion) {
        this.cdpJustificacion = cdpJustificacion;
    }

    public String getCdpJustificacion() {
        return cdpJustificacion;
    }

    public void setCdpNumeroDocSop(String cdpNumeroDocSop) {
        this.cdpNumeroDocSop = cdpNumeroDocSop;
    }

    public String getCdpNumeroDocSop() {
        return cdpNumeroDocSop;
    }

    public void setCdpObjeto(String cdpObjeto) {
        this.cdpObjeto = cdpObjeto;
    }

    public String getCdpObjeto() {
        return cdpObjeto;
    }

    public void setCdpVigencia(Integer cdpVigencia) {
        this.cdpVigencia = cdpVigencia;
    }

    public Integer getCdpVigencia() {
        return cdpVigencia;
    }

    public void setCdpVigenciaAfectada(Integer cdpVigenciaAfectada) {
        this.cdpVigenciaAfectada = cdpVigenciaAfectada;
    }

    public Integer getCdpVigenciaAfectada() {
        return cdpVigenciaAfectada;
    }


    public void setEstadoCdpVO(EstadoCdpVO estadoCdpVO) {
        this.estadoCdpVO = estadoCdpVO;
    }

    public EstadoCdpVO getEstadoCdpVO() {
        return estadoCdpVO;
    }


    public void setTipoDocSoporteVO(TipoDocSoporteVO tipoDocSoporteVO) {
        this.tipoDocSoporteVO = tipoDocSoporteVO;
    }

    public TipoDocSoporteVO getTipoDocSoporteVO() {
        return tipoDocSoporteVO;
    }

    public void setCdpSaldoAnterior(BigDecimal cdpSaldoAnterior) {
        this.cdpSaldoAnterior = cdpSaldoAnterior;
    }

    public BigDecimal getCdpSaldoAnterior() {
        return cdpSaldoAnterior;
    }

    public void setCdpValorSolicit(BigDecimal cdpValorSolicit) {
        this.cdpValorSolicit = cdpValorSolicit;
    }

    public BigDecimal getCdpValorSolicit() {
        return cdpValorSolicit;
    }

    public void setCdpNumVigFut(String cdpNumVigFut) {
        this.cdpNumVigFut = cdpNumVigFut;
    }

    public String getCdpNumVigFut() {
        return cdpNumVigFut;
    }

    public void setCdpNumContrato(Long cdpNumContrato) {
        this.cdpNumContrato = cdpNumContrato;
    }

    public Long getCdpNumContrato() {
        return cdpNumContrato;
    }

    public void setCdpFechaCont(Date cdpFechaCont) {
        this.cdpFechaCont = cdpFechaCont;
    }

    public Date getCdpFechaCont() {
        return cdpFechaCont;
    }

    public void setCdpObjetoCont(String cdpObjetoCont) {
        this.cdpObjetoCont = cdpObjetoCont;
    }

    public String getCdpObjetoCont() {
        return cdpObjetoCont;
    }

    public void setCdpFechaVigFut(Date cdpFechaVigFut) {
        this.cdpFechaVigFut = cdpFechaVigFut;
    }

    public Date getCdpFechaVigFut() {
        return cdpFechaVigFut;
    }

    public void setCdpRpListVo(List<CdpRpVO> cdpRpListVo) {
        this.cdpRpListVo = cdpRpListVo;
    }

    public List<CdpRpVO> getCdpRpListVo() {
        return cdpRpListVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
