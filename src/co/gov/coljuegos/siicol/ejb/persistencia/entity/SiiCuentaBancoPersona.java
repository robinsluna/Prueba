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
@Table(name = "SII_CUENTA_BANCO_PERSONA")
public class SiiCuentaBancoPersona implements Serializable {
    private static final long serialVersionUID = 6898742372423746069L;
    private String cbpActivo;
    private Long cbpCodigo;
    private String cbpComentario;
    private String cbpNumero;
    private String cbpTipo;
    private List<SiiPersonaCtaBanco> siiPersonaCtaBancoList;
    private SiiBanco siiBanco;

    public SiiCuentaBancoPersona() {
    }

    public SiiCuentaBancoPersona(SiiBanco siiBanco, String cbpActivo, Long cbpCodigo, String cbpComentario,
                                 String cbpNumero, String cbpTipo) {
        this.siiBanco = siiBanco;
        this.cbpActivo = cbpActivo;
        this.cbpCodigo = cbpCodigo;
        this.cbpComentario = cbpComentario;
        this.cbpNumero = cbpNumero;
        this.cbpTipo = cbpTipo;
    }


    @Column(name = "CBP_ACTIVO", nullable = false, length = 1)
    public String getCbpActivo() {
        return cbpActivo;
    }

    public void setCbpActivo(String cbpActivo) {
        this.cbpActivo = cbpActivo;
    }

    @Id
    @Column(name = "CBP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUEN_BANC_PERS_COD")
    @SequenceGenerator(name = "SEQ_CUEN_BANC_PERS_COD", sequenceName = "SEQ_CUEN_BANC_PERS_COD",allocationSize=1)
    public Long getCbpCodigo() {
        return cbpCodigo;
    }

    public void setCbpCodigo(Long cbpCodigo) {
        this.cbpCodigo = cbpCodigo;
    }

    @Column(name = "CBP_COMENTARIO", length = 50)
    public String getCbpComentario() {
        return cbpComentario;
    }

    public void setCbpComentario(String cbpComentario) {
        this.cbpComentario = cbpComentario;
    }

    @Column(name = "CBP_NUMERO", nullable = false, length = 20)
    public String getCbpNumero() {
        return cbpNumero;
    }

    public void setCbpNumero(String cbpNumero) {
        this.cbpNumero = cbpNumero;
    }

    @Column(name = "CBP_TIPO", nullable = false, length = 1)
    public String getCbpTipo() {
        return cbpTipo;
    }

    public void setCbpTipo(String cbpTipo) {
        this.cbpTipo = cbpTipo;
    }

    @OneToMany(mappedBy = "siiCuentaBancoPersona")
    public List<SiiPersonaCtaBanco> getSiiPersonaCtaBancoList() {
        return siiPersonaCtaBancoList;
    }

    public void setSiiPersonaCtaBancoList(List<SiiPersonaCtaBanco> siiPersonaCtaBancoList) {
        this.siiPersonaCtaBancoList = siiPersonaCtaBancoList;
    }

    public SiiPersonaCtaBanco addSiiPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) {
        getSiiPersonaCtaBancoList().add(siiPersonaCtaBanco);
        siiPersonaCtaBanco.setSiiCuentaBancoPersona(this);
        return siiPersonaCtaBanco;
    }

    public SiiPersonaCtaBanco removeSiiPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) {
        getSiiPersonaCtaBancoList().remove(siiPersonaCtaBanco);
        siiPersonaCtaBanco.setSiiCuentaBancoPersona(null);
        return siiPersonaCtaBanco;
    }

    @ManyToOne
    @JoinColumn(name = "BAN_CODIGO")
    public SiiBanco getSiiBanco() {
        return siiBanco;
    }

    public void setSiiBanco(SiiBanco siiBanco) {
        this.siiBanco = siiBanco;
    }
}
