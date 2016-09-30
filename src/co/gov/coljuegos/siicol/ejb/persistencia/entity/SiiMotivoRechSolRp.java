package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_RECH_SOL_RP")
public class SiiMotivoRechSolRp implements Serializable {
    private static final long serialVersionUID = -3529327256996689175L;
    private Long mrsCodigo;
    private String mrsNombre;
    private List<SiiRp> siiRpList1;

    public SiiMotivoRechSolRp() {
    }

    public SiiMotivoRechSolRp(Long mrsCodigo, String mrsNombre) {
        this.mrsCodigo = mrsCodigo;
        this.mrsNombre = mrsNombre;
    }

    @Id
    @Column(name = "MRS_CODIGO", nullable = false)
    public Long getMrsCodigo() {
        return mrsCodigo;
    }

    public void setMrsCodigo(Long mrsCodigo) {
        this.mrsCodigo = mrsCodigo;
    }

    @Column(name = "MRS_NOMBRE", nullable = false, length = 100)
    public String getMrsNombre() {
        return mrsNombre;
    }

    public void setMrsNombre(String mrsNombre) {
        this.mrsNombre = mrsNombre;
    }

    @OneToMany(mappedBy = "siiMotivoRechSolRp")
    public List<SiiRp> getSiiRpList1() {
        return siiRpList1;
    }

    public void setSiiRpList1(List<SiiRp> siiRpList1) {
        this.siiRpList1 = siiRpList1;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList1().add(siiRp);
        siiRp.setSiiMotivoRechSolRp(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList1().remove(siiRp);
        siiRp.setSiiMotivoRechSolRp(null);
        return siiRp;
    }
}
