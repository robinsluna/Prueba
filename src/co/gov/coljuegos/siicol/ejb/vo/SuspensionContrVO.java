package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSuspensionContr;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SuspensionContrVO {
    private Long scoCodigo;
    private Date scoFechaActaSusp;
    private Date scoFechaFinDefCon;
    private Date scoFechaFinSusAct;
    private Date scoFechaFinSusp;
    private Date scoFechaIniSusAct;
    private Date scoFechaIniSusp;
    private Date scoFechaRadDesist;
    private Date scoFechaRadRecha;
    private Date scoFechaRadica;
    private Date scoFechaReanuda;
    private String scoModificaFecFin;
    private String scoMotivoDesist;
    private String scoMotivoRechazo;
    private String scoRadicado;
    private String scoRadicadoDesist;
    private String scoRadicadoRecha;
    private String scoTipo;
    private List<EstablecSuspensionVO> establecSuspensionListVo;
    private EstadoSuspensionContVO estadoSuspensionContVo;
    private ContratoVO contratoVo;
    //
    private int diasHabiles;

    
    public SuspensionContrVO() {
    }
    
    public SuspensionContrVO(SiiSuspensionContr siiSuspensionContr) {
        this.scoCodigo = siiSuspensionContr.getScoCodigo();
        this.scoFechaActaSusp = siiSuspensionContr.getScoFechaActaSusp();
        this.scoFechaFinDefCon = siiSuspensionContr.getScoFechaFinDefCon();
        this.scoFechaFinSusAct = siiSuspensionContr.getScoFechaFinSusAct();
        this.scoFechaFinSusp = siiSuspensionContr.getScoFechaFinSusp();
        this.scoFechaIniSusAct = siiSuspensionContr.getScoFechaIniSusAct();
        this.scoFechaIniSusp = siiSuspensionContr.getScoFechaIniSusp();
        this.scoFechaRadDesist = siiSuspensionContr.getScoFechaRadDesist();
        this.scoFechaRadRecha = siiSuspensionContr.getScoFechaRadRecha();
        this.scoFechaRadica = siiSuspensionContr.getScoFechaRadica();
        this.scoFechaReanuda= siiSuspensionContr.getScoFechaReanuda();
        this.scoModificaFecFin = siiSuspensionContr.getScoModificaFecFin();
        this.scoMotivoDesist = siiSuspensionContr.getScoMotivoDesist();
        this.scoMotivoRechazo = siiSuspensionContr.getScoMotivoRachazo();
        this.scoRadicado = siiSuspensionContr.getScoRadicado();
        this.scoRadicadoDesist = siiSuspensionContr.getScoRadicadoDesist();
        this.scoRadicadoRecha = siiSuspensionContr.getScoRadicadoRecha();
        this.scoTipo = siiSuspensionContr.getScoTipo();
        //Padres
        if (siiSuspensionContr.getSiiContrato()!= null) {
            this.contratoVo = new ContratoVO(siiSuspensionContr.getSiiContrato());
        }
        if (siiSuspensionContr.getSiiEstadoSuspensionCont()!= null ) {
            this.estadoSuspensionContVo = new EstadoSuspensionContVO(siiSuspensionContr.getSiiEstadoSuspensionCont());
        }
    }

    public void setScoCodigo(Long scoCodigo) {
        this.scoCodigo = scoCodigo;
    }

    public Long getScoCodigo() {
        return scoCodigo;
    }

    public void setScoFechaActaSusp(Date scoFechaActaSusp) {
        this.scoFechaActaSusp = scoFechaActaSusp;
    }

    public Date getScoFechaActaSusp() {
        return scoFechaActaSusp;
    }

    public void setScoFechaFinDefCon(Date scoFechaFinDefCon) {
        this.scoFechaFinDefCon = scoFechaFinDefCon;
    }

    public Date getScoFechaFinDefCon() {
        return scoFechaFinDefCon;
    }

    public void setScoFechaFinSusAct(Date scoFechaFinSusAct) {
        this.scoFechaFinSusAct = scoFechaFinSusAct;
    }

    public Date getScoFechaFinSusAct() {
        return scoFechaFinSusAct;
    }

    public void setScoFechaFinSusp(Date scoFechaFinSusp) {
        this.scoFechaFinSusp = scoFechaFinSusp;
    }

    public Date getScoFechaFinSusp() {
        return scoFechaFinSusp;
    }

    public void setScoFechaIniSusAct(Date scoFechaIniSusAct) {
        this.scoFechaIniSusAct = scoFechaIniSusAct;
    }

    public Date getScoFechaIniSusAct() {
        return scoFechaIniSusAct;
    }

    public void setScoFechaIniSusp(Date scoFechaIniSusp) {
        this.scoFechaIniSusp = scoFechaIniSusp;
    }

    public Date getScoFechaIniSusp() {
        return scoFechaIniSusp;
    }

    public void setScoFechaRadDesist(Date scoFechaRadDesist) {
        this.scoFechaRadDesist = scoFechaRadDesist;
    }

    public Date getScoFechaRadDesist() {
        return scoFechaRadDesist;
    }

    public void setScoFechaRadRecha(Date scoFechaRadRecha) {
        this.scoFechaRadRecha = scoFechaRadRecha;
    }

    public Date getScoFechaRadRecha() {
        return scoFechaRadRecha;
    }

    public void setScoFechaRadica(Date scoFechaRadica) {
        this.scoFechaRadica = scoFechaRadica;
    }

    public Date getScoFechaRadica() {
        return scoFechaRadica;
    }

    public void setScoFechaReanuda(Date scoFechaReanuda) {
        this.scoFechaReanuda = scoFechaReanuda;
    }

    public Date getScoFechaReanuda() {
        return scoFechaReanuda;
    }

    public void setScoModificaFecFin(String scoModificaFecFin) {
        this.scoModificaFecFin = scoModificaFecFin;
    }

    public String getScoModificaFecFin() {
        return scoModificaFecFin;
    }

    public void setScoMotivoDesist(String scoMotivoDesist) {
        this.scoMotivoDesist = scoMotivoDesist;
    }

    public String getScoMotivoDesist() {
        return scoMotivoDesist;
    }

    public void setScoMotivoRechazo(String scoMotivoRechazo) {
        this.scoMotivoRechazo = scoMotivoRechazo;
    }

    public String getScoMotivoRechazo() {
        return scoMotivoRechazo;
    }

    public void setScoRadicado(String scoRadicado) {
        this.scoRadicado = scoRadicado;
    }

    public String getScoRadicado() {
        return scoRadicado;
    }

    public void setScoRadicadoDesist(String scoRadicadoDesist) {
        this.scoRadicadoDesist = scoRadicadoDesist;
    }

    public String getScoRadicadoDesist() {
        return scoRadicadoDesist;
    }

    public void setScoRadicadoRecha(String scoRadicadoRecha) {
        this.scoRadicadoRecha = scoRadicadoRecha;
    }

    public String getScoRadicadoRecha() {
        return scoRadicadoRecha;
    }

    public void setScoTipo(String scoTipo) {
        this.scoTipo = scoTipo;
    }

    public String getScoTipo() {
        return scoTipo;
    }

    public void setEstablecSuspensionListVo(List<EstablecSuspensionVO> establecSuspensionListVo) {
        this.establecSuspensionListVo = establecSuspensionListVo;
    }

    public List<EstablecSuspensionVO> getEstablecSuspensionListVo() {
        return establecSuspensionListVo;
    }

    public void setEstadoSuspensionContVo(EstadoSuspensionContVO estadoSuspensionContVo) {
        this.estadoSuspensionContVo = estadoSuspensionContVo;
    }

    public EstadoSuspensionContVO getEstadoSuspensionContVo() {
        return estadoSuspensionContVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setDiasHabiles(int diasHabiles) {
        this.diasHabiles = diasHabiles;
    }


    public int getDiasHabiles() {
        return diasHabiles;
    }
}
