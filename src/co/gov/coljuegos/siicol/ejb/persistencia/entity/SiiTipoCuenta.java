package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_CUENTA")
public class SiiTipoCuenta implements Serializable {
    private static final long serialVersionUID = -7940553704284813001L;
    private Long tcuCodigo;
    private String tcuNombre;
    private List<SiiRecaudoBanco> siiRecaudoBancoList;

    public SiiTipoCuenta() {
    }

    public SiiTipoCuenta(Long tcuCodigo, String tcuNombre) {
        this.tcuCodigo = tcuCodigo;
        this.tcuNombre = tcuNombre;
    }

    @Id
    @Column(name = "TCU_CODIGO", nullable = false)
    public Long getTcuCodigo() {
        return tcuCodigo;
    }

    public void setTcuCodigo(Long tcuCodigo) {
        this.tcuCodigo = tcuCodigo;
    }

    @Column(name = "TCU_NOMBRE", nullable = false, length = 20)
    public String getTcuNombre() {
        return tcuNombre;
    }

    public void setTcuNombre(String tcuNombre) {
        this.tcuNombre = tcuNombre;
    }

    @OneToMany(mappedBy = "siiTipoCuenta")
    public List<SiiRecaudoBanco> getSiiRecaudoBancoList() {
        return siiRecaudoBancoList;
    }

    public void setSiiRecaudoBancoList(List<SiiRecaudoBanco> siiRecaudoBancoList) {
        this.siiRecaudoBancoList = siiRecaudoBancoList;
    }

    public SiiRecaudoBanco addSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().add(siiRecaudoBanco);
        siiRecaudoBanco.setSiiTipoCuenta(this);
        return siiRecaudoBanco;
    }

    public SiiRecaudoBanco removeSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().remove(siiRecaudoBanco);
        siiRecaudoBanco.setSiiTipoCuenta(null);
        return siiRecaudoBanco;
    }
}
