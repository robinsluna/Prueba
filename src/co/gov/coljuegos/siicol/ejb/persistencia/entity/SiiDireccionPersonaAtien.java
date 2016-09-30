package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_DIRECCION_PERSONA_ATIEN")
public class SiiDireccionPersonaAtien implements Serializable{
    private static final long serialVersionUID = 6995319461609870712L;
    private String dpaActivo;
    private Long dpaCodigo;
    private String dpaDireccion;
    private SiiUsuario siiUsuarioConect;
    private SiiUbicacion siiUbicacionMunic;
    private SiiPersonaAtiendeAcc siiPersonaAtiendeAcc;

    public SiiDireccionPersonaAtien(){
    }

    public SiiDireccionPersonaAtien(String dpaActivo, Long dpaCodigo, String dpaDireccion, SiiPersonaAtiendeAcc siiPersonaAtiendeAcc, SiiUbicacion siiUbicacionMunic, SiiUsuario siiUsuarioConect){
        this.dpaActivo = dpaActivo;
        this.dpaCodigo = dpaCodigo;
        this.dpaDireccion = dpaDireccion;
        this.siiPersonaAtiendeAcc = siiPersonaAtiendeAcc;
        this.siiUbicacionMunic = siiUbicacionMunic;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Column(name = "DPA_ACTIVO", nullable = false, length = 1)
    public String getDpaActivo(){
        return dpaActivo;
    }

    public void setDpaActivo(String dpaActivo){
        this.dpaActivo = dpaActivo;
    }

    @Id
    @Column(name = "DPA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DIRECC_PERS_ATIEN_COD")
    @SequenceGenerator(name = "SEQ_DIRECC_PERS_ATIEN_COD", sequenceName = "SEQ_DIRECC_PERS_ATIEN_COD",allocationSize=1)
    public Long getDpaCodigo(){
        return dpaCodigo;
    }

    public void setDpaCodigo(Long dpaCodigo){
        this.dpaCodigo = dpaCodigo;
    }

    @Column(name = "DPA_DIRECCION", nullable = false, length = 200)
    public String getDpaDireccion(){
        return dpaDireccion;
    }

    public void setDpaDireccion(String dpaDireccion){
        this.dpaDireccion = dpaDireccion;
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
    @JoinColumn(name = "UBI_CODIGO_MUNIC")
    public SiiUbicacion getSiiUbicacionMunic(){
        return siiUbicacionMunic;
    }

    public void setSiiUbicacionMunic(SiiUbicacion siiUbicacionMunic){
        this.siiUbicacionMunic = siiUbicacionMunic;
    }

    @ManyToOne
    @JoinColumn(name = "PEA_CODIGO")
    public SiiPersonaAtiendeAcc getSiiPersonaAtiendeAcc(){
        return siiPersonaAtiendeAcc;
    }

    public void setSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        this.siiPersonaAtiendeAcc = siiPersonaAtiendeAcc;
    }
}
