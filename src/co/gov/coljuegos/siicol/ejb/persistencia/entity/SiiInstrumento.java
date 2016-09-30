package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_INSTRUMENTO")
public class SiiInstrumento implements Serializable {
    private static final long serialVersionUID = -8459653986763137645L;
    private String insActivo;
    private Long insCodigo;
    private Date insFechaModific;
    private Date insFechaRegistro;
    private Long tapCodigo;
    private SiiTipoInstrumento siiTipoInstrumento;
    private SiiMet siiMet;
    private List<SiiInventario> siiInventarioList1;
    private SiiOperador siiOperador1;
    private SiiMesaCasino siiMesaCasino;
    private SiiTerminalAcdv siiTerminalAcdv;

    public SiiInstrumento() {
    }

    public SiiInstrumento(String insActivo, Long insCodigo, Date insFechaModific, Date insFechaRegistro, SiiMet siiMet,
                          SiiOperador siiOperador1, Long tapCodigo, SiiTipoInstrumento siiTipoInstrumento,
						SiiMesaCasino siiMesaCasino) {
        this.insActivo = insActivo;
        this.insCodigo = insCodigo;
        this.insFechaModific = insFechaModific;
        this.insFechaRegistro = insFechaRegistro;
        this.siiMet = siiMet;
        this.siiOperador1 = siiOperador1;
        this.siiMesaCasino = siiMesaCasino;
        this.tapCodigo = tapCodigo;
        this.siiTipoInstrumento = siiTipoInstrumento;
    }

    @Column(name = "INS_ACTIVO", nullable = false, length = 1)
    public String getInsActivo() {
        return insActivo;
    }

    public void setInsActivo(String insActivo) {
        this.insActivo = insActivo;
    }

    @Id
    @Column(name = "INS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INSTRUMENTO_COD")
    @SequenceGenerator(name = "SEQ_INSTRUMENTO_COD", sequenceName = "SEQ_INSTRUMENTO_COD",allocationSize=1)
    public Long getInsCodigo() {
        return insCodigo;
    }

    public void setInsCodigo(Long insCodigo) {
        this.insCodigo = insCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INS_FECHA_MODIFIC", nullable = false)
    public Date getInsFechaModific() {
        return insFechaModific;
    }

    public void setInsFechaModific(Date insFechaModific) {
        this.insFechaModific = insFechaModific;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INS_FECHA_REGISTRO", nullable = false)
    public Date getInsFechaRegistro() {
        return insFechaRegistro;
    }

    public void setInsFechaRegistro(Date insFechaRegistro) {
        this.insFechaRegistro = insFechaRegistro;
    }


    @Column(name = "TAP_CODIGO", nullable = false)
    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "TIN_CODIGO")
    public SiiTipoInstrumento getSiiTipoInstrumento() {
        return siiTipoInstrumento;
    }

    public void setSiiTipoInstrumento(SiiTipoInstrumento siiTipoInstrumento) {
        this.siiTipoInstrumento = siiTipoInstrumento;
    }

    @ManyToOne
    @JoinColumn(name = "MET_CODIGO")
    public SiiMet getSiiMet() {
        return siiMet;
    }

    public void setSiiMet(SiiMet siiMet) {
        this.siiMet = siiMet;
    }

    @OneToMany(mappedBy = "siiInstrumento")
    public List<SiiInventario> getSiiInventarioList1() {
        return siiInventarioList1;
    }

    public void setSiiInventarioList1(List<SiiInventario> siiInventarioList1) {
        this.siiInventarioList1 = siiInventarioList1;
    }

    public SiiInventario addSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList1().add(siiInventario);
        siiInventario.setSiiInstrumento(this);
        return siiInventario;
    }

    public SiiInventario removeSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList1().remove(siiInventario);
        siiInventario.setSiiInstrumento(null);
        return siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador1() {
        return siiOperador1;
    }

    public void setSiiOperador1(SiiOperador siiOperador1) {
        this.siiOperador1 = siiOperador1;
    }

    @ManyToOne
    @JoinColumn(name = "MCA_CODIGO")
    public SiiMesaCasino getSiiMesaCasino() {
        return siiMesaCasino;
    }

    public void setSiiMesaCasino(SiiMesaCasino siiMesaCasino) {
        this.siiMesaCasino = siiMesaCasino;
    }

    @ManyToOne
    @JoinColumn(name = "TAC_CODIGO")
    public SiiTerminalAcdv getSiiTerminalAcdv() {
        return siiTerminalAcdv;
    }

    public void setSiiTerminalAcdv(SiiTerminalAcdv siiTerminalAcdv) {
        this.siiTerminalAcdv = siiTerminalAcdv;
    }
}
