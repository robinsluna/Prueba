/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 31-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIcaPers;


/**
 * Value Object para la Actividad ICA de la Persona.
 * @author Camilo Miranda
 */
public class ActividadIcaPersVO {
    
    private String aipActivPrinc;
    private Long aipCodigo;
    
    private PersonaVO personaVo;
    private ActividadIcaVO actividadIcaVo;
    
    //Badera para deteerminar la actividad principal en el aplicativo
    private boolean actividadPrincipal;
    
    
    /**
     * Constructor.
     */
    public ActividadIcaPersVO() { }
    
    
    /**
     * Constructor.
     * @param siiActividadIcaPers - Entity.
     */
    public ActividadIcaPersVO (SiiActividadIcaPers siiActividadIcaPers) {
        if (siiActividadIcaPers!=null) {
            this.aipActivPrinc = siiActividadIcaPers.getAipActivPrinc();
            this.aipCodigo = siiActividadIcaPers.getAipCodigo();
            
            if (siiActividadIcaPers.getSiiPersona()!=null) 
                this.personaVo = new PersonaVO(siiActividadIcaPers.getSiiPersona());
            
            if (siiActividadIcaPers.getSiiActividadIca()!=null)
                this.actividadIcaVo = new ActividadIcaVO(siiActividadIcaPers.getSiiActividadIca());
        }
    }


    public void setAipActivPrinc(String aipActivPrinc) {
        this.aipActivPrinc = aipActivPrinc;
    }

    public String getAipActivPrinc() {
        return aipActivPrinc;
    }

    public void setAipCodigo(Long aipCodigo) {
        this.aipCodigo = aipCodigo;
    }

    public Long getAipCodigo() {
        return aipCodigo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setActividadIcaVo(ActividadIcaVO actividadIcaVo) {
        this.actividadIcaVo = actividadIcaVo;
    }

    public ActividadIcaVO getActividadIcaVo() {
        return actividadIcaVo;
    }

    public boolean isActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(boolean actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }
}
