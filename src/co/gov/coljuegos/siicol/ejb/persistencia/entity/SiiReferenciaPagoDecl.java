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
@Table(name = "SII_REFERENCIA_PAGO_DECL")
public class SiiReferenciaPagoDecl implements Serializable {
    private Long rpdCodigo;
    private Long rpdNumero;
    private List<SiiDetalleDeclaracion> siiDetalleDeclaracionList;

    public SiiReferenciaPagoDecl() {
    }

    public SiiReferenciaPagoDecl(Long rpdCodigo, Long rpdNumero) {
        this.rpdCodigo = rpdCodigo;
        this.rpdNumero = rpdNumero;
    }

    @Id
    @Column(name = "RPD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REFERENCIA_PAGO_DECL_COD")
    @SequenceGenerator(name = "SEQ_REFERENCIA_PAGO_DECL_COD", sequenceName = "SEQ_REFERENCIA_PAGO_DECL_COD",allocationSize=1)
    public Long getRpdCodigo() {
        return rpdCodigo;
    }

    public void setRpdCodigo(Long rpdCodigo) {
        this.rpdCodigo = rpdCodigo;
    }

    @Column(name = "RPD_NUMERO", nullable = false)
    public Long getRpdNumero() {
        return rpdNumero;
    }

    public void setRpdNumero(Long rpdNumero) {
        this.rpdNumero = rpdNumero;
    }

    @OneToMany(mappedBy = "siiReferenciaPagoDecl")
    public List<SiiDetalleDeclaracion> getSiiDetalleDeclaracionList() {
        return siiDetalleDeclaracionList;
    }

    public void setSiiDetalleDeclaracionList(List<SiiDetalleDeclaracion> siiDetalleDeclaracionList) {
        this.siiDetalleDeclaracionList = siiDetalleDeclaracionList;
    }

    public SiiDetalleDeclaracion addSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().add(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiReferenciaPagoDecl(this);
        return siiDetalleDeclaracion;
    }

    public SiiDetalleDeclaracion removeSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().remove(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiReferenciaPagoDecl(null);
        return siiDetalleDeclaracion;
    }
}
