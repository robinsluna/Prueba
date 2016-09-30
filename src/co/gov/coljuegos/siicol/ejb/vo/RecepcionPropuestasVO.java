/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para la Recepci&oacute;n de Propuestas.
 * @author Camilo Miranda
 */
public class RecepcionPropuestasVO 
{
    /** C&oacute;digo */
    private Long rprCodigo;
    /** Estado del Acta */
    private String rprEstadoActa;
    /** Fecha del Acta */
    private Date rprFechaActa;
    /** N&uacute;mero del Acta */
    private Long rprNumActa;
    /** Archivo F&iacute;sico */
    private ArchivoFisicoVO archivoFisico;
    /** Listado de Propuestas Recibidas */
    private List<PropuestaRecibVO> propuestaRecibList;
    /** Proceso de Contrataci&oacute;n */
    private ProcesoContratacionVO procesoContratacion;
    
    
    
    /**
     * Constructor.
     */
    public RecepcionPropuestasVO () { }
    
    
    /**
     * Constructor.
     * @param siiRecepcionPropuestas - Entity
     */
    public RecepcionPropuestasVO (SiiRecepcionPropuestas siiRecepcionPropuestas) 
    {
        this.rprCodigo = siiRecepcionPropuestas.getRprCodigo();
        this.rprEstadoActa = siiRecepcionPropuestas.getRprEstadoActa();
        this.rprFechaActa = siiRecepcionPropuestas.getRprFechaActa();
        this.rprNumActa = siiRecepcionPropuestas.getRprNumActa();
        
        if (siiRecepcionPropuestas.getSiiArchivoFisico() != null)
            this.archivoFisico = new ArchivoFisicoVO(siiRecepcionPropuestas.getSiiArchivoFisico());
        
        if (siiRecepcionPropuestas.getSiiProcesoContratacion() != null)
            this.procesoContratacion = new ProcesoContratacionVO(siiRecepcionPropuestas.getSiiProcesoContratacion());
        
        /*
        // adicionar los value object relacionados a cada propuesta recibida, contenida en la lista de entidades
        if (siiRecepcionPropuestas.getSiiPropuestaRecibList1() != null) {
            this.propuestaRecibList = new ArrayList<PropuestaRecibVO>();
            
            for (SiiPropuestaRecib siiPR: siiRecepcionPropuestas.getSiiPropuestaRecibList1()) {
                addPropuestaRecibVO(new PropuestaRecibVO(siiPR));
            }
        }
        */
    }


    public void setRprCodigo(Long rprCodigo) {
        this.rprCodigo = rprCodigo;
    }

    public Long getRprCodigo() {
        return rprCodigo;
    }

    public void setRprEstadoActa(String rprEstadoActa) {
        this.rprEstadoActa = rprEstadoActa;
    }

    public String getRprEstadoActa() {
        return rprEstadoActa;
    }

    public void setRprFechaActa(Date rprFechaActa) {
        this.rprFechaActa = rprFechaActa;
    }

    public Date getRprFechaActa() {
        return rprFechaActa;
    }

    public void setRprNumActa(Long rprNumActa) {
        this.rprNumActa = rprNumActa;
    }

    public Long getRprNumActa() {
        return rprNumActa;
    }

    public void setArchivoFisico(ArchivoFisicoVO archivoFisico) {
        this.archivoFisico = archivoFisico;
    }

    public ArchivoFisicoVO getArchivoFisico() {
        return archivoFisico;
    }

    public void setPropuestaRecibList(List<PropuestaRecibVO> propuestaRecibList) {
        this.propuestaRecibList = propuestaRecibList;
    }

    public List<PropuestaRecibVO> getPropuestaRecibList() {
        return propuestaRecibList;
    }
    
    /**
     * Adiciona una PropuestaRecibVO.
     * @param propuestaRecibVO
     * @return adicionado?
     */
    public boolean addPropuestaRecibVO (PropuestaRecibVO propuestaRecibVO) 
    {
        boolean adicionado = false;
        
        if (propuestaRecibList == null) 
            propuestaRecibList = new ArrayList<PropuestaRecibVO>();
        
        if (propuestaRecibVO!=null) {
            adicionado = getPropuestaRecibList().add(propuestaRecibVO);
            
            if (adicionado)
                propuestaRecibVO.setRecepcionPropuestas(this);
        }
        return (adicionado);
    }
    
    /**
     * Elimina una PropuestaRecibVO.
     * @param propuestaRecibVO
     * @return eliminado?
     */
    public boolean removePropuestaRecibVO (PropuestaRecibVO propuestaRecibVO) 
    {
        boolean eliminado = false;
        if (propuestaRecibVO != null && propuestaRecibList != null) {
            eliminado = getPropuestaRecibList().remove(propuestaRecibVO);
            
            if (eliminado)
                propuestaRecibVO.setRecepcionPropuestas(null);
        }
        return (eliminado);
    }


    public void setProcesoContratacion(ProcesoContratacionVO procesoContratacion) {
        this.procesoContratacion = procesoContratacion;
    }

    public ProcesoContratacionVO getProcesoContratacion() {
        return procesoContratacion;
    }
    
    
    /**
     * Obtiene el nombre del Estado a partir de su ID.
     * @return
     */
    public String getNombreEstadoActa () 
    {
        String nombre = null;
        
        if (rprEstadoActa != null) {
            EnumEstado[] estados = EnumEstado.values();
            for (int i=0; i < estados.length && nombre == null; i++) {
                if (estados[i].getId().equals(rprEstadoActa)) {
                    nombre = estados[i].getNombre();
                }
                
            }
        }
        
        return (nombre);
    }
}
