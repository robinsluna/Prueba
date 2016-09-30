package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

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

@Entity
@Table(name = "SII_PERSONA_ATIENDE_ACC")
public class SiiPersonaAtiendeAcc implements Serializable{
    private static final long serialVersionUID = 2891921295515659864L;
    private String peaActivo;
    private Long peaCodigo;
    private String peaEmail;
    private String peaNumeroIden;
    private String peaPrimerApell;
    private String peaPrimerNombre;
    private String peaSegundoApell;
    private String peaSegundoNomb;
    private String peaTelefonos;
    private SiiTipoIdentificacion siiTipoIdentificacion;
    private SiiUsuario siiUsuarioConect;
    private SiiAccionControl siiAccionControl;
    private List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienList;

    public SiiPersonaAtiendeAcc(){
    }

    public SiiPersonaAtiendeAcc(SiiAccionControl siiAccionControl, String peaActivo, Long peaCodigo, String peaEmail, String peaNumeroIden, String peaPrimerApell, String peaPrimerNombre,
                                String peaSegundoApell, String peaSegundoNomb, String peaTelefonos, SiiTipoIdentificacion siiTipoIdentificacion, SiiUsuario siiUsuarioConect){
        this.siiAccionControl = siiAccionControl;
        this.peaActivo = peaActivo;
        this.peaCodigo = peaCodigo;
        this.peaEmail = peaEmail;
        this.peaNumeroIden = peaNumeroIden;
        this.peaPrimerApell = peaPrimerApell;
        this.peaPrimerNombre = peaPrimerNombre;
        this.peaSegundoApell = peaSegundoApell;
        this.peaSegundoNomb = peaSegundoNomb;
        this.peaTelefonos = peaTelefonos;
        this.siiTipoIdentificacion = siiTipoIdentificacion;
        this.siiUsuarioConect = siiUsuarioConect;
    }


    @Column(name = "PEA_ACTIVO", nullable = false, length = 1)
    public String getPeaActivo(){
        return peaActivo;
    }

    public void setPeaActivo(String peaActivo){
        this.peaActivo = peaActivo;
    }

    @Id
    @Column(name = "PEA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERS_ATIENDE_ACC_COD")
    @SequenceGenerator(name = "SEQ_PERS_ATIENDE_ACC_COD", sequenceName = "SEQ_PERS_ATIENDE_ACC_COD",allocationSize=1)
    public Long getPeaCodigo(){
        return peaCodigo;
    }

    public void setPeaCodigo(Long peaCodigo){
        this.peaCodigo = peaCodigo;
    }

    @Column(name = "PEA_EMAIL", length = 100)
    public String getPeaEmail(){
        return peaEmail;
    }

    public void setPeaEmail(String peaEmail){
        this.peaEmail = peaEmail;
    }

    @Column(name = "PEA_NUMERO_IDEN", nullable = false, length = 20)
    public String getPeaNumeroIden(){
        return peaNumeroIden;
    }

    public void setPeaNumeroIden(String peaNumeroIden){
        this.peaNumeroIden = peaNumeroIden;
    }

    @Column(name = "PEA_PRIMER_APELL", nullable = false, length = 20)
    public String getPeaPrimerApell(){
        return peaPrimerApell;
    }

    public void setPeaPrimerApell(String peaPrimerApell){
        this.peaPrimerApell = peaPrimerApell;
    }

    @Column(name = "PEA_PRIMER_NOMBRE", nullable = false, length = 20)
    public String getPeaPrimerNombre(){
        return peaPrimerNombre;
    }

    public void setPeaPrimerNombre(String peaPrimerNombre){
        this.peaPrimerNombre = peaPrimerNombre;
    }

    @Column(name = "PEA_SEGUNDO_APELL", length = 20)
    public String getPeaSegundoApell(){
        return peaSegundoApell;
    }

    public void setPeaSegundoApell(String peaSegundoApell){
        this.peaSegundoApell = peaSegundoApell;
    }

    @Column(name = "PEA_SEGUNDO_NOMB", length = 20)
    public String getPeaSegundoNomb(){
        return peaSegundoNomb;
    }

    public void setPeaSegundoNomb(String peaSegundoNomb){
        this.peaSegundoNomb = peaSegundoNomb;
    }

    @Column(name = "PEA_TELEFONOS", length = 30)
    public String getPeaTelefonos(){
        return peaTelefonos;
    }

    public void setPeaTelefonos(String peaTelefonos){
        this.peaTelefonos = peaTelefonos;
    }


    @ManyToOne
    @JoinColumn(name = "TID_CODIGO")
    public SiiTipoIdentificacion getSiiTipoIdentificacion(){
        return siiTipoIdentificacion;
    }

    public void setSiiTipoIdentificacion(SiiTipoIdentificacion siiTipoIdentificacion){
        this.siiTipoIdentificacion = siiTipoIdentificacion;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @ManyToOne
    @JoinColumn(name = "ACC_CODIGO")
    public SiiAccionControl getSiiAccionControl(){
        return siiAccionControl;
    }

    public void setSiiAccionControl(SiiAccionControl siiAccionControl){
        this.siiAccionControl = siiAccionControl;
    }

    @OneToMany(mappedBy = "siiPersonaAtiendeAcc")
    public List<SiiDireccionPersonaAtien> getSiiDireccionPersonaAtienList(){
        return siiDireccionPersonaAtienList;
    }

    public void setSiiDireccionPersonaAtienList(List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienList){
        this.siiDireccionPersonaAtienList = siiDireccionPersonaAtienList;
    }

    public SiiDireccionPersonaAtien addSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienList().add(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiPersonaAtiendeAcc(this);
        return siiDireccionPersonaAtien;
    }

    public SiiDireccionPersonaAtien removeSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienList().remove(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiPersonaAtiendeAcc(null);
        return siiDireccionPersonaAtien;
    }
}
