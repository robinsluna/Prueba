package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_DENUNCIA_ORDEN_TRAB")
public class SiiDenunciaOrdenTrab implements Serializable {
    private static final long serialVersionUID = 369489620494964019L;
    private String dotActivo;
    private Long dotCodigo;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private SiiDenuncia siiDenuncia;
    private List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList;

    public SiiDenunciaOrdenTrab() {
    }

    public SiiDenunciaOrdenTrab(SiiDenuncia siiDenuncia, String dotActivo, Long dotCodigo, SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiDenuncia = siiDenuncia;
        this.dotActivo = dotActivo;
        this.dotCodigo = dotCodigo;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }


    @Column(name = "DOT_ACTIVO", nullable = false, length = 1)
    public String getDotActivo() {
        return dotActivo;
    }

    public void setDotActivo(String dotActivo) {
        this.dotActivo = dotActivo;
    }

    @Id
    @Column(name = "DOT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DENUNC_ORD_TRAB_COD")
    @SequenceGenerator(name = "SEQ_DENUNC_ORD_TRAB_COD", sequenceName = "SEQ_DENUNC_ORD_TRAB_COD",allocationSize=1)
    public Long getDotCodigo() {
        return dotCodigo;
    }

    public void setDotCodigo(Long dotCodigo) {
        this.dotCodigo = dotCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "OTV_CODIGO")
    public SiiOrdenTrabajoVisita getSiiOrdenTrabajoVisita() {
        return siiOrdenTrabajoVisita;
    }

    public void setSiiOrdenTrabajoVisita(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @ManyToOne
    @JoinColumn(name = "DEN_CODIGO")
    public SiiDenuncia getSiiDenuncia() {
        return siiDenuncia;
    }

    public void setSiiDenuncia(SiiDenuncia siiDenuncia) {
        this.siiDenuncia = siiDenuncia;
    }

    @OneToMany(mappedBy = "siiDenunciaOrdenTrab")
    public List<SiiDenuncOrdTraInfVer> getSiiDenuncOrdTraInfVerList() {
        return siiDenuncOrdTraInfVerList;
    }

    public void setSiiDenuncOrdTraInfVerList(List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList) {
        this.siiDenuncOrdTraInfVerList = siiDenuncOrdTraInfVerList;
    }

    public SiiDenuncOrdTraInfVer addSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().add(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiDenunciaOrdenTrab(this);
        return siiDenuncOrdTraInfVer;
    }

    public SiiDenuncOrdTraInfVer removeSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().remove(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiDenunciaOrdenTrab(null);
        return siiDenuncOrdTraInfVer;
    }
}
