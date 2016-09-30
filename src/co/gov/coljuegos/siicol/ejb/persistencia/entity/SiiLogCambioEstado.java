package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_LOG_CAMBIO_ESTADO")
public class SiiLogCambioEstado implements Serializable {
    private static final long serialVersionUID = 7242152305608766657L;
    private Long lceCodigo;
    private Long lceCodigoDoc;
    private Long lceEstadoNuevo;
    private Date lceFecha;
    private SiiUsuario siiUsuario;
    private SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos;
    private String LceNombEstNuevo;
    private String lceNombCodigoDoc;

    public SiiLogCambioEstado() {
    }

    public SiiLogCambioEstado(Long lceCodigo, Long lceCodigoDoc, Long lceEstadoNuevo, Date lceFecha,
                              SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos, SiiUsuario siiUsuario) {
        this.lceCodigo = lceCodigo;
        this.lceCodigoDoc = lceCodigoDoc;
        this.lceEstadoNuevo = lceEstadoNuevo;
        this.lceFecha = lceFecha;
        this.siiTipoDocumentoColjuegos = siiTipoDocumentoColjuegos;
        this.siiUsuario = siiUsuario;
    }
    
    public SiiLogCambioEstado(Long lceCodigo, Long lceCodigoDoc, String lceNombEstNuevo, Date lceFecha,
                              SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos, SiiUsuario siiUsuario) {
        this.lceCodigo = lceCodigo;
        this.lceCodigoDoc = lceCodigoDoc;
        this.LceNombEstNuevo = lceNombEstNuevo;
        this.lceFecha = lceFecha;
        this.siiTipoDocumentoColjuegos = siiTipoDocumentoColjuegos;
        this.siiUsuario = siiUsuario;
    }
    
    public SiiLogCambioEstado(String lceNombCodigoDoc, String lceNombEstNuevo, Date lceFecha,
                              SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos, SiiUsuario siiUsuario) {
        this.lceNombCodigoDoc = lceNombCodigoDoc;
        this.LceNombEstNuevo = lceNombEstNuevo;
        this.lceFecha = lceFecha;
        this.siiTipoDocumentoColjuegos = siiTipoDocumentoColjuegos;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "LCE_CODIGO", nullable = false)
    //Comentariado porque no hace falta conocer el id del log de cambio de estado
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LOG_CAMBIO_ESTADO_COD")
    //@SequenceGenerator(name = "SEQ_LOG_CAMBIO_ESTADO_COD", sequenceName = "SEQ_LOG_CAMBIO_ESTADO_COD",allocationSize=1)
    public Long getLceCodigo() {
        return lceCodigo;
    }

    public void setLceCodigo(Long lceCodigo) {
        this.lceCodigo = lceCodigo;
    }

    @Column(name = "LCE_CODIGO_DOC", nullable = false)
    public Long getLceCodigoDoc() {
        return lceCodigoDoc;
    }

    public void setLceCodigoDoc(Long lceCodigoDoc) {
        this.lceCodigoDoc = lceCodigoDoc;
    }

    @Column(name = "LCE_ESTADO_NUEVO", nullable = false)
    public Long getLceEstadoNuevo() {
        return lceEstadoNuevo;
    }

    public void setLceEstadoNuevo(Long lceEstadoNuevo) {
        this.lceEstadoNuevo = lceEstadoNuevo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCE_FECHA", nullable = false)
    public Date getLceFecha() {
        return lceFecha;
    }

    public void setLceFecha(Date lceFecha) {
        this.lceFecha = lceFecha;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "TDO_CODIGO")
    public SiiTipoDocumentoColjuegos getSiiTipoDocumentoColjuegos() {
        return siiTipoDocumentoColjuegos;
    }

    public void setSiiTipoDocumentoColjuegos(SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos) {
        this.siiTipoDocumentoColjuegos = siiTipoDocumentoColjuegos;
    }

    @Column(name = "LCE_NOMB_EST_NUEVO", length = 20)
    public String getLceNombEstNuevo() {
        return LceNombEstNuevo;
    }
    
    public void setLceNombEstNuevo(String LceNombEstNuevo) {
        this.LceNombEstNuevo = LceNombEstNuevo;
    }

    @Column(name = "LCE_NOMB_CODIGO_DOC", length = 20)
    public String getLceNombCodigoDoc() {
        return lceNombCodigoDoc;
    }
    
    public void setLceNombCodigoDoc(String lceNombCodigoDoc) {
        this.lceNombCodigoDoc = lceNombCodigoDoc;
    }
}
