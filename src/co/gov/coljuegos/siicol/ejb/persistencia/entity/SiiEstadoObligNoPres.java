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
@Table(name = "SII_ESTADO_OBLIG_NO_PRES")
public class SiiEstadoObligNoPres implements Serializable {
    private static final long serialVersionUID = -2735513890909813461L;
    private Long eonCodigo;
    private String eonNombre;
    private List<SiiObligacionNoPresup> siiObligacionNoPresupList;

    public SiiEstadoObligNoPres() {
    }

    public SiiEstadoObligNoPres(Long eonCodigo, String eonNombre) {
        this.eonCodigo = eonCodigo;
        this.eonNombre = eonNombre;
    }

    @Id
    @Column(name = "EON_CODIGO", nullable = false)
    public Long getEonCodigo() {
        return eonCodigo;
    }

    public void setEonCodigo(Long eonCodigo) {
        this.eonCodigo = eonCodigo;
    }

    @Column(name = "EON_NOMBRE", nullable = false, length = 20)
    public String getEonNombre() {
        return eonNombre;
    }

    public void setEonNombre(String eonNombre) {
        this.eonNombre = eonNombre;
    }

    @OneToMany(mappedBy = "siiEstadoObligNoPres")
    public List<SiiObligacionNoPresup> getSiiObligacionNoPresupList() {
        return siiObligacionNoPresupList;
    }

    public void setSiiObligacionNoPresupList(List<SiiObligacionNoPresup> siiObligacionNoPresupList) {
        this.siiObligacionNoPresupList = siiObligacionNoPresupList;
    }

    public SiiObligacionNoPresup addSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligacionNoPresupList().add(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiEstadoObligNoPres(this);
        return siiObligacionNoPresup;
    }

    public SiiObligacionNoPresup removeSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligacionNoPresupList().remove(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiEstadoObligNoPres(null);
        return siiObligacionNoPresup;
    }
}
