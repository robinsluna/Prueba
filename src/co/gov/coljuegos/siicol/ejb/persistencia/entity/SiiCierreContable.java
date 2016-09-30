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
@Table(name = "SII_CIERRE_CONTABLE")
public class SiiCierreContable implements Serializable {
    private static final long serialVersionUID = -8728694569340518546L;
    private Long cicCodigo;
    private Date cicFechaCCont;
    private Integer cicVigencia;
    private SiiMes siiMes;
    private List<SiiDetalleCierreCont> siiDetalleCierreContList;

    public SiiCierreContable() {
    }

    public SiiCierreContable(Long cicCodigo, Date cicFechaCCont, Integer cicVigencia, SiiMes siiMes) {
        this.cicCodigo = cicCodigo;
        this.cicFechaCCont = cicFechaCCont;
        this.cicVigencia = cicVigencia;
        this.siiMes = siiMes;
    }

    @Id
    @Column(name = "CIC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CIERRE_CONTABLE_COD")
    @SequenceGenerator(name = "SEQ_CIERRE_CONTABLE_COD", sequenceName = "SEQ_CIERRE_CONTABLE_COD",allocationSize=1)
    public Long getCicCodigo() {
        return cicCodigo;
    }

    public void setCicCodigo(Long cicCodigo) {
        this.cicCodigo = cicCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CIC_FECHA_C_CONT")
    public Date getCicFechaCCont() {
        return cicFechaCCont;
    }

    public void setCicFechaCCont(Date cicFechaCCont) {
        this.cicFechaCCont = cicFechaCCont;
    }

    @Column(name = "CIC_VIGENCIA", nullable = false)
    public Integer getCicVigencia() {
        return cicVigencia;
    }

    public void setCicVigencia(Integer cicVigencia) {
        this.cicVigencia = cicVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiCierreContable")
    public List<SiiDetalleCierreCont> getSiiDetalleCierreContList() {
        return siiDetalleCierreContList;
    }

    public void setSiiDetalleCierreContList(List<SiiDetalleCierreCont> siiDetalleCierreContList) {
        this.siiDetalleCierreContList = siiDetalleCierreContList;
    }

    public SiiDetalleCierreCont addSiiDetalleCierreCont(SiiDetalleCierreCont siiDetalleCierreCont) {
        getSiiDetalleCierreContList().add(siiDetalleCierreCont);
        siiDetalleCierreCont.setSiiCierreContable(this);
        return siiDetalleCierreCont;
    }

    public SiiDetalleCierreCont removeSiiDetalleCierreCont(SiiDetalleCierreCont siiDetalleCierreCont) {
        getSiiDetalleCierreContList().remove(siiDetalleCierreCont);
        siiDetalleCierreCont.setSiiCierreContable(null);
        return siiDetalleCierreCont;
    }
}
