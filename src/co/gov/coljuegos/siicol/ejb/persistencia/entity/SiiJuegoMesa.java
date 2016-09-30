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
@Table(name = "SII_JUEGO_MESA")
public class SiiJuegoMesa implements Serializable {
    private static final long serialVersionUID = 4939445659121096823L;
    private Long jmeCodigo;
    private String jmeNombre;
    private List<SiiMesaCasino> siiMesaCasinoList;

    public SiiJuegoMesa() {
    }

    public SiiJuegoMesa(Long jmeCodigo, String jmeNombre) {
        this.jmeCodigo = jmeCodigo;
        this.jmeNombre = jmeNombre;
    }

    @Id
    @Column(name = "JME_CODIGO", nullable = false)
    public Long getJmeCodigo() {
        return jmeCodigo;
    }

    public void setJmeCodigo(Long jmeCodigo) {
        this.jmeCodigo = jmeCodigo;
    }

    @Column(name = "JME_NOMBRE", nullable = false, length = 20)
    public String getJmeNombre() {
        return jmeNombre;
    }

    public void setJmeNombre(String jmeNombre) {
        this.jmeNombre = jmeNombre;
    }

    @OneToMany(mappedBy = "siiJuegoMesa")
    public List<SiiMesaCasino> getSiiMesaCasinoList() {
        return siiMesaCasinoList;
    }

    public void setSiiMesaCasinoList(List<SiiMesaCasino> siiMesaCasinoList) {
        this.siiMesaCasinoList = siiMesaCasinoList;
    }

    public SiiMesaCasino addSiiMesaCasino(SiiMesaCasino siiMesaCasino) {
        getSiiMesaCasinoList().add(siiMesaCasino);
        siiMesaCasino.setSiiJuegoMesa(this);
        return siiMesaCasino;
    }

    public SiiMesaCasino removeSiiMesaCasino(SiiMesaCasino siiMesaCasino) {
        getSiiMesaCasinoList().remove(siiMesaCasino);
        siiMesaCasino.setSiiJuegoMesa(null);
        return siiMesaCasino;
    }
}
