/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 08-07-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a las distintas Fuentes de Financiaci&oacute;n Contable.
 * @author Camilo Miranda
 */
public enum EnumFuenteFinancContab {
    
    RECURSOS_NACION_GENERALES("RNG"),
    RECURSOS_NACION_PERSONALES("RNP"),
    RECURSOS_PROPIOS_ENTIDAD("RPE"),
    RECURSOS_CONTROL_ILEGALIDAD("RCI"),
    RECURSOS_DONACION_TERCEROS("RDT"),
    RECURSOS_NACION_TRANSFERENCIAS("RNT");
    
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumFuenteFinancContab(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
