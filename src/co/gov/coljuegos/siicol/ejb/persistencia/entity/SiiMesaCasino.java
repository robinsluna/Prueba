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
@Table(name = "SII_MESA_CASINO")
public class SiiMesaCasino implements Serializable {
    private static final long serialVersionUID = -1998219596143354727L;
    private Long mcaCodigo;
    private SiiJuegoMesa siiJuegoMesa;
    private List<SiiInstrumento> siiInstrumentoList;

    public SiiMesaCasino() {
    }

    public SiiMesaCasino(SiiJuegoMesa siiJuegoMesa, Long mcaCodigo) {
        this.siiJuegoMesa = siiJuegoMesa;
        this.mcaCodigo = mcaCodigo;
    }


    @Id
    @Column(name = "MCA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MESA_CASINO_COD")
    @SequenceGenerator(name = "SEQ_MESA_CASINO_COD", sequenceName = "SEQ_MESA_CASINO_COD",allocationSize=1)
    public Long getMcaCodigo() {
        return mcaCodigo;
    }

    public void setMcaCodigo(Long mcaCodigo) {
        this.mcaCodigo = mcaCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "JME_CODIGO")
    public SiiJuegoMesa getSiiJuegoMesa() {
        return siiJuegoMesa;
    }

    public void setSiiJuegoMesa(SiiJuegoMesa siiJuegoMesa) {
        this.siiJuegoMesa = siiJuegoMesa;
    }

    @OneToMany(mappedBy = "siiMesaCasino")
    public List<SiiInstrumento> getSiiInstrumentoList() {
        return siiInstrumentoList;
    }

    public void setSiiInstrumentoList(List<SiiInstrumento> siiInstrumentoList) {
        this.siiInstrumentoList = siiInstrumentoList;
    }

    public SiiInstrumento addSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().add(siiInstrumento);
        siiInstrumento.setSiiMesaCasino(this);
        return siiInstrumento;
    }

    public SiiInstrumento removeSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().remove(siiInstrumento);
        siiInstrumento.setSiiMesaCasino(null);
        return siiInstrumento;
    }
}
