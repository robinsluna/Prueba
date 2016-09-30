/* 
 * SISTEMA	: SIICOL
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 22-09-2015
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Estados de la denuncia.
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public enum EnumResultadoVerifDenun
{
    INFORMACIÓN_INSUFICIENTE(1L),
    REPETIDO(2L),
    ESTABLECIMIENTO_CON_CONTRATO(3L),
    PENDIENTE_TRABAJO_EN_CAMPO (4L);

    
    /** ID del Estado */
    private Long id;
    
    /**
     * Constructor
     * @param id 
     */
    EnumResultadoVerifDenun (Long id) 
    {
        this.id = id;
    }

    
    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public Long getId() {
        return id;
    }
        
}
