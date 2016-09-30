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
@Table(name = "SII_ESTADO_OTROSI")
public class SiiEstadoOtrosi implements Serializable {
    private static final long serialVersionUID = 8352433825652080083L;
    private Long eosCodigo;
    private String eosNombre;
    private List<SiiOtrosi> siiOtrosiList;

    public SiiEstadoOtrosi() {
    }

    public SiiEstadoOtrosi(Long eosCodigo, String eosNombre) {
        this.eosCodigo = eosCodigo;
        this.eosNombre = eosNombre;
    }

    @Id
    @Column(name = "EOS_CODIGO", nullable = false)
    public Long getEosCodigo() {
        return eosCodigo;
    }

    public void setEosCodigo(Long eosCodigo) {
        this.eosCodigo = eosCodigo;
    }

    @Column(name = "EOS_NOMBRE", nullable = false, length = 30)
    public String getEosNombre() {
        return eosNombre;
    }

    public void setEosNombre(String eosNombre) {
        this.eosNombre = eosNombre;
    }

    @OneToMany(mappedBy = "siiEstadoOtrosi")
    public List<SiiOtrosi> getSiiOtrosiList() {
        return siiOtrosiList;
    }

    public void setSiiOtrosiList(List<SiiOtrosi> siiOtrosiList) {
        this.siiOtrosiList = siiOtrosiList;
    }

    public SiiOtrosi addSiiOtrosi(SiiOtrosi siiOtrosi) {
        getSiiOtrosiList().add(siiOtrosi);
        siiOtrosi.setSiiEstadoOtrosi(this);
        return siiOtrosi;
    }

    public SiiOtrosi removeSiiOtrosi(SiiOtrosi siiOtrosi) {
        getSiiOtrosiList().remove(siiOtrosi);
        siiOtrosi.setSiiEstadoOtrosi(null);
        return siiOtrosi;
    }
}
