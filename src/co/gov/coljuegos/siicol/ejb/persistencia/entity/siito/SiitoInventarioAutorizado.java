package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIITO_INVENTARIO_AUTORIZADO")
public class SiitoInventarioAutorizado implements Serializable {
    private static final long serialVersionUID = 1341810460276388248L;
    private long invAutAnoFab;
    private int invAutCantSilla;
    private long invAutCodigo;
    private long invAutCodApuesta;
    private String invAutCodDaneMun;
    private String invAutCodLocal;
    private long invAutCodMarca;
    private long invAutCodModelo;
    private String invAutContOper;
    private String invAutDir;
    private String invAutEmail;
    private long invAutEstaDirLocalOper;
    private long invAutEstaSerialRepOper;
    private long invAutEstUbiMet;
    private Timestamp invAutFechaRegistro;
    private long invAutIndEnLineaSclm;
    private long invAutIndHomoMet;
    private long invAutIuc;
    private String invAutLatEsta;
    private String invAutLongEsta;
    private String invAutModJuego;
    private long invAutMovSolCodigo;
    private String invAutNitOper;
    private String invAutNomLocal;
    private String invAutNuid;
    private long invAutNumFab;
    private long invAutNumRegSclm;
    private String invAutSerial;
    private String invAutSolCodigo;
    private String invAutTel;
    private long invAutTipInst;
    private long invAutTipJuego;
    private Long invAutVlrCarton;

    public SiitoInventarioAutorizado() {
    }

    public SiitoInventarioAutorizado(long invAutAnoFab, int invAutCantSilla, long invAutCodApuesta,
                                     String invAutCodDaneMun, String invAutCodLocal, long invAutCodMarca,
                                     long invAutCodModelo, long invAutCodigo, String invAutContOper, String invAutDir,
                                     String invAutEmail, long invAutEstUbiMet, long invAutEstaDirLocalOper,
                                     long invAutEstaSerialRepOper, Timestamp invAutFechaRegistro,
                                     long invAutIndEnLineaSclm, long invAutIndHomoMet, long invAutIuc,
                                     String invAutLatEsta, String invAutLongEsta, String invAutModJuego,
                                     long invAutMovSolCodigo, String invAutNitOper, String invAutNomLocal,
                                     String invAutNuid, long invAutNumFab, long invAutNumRegSclm, String invAutSerial,
                                     String invAutSolCodigo, String invAutTel, long invAutTipInst, long invAutTipJuego,
                                     Long invAutVlrCarton) {
        this.invAutAnoFab = invAutAnoFab;
        this.invAutCantSilla = invAutCantSilla;
        this.invAutCodApuesta = invAutCodApuesta;
        this.invAutCodDaneMun = invAutCodDaneMun;
        this.invAutCodLocal = invAutCodLocal;
        this.invAutCodMarca = invAutCodMarca;
        this.invAutCodModelo = invAutCodModelo;
        this.invAutCodigo = invAutCodigo;
        this.invAutContOper = invAutContOper;
        this.invAutDir = invAutDir;
        this.invAutEmail = invAutEmail;
        this.invAutEstUbiMet = invAutEstUbiMet;
        this.invAutEstaDirLocalOper = invAutEstaDirLocalOper;
        this.invAutEstaSerialRepOper = invAutEstaSerialRepOper;
        this.invAutFechaRegistro = invAutFechaRegistro;
        this.invAutIndEnLineaSclm = invAutIndEnLineaSclm;
        this.invAutIndHomoMet = invAutIndHomoMet;
        this.invAutIuc = invAutIuc;
        this.invAutLatEsta = invAutLatEsta;
        this.invAutLongEsta = invAutLongEsta;
        this.invAutModJuego = invAutModJuego;
        this.invAutMovSolCodigo = invAutMovSolCodigo;
        this.invAutNitOper = invAutNitOper;
        this.invAutNomLocal = invAutNomLocal;
        this.invAutNuid = invAutNuid;
        this.invAutNumFab = invAutNumFab;
        this.invAutNumRegSclm = invAutNumRegSclm;
        this.invAutSerial = invAutSerial;
        this.invAutSolCodigo = invAutSolCodigo;
        this.invAutTel = invAutTel;
        this.invAutTipInst = invAutTipInst;
        this.invAutTipJuego = invAutTipJuego;
        this.invAutVlrCarton = invAutVlrCarton;
    }

    @Column(name = "INV_AUT_ANO_FAB")
    public long getInvAutAnoFab() {
        return invAutAnoFab;
    }

    public void setInvAutAnoFab(long invAutAnoFab) {
        this.invAutAnoFab = invAutAnoFab;
    }

    @Column(name = "INV_AUT_CANT_SILLA")
    public int getInvAutCantSilla() {
        return invAutCantSilla;
    }

    public void setInvAutCantSilla(int invAutCantSilla) {
        this.invAutCantSilla = invAutCantSilla;
    }

    @Id
    @Column(name = "INV_AUT_CODIGO", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getInvAutCodigo() {
        return invAutCodigo;
    }

    public void setInvAutCodigo(long invAutCodigo) {
        this.invAutCodigo = invAutCodigo;
    }

    @Column(name = "INV_AUT_COD_APUESTA")
    public long getInvAutCodApuesta() {
        return invAutCodApuesta;
    }

    public void setInvAutCodApuesta(long invAutCodApuesta) {
        this.invAutCodApuesta = invAutCodApuesta;
    }

    @Column(name = "INV_AUT_COD_DANE_MUN")
    public String getInvAutCodDaneMun() {
        return invAutCodDaneMun;
    }

    public void setInvAutCodDaneMun(String invAutCodDaneMun) {
        this.invAutCodDaneMun = invAutCodDaneMun;
    }

    @Column(name = "INV_AUT_COD_LOCAL")
    public String getInvAutCodLocal() {
        return invAutCodLocal;
    }

    public void setInvAutCodLocal(String invAutCodLocal) {
        this.invAutCodLocal = invAutCodLocal;
    }

    @Column(name = "INV_AUT_COD_MARCA")
    public long getInvAutCodMarca() {
        return invAutCodMarca;
    }

    public void setInvAutCodMarca(long invAutCodMarca) {
        this.invAutCodMarca = invAutCodMarca;
    }

    @Column(name = "INV_AUT_COD_MODELO")
    public long getInvAutCodModelo() {
        return invAutCodModelo;
    }

    public void setInvAutCodModelo(long invAutCodModelo) {
        this.invAutCodModelo = invAutCodModelo;
    }

    @Column(name = "INV_AUT_CONT_OPER")
    public String getInvAutContOper() {
        return invAutContOper;
    }

    public void setInvAutContOper(String invAutContOper) {
        this.invAutContOper = invAutContOper;
    }

    @Column(name = "INV_AUT_DIR")
    public String getInvAutDir() {
        return invAutDir;
    }

    public void setInvAutDir(String invAutDir) {
        this.invAutDir = invAutDir;
    }

    @Column(name = "INV_AUT_EMAIL")
    public String getInvAutEmail() {
        return invAutEmail;
    }

    public void setInvAutEmail(String invAutEmail) {
        this.invAutEmail = invAutEmail;
    }

    @Column(name = "INV_AUT_ESTA_DIR_LOCAL_OPER")
    public long getInvAutEstaDirLocalOper() {
        return invAutEstaDirLocalOper;
    }

    public void setInvAutEstaDirLocalOper(long invAutEstaDirLocalOper) {
        this.invAutEstaDirLocalOper = invAutEstaDirLocalOper;
    }

    @Column(name = "INV_AUT_ESTA_SERIAL_REP_OPER")
    public long getInvAutEstaSerialRepOper() {
        return invAutEstaSerialRepOper;
    }

    public void setInvAutEstaSerialRepOper(long invAutEstaSerialRepOper) {
        this.invAutEstaSerialRepOper = invAutEstaSerialRepOper;
    }

    @Column(name = "INV_AUT_EST_UBI_MET")
    public long getInvAutEstUbiMet() {
        return invAutEstUbiMet;
    }

    public void setInvAutEstUbiMet(long invAutEstUbiMet) {
        this.invAutEstUbiMet = invAutEstUbiMet;
    }

    @Column(name = "INV_AUT_FECHA_REGISTRO")
    public Timestamp getInvAutFechaRegistro() {
        return invAutFechaRegistro;
    }

    public void setInvAutFechaRegistro(Timestamp invAutFechaRegistro) {
        this.invAutFechaRegistro = invAutFechaRegistro;
    }

    @Column(name = "INV_AUT_IND_EN_LINEA_SCLM")
    public long getInvAutIndEnLineaSclm() {
        return invAutIndEnLineaSclm;
    }

    public void setInvAutIndEnLineaSclm(long invAutIndEnLineaSclm) {
        this.invAutIndEnLineaSclm = invAutIndEnLineaSclm;
    }

    @Column(name = "INV_AUT_IND_HOMO_MET")
    public long getInvAutIndHomoMet() {
        return invAutIndHomoMet;
    }

    public void setInvAutIndHomoMet(long invAutIndHomoMet) {
        this.invAutIndHomoMet = invAutIndHomoMet;
    }

    @Column(name = "INV_AUT_IUC")
    public long getInvAutIuc() {
        return invAutIuc;
    }

    public void setInvAutIuc(long invAutIuc) {
        this.invAutIuc = invAutIuc;
    }

    @Column(name = "INV_AUT_LAT_ESTA")
    public String getInvAutLatEsta() {
        return invAutLatEsta;
    }

    public void setInvAutLatEsta(String invAutLatEsta) {
        this.invAutLatEsta = invAutLatEsta;
    }

    @Column(name = "INV_AUT_LONG_ESTA")
    public String getInvAutLongEsta() {
        return invAutLongEsta;
    }

    public void setInvAutLongEsta(String invAutLongEsta) {
        this.invAutLongEsta = invAutLongEsta;
    }

    @Column(name = "INV_AUT_MOD_JUEGO")
    public String getInvAutModJuego() {
        return invAutModJuego;
    }

    public void setInvAutModJuego(String invAutModJuego) {
        this.invAutModJuego = invAutModJuego;
    }

    @Column(name = "INV_AUT_MOV_SOL_CODIGO")
    public long getInvAutMovSolCodigo() {
        return invAutMovSolCodigo;
    }

    public void setInvAutMovSolCodigo(long invAutMovSolCodigo) {
        this.invAutMovSolCodigo = invAutMovSolCodigo;
    }

    @Column(name = "INV_AUT_NIT_OPER")
    public String getInvAutNitOper() {
        return invAutNitOper;
    }

    public void setInvAutNitOper(String invAutNitOper) {
        this.invAutNitOper = invAutNitOper;
    }

    @Column(name = "INV_AUT_NOM_LOCAL")
    public String getInvAutNomLocal() {
        return invAutNomLocal;
    }

    public void setInvAutNomLocal(String invAutNomLocal) {
        this.invAutNomLocal = invAutNomLocal;
    }

    @Column(name = "INV_AUT_NUID")
    public String getInvAutNuid() {
        return invAutNuid;
    }

    public void setInvAutNuid(String invAutNuid) {
        this.invAutNuid = invAutNuid;
    }

    @Column(name = "INV_AUT_NUM_FAB")
    public long getInvAutNumFab() {
        return invAutNumFab;
    }

    public void setInvAutNumFab(long invAutNumFab) {
        this.invAutNumFab = invAutNumFab;
    }

    @Column(name = "INV_AUT_NUM_REG_SCLM")
    public long getInvAutNumRegSclm() {
        return invAutNumRegSclm;
    }

    public void setInvAutNumRegSclm(long invAutNumRegSclm) {
        this.invAutNumRegSclm = invAutNumRegSclm;
    }

    @Column(name = "INV_AUT_SERIAL")
    public String getInvAutSerial() {
        return invAutSerial;
    }

    public void setInvAutSerial(String invAutSerial) {
        this.invAutSerial = invAutSerial;
    }

    @Column(name = "INV_AUT_SOL_CODIGO")
    public String getInvAutSolCodigo() {
        return invAutSolCodigo;
    }

    public void setInvAutSolCodigo(String invAutSolCodigo) {
        this.invAutSolCodigo = invAutSolCodigo;
    }

    @Column(name = "INV_AUT_TEL")
    public String getInvAutTel() {
        return invAutTel;
    }

    public void setInvAutTel(String invAutTel) {
        this.invAutTel = invAutTel;
    }

    @Column(name = "INV_AUT_TIP_INST")
    public long getInvAutTipInst() {
        return invAutTipInst;
    }

    public void setInvAutTipInst(long invAutTipInst) {
        this.invAutTipInst = invAutTipInst;
    }

    @Column(name = "INV_AUT_TIP_JUEGO")
    public long getInvAutTipJuego() {
        return invAutTipJuego;
    }

    public void setInvAutTipJuego(long invAutTipJuego) {
        this.invAutTipJuego = invAutTipJuego;
    }

    @Column(name = "INV_AUT_VLR_CARTON")
    public Long getInvAutVlrCarton() {
        return invAutVlrCarton;
    }

    public void setInvAutVlrCarton(Long invAutVlrCarton) {
        this.invAutVlrCarton = invAutVlrCarton;
    }
}
