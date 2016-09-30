/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;

import java.util.List;

public class EnteTerritorialVO {
    
    private Long etiCodigo;
    private UbicacionVO ubicacionVo;
    private PersonaVO personaVo;
    private Integer etiPoblacion;
    private Integer etiPoblacionActual;
    
    private List<DistribucionUbicaVO> distribucionUbicaList;
    private List<DetalleDistribVO> detalleDistribList;
    
    
    
    /**
     * Constructor.
     */
    public EnteTerritorialVO() { }
    
    
    /**
     * Constructor.
     * @param siiEnteTerritorial
     */
    public EnteTerritorialVO(SiiEnteTerritorial siiEnteTerritorial) {
        this.setEtiCodigo(siiEnteTerritorial.getEtiCodigo());
        this.setEtiPoblacion(siiEnteTerritorial.getEtiPoblacion());
        this.setEtiPoblacionActual(siiEnteTerritorial.getEtiPoblacP2014());
        
        //Padres
        if(siiEnteTerritorial.getSiiPersona()!= null)
            this.personaVo= new  PersonaVO(siiEnteTerritorial.getSiiPersona());
        if(siiEnteTerritorial.getSiiUbicacion()!= null)
            this.ubicacionVo= new UbicacionVO(siiEnteTerritorial.getSiiUbicacion()); 
    }


    public void setEtiCodigo(Long etiCodigo) {
        this.etiCodigo = etiCodigo;
    }

    public Long getEtiCodigo() {
        return etiCodigo;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }


    public void setEtiPoblacion(Integer etiPoblacion) {
        this.etiPoblacion = etiPoblacion;
    }

    public Integer getEtiPoblacion() {
        return etiPoblacion;
    }

    public void setDistribucionUbicaList(List<DistribucionUbicaVO> distribucionUbicaList) {
        this.distribucionUbicaList = distribucionUbicaList;
    }

    public List<DistribucionUbicaVO> getDistribucionUbicaList() {
        return distribucionUbicaList;
    }

    public void setDetalleDistribList(List<DetalleDistribVO> detalleDistribList) {
        this.detalleDistribList = detalleDistribList;
    }

    public List<DetalleDistribVO> getDetalleDistribList() {
        return detalleDistribList;
    }

    public Integer getEtiPoblacionActual() {
        return etiPoblacionActual;
    }

    public void setEtiPoblacionActual(Integer etiPoblacionActual) {
        this.etiPoblacionActual = etiPoblacionActual;
    }
}
