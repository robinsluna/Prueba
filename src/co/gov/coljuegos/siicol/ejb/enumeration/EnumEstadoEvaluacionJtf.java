/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-12-2013
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Evaluaci&oacute;n Jur&iacute;dica/T&eacute;cnica/Financiera.
 * Obtenidos de la tabla SII_ESTADO_PROC_CONTRAT.
 * @author Camilo Miranda
 */
public enum EnumEstadoEvaluacionJtf 
{
    BORRADOR_EVALUACION(1L, "BORRADOR EVALUACION"),
    BORRADOR_CONSOLIDACION_EVALUACION(2L, "BORRADOR CONSOLIDACION EVALUACION"),
    CONSOLIDACION_EVALUACION_APROBADO(3L, "CONSOLIDACION EVALUACION APROBADO");
    
    
    /** ID del Estado de la Evaluaci&iacute;n. */
    private Long id;
    /** Nombre del Estado de la Evaluaci&iacute;n. */
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoEvaluacionJtf (Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Obtiene el nombre del Enumerado a partir del ID.
     * @param id
     * @return enum.id
     */
    public static String getNombreById (Long id) 
    {
        String nombre = null;
        
        EnumEstadoEvaluacionJtf[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
