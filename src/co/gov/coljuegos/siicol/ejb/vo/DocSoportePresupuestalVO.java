package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;


/**
 * Value Object para los Documentos de Soporte relacionados con temas Presupuestales.
 * @author Camilo Miranda
 */
public class DocSoportePresupuestalVO {
    
    /** Tipo de Documento: <b>DECRETO</b> */
    public final static String DECRETO = "Decreto";
    /** Tipo de Documento: <b>ACUERDO</b> */
    public final static String ACUERDO = "Acuerdo";
    /** Tipo de Documento: <b>OFICIO</b> */
    public final static String OFICIO = "Oficio";
    
    
    private String tipoDocumento;
    private Date fechaDocumento;
    private String numeroDocumento;
    
    
    
    /**
     * Constructor.
     */
    public DocSoportePresupuestalVO() { }
    
    
    /**
     * Constructor.
     * @param tipoDocumento - Tipo de Documento Presupuestal.
     */
    public DocSoportePresupuestalVO (String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
}
