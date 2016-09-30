package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ACTA_VISITA")
public class SiiActaVisita implements Serializable {
    private static final long serialVersionUID = -4261912868869564746L;
    private String aviCalidadPerAten;
    private String aviCargoRepOpera;
    private Long aviCodigo;
    private BigDecimal aviEstLatitud;
    private BigDecimal aviEstLongitud;
    private String aviExpedPerAten;
    private Date aviFechaFin;
    private Date aviFechaLlegada;
    private Date aviFechaVisita;
    private String aviIdRepOpera;
    private String aviIdentPerAten;
    private Integer aviMesaApuNoCorr;
    private Integer aviMesaAutoriz;
    private Integer aviMesaEncontrado;
    private Integer aviMesaMayNumAut;
    private Integer aviMesaNoEncont;
    private Integer aviMesaNoRegNoOp;
    private Integer aviMesaSerNoCorr;
    private Integer aviMesaSinPlaca;
    private Integer aviMetApuNoCorr;
    private Integer aviMetAutoriz;
    private Integer aviMetEncontrado;
    private Integer aviMetMayNumAut;
    private Integer aviMetNoEncont;
    private Integer aviMetNoRegNoOp;
    private Integer aviMetSerNoCorr;
    private Integer aviMetSinPlaca;
    private String aviNomRepOpera;
    private String aviNombrePerAten;
    private Integer aviNumFolios;
    private Integer aviOtroApuNoCorr;
    private Integer aviOtroAutoriz;
    private Integer aviOtroEncontrado;
    private Integer aviOtroMayNumAut;
    private Integer aviOtroNoEncont;
    private Integer aviOtroNoRegNoOp;
    private Integer aviOtroSerNoCorr;
    private Integer aviOtroSinPlaca;
    private Integer aviSillApuNoCorr;
    private Integer aviSillAutoriz;
    private Integer aviSillEncontrado;
    private Integer aviSillMayNumAut;
    private Integer aviSillNoEncont;
    private Integer aviSillNoRegNoOp;
    private Integer aviSillSerNoCorr;
    private Integer aviSillSinPlaca;
    private Integer aviTotEleNoInv;
    private Integer aviTotEleTraNoau;
    private String aviVerifAviso;
    private String aviVerifCualAct_;
    private String aviVerifDireccion;
    private String aviVerifMantenEle;
    private String aviVerifNomEst;
    private String aviVerifOtrasAct;
    private String aviVerifSpCodCon;
    private String aviVerifSpDilig;
    private String aviVerifSpIdCli;
    private BigDecimal aviVerifSpMonto;
    private String aviVerifSpSenAler;
    private SiiAutoComisorio siiAutoComisorio;
    private List<SiiInstrNoCorresp> siiInstrNoCorrespList;
    private String aviVerifObsEncarg;
    private String aviVerifObsInspec;
    private Integer aviVerifTotalCoinc;
    private Integer aviVerifTotalNoEnc;
    private String aviNumero;

    public SiiActaVisita() {
    }

    public SiiActaVisita(SiiAutoComisorio siiAutoComisorio, String aviCalidadPerAten, String aviCargoRepOpera, Long aviCodigo, BigDecimal aviEstLatitud, BigDecimal aviEstLongitud,
                         String aviExpedPerAten, Date aviFechaFin, Date aviFechaLlegada, Date aviFechaVisita, String aviIdRepOpera, String aviIdentPerAten, Integer aviMesaApuNoCorr,
                         Integer aviMesaAutoriz, Integer aviMesaEncontrado, Integer aviMesaMayNumAut, Integer aviMesaNoEncont, Integer aviMesaNoRegNoOp, Integer aviMesaSerNoCorr,
                         Integer aviMesaSinPlaca, Integer aviMetApuNoCorr, Integer aviMetAutoriz, Integer aviMetEncontrado, Integer aviMetMayNumAut, Integer aviMetNoEncont, Integer aviMetNoRegNoOp,
                         Integer aviMetSerNoCorr, Integer aviMetSinPlaca, String aviNomRepOpera, String aviNombrePerAten, Integer aviNumFolios, Integer aviOtroApuNoCorr, Integer aviOtroAutoriz,
                         Integer aviOtroEncontrado, Integer aviOtroMayNumAut, Integer aviOtroNoEncont, Integer aviOtroNoRegNoOp, Integer aviOtroSerNoCorr, Integer aviOtroSinPlaca,
                         Integer aviSillApuNoCorr, Integer aviSillAutoriz, Integer aviSillEncontrado, Integer aviSillMayNumAut, Integer aviSillNoEncont, Integer aviSillNoRegNoOp,
                         Integer aviSillSerNoCorr, Integer aviSillSinPlaca, Integer aviTotEleNoInv, Integer aviTotEleTraNoau, String aviVerifAviso, String aviVerifCualAct_, String aviVerifDireccion,
                         String aviVerifMantenEle, String aviVerifNomEst, String aviVerifOtrasAct, String aviVerifSpCodCon, String aviVerifSpDilig, String aviVerifSpIdCli, BigDecimal aviVerifSpMonto,
                         String aviVerifSpSenAler, String aviNumero) {
        this.siiAutoComisorio = siiAutoComisorio;
        this.aviCalidadPerAten = aviCalidadPerAten;
        this.aviCargoRepOpera = aviCargoRepOpera;
        this.aviCodigo = aviCodigo;
        this.aviEstLatitud = aviEstLatitud;
        this.aviEstLongitud = aviEstLongitud;
        this.aviExpedPerAten = aviExpedPerAten;
        this.aviFechaFin = aviFechaFin;
        this.aviFechaLlegada = aviFechaLlegada;
        this.aviFechaVisita = aviFechaVisita;
        this.aviIdRepOpera = aviIdRepOpera;
        this.aviIdentPerAten = aviIdentPerAten;
        this.aviMesaApuNoCorr = aviMesaApuNoCorr;
        this.aviMesaAutoriz = aviMesaAutoriz;
        this.aviMesaEncontrado = aviMesaEncontrado;
        this.aviMesaMayNumAut = aviMesaMayNumAut;
        this.aviMesaNoEncont = aviMesaNoEncont;
        this.aviMesaNoRegNoOp = aviMesaNoRegNoOp;
        this.aviMesaSerNoCorr = aviMesaSerNoCorr;
        this.aviMesaSinPlaca = aviMesaSinPlaca;
        this.aviMetApuNoCorr = aviMetApuNoCorr;
        this.aviMetAutoriz = aviMetAutoriz;
        this.aviMetEncontrado = aviMetEncontrado;
        this.aviMetMayNumAut = aviMetMayNumAut;
        this.aviMetNoEncont = aviMetNoEncont;
        this.aviMetNoRegNoOp = aviMetNoRegNoOp;
        this.aviMetSerNoCorr = aviMetSerNoCorr;
        this.aviMetSinPlaca = aviMetSinPlaca;
        this.aviNomRepOpera = aviNomRepOpera;
        this.aviNombrePerAten = aviNombrePerAten;
        this.aviNumFolios = aviNumFolios;
        this.aviOtroApuNoCorr = aviOtroApuNoCorr;
        this.aviOtroAutoriz = aviOtroAutoriz;
        this.aviOtroEncontrado = aviOtroEncontrado;
        this.aviOtroMayNumAut = aviOtroMayNumAut;
        this.aviOtroNoEncont = aviOtroNoEncont;
        this.aviOtroNoRegNoOp = aviOtroNoRegNoOp;
        this.aviOtroSerNoCorr = aviOtroSerNoCorr;
        this.aviOtroSinPlaca = aviOtroSinPlaca;
        this.aviSillApuNoCorr = aviSillApuNoCorr;
        this.aviSillAutoriz = aviSillAutoriz;
        this.aviSillEncontrado = aviSillEncontrado;
        this.aviSillMayNumAut = aviSillMayNumAut;
        this.aviSillNoEncont = aviSillNoEncont;
        this.aviSillNoRegNoOp = aviSillNoRegNoOp;
        this.aviSillSerNoCorr = aviSillSerNoCorr;
        this.aviSillSinPlaca = aviSillSinPlaca;
        this.aviTotEleNoInv = aviTotEleNoInv;
        this.aviTotEleTraNoau = aviTotEleTraNoau;
        this.aviVerifAviso = aviVerifAviso;
        this.aviVerifCualAct_ = aviVerifCualAct_;
        this.aviVerifDireccion = aviVerifDireccion;
        this.aviVerifMantenEle = aviVerifMantenEle;
        this.aviVerifNomEst = aviVerifNomEst;
        this.aviVerifOtrasAct = aviVerifOtrasAct;
        this.aviVerifSpCodCon = aviVerifSpCodCon;
        this.aviVerifSpDilig = aviVerifSpDilig;
        this.aviVerifSpIdCli = aviVerifSpIdCli;
        this.aviVerifSpMonto = aviVerifSpMonto;
        this.aviVerifSpSenAler = aviVerifSpSenAler;
        this.aviNumero = aviNumero;
    }


    @Column(name = "AVI_CALIDAD_PER_ATEN", nullable = false, length = 30)
    public String getAviCalidadPerAten() {
        return aviCalidadPerAten;
    }

    public void setAviCalidadPerAten(String aviCalidadPerAten) {
        this.aviCalidadPerAten = aviCalidadPerAten;
    }

    @Column(name = "AVI_CARGO_REP_OPERA", nullable = false, length = 30)
    public String getAviCargoRepOpera() {
        return aviCargoRepOpera;
    }

    public void setAviCargoRepOpera(String aviCargoRepOpera) {
        this.aviCargoRepOpera = aviCargoRepOpera;
    }

    @Id
    @Column(name = "AVI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTA_VISITA_COD")
    @SequenceGenerator(name = "SEQ_ACTA_VISITA_COD", sequenceName = "SEQ_ACTA_VISITA_COD",allocationSize=1)
    public Long getAviCodigo() {
        return aviCodigo;
    }

    public void setAviCodigo(Long aviCodigo) {
        this.aviCodigo = aviCodigo;
    }

    @Column(name = "AVI_EST_LATITUD", nullable = false)
    public BigDecimal getAviEstLatitud() {
        return aviEstLatitud;
    }

    public void setAviEstLatitud(BigDecimal aviEstLatitud) {
        this.aviEstLatitud = aviEstLatitud;
    }

    @Column(name = "AVI_EST_LONGITUD", nullable = false)
    public BigDecimal getAviEstLongitud() {
        return aviEstLongitud;
    }

    public void setAviEstLongitud(BigDecimal aviEstLongitud) {
        this.aviEstLongitud = aviEstLongitud;
    }

    @Column(name = "AVI_EXPED_PER_ATEN", nullable = false, length = 30)
    public String getAviExpedPerAten() {
        return aviExpedPerAten;
    }

    public void setAviExpedPerAten(String aviExpedPerAten) {
        this.aviExpedPerAten = aviExpedPerAten;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AVI_FECHA_FIN", nullable = false)
    public Date getAviFechaFin() {
        return aviFechaFin;
    }

    public void setAviFechaFin(Date aviFechaFin) {
        this.aviFechaFin = aviFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AVI_FECHA_LLEGADA", nullable = false)
    public Date getAviFechaLlegada() {
        return aviFechaLlegada;
    }

    public void setAviFechaLlegada(Date aviFechaLlegada) {
        this.aviFechaLlegada = aviFechaLlegada;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AVI_FECHA_VISITA", nullable = false)
    public Date getAviFechaVisita() {
        return aviFechaVisita;
    }

    public void setAviFechaVisita(Date aviFechaVisita) {
        this.aviFechaVisita = aviFechaVisita;
    }

    @Column(name = "AVI_ID_REP_OPERA", nullable = false, length = 20)
    public String getAviIdRepOpera() {
        return aviIdRepOpera;
    }

    public void setAviIdRepOpera(String aviIdRepOpera) {
        this.aviIdRepOpera = aviIdRepOpera;
    }

    @Column(name = "AVI_IDENT_PER_ATEN", nullable = false, length = 20)
    public String getAviIdentPerAten() {
        return aviIdentPerAten;
    }

    public void setAviIdentPerAten(String aviIdentPerAten) {
        this.aviIdentPerAten = aviIdentPerAten;
    }

    @Column(name = "AVI_MESA_APU_NO_CORR", nullable = false)
    public Integer getAviMesaApuNoCorr() {
        return aviMesaApuNoCorr;
    }

    public void setAviMesaApuNoCorr(Integer aviMesaApuNoCorr) {
        this.aviMesaApuNoCorr = aviMesaApuNoCorr;
    }

    @Column(name = "AVI_MESA_AUTORIZ", nullable = false)
    public Integer getAviMesaAutoriz() {
        return aviMesaAutoriz;
    }

    public void setAviMesaAutoriz(Integer aviMesaAutoriz) {
        this.aviMesaAutoriz = aviMesaAutoriz;
    }

    @Column(name = "AVI_MESA_ENCONTRADO", nullable = false)
    public Integer getAviMesaEncontrado() {
        return aviMesaEncontrado;
    }

    public void setAviMesaEncontrado(Integer aviMesaEncontrado) {
        this.aviMesaEncontrado = aviMesaEncontrado;
    }

    @Column(name = "AVI_MESA_MAY_NUM_AUT", nullable = false)
    public Integer getAviMesaMayNumAut() {
        return aviMesaMayNumAut;
    }

    public void setAviMesaMayNumAut(Integer aviMesaMayNumAut) {
        this.aviMesaMayNumAut = aviMesaMayNumAut;
    }

    @Column(name = "AVI_MESA_NO_ENCONT", nullable = false)
    public Integer getAviMesaNoEncont() {
        return aviMesaNoEncont;
    }

    public void setAviMesaNoEncont(Integer aviMesaNoEncont) {
        this.aviMesaNoEncont = aviMesaNoEncont;
    }

    @Column(name = "AVI_MESA_NO_REG_NO_OP", nullable = false)
    public Integer getAviMesaNoRegNoOp() {
        return aviMesaNoRegNoOp;
    }

    public void setAviMesaNoRegNoOp(Integer aviMesaNoRegNoOp) {
        this.aviMesaNoRegNoOp = aviMesaNoRegNoOp;
    }

    @Column(name = "AVI_MESA_SER_NO_CORR", nullable = false)
    public Integer getAviMesaSerNoCorr() {
        return aviMesaSerNoCorr;
    }

    public void setAviMesaSerNoCorr(Integer aviMesaSerNoCorr) {
        this.aviMesaSerNoCorr = aviMesaSerNoCorr;
    }

    @Column(name = "AVI_MESA_SIN_PLACA", nullable = false)
    public Integer getAviMesaSinPlaca() {
        return aviMesaSinPlaca;
    }

    public void setAviMesaSinPlaca(Integer aviMesaSinPlaca) {
        this.aviMesaSinPlaca = aviMesaSinPlaca;
    }

    @Column(name = "AVI_MET_APU_NO_CORR", nullable = false)
    public Integer getAviMetApuNoCorr() {
        return aviMetApuNoCorr;
    }

    public void setAviMetApuNoCorr(Integer aviMetApuNoCorr) {
        this.aviMetApuNoCorr = aviMetApuNoCorr;
    }

    @Column(name = "AVI_MET_AUTORIZ", nullable = false)
    public Integer getAviMetAutoriz() {
        return aviMetAutoriz;
    }

    public void setAviMetAutoriz(Integer aviMetAutoriz) {
        this.aviMetAutoriz = aviMetAutoriz;
    }

    @Column(name = "AVI_MET_ENCONTRADO", nullable = false)
    public Integer getAviMetEncontrado() {
        return aviMetEncontrado;
    }

    public void setAviMetEncontrado(Integer aviMetEncontrado) {
        this.aviMetEncontrado = aviMetEncontrado;
    }

    @Column(name = "AVI_MET_MAY_NUM_AUT", nullable = false)
    public Integer getAviMetMayNumAut() {
        return aviMetMayNumAut;
    }

    public void setAviMetMayNumAut(Integer aviMetMayNumAut) {
        this.aviMetMayNumAut = aviMetMayNumAut;
    }

    @Column(name = "AVI_MET_NO_ENCONT", nullable = false)
    public Integer getAviMetNoEncont() {
        return aviMetNoEncont;
    }

    public void setAviMetNoEncont(Integer aviMetNoEncont) {
        this.aviMetNoEncont = aviMetNoEncont;
    }

    @Column(name = "AVI_MET_NO_REG_NO_OP", nullable = false)
    public Integer getAviMetNoRegNoOp() {
        return aviMetNoRegNoOp;
    }

    public void setAviMetNoRegNoOp(Integer aviMetNoRegNoOp) {
        this.aviMetNoRegNoOp = aviMetNoRegNoOp;
    }

    @Column(name = "AVI_MET_SER_NO_CORR", nullable = false)
    public Integer getAviMetSerNoCorr() {
        return aviMetSerNoCorr;
    }

    public void setAviMetSerNoCorr(Integer aviMetSerNoCorr) {
        this.aviMetSerNoCorr = aviMetSerNoCorr;
    }

    @Column(name = "AVI_MET_SIN_PLACA", nullable = false)
    public Integer getAviMetSinPlaca() {
        return aviMetSinPlaca;
    }

    public void setAviMetSinPlaca(Integer aviMetSinPlaca) {
        this.aviMetSinPlaca = aviMetSinPlaca;
    }

    @Column(name = "AVI_NOM_REP_OPERA", nullable = false, length = 100)
    public String getAviNomRepOpera() {
        return aviNomRepOpera;
    }

    public void setAviNomRepOpera(String aviNomRepOpera) {
        this.aviNomRepOpera = aviNomRepOpera;
    }

    @Column(name = "AVI_NOMBRE_PER_ATEN", nullable = false, length = 100)
    public String getAviNombrePerAten() {
        return aviNombrePerAten;
    }

    public void setAviNombrePerAten(String aviNombrePerAten) {
        this.aviNombrePerAten = aviNombrePerAten;
    }

    @Column(name = "AVI_NUM_FOLIOS", nullable = false)
    public Integer getAviNumFolios() {
        return aviNumFolios;
    }

    public void setAviNumFolios(Integer aviNumFolios) {
        this.aviNumFolios = aviNumFolios;
    }

    @Column(name = "AVI_OTRO_APU_NO_CORR", nullable = false)
    public Integer getAviOtroApuNoCorr() {
        return aviOtroApuNoCorr;
    }

    public void setAviOtroApuNoCorr(Integer aviOtroApuNoCorr) {
        this.aviOtroApuNoCorr = aviOtroApuNoCorr;
    }

    @Column(name = "AVI_OTRO_AUTORIZ", nullable = false)
    public Integer getAviOtroAutoriz() {
        return aviOtroAutoriz;
    }

    public void setAviOtroAutoriz(Integer aviOtroAutoriz) {
        this.aviOtroAutoriz = aviOtroAutoriz;
    }

    @Column(name = "AVI_OTRO_ENCONTRADO", nullable = false)
    public Integer getAviOtroEncontrado() {
        return aviOtroEncontrado;
    }

    public void setAviOtroEncontrado(Integer aviOtroEncontrado) {
        this.aviOtroEncontrado = aviOtroEncontrado;
    }

    @Column(name = "AVI_OTRO_MAY_NUM_AUT", nullable = false)
    public Integer getAviOtroMayNumAut() {
        return aviOtroMayNumAut;
    }

    public void setAviOtroMayNumAut(Integer aviOtroMayNumAut) {
        this.aviOtroMayNumAut = aviOtroMayNumAut;
    }

    @Column(name = "AVI_OTRO_NO_ENCONT", nullable = false)
    public Integer getAviOtroNoEncont() {
        return aviOtroNoEncont;
    }

    public void setAviOtroNoEncont(Integer aviOtroNoEncont) {
        this.aviOtroNoEncont = aviOtroNoEncont;
    }

    @Column(name = "AVI_OTRO_NO_REG_NO_OP", nullable = false)
    public Integer getAviOtroNoRegNoOp() {
        return aviOtroNoRegNoOp;
    }

    public void setAviOtroNoRegNoOp(Integer aviOtroNoRegNoOp) {
        this.aviOtroNoRegNoOp = aviOtroNoRegNoOp;
    }

    @Column(name = "AVI_OTRO_SER_NO_CORR", nullable = false)
    public Integer getAviOtroSerNoCorr() {
        return aviOtroSerNoCorr;
    }

    public void setAviOtroSerNoCorr(Integer aviOtroSerNoCorr) {
        this.aviOtroSerNoCorr = aviOtroSerNoCorr;
    }

    @Column(name = "AVI_OTRO_SIN_PLACA", nullable = false)
    public Integer getAviOtroSinPlaca() {
        return aviOtroSinPlaca;
    }

    public void setAviOtroSinPlaca(Integer aviOtroSinPlaca) {
        this.aviOtroSinPlaca = aviOtroSinPlaca;
    }

    @Column(name = "AVI_SILL_APU_NO_CORR", nullable = false)
    public Integer getAviSillApuNoCorr() {
        return aviSillApuNoCorr;
    }

    public void setAviSillApuNoCorr(Integer aviSillApuNoCorr) {
        this.aviSillApuNoCorr = aviSillApuNoCorr;
    }

    @Column(name = "AVI_SILL_AUTORIZ", nullable = false)
    public Integer getAviSillAutoriz() {
        return aviSillAutoriz;
    }

    public void setAviSillAutoriz(Integer aviSillAutoriz) {
        this.aviSillAutoriz = aviSillAutoriz;
    }

    @Column(name = "AVI_SILL_ENCONTRADO", nullable = false)
    public Integer getAviSillEncontrado() {
        return aviSillEncontrado;
    }

    public void setAviSillEncontrado(Integer aviSillEncontrado) {
        this.aviSillEncontrado = aviSillEncontrado;
    }

    @Column(name = "AVI_SILL_MAY_NUM_AUT", nullable = false)
    public Integer getAviSillMayNumAut() {
        return aviSillMayNumAut;
    }

    public void setAviSillMayNumAut(Integer aviSillMayNumAut) {
        this.aviSillMayNumAut = aviSillMayNumAut;
    }

    @Column(name = "AVI_SILL_NO_ENCONT", nullable = false)
    public Integer getAviSillNoEncont() {
        return aviSillNoEncont;
    }

    public void setAviSillNoEncont(Integer aviSillNoEncont) {
        this.aviSillNoEncont = aviSillNoEncont;
    }

    @Column(name = "AVI_SILL_NO_REG_NO_OP", nullable = false)
    public Integer getAviSillNoRegNoOp() {
        return aviSillNoRegNoOp;
    }

    public void setAviSillNoRegNoOp(Integer aviSillNoRegNoOp) {
        this.aviSillNoRegNoOp = aviSillNoRegNoOp;
    }

    @Column(name = "AVI_SILL_SER_NO_CORR", nullable = false)
    public Integer getAviSillSerNoCorr() {
        return aviSillSerNoCorr;
    }

    public void setAviSillSerNoCorr(Integer aviSillSerNoCorr) {
        this.aviSillSerNoCorr = aviSillSerNoCorr;
    }

    @Column(name = "AVI_SILL_SIN_PLACA", nullable = false)
    public Integer getAviSillSinPlaca() {
        return aviSillSinPlaca;
    }

    public void setAviSillSinPlaca(Integer aviSillSinPlaca) {
        this.aviSillSinPlaca = aviSillSinPlaca;
    }

    @Column(name = "AVI_TOT_ELE_NO_INV")
    public Integer getAviTotEleNoInv() {
        return aviTotEleNoInv;
    }

    public void setAviTotEleNoInv(Integer aviTotEleNoInv) {
        this.aviTotEleNoInv = aviTotEleNoInv;
    }

    @Column(name = "AVI_TOT_ELE_TRA_NOAU")
    public Integer getAviTotEleTraNoau() {
        return aviTotEleTraNoau;
    }

    public void setAviTotEleTraNoau(Integer aviTotEleTraNoau) {
        this.aviTotEleTraNoau = aviTotEleTraNoau;
    }

    @Column(name = "AVI_VERIF_AVISO", nullable = false, length = 2)
    public String getAviVerifAviso() {
        return aviVerifAviso;
    }

    public void setAviVerifAviso(String aviVerifAviso) {
        this.aviVerifAviso = aviVerifAviso;
    }

    @Column(name = "AVI_VERIF_CUAL_ACT_", length = 20)
    public String getAviVerifCualAct_() {
        return aviVerifCualAct_;
    }

    public void setAviVerifCualAct_(String aviVerifCualAct_) {
        this.aviVerifCualAct_ = aviVerifCualAct_;
    }

    @Column(name = "AVI_VERIF_DIRECCION", nullable = false, length = 2)
    public String getAviVerifDireccion() {
        return aviVerifDireccion;
    }

    public void setAviVerifDireccion(String aviVerifDireccion) {
        this.aviVerifDireccion = aviVerifDireccion;
    }

    @Column(name = "AVI_VERIF_MANTEN_ELE", nullable = false, length = 2)
    public String getAviVerifMantenEle() {
        return aviVerifMantenEle;
    }

    public void setAviVerifMantenEle(String aviVerifMantenEle) {
        this.aviVerifMantenEle = aviVerifMantenEle;
    }

    @Column(name = "AVI_VERIF_NOM_EST", nullable = false, length = 2)
    public String getAviVerifNomEst() {
        return aviVerifNomEst;
    }

    public void setAviVerifNomEst(String aviVerifNomEst) {
        this.aviVerifNomEst = aviVerifNomEst;
    }

    @Column(name = "AVI_VERIF_OBS_ENCARG", nullable = false, length = 2200)
    public String getAviVerifObsEncarg() {
        return aviVerifObsEncarg;
    }

    public void setAviVerifObsEncarg(String aviVerifObsEncarg) {
        this.aviVerifObsEncarg = aviVerifObsEncarg;
    }

    @Column(name = "AVI_VERIF_OBS_INSPEC", nullable = false, length = 2200)
    public String getAviVerifObsInspec() {
        return aviVerifObsInspec;
    }

    public void setAviVerifObsInspec(String aviVerifObsInspec) {
        this.aviVerifObsInspec = aviVerifObsInspec;
    }

    @Column(name = "AVI_VERIF_OTRAS_ACT", nullable = false, length = 2)
    public String getAviVerifOtrasAct() {
        return aviVerifOtrasAct;
    }

    public void setAviVerifOtrasAct(String aviVerifOtrasAct) {
        this.aviVerifOtrasAct = aviVerifOtrasAct;
    }

    @Column(name = "AVI_VERIF_SP_COD_CON", nullable = false, length = 1)
    public String getAviVerifSpCodCon() {
        return aviVerifSpCodCon;
    }

    public void setAviVerifSpCodCon(String aviVerifSpCodCon) {
        this.aviVerifSpCodCon = aviVerifSpCodCon;
    }

    @Column(name = "AVI_VERIF_SP_DILIG", nullable = false, length = 1)
    public String getAviVerifSpDilig() {
        return aviVerifSpDilig;
    }

    public void setAviVerifSpDilig(String aviVerifSpDilig) {
        this.aviVerifSpDilig = aviVerifSpDilig;
    }

    @Column(name = "AVI_VERIF_SP_ID_CLI", nullable = false, length = 1)
    public String getAviVerifSpIdCli() {
        return aviVerifSpIdCli;
    }

    public void setAviVerifSpIdCli(String aviVerifSpIdCli) {
        this.aviVerifSpIdCli = aviVerifSpIdCli;
    }

    @Column(name = "AVI_VERIF_SP_MONTO", nullable = false)
    public BigDecimal getAviVerifSpMonto() {
        return aviVerifSpMonto;
    }

    public void setAviVerifSpMonto(BigDecimal aviVerifSpMonto) {
        this.aviVerifSpMonto = aviVerifSpMonto;
    }

    @Column(name = "AVI_VERIF_SP_SEN_ALER", nullable = false, length = 550)
    public String getAviVerifSpSenAler() {
        return aviVerifSpSenAler;
    }

    public void setAviVerifSpSenAler(String aviVerifSpSenAler) {
        this.aviVerifSpSenAler = aviVerifSpSenAler;
    }

    @ManyToOne
    @JoinColumn(name = "AUC_CODIGO")
    public SiiAutoComisorio getSiiAutoComisorio() {
        return siiAutoComisorio;
    }

    public void setSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        this.siiAutoComisorio = siiAutoComisorio;
    }

    @OneToMany(mappedBy = "siiActaVisita")
    public List<SiiInstrNoCorresp> getSiiInstrNoCorrespList() {
        return siiInstrNoCorrespList;
    }

    public void setSiiInstrNoCorrespList(List<SiiInstrNoCorresp> siiInstrNoCorrespList) {
        this.siiInstrNoCorrespList = siiInstrNoCorrespList;
    }

    public SiiInstrNoCorresp addSiiInstrNoCorresp(SiiInstrNoCorresp siiInstrNoCorresp) {
        getSiiInstrNoCorrespList().add(siiInstrNoCorresp);
        siiInstrNoCorresp.setSiiActaVisita(this);
        return siiInstrNoCorresp;
    }

    public SiiInstrNoCorresp removeSiiInstrNoCorresp(SiiInstrNoCorresp siiInstrNoCorresp) {
        getSiiInstrNoCorrespList().remove(siiInstrNoCorresp);
        siiInstrNoCorresp.setSiiActaVisita(null);
        return siiInstrNoCorresp;
    }
    
    @Column(name = "AVI_VERIF_TOTAL_COINC", nullable = false)
    public Integer getAviVerifTotalCoinc() {
        return aviVerifTotalCoinc;
    }

    public void setAviVerifTotalCoinc(Integer aviVerifTotalCoinc) {
        this.aviVerifTotalCoinc = aviVerifTotalCoinc;
    }

    @Column(name = "AVI_VERIF_TOTAL_NO_ENC", nullable = false)
    public Integer getAviVerifTotalNoEnc() {
        return aviVerifTotalNoEnc;
    }

    public void setAviVerifTotalNoEnc(Integer aviVerifTotalNoEnc) {
        this.aviVerifTotalNoEnc = aviVerifTotalNoEnc;
    }

    @Column(name = "AVI_NUMERO", length = 10)
    public String getAviNumero() {
        return aviNumero;
    }
    
    public void setAviNumero(String aviNumero) {
        this.aviNumero = aviNumero;
    }
    
}
