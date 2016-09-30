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
@Table(name = "SII_GRUPO_FISCALIZACION")
public class SiiGrupoFiscalizacion implements Serializable {
    private static final long serialVersionUID = -7189098317488759920L;
    private Long gfiCodigo;
    private Date gfiFechaFin;
    private Date gfiFechaIni;
    private String gfiNumero;
    private SiiFiscalizadorSustanc siiFiscalizadorSustancPrincipal;
    private SiiFiscalizadorSustanc siiFiscalizadorSustancAcomp;
    private List<SiiAutoComisorio> siiAutoComisorioList;

    public SiiGrupoFiscalizacion() {
    }

    public SiiGrupoFiscalizacion(SiiFiscalizadorSustanc siiFiscalizadorSustancPrincipal, SiiFiscalizadorSustanc siiFiscalizadorSustancAcomp, Long gfiCodigo, Date gfiFechaFin, Date gfiFechaIni,
                                 String gfiNumero) {
        this.siiFiscalizadorSustancPrincipal = siiFiscalizadorSustancPrincipal;
        this.siiFiscalizadorSustancAcomp = siiFiscalizadorSustancAcomp;
        this.gfiCodigo = gfiCodigo;
        this.gfiFechaFin = gfiFechaFin;
        this.gfiFechaIni = gfiFechaIni;
        this.gfiNumero = gfiNumero;
    }


    @Id
    @Column(name = "GFI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GRUPO_FISCALIZAC_COD")
    @SequenceGenerator(name = "SEQ_GRUPO_FISCALIZAC_COD", sequenceName = "SEQ_GRUPO_FISCALIZAC_COD",allocationSize=1)
    public Long getGfiCodigo() {
        return gfiCodigo;
    }

    public void setGfiCodigo(Long gfiCodigo) {
        this.gfiCodigo = gfiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GFI_FECHA_FIN", nullable = false)
    public Date getGfiFechaFin() {
        return gfiFechaFin;
    }

    public void setGfiFechaFin(Date gfiFechaFin) {
        this.gfiFechaFin = gfiFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GFI_FECHA_INI", nullable = false)
    public Date getGfiFechaIni() {
        return gfiFechaIni;
    }

    public void setGfiFechaIni(Date gfiFechaIni) {
        this.gfiFechaIni = gfiFechaIni;
    }

    @Column(name = "GFI_NUMERO", nullable = false, length = 2)
    public String getGfiNumero() {
        return gfiNumero;
    }

    public void setGfiNumero(String gfiNumero) {
        this.gfiNumero = gfiNumero;
    }

    @ManyToOne
    @JoinColumn(name = "FSU_CODIGO_PRINCIP")
    public SiiFiscalizadorSustanc getSiiFiscalizadorSustancPrincipal() {
        return siiFiscalizadorSustancPrincipal;
    }

    public void setSiiFiscalizadorSustancPrincipal(SiiFiscalizadorSustanc siiFiscalizadorSustancPrincipal) {
        this.siiFiscalizadorSustancPrincipal = siiFiscalizadorSustancPrincipal;
    }

    @ManyToOne
    @JoinColumn(name = "FSU_CODIGO_ACOMP")
    public SiiFiscalizadorSustanc getSiiFiscalizadorSustancAcomp() {
        return siiFiscalizadorSustancAcomp;
    }

    public void setSiiFiscalizadorSustancAcomp(SiiFiscalizadorSustanc siiFiscalizadorSustancAcomp) {
        this.siiFiscalizadorSustancAcomp = siiFiscalizadorSustancAcomp;
    }

    @OneToMany(mappedBy = "siiGrupoFiscalizacion")
    public List<SiiAutoComisorio> getSiiAutoComisorioList() {
        return siiAutoComisorioList;
    }

    public void setSiiAutoComisorioList(List<SiiAutoComisorio> siiAutoComisorioList) {
        this.siiAutoComisorioList = siiAutoComisorioList;
    }

    public SiiAutoComisorio addSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().add(siiAutoComisorio);
        siiAutoComisorio.setSiiGrupoFiscalizacion(this);
        return siiAutoComisorio;
    }

    public SiiAutoComisorio removeSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().remove(siiAutoComisorio);
        siiAutoComisorio.setSiiGrupoFiscalizacion(null);
        return siiAutoComisorio;
    }
}
