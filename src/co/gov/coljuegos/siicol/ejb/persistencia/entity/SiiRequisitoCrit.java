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
@Table(name = "SII_REQUISITO_CRIT")
public class SiiRequisitoCrit implements Serializable {
    private static final long serialVersionUID = 4934073844236436906L;
    private String rcrActivo;
    private Long rcrCodigo;
    private String rcrNombre;
    private String rcrTipo;
    private List<SiiReqEstudioPrevio> siiReqEstudioPrevioList1;
    private List<SiiReqAlcanceInv> siiReqAlcanceInvList1;

    public SiiRequisitoCrit() {
    }

    public SiiRequisitoCrit(String rcrActivo, Long rcrCodigo, String rcrNombre, String rcrTipo) {
        this.rcrActivo = rcrActivo;
        this.rcrCodigo = rcrCodigo;
        this.rcrNombre = rcrNombre;
        this.rcrTipo = rcrTipo;
    }

    @Column(name = "RCR_ACTIVO", nullable = false, length = 1)
    public String getRcrActivo() {
        return rcrActivo;
    }

    public void setRcrActivo(String rcrActivo) {
        this.rcrActivo = rcrActivo;
    }

    @Id
    @Column(name = "RCR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REQUISITO_COD")
    @SequenceGenerator(name = "SEQ_REQUISITO_COD", sequenceName = "SEQ_REQUISITO_COD",allocationSize=1)
    public Long getRcrCodigo() {
        return rcrCodigo;
    }

    public void setRcrCodigo(Long rcrCodigo) {
        this.rcrCodigo = rcrCodigo;
    }

    @Column(name = "RCR_NOMBRE", nullable = false, length = 100)
    public String getRcrNombre() {
        return rcrNombre;
    }

    public void setRcrNombre(String rcrNombre) {
        this.rcrNombre = rcrNombre;
    }

    @Column(name = "RCR_TIPO", nullable = false, length = 2)
    public String getRcrTipo() {
        return rcrTipo;
    }

    public void setRcrTipo(String rcrTipo) {
        this.rcrTipo = rcrTipo;
    }

    @OneToMany(mappedBy = "siiRequisitoCrit")
    public List<SiiReqEstudioPrevio> getSiiReqEstudioPrevioList1() {
        return siiReqEstudioPrevioList1;
    }

    public void setSiiReqEstudioPrevioList1(List<SiiReqEstudioPrevio> siiReqEstudioPrevioList1) {
        this.siiReqEstudioPrevioList1 = siiReqEstudioPrevioList1;
    }

    public SiiReqEstudioPrevio addSiiReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) {
        getSiiReqEstudioPrevioList1().add(siiReqEstudioPrevio);
        siiReqEstudioPrevio.setSiiRequisitoCrit(this);
        return siiReqEstudioPrevio;
    }

    public SiiReqEstudioPrevio removeSiiReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) {
        getSiiReqEstudioPrevioList1().remove(siiReqEstudioPrevio);
        siiReqEstudioPrevio.setSiiRequisitoCrit(null);
        return siiReqEstudioPrevio;
    }

    @OneToMany(mappedBy = "siiRequisitoCrit")
    public List<SiiReqAlcanceInv> getSiiReqAlcanceInvList1() {
        return siiReqAlcanceInvList1;
    }

    public void setSiiReqAlcanceInvList1(List<SiiReqAlcanceInv> siiReqAlcanceInvList1) {
        this.siiReqAlcanceInvList1 = siiReqAlcanceInvList1;
    }

    public SiiReqAlcanceInv addSiiReqAlcanceInv(SiiReqAlcanceInv siiReqAlcanceInv) {
        getSiiReqAlcanceInvList1().add(siiReqAlcanceInv);
        siiReqAlcanceInv.setSiiRequisitoCrit(this);
        return siiReqAlcanceInv;
    }

    public SiiReqAlcanceInv removeSiiReqAlcanceInv(SiiReqAlcanceInv siiReqAlcanceInv) {
        getSiiReqAlcanceInvList1().remove(siiReqAlcanceInv);
        siiReqAlcanceInv.setSiiRequisitoCrit(null);
        return siiReqAlcanceInv;
    }
}
