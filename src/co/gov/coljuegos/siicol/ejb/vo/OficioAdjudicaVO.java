/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContratoProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica;

import java.util.Date;
import java.util.List;


/**
 * Value Object para el Oficio de Adjudicaci&oacute;n.
 * @author Camilo Miranda
 */
public class OficioAdjudicaVO 
{
    private Long oadCodigo;
    private Integer oadConsecContr;
    private String oadEstado;
    private Date oadFechaReg;
    private ProcesoContratacionVO procesoContratacion;
    private ProveedorVO proveedor;
    private String oadTipoContr;
    private Integer oadVigenciaContr;
    private List<ContratoProveedorVO> contratoProveedorList;

    
    
    /**
     * Constructor.
     */
    public OficioAdjudicaVO() { }
    
    
    /**
     * Constructor.
     * @param siiOficioAdjudica - Entity
     */
    public OficioAdjudicaVO (SiiOficioAdjudica siiOficioAdjudica) 
    {
        this.oadCodigo = siiOficioAdjudica.getOadCodigo();
        this.oadEstado = siiOficioAdjudica.getOadEstado();
        this.oadFechaReg = siiOficioAdjudica.getOadFechaReg();
        this.oadConsecContr = siiOficioAdjudica.getOadConsecContr();
        this.oadTipoContr = siiOficioAdjudica.getOadTipoContr();
        this.oadVigenciaContr = siiOficioAdjudica.getOadVigenciaContr();
        
        if (siiOficioAdjudica.getSiiProcesoContratacion() != null)
            this.procesoContratacion = new ProcesoContratacionVO(siiOficioAdjudica.getSiiProcesoContratacion());
        
        if (siiOficioAdjudica.getSiiProveedor() != null)
            this.proveedor = new ProveedorVO(siiOficioAdjudica.getSiiProveedor());
    }

    
    
    public void setOadCodigo(Long oadCodigo) {
        this.oadCodigo = oadCodigo;
    }

    public Long getOadCodigo() {
        return oadCodigo;
    }

    public void setOadEstado(String oadEstado) {
        this.oadEstado = oadEstado;
    }

    public String getOadEstado() {
        return oadEstado;
    }

    public void setOadFechaReg(Date oadFechaReg) {
        this.oadFechaReg = oadFechaReg;
    }

    public Date getOadFechaReg() {
        return oadFechaReg;
    }

    public void setProcesoContratacion(ProcesoContratacionVO procesoContratacion) {
        this.procesoContratacion = procesoContratacion;
    }

    public ProcesoContratacionVO getProcesoContratacion() {
        return procesoContratacion;
    }

    public void setProveedor(ProveedorVO proveedor) {
        this.proveedor = proveedor;
    }

    public ProveedorVO getProveedor() {
        return proveedor;
    }

    public void setOadConsecContr(Integer oadConsecContr) {
        this.oadConsecContr = oadConsecContr;
    }

    public Integer getOadConsecContr() {
        return oadConsecContr;
    }

    public void setOadTipoContr(String oadTipoContr) {
        this.oadTipoContr = oadTipoContr;
    }

    public String getOadTipoContr() {
        return oadTipoContr;
    }

    public void setOadVigenciaContr(Integer oadVigenciaContr) {
        this.oadVigenciaContr = oadVigenciaContr;
    }

    public Integer getOadVigenciaContr() {
        return oadVigenciaContr;
    }

    public void setContratoProveedorList(List<ContratoProveedorVO> contratoProveedorList) {
        this.contratoProveedorList = contratoProveedorList;
    }

    public List<ContratoProveedorVO> getContratoProveedorList() {
        return contratoProveedorList;
    }
}
