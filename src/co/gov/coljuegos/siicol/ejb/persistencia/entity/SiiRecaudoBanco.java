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
@Table(name = "SII_RECAUDO_BANCO")
public class SiiRecaudoBanco implements Serializable {
    private static final long serialVersionUID = -4028822821505884076L;
    private Long rbaCodigo;
    private Date rbaFechaArchivo;
    private Date rbaFechaRec;
    private String rbaNumCuenta;
    private String rbaOrdenDia;
    private SiiTipoCuenta siiTipoCuenta;
    private SiiBanco siiBanco;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiRecaudoBanco() {
    }

    public SiiRecaudoBanco(SiiBanco siiBanco, Long rbaCodigo, Date rbaFechaArchivo, Date rbaFechaRec,
                           String rbaNumCuenta, String rbaOrdenDia, SiiTipoCuenta siiTipoCuenta, SiiArchivoFisico siiArchivoFisico) {
        this.siiBanco = siiBanco;
        this.rbaCodigo = rbaCodigo;
        this.rbaFechaArchivo = rbaFechaArchivo;
        this.rbaFechaRec = rbaFechaRec;
        this.rbaNumCuenta = rbaNumCuenta;
        this.rbaOrdenDia = rbaOrdenDia;
        this.siiTipoCuenta = siiTipoCuenta;
        this.siiArchivoFisico = siiArchivoFisico;
    }


    @Id
    @Column(name = "RBA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RECAUDO_BANCO_COD")
    @SequenceGenerator(name = "SEQ_RECAUDO_BANCO_COD", sequenceName = "SEQ_RECAUDO_BANCO_COD",allocationSize=1)
    public Long getRbaCodigo() {
        return rbaCodigo;
    }

    public void setRbaCodigo(Long rbaCodigo) {
        this.rbaCodigo = rbaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RBA_FECHA_ARCHIVO", nullable = false)
    public Date getRbaFechaArchivo() {
        return rbaFechaArchivo;
    }

    public void setRbaFechaArchivo(Date rbaFechaArchivo) {
        this.rbaFechaArchivo = rbaFechaArchivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RBA_FECHA_REC", nullable = false)
    public Date getRbaFechaRec() {
        return rbaFechaRec;
    }

    public void setRbaFechaRec(Date rbaFechaRec) {
        this.rbaFechaRec = rbaFechaRec;
    }

    @Column(name = "RBA_NUM_CUENTA", nullable = false, length = 20)
    public String getRbaNumCuenta() {
        return rbaNumCuenta;
    }

    public void setRbaNumCuenta(String rbaNumCuenta) {
        this.rbaNumCuenta = rbaNumCuenta;
    }

    @Column(name = "RBA_ORDEN_DIA", nullable = false, length = 1)
    public String getRbaOrdenDia() {
        return rbaOrdenDia;
    }

    public void setRbaOrdenDia(String rbaOrdenDia) {
        this.rbaOrdenDia = rbaOrdenDia;
    }


    @ManyToOne
    @JoinColumn(name = "TCU_CODIGO")
    public SiiTipoCuenta getSiiTipoCuenta() {
        return siiTipoCuenta;
    }

    public void setSiiTipoCuenta(SiiTipoCuenta siiTipoCuenta) {
        this.siiTipoCuenta = siiTipoCuenta;
    }

    @ManyToOne
    @JoinColumn(name = "BAN_CODIGO")
    public SiiBanco getSiiBanco() {
        return siiBanco;
    }

    public void setSiiBanco(SiiBanco siiBanco) {
        this.siiBanco = siiBanco;
    }

    @OneToMany(mappedBy = "siiRecaudoBanco")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoBanco(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoBanco(null);
        return siiDetalleRecaudo;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
}
