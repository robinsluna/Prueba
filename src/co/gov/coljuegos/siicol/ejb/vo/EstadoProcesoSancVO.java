package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;

import java.util.List;


/**
 * Value Object para el Estado de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class EstadoProcesoSancVO 
{
    private Long epsCodigo;
    private String epsNombre;
    
    private List<ProcesoSancionatorioVO> procesoSancionatorioList;
    
    
    
    /**
     * Constructor.
     */
    public EstadoProcesoSancVO() { }
    
    
    /**
     * Constructor.
     * @param siiEstadoProcesoSanc - Entity.
     */
    public EstadoProcesoSancVO (SiiEstadoProcesoSanc siiEstadoProcesoSanc) 
    {
        if (siiEstadoProcesoSanc!=null) {
            this.epsCodigo = siiEstadoProcesoSanc.getEpsCodigo();
            this.epsNombre = siiEstadoProcesoSanc.getEpsNombre();
        }
    }


    public void setEpsCodigo(Long epsCodigo) {
        this.epsCodigo = epsCodigo;
    }

    public Long getEpsCodigo() {
        return epsCodigo;
    }

    public void setEpsNombre(String epsNombre) {
        this.epsNombre = epsNombre;
    }

    public String getEpsNombre() {
        return epsNombre;
    }

    public void setProcesoSancionatorioList(List<ProcesoSancionatorioVO> procesoSancionatorioList) {
        this.procesoSancionatorioList = procesoSancionatorioList;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioList() {
        return procesoSancionatorioList;
    }
}
