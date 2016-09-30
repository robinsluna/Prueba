/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-04-2015
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Retenci&oacute;n.
 * @author Camilo Miranda
 */
public enum EnumTipoRetencion 
{
    ADVEH("ADVEH"),
    AFC("AFC"),
    AFP("AFP"),
    ARRBI("ARRBI"),
    ARRBM("ARRBM"),
    ARRGI("ARRGI"),
    ARRIM("ARRIM"),
    ASEVI("ASEVI"),
    ATIRE("ATIRE"),
    BIEGI("BIEGI"),
    COMCO("COMCO"),
    COMGE("COMGE"),
    COMND("COMND"),
    COMPJ("COMPJ"),
    COMPN("COMPN"),
    CONST("CONST"),
    COSPJ("COSPJ"),
    COSPN("COSPN"),
    EMPPN("EMPPN"),
    EXTER("EXTER"),
    HONGI("HONGI"),
    HONND("HONND"),
    HONPJ("HONPJ"),
    HONPN("HONPN"),
    HOREH("HOREH"),
    INGDR("INGDR"),
    INGPN("INGPN"),
    L1429("L1429"),
    LICEN("LICEN"),
    LOTRF("LOTRF"),
    NOIVA("NOIVA"),
    NORTE("NORTE"),
    SALUD("SALUD"),
    SEREX("SEREX"),
    SERGE("SERGE"),
    SERGI("SERGI"),
    SERND("SERND"),
    SISHI("SISHI"),
    TC1("TC1"),
    TC2("TC2"),
    TC3("TC3"),
    TEMPO("TEMPO"),
    TPNCP("TPNCP"),
    TRAAM("TRAAM"),
    TRACR("TRACR"),
    TRAPS("TRAPS");
        
        
    private String id;
    
    
    
    /**
     * Constructor.
     */
    EnumTipoRetencion(String id) 
    {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
