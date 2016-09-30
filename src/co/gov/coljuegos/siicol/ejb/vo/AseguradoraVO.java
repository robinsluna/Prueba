package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAseguradora;

import java.util.List;

public class AseguradoraVO {
    
    private Long aseCodigo;
    private PersonaVO personaVo;
    private List<PolizaContratVO> polizaContratListVo;
    
    public AseguradoraVO() {
        
    }
    
    public AseguradoraVO(SiiAseguradora siiAseguradora) {
        this.aseCodigo = siiAseguradora.getAseCodigo();
        //Padres:
        if (siiAseguradora.getSiiPersona() != null){
            this.personaVo = new PersonaVO(siiAseguradora.getSiiPersona());
        }

    }

    public void setAseCodigo(Long aseCodigo) {
        this.aseCodigo = aseCodigo;
    }

    public Long getAseCodigo() {
        return aseCodigo;
    }


    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setPolizaContratListVo(List<PolizaContratVO> polizaContratListVo) {
        this.polizaContratListVo = polizaContratListVo;
    }

    public List<PolizaContratVO> getPolizaContratListVo() {
        return polizaContratListVo;
    }
}
