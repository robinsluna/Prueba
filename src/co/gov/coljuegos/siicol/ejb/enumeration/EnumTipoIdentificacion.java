/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-03-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Identificaci&oacute;n.
 * Obtenidos de la tabla SII_TIPO_IDENTIFICACION.
 * @author Camilo Miranda
 */
public enum EnumTipoIdentificacion {
    
    REGISTRO_CIVIL(11L, "RCI"),
    TARJETA_IDENTIDAD(12L, "TI"),
    CEDULA_CIUDADANIA(13L, "CC"),
    CEDULA_EXTRANJERIA(22L, "CE"),
    NUMERO_IDENTIFICACION_TRIBUTARIO(31L, "NIT"),
    PASAPORTE(41L, "PAS"),
    DOCUMENTO_IDENTIFICACION_EXTRANJERO(42L, "DIE"),
    SIN_IDENTIFICACION_EXTERIOR(43L, "SIE"),
    IDENTIFICACION_EXTRANJERO_PERSONA_JURIDICA(44L, "DEPJ"),
    CARNE_DIPLOMATICO(46L, "CDI"),
    CERTIFICADO_REGISTRADURIA(14L, "CRE"),
    DOCUMENTO_SUCESION_ILIQUIDA(15L, "DSI"),
    ID_EXTRANJEROS_NO_NIT(33L, "TEX"),
    TARJETA_EXTRANJERIA(21L, "TE");
    
    
    
    private Long id;
    private String nombreCorto;
    
    
    /**
     *  Constructor.
     */
    EnumTipoIdentificacion(Long id, String nombreCorto) {
        this.id = id;
        this.nombreCorto = nombreCorto;
    }


    public Long getId() {
        return id;
    }
    
    public String getNombreCorto() {
        return nombreCorto;
    }
    
    
    /**
     * Obtiene el nombre del Enumerado a partir del ID.
     * @param id
     * @return enum.id
     */
    public static String getNombreCortoById (Long id) 
    {
        String nombre = null;
        
        EnumTipoIdentificacion[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombreCorto();
            i++;
        }
        
        return (nombre);
    }
}
