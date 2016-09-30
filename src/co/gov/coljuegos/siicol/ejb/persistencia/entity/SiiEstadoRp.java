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
@Table(name = "SII_ESTADO_RP")
public class SiiEstadoRp implements Serializable {
    private static final long serialVersionUID = 5745631468737017414L;
    private String erpActivo;
    private Long erpCodigo;
    private String erpDescripcion;
    private String erpNombre;
    private List<SiiRp> siiRpList;

    public SiiEstadoRp() {
    }

    public SiiEstadoRp(String erpActivo, Long erpCodigo, String erpDescripcion, String erpNombre) {
        this.erpActivo = erpActivo;
        this.erpCodigo = erpCodigo;
        this.erpDescripcion = erpDescripcion;
        this.erpNombre = erpNombre;
    }

    @Column(name = "ERP_ACTIVO", nullable = false, length = 1, insertable=false, updatable = false)
    public String getErpActivo() {
        return erpActivo;
    }

    public void setErpActivo(String erpActivo) {
        this.erpActivo = erpActivo;
    }
    
    @Id
    @Column(name = "ERP_CODIGO", nullable = false)
    public Long getErpCodigo() {
        return erpCodigo;
    }

    public void setErpCodigo(Long erpCodigo) {
        this.erpCodigo = erpCodigo;
    }

    @Column(name = "ERP_DESCRIPCION", length = 100, insertable=false, updatable = false)
    public String getErpDescripcion() {
        return erpDescripcion;
    }

    public void setErpDescripcion(String erpDescripcion) {
        this.erpDescripcion = erpDescripcion;
    }

    @Column(name = "ERP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getErpNombre() {
        return erpNombre;
    }

    public void setErpNombre(String erpNombre) {
        this.erpNombre = erpNombre;
    }

    @OneToMany(mappedBy = "siiEstadoRp")
    public List<SiiRp> getSiiRpList() {
        return siiRpList;
    }

    public void setSiiRpList(List<SiiRp> siiRpList) {
        this.siiRpList = siiRpList;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList().add(siiRp);
        siiRp.setSiiEstadoRp(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList().remove(siiRp);
        siiRp.setSiiEstadoRp(null);
        return siiRp;
    }
}
