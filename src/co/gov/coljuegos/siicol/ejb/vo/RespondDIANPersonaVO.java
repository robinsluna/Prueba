package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;


public class RespondDIANPersonaVO {
    
    private Long rdpCodigo;
    private ResponsabilidadDianVO responsabilidadDianVo;
    private PersonaVO personaVo;
    
    public RespondDIANPersonaVO(SiiResponDianPersona siiResponDIANPersona){
        if (siiResponDIANPersona != null){            
            this.rdpCodigo = siiResponDIANPersona.getRdpCodigo();
            
            if (siiResponDIANPersona.getSiiPersona() != null){
                this.personaVo = new PersonaVO(siiResponDIANPersona.getSiiPersona());
            }
            
            if (siiResponDIANPersona.getSiiResponsabilidadDian() != null)
            this.responsabilidadDianVo = new ResponsabilidadDianVO(siiResponDIANPersona.getSiiResponsabilidadDian());
        }
    }
    
    public RespondDIANPersonaVO() {
     
    }

    public void setRdpCodigo(Long rdpCodigo) {
        this.rdpCodigo = rdpCodigo;
    }

    public Long getRdpCodigo() {
        return rdpCodigo;
    }

    public void setResponsabilidadDianVo(ResponsabilidadDianVO responsabilidadDianVo) {
        this.responsabilidadDianVo = responsabilidadDianVo;
    }

    public ResponsabilidadDianVO getResponsabilidadDianVo() {
        return responsabilidadDianVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
    
}
