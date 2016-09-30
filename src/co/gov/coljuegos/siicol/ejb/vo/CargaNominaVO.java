/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-05-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaNomina;

import java.util.ArrayList;
import java.util.List;


/**
 * Value Object para el Cargue de archivos de N&oacute;mina.
 * @author Camilo Miranda
 */
public class CargaNominaVO {
    
    private Long cnoCodigo;
    private String cnoNombreArch;
    private String cnoDescripcion;
    
    private ArchivoFisicoVO archivoFisicoVo;
    
    private List<ObligacionVO> obligacionList;
    private List<DetalleContNominaVO> detalleContNominaList;
    
    
    
    /**
     * Constructor.
     */
    public CargaNominaVO() { }
    
    
    /**
     * Constructor.
     * @param siiCargaNomina - Entity.
     */
    public CargaNominaVO (SiiCargaNomina siiCargaNomina) {
        if (siiCargaNomina!=null) {
            this.cnoCodigo = siiCargaNomina.getCnoCodigo();
            this.cnoNombreArch = siiCargaNomina.getCnoNombreArch();
            this.cnoDescripcion = siiCargaNomina.getCnoDescripcion();
            
            if (siiCargaNomina.getSiiArchivoFisico()!=null)
                this.archivoFisicoVo = new ArchivoFisicoVO(siiCargaNomina.getSiiArchivoFisico());
        }
    }


    public void setCnoCodigo(Long cnoCodigo) {
        this.cnoCodigo = cnoCodigo;
    }

    public Long getCnoCodigo() {
        return cnoCodigo;
    }

    public void setCnoNombreArch(String cnoNombreArch) {
        this.cnoNombreArch = cnoNombreArch;
    }

    public String getCnoNombreArch() {
        return cnoNombreArch;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setObligacionList(List<ObligacionVO> obligacionList) {
        this.obligacionList = obligacionList;
    }

    public List<ObligacionVO> getObligacionList() {
        return obligacionList;
    }

    public void setCnoDescripcion(String cnoDescripcion) {
        this.cnoDescripcion = cnoDescripcion;
    }

    public String getCnoDescripcion() {
        return cnoDescripcion;
    }

    public void setDetalleContNominaList(List<DetalleContNominaVO> detalleContNominaList) {
        this.detalleContNominaList = detalleContNominaList;
    }

    public List<DetalleContNominaVO> getDetalleContNominaList() {
        return detalleContNominaList;
    }

    
    
    
    /**
     * Adiciona un registro al listado de Obligaciones.
     * @param obligacionVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addObligacion (ObligacionVO obligacionVo) 
    {
        boolean exitoso = false;
        
        if (obligacionList==null)
            obligacionList = new ArrayList<ObligacionVO>();
        
        exitoso = obligacionList.add(obligacionVo);
        
        if (exitoso)
            obligacionVo.setCargaNominaVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado Obligaciones.
     * @param obligacionVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeObligacion (ObligacionVO obligacionVo) {
        boolean exitoso = false;
        
        if (obligacionList!=null) {
            exitoso = obligacionList.remove(obligacionVo);
            
            if (exitoso)
                obligacionVo.setCargaNominaVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro al listado de Detalles de N&oacute;mina.
     * @param detalleContNominaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDetalleContNomina (DetalleContNominaVO detalleContNominaVo) 
    {
        boolean exitoso = false;
        
        if (detalleContNominaList==null)
            detalleContNominaList = new ArrayList<DetalleContNominaVO>();
        
        exitoso = detalleContNominaList.add(detalleContNominaVo);
        
        if (exitoso)
            detalleContNominaVo.setCargaNominaVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado de Detalles de N&oacute;mina.
     * @param detalleContNominaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDetalleContNomina (DetalleContNominaVO detalleContNominaVo) {
        boolean exitoso = false;
        
        if (detalleContNominaList!=null) {
            exitoso = detalleContNominaList.remove(detalleContNominaVo);
            
            if (exitoso)
                detalleContNominaVo.setCargaNominaVo(null);
        }
        
        return (exitoso);
    }
}
