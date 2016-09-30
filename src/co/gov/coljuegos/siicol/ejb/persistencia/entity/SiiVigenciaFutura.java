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
@Table(name = "SII_VIGENCIA_FUTURA")
public class SiiVigenciaFutura implements Serializable {
    private static final long serialVersionUID = 7761732213830071267L;
    private Long vfuCodigo;
    private String vfuEstado;
    private Date vfuFechaOficioAut;
    private String vfuNumOficioAut;
    private Integer vfuVigencia;
    private List<SiiDetRubroVigenFutura> siiDetRubroVigenFuturaList;

    public SiiVigenciaFutura() {
    }

    public SiiVigenciaFutura(Long vfuCodigo, String vfuEstado, Date vfuFechaOficioAut, String vfuNumOficioAut,
                             Integer vfuVigencia) {
        this.vfuCodigo = vfuCodigo;
        this.vfuEstado = vfuEstado;
        this.vfuFechaOficioAut = vfuFechaOficioAut;
        this.vfuNumOficioAut = vfuNumOficioAut;
        this.vfuVigencia = vfuVigencia;
    }

    @Id
    @Column(name = "VFU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_VIGENCIA_FUTURA_COD")
    @SequenceGenerator(name = "SEQ_VIGENCIA_FUTURA_COD", sequenceName = "SEQ_VIGENCIA_FUTURA_COD",allocationSize=1)
    public Long getVfuCodigo() {
        return vfuCodigo;
    }

    public void setVfuCodigo(Long vfuCodigo) {
        this.vfuCodigo = vfuCodigo;
    }

    @Column(name = "VFU_ESTADO", nullable = false, length = 1)
    public String getVfuEstado() {
        return vfuEstado;
    }

    public void setVfuEstado(String vfuEstado) {
        this.vfuEstado = vfuEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VFU_FECHA_OFICIO_AUT", nullable = false)
    public Date getVfuFechaOficioAut() {
        return vfuFechaOficioAut;
    }

    public void setVfuFechaOficioAut(Date vfuFechaOficioAut) {
        this.vfuFechaOficioAut = vfuFechaOficioAut;
    }

    @Column(name = "VFU_NUM_OFICIO_AUT", nullable = false, length = 10)
    public String getVfuNumOficioAut() {
        return vfuNumOficioAut;
    }

    public void setVfuNumOficioAut(String vfuNumOficioAut) {
        this.vfuNumOficioAut = vfuNumOficioAut;
    }

    @Column(name = "VFU_VIGENCIA", nullable = false)
    public Integer getVfuVigencia() {
        return vfuVigencia;
    }

    public void setVfuVigencia(Integer vfuVigencia) {
        this.vfuVigencia = vfuVigencia;
    }

    @OneToMany(mappedBy = "siiVigenciaFutura")
    public List<SiiDetRubroVigenFutura> getSiiDetRubroVigenFuturaList() {
        return siiDetRubroVigenFuturaList;
    }

    public void setSiiDetRubroVigenFuturaList(List<SiiDetRubroVigenFutura> siiDetRubroVigenFuturaList) {
        this.siiDetRubroVigenFuturaList = siiDetRubroVigenFuturaList;
    }

    public SiiDetRubroVigenFutura addSiiDetRubroVigenFutura(SiiDetRubroVigenFutura siiDetRubroVigenFutura) {
        getSiiDetRubroVigenFuturaList().add(siiDetRubroVigenFutura);
        siiDetRubroVigenFutura.setSiiVigenciaFutura(this);
        return siiDetRubroVigenFutura;
    }

    public SiiDetRubroVigenFutura removeSiiDetRubroVigenFutura(SiiDetRubroVigenFutura siiDetRubroVigenFutura) {
        getSiiDetRubroVigenFuturaList().remove(siiDetRubroVigenFutura);
        siiDetRubroVigenFutura.setSiiVigenciaFutura(null);
        return siiDetRubroVigenFutura;
    }
}
