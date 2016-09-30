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
@Table(name = "SII_MODIFICACION_CDP")
public class SiiModificacionCdp implements Serializable {
    private static final long serialVersionUID = 6740717832479833598L;
    private Long mcdCodigo;
    private Date mcdFechaSolic;
    private Long mcdNumero;
    private String mcdTipoMod;
    private SiiEstadoModifCdp siiEstadoModifCdp;
    private List<SiiModifCdpDetRubCdp> siiModifCdpDetRubCdpList;
    private SiiCdp siiCdp;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiModificacionCdp() {
    }

    public SiiModificacionCdp(SiiCdp siiCdp, SiiEstadoModifCdp siiEstadoModifCdp, Long mcdCodigo, String mcdTipoMod,
						Date mcdFechaSolic, SiiArchivoFisico siiArchivoFisico) {
        this.siiEstadoModifCdp = siiEstadoModifCdp;
        this.mcdCodigo = mcdCodigo;
        this.mcdFechaSolic = mcdFechaSolic;
        this.mcdTipoMod = mcdTipoMod;
        this.siiCdp = siiCdp;
        this.siiArchivoFisico = siiArchivoFisico;
    }


    @Id
    @Column(name = "MCD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIFICACION_CDP_COD")
    @SequenceGenerator(name = "SEQ_MODIFICACION_CDP_COD", sequenceName = "SEQ_MODIFICACION_CDP_COD",allocationSize=1)
    public Long getMcdCodigo() {
        return mcdCodigo;
    }

    public void setMcdCodigo(Long mcdCodigo) {
        this.mcdCodigo = mcdCodigo;
    }

    @Column(name = "MCD_TIPO_MOD", nullable = false, length = 1)
    public String getMcdTipoMod() {
        return mcdTipoMod;
    }

    public void setMcdTipoMod(String mcdTipoMod) {
        this.mcdTipoMod = mcdTipoMod;
    }

    @ManyToOne
    @JoinColumn(name = "EMC_CODIGO")
    public SiiEstadoModifCdp getSiiEstadoModifCdp() {
        return siiEstadoModifCdp;
    }

    public void setSiiEstadoModifCdp(SiiEstadoModifCdp siiEstadoModifCdp) {
        this.siiEstadoModifCdp = siiEstadoModifCdp;
    }

    @OneToMany(mappedBy = "siiModificacionCdp")
    public List<SiiModifCdpDetRubCdp> getSiiModifCdpDetRubCdpList() {
        return siiModifCdpDetRubCdpList;
    }

    public void setSiiModifCdpDetRubCdpList(List<SiiModifCdpDetRubCdp> siiModifCdpDetRubCdpList) {
        this.siiModifCdpDetRubCdpList = siiModifCdpDetRubCdpList;
    }

    public SiiModifCdpDetRubCdp addSiiModifCdpDetRubCdp(SiiModifCdpDetRubCdp siiModifCdpDetRubCdp) {
        getSiiModifCdpDetRubCdpList().add(siiModifCdpDetRubCdp);
        siiModifCdpDetRubCdp.setSiiModificacionCdp(this);
        return siiModifCdpDetRubCdp;
    }

    public SiiModifCdpDetRubCdp removeSiiModifCdpDetRubCdp(SiiModifCdpDetRubCdp siiModifCdpDetRubCdp) {
        getSiiModifCdpDetRubCdpList().remove(siiModifCdpDetRubCdp);
        siiModifCdpDetRubCdp.setSiiModificacionCdp(null);
        return siiModifCdpDetRubCdp;
    }

    @ManyToOne
    @JoinColumn(name = "CDP_CODIGO")
    public SiiCdp getSiiCdp() {
        return siiCdp;
    }

    public void setSiiCdp(SiiCdp siiCdp) {
        this.siiCdp = siiCdp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MCD_FECHA_SOLIC", nullable = false)
    public Date getMcdFechaSolic() {
        return mcdFechaSolic;
    }

    public void setMcdFechaSolic(Date mcdFechaSolic) {
        this.mcdFechaSolic = mcdFechaSolic;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Column(name = "MCD_NUMERO")
    public Long getMcdNumero() {
        return mcdNumero;
    }

    public void setMcdNumero(Long mcdNumero) {
        this.mcdNumero = mcdNumero;
    }
}
