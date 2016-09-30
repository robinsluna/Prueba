package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_DECLARACION_SUGERIDA")
public class SiiDeclaracionSugerida implements Serializable {
    private static final long serialVersionUID = 4306830417308466283L;
    private Long dsuCodigo;
    private Integer dsuConsecutivo;
    private Date dsuFecha;
    private List<SiiDeclaracionOperador> siiDeclaracionOperadorList;
    private List<SiiDetalleDeclaracionSug> siiDetalleDeclaracionSugList;

    public SiiDeclaracionSugerida() {
    }

    public SiiDeclaracionSugerida(Long dsuCodigo, Integer dsuConsecutivo, Date dsuFecha) {
        this.dsuCodigo = dsuCodigo;
        this.dsuConsecutivo = dsuConsecutivo;
        this.dsuFecha = dsuFecha;
    }

    @Id
    @Column(name = "DSU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DECLARACION_SUG_COD")
    @SequenceGenerator(name = "SEQ_DECLARACION_SUG_COD", sequenceName = "SEQ_DECLARACION_SUG_COD",allocationSize=1)
    public Long getDsuCodigo() {
        return dsuCodigo;
    }

    public void setDsuCodigo(Long dsuCodigo) {
        this.dsuCodigo = dsuCodigo;
    }

    @Column(name = "DSU_CONSECUTIVO", nullable = false)
    public Integer getDsuConsecutivo() {
        return dsuConsecutivo;
    }

    public void setDsuConsecutivo(Integer dsuConsecutivo) {
        this.dsuConsecutivo = dsuConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DSU_FECHA", nullable = false)
    public Date getDsuFecha() {
        return dsuFecha;
    }

    public void setDsuFecha(Date dsuFecha) {
        this.dsuFecha = dsuFecha;
    }

    @OneToMany(mappedBy = "siiDeclaracionSugerida")
    public List<SiiDeclaracionOperador> getSiiDeclaracionOperadorList() {
        return siiDeclaracionOperadorList;
    }

    public void setSiiDeclaracionOperadorList(List<SiiDeclaracionOperador> siiDeclaracionOperadorList) {
        this.siiDeclaracionOperadorList = siiDeclaracionOperadorList;
    }

    public SiiDeclaracionOperador addSiiDeclaracionOperador(SiiDeclaracionOperador siiDeclaracionOperador) {
        getSiiDeclaracionOperadorList().add(siiDeclaracionOperador);
        siiDeclaracionOperador.setSiiDeclaracionSugerida(this);
        return siiDeclaracionOperador;
    }

    public SiiDeclaracionOperador removeSiiDeclaracionOperador(SiiDeclaracionOperador siiDeclaracionOperador) {
        getSiiDeclaracionOperadorList().remove(siiDeclaracionOperador);
        siiDeclaracionOperador.setSiiDeclaracionSugerida(null);
        return siiDeclaracionOperador;
    }

    @OneToMany(mappedBy = "siiDeclaracionSugerida")
    public List<SiiDetalleDeclaracionSug> getSiiDetalleDeclaracionSugList() {
        return siiDetalleDeclaracionSugList;
    }

    public void setSiiDetalleDeclaracionSugList(List<SiiDetalleDeclaracionSug> siiDetalleDeclaracionSugList) {
        this.siiDetalleDeclaracionSugList = siiDetalleDeclaracionSugList;
    }

    public SiiDetalleDeclaracionSug addSiiDetalleDeclaracionSug(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug) {
        getSiiDetalleDeclaracionSugList().add(siiDetalleDeclaracionSug);
        siiDetalleDeclaracionSug.setSiiDeclaracionSugerida(this);
        return siiDetalleDeclaracionSug;
    }

    public SiiDetalleDeclaracionSug removeSiiDetalleDeclaracionSug(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug) {
        getSiiDetalleDeclaracionSugList().remove(siiDetalleDeclaracionSug);
        siiDetalleDeclaracionSug.setSiiDeclaracionSugerida(null);
        return siiDetalleDeclaracionSug;
    }
}
