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
@Table(name = "SII_ESTADO_CONTR_PROV")
public class SiiEstadoContrProv implements Serializable {
    private static final long serialVersionUID = -5643116151949472391L;
    private Long ecpCodigo;
    private String ecpNombre;
    private List<SiiContratoProveedor> siiContratoProveedorList;

    public SiiEstadoContrProv() {
    }

    public SiiEstadoContrProv(Long ecpCodigo, String ecpNombre) {
        this.ecpCodigo = ecpCodigo;
        this.ecpNombre = ecpNombre;
    }

    @Id
    @Column(name = "ECP_CODIGO", nullable = false)
    public Long getEcpCodigo() {
        return ecpCodigo;
    }

    public void setEcpCodigo(Long ecpCodigo) {
        this.ecpCodigo = ecpCodigo;
    }

    @Column(name = "ECP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEcpNombre() {
        return ecpNombre;
    }

    public void setEcpNombre(String ecpNombre) {
        this.ecpNombre = ecpNombre;
    }

    @OneToMany(mappedBy = "siiEstadoContrProv")
    public List<SiiContratoProveedor> getSiiContratoProveedorList() {
        return siiContratoProveedorList;
    }

    public void setSiiContratoProveedorList(List<SiiContratoProveedor> siiContratoProveedorList) {
        this.siiContratoProveedorList = siiContratoProveedorList;
    }

    public SiiContratoProveedor addSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().add(siiContratoProveedor);
        siiContratoProveedor.setSiiEstadoContrProv(this);
        return siiContratoProveedor;
    }

    public SiiContratoProveedor removeSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().remove(siiContratoProveedor);
        siiContratoProveedor.setSiiEstadoContrProv(null);
        return siiContratoProveedor;
    }
}
