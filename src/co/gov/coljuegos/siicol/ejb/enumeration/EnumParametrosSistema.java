package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Par&aacute;metros del Sistema.
 * - Obtenido de la tabla <i>SII_PARAMETROS_SISTEMA</i>.
 * @author Camilo Miranda
 */
public enum EnumParametrosSistema 
{
    PORCENTAJE_MET_VENTAS("PORCENTAJE_MET_VENTAS"), 
    BASE_DE_DATOS("BASE_DE_DATOS"),
    PORCENTAJE_GASTOS_ADMINISTRACION("PORCENTAJE_GASTOS_ADMINISTRACION"),
    DURACION_INHABILIDADES("DURACION_INHABILIDADES"),
    PORCENTAJE_SANCION_OMISION("PORCENTAJE_SANCION_OMISION"),
    PORCENTAJE_SANCION_INEXACTITUD("PORCENTAJE_SANCION_INEXACTITUD"),
    
    EMAIL_CONTACTO_COLJUEGOS("contactenos@coljuegos.gov.co"),
    DIRECCION_COLJUEGOS("Carrera 11 93A 85"),
    INTERNACIONALIZACION_COLJUEGOS("1-170-11-1"),
    NOMBRE_COLJUEGOS("Coljuegos"),
    CAUSAL_ORFEO_COLJUEGOS("1-43-272");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumParametrosSistema (String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
