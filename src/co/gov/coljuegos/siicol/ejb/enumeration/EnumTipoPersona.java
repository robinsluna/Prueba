/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 07-04-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el manejo de Tipos de Persona.
 * @author Camilo Miranda
 */
public enum EnumTipoPersona 
{
    NATURAL("N"),
    JURIDICA("J");
    
    
    private String id;
    
    
    /**
     * Constructor.
     */
    EnumTipoPersona(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
