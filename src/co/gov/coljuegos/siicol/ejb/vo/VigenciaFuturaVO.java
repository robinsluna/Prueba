/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVigenciaFutura;

import java.util.Date;
import java.util.List;


/**
 * Value Object para el manejo de Vigencias Futuras.
 * @author Camilo Miranda
 */
public class VigenciaFuturaVO 
{
    private Long vfuCodigo;
    private String vfuEstado;
    private Date vfuFechaOficioAut;
    private String vfuNumOficioAut;
    private Integer vfuVigencia;
    
    private List<DetRubroVigenFuturaVO> detRubroVigenFuturaList;
    
    
    /**
     * Constructor.
     */
    public VigenciaFuturaVO() { }
    
    
    /**
     * Constructor.
     * @param siiVigenciaFutura - Entity.
     */
    public VigenciaFuturaVO (SiiVigenciaFutura siiVigenciaFutura) 
    {
        if (siiVigenciaFutura!=null) {
            this.vfuCodigo = siiVigenciaFutura.getVfuCodigo();
            this.vfuEstado = siiVigenciaFutura.getVfuEstado();
            this.vfuFechaOficioAut = siiVigenciaFutura.getVfuFechaOficioAut();
            this.vfuNumOficioAut = siiVigenciaFutura.getVfuNumOficioAut();
            this.vfuVigencia = siiVigenciaFutura.getVfuVigencia();
        }
    }

    
    
    public void setVfuCodigo(Long vfuCodigo) {
        this.vfuCodigo = vfuCodigo;
    }

    public Long getVfuCodigo() {
        return vfuCodigo;
    }

    public void setVfuEstado(String vfuEstado) {
        this.vfuEstado = vfuEstado;
    }

    public String getVfuEstado() {
        return vfuEstado;
    }

    public void setVfuFechaOficioAut(Date vfuFechaOficioAut) {
        this.vfuFechaOficioAut = vfuFechaOficioAut;
    }

    public Date getVfuFechaOficioAut() {
        return vfuFechaOficioAut;
    }

    public void setVfuNumOficioAut(String vfuNumOficioAut) {
        this.vfuNumOficioAut = vfuNumOficioAut;
    }

    public String getVfuNumOficioAut() {
        return vfuNumOficioAut;
    }

    public void setVfuVigencia(Integer vfuVigencia) {
        this.vfuVigencia = vfuVigencia;
    }

    public Integer getVfuVigencia() {
        return vfuVigencia;
    }

    public void setDetRubroVigenFuturaList(List<DetRubroVigenFuturaVO> detRubroVigenFuturaList) {
        this.detRubroVigenFuturaList = detRubroVigenFuturaList;
    }

    public List<DetRubroVigenFuturaVO> getDetRubroVigenFuturaList() {
        return detRubroVigenFuturaList;
    }
    
    
    
    /**
     * Obtiene el nombre asociado al Estado de la Vigencia Futura.
     * @return getNombreById(this.vfuEstado)
     */
    public String getEstado () 
    {
        return ( vfuEstado!=null ? EnumEstado.getNombreById(vfuEstado) : null );
    }
}
