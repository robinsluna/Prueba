package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_CARGA_RP")
public class SiiCargaRp implements Serializable {
    private static final long serialVersionUID = -2811857629248890497L;
    private Long crpCodigo;
    private String crpNombreArch;
    private List<SiiRp> siiRpList;
    private SiiArchivoFisico siiArchivoFisico;
    private String crpDescripcion;

    public SiiCargaRp() {
    }

    public SiiCargaRp(Long crpCodigo, String crpNombreArch) {
        this.crpCodigo = crpCodigo;
        this.crpNombreArch = crpNombreArch;
    }


    @Id
    @Column(name = "CRP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CARGA_RP_COD")
    @SequenceGenerator(name = "SEQ_CARGA_RP_COD", sequenceName = "SEQ_CARGA_RP_COD",allocationSize=1)
    public Long getCrpCodigo() {
        return crpCodigo;
    }

    public void setCrpCodigo(Long crpCodigo) {
        this.crpCodigo = crpCodigo;
    }

    @Column(name = "CRP_NOMBRE_ARCH", nullable = false, length = 20)
    public String getCrpNombreArch() {
        return crpNombreArch;
    }

    public void setCrpNombreArch(String crpNombreArch) {
        this.crpNombreArch = crpNombreArch;
    }

    @OneToMany(mappedBy = "siiCargaRp")
    public List<SiiRp> getSiiRpList() {
        return siiRpList;
    }

    public void setSiiRpList(List<SiiRp> siiRpList) {
        this.siiRpList = siiRpList;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList().add(siiRp);
        siiRp.setSiiCargaRp(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList().remove(siiRp);
        siiRp.setSiiCargaRp(null);
        return siiRp;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Column(name = "CRP_DESCRIPCION", nullable = false, length = 500)
    public String getCrpDescripcion() {
        return crpDescripcion;
    }

    public void setCrpDescripcion(String crpDescripcion) {
        this.crpDescripcion = crpDescripcion;
    }
}
