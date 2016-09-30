/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-04-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancoPersona;

import java.util.List;


/**
 * Value Object para la Cuenta Banco de la Persona.
 * @author Camilo Miranda
 */
public class CuentaBancoPersonaVO {
    
    private String cbpActivo;
    private Long cbpCodigo;
    private String cbpComentario;
    private String cbpNumero;
    private String cbpTipo;
    
    private BancoVO bancoVo;
    
    private List<PersonaCtaBancoVO> personaCtaBancoList;
    
    
    
    /**
     * Constructor.
     */
    public CuentaBancoPersonaVO() { }
    
    
    /**
     * Constructor.
     * @param siiCuentaBancoPersona - Entidad.
     */
    public CuentaBancoPersonaVO (SiiCuentaBancoPersona siiCuentaBancoPersona) {
        if (siiCuentaBancoPersona!=null) {
            this.cbpActivo = siiCuentaBancoPersona.getCbpActivo();
            this.cbpCodigo = siiCuentaBancoPersona.getCbpCodigo();
            this.cbpComentario = siiCuentaBancoPersona.getCbpComentario();
            this.cbpNumero = siiCuentaBancoPersona.getCbpNumero();
            this.cbpTipo = siiCuentaBancoPersona.getCbpTipo();
            
            if (siiCuentaBancoPersona.getSiiBanco()!=null) {
                this.bancoVo = new BancoVO(siiCuentaBancoPersona.getSiiBanco());
            }
        }
    }


    public void setCbpActivo(String cbpActivo) {
        this.cbpActivo = cbpActivo;
    }

    public String getCbpActivo() {
        return cbpActivo;
    }

    public void setCbpCodigo(Long cbpCodigo) {
        this.cbpCodigo = cbpCodigo;
    }

    public Long getCbpCodigo() {
        return cbpCodigo;
    }

    public void setCbpComentario(String cbpComentario) {
        this.cbpComentario = cbpComentario;
    }

    public String getCbpComentario() {
        return cbpComentario;
    }

    public void setCbpNumero(String cbpNumero) {
        this.cbpNumero = cbpNumero;
    }

    public String getCbpNumero() {
        return cbpNumero;
    }

    public void setCbpTipo(String cbpTipo) {
        this.cbpTipo = cbpTipo;
    }

    public String getCbpTipo() {
        return cbpTipo;
    }

    public void setBancoVo(BancoVO bancoVo) {
        this.bancoVo = bancoVo;
    }

    public BancoVO getBancoVo() {
        return bancoVo;
    }

    public void setPersonaCtaBancoList(List<PersonaCtaBancoVO> personaCtaBancoList) {
        this.personaCtaBancoList = personaCtaBancoList;
    }

    public List<PersonaCtaBancoVO> getPersonaCtaBancoList() {
        return personaCtaBancoList;
    }
}
