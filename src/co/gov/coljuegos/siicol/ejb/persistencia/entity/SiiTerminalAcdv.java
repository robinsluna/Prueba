package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TERMINAL_ACDV")
public class SiiTerminalAcdv implements Serializable {
    private Integer tacAnioFabric;
    private Long tacCodigo;
    private String tacModelo;
    private String tacSerial;
    private List<SiiInstrumento> siiInstrumentoList;
    private SiiMarca siiMarca;

    public SiiTerminalAcdv() {
    }

    public SiiTerminalAcdv(SiiMarca siiMarca, Integer tacAnioFabric, Long tacCodigo, String tacModelo,
                           String tacSerial) {
        this.siiMarca = siiMarca;
        this.tacAnioFabric = tacAnioFabric;
        this.tacCodigo = tacCodigo;
        this.tacModelo = tacModelo;
        this.tacSerial = tacSerial;
    }


    @Column(name = "TAC_ANIO_FABRIC", nullable = false)
    public Integer getTacAnioFabric() {
        return tacAnioFabric;
    }

    public void setTacAnioFabric(Integer tacAnioFabric) {
        this.tacAnioFabric = tacAnioFabric;
    }

    @Id
    @Column(name = "TAC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TERMINAL_ACDV_COD")
    @SequenceGenerator(name = "SEQ_TERMINAL_ACDV_COD", sequenceName = "SEQ_TERMINAL_ACDV_COD", allocationSize = 1)
    public Long getTacCodigo() {
        return tacCodigo;
    }

    public void setTacCodigo(Long tacCodigo) {
        this.tacCodigo = tacCodigo;
    }

    @Column(name = "TAC_MODELO", nullable = false, length = 100)
    public String getTacModelo() {
        return tacModelo;
    }

    public void setTacModelo(String tacModelo) {
        this.tacModelo = tacModelo;
    }

    @Column(name = "TAC_SERIAL", nullable = false, length = 30)
    public String getTacSerial() {
        return tacSerial;
    }

    public void setTacSerial(String tacSerial) {
        this.tacSerial = tacSerial;
    }

    @OneToMany(mappedBy = "siiTerminalAcdv")
    public List<SiiInstrumento> getSiiInstrumentoList() {
        return siiInstrumentoList;
    }

    public void setSiiInstrumentoList(List<SiiInstrumento> siiInstrumentoList) {
        this.siiInstrumentoList = siiInstrumentoList;
    }

    public SiiInstrumento addSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().add(siiInstrumento);
        siiInstrumento.setSiiTerminalAcdv(this);
        return siiInstrumento;
    }

    public SiiInstrumento removeSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList().remove(siiInstrumento);
        siiInstrumento.setSiiTerminalAcdv(null);
        return siiInstrumento;
    }

    @ManyToOne
    @JoinColumn(name = "MAR_CODIGO")
    public SiiMarca getSiiMarca() {
        return siiMarca;
    }

    public void setSiiMarca(SiiMarca siiMarca) {
        this.siiMarca = siiMarca;
    }
}
