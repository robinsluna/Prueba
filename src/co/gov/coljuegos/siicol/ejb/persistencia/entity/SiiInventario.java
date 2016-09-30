package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_INVENTARIO")
public class SiiInventario implements Serializable {
    private static final long serialVersionUID = -2115698107696929846L;
    private Long invCodigo;
    private String invEstado;
    private Date invFechaFinLiq;
    private Date invFechaFinOfi;
    private Date invFechaIniLiq;
    private Date invFechaIniOfi;
    private Integer invSillas;
    private SiiTipoApuesta siiTipoApuesta;
    private SiiInstrumento siiInstrumento;
    private SiiNovedad siiNovedad;
    private SiiEstablecimiento siiEstablecimiento;
    private String invPg;
    private List<SiiVentasMet> siiVentasMetList;
    private List<SiiInventarioAutoComis> siiInventarioAutoComisList;
    private List<SiiInventarioProcSan> siiInventarioProcSanList;

    public SiiInventario() {
    }

    public SiiInventario(SiiEstablecimiento siiEstablecimiento, SiiInstrumento siiInstrumento, Long invCodigo,
                         String invEstado, Date invFechaFinLiq, Date invFechaFinOfi, Date invFechaIniLiq,
                         Date invFechaIniOfi, Integer invSillas, SiiNovedad siiNovedad, SiiTipoApuesta siiTipoApuesta) {
        this.siiEstablecimiento = siiEstablecimiento;
        this.siiInstrumento = siiInstrumento;
        this.invCodigo = invCodigo;
        this.invEstado = invEstado;
        this.invFechaFinLiq = invFechaFinLiq;
        this.invFechaFinOfi = invFechaFinOfi;
        this.invFechaIniLiq = invFechaIniLiq;
        this.invFechaIniOfi = invFechaIniOfi;
        this.invSillas = invSillas;
        this.siiNovedad = siiNovedad;
        this.siiTipoApuesta = siiTipoApuesta;
    }


    @Id
    @Column(name = "INV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVENTARIO_COD")
    @SequenceGenerator(name = "SEQ_INVENTARIO_COD", sequenceName = "SEQ_INVENTARIO_COD",allocationSize=1)
    public Long getInvCodigo() {
        return invCodigo;
    }

    public void setInvCodigo(Long invCodigo) {
        this.invCodigo = invCodigo;
    }

    @Column(name = "INV_ESTADO", nullable = false, length = 2)
    public String getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(String invEstado) {
        this.invEstado = invEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INV_FECHA_FIN_LIQ", nullable = false)
    public Date getInvFechaFinLiq() {
        return invFechaFinLiq;
    }

    public void setInvFechaFinLiq(Date invFechaFinLiq) {
        this.invFechaFinLiq = invFechaFinLiq;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INV_FECHA_FIN_OFI", nullable = false)
    public Date getInvFechaFinOfi() {
        return invFechaFinOfi;
    }

    public void setInvFechaFinOfi(Date invFechaFinOfi) {
        this.invFechaFinOfi = invFechaFinOfi;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INV_FECHA_INI_LIQ", nullable = false)
    public Date getInvFechaIniLiq() {
        return invFechaIniLiq;
    }

    public void setInvFechaIniLiq(Date invFechaIniLiq) {
        this.invFechaIniLiq = invFechaIniLiq;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INV_FECHA_INI_OFI", nullable = false)
    public Date getInvFechaIniOfi() {
        return invFechaIniOfi;
    }

    public void setInvFechaIniOfi(Date invFechaIniOfi) {
        this.invFechaIniOfi = invFechaIniOfi;
    }

    @Column(name = "INV_SILLAS")
    public Integer getInvSillas() {
        return invSillas;
    }

    public void setInvSillas(Integer invSillas) {
        this.invSillas = invSillas;
    }


    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @ManyToOne
    @JoinColumn(name = "INS_CODIGO")
    public SiiInstrumento getSiiInstrumento() {
        return siiInstrumento;
    }

    public void setSiiInstrumento(SiiInstrumento siiInstrumento) {
        this.siiInstrumento = siiInstrumento;
    }

    @ManyToOne
    @JoinColumn(name = "NOV_CODIGO")
    public SiiNovedad getSiiNovedad() {
        return siiNovedad;
    }

    public void setSiiNovedad(SiiNovedad siiNovedad) {
        this.siiNovedad = siiNovedad;
    }

    @ManyToOne
    @JoinColumn(name = "EST_CODIGO")
    public SiiEstablecimiento getSiiEstablecimiento() {
        return siiEstablecimiento;
    }

    public void setSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        this.siiEstablecimiento = siiEstablecimiento;
    }

    @Column(name = "INV_PG", length = 1)
    public String getInvPg() {
        return invPg;
    }

    public void setInvPg(String invPg) {
        this.invPg = invPg;
    }

    @OneToMany(mappedBy = "siiInventario")
    public List<SiiVentasMet> getSiiVentasMetList() {
        return siiVentasMetList;
    }

    public void setSiiVentasMetList(List<SiiVentasMet> siiVentasMetList) {
        this.siiVentasMetList = siiVentasMetList;
    }

    public SiiVentasMet addSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().add(siiVentasMet);
        siiVentasMet.setSiiInventario(this);
        return siiVentasMet;
    }

    public SiiVentasMet removeSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().remove(siiVentasMet);
        siiVentasMet.setSiiInventario(null);
        return siiVentasMet;
    }
    
    @OneToMany(mappedBy = "siiInventario")
    public List<SiiInventarioAutoComis> getSiiInventarioAutoComisList() {
        return siiInventarioAutoComisList;
    }

    public void setSiiInventarioAutoComisList(List<SiiInventarioAutoComis> siiInventarioAutoComisList) {
        this.siiInventarioAutoComisList = siiInventarioAutoComisList;
    }

    public SiiInventarioAutoComis addSiiInventarioAutoComis(SiiInventarioAutoComis siiInventarioAutoComis) {
        getSiiInventarioAutoComisList().add(siiInventarioAutoComis);
        siiInventarioAutoComis.setSiiInventario(this);
        return siiInventarioAutoComis;
    }

    public SiiInventarioAutoComis removeSiiInventarioAutoComis(SiiInventarioAutoComis siiInventarioAutoComis) {
        getSiiInventarioAutoComisList().remove(siiInventarioAutoComis);
        siiInventarioAutoComis.setSiiInventario(null);
        return siiInventarioAutoComis;
    }

    @OneToMany(mappedBy = "siiInventario")
    public List<SiiInventarioProcSan> getSiiInventarioProcSanList() {
        return siiInventarioProcSanList;
    }

    public void setSiiInventarioProcSanList(List<SiiInventarioProcSan> siiInventarioProcSanList) {
        this.siiInventarioProcSanList = siiInventarioProcSanList;
    }

    public SiiInventarioProcSan addSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().add(siiInventarioProcSan);
        siiInventarioProcSan.setSiiInventario(this);
        return siiInventarioProcSan;
    }

    public SiiInventarioProcSan removeSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().remove(siiInventarioProcSan);
        siiInventarioProcSan.setSiiInventario(null);
        return siiInventarioProcSan;
    }
}
