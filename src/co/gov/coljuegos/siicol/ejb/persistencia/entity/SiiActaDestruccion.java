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
@Table(name = "SII_ACTA_DESTRUCCION")
public class SiiActaDestruccion implements Serializable{
    private static final long serialVersionUID = -569445321875487565L;
    private Long adeCodigo;
    private String adeEstado;
    private Date adeFecha;
    private Date adeFechaFin;
    private Date adeFechaIni;
    private String adeLugar;
    private Integer adeNumero;
    private SiiEmpresaDestruye siiEmpresaDestruye;
    private SiiMotivoNoDestruccion siiMotivoNoDestruccion;
    private SiiUbicacion siiUbicacionMunic;
    private SiiUsuario siiUsuarioConect;
    private List<SiiResolucionDecomDest> siiResolucionDecomDestList;

    public SiiActaDestruccion(){
    }

    public SiiActaDestruccion(Long adeCodigo, String adeEstado, Date adeFecha, Date adeFechaFin, Date adeFechaIni, String adeLugar, Integer adeNumero, SiiEmpresaDestruye siiEmpresaDestruye,
                              SiiMotivoNoDestruccion siiMotivoNoDestruccion, SiiUbicacion siiUbicacionMunic, SiiUsuario siiUsuarioConect){
        this.adeCodigo = adeCodigo;
        this.adeEstado = adeEstado;
        this.adeFecha = adeFecha;
        this.adeFechaFin = adeFechaFin;
        this.adeFechaIni = adeFechaIni;
        this.adeLugar = adeLugar;
        this.adeNumero = adeNumero;
        this.siiEmpresaDestruye = siiEmpresaDestruye;
        this.siiMotivoNoDestruccion = siiMotivoNoDestruccion;
        this.siiUbicacionMunic = siiUbicacionMunic;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Id
    @Column(name = "ADE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTA_DESTRUCCION_COD")
    @SequenceGenerator(name = "SEQ_ACTA_DESTRUCCION_COD", sequenceName = "SEQ_ACTA_DESTRUCCION_COD",allocationSize=1)
    public Long getAdeCodigo(){
        return adeCodigo;
    }

    public void setAdeCodigo(Long adeCodigo){
        this.adeCodigo = adeCodigo;
    }

    @Column(name = "ADE_ESTADO", nullable = false, length = 1)
    public String getAdeEstado(){
        return adeEstado;
    }

    public void setAdeEstado(String adeEstado){
        this.adeEstado = adeEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADE_FECHA", nullable = false)
    public Date getAdeFecha(){
        return adeFecha;
    }

    public void setAdeFecha(Date adeFecha){
        this.adeFecha = adeFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADE_FECHA_FIN", nullable = false)
    public Date getAdeFechaFin(){
        return adeFechaFin;
    }

    public void setAdeFechaFin(Date adeFechaFin){
        this.adeFechaFin = adeFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ADE_FECHA_INI", nullable = false)
    public Date getAdeFechaIni(){
        return adeFechaIni;
    }

    public void setAdeFechaIni(Date adeFechaIni){
        this.adeFechaIni = adeFechaIni;
    }

    @Column(name = "ADE_LUGAR", nullable = false, length = 100)
    public String getAdeLugar(){
        return adeLugar;
    }

    public void setAdeLugar(String adeLugar){
        this.adeLugar = adeLugar;
    }

    @Column(name = "ADE_NUMERO", nullable = false)
    public Integer getAdeNumero(){
        return adeNumero;
    }

    public void setAdeNumero(Integer adeNumero){
        this.adeNumero = adeNumero;
    }


    @ManyToOne
    @JoinColumn(name = "EMD_CODIGO")
    public SiiEmpresaDestruye getSiiEmpresaDestruye(){
        return siiEmpresaDestruye;
    }

    public void setSiiEmpresaDestruye(SiiEmpresaDestruye siiEmpresaDestruye){
        this.siiEmpresaDestruye = siiEmpresaDestruye;
    }

    @ManyToOne
    @JoinColumn(name = "MND_CODIGO")
    public SiiMotivoNoDestruccion getSiiMotivoNoDestruccion(){
        return siiMotivoNoDestruccion;
    }

    public void setSiiMotivoNoDestruccion(SiiMotivoNoDestruccion siiMotivoNoDestruccion){
        this.siiMotivoNoDestruccion = siiMotivoNoDestruccion;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_MUNIC")
    public SiiUbicacion getSiiUbicacionMunic(){
        return siiUbicacionMunic;
    }

    public void setSiiUbicacionMunic(SiiUbicacion siiUbicacionMunic){
        this.siiUbicacionMunic = siiUbicacionMunic;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @OneToMany(mappedBy = "siiActaDestruccion")
    public List<SiiResolucionDecomDest> getSiiResolucionDecomDestList(){
        return siiResolucionDecomDestList;
    }

    public void setSiiResolucionDecomDestList(List<SiiResolucionDecomDest> siiResolucionDecomDestList){
        this.siiResolucionDecomDestList = siiResolucionDecomDestList;
    }

    public SiiResolucionDecomDest addSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestList().add(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiActaDestruccion(this);
        return siiResolucionDecomDest;
    }

    public SiiResolucionDecomDest removeSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestList().remove(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiActaDestruccion(null);
        return siiResolucionDecomDest;
    }
}
