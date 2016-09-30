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
@Table(name = "SII_DIRECCION")
public class SiiDireccion implements Serializable {
    private static final long serialVersionUID = 1722599077492997219L;
    private String dirActivo;
    private Integer dirCallePpal;
    private Long dirCodigo;
    private String dirInfoAdicional;
    private Integer dirNumero1;
    private Integer dirNumero2;
    private SiiTipoCalleDireccion siiTipoCalleDireccion;
    private SiiTipoSectorDirec siiTipoSectorDirecPpal;
    private SiiTipoSufijo1Calle siiTipoSufijo1CallePpal1;
    private List<SiiDenuncia> siiDenunciaDenunList;
    private List<SiiDenuncia> siiDenunciaList;
    private SiiTipoSufijo1Calle siiTipoSufijo1CallePpal2;
    private SiiUsuario siiUsuarioConec;
    private List<SiiDenuncia> siiDenunciaDnadoList;
    private SiiTipoSufijo2Calle siiTipoSufijo2Calle;
    private SiiTipoSectorDirec siiTipoSectorDirecNum2;
    private SiiTipoSufijo1Calle siiTipoSufijo1CalleNum1;
    private List<SiiDireccionProcePerIle> siiDireccionProcePerIleList;
    private List<SiiDireccionPersona> siiDireccionPersonaList;

    public SiiDireccion() {
    }

    public SiiDireccion(String dirActivo, Integer dirCallePpal, Long dirCodigo, String dirInfoAdicional, Integer dirNumero1, Integer dirNumero2, SiiTipoCalleDireccion siiTipoCalleDireccion,
                        SiiTipoSufijo1Calle siiTipoSufijo1CallePpal1, SiiTipoSufijo1Calle siiTipoSufijo1CallePpal2, SiiTipoSectorDirec siiTipoSectorDirecNum2,
                        SiiTipoSectorDirec siiTipoSectorDirecPpal, SiiTipoSufijo2Calle siiTipoSufijo2Calle, SiiUsuario siiUsuarioConec) {
        this.dirActivo = dirActivo;
        this.dirCallePpal = dirCallePpal;
        this.dirCodigo = dirCodigo;
        this.dirInfoAdicional = dirInfoAdicional;
        this.dirNumero1 = dirNumero1;
        this.dirNumero2 = dirNumero2;
        this.siiTipoCalleDireccion = siiTipoCalleDireccion;
        this.siiTipoSufijo1CallePpal1 = siiTipoSufijo1CallePpal1;
        this.siiTipoSufijo1CallePpal2 = siiTipoSufijo1CallePpal2;
        this.siiTipoSectorDirecNum2 = siiTipoSectorDirecNum2;
        this.siiTipoSectorDirecPpal = siiTipoSectorDirecPpal;
        this.siiTipoSufijo2Calle = siiTipoSufijo2Calle;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Column(name = "DIR_ACTIVO", nullable = false, length = 1)
    public String getDirActivo() {
        return dirActivo;
    }

    public void setDirActivo(String dirActivo) {
        this.dirActivo = dirActivo;
    }

    @Column(name = "DIR_CALLE_PPAL", nullable = false)
    public Integer getDirCallePpal() {
        return dirCallePpal;
    }

    public void setDirCallePpal(Integer dirCallePpal) {
        this.dirCallePpal = dirCallePpal;
    }

    @Id
    @Column(name = "DIR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DIRECCION_COD")
    @SequenceGenerator(name = "SEQ_DIRECCION_COD", sequenceName = "SEQ_DIRECCION_COD",allocationSize=1)
    public Long getDirCodigo() {
        return dirCodigo;
    }

    public void setDirCodigo(Long dirCodigo) {
        this.dirCodigo = dirCodigo;
    }

    @Column(name = "DIR_INFO_ADICIONAL", length = 50)
    public String getDirInfoAdicional() {
        return dirInfoAdicional;
    }

    public void setDirInfoAdicional(String dirInfoAdicional) {
        this.dirInfoAdicional = dirInfoAdicional;
    }

    @Column(name = "DIR_NUMERO1", nullable = false)
    public Integer getDirNumero1() {
        return dirNumero1;
    }

    public void setDirNumero1(Integer dirNumero1) {
        this.dirNumero1 = dirNumero1;
    }

    @Column(name = "DIR_NUMERO2", nullable = false)
    public Integer getDirNumero2() {
        return dirNumero2;
    }

    public void setDirNumero2(Integer dirNumero2) {
        this.dirNumero2 = dirNumero2;
    }


    @ManyToOne
    @JoinColumn(name = "TCD_CODIGO")
    public SiiTipoCalleDireccion getSiiTipoCalleDireccion() {
        return siiTipoCalleDireccion;
    }

    public void setSiiTipoCalleDireccion(SiiTipoCalleDireccion siiTipoCalleDireccion) {
        this.siiTipoCalleDireccion = siiTipoCalleDireccion;
    }

    @ManyToOne
    @JoinColumn(name = "TSD_CODIGO_PPAL")
    public SiiTipoSectorDirec getSiiTipoSectorDirecPpal() {
        return siiTipoSectorDirecPpal;
    }

    public void setSiiTipoSectorDirecPpal(SiiTipoSectorDirec siiTipoSectorDirecPpal) {
        this.siiTipoSectorDirecPpal = siiTipoSectorDirecPpal;
    }

    @ManyToOne
    @JoinColumn(name = "TSC_CODIGO1_PPAL")
    public SiiTipoSufijo1Calle getSiiTipoSufijo1CallePpal1() {
        return siiTipoSufijo1CallePpal1;
    }

    public void setSiiTipoSufijo1CallePpal1(SiiTipoSufijo1Calle siiTipoSufijo1CallePpal1) {
        this.siiTipoSufijo1CallePpal1 = siiTipoSufijo1CallePpal1;
    }

    @OneToMany(mappedBy = "siiDireccionDenun")
    public List<SiiDenuncia> getSiiDenunciaDenunList() {
        return siiDenunciaDenunList;
    }

    public void setSiiDenunciaDenunList(List<SiiDenuncia> siiDenunciaDenunList) {
        this.siiDenunciaDenunList = siiDenunciaDenunList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaDenunList().add(siiDenuncia);
        siiDenuncia.setSiiDireccionDenun(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaDenunList().remove(siiDenuncia);
        siiDenuncia.setSiiDireccionDenun(null);
        return siiDenuncia;
    }

    @OneToMany(mappedBy = "siiDireccion")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    @ManyToOne
    @JoinColumn(name = "TSC_CODIGO2_PPAL")
    public SiiTipoSufijo1Calle getSiiTipoSufijo1CallePpal2() {
        return siiTipoSufijo1CallePpal2;
    }

    public void setSiiTipoSufijo1CallePpal2(SiiTipoSufijo1Calle siiTipoSufijo1CallePpal2) {
        this.siiTipoSufijo1CallePpal2 = siiTipoSufijo1CallePpal2;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiDireccionDnado")
    public List<SiiDenuncia> getSiiDenunciaDnadoList() {
        return siiDenunciaDnadoList;
    }

    public void setSiiDenunciaDnadoList(List<SiiDenuncia> siiDenunciaDnadoList) {
        this.siiDenunciaDnadoList = siiDenunciaDnadoList;
    }

    @ManyToOne
    @JoinColumn(name = "TSU_CODIGO")
    public SiiTipoSufijo2Calle getSiiTipoSufijo2Calle() {
        return siiTipoSufijo2Calle;
    }

    public void setSiiTipoSufijo2Calle(SiiTipoSufijo2Calle siiTipoSufijo2Calle) {
        this.siiTipoSufijo2Calle = siiTipoSufijo2Calle;
    }

    @ManyToOne
    @JoinColumn(name = "TSD_CODIGO_NUM2")
    public SiiTipoSectorDirec getSiiTipoSectorDirecNum2() {
        return siiTipoSectorDirecNum2;
    }

    public void setSiiTipoSectorDirecNum2(SiiTipoSectorDirec siiTipoSectorDirecNum2) {
        this.siiTipoSectorDirecNum2 = siiTipoSectorDirecNum2;
    }

    @ManyToOne
    @JoinColumn(name = "TSC_CODIGO_NUM1")
    public SiiTipoSufijo1Calle getSiiTipoSufijo1CalleNum1() {
        return siiTipoSufijo1CalleNum1;
    }

    public void setSiiTipoSufijo1CalleNum1(SiiTipoSufijo1Calle siiTipoSufijo1CalleNum1) {
        this.siiTipoSufijo1CalleNum1 = siiTipoSufijo1CalleNum1;
    }
    @OneToMany(mappedBy = "siiDireccion")
    public List<SiiDireccionProcePerIle> getSiiDireccionProcePerIleList() {
        return siiDireccionProcePerIleList;
    }

    public void setSiiDireccionProcePerIleList(List<SiiDireccionProcePerIle> siiDireccionProcePerIleList) {
        this.siiDireccionProcePerIleList = siiDireccionProcePerIleList;
    }

    public SiiDireccionProcePerIle addSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().add(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiDireccion(this);
        return siiDireccionProcePerIle;
    }

    public SiiDireccionProcePerIle removeSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().remove(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiDireccion(null);
        return siiDireccionProcePerIle;
    }

    @OneToMany(mappedBy = "siiDireccion")
    public List<SiiDireccionPersona> getSiiDireccionPersonaList() {
        return siiDireccionPersonaList;
    }

    public void setSiiDireccionPersonaList(List<SiiDireccionPersona> siiDireccionPersonaList) {
        this.siiDireccionPersonaList = siiDireccionPersonaList;
    }

    public SiiDireccionPersona addSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaList().add(siiDireccionPersona);
        siiDireccionPersona.setSiiDireccion(this);
        return siiDireccionPersona;
    }

    public SiiDireccionPersona removeSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaList().remove(siiDireccionPersona);
        siiDireccionPersona.setSiiDireccion(null);
        return siiDireccionPersona;
    }
}
