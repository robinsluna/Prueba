/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-03-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoNomina;

import java.util.List;


/**
 * Value Object para el manejo de Conceptos de N&oacute;mina.
 * @author Camilo Miranda
 */
public class ConceptoNominaVO 
{
    private String cnoActivo;
    private String cnoCodigo;
    private String cnoNombre;
    private String cnoRubro;
    private String cnoReintegro;
    
    private List<DetalleContNominaVO> listaDetalleContNomina;
    
    
    /**
     * Constructor.
     */
    public ConceptoNominaVO() { }
    
    
    /**
     * Constructor.
     * @param siiConceptoNomina - Entity.
     */
    public ConceptoNominaVO (SiiConceptoNomina siiConceptoNomina) 
    {
        if (siiConceptoNomina!=null) {
            this.cnoActivo = siiConceptoNomina.getCnoActivo();
            this.cnoCodigo = siiConceptoNomina.getCnoCodigo();
            this.cnoNombre = siiConceptoNomina.getCnoNombre();
            this.cnoRubro = siiConceptoNomina.getCnoRubro();
            this.cnoReintegro = siiConceptoNomina.getCnoReintegro();
        }
    }


    public void setCnoActivo(String cnoActivo) {
        this.cnoActivo = cnoActivo;
    }

    public String getCnoActivo() {
        return cnoActivo;
    }

    public void setCnoCodigo(String cnoCodigo) {
        this.cnoCodigo = cnoCodigo;
    }

    public String getCnoCodigo() {
        return cnoCodigo;
    }

    public void setCnoNombre(String cnoNombre) {
        this.cnoNombre = cnoNombre;
    }

    public String getCnoNombre() {
        return cnoNombre;
    }

    public void setListaDetalleContNomina(List<DetalleContNominaVO> listaDetalleContNomina) {
        this.listaDetalleContNomina = listaDetalleContNomina;
    }

    public List<DetalleContNominaVO> getListaDetalleContNomina() {
        return listaDetalleContNomina;
    }

    public void setCnoRubro(String cnoRubro) {
        this.cnoRubro = cnoRubro;
    }

    public String getCnoRubro() {
        return cnoRubro;
    }

    public void setCnoReintegro(String cnoReintegro) {
        this.cnoReintegro = cnoReintegro;
    }

    public String getCnoReintegro() {
        return cnoReintegro;
    }

    
    
    
    /**
     * Obtiene el Estado del Concepto de N&oacute;mina.
     * @return nombre[acoActivo].
     */
    public String getEstado () 
    {
        String estado = null;
        if (cnoActivo!=null) {
            estado = EnumEstado.getNombreById(cnoActivo);
        }
        return (estado);
    }
    
    
    /**
     * Obtiene el nombre asociado al Indicador de Reintegro.
     * @return nombre[cnoReintegro].
     */
    public String getIndicadorReintegro () {
        String reintegro = null;
        if (cnoReintegro!=null) {
            reintegro = EnumDecision.getNombreById(cnoReintegro);
        }
        return (reintegro);
    }
}
