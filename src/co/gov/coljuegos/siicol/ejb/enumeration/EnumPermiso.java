/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-10-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los tipos de Permiso.
 * Obtenidos de la tabla <i>SII_PERMISO</i>.
 * @author Camilo Miranda
 */
public enum EnumPermiso 
{
    REGISTRAR(2L, "REGISTRAR"),
    MODIFICAR(3L, "MODIFICAR"),
    BORRAR(4L, "BORRAR"),
    IMPRIMIR(5L, "IMPRIMIR"),
    APROBAR(23L, "APROBAR"),
    RECHAZAR(24L, "RECHAZAR"),
    CONSULTAR(25L, "CONSULTAR"),
    REVISAR(26L, "REVISAR"),
    GENERAR(41L, "GENERAR"),
    DEVOLVER(42L, "DEVOLVER");
    
    
    
    private Long id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumPermiso(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public Long getId() {
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
        
        EnumPermiso[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
