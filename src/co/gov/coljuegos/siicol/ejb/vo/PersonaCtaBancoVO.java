/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-04-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;


/**
 * Value Object para la relaci&oacute;n de Persona con Cuenta Banco.
 * @author Camilo Miranda
 */
public class PersonaCtaBancoVO {
    
    private Long pcbCodigo;
    
    private CuentaBancoPersonaVO cuentaBancoPersonaVo;
    private PersonaVO personaVo;
    
    
    
    /**
     * Constructor.
     */
    public PersonaCtaBancoVO() { }
    
    
    /**
     * Constructor.
     * @param siiPersonaCtaBanco - Entidad.
     */
    public PersonaCtaBancoVO (SiiPersonaCtaBanco siiPersonaCtaBanco) {
        if (siiPersonaCtaBanco!=null) {
            this.pcbCodigo = siiPersonaCtaBanco.getPcbCodigo();
            
            if (siiPersonaCtaBanco.getSiiCuentaBancoPersona()!=null) {
                this.cuentaBancoPersonaVo = new CuentaBancoPersonaVO(siiPersonaCtaBanco.getSiiCuentaBancoPersona());
            }
            
            if (siiPersonaCtaBanco.getSiiPersona()!=null) {
                this.personaVo = new PersonaVO(siiPersonaCtaBanco.getSiiPersona());
            }
        }
    }


    public void setPcbCodigo(Long pcbCodigo) {
        this.pcbCodigo = pcbCodigo;
    }

    public Long getPcbCodigo() {
        return pcbCodigo;
    }

    public void setCuentaBancoPersonaVo(CuentaBancoPersonaVO cuentaBancoPersonaVo) {
        this.cuentaBancoPersonaVo = cuentaBancoPersonaVo;
    }

    public CuentaBancoPersonaVO getCuentaBancoPersonaVo() {
        return cuentaBancoPersonaVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
}
