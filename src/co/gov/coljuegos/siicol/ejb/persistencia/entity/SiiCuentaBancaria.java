package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CUENTA_BANCARIA")
public class SiiCuentaBancaria implements Serializable {
    private static final long serialVersionUID = 3315700203283695782L;
    private String cbaActivo;
    private Long cbaCodigo;
    private String cbaComentario;
    private String cbaNumero;
    private String cbaTipo;
    private List<SiiOrdenPago> siiOrdenPagoList;
    private SiiBanco siiBanco;
    private List<SiiSaldoCtaBanco> siiSaldoCtaBancoList;
    private String cboAplicaGmf;
    private List<SiiTrasladoBancario> siiTrasladoBancarioOriList;
    private List<SiiTrasladoBancario> siiTrasladoBancarioDestList;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private SiiCuentasContables siiCuentasContables;
    private Integer cbaGrupoRecaudo;
    private List<SiiReintegroIngresoPag> siiReintegroIngresoPagList;

    public SiiCuentaBancaria() {
    }

    public SiiCuentaBancaria(SiiBanco siiBanco, String cbaActivo, Long cbaCodigo, String cbaComentario,
                             String cbaNumero, String cbaTipo, String cboAplicaGmf) {
        this.siiBanco = siiBanco;
        this.cbaActivo = cbaActivo;
        this.cbaCodigo = cbaCodigo;
        this.cbaComentario = cbaComentario;
        this.cbaNumero = cbaNumero;
        this.cbaTipo = cbaTipo;
        this.cboAplicaGmf = cboAplicaGmf;
    }


    @Column(name = "CBA_ACTIVO", nullable = false, length = 1)
    public String getCbaActivo() {
        return cbaActivo;
    }

    public void setCbaActivo(String cbaActivo) {
        this.cbaActivo = cbaActivo;
    }

    @Id
    @Column(name = "CBA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUENTA_BANCARIA_COD")
    @SequenceGenerator(name = "SEQ_CUENTA_BANCARIA_COD", sequenceName = "SEQ_CUENTA_BANCARIA_COD",allocationSize=1)
    public Long getCbaCodigo() {
        return cbaCodigo;
    }

    public void setCbaCodigo(Long cbaCodigo) {
        this.cbaCodigo = cbaCodigo;
    }

    @Column(name = "CBA_COMENTARIO", length = 50)
    public String getCbaComentario() {
        return cbaComentario;
    }

    public void setCbaComentario(String cbaComentario) {
        this.cbaComentario = cbaComentario;
    }

    @Column(name = "CBA_NUMERO", nullable = false, length = 20)
    public String getCbaNumero() {
        return cbaNumero;
    }

    public void setCbaNumero(String cbaNumero) {
        this.cbaNumero = cbaNumero;
    }

    @Column(name = "CBA_TIPO", nullable = false, length = 1)
    public String getCbaTipo() {
        return cbaTipo;
    }

    public void setCbaTipo(String cbaTipo) {
        this.cbaTipo = cbaTipo;
    }

    @Column(name = "CBO_APLICA_GMF", nullable = false, length = 1)
    public String getCboAplicaGmf() {
        return cboAplicaGmf;
    }

    public void setCboAplicaGmf(String cboAplicaGmf) {
        this.cboAplicaGmf = cboAplicaGmf;
    }


    @OneToMany(mappedBy = "siiCuentaBancaria")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiCuentaBancaria(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiCuentaBancaria(null);
        return siiOrdenPago;
    }

    @ManyToOne
    @JoinColumn(name = "BAN_CODIGO")
    public SiiBanco getSiiBanco() {
        return siiBanco;
    }

    public void setSiiBanco(SiiBanco siiBanco) {
        this.siiBanco = siiBanco;
    }

    @OneToMany(mappedBy = "siiCuentaBancaria")
    public List<SiiSaldoCtaBanco> getSiiSaldoCtaBancoList() {
        return siiSaldoCtaBancoList;
    }

    public void setSiiSaldoCtaBancoList(List<SiiSaldoCtaBanco> siiSaldoCtaBancoList) {
        this.siiSaldoCtaBancoList = siiSaldoCtaBancoList;
    }

    public SiiSaldoCtaBanco addSiiSaldoCtaBanco(SiiSaldoCtaBanco siiSaldoCtaBanco) {
        getSiiSaldoCtaBancoList().add(siiSaldoCtaBanco);
        siiSaldoCtaBanco.setSiiCuentaBancaria(this);
        return siiSaldoCtaBanco;
    }

    public SiiSaldoCtaBanco removeSiiSaldoCtaBanco(SiiSaldoCtaBanco siiSaldoCtaBanco) {
        getSiiSaldoCtaBancoList().remove(siiSaldoCtaBanco);
        siiSaldoCtaBanco.setSiiCuentaBancaria(null);
        return siiSaldoCtaBanco;
    }

    @OneToMany(mappedBy = "siiCuentaBancariaOri")
    public List<SiiTrasladoBancario> getSiiTrasladoBancarioOriList() {
        return siiTrasladoBancarioOriList;
    }

    public void setSiiTrasladoBancarioOriList(List<SiiTrasladoBancario> siiTrasladoBancarioOriList) {
        this.siiTrasladoBancarioOriList = siiTrasladoBancarioOriList;
    }

    public SiiTrasladoBancario addSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        getSiiTrasladoBancarioOriList().add(siiTrasladoBancario);
        siiTrasladoBancario.setSiiCuentaBancariaOri(this);
        return siiTrasladoBancario;
    }

    public SiiTrasladoBancario removeSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        getSiiTrasladoBancarioOriList().remove(siiTrasladoBancario);
        siiTrasladoBancario.setSiiCuentaBancariaOri(null);
        return siiTrasladoBancario;
    }

    @OneToMany(mappedBy = "siiCuentaBancariaDest")
    public List<SiiTrasladoBancario> getSiiTrasladoBancarioDestList() {
        return siiTrasladoBancarioDestList;
    }

    public void setSiiTrasladoBancarioDestList(List<SiiTrasladoBancario> siiTrasladoBancarioDestList) {
        this.siiTrasladoBancarioDestList = siiTrasladoBancarioDestList;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }

    @Column(name = "CBA_GRUPO_RECAUDO")
    public Integer getCbaGrupoRecaudo() {
        return cbaGrupoRecaudo;
    }

    public void setCbaGrupoRecaudo(Integer cbaGrupoRecaudo) {
        this.cbaGrupoRecaudo = cbaGrupoRecaudo;
    }

    @OneToMany(mappedBy = "siiCuentaBancaria")
    public List<SiiReintegroIngresoPag> getSiiReintegroIngresoPagList() {
        return siiReintegroIngresoPagList;
    }

    public void setSiiReintegroIngresoPagList(List<SiiReintegroIngresoPag> siiReintegroIngresoPagList) {
        this.siiReintegroIngresoPagList = siiReintegroIngresoPagList;
    }

    public SiiReintegroIngresoPag addSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagList().add(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiCuentaBancaria(this);
        return siiReintegroIngresoPag;
    }

    public SiiReintegroIngresoPag removeSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagList().remove(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiCuentaBancaria(null);
        return siiReintegroIngresoPag;
    }
}
