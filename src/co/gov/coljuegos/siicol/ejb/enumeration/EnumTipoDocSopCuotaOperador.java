package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Documento de Soporte para una Cuota Operador.
 * - Tomados de la columna <i>SII_CUOTA_OPERADOR</i>.<i>COP_TIPO_DOC_SOPOR</i>.
 * @author Camilo Miranda
 */
public enum EnumTipoDocSopCuotaOperador 
{
    CONTRATO("CO", "CONTRATO"), // Cuando el concepto es DE o GA
    RESOLUCION("RE", "RESOLUCIÓN"), // Cuando el concepto es multa o sancion
    DOCUMENTO_ACUERDO_PAGO("DA", "DOCUMENTO DE ACUERDO DE PAGO"); // Cuando el concepto es acuerdo de pago
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoDocSopCuotaOperador(String id, String nombre) 
    {
        this.id = id;
        this.nombre = nombre;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Obtiene el nombre del Enumerado a partir del ID.
     * @param id
     * @return enum.id
     */
    public static String getNombreById (String id) 
    {
        String nombre = null;
        
        EnumTipoDocSopCuotaOperador[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
