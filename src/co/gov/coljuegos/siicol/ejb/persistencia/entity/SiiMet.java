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
@Table(name = "SII_MET")
public class SiiMet implements Serializable {
    private static final long serialVersionUID = 4215880721420990847L;
    private Long metCodigo;
    private Date metFechaFab;
    private String metHomologado;
    private String metMarcaAnterior;
    private String metModelo;
    private String metNuid;
    private String metOnline;
    private String metSerial;
    private String metUid;
    private List<SiiInstrumento> siiInstrumentoList1;
    private SiiMarca siiMarca;
    private List<SiiVentasMet> siiVentasMetList;
    private String metReporteOpe;
    private Integer metFase;
    private Date metFechaMarcOnline;

    public SiiMet() {
    }

    public SiiMet(SiiMarca siiMarca, Long metCodigo, Date metFechaFab, String metHomologado, String metOnline,
                  String metSerial, String metUid, String metMarcaAnterior, String metModelo, String metNuid) {
        this.siiMarca = siiMarca;
        this.metCodigo = metCodigo;
        this.metFechaFab = metFechaFab;
        this.metHomologado = metHomologado;
        this.metMarcaAnterior = metMarcaAnterior;
        this.metModelo = metModelo;
        this.metNuid = metNuid;
        this.metOnline = metOnline;
        this.metSerial = metSerial;
        this.metUid = metUid;
    }


    @Id
    @Column(name = "MET_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MET_COD")
    @SequenceGenerator(name = "SEQ_MET_COD", sequenceName = "SEQ_MET_COD",allocationSize=1)
    public Long getMetCodigo() {
        return metCodigo;
    }

    public void setMetCodigo(Long metCodigo) {
        this.metCodigo = metCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MET_FECHA_FAB")
    public Date getMetFechaFab() {
        return metFechaFab;
    }

    public void setMetFechaFab(Date metFechaFab) {
        this.metFechaFab = metFechaFab;
    }

    @Column(name = "MET_HOMOLOGADO", length = 1)
    public String getMetHomologado() {
        return metHomologado;
    }

    public void setMetHomologado(String metHomologado) {
        this.metHomologado = metHomologado;
    }

    @Column(name = "MET_MARCA_ANTERIOR", length = 50)
    public String getMetMarcaAnterior() {
        return metMarcaAnterior;
    }

    public void setMetMarcaAnterior(String metMarcaAnterior) {
        this.metMarcaAnterior = metMarcaAnterior;
    }

    @Column(name = "MET_MODELO", length = 40)
    public String getMetModelo() {
        return metModelo;
    }

    public void setMetModelo(String metModelo) {
        this.metModelo = metModelo;
    }

    @Column(name = "MET_NUID", length = 20)
    public String getMetNuid() {
        return metNuid;
    }

    public void setMetNuid(String metNuid) {
        this.metNuid = metNuid;
    }

    @Column(name = "MET_ONLINE", nullable = false, length = 1)
    public String getMetOnline() {
        return metOnline;
    }

    public void setMetOnline(String metOnline) {
        this.metOnline = metOnline;
    }

    @Column(name = "MET_SERIAL", nullable = false, length = 60)
    public String getMetSerial() {
        return metSerial;
    }

    public void setMetSerial(String metSerial) {
        this.metSerial = metSerial;
    }

    @Column(name = "MET_UID", length = 60)
    public String getMetUid() {
        return metUid;
    }

    public void setMetUid(String metUid) {
        this.metUid = metUid;
    }


    @OneToMany(mappedBy = "siiMet")
    public List<SiiInstrumento> getSiiInstrumentoList1() {
        return siiInstrumentoList1;
    }

    public void setSiiInstrumentoList1(List<SiiInstrumento> siiInstrumentoList1) {
        this.siiInstrumentoList1 = siiInstrumentoList1;
    }

    public SiiInstrumento addSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList1().add(siiInstrumento);
        siiInstrumento.setSiiMet(this);
        return siiInstrumento;
    }

    public SiiInstrumento removeSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList1().remove(siiInstrumento);
        siiInstrumento.setSiiMet(null);
        return siiInstrumento;
    }

    @ManyToOne
    @JoinColumn(name = "MAR_CODIGO")
    public SiiMarca getSiiMarca() {
        return siiMarca;
    }

    public void setSiiMarca(SiiMarca siiMarca) {
        this.siiMarca = siiMarca;
    }

    @OneToMany(mappedBy = "siiMet")
    public List<SiiVentasMet> getSiiVentasMetList() {
        return siiVentasMetList;
    }

    public void setSiiVentasMetList(List<SiiVentasMet> siiVentasMetList) {
        this.siiVentasMetList = siiVentasMetList;
    }

    public SiiVentasMet addSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().add(siiVentasMet);
        siiVentasMet.setSiiMet(this);
        return siiVentasMet;
    }

    public SiiVentasMet removeSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().remove(siiVentasMet);
        siiVentasMet.setSiiMet(null);
        return siiVentasMet;
    }

    @Column(name = "MET_FASE")
    public Integer getMetFase() {
        return metFase;
    }

    public void setMetFase(Integer metFase) {
        this.metFase = metFase;
    }

    @Column(name = "MET_REPORTE_OPE", length = 1)
    public String getMetReporteOpe() {
        return metReporteOpe;
    }

    public void setMetReporteOpe(String metReporteOpe) {
        this.metReporteOpe = metReporteOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MET_FECHA_MARC_ONLINE")
    public Date getMetFechaMarcOnline() {
        return metFechaMarcOnline;
    }
    
    public void setMetFechaMarcOnline(Date metFechaMarcOnline) {
        this.metFechaMarcOnline = metFechaMarcOnline;
    }
    
}
