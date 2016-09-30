/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado al Grupo de Retenci&oacute;n.
 * Obtenidos de la tabla <b>SII_GRUPO_RETENC</b>.
 * @author Camilo Miranda
 */
public enum EnumGrupoRetenc
{
    RENTA(1L),
    IVA(2L),
    PRO_ESTAMPILLA_UNAL(3L),
    APORTES_VOLUNTARIOS_AFC(4L),
    APORTES_VOLUNTARIOS_AFP(5L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     */
    EnumGrupoRetenc(Long id) {
        this.id = id;
    }

    
    /**
     * Obtiene el identificador del Enumerado.
     * @return id
     */
    public Long getId() {
        return id;
    }
}
