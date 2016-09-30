package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_TRAMITE_RESOL_DEC_DES")
public class SiiTramiteResolDecDes implements Serializable{
    private static final long serialVersionUID = -7708135441320793075L;
    private Long trdCodigo;
    private Date trdFecha;
    private SiiEstadoTramResDecDes siiEstadoTramResDecDes;
    private SiiUsuario siiUsuarioConect;
    private SiiResolucionDecomDest siiResolucionDecomDest;

    public SiiTramiteResolDecDes(){
    }

    public SiiTramiteResolDecDes(SiiEstadoTramResDecDes siiEstadoTramResDecDes, SiiResolucionDecomDest siiResolucionDecomDest, Long trdCodigo, Date trdFecha, SiiUsuario siiUsuarioConect){
        this.siiEstadoTramResDecDes = siiEstadoTramResDecDes;
        this.siiResolucionDecomDest = siiResolucionDecomDest;
        this.trdCodigo = trdCodigo;
        this.trdFecha = trdFecha;
        this.siiUsuarioConect = siiUsuarioConect;
    }


    @Id
    @Column(name = "TRD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAM_RESOL_DEC_DES_COD")
    @SequenceGenerator(name = "SEQ_TRAM_RESOL_DEC_DES_COD", sequenceName = "SEQ_TRAM_RESOL_DEC_DES_COD",allocationSize=1)
    public Long getTrdCodigo(){
        return trdCodigo;
    }

    public void setTrdCodigo(Long trdCodigo){
        this.trdCodigo = trdCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRD_FECHA", nullable = false)
    public Date getTrdFecha(){
        return trdFecha;
    }

    public void setTrdFecha(Date trdFecha){
        this.trdFecha = trdFecha;
    }


    @ManyToOne
    @JoinColumn(name = "ETD_CODIGO")
    public SiiEstadoTramResDecDes getSiiEstadoTramResDecDes(){
        return siiEstadoTramResDecDes;
    }

    public void setSiiEstadoTramResDecDes(SiiEstadoTramResDecDes siiEstadoTramResDecDes){
        this.siiEstadoTramResDecDes = siiEstadoTramResDecDes;
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
    @JoinColumn(name = "RDD_CODIGO")
    public SiiResolucionDecomDest getSiiResolucionDecomDest(){
        return siiResolucionDecomDest;
    }

    public void setSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        this.siiResolucionDecomDest = siiResolucionDecomDest;
    }
}
