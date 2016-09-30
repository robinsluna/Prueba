/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;

import java.math.BigDecimal;

import java.util.List;


/**
 * Value Object para el Tipo de Retenci&oacute;n.
 * @author Camilo Miranda
 */
public class TipoRetencionVO 
{
    private String treCodigo;
    private String treNomClasific;
    private String treObservaciones;
    private Integer treRenglon;
    private BigDecimal treTarifa;
    private String treBaseUvt;
    
    private GrupoRetencVO grupoRetenc;
    private ConceptoRetenVO conceptoReten;
    private CuentasContablesVO cuentasContables;
    
    //private List<ReglaImpuestosVO> reglaImpuestosList;
    private List<PersonaVO> personaVentasList;
    private List<PersonaVO> personaRentasList;
    private List<ImputacionContableVO> imputacionContVentaList;
    private List<ImputacionContableVO> imputacionContRentaList;
    private List<ObligacionConceptoVO> obligacionConceptoRentaList;
    private List<ObligacionConceptoVO> obligacionConceptoIvaList;
    
    
    
    /**
     * Constructor.
     * @param siiTipoRetencion - Entity.
     */
    public TipoRetencionVO(SiiTipoRetencion siiTipoRetencion) {
        if (siiTipoRetencion!=null) {
            this.treCodigo = siiTipoRetencion.getTreCodigo();
            this.treNomClasific = siiTipoRetencion.getTreNomClasific();
            this.treObservaciones = siiTipoRetencion.getTreObservaciones();
            this.treRenglon = siiTipoRetencion.getTreRenglon();
            this.treTarifa = siiTipoRetencion.getTreTarifa();
            this.treBaseUvt = siiTipoRetencion.getTreBaseUvt();
            
            if (siiTipoRetencion.getSiiCuentasContables() != null) {
                this.cuentasContables = new CuentasContablesVO(siiTipoRetencion.getSiiCuentasContables());
            }
            
            if (siiTipoRetencion.getSiiConceptoReten() != null) {
                this.conceptoReten = new ConceptoRetenVO(siiTipoRetencion.getSiiConceptoReten());
            }
            
            if (siiTipoRetencion.getSiiGrupoRetenc() != null) {
                this.grupoRetenc = new GrupoRetencVO(siiTipoRetencion.getSiiGrupoRetenc());
            }
        }
    }
    
    public TipoRetencionVO() {
    }

    public void setTreCodigo(String treCodigo) {
        this.treCodigo = treCodigo;
    }

    public String getTreCodigo() {
        return treCodigo;
    }

    public void setTreNomClasific(String treNomClasific) {
        this.treNomClasific = treNomClasific;
    }

    public String getTreNomClasific() {
        return treNomClasific;
    }

    public void setTreObservaciones(String treObservaciones) {
        this.treObservaciones = treObservaciones;
    }

    public String getTreObservaciones() {
        return treObservaciones;
    }

    public void setTreRenglon(Integer treRenglon) {
        this.treRenglon = treRenglon;
    }

    public Integer getTreRenglon() {
        return treRenglon;
    }

    public void setTreTarifa(BigDecimal treTarifa) {
        this.treTarifa = treTarifa;
    }

    public BigDecimal getTreTarifa() {
        return treTarifa;
    }

    public void setCuentasContables(CuentasContablesVO cuentasContables) {
        this.cuentasContables = cuentasContables;
    }

    public CuentasContablesVO getCuentasContables() {
        return cuentasContables;
    }


    public void setPersonaVentasList(List<PersonaVO> personaVentasList) {
        this.personaVentasList = personaVentasList;
    }

    public List<PersonaVO> getPersonaVentasList() {
        return personaVentasList;
    }

    public void setPersonaRentasList(List<PersonaVO> personaRentasList) {
        this.personaRentasList = personaRentasList;
    }

    public List<PersonaVO> getPersonaRentasList() {
        return personaRentasList;
    }


    public void setConceptoReten(ConceptoRetenVO conceptoReten) {
        this.conceptoReten = conceptoReten;
    }

    public ConceptoRetenVO getConceptoReten() {
        return conceptoReten;
    }

    public void setGrupoRetenc(GrupoRetencVO grupoRetenc) {
        this.grupoRetenc = grupoRetenc;
    }

    public GrupoRetencVO getGrupoRetenc() {
        return grupoRetenc;
    }

    public void setImputacionContVentaList(List<ImputacionContableVO> imputacionContVentaList) {
        this.imputacionContVentaList = imputacionContVentaList;
    }

    public List<ImputacionContableVO> getImputacionContVentaList() {
        return imputacionContVentaList;
    }

    public void setImputacionContRentaList(List<ImputacionContableVO> imputacionContRentaList) {
        this.imputacionContRentaList = imputacionContRentaList;
    }

    public List<ImputacionContableVO> getImputacionContRentaList() {
        return imputacionContRentaList;
    }

    public void setObligacionConceptoRentaList(List<ObligacionConceptoVO> obligacionConceptoRentaList) {
        this.obligacionConceptoRentaList = obligacionConceptoRentaList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoRentaList() {
        return obligacionConceptoRentaList;
    }

    public void setObligacionConceptoIvaList(List<ObligacionConceptoVO> obligacionConceptoIvaList) {
        this.obligacionConceptoIvaList = obligacionConceptoIvaList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoIvaList() {
        return obligacionConceptoIvaList;
    }

    public void setTreBaseUvt(String treBaseUvt) {
        this.treBaseUvt = treBaseUvt;
    }

    public String getTreBaseUvt() {
        return treBaseUvt;
    }
}
