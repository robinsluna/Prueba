package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIITO_MOV_CARGUE_INVENTARIO")
public class SiitoMovCargueInventario implements Serializable {
    private static final long serialVersionUID = -3048667522173210599L;
    private String codAcure;
    private long movCargueInvAnoFab;
    private long movCargueInvCantSillas;
    private long movCargueInvCodigo;
    private long movCargueInvCodApuesta;
    private String movCargueInvCodGestDoc;
    private String movCargueInvCodLocal;
    private String movCargueInvCodLocalDest;
    private Integer movCargueInvCodMarca;
    private String movCargueInvCodModelo;
    private String movCargueInvCodMunLoc;
    private String movCargueInvCodMunLocDest;
    private String movCargueInvCont;
    private String movCargueInvDirBarrio;
    private String movCargueInvDirDesc;
    private String movCargueInvDirInfoAdi;
    private long movCargueInvDirNumPre;
    private long movCargueInvDirNumViaG;
    private long movCargueInvDirNumViaP;
    private String movCargueInvDirSecCiu;
    private String movCargueInvDirSufiViaG;
    private String movCargueInvDirSufiViaP;
    private long movCargueInvDirViaPriCod;
    private long movCargueInvEstUbiInst;
    private Timestamp movCargueInvFechSol;
    private String movCargueInvIndAmpDis;
    private Integer movCargueInvIndDup;
    private Integer movCargueInvIndIle;
    private Integer movCargueInvIndImpTip1;
    private Integer movCargueInvIndImpTip2;
    private long movCargueInvIndInstHomo;
    private long movCargueInvIndInstSclmIn;
    private Long movCargueInvIucAd;
    private String movCargueInvIucRet;
    private String movCargueInvLatEstableci;
    private String movCargueInvLonEstableci;
    private String movCargueInvModJuego;
    private String movCargueInvNit;
    private String movCargueInvNomLocal;
    private String movCargueInvNomLocalDest;
    private String movCargueInvNuidAd;
    private String movCargueInvNuidRet;
    private String movCargueInvNumFab;
    private long movCargueInvNumFabSclm;
    private String movCargueInvSerialInstAd;
    private String movCargueInvSerialInstRet;
    private String movCargueInvTenLegal;
    private String movCargueInvTipInst;
    private String movCargueInvTipJuegos;
    private long movCargueInvTipNov;
    private long movCargueInvTipSolCodigo;
    private Long movCargueInvVlrCarton;
    private String movCargueInvVlrInd;
    private long movSolCodigo;
    private String movSolSiito;
    private List<SiitoMovCargInvEstCargInv> siitoMovCargInvEstCargInvList;
    private long movCargueInvCantTerm;
    private long movCargueInvCodApuestaNew;
    private boolean movCargueInvEstVal;
    private String movCargueInvModLic;
    private String movCargueInvNumLic;

    public SiitoMovCargueInventario() {
    }

    public SiitoMovCargueInventario(String codAcure, long movCargueInvAnoFab, long movCargueInvCantSillas,
                                    long movCargueInvCodApuesta, String movCargueInvCodGestDoc,
                                    String movCargueInvCodLocal, String movCargueInvCodLocalDest,
                                    Integer movCargueInvCodMarca, String movCargueInvCodModelo,
                                    String movCargueInvCodMunLoc, String movCargueInvCodMunLocDest,
                                    long movCargueInvCodigo, String movCargueInvCont, String movCargueInvDirBarrio,
                                    String movCargueInvDirDesc, String movCargueInvDirInfoAdi,
                                    long movCargueInvDirNumPre, long movCargueInvDirNumViaG,
                                    long movCargueInvDirNumViaP, String movCargueInvDirSecCiu,
                                    String movCargueInvDirSufiViaG, String movCargueInvDirSufiViaP,
                                    long movCargueInvDirViaPriCod, long movCargueInvEstUbiInst,
                                    Timestamp movCargueInvFechSol, String movCargueInvIndAmpDis,
                                    Integer movCargueInvIndDup, Integer movCargueInvIndIle,
                                    Integer movCargueInvIndImpTip1, Integer movCargueInvIndImpTip2,
                                    long movCargueInvIndInstHomo, long movCargueInvIndInstSclmIn,
                                    Long movCargueInvIucAd, String movCargueInvIucRet, String movCargueInvLatEstableci,
                                    String movCargueInvLonEstableci, String movCargueInvModJuego,
                                    String movCargueInvNit, String movCargueInvNomLocal,
                                    String movCargueInvNomLocalDest, String movCargueInvNuidAd,
                                    String movCargueInvNuidRet, String movCargueInvNumFab, long movCargueInvNumFabSclm,
                                    String movCargueInvSerialInstAd, String movCargueInvSerialInstRet,
                                    String movCargueInvTenLegal, String movCargueInvTipInst,
                                    String movCargueInvTipJuegos, long movCargueInvTipNov,
                                    long movCargueInvTipSolCodigo, Long movCargueInvVlrCarton,
                                    String movCargueInvVlrInd, long movSolCodigo, String movSolSiito) {
        this.codAcure = codAcure;
        this.movCargueInvAnoFab = movCargueInvAnoFab;
        this.movCargueInvCantSillas = movCargueInvCantSillas;
        this.movCargueInvCodApuesta = movCargueInvCodApuesta;
        this.movCargueInvCodGestDoc = movCargueInvCodGestDoc;
        this.movCargueInvCodLocal = movCargueInvCodLocal;
        this.movCargueInvCodLocalDest = movCargueInvCodLocalDest;
        this.movCargueInvCodMarca = movCargueInvCodMarca;
        this.movCargueInvCodModelo = movCargueInvCodModelo;
        this.movCargueInvCodMunLoc = movCargueInvCodMunLoc;
        this.movCargueInvCodMunLocDest = movCargueInvCodMunLocDest;
        this.movCargueInvCodigo = movCargueInvCodigo;
        this.movCargueInvCont = movCargueInvCont;
        this.movCargueInvDirBarrio = movCargueInvDirBarrio;
        this.movCargueInvDirDesc = movCargueInvDirDesc;
        this.movCargueInvDirInfoAdi = movCargueInvDirInfoAdi;
        this.movCargueInvDirNumPre = movCargueInvDirNumPre;
        this.movCargueInvDirNumViaG = movCargueInvDirNumViaG;
        this.movCargueInvDirNumViaP = movCargueInvDirNumViaP;
        this.movCargueInvDirSecCiu = movCargueInvDirSecCiu;
        this.movCargueInvDirSufiViaG = movCargueInvDirSufiViaG;
        this.movCargueInvDirSufiViaP = movCargueInvDirSufiViaP;
        this.movCargueInvDirViaPriCod = movCargueInvDirViaPriCod;
        this.movCargueInvEstUbiInst = movCargueInvEstUbiInst;
        this.movCargueInvFechSol = movCargueInvFechSol;
        this.movCargueInvIndAmpDis = movCargueInvIndAmpDis;
        this.movCargueInvIndDup = movCargueInvIndDup;
        this.movCargueInvIndIle = movCargueInvIndIle;
        this.movCargueInvIndImpTip1 = movCargueInvIndImpTip1;
        this.movCargueInvIndImpTip2 = movCargueInvIndImpTip2;
        this.movCargueInvIndInstHomo = movCargueInvIndInstHomo;
        this.movCargueInvIndInstSclmIn = movCargueInvIndInstSclmIn;
        this.movCargueInvIucAd = movCargueInvIucAd;
        this.movCargueInvIucRet = movCargueInvIucRet;
        this.movCargueInvLatEstableci = movCargueInvLatEstableci;
        this.movCargueInvLonEstableci = movCargueInvLonEstableci;
        this.movCargueInvModJuego = movCargueInvModJuego;
        this.movCargueInvNit = movCargueInvNit;
        this.movCargueInvNomLocal = movCargueInvNomLocal;
        this.movCargueInvNomLocalDest = movCargueInvNomLocalDest;
        this.movCargueInvNuidAd = movCargueInvNuidAd;
        this.movCargueInvNuidRet = movCargueInvNuidRet;
        this.movCargueInvNumFab = movCargueInvNumFab;
        this.movCargueInvNumFabSclm = movCargueInvNumFabSclm;
        this.movCargueInvSerialInstAd = movCargueInvSerialInstAd;
        this.movCargueInvSerialInstRet = movCargueInvSerialInstRet;
        this.movCargueInvTenLegal = movCargueInvTenLegal;
        this.movCargueInvTipInst = movCargueInvTipInst;
        this.movCargueInvTipJuegos = movCargueInvTipJuegos;
        this.movCargueInvTipNov = movCargueInvTipNov;
        this.movCargueInvTipSolCodigo = movCargueInvTipSolCodigo;
        this.movCargueInvVlrCarton = movCargueInvVlrCarton;
        this.movCargueInvVlrInd = movCargueInvVlrInd;
        this.movSolCodigo = movSolCodigo;
        this.movSolSiito = movSolSiito;
    }

    @Column(name = "COD_ACURE")
    public String getCodAcure() {
        return codAcure;
    }

    public void setCodAcure(String codAcure) {
        this.codAcure = codAcure;
    }

    @Column(name = "MOV_CARGUE_INV_ANO_FAB")
    public long getMovCargueInvAnoFab() {
        return movCargueInvAnoFab;
    }

    public void setMovCargueInvAnoFab(long movCargueInvAnoFab) {
        this.movCargueInvAnoFab = movCargueInvAnoFab;
    }

    @Column(name = "MOV_CARGUE_INV_CANT_SILLAS")
    public long getMovCargueInvCantSillas() {
        return movCargueInvCantSillas;
    }

    public void setMovCargueInvCantSillas(long movCargueInvCantSillas) {
        this.movCargueInvCantSillas = movCargueInvCantSillas;
    }

    @Id
    @Column(name = "MOV_CARGUE_INV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getMovCargueInvCodigo() {
        return movCargueInvCodigo;
    }

    public void setMovCargueInvCodigo(long movCargueInvCodigo) {
        this.movCargueInvCodigo = movCargueInvCodigo;
    }

    @Column(name = "MOV_CARGUE_INV_COD_APUESTA")
    public long getMovCargueInvCodApuesta() {
        return movCargueInvCodApuesta;
    }

    public void setMovCargueInvCodApuesta(long movCargueInvCodApuesta) {
        this.movCargueInvCodApuesta = movCargueInvCodApuesta;
    }

    @Column(name = "MOV_CARGUE_INV_COD_GEST_DOC")
    public String getMovCargueInvCodGestDoc() {
        return movCargueInvCodGestDoc;
    }

    public void setMovCargueInvCodGestDoc(String movCargueInvCodGestDoc) {
        this.movCargueInvCodGestDoc = movCargueInvCodGestDoc;
    }

    @Column(name = "MOV_CARGUE_INV_COD_LOCAL")
    public String getMovCargueInvCodLocal() {
        return movCargueInvCodLocal;
    }

    public void setMovCargueInvCodLocal(String movCargueInvCodLocal) {
        this.movCargueInvCodLocal = movCargueInvCodLocal;
    }

    @Column(name = "MOV_CARGUE_INV_COD_LOCAL_DEST")
    public String getMovCargueInvCodLocalDest() {
        return movCargueInvCodLocalDest;
    }

    public void setMovCargueInvCodLocalDest(String movCargueInvCodLocalDest) {
        this.movCargueInvCodLocalDest = movCargueInvCodLocalDest;
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

    @Column(name = "MOV_CARGUE_INV_COD_MUN_LOC")
    public String getMovCargueInvCodMunLoc() {
        return movCargueInvCodMunLoc;
    }

    public void setMovCargueInvCodMunLoc(String movCargueInvCodMunLoc) {
        this.movCargueInvCodMunLoc = movCargueInvCodMunLoc;
    }

    @Column(name = "MOV_CARGUE_INV_COD_MUN_LOC_DEST")
    public String getMovCargueInvCodMunLocDest() {
        return movCargueInvCodMunLocDest;
    }

    public void setMovCargueInvCodMunLocDest(String movCargueInvCodMunLocDest) {
        this.movCargueInvCodMunLocDest = movCargueInvCodMunLocDest;
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

    @Column(name = "MOV_CARGUE_INV_DIR_INFO_ADI")
    public String getMovCargueInvDirInfoAdi() {
        return movCargueInvDirInfoAdi;
    }

    public void setMovCargueInvDirInfoAdi(String movCargueInvDirInfoAdi) {
        this.movCargueInvDirInfoAdi = movCargueInvDirInfoAdi;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_NUM_PRE")
    public long getMovCargueInvDirNumPre() {
        return movCargueInvDirNumPre;
    }

    public void setMovCargueInvDirNumPre(long movCargueInvDirNumPre) {
        this.movCargueInvDirNumPre = movCargueInvDirNumPre;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_NUM_VIA_G")
    public long getMovCargueInvDirNumViaG() {
        return movCargueInvDirNumViaG;
    }

    public void setMovCargueInvDirNumViaG(long movCargueInvDirNumViaG) {
        this.movCargueInvDirNumViaG = movCargueInvDirNumViaG;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_NUM_VIA_P")
    public long getMovCargueInvDirNumViaP() {
        return movCargueInvDirNumViaP;
    }

    public void setMovCargueInvDirNumViaP(long movCargueInvDirNumViaP) {
        this.movCargueInvDirNumViaP = movCargueInvDirNumViaP;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_SEC_CIU")
    public String getMovCargueInvDirSecCiu() {
        return movCargueInvDirSecCiu;
    }

    public void setMovCargueInvDirSecCiu(String movCargueInvDirSecCiu) {
        this.movCargueInvDirSecCiu = movCargueInvDirSecCiu;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_SUFI_VIA_G")
    public String getMovCargueInvDirSufiViaG() {
        return movCargueInvDirSufiViaG;
    }

    public void setMovCargueInvDirSufiViaG(String movCargueInvDirSufiViaG) {
        this.movCargueInvDirSufiViaG = movCargueInvDirSufiViaG;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_SUFI_VIA_P")
    public String getMovCargueInvDirSufiViaP() {
        return movCargueInvDirSufiViaP;
    }

    public void setMovCargueInvDirSufiViaP(String movCargueInvDirSufiViaP) {
        this.movCargueInvDirSufiViaP = movCargueInvDirSufiViaP;
    }

    @Column(name = "MOV_CARGUE_INV_DIR_VIA_PRI_COD")
    public long getMovCargueInvDirViaPriCod() {
        return movCargueInvDirViaPriCod;
    }

    public void setMovCargueInvDirViaPriCod(long movCargueInvDirViaPriCod) {
        this.movCargueInvDirViaPriCod = movCargueInvDirViaPriCod;
    }

    @Column(name = "MOV_CARGUE_INV_EST_UBI_INST")
    public long getMovCargueInvEstUbiInst() {
        return movCargueInvEstUbiInst;
    }

    public void setMovCargueInvEstUbiInst(long movCargueInvEstUbiInst) {
        this.movCargueInvEstUbiInst = movCargueInvEstUbiInst;
    }

    @Column(name = "MOV_CARGUE_INV_FECH_SOL")
    public Timestamp getMovCargueInvFechSol() {
        return movCargueInvFechSol;
    }

    public void setMovCargueInvFechSol(Timestamp movCargueInvFechSol) {
        this.movCargueInvFechSol = movCargueInvFechSol;
    }

    @Column(name = "MOV_CARGUE_INV_IND_AMP_DIS")
    public String getMovCargueInvIndAmpDis() {
        return movCargueInvIndAmpDis;
    }

    public void setMovCargueInvIndAmpDis(String movCargueInvIndAmpDis) {
        this.movCargueInvIndAmpDis = movCargueInvIndAmpDis;
    }

    @Column(name = "MOV_CARGUE_INV_IND_DUP")
    public Integer getMovCargueInvIndDup() {
        return movCargueInvIndDup;
    }

    public void setMovCargueInvIndDup(Integer movCargueInvIndDup) {
        this.movCargueInvIndDup = movCargueInvIndDup;
    }

    @Column(name = "MOV_CARGUE_INV_IND_ILE")
    public Integer getMovCargueInvIndIle() {
        return movCargueInvIndIle;
    }

    public void setMovCargueInvIndIle(Integer movCargueInvIndIle) {
        this.movCargueInvIndIle = movCargueInvIndIle;
    }

    @Column(name = "MOV_CARGUE_INV_IND_IMP_TIP1")
    public Integer getMovCargueInvIndImpTip1() {
        return movCargueInvIndImpTip1;
    }

    public void setMovCargueInvIndImpTip1(Integer movCargueInvIndImpTip1) {
        this.movCargueInvIndImpTip1 = movCargueInvIndImpTip1;
    }

    @Column(name = "MOV_CARGUE_INV_IND_IMP_TIP2")
    public Integer getMovCargueInvIndImpTip2() {
        return movCargueInvIndImpTip2;
    }

    public void setMovCargueInvIndImpTip2(Integer movCargueInvIndImpTip2) {
        this.movCargueInvIndImpTip2 = movCargueInvIndImpTip2;
    }

    @Column(name = "MOV_CARGUE_INV_IND_INST_HOMO")
    public long getMovCargueInvIndInstHomo() {
        return movCargueInvIndInstHomo;
    }

    public void setMovCargueInvIndInstHomo(long movCargueInvIndInstHomo) {
        this.movCargueInvIndInstHomo = movCargueInvIndInstHomo;
    }

    @Column(name = "MOV_CARGUE_INV_IND_INST_SCLM_IN")
    public long getMovCargueInvIndInstSclmIn() {
        return movCargueInvIndInstSclmIn;
    }

    public void setMovCargueInvIndInstSclmIn(long movCargueInvIndInstSclmIn) {
        this.movCargueInvIndInstSclmIn = movCargueInvIndInstSclmIn;
    }

    @Column(name = "MOV_CARGUE_INV_IUC_AD")
    public Long getMovCargueInvIucAd() {
        return movCargueInvIucAd;
    }

    public void setMovCargueInvIucAd(Long movCargueInvIucAd) {
        this.movCargueInvIucAd = movCargueInvIucAd;
    }

    @Column(name = "MOV_CARGUE_INV_IUC_RET")
    public String getMovCargueInvIucRet() {
        return movCargueInvIucRet;
    }

    public void setMovCargueInvIucRet(String movCargueInvIucRet) {
        this.movCargueInvIucRet = movCargueInvIucRet;
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

    @Column(name = "MOV_CARGUE_INV_NOM_LOCAL_DEST")
    public String getMovCargueInvNomLocalDest() {
        return movCargueInvNomLocalDest;
    }

    public void setMovCargueInvNomLocalDest(String movCargueInvNomLocalDest) {
        this.movCargueInvNomLocalDest = movCargueInvNomLocalDest;
    }

    @Column(name = "MOV_CARGUE_INV_NUID_AD")
    public String getMovCargueInvNuidAd() {
        return movCargueInvNuidAd;
    }

    public void setMovCargueInvNuidAd(String movCargueInvNuidAd) {
        this.movCargueInvNuidAd = movCargueInvNuidAd;
    }

    @Column(name = "MOV_CARGUE_INV_NUID_RET")
    public String getMovCargueInvNuidRet() {
        return movCargueInvNuidRet;
    }

    public void setMovCargueInvNuidRet(String movCargueInvNuidRet) {
        this.movCargueInvNuidRet = movCargueInvNuidRet;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_FAB")
    public String getMovCargueInvNumFab() {
        return movCargueInvNumFab;
    }

    public void setMovCargueInvNumFab(String movCargueInvNumFab) {
        this.movCargueInvNumFab = movCargueInvNumFab;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_FAB_SCLM")
    public long getMovCargueInvNumFabSclm() {
        return movCargueInvNumFabSclm;
    }

    public void setMovCargueInvNumFabSclm(long movCargueInvNumFabSclm) {
        this.movCargueInvNumFabSclm = movCargueInvNumFabSclm;
    }

    @Column(name = "MOV_CARGUE_INV_SERIAL_INST_AD")
    public String getMovCargueInvSerialInstAd() {
        return movCargueInvSerialInstAd;
    }

    public void setMovCargueInvSerialInstAd(String movCargueInvSerialInstAd) {
        this.movCargueInvSerialInstAd = movCargueInvSerialInstAd;
    }

    @Column(name = "MOV_CARGUE_INV_SERIAL_INST_RET")
    public String getMovCargueInvSerialInstRet() {
        return movCargueInvSerialInstRet;
    }

    public void setMovCargueInvSerialInstRet(String movCargueInvSerialInstRet) {
        this.movCargueInvSerialInstRet = movCargueInvSerialInstRet;
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

    @Column(name = "MOV_CARGUE_INV_TIP_NOV")
    public long getMovCargueInvTipNov() {
        return movCargueInvTipNov;
    }

    public void setMovCargueInvTipNov(long movCargueInvTipNov) {
        this.movCargueInvTipNov = movCargueInvTipNov;
    }

    @Column(name = "MOV_CARGUE_INV_TIP_SOL_CODIGO")
    public long getMovCargueInvTipSolCodigo() {
        return movCargueInvTipSolCodigo;
    }

    public void setMovCargueInvTipSolCodigo(long movCargueInvTipSolCodigo) {
        this.movCargueInvTipSolCodigo = movCargueInvTipSolCodigo;
    }

    @Column(name = "MOV_CARGUE_INV_VLR_CARTON")
    public Long getMovCargueInvVlrCarton() {
        return movCargueInvVlrCarton;
    }

    public void setMovCargueInvVlrCarton(Long movCargueInvVlrCarton) {
        this.movCargueInvVlrCarton = movCargueInvVlrCarton;
    }

    @Column(name = "MOV_CARGUE_INV_VLR_IND")
    public String getMovCargueInvVlrInd() {
        return movCargueInvVlrInd;
    }

    public void setMovCargueInvVlrInd(String movCargueInvVlrInd) {
        this.movCargueInvVlrInd = movCargueInvVlrInd;
    }

    @Column(name = "MOV_SOL_CODIGO")
    public long getMovSolCodigo() {
        return movSolCodigo;
    }

    public void setMovSolCodigo(long movSolCodigo) {
        this.movSolCodigo = movSolCodigo;
    }

    @Column(name = "MOV_SOL_SIITO")
    public String getMovSolSiito() {
        return movSolSiito;
    }

    public void setMovSolSiito(String movSolSiito) {
        this.movSolSiito = movSolSiito;
    }

    @Column(name = "MOV_CARGUE_INV_CANT_TERM")
    public long getMovCargueInvCantTerm() {
        return movCargueInvCantTerm;
    }

    public void setMovCargueInvCantTerm(long movCargueInvCantTerm) {
        this.movCargueInvCantTerm = movCargueInvCantTerm;
    }

    @Column(name = "MOV_CARGUE_INV_COD_APUESTA_NEW")
    public long getMovCargueInvCodApuestaNew() {
        return movCargueInvCodApuestaNew;
    }

    public void setMovCargueInvCodApuestaNew(long movCargueInvCodApuestaNew) {
        this.movCargueInvCodApuestaNew = movCargueInvCodApuestaNew;
    }

    @Column(name = "MOV_CARGUE_INV_EST_VAL")
    public boolean getMovCargueInvEstVal() {
        return movCargueInvEstVal;
    }

    public void setMovCargueInvEstVal(boolean movCargueInvEstVal) {
        this.movCargueInvEstVal = movCargueInvEstVal;
    }

    @Column(name = "MOV_CARGUE_INV_MOD_LIC")
    public String getMovCargueInvModLic() {
        return movCargueInvModLic;
    }

    public void setMovCargueInvModLic(String movCargueInvModLic) {
        this.movCargueInvModLic = movCargueInvModLic;
    }

    @Column(name = "MOV_CARGUE_INV_NUM_LIC")
    public String getMovCargueInvNumLic() {
        return movCargueInvNumLic;
    }

    public void setMovCargueInvNumLic(String movCargueInvNumLic) {
        this.movCargueInvNumLic = movCargueInvNumLic;
    }
}
