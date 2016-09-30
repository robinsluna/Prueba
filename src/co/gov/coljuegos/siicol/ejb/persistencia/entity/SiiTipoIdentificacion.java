package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_IDENTIFICACION")
public class SiiTipoIdentificacion implements Serializable {
    private static final long serialVersionUID = -4670002270291754929L;
    private String tidActivo;
    private Long tidCodigo;
    private String tidNombre;
    private String tidNombreCorto;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList;
    private List<SiiPersona> siiPersonaList;
    private List<SiiOficioDesigSuperv> siiOficioDesigSupervList;
    private List<SiiHistPersona> siiHistPersonaList;
    private List<SiiDenuncia> siiDenunciaList;
    private List<SiiDenuncia> siiDenunciaDenunciadoList;
    private List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccList;

    public SiiTipoIdentificacion() {
    }

    public SiiTipoIdentificacion(String tidActivo, Long tidCodigo, String tidNombre, String tidNombreCorto) {
        this.tidActivo = tidActivo;
        this.tidCodigo = tidCodigo;
        this.tidNombre = tidNombre;
        this.tidNombreCorto = tidNombreCorto;
    }

    @Column(name = "TID_ACTIVO", nullable = false, length = 1)
    public String getTidActivo() {
        return tidActivo;
    }

    public void setTidActivo(String tidActivo) {
        this.tidActivo = tidActivo;
    }

    @Id
    @Column(name = "TID_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_IDENTIF_CODIGO")
    @SequenceGenerator(name = "SEQ_TIPO_IDENTIF_CODIGO", sequenceName = "SEQ_TIPO_IDENTIF_CODIGO",allocationSize=1)
    public Long getTidCodigo() {
        return tidCodigo;
    }

    public void setTidCodigo(Long tidCodigo) {
        this.tidCodigo = tidCodigo;
    }

    @Column(name = "TID_NOMBRE", nullable = false, length = 50)
    public String getTidNombre() {
        return tidNombre;
    }

    public void setTidNombre(String tidNombre) {
        this.tidNombre = tidNombre;
    }

    @Column(name = "TID_NOMBRE_CORTO", nullable = false, length = 5)
    public String getTidNombreCorto() {
        return tidNombreCorto;
    }

    public void setTidNombreCorto(String tidNombreCorto) {
        this.tidNombreCorto = tidNombreCorto;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacion")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList() {
        return siiSolicitudEstMercadoList;
    }

    public void setSiiSolicitudEstMercadoList(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList) {
        this.siiSolicitudEstMercadoList = siiSolicitudEstMercadoList;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiTipoIdentificacion(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiTipoIdentificacion(null);
        return siiSolicitudEstMercado;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacion1")
    public List<SiiPersona> getSiiPersonaList() {
        return siiPersonaList;
    }

    public void setSiiPersonaList(List<SiiPersona> siiPersonaList) {
        this.siiPersonaList = siiPersonaList;
    }

    public SiiPersona addSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().add(siiPersona);
        siiPersona.setSiiTipoIdentificacion1(this);
        return siiPersona;
    }

    public SiiPersona removeSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().remove(siiPersona);
        siiPersona.setSiiTipoIdentificacion1(null);
        return siiPersona;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacion")
    public List<SiiOficioDesigSuperv> getSiiOficioDesigSupervList() {
        return siiOficioDesigSupervList;
    }

    public void setSiiOficioDesigSupervList(List<SiiOficioDesigSuperv> siiOficioDesigSupervList) {
        this.siiOficioDesigSupervList = siiOficioDesigSupervList;
    }

    public SiiOficioDesigSuperv addSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().add(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiTipoIdentificacion(this);
        return siiOficioDesigSuperv;
    }

    public SiiOficioDesigSuperv removeSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().remove(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiTipoIdentificacion(null);
        return siiOficioDesigSuperv;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacion")
    public List<SiiHistPersona> getSiiHistPersonaList() {
        return siiHistPersonaList;
    }

    public void setSiiHistPersonaList(List<SiiHistPersona> siiHistPersonaList) {
        this.siiHistPersonaList = siiHistPersonaList;
    }

    public SiiHistPersona addSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().add(siiHistPersona);
        siiHistPersona.setSiiTipoIdentificacion(this);
        return siiHistPersona;
    }

    public SiiHistPersona removeSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().remove(siiHistPersona);
        siiHistPersona.setSiiTipoIdentificacion(null);
        return siiHistPersona;
    }
    
    @OneToMany(mappedBy = "siiTipoIdentificacion")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().add(siiDenuncia);
        siiDenuncia.setSiiTipoIdentificacion(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().remove(siiDenuncia);
        siiDenuncia.setSiiTipoIdentificacion(null);
        return siiDenuncia;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacionDenunciado")
    public List<SiiDenuncia> getSiiDenunciaDenunciadoList() {
        return siiDenunciaDenunciadoList;
    }

    public void setSiiDenunciaDenunciadoList(List<SiiDenuncia> siiDenunciaDenunciadoList) {
        this.siiDenunciaDenunciadoList = siiDenunciaDenunciadoList;
    }

    @OneToMany(mappedBy = "siiTipoIdentificacion")
    public List<SiiPersonaAtiendeAcc> getSiiPersonaAtiendeAccList(){
        return siiPersonaAtiendeAccList;
    }

    public void setSiiPersonaAtiendeAccList(List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccList){
        this.siiPersonaAtiendeAccList = siiPersonaAtiendeAccList;
    }

    public SiiPersonaAtiendeAcc addSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccList().add(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiTipoIdentificacion(this);
        return siiPersonaAtiendeAcc;
    }

    public SiiPersonaAtiendeAcc removeSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccList().remove(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiTipoIdentificacion(null);
        return siiPersonaAtiendeAcc;
    }
}
