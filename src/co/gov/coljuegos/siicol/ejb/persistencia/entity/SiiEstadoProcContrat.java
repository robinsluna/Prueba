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
@Table(name = "SII_ESTADO_PROC_CONTRAT")
public class SiiEstadoProcContrat implements Serializable {
    private static final long serialVersionUID = -4159859396864687602L;
    private Long epcCodigo;
    private String epcDescripcion;
    private String epcNombre;
    private List<SiiProcesoContratacion> siiProcesoContratacionList;

    public SiiEstadoProcContrat() {
    }

    public SiiEstadoProcContrat(Long epcCodigo, String epcDescripcion, String epcNombre) {
        this.epcCodigo = epcCodigo;
        this.epcDescripcion = epcDescripcion;
        this.epcNombre = epcNombre;
    }

    @Id
    @Column(name = "EPC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_PROC_CONT_COD")
    @SequenceGenerator(name = "SEQ_ESTADO_PROC_CONT_COD", sequenceName = "SEQ_ESTADO_PROC_CONT_COD",allocationSize=1)
    public Long getEpcCodigo() {
        return epcCodigo;
    }

    public void setEpcCodigo(Long epcCodigo) {
        this.epcCodigo = epcCodigo;
    }

    @Column(name = "EPC_DESCRIPCION", nullable = false, length = 50, insertable=false, updatable = false)
    public String getEpcDescripcion() {
        return epcDescripcion;
    }

    public void setEpcDescripcion(String epcDescripcion) {
        this.epcDescripcion = epcDescripcion;
    }

    @Column(name = "EPC_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEpcNombre() {
        return epcNombre;
    }

    public void setEpcNombre(String epcNombre) {
        this.epcNombre = epcNombre;
    }

    @OneToMany(mappedBy = "siiEstadoProcContrat")
    public List<SiiProcesoContratacion> getSiiProcesoContratacionList() {
        return siiProcesoContratacionList;
    }

    public void setSiiProcesoContratacionList(List<SiiProcesoContratacion> siiProcesoContratacionList) {
        this.siiProcesoContratacionList = siiProcesoContratacionList;
    }

    public SiiProcesoContratacion addSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        getSiiProcesoContratacionList().add(siiProcesoContratacion);
        siiProcesoContratacion.setSiiEstadoProcContrat(this);
        return siiProcesoContratacion;
    }

    public SiiProcesoContratacion removeSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        getSiiProcesoContratacionList().remove(siiProcesoContratacion);
        siiProcesoContratacion.setSiiEstadoProcContrat(null);
        return siiProcesoContratacion;
    }
}
