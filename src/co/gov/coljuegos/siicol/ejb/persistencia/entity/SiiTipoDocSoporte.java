package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_DOC_SOPORTE")
public class SiiTipoDocSoporte implements Serializable {
    private static final long serialVersionUID = -8906016547862210479L;
    private Long tdsCodigo;
    private String tdsNombre;
    private List<SiiObligacionPago> siiObligacionPagoList;
    private List<SiiCdp> siiCdpList4;

    public SiiTipoDocSoporte() {
    }

    public SiiTipoDocSoporte(Long tdsCodigo, String tdsNombre) {
        this.tdsCodigo = tdsCodigo;
        this.tdsNombre = tdsNombre;
    }

    @Id
    @Column(name = "TDS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_DOC_SOPOR")
    @SequenceGenerator(name = "SEQ_TIPO_DOC_SOPOR", sequenceName = "SEQ_TIPO_DOC_SOPOR",allocationSize=1)
    public Long getTdsCodigo() {
        return tdsCodigo;
    }

    public void setTdsCodigo(Long tdsCodigo) {
        this.tdsCodigo = tdsCodigo;
    }

    @Column(name = "TDS_NOMBRE", nullable = false, length = 30)
    public String getTdsNombre() {
        return tdsNombre;
    }

    public void setTdsNombre(String tdsNombre) {
        this.tdsNombre = tdsNombre;
    }

    @OneToMany(mappedBy = "siiTipoDocSoporte")
    public List<SiiObligacionPago> getSiiObligacionPagoList() {
        return siiObligacionPagoList;
    }

    public void setSiiObligacionPagoList(List<SiiObligacionPago> siiObligacionPagoList) {
        this.siiObligacionPagoList = siiObligacionPagoList;
    }

    public SiiObligacionPago addSiiObligacionPago(SiiObligacionPago siiObligacionPago) {
        getSiiObligacionPagoList().add(siiObligacionPago);
        siiObligacionPago.setSiiTipoDocSoporte(this);
        return siiObligacionPago;
    }

    public SiiObligacionPago removeSiiObligacionPago(SiiObligacionPago siiObligacionPago) {
        getSiiObligacionPagoList().remove(siiObligacionPago);
        siiObligacionPago.setSiiTipoDocSoporte(null);
        return siiObligacionPago;
    }

    @OneToMany(mappedBy = "siiTipoDocSoporte")
    public List<SiiCdp> getSiiCdpList4() {
        return siiCdpList4;
    }

    public void setSiiCdpList4(List<SiiCdp> siiCdpList4) {
        this.siiCdpList4 = siiCdpList4;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList4().add(siiCdp);
        siiCdp.setSiiTipoDocSoporte(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList4().remove(siiCdp);
        siiCdp.setSiiTipoDocSoporte(null);
        return siiCdp;
    }
}
