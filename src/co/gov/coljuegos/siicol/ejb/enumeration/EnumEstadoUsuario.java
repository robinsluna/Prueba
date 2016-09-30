/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-15-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados de los Usuarios.
 * @author Camilo Miranda
 */
public enum EnumEstadoUsuario 
{
    ACTIVO(1L),
    INACTIVO(2L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoUsuario (Long id) {
        this.id = id;;
    }


    public Long getId() {
        return id;
    }
}
