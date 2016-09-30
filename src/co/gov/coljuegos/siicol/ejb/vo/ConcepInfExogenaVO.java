/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepInfExogena;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;

import java.util.List;


/**
 * Value Object para los Conceptos de Informaci&oacute;n Ex&oacute;gena.
 * @author Camilo Miranda
 */
public class ConcepInfExogenaVO 
{
    private Long cieCodigo;
    private String cieNombre;
    
    private List<SiiImputacionContable> imputacionContableList;
    
    
    
    /**
     * Constructor.
     */
    public ConcepInfExogenaVO() { }
    
    
    /**
     * Constructor.
     * @param siiConcepInfExogena
     */
    public ConcepInfExogenaVO (SiiConcepInfExogena siiConcepInfExogena) {
        if (siiConcepInfExogena!=null) {
            this.cieCodigo = siiConcepInfExogena.getCieCodigo();
            this.cieNombre = siiConcepInfExogena.getCieNombre();
        }
    }


    public void setCieCodigo(Long cieCodigo) {
        this.cieCodigo = cieCodigo;
    }

    public Long getCieCodigo() {
        return cieCodigo;
    }

    public void setCieNombre(String cieNombre) {
        this.cieNombre = cieNombre;
    }

    public String getCieNombre() {
        return cieNombre;
    }

    public void setImputacionContableList(List<SiiImputacionContable> imputacionContableList) {
        this.imputacionContableList = imputacionContableList;
    }

    public List<SiiImputacionContable> getImputacionContableList() {
        return imputacionContableList;
    }
}
