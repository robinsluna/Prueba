package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_AUTO_FORM_CARG_PRO_ILE")
public class SiiAutoFormCargProIle implements Serializable {
    private static final long serialVersionUID = 1339725391489997120L;
    private Long afcCodigo;
    private Date afcNumFechaRad;
    private String afcNumRadicado;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;
    private List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoList;
    private SiiUsuario siiUsuarioConec;
    private List<SiiTramiteAutoForCarIle> siiTramiteAutoForCarIleList;
    private String afcNumero;
    private Date afcFecha;
    private Date afcFechaNotifica;

    public SiiAutoFormCargProIle() {
    }

    public SiiAutoFormCargProIle(Long afcCodigo, Date afcNumFechaRad, String afcNumRadicado, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiUsuario siiUsuarioConec) {
        this.afcCodigo = afcCodigo;
        this.afcNumFechaRad = afcNumFechaRad;
        this.afcNumRadicado = afcNumRadicado;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "AFC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUTO_FOR_CAR_PRO_ILE_COD")
    @SequenceGenerator(name = "SEQ_AUTO_FOR_CAR_PRO_ILE_COD", sequenceName = "SEQ_AUTO_FOR_CAR_PRO_ILE_COD",allocationSize=1)
    public Long getAfcCodigo() {
        return afcCodigo;
    }

    public void setAfcCodigo(Long afcCodigo) {
        this.afcCodigo = afcCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AFC_NUM_FECHA_RAD")
    public Date getAfcNumFechaRad() {
        return afcNumFechaRad;
    }

    public void setAfcNumFechaRad(Date afcNumFechaRad) {
        this.afcNumFechaRad = afcNumFechaRad;
    }

    @Column(name = "AFC_NUM_RADICADO", length = 30)
    public String getAfcNumRadicado() {
        return afcNumRadicado;
    }

    public void setAfcNumRadicado(String afcNumRadicado) {
        this.afcNumRadicado = afcNumRadicado;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiAutoFormCargProIle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiPersonaInvProIleAuto> getSiiPersonaInvProIleAutoList() {
        return siiPersonaInvProIleAutoList;
    }

    public void setSiiPersonaInvProIleAutoList(List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoList) {
        this.siiPersonaInvProIleAutoList = siiPersonaInvProIleAutoList;
    }

    public SiiPersonaInvProIleAuto addSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoList().add(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiAutoFormCargProIle(this);
        return siiPersonaInvProIleAuto;
    }

    public SiiPersonaInvProIleAuto removeSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoList().remove(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiAutoFormCargProIle(null);
        return siiPersonaInvProIleAuto;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiAutoFormCargProIle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiTramiteAutoForCarIle> getSiiTramiteAutoForCarIleList() {
        return siiTramiteAutoForCarIleList;
    }

    public void setSiiTramiteAutoForCarIleList(List<SiiTramiteAutoForCarIle> siiTramiteAutoForCarIleList) {
        this.siiTramiteAutoForCarIleList = siiTramiteAutoForCarIleList;
    }

    public SiiTramiteAutoForCarIle addSiiTramiteAutoForCarIle(SiiTramiteAutoForCarIle siiTramiteAutoForCarIle) {
        getSiiTramiteAutoForCarIleList().add(siiTramiteAutoForCarIle);
        siiTramiteAutoForCarIle.setSiiAutoFormCargProIle(this);
        return siiTramiteAutoForCarIle;
    }

    public SiiTramiteAutoForCarIle removeSiiTramiteAutoForCarIle(SiiTramiteAutoForCarIle siiTramiteAutoForCarIle) {
        getSiiTramiteAutoForCarIleList().remove(siiTramiteAutoForCarIle);
        siiTramiteAutoForCarIle.setSiiAutoFormCargProIle(null);
        return siiTramiteAutoForCarIle;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AFC_FECHA")
    public Date getAfcFecha() {
        return afcFecha;
    }

    public void setAfcFecha(Date afcFecha) {
        this.afcFecha = afcFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AFC_FECHA_NOTIFICA")
    public Date getAfcFechaNotifica() {
        return afcFechaNotifica;
    }

    public void setAfcFechaNotifica(Date afcFechaNotifica) {
        this.afcFechaNotifica = afcFechaNotifica;
    }

    @Column(name = "AFC_NUMERO", length = 20)
    public String getAfcNumero() {
        return afcNumero;
    }

    public void setAfcNumero(String afcNumero) {
        this.afcNumero = afcNumero;
    }

}
