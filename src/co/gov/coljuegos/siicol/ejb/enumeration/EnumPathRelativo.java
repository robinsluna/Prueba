/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2013
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de nombre de la propiedad de Path Relativos configurados en el archivo "<b>recursos.properties</b>".
 * @author Camilo Miranda
 */
public enum EnumPathRelativo {
    
    APROPIACION("pathRelApropIni"),
    CONTRATACION("pathRelContratacion"),
    GCT("pathRelGCT"),
    DESARROLLOMERCADO("pathRelDesarrolloMercado"),
    CONTABILIDAD("pathRelContabilidad");
    
    
    
    /** Path relativo */
    private String relativePath;
    
    
    /**
     * Constructor.
     * @param relativePath
     */
    EnumPathRelativo(String relativePath) {
        this.relativePath = relativePath;
    }


    /**
     * Obtiene el Path Relativo.
     * @return relativePath
     */
    public String getRelativePath() {
        return relativePath;
    }
}
