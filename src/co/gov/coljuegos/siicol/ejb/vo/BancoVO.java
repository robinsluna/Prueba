/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;

public class BancoVO {
    
    private String banCodigo;
    private String banNombre;
    private PersonaVO persona;
    
    public BancoVO(SiiBanco siiBanco ) {
        if(siiBanco !=null){
            this.setBanCodigo(siiBanco.getBanCodigo());
            this.setBanNombre(siiBanco.getBanNombre());
        }
        
        if(siiBanco.getSiiPersona() != null )
           this.persona=new PersonaVO(siiBanco.getSiiPersona());
        
    }
   
   
    public BancoVO() {
    
    }


    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setPersona(PersonaVO persona) {
        this.persona = persona;
    }

    public PersonaVO getPersona() {
        return persona;
    }


}
