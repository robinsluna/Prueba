package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_INVENTARIO_RESOL_DESIS")
public class SiiInventarioResolDesis implements Serializable{
    private static final long serialVersionUID = -2384155285492540291L;
    private String irdActivo;
    private Integer irdCantidadElem;
    private Long irdCodigo;
    private SiiTipoApuesta siiTipoApuesta;
    private SiiUsuario siiUsuarioConect;
    private SiiResolucionDesisSolAut siiResolucionDesisSolAut;
    private SiiTipoNovedad siiTipoNovedad;

    public SiiInventarioResolDesis(){
    }

    public SiiInventarioResolDesis(String irdActivo, Integer irdCantidadElem, Long irdCodigo, SiiResolucionDesisSolAut siiResolucionDesisSolAut, SiiTipoApuesta siiTipoApuesta,
                                   SiiUsuario siiUsuarioConect, SiiTipoNovedad siiTipoNovedad){
        this.irdActivo = irdActivo;
        this.irdCantidadElem = irdCantidadElem;
        this.irdCodigo = irdCodigo;
        this.siiResolucionDesisSolAut = siiResolucionDesisSolAut;
        this.siiTipoApuesta = siiTipoApuesta;
        this.siiUsuarioConect = siiUsuarioConect;
        this.siiTipoNovedad = siiTipoNovedad;
    }

    @Column(name = "IRD_ACTIVO", nullable = false, length = 1)
    public String getIrdActivo(){
        return irdActivo;
    }

    public void setIrdActivo(String irdActivo){
        this.irdActivo = irdActivo;
    }

    @Column(name = "IRD_CANTIDAD_ELEM", nullable = false)
    public Integer getIrdCantidadElem(){
        return irdCantidadElem;
    }

    public void setIrdCantidadElem(Integer irdCantidadElem){
        this.irdCantidadElem = irdCantidadElem;
    }

    @Id
    @Column(name = "IRD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVENTARIO_RESOL_DESIS")
    @SequenceGenerator(name = "SEQ_INVENTARIO_RESOL_DESIS", sequenceName = "SEQ_INVENTARIO_RESOL_DESIS",allocationSize=1)
    public Long getIrdCodigo(){
        return irdCodigo;
    }

    public void setIrdCodigo(Long irdCodigo){
        this.irdCodigo = irdCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta(){
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta){
        this.siiTipoApuesta = siiTipoApuesta;
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
    @JoinColumn(name = "RDS_CODIGO")
    public SiiResolucionDesisSolAut getSiiResolucionDesisSolAut(){
        return siiResolucionDesisSolAut;
    }

    public void setSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        this.siiResolucionDesisSolAut = siiResolucionDesisSolAut;
    }
    
    @ManyToOne
    @JoinColumn(name = "TNO_CODIGO")
    public SiiTipoNovedad getSiiTipoNovedad(){
        return siiTipoNovedad;
    }
    public void setSiiTipoNovedad(SiiTipoNovedad siiTipoNovedad){
        this.siiTipoNovedad = siiTipoNovedad;
    }
}
