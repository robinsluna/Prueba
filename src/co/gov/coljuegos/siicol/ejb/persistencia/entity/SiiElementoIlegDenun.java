package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ELEMENTO_ILEG_DENUN")
public class SiiElementoIlegDenun implements Serializable {
    private static final long serialVersionUID = 8737783977372989792L;
    private String eidActivo;
    private Long eidCodigo;
    private Integer eidNumero;
    private SiiTipoElemenIlegalidad siiTipoElemenIlegalidad;
    private SiiDenuncia siiDenuncia;

    public SiiElementoIlegDenun() {
    }

    public SiiElementoIlegDenun(SiiDenuncia siiDenuncia, String eidActivo, Long eidCodigo, Integer eidNumero, SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.siiDenuncia = siiDenuncia;
        this.eidActivo = eidActivo;
        this.eidCodigo = eidCodigo;
        this.eidNumero = eidNumero;
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
    }


    @Column(name = "EID_ACTIVO", nullable = false, length = 1)
    public String getEidActivo() {
        return eidActivo;
    }

    public void setEidActivo(String eidActivo) {
        this.eidActivo = eidActivo;
    }

    @Id
    @Column(name = "EID_CODIGO", nullable = false)
    public Long getEidCodigo() {
        return eidCodigo;
    }

    public void setEidCodigo(Long eidCodigo) {
        this.eidCodigo = eidCodigo;
    }

    @Column(name = "EID_NUMERO", nullable = false)
    public Integer getEidNumero() {
        return eidNumero;
    }

    public void setEidNumero(Integer eidNumero) {
        this.eidNumero = eidNumero;
    }


    @ManyToOne
    @JoinColumn(name = "TEI_CODIGO")
    public SiiTipoElemenIlegalidad getSiiTipoElemenIlegalidad() {
        return siiTipoElemenIlegalidad;
    }

    public void setSiiTipoElemenIlegalidad(SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
    }

    @ManyToOne
    @JoinColumn(name = "DEN_CODIGO")
    public SiiDenuncia getSiiDenuncia() {
        return siiDenuncia;
    }

    public void setSiiDenuncia(SiiDenuncia siiDenuncia) {
        this.siiDenuncia = siiDenuncia;
    }
}
