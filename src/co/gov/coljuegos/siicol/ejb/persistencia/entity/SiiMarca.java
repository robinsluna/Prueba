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
@Table(name = "SII_MARCA")
public class SiiMarca implements Serializable {
    private static final long serialVersionUID = 5080648134738964794L;
    private Long marCodigo;
    private String marNombre;
    private List<SiiMet> siiMetList1;
    private List<SiiTerminalAcdv> siiTerminalAcdvList;

    public SiiMarca() {
    }

    public SiiMarca(Long marCodigo, String marNombre, String marReferencia) {
        this.marCodigo = marCodigo;
        this.marNombre = marNombre;
    }

    @Id
    @Column(name = "MAR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MARCA_COD")
    @SequenceGenerator(name = "SEQ_MARCA_COD", sequenceName = "SEQ_MARCA_COD",allocationSize=1)
    public Long getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(Long marCodigo) {
        this.marCodigo = marCodigo;
    }

    @Column(name = "MAR_NOMBRE", nullable = false, length = 100)
    public String getMarNombre() {
        return marNombre;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    @OneToMany(mappedBy = "siiMarca")
    public List<SiiMet> getSiiMetList1() {
        return siiMetList1;
    }

    public void setSiiMetList1(List<SiiMet> siiMetList1) {
        this.siiMetList1 = siiMetList1;
    }

    public SiiMet addSiiMet(SiiMet siiMet) {
        getSiiMetList1().add(siiMet);
        siiMet.setSiiMarca(this);
        return siiMet;
    }

    public SiiMet removeSiiMet(SiiMet siiMet) {
        getSiiMetList1().remove(siiMet);
        siiMet.setSiiMarca(null);
        return siiMet;
    }

    @OneToMany(mappedBy = "siiMarca")
    public List<SiiTerminalAcdv> getSiiTerminalAcdvList() {
        return siiTerminalAcdvList;
    }

    public void setSiiTerminalAcdvList(List<SiiTerminalAcdv> siiTerminalAcdvList) {
        this.siiTerminalAcdvList = siiTerminalAcdvList;
    }

    public SiiTerminalAcdv addSiiTerminalAcdv(SiiTerminalAcdv siiTerminalAcdv) {
        getSiiTerminalAcdvList().add(siiTerminalAcdv);
        siiTerminalAcdv.setSiiMarca(this);
        return siiTerminalAcdv;
    }

    public SiiTerminalAcdv removeSiiTerminalAcdv(SiiTerminalAcdv siiTerminalAcdv) {
        getSiiTerminalAcdvList().remove(siiTerminalAcdv);
        siiTerminalAcdv.setSiiMarca(null);
        return siiTerminalAcdv;
    }
}
