/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoRetenc;

import java.util.List;


/**
 * Value Object para el Grupo de Retenci&oacute;n.
 * @author Camilo Miranda
 */
public class GrupoRetencVO 
{
    private Long greCodigo;
    private String greNombre;
    
    private List<TipoRetencionVO> tipoRetencionList;
    //private List<ReglaImpuestosVO> reglaImpuestosList;
    
    
    
    /**
     * Constructor.
     */
    public GrupoRetencVO() { }
    
    
    /**
     * Constructor.
     * @param siiGrupoRetenc
     */
    public GrupoRetencVO (SiiGrupoRetenc siiGrupoRetenc) {
        if (siiGrupoRetenc!=null) {
            this.greCodigo = siiGrupoRetenc.getGreCodigo();
            this.greNombre = siiGrupoRetenc.getGreNombre();
        }
    }


    public void setGreCodigo(Long greCodigo) {
        this.greCodigo = greCodigo;
    }

    public Long getGreCodigo() {
        return greCodigo;
    }

    public void setGreNombre(String greNombre) {
        this.greNombre = greNombre;
    }

    public String getGreNombre() {
        return greNombre;
    }

    public void setTipoRetencionList(List<TipoRetencionVO> tipoRetencionList) {
        this.tipoRetencionList = tipoRetencionList;
    }

    public List<TipoRetencionVO> getTipoRetencionList() {
        return tipoRetencionList;
    }
}
