/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y DISTRIBUCION
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-02-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el Estado de los registros de Beneficiario por Ente Territorial.
 * Obtenidos de la tabla <i>SII_BENEFICIARIO_ENTE</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoBeneficiarioEnte 
{
    BORRADOR("BO"),
    APROBADO("AP"),
    ACTIVO("AC"),
    INACTIVO("IN");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoBeneficiarioEnte(String id) 
    {
        this.id = id;;
    }


    public String getId() {
        return id;
    }
}
