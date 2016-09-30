/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 28-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResDecDes;

import java.util.ArrayList;
import java.util.List;

/**
 * Value object que gestiona los estados de los Tr�mites de Resoluci�n de Decomiso y Destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

public class EstadoTramResDecDesVO {

    private Long etdCodigo;
    private String etdNombre;

    private List<TramiteResolDecDesVO> tramiteResolDecDesListVo;

    /**
     * Constructor.
     * @param siiEstadoTramResDecDes
     */

    public EstadoTramResDecDesVO(SiiEstadoTramResDecDes siiEstadoTramResDecDes) {
        if (siiEstadoTramResDecDes != null) {
            this.etdCodigo = siiEstadoTramResDecDes.getEtdCodigo();
            this.etdNombre = siiEstadoTramResDecDes.getEtdNombre();
        }
    }

    /**
     * Agregar Tr�mite de Resoluci�n de Decomiso y Destrucci�n
     * @param tramiteResolDecDesVo
     * @return exitoso - boolean
     */
    
    public boolean addTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) {
        boolean exitoso = false;

        if (tramiteResolDecDesListVo == null)
            tramiteResolDecDesListVo = new ArrayList<TramiteResolDecDesVO>();

        exitoso = tramiteResolDecDesListVo.add(tramiteResolDecDesVo);

        if (exitoso)
            tramiteResolDecDesVo.setEstadoTramResDecDesVo(this);

        return (exitoso);
    }


    /**
     * Elimina un registro del listado TramiteResolDecDesVO.
     * @param tramiteResolDecDesVo - Objeto a adicionar.
     * @return �Operaci&oacute;n exitosa?
     */
    
    public boolean removeTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) {
        boolean exitoso = false;

        if (tramiteResolDecDesListVo != null) {
            exitoso = tramiteResolDecDesListVo.remove(tramiteResolDecDesVo);

            if (exitoso)
                tramiteResolDecDesVo.setEstadoTramResDecDesVo(null);
        }

        return (exitoso);
    }

    public void setEtdCodigo(Long etdCodigo) {
        this.etdCodigo = etdCodigo;
    }

    public Long getEtdCodigo() {
        return etdCodigo;
    }

    public void setEtdNombre(String etdNombre) {
        this.etdNombre = etdNombre;
    }

    public String getEtdNombre() {
        return etdNombre;
    }

    public void setTramiteResolDecDesListVo(List<TramiteResolDecDesVO> tramiteResolDecDesListVo) {
        this.tramiteResolDecDesListVo = tramiteResolDecDesListVo;
    }

    public List<TramiteResolDecDesVO> getTramiteResolDecDesListVo() {
        return tramiteResolDecDesListVo;
    }

}
