/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-03-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;

import java.util.Date;
import java.util.List;

public class ObligacionNoPresupVO {

    private Long onpCodigo;
    private Date onpFecha;
    private Integer onpNumero;
    private List<ImpContabOblNoPresVO> impContabOblNoPresListVo;
    private EstadoObligNoPresVO estadoObligNoPresVo;
    private PersonaVO personaVo;
    private String onpMotivoAnul;
    private Long idEstadoAnterior;
    private UsuarioVO usuarioRegistra;
    private UsuarioVO usuarioAprueba;
    private String onpConcepto;
    

    /**
     * @author Modifica Giovanni
     * @param siiObligacionNoPresup
     */
    public ObligacionNoPresupVO(SiiObligacionNoPresup siiObligacionNoPresup) {
        this.onpCodigo = siiObligacionNoPresup.getOnpCodigo();
        this.onpFecha = siiObligacionNoPresup.getOnpFecha();
        this.onpNumero = siiObligacionNoPresup.getOnpNumero();
        this.onpMotivoAnul = siiObligacionNoPresup.getOnpMotivoAnul();
        this.onpConcepto = siiObligacionNoPresup.getOnpConcepto();

        //Estado
        if (siiObligacionNoPresup.getSiiEstadoObligNoPres() != null) {
            this.estadoObligNoPresVo = new EstadoObligNoPresVO(siiObligacionNoPresup.getSiiEstadoObligNoPres());
            this.idEstadoAnterior = siiObligacionNoPresup.getSiiEstadoObligNoPres().getEonCodigo();
        }

        //Persona
        if (siiObligacionNoPresup.getSiiPersona() != null) {
            this.personaVo = new PersonaVO(siiObligacionNoPresup.getSiiPersona());
        }
        
        //Usuario que registra la Obligacion
        if (siiObligacionNoPresup.getSiiUsuarioRegistra()!=null) {
            this.usuarioRegistra = new UsuarioVO(siiObligacionNoPresup.getSiiUsuarioRegistra());
        }
        
        //Usuario que aprueba la Obligacion
        if (siiObligacionNoPresup.getSiiUsuarioAprueba()!=null) {
            this.usuarioAprueba = new UsuarioVO(siiObligacionNoPresup.getSiiUsuarioAprueba());
        }
    }

    public ObligacionNoPresupVO() {

    }

    public void setOnpCodigo(Long onpCodigo) {
        this.onpCodigo = onpCodigo;
    }

    public Long getOnpCodigo() {
        return onpCodigo;
    }

    public void setOnpFecha(Date onpFecha) {
        this.onpFecha = onpFecha;
    }

    public Date getOnpFecha() {
        return onpFecha;
    }

    public void setOnpNumero(Integer onpNumero) {
        this.onpNumero = onpNumero;
    }

    public Integer getOnpNumero() {
        return onpNumero;
    }


    public void setImpContabOblNoPresListVo(List<ImpContabOblNoPresVO> impContabOblNoPresListVo) {
        this.impContabOblNoPresListVo = impContabOblNoPresListVo;
    }

    public List<ImpContabOblNoPresVO> getImpContabOblNoPresListVo() {
        return impContabOblNoPresListVo;
    }

    public void setEstadoObligNoPresVo(EstadoObligNoPresVO estadoObligNoPresVo) {
        this.estadoObligNoPresVo = estadoObligNoPresVo;
    }

    public EstadoObligNoPresVO getEstadoObligNoPresVo() {
        return estadoObligNoPresVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setOnpMotivoAnul(String onpMotivoAnul) {
        this.onpMotivoAnul = onpMotivoAnul;
    }

    public String getOnpMotivoAnul() {
        return onpMotivoAnul;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public void setUsuarioRegistra(UsuarioVO usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public UsuarioVO getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioAprueba(UsuarioVO usuarioAprueba) {
        this.usuarioAprueba = usuarioAprueba;
    }

    public UsuarioVO getUsuarioAprueba() {
        return usuarioAprueba;
    }

    public void setOnpConcepto(String onpConcepto) {
        this.onpConcepto = onpConcepto;
    }

    public String getOnpConcepto() {
        return onpConcepto;
    }
}
