/*
 * SISTEMA	: SIICOL
 * MÓDULO	: WebServices Operador
 * AUTOR	: Gatopardo
 * FECHA	: 04-06-2014
 */

package co.gov.coljuegos.siicol.ejb.wsvo;

import java.util.Date;
import java.util.List;


public class CuotaOperadorWSVO {
    
    public Integer numeroCuota;
    public Integer mesCodigo;
    public Date fechaCuota;
    public String numeroResolucion;
    public Date fechaResolucion;
    public String contrato;
    public Date fechaEjecutoria;
    public List<ConceptoCuotaWSVO> listaConceptosCuota;
    
    public CuotaOperadorWSVO() {
    }
}
