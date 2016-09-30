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
@Table(name = "SII_MODIFICACION_RP")
public class SiiModificacionRp implements Serializable {
    private static final long serialVersionUID = 7658774119244217126L;
    private Long mrpCodigo;
    private Date mrpFecha;
    private String mrpTipoModif;
    private List<SiiModifRpDetRubCdp> siiModifRpDetRubCdpList;
    private SiiRp siiRp1;
    private SiiEstadoModificRp siiEstadoModificRp;
    private Long mrpConsecutivo;
    private String mrpMotivoAnula;

    public SiiModificacionRp() {
    }

    public SiiModificacionRp(SiiEstadoModificRp siiEstadoModificRp, Long mrpCodigo, String mrpTipoModif,
                            Date mrpFecha, SiiRp siiRp1) {
        this.mrpCodigo = mrpCodigo;
        this.mrpFecha = mrpFecha;
        this.mrpTipoModif = mrpTipoModif;
        this.siiRp1 = siiRp1;
        this.siiEstadoModificRp = siiEstadoModificRp;
    }

    @Id
    @Column(name = "MRP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIFICACION_RP_COD")
    @SequenceGenerator(name = "SEQ_MODIFICACION_RP_COD", sequenceName = "SEQ_MODIFICACION_RP_COD",allocationSize=1)
    public Long getMrpCodigo() {
        return mrpCodigo;
    }

    public void setMrpCodigo(Long mrpCodigo) {
        this.mrpCodigo = mrpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MRP_FECHA", nullable = false)
    public Date getMrpFecha() {
        return mrpFecha;
    }

    public void setMrpFecha(Date mrpFecha) {
        this.mrpFecha = mrpFecha;
    }

    @Column(name = "MRP_TIPO_MODIF", nullable = false, length = 1)
    public String getMrpTipoModif() {
        return mrpTipoModif;
    }

    public void setMrpTipoModif(String mrpTipoModif) {
        this.mrpTipoModif = mrpTipoModif;
    }


    @OneToMany(mappedBy = "siiModificacionRp")
    public List<SiiModifRpDetRubCdp> getSiiModifRpDetRubCdpList() {
        return siiModifRpDetRubCdpList;
    }

    public void setSiiModifRpDetRubCdpList(List<SiiModifRpDetRubCdp> siiModifRpDetRubCdpList) {
        this.siiModifRpDetRubCdpList = siiModifRpDetRubCdpList;
    }

    public SiiModifRpDetRubCdp addSiiModifRpDetRubCdp(SiiModifRpDetRubCdp siiModifRpDetRubCdp) {
        getSiiModifRpDetRubCdpList().add(siiModifRpDetRubCdp);
        siiModifRpDetRubCdp.setSiiModificacionRp(this);
        return siiModifRpDetRubCdp;
    }

    public SiiModifRpDetRubCdp removeSiiModifRpDetRubCdp(SiiModifRpDetRubCdp siiModifRpDetRubCdp) {
        getSiiModifRpDetRubCdpList().remove(siiModifRpDetRubCdp);
        siiModifRpDetRubCdp.setSiiModificacionRp(null);
        return siiModifRpDetRubCdp;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp1() {
        return siiRp1;
    }

    public void setSiiRp1(SiiRp siiRp1) {
        this.siiRp1 = siiRp1;
    }

    @ManyToOne
    @JoinColumn(name = "EMR_CODIGO")
    public SiiEstadoModificRp getSiiEstadoModificRp() {
        return siiEstadoModificRp;
    }

    public void setSiiEstadoModificRp(SiiEstadoModificRp siiEstadoModificRp) {
        this.siiEstadoModificRp = siiEstadoModificRp;
    }

    @Column(name = "MRP_CONSECUTIVO")
    public Long getMrpConsecutivo() {
        return mrpConsecutivo;
    }

    public void setMrpConsecutivo(Long mrpConsecutivo) {
        this.mrpConsecutivo = mrpConsecutivo;
    }
        
    @Column(name = "MRP_MOTIVO_ANULA", nullable = false, length = 200)
    public String getMrpMotivoAnula() {
        return mrpMotivoAnula;
    }

    public void setMrpMotivoAnula(String mrpMotivoAnula) {
        this.mrpMotivoAnula = mrpMotivoAnula;
    }
}
