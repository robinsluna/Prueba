/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 31-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIca;

import java.math.BigDecimal;

import java.util.List;


/**
 * Value Object para la Actividad ICA.
 * @author Camilo Miranda
 */
public class ActividadIcaVO {
    
    private Integer aicAgrupacion;
    private String aicCodigo;
    private String aicDescripcion;
    private BigDecimal aicTarifa;
    
    private CuentasContablesVO cuentasContablesVo;
    
    private List<ActividadIcaPersVO> actividadIcaPersList;
    private List<ObligacionConceptoVO> obligacionConceptoList;
    
    
    /**
     * Constructor.
     */
    public ActividadIcaVO() { }
    
    
    /**
     * Constructor.
     * @param siiActividadIca - Entity.
     */
    public ActividadIcaVO (SiiActividadIca siiActividadIca) {
        if (siiActividadIca!=null) {
            this.aicAgrupacion = siiActividadIca.getAicAgrupacion();
            this.aicCodigo = siiActividadIca.getAicCodigo();
            this.aicDescripcion = siiActividadIca.getAicDescripcion();
            this.aicTarifa = siiActividadIca.getAicTarifa();
            
            if (siiActividadIca.getSiiCuentasContables()!=null) {
                this.cuentasContablesVo = new CuentasContablesVO(siiActividadIca.getSiiCuentasContables());
            }
        }
    }


    public void setAicAgrupacion(Integer aicAgrupacion) {
        this.aicAgrupacion = aicAgrupacion;
    }

    public Integer getAicAgrupacion() {
        return aicAgrupacion;
    }

    public void setAicCodigo(String aicCodigo) {
        this.aicCodigo = aicCodigo;
    }

    public String getAicCodigo() {
        return aicCodigo;
    }

    public void setAicDescripcion(String aicDescripcion) {
        this.aicDescripcion = aicDescripcion;
    }

    public String getAicDescripcion() {
        return aicDescripcion;
    }

    public void setAicTarifa(BigDecimal aicTarifa) {
        this.aicTarifa = aicTarifa;
    }

    public BigDecimal getAicTarifa() {
        return aicTarifa;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setActividadIcaPersList(List<ActividadIcaPersVO> actividadIcaPersList) {
        this.actividadIcaPersList = actividadIcaPersList;
    }

    public List<ActividadIcaPersVO> getActividadIcaPersList() {
        return actividadIcaPersList;
    }

    public void setObligacionConceptoList(List<ObligacionConceptoVO> obligacionConceptoList) {
        this.obligacionConceptoList = obligacionConceptoList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoList() {
        return obligacionConceptoList;
    }
}
