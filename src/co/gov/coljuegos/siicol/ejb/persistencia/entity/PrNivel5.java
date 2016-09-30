package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PR_NIVEL5")
@IdClass(PrNivel5PK.class)
public class PrNivel5 implements Serializable {
    private static final long serialVersionUID = 5141732426348756865L;
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel4;
    private String tipoPlan;
    private Integer vigencia;

    public PrNivel5() {
    }

    public PrNivel5(String codigo, String descripcion, Long interno, Long internoNivel4, String tipoPlan,
                    Integer vigencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.interno = interno;
        this.internoNivel4 = internoNivel4;
        this.tipoPlan = tipoPlan;
        this.vigencia = vigencia;
    }

    @Column(nullable = false, length = 10)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(length = 250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_NIVEL5_INTERNO")
    @SequenceGenerator(name = "SEQ_PR_NIVEL5_INTERNO", sequenceName = "SEQ_PR_NIVEL5_INTERNO",allocationSize=1) 
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(name = "INTERNO_NIVEL4", nullable = false)
    public Long getInternoNivel4() {
        return internoNivel4;
    }

    public void setInternoNivel4(Long internoNivel4) {
        this.internoNivel4 = internoNivel4;
    }

    @Column(name = "TIPO_PLAN", length = 30)
    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    @Id
    @Column(nullable = false)
    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
}
