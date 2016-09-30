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
@Table(name = "SII_ESTADO_OFICIO_LIQ")
public class SiiEstadoOficioLiq implements Serializable {
    private static final long serialVersionUID = 5508698068493062875L;
    private Long eolCodigo;
    private String eolNombre;
    private List<SiiOficioLiquidacion> siiOficioLiquidacionList;

    public SiiEstadoOficioLiq() {
    }

    public SiiEstadoOficioLiq(Long eolCodigo, String eolNombre) {
        this.eolCodigo = eolCodigo;
        this.eolNombre = eolNombre;
    }

    @Id
    @Column(name = "EOL_CODIGO", nullable = false)
    public Long getEolCodigo() {
        return eolCodigo;
    }

    public void setEolCodigo(Long eolCodigo) {
        this.eolCodigo = eolCodigo;
    }

    @Column(name = "EOL_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEolNombre() {
        return eolNombre;
    }

    public void setEolNombre(String eolNombre) {
        this.eolNombre = eolNombre;
    }

    @OneToMany(mappedBy = "siiEstadoOficioLiq")
    public List<SiiOficioLiquidacion> getSiiOficioLiquidacionList() {
        return siiOficioLiquidacionList;
    }

    public void setSiiOficioLiquidacionList(List<SiiOficioLiquidacion> siiOficioLiquidacionList) {
        this.siiOficioLiquidacionList = siiOficioLiquidacionList;
    }

    public SiiOficioLiquidacion addSiiOficioLiquidacion(SiiOficioLiquidacion siiOficioLiquidacion) {
        getSiiOficioLiquidacionList().add(siiOficioLiquidacion);
        siiOficioLiquidacion.setSiiEstadoOficioLiq(this);
        return siiOficioLiquidacion;
    }

    public SiiOficioLiquidacion removeSiiOficioLiquidacion(SiiOficioLiquidacion siiOficioLiquidacion) {
        getSiiOficioLiquidacionList().remove(siiOficioLiquidacion);
        siiOficioLiquidacion.setSiiEstadoOficioLiq(null);
        return siiOficioLiquidacion;
    }
}
