package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_DOCUM_SOPOR_MODIF")
public class SiiDocumSoporModif implements Serializable {
    private static final long serialVersionUID = -8255965605608867147L;
    private String dsmActivo;
    private Long dsmCodigo;
    private Date dsmFecha;
    private String dsmNumDoc;
    private SiiModificacionPlanCont siiModificacionPlanCont;
    private SiiTipoDocSoporteModif siiTipoDocSoporteModif;

    public SiiDocumSoporModif() {
    }

    public SiiDocumSoporModif(String dsmActivo, Long dsmCodigo, Date dsmFecha, String dsmNumDoc,
                              SiiModificacionPlanCont siiModificacionPlanCont,
                              SiiTipoDocSoporteModif siiTipoDocSoporteModif) {
        this.dsmActivo = dsmActivo;
        this.dsmCodigo = dsmCodigo;
        this.dsmFecha = dsmFecha;
        this.dsmNumDoc = dsmNumDoc;
        this.siiModificacionPlanCont = siiModificacionPlanCont;
        this.siiTipoDocSoporteModif = siiTipoDocSoporteModif;
    }

    @Column(name = "DSM_ACTIVO", nullable = false, length = 1)
    public String getDsmActivo() {
        return dsmActivo;
    }

    public void setDsmActivo(String dsmActivo) {
        this.dsmActivo = dsmActivo;
    }

    @Id
    @Column(name = "DSM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DOCUM_SOPOR_MODIF_COD")
    @SequenceGenerator(name = "SEQ_DOCUM_SOPOR_MODIF_COD", sequenceName = "SEQ_DOCUM_SOPOR_MODIF_COD",allocationSize=1)
    public Long getDsmCodigo() {
        return dsmCodigo;
    }

    public void setDsmCodigo(Long dsmCodigo) {
        this.dsmCodigo = dsmCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DSM_FECHA", nullable = false)
    public Date getDsmFecha() {
        return dsmFecha;
    }

    public void setDsmFecha(Date dsmFecha) {
        this.dsmFecha = dsmFecha;
    }

    @Column(name = "DSM_NUM_DOC", nullable = false, length = 20)
    public String getDsmNumDoc() {
        return dsmNumDoc;
    }

    public void setDsmNumDoc(String dsmNumDoc) {
        this.dsmNumDoc = dsmNumDoc;
    }


    @ManyToOne
    @JoinColumn(name = "MPC_CODIGO")
    public SiiModificacionPlanCont getSiiModificacionPlanCont() {
        return siiModificacionPlanCont;
    }

    public void setSiiModificacionPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) {
        this.siiModificacionPlanCont = siiModificacionPlanCont;
    }

    @ManyToOne
    @JoinColumn(name = "TDM_CODIGO")
    public SiiTipoDocSoporteModif getSiiTipoDocSoporteModif() {
        return siiTipoDocSoporteModif;
    }

    public void setSiiTipoDocSoporteModif(SiiTipoDocSoporteModif siiTipoDocSoporteModif) {
        this.siiTipoDocSoporteModif = siiTipoDocSoporteModif;
    }
}
