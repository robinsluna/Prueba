package co.gov.coljuegos.siicol.ejb.persistencia.entity.siito;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.validation.constraints.Size;

@Entity
@Table(name = "SIITO_MOV_CARG_INV_EST_CARG_INV")
@IdClass(SiitoMovCargInvEstCargInvPK.class)
public class SiitoMovCargInvEstCargInv implements Serializable {
    private static final long serialVersionUID = 3400407296197643104L;
    @Id
    @Column(name = "EST_CARG_INV_CODIGO", nullable = false)
    private Long estCargInvCodigo;
    @Id
    @Column(name = "MOV_CARGUE_INV_CODIGO", nullable = false)
    private Long movCargueInvCodigo;    
    @Column(name = "COMPLEMENTO",nullable = true)
    private String complemento;

    public SiitoMovCargInvEstCargInv() {
    }

    @JoinColumn(name = "EST_CARG_INV_CODIGO")
    public Long getEstCargInvCodigo() {
        return estCargInvCodigo;
    }

    public void setEstCargInvCodigo(Long estCargInvCodigo) {
        this.estCargInvCodigo = estCargInvCodigo;
    }

    @JoinColumn(name = "MOV_CARGUE_INV_CODIGO")
    public Long getMovCargueInvCodigo() {
        return movCargueInvCodigo;
    }

    public void setMovCargueInvCodigo(Long movCargueInvCodigo) {
        this.movCargueInvCodigo = movCargueInvCodigo;
    }
    
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
