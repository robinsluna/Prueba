package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el Indicador de Estado de Cuenta.
 * @author Camilo Miranda
 */
public enum EnumIndicadorEstadoCuenta 
{
    A_PAZ_Y_SALVO("PS", "A PAZ Y SALVO"),
    CON_SALDO_POR_PAGAR("SP", "CON SALDO POR PAGAR"),
    CON_SALDO_A_FAVOR("SF", "CON SALDO A FAVOR");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumIndicadorEstadoCuenta(String id, String nombre) 
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
        
        EnumIndicadorEstadoCuenta[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
