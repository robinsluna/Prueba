package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el Estado de la Imputaci&oacute;n de Obligaciones No Presupuestales.
 * - Obtenido de la columna <i>SII_IMP_CONTAB_OBL_NO_PRES</i>.<i>ION_ESTADO</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoImputacionObligaNoPresupuestal 
{
    ACTIVO("A", "ACTIVO"),
    INACTIVO("I", "INACTIVO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    private EnumEstadoImputacionObligaNoPresupuestal(String id, String nombre) 
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
        
        EnumEstadoImputacionObligaNoPresupuestal[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
