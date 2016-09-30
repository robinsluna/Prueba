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
@Table(name = "SII_TIPO_AMPARO")
public class SiiTipoAmparo implements Serializable {
    private static final long serialVersionUID = 5149648539131516589L;
    private String tamActivo;
    private Long tamCodigo;
    private String tamDescripcion;
    private String tamNombre;
    private List<SiiAmparoEstPrev> siiAmparoEstPrevList1;
    private List<SiiAmparoPolContProv> siiAmparoPolContProvList;

    public SiiTipoAmparo() {
    }

    public SiiTipoAmparo(String tamActivo, Long tamCodigo, String tamDescripcion, String tamNombre) {
        this.tamActivo = tamActivo;
        this.tamCodigo = tamCodigo;
        this.tamDescripcion = tamDescripcion;
        this.tamNombre = tamNombre;
    }

    @Column(name = "TAM_ACTIVO", nullable = false, length = 1)
    public String getTamActivo() {
        return tamActivo;
    }

    public void setTamActivo(String tamActivo) {
        this.tamActivo = tamActivo;
    }

    @Id
    @Column(name = "TAM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_AMPARO_COD")
    @SequenceGenerator(name = "SEQ_TIPO_AMPARO_COD", sequenceName = "SEQ_TIPO_AMPARO_COD",allocationSize=1)
    public Long getTamCodigo() {
        return tamCodigo;
    }

    public void setTamCodigo(Long tamCodigo) {
        this.tamCodigo = tamCodigo;
    }

    @Column(name = "TAM_DESCRIPCION", length = 200)
    public String getTamDescripcion() {
        return tamDescripcion;
    }

    public void setTamDescripcion(String tamDescripcion) {
        this.tamDescripcion = tamDescripcion;
    }

    @Column(name = "TAM_NOMBRE", nullable = false, length = 50)
    public String getTamNombre() {
        return tamNombre;
    }

    public void setTamNombre(String tamNombre) {
        this.tamNombre = tamNombre;
    }

    @OneToMany(mappedBy = "siiTipoAmparo")
    public List<SiiAmparoEstPrev> getSiiAmparoEstPrevList1() {
        return siiAmparoEstPrevList1;
    }

    public void setSiiAmparoEstPrevList1(List<SiiAmparoEstPrev> siiAmparoEstPrevList1) {
        this.siiAmparoEstPrevList1 = siiAmparoEstPrevList1;
    }

    public SiiAmparoEstPrev addSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList1().add(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiTipoAmparo(this);
        return siiAmparoEstPrev;
    }

    public SiiAmparoEstPrev removeSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList1().remove(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiTipoAmparo(null);
        return siiAmparoEstPrev;
    }

    @OneToMany(mappedBy = "siiTipoAmparo")
    public List<SiiAmparoPolContProv> getSiiAmparoPolContProvList() {
        return siiAmparoPolContProvList;
    }

    public void setSiiAmparoPolContProvList(List<SiiAmparoPolContProv> siiAmparoPolContProvList) {
        this.siiAmparoPolContProvList = siiAmparoPolContProvList;
    }

    public SiiAmparoPolContProv addSiiAmparoPolContProv(SiiAmparoPolContProv siiAmparoPolContProv) {
        getSiiAmparoPolContProvList().add(siiAmparoPolContProv);
        siiAmparoPolContProv.setSiiTipoAmparo(this);
        return siiAmparoPolContProv;
    }

    public SiiAmparoPolContProv removeSiiAmparoPolContProv(SiiAmparoPolContProv siiAmparoPolContProv) {
        getSiiAmparoPolContProvList().remove(siiAmparoPolContProv);
        siiAmparoPolContProv.setSiiTipoAmparo(null);
        return siiAmparoPolContProv;
    }
}
