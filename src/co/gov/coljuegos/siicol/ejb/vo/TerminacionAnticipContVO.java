package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminacionAnticip;

import java.util.Date;

public class TerminacionAnticipContVO {
    private Long tanCodigo;
    private Date tanFechaActaTerAnt;
    private Date tanFechaAproTerAnt;
    private Date tanFechaRadica;
    private Date tanFechaRadicRech;
    private Date tanFechaRadDesist;
    private Date tanFechaTermAntic;
    private Date tanFechaTermSolic;
    private String tanMotivoDesistim;
    private String tanMotivoRechazo;
    private String tanMotivoSolic;
    private String tanRadicado;
    private String tanRadicadoDesistim;
    private String tanRadicadoRechazo;
    private EstadoTermAnticipVO estadoTermAnticipVo;
    private ContratoVO contratoVo;
    private Long idEstadoAnterior;
    private Integer diasHabiles;
    
    public TerminacionAnticipContVO() {        
    }
 
    public  TerminacionAnticipContVO (SiiTerminacionAnticip siiTerminacionAnticip) {        
        this.tanCodigo = siiTerminacionAnticip.getTanCodigo();
        this.tanFechaActaTerAnt = siiTerminacionAnticip.getTanFechaActaTerAnt();
        this.tanFechaAproTerAnt = siiTerminacionAnticip.getTanFechaAproTerAnt();
        this.tanFechaRadica = siiTerminacionAnticip.getTanFechaRadica();
        this.tanFechaRadicRech = siiTerminacionAnticip.getTanFechaRadicRech();
        this.tanFechaRadDesist = siiTerminacionAnticip.getTanFechaRadDesist();
        this.tanFechaTermAntic = siiTerminacionAnticip.getTanFechaTermAntic();
        this.tanFechaTermSolic = siiTerminacionAnticip.getTanFechaTermSolic();
        this.tanMotivoDesistim = siiTerminacionAnticip.getTanMotivoDesistim();
        this.tanMotivoRechazo = siiTerminacionAnticip.getTanMotivoRechazo();
        this.tanMotivoSolic = siiTerminacionAnticip.getTanMotivoSolic();
        this.tanRadicado = siiTerminacionAnticip.getTanRadicado();
        this.tanRadicadoDesistim = siiTerminacionAnticip.getTanRadicadoDesistim();
        this.tanRadicadoRechazo = siiTerminacionAnticip.getTanRadicadoRechazo();
        if (siiTerminacionAnticip.getSiiEstadoTermAnticip() != null){
            this.estadoTermAnticipVo = new EstadoTermAnticipVO(siiTerminacionAnticip.getSiiEstadoTermAnticip());
        }
        if(siiTerminacionAnticip.getSiiContrato() != null){
            this.contratoVo = new ContratoVO(siiTerminacionAnticip.getSiiContrato());
        }
 
        if (siiTerminacionAnticip.getSiiEstadoTermAnticip() != null )       {
            this.estadoTermAnticipVo = new EstadoTermAnticipVO (siiTerminacionAnticip.getSiiEstadoTermAnticip());
            this.idEstadoAnterior = siiTerminacionAnticip.getSiiEstadoTermAnticip().getEtaCodigo();
        }        
    }

    public void setTanCodigo(Long tanCodigo) {
        this.tanCodigo = tanCodigo;
    }

    public Long getTanCodigo() {
        return tanCodigo;
    }

    public void setTanFechaActaTerAnt(Date tanFechaActaTerAnt) {
        this.tanFechaActaTerAnt = tanFechaActaTerAnt;
    }

    public Date getTanFechaActaTerAnt() {
        return tanFechaActaTerAnt;
    }

    public void setTanFechaAproTerAnt(Date tanFechaAproTerAnt) {
        this.tanFechaAproTerAnt = tanFechaAproTerAnt;
    }

    public Date getTanFechaAproTerAnt() {
        return tanFechaAproTerAnt;
    }

    public void setTanFechaRadica(Date tanFechaRadica) {
        this.tanFechaRadica = tanFechaRadica;
    }

    public Date getTanFechaRadica() {
        return tanFechaRadica;
    }

    public void setTanFechaRadicRech(Date tanFechaRadicRech) {
        this.tanFechaRadicRech = tanFechaRadicRech;
    }

    public Date getTanFechaRadicRech() {
        return tanFechaRadicRech;
    }

    public void setTanFechaRadDesist(Date tanFechaRadDesist) {
        this.tanFechaRadDesist = tanFechaRadDesist;
    }

    public Date getTanFechaRadDesist() {
        return tanFechaRadDesist;
    }

    public void setTanFechaTermAntic(Date tanFechaTermAntic) {
        this.tanFechaTermAntic = tanFechaTermAntic;
    }

    public Date getTanFechaTermAntic() {
        return tanFechaTermAntic;
    }

    public void setTanFechaTermSolic(Date tanFechaTermSolic) {
        this.tanFechaTermSolic = tanFechaTermSolic;
    }

    public Date getTanFechaTermSolic() {
        return tanFechaTermSolic;
    }

    public void setTanMotivoDesistim(String tanMotivoDesistim) {
        this.tanMotivoDesistim = tanMotivoDesistim;
    }

    public String getTanMotivoDesistim() {
        return tanMotivoDesistim;
    }

    public void setTanMotivoRechazo(String tanMotivoRechazo) {
        this.tanMotivoRechazo = tanMotivoRechazo;
    }

    public String getTanMotivoRechazo() {
        return tanMotivoRechazo;
    }

    public void setTanMotivoSolic(String tanMotivoSolic) {
        this.tanMotivoSolic = tanMotivoSolic;
    }

    public String getTanMotivoSolic() {
        return tanMotivoSolic;
    }

    public void setTanRadicado(String tanRadicado) {
        this.tanRadicado = tanRadicado;
    }

    public String getTanRadicado() {
        return tanRadicado;
    }

    public void setTanRadicadoDesistim(String tanRadicadoDesistim) {
        this.tanRadicadoDesistim = tanRadicadoDesistim;
    }

    public String getTanRadicadoDesistim() {
        return tanRadicadoDesistim;
    }

    public void setTanRadicadoRechazo(String tanRadicadoRechazo) {
        this.tanRadicadoRechazo = tanRadicadoRechazo;
    }

    public String getTanRadicadoRechazo() {
        return tanRadicadoRechazo;
    }

    public void setEstadoTermAnticipVo(EstadoTermAnticipVO estadoTermAnticipVo) {
        this.estadoTermAnticipVo = estadoTermAnticipVo;
    }

    public EstadoTermAnticipVO getEstadoTermAnticipVo() {
        return estadoTermAnticipVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setDiasHabiles(Integer diasHabiles) {
        this.diasHabiles = diasHabiles;
    }

    public Integer getDiasHabiles() {
        return diasHabiles;
    }
}
