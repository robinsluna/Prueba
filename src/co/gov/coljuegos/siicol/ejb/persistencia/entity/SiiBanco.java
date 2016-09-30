package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_BANCO")
public class SiiBanco implements Serializable {
    private static final long serialVersionUID = 1276893085326281786L;
    private String banCodigo;
    private String banNombre;
    private List<SiiRecaudoBanco> siiRecaudoBancoList;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;
    private List<SiiCuentaBancaria> siiCuentaBancariaList;
    private List<SiiCuentaBancoPersona> siiCuentaBancoPersonaList;
    private SiiPersona siiPersona;

    public SiiBanco() {
    }

    public SiiBanco(String banCodigo, String banNombre) {
        this.banCodigo = banCodigo;
        this.banNombre = banNombre;
    }

    @Id
    @Column(name = "BAN_CODIGO", nullable = false, length = 4)
    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    @Column(name = "BAN_NOMBRE", nullable = false, length = 40)
    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    @OneToMany(mappedBy = "siiBanco")
    public List<SiiRecaudoBanco> getSiiRecaudoBancoList() {
        return siiRecaudoBancoList;
    }

    public void setSiiRecaudoBancoList(List<SiiRecaudoBanco> siiRecaudoBancoList) {
        this.siiRecaudoBancoList = siiRecaudoBancoList;
    }

    public SiiRecaudoBanco addSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().add(siiRecaudoBanco);
        siiRecaudoBanco.setSiiBanco(this);
        return siiRecaudoBanco;
    }

    public SiiRecaudoBanco removeSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().remove(siiRecaudoBanco);
        siiRecaudoBanco.setSiiBanco(null);
        return siiRecaudoBanco;
    }

    @OneToMany(mappedBy = "siiBanco")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiBanco(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiBanco(null);
        return siiDetalleRecaudo;
    }

    @OneToMany(mappedBy = "siiBanco")
    public List<SiiCuentaBancaria> getSiiCuentaBancariaList() {
        return siiCuentaBancariaList;
    }

    public void setSiiCuentaBancariaList(List<SiiCuentaBancaria> siiCuentaBancariaList) {
        this.siiCuentaBancariaList = siiCuentaBancariaList;
    }

    public SiiCuentaBancaria addSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().add(siiCuentaBancaria);
        siiCuentaBancaria.setSiiBanco(this);
        return siiCuentaBancaria;
    }

    public SiiCuentaBancaria removeSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().remove(siiCuentaBancaria);
        siiCuentaBancaria.setSiiBanco(null);
        return siiCuentaBancaria;
    }


    @OneToMany(mappedBy = "siiBanco")
    public List<SiiCuentaBancoPersona> getSiiCuentaBancoPersonaList() {
        return siiCuentaBancoPersonaList;
    }

    public void setSiiCuentaBancoPersonaList(List<SiiCuentaBancoPersona> siiCuentaBancoPersonaList) {
        this.siiCuentaBancoPersonaList = siiCuentaBancoPersonaList;
    }

    public SiiCuentaBancoPersona addSiiCuentaBancoPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) {
        getSiiCuentaBancoPersonaList().add(siiCuentaBancoPersona);
        siiCuentaBancoPersona.setSiiBanco(this);
        return siiCuentaBancoPersona;
    }

    public SiiCuentaBancoPersona removeSiiCuentaBancoPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) {
        getSiiCuentaBancoPersonaList().remove(siiCuentaBancoPersona);
        siiCuentaBancoPersona.setSiiBanco(null);
        return siiCuentaBancoPersona;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }
}
