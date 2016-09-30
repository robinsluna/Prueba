package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_EMPRESA_DESTRUYE")
public class SiiEmpresaDestruye implements Serializable{
    private static final long serialVersionUID = 2940905296152257318L;
    private String emdActivo;
    private Long emdCodigo;
    private Date emdFechaActiv;
    private Date emdFechaInac;
    private Integer emdVigencia;
    private List<SiiActaDestruccion> siiActaDestruccionList;
    private SiiPersona siiPersona;
    private SiiUsuario siiUsuarioConect;

    public SiiEmpresaDestruye(){
    }

    public SiiEmpresaDestruye(String emdActivo, Long emdCodigo, Date emdFechaActiv, Date emdFechaInac, Integer emdVigencia, SiiPersona siiPersona, SiiUsuario siiUsuarioConect){
        this.emdActivo = emdActivo;
        this.emdCodigo = emdCodigo;
        this.emdFechaActiv = emdFechaActiv;
        this.emdFechaInac = emdFechaInac;
        this.emdVigencia = emdVigencia;
        this.siiPersona = siiPersona;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Column(name = "EMD_ACTIVO", nullable = false, length = 1)
    public String getEmdActivo(){
        return emdActivo;
    }

    public void setEmdActivo(String emdActivo){
        this.emdActivo = emdActivo;
    }

    @Id
    @Column(name = "EMD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_EMPRESA_DESTRUYE_COD")
    @SequenceGenerator(name = "SEQ_EMPRESA_DESTRUYE_COD", sequenceName = "SEQ_EMPRESA_DESTRUYE_COD",allocationSize=1)
    public Long getEmdCodigo(){
        return emdCodigo;
    }

    public void setEmdCodigo(Long emdCodigo){
        this.emdCodigo = emdCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EMD_FECHA_ACTIV", nullable = false)
    public Date getEmdFechaActiv(){
        return emdFechaActiv;
    }

    public void setEmdFechaActiv(Date emdFechaActiv){
        this.emdFechaActiv = emdFechaActiv;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EMD_FECHA_INAC")
    public Date getEmdFechaInac(){
        return emdFechaInac;
    }

    public void setEmdFechaInac(Date emdFechaInac){
        this.emdFechaInac = emdFechaInac;
    }

    @Column(name = "EMD_VIGENCIA", nullable = false)
    public Integer getEmdVigencia(){
        return emdVigencia;
    }

    public void setEmdVigencia(Integer emdVigencia){
        this.emdVigencia = emdVigencia;
    }


    @OneToMany(mappedBy = "siiEmpresaDestruye")
    public List<SiiActaDestruccion> getSiiActaDestruccionList(){
        return siiActaDestruccionList;
    }

    public void setSiiActaDestruccionList(List<SiiActaDestruccion> siiActaDestruccionList){
        this.siiActaDestruccionList = siiActaDestruccionList;
    }

    public SiiActaDestruccion addSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionList().add(siiActaDestruccion);
        siiActaDestruccion.setSiiEmpresaDestruye(this);
        return siiActaDestruccion;
    }

    public SiiActaDestruccion removeSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionList().remove(siiActaDestruccion);
        siiActaDestruccion.setSiiEmpresaDestruye(null);
        return siiActaDestruccion;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona(){
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona){
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }
}
