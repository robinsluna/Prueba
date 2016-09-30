/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;


/**
 * Value Object para la entidad que relaciona la Responsabilidad DIAN con la Persona.
 * @author Camilo Miranda
 */
public class ResponDianPersonaVO 
{
    private Long rdpCodigo;
    
    private ResponsabilidadDianVO responsabilidadDianVo;
    private PersonaVO personaVo;
    
    
    
    /**
     * Constructor.
     */
    public ResponDianPersonaVO() { }
    
    
    /**
     * Constructor.
     * @param siiResponDianPersona
     */
    public ResponDianPersonaVO (SiiResponDianPersona siiResponDianPersona) {
        if (siiResponDianPersona!=null) {
            this.rdpCodigo = siiResponDianPersona.getRdpCodigo();
            
            if (siiResponDianPersona.getSiiPersona()!=null) {
                this.personaVo = new PersonaVO(siiResponDianPersona.getSiiPersona());
            }
            
            if (siiResponDianPersona.getSiiResponsabilidadDian()!=null) {
                this.responsabilidadDianVo = new ResponsabilidadDianVO(siiResponDianPersona.getSiiResponsabilidadDian());
            }
        }
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
