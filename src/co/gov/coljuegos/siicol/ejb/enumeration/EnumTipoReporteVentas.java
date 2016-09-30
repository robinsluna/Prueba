/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Mónica Pabón
 * FECHA	: 20-08-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumerado para los tipos de reporte de ventas.
 * @author Mónica Pabón
 */

public enum EnumTipoReporteVentas {
   
    PRIMER_REPORTE("P"),
    VENTAS_MODIFICADAS("M"),
    VENTAS_CORREGIDAS("Cn"),
    VENTAS_Q("Q");
    
    private String id;
    
    
    /**
     * Constructor.
     */
    EnumTipoReporteVentas(String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
