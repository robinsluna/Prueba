package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

//import java.sql.Date;
import java.sql.Timestamp;
//import java.util.Date;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIITO_CONSULTA_INV_SIICOL")
public class SiitoConsultaInvSiicol implements Serializable {
    private static final long serialVersionUID = 4637831741927175189L;
    private Long movCargueInvAnoFab;
    private Long movCargueInvCantSillas;
    private Long movCargueInvCantTerm;
    private Long movCargueInvCodApuesta;
    private String movCargueInvCodLocal;
    private Integer movCargueInvCodMarca;
    private String movCargueInvCodModelo;
    private Long movCargueInvCodigo;
    private String movCargueInvCont;
    private String movCargueInvDirBarrio;
    private String movCargueInvDirDesc;
    private String movCargueInvEstElem;
    private Long movCargueInvEstUbiInst;
    private Timestamp movCargueInvFecFinele;
    private Timestamp movCargueInvFecInicioele;
    private Timestamp movCargueInvFechFinLiq;
    private Timestamp movCargueInvFechIniLiq;    
    private Timestamp movCargueInvFechSol;
    private Long movCargueInvIndInstHomo;
    private Long movCargueInvIndInstSclmIn;
    private Long movCargueInvIucAd;
    private String movCargueInvLatEstableci;
    private String movCargueInvLonEstableci;
    private String movCargueInvModJuego;
    private String movCargueInvModLic;
    private String movCargueInvNit;
    private String movCargueInvNomLocal;
    private String movCargueInvNuidAd;
    private String movCargueInvNumFab;
    private Long movCargueInvNumFabSclm;
    private String movCargueInvNumLic;
    private String movCargueInvSerialInstAd;
    private String movCargueInvTenLegal;
    private String movCargueInvTipInst;
    private String movCargueInvTipJuegos;
    private Long movCargueInvTipSolCodigo;
    private Long movCargueInvVlrCarton;
    private String movSolSiito;

    public SiitoConsultaInvSiicol() {
    }

    public SiitoConsultaInvSiicol(Long movCargueInvAnoFab, Long movCargueInvCantSillas, Long movCargueInvCantTerm,
                                  Long movCargueInvCodApuesta, String movCargueInvCodLocal,
                                  Integer movCargueInvCodMarca, String movCargueInvCodModelo, Long movCargueInvCodigo,
                                  String movCargueInvCont, String movCargueInvDirBarrio, String movCargueInvDirDesc,
                                  String movCargueInvEstElem, Long movCargueInvEstUbiInst,
                                  Timestamp movCargueInvFecFinele, Timestamp movCargueInvFecInicioele,
                                  Timestamp movCargueInvFechSol, Long movCargueInvIndInstHomo,
                                  Long movCargueInvIndInstSclmIn, Long movCargueInvIucAd,
                                  String movCargueInvLatEstableci, String movCargueInvLonEstableci,
                                  String movCargueInvModJuego, String movCargueInvModLic, String movCargueInvNit,
                                  String movCargueInvNomLocal, String movCargueInvNuidAd, String movCargueInvNumFab,
                                  Long movCargueInvNumFabSclm, String movCargueInvNumLic,
                                  String movCargueInvSerialInstAd, String movCargueInvTenLegal,
                                  String movCargueInvTipInst, String movCargueInvTipJuegos,
                                  Long movCargueInvTipSolCodigo, Long movCargueInvVlrCarton, String movSolSiito) {
        this.movCargueInvAnoFab = movCargueInvAnoFab;
        this.movCargueInvCantSillas = movCargueInvCantSillas;
        this.movCargueInvCantTerm = movCargueInvCantTerm;
        this.movCargueInvCodApuesta = movCargueInvCodApuesta;
        this.movCargueInvCodLocal = movCargueInvCodLocal;
        this.movCargueInvCodMarca = movCargueInvCodMarca;
        this.movCargueInvCodModelo = movCargueInvCodModelo;
        this.movCargueInvCodigo = movCargueInvCodigo;
        this.movCargueInvCont = movCargueInvCont;
        this.movCargueInvDirBarrio = movCargueInvDirBarrio;
        this.movCargueInvDirDesc = movCargueInvDirDesc;
        this.movCargueInvEstElem = movCargueInvEstElem;
        this.movCargueInvEstUbiInst = movCargueInvEstUbiInst;
        this.movCargueInvFecFinele = movCargueInvFecFinele;
        this.movCargueInvFecInicioele = movCargueInvFecInicioele;
        this.movCargueInvFechSol = movCargueInvFechSol;
        this.movCargueInvIndInstHomo = movCargueInvIndInstHomo;
        this.movCargueInvIndInstSclmIn = movCargueInvIndInstSclmIn;
        this.movCargueInvIucAd = movCargueInvIucAd;
        this.movCargueInvLatEstableci = movCargueInvLatEstableci;
        this.movCargueInvLonEstableci = movCargueInvLonEstableci;
        this.movCargueInvModJuego = movCargueInvModJuego;
        this.movCargueInvModLic = movCargueInvModLic;
        this.movCargueInvNit = movCargueInvNit;
        this.movCargueInvNomLocal = movCargueInvNomLocal;
        this.movCargueInvNuidAd = movCargueInvNuidAd;
        this.movCargueInvNumFab = movCargueInvNumFab;
        this.movCargueInvNumFabSclm = movCargueInvNumFabSclm;
        this.movCargueInvNumLic = movCargueInvNumLic;
        this.movCargueInvSerialInstAd = movCargueInvSerialInstAd;
        this.movCargueInvTenLegal = movCargueInvTenLegal;
        this.movCargueInvTipInst = movCargueInvTipInst;
        this.movCargueInvTipJuegos = movCargueInvTipJuegos;
        this.movCargueInvTipSolCodigo = movCargueInvTipSolCodigo;
        this.movCargueInvVlrCarton = movCargueInvVlrCarton;
        this.movSolSiito = movSolSiito;
    }

    @Column(name = "MOV_CARGUE_INV_ANO_FAB")
    public Long getMovCargueInvAnoFab() {
        return movCargueInvAnoFab;
    }

    public void setMovCargueInvAnoFab(Long movCargueInvAnoFab) {
        this.movCargueInvAnoFab = movCargueInvAnoFab;
    }

    @Column(name = "MOV_CARGUE_INV_CANT_SILLAS")
    public Long getMovCargueInvCantSillas() {
        return movCargueInvCantSillas;
    }

    public void setMovCargueInvCantSillas(Long movCargueInvCantSillas) {
        this.movCargueInvCantSillas = movCargueInvCantSillas;
    }

    @Column(name = "MOV_CARGUE_INV_CANT_TERM")
    public Long getMovCargueInvCantTerm() {
        return movCargueInvCantTerm;
    }

    public void setMovCargueInvCantTerm(Long movCargueInvCantTerm) {
        this.movCargueInvCantTerm = movCargueInvCantTerm;
    }

    @Column(name = "MOV_CARGUE_INV_COD_APUESTA")
    public Long getMovCargueInvCodApuesta() {
        return movCargueInvCodApuesta;
    }

    public void setMovCargueInvCodApuesta(Long movCargueInvCodApuesta) {
        this.movCargueInvCodApuesta = movCargueInvCodApuesta;
    }

    @Column(name = "MOV_CARGUE_INV_COD_LOCAL")
    public String getMovCargueInvCodLocal() {
        return movCargueInvCodLocal;
    }

    public void setMovCargueInvCodLocal(String movCargueInvCodLocal) {
        this.movCargueInvCodLocal = movCargueInvCodLocal;
    }

    @Column(name = "MOV_CARGUE_INV_COD_MARCA")
    public Integer getMovCargueInvCodMarca() {
        return movCargueInvCodMarca;
    }

    public void setMovCargueInvCodMarca(Integer movCargueInvCodMarca) {
        this.movCargueInvCodMarca = movCargueInvCodMarca;
    }

    @Column(name = "MOV_CARGUE_INV_COD_MODELO")
    public String getMovCargueInvCodModelo() {
        return movCargueInvCodModelo;
    }

    public void setMovCargueInvCodModelo(String movCargueInvCodModelo) {
        this.movCargueInvCodModelo = movCargueInvCodModelo;
    }

    @Id
    @Column(name = "MOV_CARGUE_INV_CODIGO", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getMovCargueInvCodigo() {
        return movCargueInvCodigo;
    }

    public void setMovCargueInvCodigo(Long movCargueInvCodigo) {
        this.movCargueInvCodigo = movCargueInvCodigo;
    }

    @Column(name = "MOV_CARGUE_INV_CONT")
    public String getMovCargueInvCont() {
        return movCargueInvCont;
    }

    public void setMovCargueInvCont(String movCargueInvCont) {
        this.movCargueInvCont = movCargueInvCont;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_BARRIO")
    public String getMovCargueInvDirBarrio() {
        return movCargueInvDirBarrio;
    }

    public void setMovCargueInvDirBarrio(String movCargueInvDirBarrio) {
        this.movCargueInvDirBarrio = movCargueInvDirBarrio;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_DESC")
    public String getMovCargueInvDirDesc() {
        return movCargueInvDirDesc;
    }

    public void setMovCargueInvDirDesc(String movCargueInvDirDesc) {
        this.movCargueInvDirDesc = movCargueInvDirDesc;
    }

    @Column(name = "MOV_CARGUE_INV_EST_ELEM")
    public String getMovCargueInvEstElem() {
        return movCargueInvEstElem;
    }

    public void setMovCargueInvEstElem(String movCargueInvEstElem) {
        this.movCargueInvEstElem = movCargueInvEstElem;
    }

    @Column(name = "MOV_CARGUE_INV_EST_UBI_INST")
    public Long getMovCargueInvEstUbiInst() {
        return movCargueInvEstUbiInst;
    }

    public void setMovCargueInvEstUbiInst(Long movCargueInvEstUbiInst) {
        this.movCargueInvEstUbiInst = movCargueInvEstUbiInst;
    }

    @Column(name = "MOV_CARGUE_INV_FEC_FINELE")
    public Timestamp getMovCargueInvFecFinele() {
        return movCargueInvFecFinele;
    }

    public void setMovCargueInvFecFinele(Timestamp movCargueInvFecFinele) {
        this.movCargueInvFecFinele = movCargueInvFecFinele;
    }

    @Column(name = "MOV_CARGUE_INV_FEC_INICIOELE")
    public Timestamp getMovCargueInvFecInicioele() {
        return movCargueInvFecInicioele;
    }

    public void setMovCargueInvFecInicioele(Timestamp movCargueInvFecInicioele) {
        this.movCargueInvFecInicioele = movCargueInvFecInicioele;
    }

    @Column(name = "MOV_CARGUE_INV_FECH_SOL")
    public Timestamp getMovCargueInvFechSol() {
        return movCargueInvFechSol;
    }

    public void setMovCargueInvFechSol(Timestamp movCargueInvFechSol) {
        this.movCargueInvFechSol = movCargueInvFechSol;
    }

    @Column(name = "MOV_CARGUE_INV_IND_INST_HOMO")
    public Long getMovCargueInvIndInstHomo() {
        return movCargueInvIndInstHomo;
    }

    public void setMovCargueInvIndInstHomo(Long movCargueInvIndInstHomo) {
        this.movCargueInvIndInstHomo = movCargueInvIndInstHomo;
    }

    @Column(name = "MOV_CARGUE_INV_IND_INST_SCLM_IN")
    public Long getMovCargueInvIndInstSclmIn() {
        return movCargueInvIndInstSclmIn;
    }

    public void setMovCargueInvIndInstSclmIn(Long movCargueInvIndInstSclmIn) {
        this.movCargueInvIndInstSclmIn = movCargueInvIndInstSclmIn;
    }

    @Column(name = "MOV_CARGUE_INV_IUC_AD")
    public Long getMovCargueInvIucAd() {
        return movCargueInvIucAd;
    }

    public void setMovCargueInvIucAd(Long movCargueInvIucAd) {
        this.movCargueInvIucAd = movCargueInvIucAd;
    }

    @Column(name = "MOV_CARGUE_INV_LAT_ESTABLECI")
    public String getMovCargueInvLatEstableci() {
        return movCargueInvLatEstableci;
    }

    public void setMovCargueInvLatEstableci(String movCargueInvLatEstableci) {
        this.movCargueInvLatEstableci = movCargueInvLatEstableci;
    }

    @Column(name = "MOV_CARGUE_INV_LON_ESTABLECI")
    public String getMovCargueInvLonEstableci() {
        return movCargueInvLonEstableci;
    }

    public void setMovCargueInvLonEstableci(String movCargueInvLonEstableci) {
        this.movCargueInvLonEstableci = movCargueInvLonEstableci;
    }

    @Column(name = "MOV_CARGUE_INV_MOD_JUEGO")
    public String getMovCargueInvModJuego() {
        return movCargueInvModJuego;
    }

    public void setMovCargueInvModJuego(String movCargueInvModJuego) {
        this.movCargueInvModJuego = movCargueInvModJuego;
    }

    @Column(name = "MOV_CARGUE_INV_MOD_LIC")
    public String getMovCargueInvModLic() {
        return movCargueInvModLic;
    }

    public void setMovCargueInvModLic(String movCargueInvModLic) {
        this.movCargueInvModLic = movCargueInvModLic;
    }

    @Column(name = "MOV_CARGUE_INV_NIT")
    public String getMovCargueInvNit() {
        return movCargueInvNit;
    }

    public void setMovCargueInvNit(String movCargueInvNit) {
        this.movCargueInvNit = movCargueInvNit;
    }

    @Column(name = "MOV_CARGUE_INV_NOM_LOCAL")
    public String getMovCargueInvNomLocal() {
        return movCargueInvNomLocal;
    }

    public void setMovCargueInvNomLocal(String movCargueInvNomLocal) {
        this.movCargueInvNomLocal = movCargueInvNomLocal;
    }

    @Column(name = "MOV_CARGUE_INV_NUID_AD")
    public String getMovCargueInvNuidAd() {
        return movCargueInvNuidAd;
    }

    public void setMovCargueInvNuidAd(String movCargueInvNuidAd) {
        this.movCargueInvNuidAd = movCargueInvNuidAd;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_FAB")
    public String getMovCargueInvNumFab() {
        return movCargueInvNumFab;
    }

    public void setMovCargueInvNumFab(String movCargueInvNumFab) {
        this.movCargueInvNumFab = movCargueInvNumFab;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_FAB_SCLM")
    public Long getMovCargueInvNumFabSclm() {
        return movCargueInvNumFabSclm;
    }

    public void setMovCargueInvNumFabSclm(Long movCargueInvNumFabSclm) {
        this.movCargueInvNumFabSclm = movCargueInvNumFabSclm;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_LIC")
    public String getMovCargueInvNumLic() {
        return movCargueInvNumLic;
    }

    public void setMovCargueInvNumLic(String movCargueInvNumLic) {
        this.movCargueInvNumLic = movCargueInvNumLic;
    }

    @Column(name = "MOV_CARGUE_INV_SERIAL_INST_AD")
    public String getMovCargueInvSerialInstAd() {
        return movCargueInvSerialInstAd;
    }

    public void setMovCargueInvSerialInstAd(String movCargueInvSerialInstAd) {
        this.movCargueInvSerialInstAd = movCargueInvSerialInstAd;
    }

    @Column(name = "MOV_CARGUE_INV_TEN_LEGAL")
    public String getMovCargueInvTenLegal() {
        return movCargueInvTenLegal;
    }

    public void setMovCargueInvTenLegal(String movCargueInvTenLegal) {
        this.movCargueInvTenLegal = movCargueInvTenLegal;
    }

    @Column(name = "MOV_CARGUE_INV_TIP_INST")
    public String getMovCargueInvTipInst() {
        return movCargueInvTipInst;
    }

    public void setMovCargueInvTipInst(String movCargueInvTipInst) {
        this.movCargueInvTipInst = movCargueInvTipInst;
    }

    @Column(name = "MOV_CARGUE_INV_TIP_JUEGOS")
    public String getMovCargueInvTipJuegos() {
        return movCargueInvTipJuegos;
    }

    public void setMovCargueInvTipJuegos(String movCargueInvTipJuegos) {
        this.movCargueInvTipJuegos = movCargueInvTipJuegos;
    }

    @Column(name = "MOV_CARGUE_INV_TIP_SOL_CODIGO")
    public Long getMovCargueInvTipSolCodigo() {
        return movCargueInvTipSolCodigo;
    }

    public void setMovCargueInvTipSolCodigo(Long movCargueInvTipSolCodigo) {
        this.movCargueInvTipSolCodigo = movCargueInvTipSolCodigo;
    }

    @Column(name = "MOV_CARGUE_INV_VLR_CARTON")
    public Long getMovCargueInvVlrCarton() {
        return movCargueInvVlrCarton;
    }

    public void setMovCargueInvVlrCarton(Long movCargueInvVlrCarton) {
        this.movCargueInvVlrCarton = movCargueInvVlrCarton;
    }

    @Column(name = "MOV_SOL_SIITO")
    public String getMovSolSiito() {
        return movSolSiito;
    }

    public void setMovSolSiito(String movSolSiito) {
        this.movSolSiito = movSolSiito;
    }

    @Column(name = "MOV_CARGUE_INV_FECH_FIN_LIQ")
    public Timestamp getMovCargueInvFechFinLiq() {
        return movCargueInvFechFinLiq;
    }

    public void setMovCargueInvFechFinLiq(Timestamp movCargueInvFechFinLiq) {
        this.movCargueInvFechFinLiq = movCargueInvFechFinLiq;
    }

    @Column(name = "MOV_CARGUE_INV_FECH_INI_LIQ")
    public Timestamp getMovCargueInvFechIniLiq() {
        return movCargueInvFechIniLiq;
    }

    public void setMovCargueInvFechIniLiq(Timestamp movCargueInvFechIniLiq) {
        this.movCargueInvFechIniLiq = movCargueInvFechIniLiq;
    }
}
