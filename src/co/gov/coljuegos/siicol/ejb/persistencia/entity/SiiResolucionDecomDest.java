package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

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
@Table(name = "SII_RESOLUCION_DECOM_DEST")
public class SiiResolucionDecomDest implements Serializable{
    private static final long serialVersionUID = -7623319907435116135L;
    private Long rddCodigo;
    private Date rddFechaGener;
    private Date rddFechaRadicac;
    private Date rddFechaResolucion;
    private String rddResolucion;
    private SiiResultadoResDecDes siiResultadoResDecDes;
    private List<SiiTramiteResolDecDes> siiTramiteResolDecDesList;
    private List<SiiAccionControl> siiAccionControlList;
    private List<SiiAccionControl> siiAccionControlResuelveList;
    private SiiUsuario siiUsuarioConect;
    private SiiActaDestruccion siiActaDestruccion;
    private String rddResolucionNumera;
    private Date rddFechaResolNumera;

    public SiiResolucionDecomDest(){
    }

    public SiiResolucionDecomDest(Long rddCodigo, Date rddFechaGener, Date rddFechaRadicac, String rddResolucion, SiiResultadoResDecDes siiResultadoResDecDes, SiiUsuario siiUsuarioConect){
        this.rddCodigo = rddCodigo;
        this.rddFechaGener = rddFechaGener;
        this.rddFechaRadicac = rddFechaRadicac;
        this.rddFechaResolucion = rddFechaResolucion;
        this.rddResolucion = rddResolucion;
        this.siiResultadoResDecDes = siiResultadoResDecDes;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Id
    @Column(name = "RDD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOLUC_DECOM_DEST_COD")
    @SequenceGenerator(name = "SEQ_RESOLUC_DECOM_DEST_COD", sequenceName = "SEQ_RESOLUC_DECOM_DEST_COD",allocationSize=1)
    public Long getRddCodigo(){
        return rddCodigo;
    }

    public void setRddCodigo(Long rddCodigo){
        this.rddCodigo = rddCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDD_FECHA_GENER")
    public Date getRddFechaGener(){
        return rddFechaGener;
    }

    public void setRddFechaGener(Date rddFechaGener){
        this.rddFechaGener = rddFechaGener;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDD_FECHA_RADICAC")
    public Date getRddFechaRadicac(){
        return rddFechaRadicac;
    }

    public void setRddFechaRadicac(Date rddFechaRadicac){
        this.rddFechaRadicac = rddFechaRadicac;
    }

    @Column(name = "RDD_RESOLUCION", length = 30)
    public String getRddResolucion(){
        return rddResolucion;
    }

    public void setRddResolucion(String rddResolucion){
        this.rddResolucion = rddResolucion;
    }


    @ManyToOne
    @JoinColumn(name = "RRD_CODIGO")
    public SiiResultadoResDecDes getSiiResultadoResDecDes(){
        return siiResultadoResDecDes;
    }

    public void setSiiResultadoResDecDes(SiiResultadoResDecDes siiResultadoResDecDes){
        this.siiResultadoResDecDes = siiResultadoResDecDes;
    }

    @OneToMany(mappedBy = "siiResolucionDecomDest")
    public List<SiiTramiteResolDecDes> getSiiTramiteResolDecDesList(){
        return siiTramiteResolDecDesList;
    }

    public void setSiiTramiteResolDecDesList(List<SiiTramiteResolDecDes> siiTramiteResolDecDesList){
        this.siiTramiteResolDecDesList = siiTramiteResolDecDesList;
    }

    public SiiTramiteResolDecDes addSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesList().add(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiResolucionDecomDest(this);
        return siiTramiteResolDecDes;
    }

    public SiiTramiteResolDecDes removeSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesList().remove(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiResolucionDecomDest(null);
        return siiTramiteResolDecDes;
    }

    @OneToMany(mappedBy = "siiResolucionDecomDest")
    public List<SiiAccionControl> getSiiAccionControlList(){
        return siiAccionControlList;
    }

    public void setSiiAccionControlList(List<SiiAccionControl> siiAccionControlList){
        this.siiAccionControlList = siiAccionControlList;
    }

    public SiiAccionControl addSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().add(siiAccionControl);
        siiAccionControl.setSiiResolucionDecomDest(this);
        return siiAccionControl;
    }

    public SiiAccionControl removeSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().remove(siiAccionControl);
        siiAccionControl.setSiiResolucionDecomDest(null);
        return siiAccionControl;
    }

    @OneToMany(mappedBy = "siiResolucionDecomDestResuelve")
    public List<SiiAccionControl> getSiiAccionControlResuelveList(){
        return siiAccionControlResuelveList;
    }

    public void setSiiAccionControlResuelveList(List<SiiAccionControl> siiAccionControlResuelveList){
        this.siiAccionControlResuelveList = siiAccionControlResuelveList;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @ManyToOne
    @JoinColumn(name = "ADE_CODIGO")
    public SiiActaDestruccion getSiiActaDestruccion(){
        return siiActaDestruccion;
    }

    public void setSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        this.siiActaDestruccion = siiActaDestruccion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDD_FECHA_RESOLUCION")
    public Date getRddFechaResolucion() {
        return rddFechaResolucion;
    }

    public void setRddFechaResolucion(Date rddFechaResolucion) {
        this.rddFechaResolucion = rddFechaResolucion;
    }

    @Column(name = "RDD_RESOLUCION_NUMERA", length = 30)
    public String getRddResolucionNumera() {
        return rddResolucionNumera;
    }
    
    public void setRddResolucionNumera(String rddResolucionNumera) {
        this.rddResolucionNumera = rddResolucionNumera;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDD_FECHA_RESOL_NUMERA")
    public Date getRddFechaResolNumera() {
        return rddFechaResolNumera;
    }
    
    public void setRddFechaResolNumera(Date rddFechaResolNumera) {
        this.rddFechaResolNumera = rddFechaResolNumera;
    }
}
