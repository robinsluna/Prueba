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
@Table(name = "SII_ITEM_PLAN_CONTRATAC")
public class SiiItemPlanContratac implements Serializable {
    private Long ipcCodigo;
    private String ipcDescripcion;
    private Date ipcFechaCreacion;
    private Date ipcFechaFinCon;
    private Date ipcFechaIniCon;
    private Date ipcFechaIniProc;
    private String ipcModContrat;
    private String ipcNombre;
    private String ipcTipologia;
    private Long ipcValorEst;
    private SiiAreaColjuegos siiAreaColjuegos;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList1;
    private List<SiiCdp> siiCdpList;
    private List<SiiItemPlanContDetRub> siiItemPlanContDetRubList1;
    private List<SiiEstudioPrevio> siiEstudioPrevioList;
    private SiiPlanContratacion siiPlanContratacion;
    private BigDecimal ipcValorNacion;
    private BigDecimal ipcValorPropios;
    private BigDecimal ipcValorVigFut;
    private SiiUsuario siiUsuarioConec;

    public SiiItemPlanContratac() {
    }

    public SiiItemPlanContratac(Long ipcCodigo, String ipcDescripcion, SiiAreaColjuegos siiAreaColjuegos,
								Date ipcFechaIniCon, Date ipcFechaIniProc, Long ipcValorEst, SiiPlanContratacion siiPlanContratacion) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.ipcCodigo = ipcCodigo;
        this.ipcDescripcion = ipcDescripcion;
        this.ipcFechaIniCon = ipcFechaIniCon;
        this.ipcFechaIniProc = ipcFechaIniProc;
        this.ipcValorEst = ipcValorEst;
        this.siiPlanContratacion = siiPlanContratacion;
    }

    @Id
    @Column(name = "IPC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_PLAN_CONTRATAC")
    @SequenceGenerator(name = "SEQ_ITEM_PLAN_CONTRATAC", sequenceName = "SEQ_ITEM_PLAN_CONTRATAC",allocationSize=1)
    public Long getIpcCodigo() {
        return ipcCodigo;
    }

    public void setIpcCodigo(Long ipcCodigo) {
        this.ipcCodigo = ipcCodigo;
    }

    @Column(name = "IPC_DESCRIPCION", nullable = false, length = 200)
    public String getIpcDescripcion() {
        return ipcDescripcion;
    }

    public void setIpcDescripcion(String ipcDescripcion) {
        this.ipcDescripcion = ipcDescripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPC_FECHA_FIN_CON")
    public Date getIpcFechaFinCon() {
        return ipcFechaFinCon;
    }

    public void setIpcFechaFinCon(Date ipcFechaFinCon) {
        this.ipcFechaFinCon = ipcFechaFinCon;
    }

    @OneToMany(mappedBy = "siiItemPlanContratac")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList1() {
        return siiSolicitudEstMercadoList1;
    }

    public void setSiiSolicitudEstMercadoList1(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList1) {
        this.siiSolicitudEstMercadoList1 = siiSolicitudEstMercadoList1;
    }

    @OneToMany(mappedBy = "siiItemPlanContratac")
    public List<SiiCdp> getSiiCdpList() {
        return siiCdpList;
    }

    public void setSiiCdpList(List<SiiCdp> siiCdpList) {
        this.siiCdpList = siiCdpList;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList().add(siiCdp);
        siiCdp.setSiiItemPlanContratac(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList().remove(siiCdp);
        siiCdp.setSiiItemPlanContratac(null);
        return siiCdp;
    }

    @Column(name = "IPC_MOD_CONTRAT", length = 30)
    public String getIpcModContrat() {
        return ipcModContrat;
    }

    public void setIpcModContrat(String ipcModContrat) {
        this.ipcModContrat = ipcModContrat;
    }

    @Column(name = "IPC_NOMBRE", length = 50)
    public String getIpcNombre() {
        return ipcNombre;
    }

    public void setIpcNombre(String ipcNombre) {
        this.ipcNombre = ipcNombre;
    }

    @Column(name = "IPC_TIPOLOGIA", length = 30)
    public String getIpcTipologia() {
        return ipcTipologia;
    }

    public void setIpcTipologia(String ipcTipologia) {
        this.ipcTipologia = ipcTipologia;
    }

    @Column(name = "IPC_VALOR_NACION")
    public BigDecimal getIpcValorNacion() {
        return ipcValorNacion;
    }

    public void setIpcValorNacion(BigDecimal ipcValorNacion) {
        this.ipcValorNacion = ipcValorNacion;
    }

    @Column(name = "IPC_VALOR_PROPIOS")
    public BigDecimal getIpcValorPropios() {
        return ipcValorPropios;
    }

    public void setIpcValorPropios(BigDecimal ipcValorPropios) {
        this.ipcValorPropios = ipcValorPropios;
    }

    @Column(name = "IPC_VALOR_VIG_FUT")
    public BigDecimal getIpcValorVigFut() {
        return ipcValorVigFut;
    }
    
    public void setIpcValorVigFut(BigDecimal ipcValorVigFut) {
        this.ipcValorVigFut = ipcValorVigFut;
    }

    @OneToMany(mappedBy = "siiItemPlanContratac")
    public List<SiiItemPlanContDetRub> getSiiItemPlanContDetRubList1() {
        return siiItemPlanContDetRubList1;
    }

    public void setSiiItemPlanContDetRubList1(List<SiiItemPlanContDetRub> siiItemPlanContDetRubList1) {
        this.siiItemPlanContDetRubList1 = siiItemPlanContDetRubList1;
    }

    public SiiItemPlanContDetRub addSiiItemPlanContDetRub(SiiItemPlanContDetRub siiItemPlanContDetRub) {
        getSiiItemPlanContDetRubList1().add(siiItemPlanContDetRub);
        siiItemPlanContDetRub.setSiiItemPlanContratac(this);
        return siiItemPlanContDetRub;
    }

    public SiiItemPlanContDetRub removeSiiItemPlanContDetRub(SiiItemPlanContDetRub siiItemPlanContDetRub) {
        getSiiItemPlanContDetRubList1().remove(siiItemPlanContDetRub);
        siiItemPlanContDetRub.setSiiItemPlanContratac(null);
        return siiItemPlanContDetRub;
    }

    @OneToMany(mappedBy = "siiItemPlanContratac")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList() {
        return siiEstudioPrevioList;
    }

    public void setSiiEstudioPrevioList(List<SiiEstudioPrevio> siiEstudioPrevioList) {
        this.siiEstudioPrevioList = siiEstudioPrevioList;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiItemPlanContratac(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiItemPlanContratac(null);
        return siiEstudioPrevio;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPC_FECHA_INI_CON", nullable = false)
    public Date getIpcFechaIniCon() {
        return ipcFechaIniCon;
    }

    public void setIpcFechaIniCon(Date ipcFechaIniCon) {
        this.ipcFechaIniCon = ipcFechaIniCon;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPC_FECHA_INI_PROC", nullable = false)
    public Date getIpcFechaIniProc() {
        return ipcFechaIniProc;
    }

    public void setIpcFechaIniProc(Date ipcFechaIniProc) {
        this.ipcFechaIniProc = ipcFechaIniProc;
    }

    @Column(name = "IPC_VALOR_EST", nullable = false)
    public Long getIpcValorEst() {
        return ipcValorEst;
    }

    public void setIpcValorEst(Long ipcValorEst) {
        this.ipcValorEst = ipcValorEst;
    }

    @ManyToOne
    @JoinColumn(name = "PCN_CODIGO")
    public SiiPlanContratacion getSiiPlanContratacion() {
        return siiPlanContratacion;
    }

    public void setSiiPlanContratacion(SiiPlanContratacion siiPlanContratacion) {
        this.siiPlanContratacion = siiPlanContratacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPC_FECHA_CREACION")
    public Date getIpcFechaCreacion() {
        return ipcFechaCreacion;
    }

    public void setIpcFechaCreacion(Date ipcFechaCreacion) {
        this.ipcFechaCreacion = ipcFechaCreacion;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
