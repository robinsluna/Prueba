package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_UBICACION")
public class SiiUbicacion implements Serializable {
    private static final long serialVersionUID = -4969068960028424921L;
    private String ubiCodigo;
    private String ubiCodigoPadre;
    private String ubiDescripcion;
    private String ubiNombre;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList;
    private SiiTipoUbicacion siiTipoUbicacion;
    private List<SiiEstudioPrevio> siiEstudioPrevioList3;
    private List<SiiCotizacionEstudio> siiCotizacionEstudioList;
    private List<SiiEstablecimiento> siiEstablecimientoList;
    private List<SiiPersona> siiPersonaList1;
    private List<SiiEnteTerritorial> siiEnteTerritorialList;
    private List<SiiHistPersona> siiHistPersonaList;
    private List<SiiConsolidadoDist> siiConsolidadoDistList;
    private SiiUbicacion siiUbicacionPadre;
    private List<SiiUbicacion> siiUbicacionHijoList;
    private List<SiiDenuncia> siiDenunciaLocalList;
    private List<SiiDenuncia> siiDenunciaDenuncianteList;
    private List<SiiBarrioOrden> siiBarrioOrdenMunicipioList;
    private List<SiiMunicipioOrdenTrab> siiMunicipioOrdenTrabMunicipioList;
    private List<SiiDenuncia> siiDenunciaMunDenunciadoList;
    private List<SiiLiquidacionEstabl> siiLiquidacionEstablMunEstabList;
    private List<SiiHlpLiqEstablAsigRec> siiHlpLiqEstablAsigRecMunEstList;
    private List<SiiAsigRecaudoAaEstabl> siiAsigRecaudoAaEstablList;
    private List<SiiAutoComisorioAccCon> siiAutoComisorioAccConMunicList;
    private List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienMunicList;
    private List<SiiAccionControl> siiAccionControlMunicList;
    private List<SiiActaDestruccion> siiActaDestruccionMunicList;
    private List<SiiEstablecConCuoCar> siiEstablecConCuoCarUbiMunList;
    private List<SiiDireccionProcePerIle> siiDireccionProcePerIleList;
    private List<SiiDireccionPersona> siiDireccionPersonaUbiMunList;

    public SiiUbicacion() {
    }

    public SiiUbicacion(SiiTipoUbicacion siiTipoUbicacion, String ubiCodigoPadre,
                        String ubiDescripcion, String ubiNombre) {
        this.siiTipoUbicacion = siiTipoUbicacion;
        this.ubiCodigoPadre = ubiCodigoPadre;
        this.ubiDescripcion = ubiDescripcion;
        this.ubiNombre = ubiNombre;
    }


    @Id
    @Column(name = "UBI_CODIGO", nullable = false)
    public String getUbiCodigo() {
        return ubiCodigo;
    }
    
    @Column(name = "UBI_CODIGO_PADRE", length = 20, insertable = false, updatable = false)
    public String getUbiCodigoPadre() {
        return ubiCodigoPadre;
    }

    public void setUbiCodigoPadre(String ubiCodigoPadre) {
        this.ubiCodigoPadre = ubiCodigoPadre;
    }


    public void setUbiCodigo(String ubiCodigo) {
        this.ubiCodigo = ubiCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_PADRE")
    public SiiUbicacion getSiiUbicacionPadre() {
        return siiUbicacionPadre;
    }

    public void setSiiUbicacionPadre(SiiUbicacion siiUbicacionPadre) {
        this.siiUbicacionPadre = siiUbicacionPadre;
    }

    @Column(name = "UBI_DESCRIPCION", length = 100)
    public String getUbiDescripcion() {
        return ubiDescripcion;
    }

    public void setUbiDescripcion(String ubiDescripcion) {
        this.ubiDescripcion = ubiDescripcion;
    }

    @Column(name = "UBI_NOMBRE", nullable = false, length = 100)
    public String getUbiNombre() {
        return ubiNombre;
    }

    public void setUbiNombre(String ubiNombre) {
        this.ubiNombre = ubiNombre;
    }

    @OneToMany(mappedBy = "siiUbicacion1")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList() {
        return siiSolicitudEstMercadoList;
    }

    public void setSiiSolicitudEstMercadoList(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList) {
        this.siiSolicitudEstMercadoList = siiSolicitudEstMercadoList;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiUbicacion1(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiUbicacion1(null);
        return siiSolicitudEstMercado;
    }

    @ManyToOne
    @JoinColumn(name = "TIU_CODIGO")
    public SiiTipoUbicacion getSiiTipoUbicacion() {
        return siiTipoUbicacion;
    }

    public void setSiiTipoUbicacion(SiiTipoUbicacion siiTipoUbicacion) {
        this.siiTipoUbicacion = siiTipoUbicacion;
    }

    @OneToMany(mappedBy = "siiUbicacion1")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList3() {
        return siiEstudioPrevioList3;
    }

    public void setSiiEstudioPrevioList3(List<SiiEstudioPrevio> siiEstudioPrevioList3) {
        this.siiEstudioPrevioList3 = siiEstudioPrevioList3;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList3().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiUbicacion1(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList3().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiUbicacion1(null);
        return siiEstudioPrevio;
    }

    @OneToMany(mappedBy = "siiUbicacion1")
    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList() {
        return siiCotizacionEstudioList;
    }

    public void setSiiCotizacionEstudioList(List<SiiCotizacionEstudio> siiCotizacionEstudioList) {
        this.siiCotizacionEstudioList = siiCotizacionEstudioList;
    }

    public SiiCotizacionEstudio addSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().add(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiUbicacion1(this);
        return siiCotizacionEstudio;
    }

    public SiiCotizacionEstudio removeSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().remove(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiUbicacion1(null);
        return siiCotizacionEstudio;
    }

    @OneToMany(mappedBy = "siiUbicacion1")
    public List<SiiEstablecimiento> getSiiEstablecimientoList() {
        return siiEstablecimientoList;
    }

    public void setSiiEstablecimientoList(List<SiiEstablecimiento> siiEstablecimientoList) {
        this.siiEstablecimientoList = siiEstablecimientoList;
    }

    public SiiEstablecimiento addSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList().add(siiEstablecimiento);
        siiEstablecimiento.setSiiUbicacion1(this);
        return siiEstablecimiento;
    }

    public SiiEstablecimiento removeSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList().remove(siiEstablecimiento);
        siiEstablecimiento.setSiiUbicacion1(null);
        return siiEstablecimiento;
    }

    @OneToMany(mappedBy = "siiUbicacion1")
    public List<SiiPersona> getSiiPersonaList1() {
        return siiPersonaList1;
    }

    public void setSiiPersonaList1(List<SiiPersona> siiPersonaList1) {
        this.siiPersonaList1 = siiPersonaList1;
    }

    public SiiPersona addSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList1().add(siiPersona);
        siiPersona.setSiiUbicacion1(this);
        return siiPersona;
    }

    public SiiPersona removeSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList1().remove(siiPersona);
        siiPersona.setSiiUbicacion1(null);
        return siiPersona;
    }

    @OneToMany(mappedBy = "siiUbicacion")
    public List<SiiEnteTerritorial> getSiiEnteTerritorialList() {
        return siiEnteTerritorialList;
    }

    public void setSiiEnteTerritorialList(List<SiiEnteTerritorial> siiEnteTerritorialList) {
        this.siiEnteTerritorialList = siiEnteTerritorialList;
    }

    public SiiEnteTerritorial addSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialList().add(siiEnteTerritorial);
        siiEnteTerritorial.setSiiUbicacion(this);
        return siiEnteTerritorial;
    }

    public SiiEnteTerritorial removeSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialList().remove(siiEnteTerritorial);
        siiEnteTerritorial.setSiiUbicacion(null);
        return siiEnteTerritorial;
    }

    @OneToMany(mappedBy = "siiUbicacion")
    public List<SiiHistPersona> getSiiHistPersonaList() {
        return siiHistPersonaList;
    }

    public void setSiiHistPersonaList(List<SiiHistPersona> siiHistPersonaList) {
        this.siiHistPersonaList = siiHistPersonaList;
    }

    public SiiHistPersona addSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().add(siiHistPersona);
        siiHistPersona.setSiiUbicacion(this);
        return siiHistPersona;
    }

    public SiiHistPersona removeSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().remove(siiHistPersona);
        siiHistPersona.setSiiUbicacion(null);
        return siiHistPersona;
    }
    
    
    @OneToMany(mappedBy = "siiUbicacion")
    public List<SiiConsolidadoDist> getSiiConsolidadoDistList() {
        return siiConsolidadoDistList;
    }

    public void setSiiConsolidadoDistList(List<SiiConsolidadoDist> siiConsolidadoDistList) {
        this.siiConsolidadoDistList = siiConsolidadoDistList;
    }

    public SiiConsolidadoDist addSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().add(siiConsolidadoDist);
        siiConsolidadoDist.setSiiUbicacion(this);
        return siiConsolidadoDist;
    }

    public SiiConsolidadoDist removeSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().remove(siiConsolidadoDist);
        siiConsolidadoDist.setSiiUbicacion(null);
        return siiConsolidadoDist;
    }
    
    @OneToMany(mappedBy = "siiUbicacionPadre")
    public List<SiiUbicacion> getSiiUbicacionHijoList() {
        return siiUbicacionHijoList;
    }

    public void setSiiUbicacionHijoList(List<SiiUbicacion> siiUbicacionHijoList) {
        this.siiUbicacionHijoList = siiUbicacionHijoList;
    }

    public SiiUbicacion addSiiUbicacion(SiiUbicacion siiUbicacion) {
        getSiiUbicacionHijoList().add(siiUbicacion);
        siiUbicacion.setSiiUbicacionPadre(this);
        return siiUbicacion;
    }

    public SiiUbicacion removeSiiUbicacion(SiiUbicacion siiUbicacion) {
        getSiiUbicacionHijoList().remove(siiUbicacion);
        siiUbicacion.setSiiUbicacionPadre(null);
        return siiUbicacion;
    }

    @OneToMany(mappedBy = "siiUbicacionLocal")
    public List<SiiDenuncia> getSiiDenunciaLocalList() {
        return siiDenunciaLocalList;
    }

    public void setSiiDenunciaLocalList(List<SiiDenuncia> siiDenunciaLocalList) {
        this.siiDenunciaLocalList = siiDenunciaLocalList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaLocalList().add(siiDenuncia);
        siiDenuncia.setSiiUbicacionLocal(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaLocalList().remove(siiDenuncia);
        siiDenuncia.setSiiUbicacionLocal(null);
        return siiDenuncia;
    }

    @OneToMany(mappedBy = "siiUbicacionDenunciante")
    public List<SiiDenuncia> getSiiDenunciaDenuncianteList() {
        return siiDenunciaDenuncianteList;
    }

    public void setSiiDenunciaDenuncianteList(List<SiiDenuncia> siiDenunciaDenuncianteList) {
        this.siiDenunciaDenuncianteList = siiDenunciaDenuncianteList;
    }
    
        @OneToMany(mappedBy = "siiUbicacionMunicipio")
    public List<SiiMunicipioOrdenTrab> getSiiMunicipioOrdenTrabMunicipioList() {
        return siiMunicipioOrdenTrabMunicipioList;
    }

    public void setSiiMunicipioOrdenTrabMunicipioList(List<SiiMunicipioOrdenTrab> siiMunicipioOrdenTrabMunicipioList) {
        this.siiMunicipioOrdenTrabMunicipioList = siiMunicipioOrdenTrabMunicipioList;
    }

    public SiiMunicipioOrdenTrab addSiiMunicipioOrdenTrab(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        getSiiMunicipioOrdenTrabMunicipioList().add(siiMunicipioOrdenTrab);
        siiMunicipioOrdenTrab.setSiiUbicacionMunicipio(this);
        return siiMunicipioOrdenTrab;
    }

    public SiiMunicipioOrdenTrab removeSiiMunicipioOrdenTrab(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        getSiiMunicipioOrdenTrabMunicipioList().remove(siiMunicipioOrdenTrab);
        siiMunicipioOrdenTrab.setSiiUbicacionMunicipio(null);
        return siiMunicipioOrdenTrab;
    }
    
    @OneToMany(mappedBy = "siiUbicacionMunicipio")
    public List<SiiBarrioOrden> getSiiBarrioOrdenMunicipioList() {
        return siiBarrioOrdenMunicipioList;
    }

    public void setSiiBarrioOrdenMunicipioList(List<SiiBarrioOrden> siiBarrioOrdenMunicipioList) {
        this.siiBarrioOrdenMunicipioList = siiBarrioOrdenMunicipioList;
    }

    public SiiBarrioOrden addSiiBarrioOrden(SiiBarrioOrden siiBarrioOrden) {
        getSiiBarrioOrdenMunicipioList().add(siiBarrioOrden);
        siiBarrioOrden.setSiiUbicacionMunicipio(this);
        return siiBarrioOrden;
    }

    public SiiBarrioOrden removeSiiBarrioOrden(SiiBarrioOrden siiBarrioOrden) {
        getSiiBarrioOrdenMunicipioList().remove(siiBarrioOrden);
        siiBarrioOrden.setSiiUbicacionMunicipio(null);
        return siiBarrioOrden;
    }

    @OneToMany(mappedBy = "siiUbicacionMunicDenunciado")
    public List<SiiDenuncia> getSiiDenunciaMunDenunciadoList() {
        return siiDenunciaMunDenunciadoList;
    }

    public void setSiiDenunciaMunDenunciadoList(List<SiiDenuncia> siiDenunciaMunDenunciadoList) {
        this.siiDenunciaMunDenunciadoList = siiDenunciaMunDenunciadoList;
    }
    
    @OneToMany(mappedBy = "siiUbicacionMunEstab")
    public List<SiiLiquidacionEstabl> getSiiLiquidacionEstablMunEstabList() {
        return siiLiquidacionEstablMunEstabList;
    }

    public void setSiiLiquidacionEstablMunEstabList(List<SiiLiquidacionEstabl> siiLiquidacionEstablMunEstabList) {
        this.siiLiquidacionEstablMunEstabList = siiLiquidacionEstablMunEstabList;
    }

    public SiiLiquidacionEstabl addSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablMunEstabList().add(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiUbicacionMunEstab(this);
        return siiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl removeSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablMunEstabList().remove(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiUbicacionMunEstab(null);
        return siiLiquidacionEstabl;
    }

    @OneToMany(mappedBy = "siiUbicacionMunEst")
    public List<SiiHlpLiqEstablAsigRec> getSiiHlpLiqEstablAsigRecMunEstList() {
        return siiHlpLiqEstablAsigRecMunEstList;
    }

    public void setSiiHlpLiqEstablAsigRecMunEstList(List<SiiHlpLiqEstablAsigRec> siiHlpLiqEstablAsigRecMunEstList) {
        this.siiHlpLiqEstablAsigRecMunEstList = siiHlpLiqEstablAsigRecMunEstList;
    }

    public SiiHlpLiqEstablAsigRec addSiiHlpLiqEstablAsigRec(SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec) {
        getSiiHlpLiqEstablAsigRecMunEstList().add(siiHlpLiqEstablAsigRec);
        siiHlpLiqEstablAsigRec.setSiiUbicacionMunEst(this);
        return siiHlpLiqEstablAsigRec;
    }

    public SiiHlpLiqEstablAsigRec removeSiiHlpLiqEstablAsigRec(SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec) {
        getSiiHlpLiqEstablAsigRecMunEstList().remove(siiHlpLiqEstablAsigRec);
        siiHlpLiqEstablAsigRec.setSiiUbicacionMunEst(null);
        return siiHlpLiqEstablAsigRec;
    }

    @OneToMany(mappedBy = "siiUbicacion")
    public List<SiiAsigRecaudoAaEstabl> getSiiAsigRecaudoAaEstablList() {
        return siiAsigRecaudoAaEstablList;
    }

    public void setSiiAsigRecaudoAaEstablList(List<SiiAsigRecaudoAaEstabl> siiAsigRecaudoAaEstablList) {
        this.siiAsigRecaudoAaEstablList = siiAsigRecaudoAaEstablList;
    }

    public SiiAsigRecaudoAaEstabl addSiiAsigRecaudoAaEstabl(SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl) {
        getSiiAsigRecaudoAaEstablList().add(siiAsigRecaudoAaEstabl);
        siiAsigRecaudoAaEstabl.setSiiUbicacion(this);
        return siiAsigRecaudoAaEstabl;
    }

    public SiiAsigRecaudoAaEstabl removeSiiAsigRecaudoAaEstabl(SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl) {
        getSiiAsigRecaudoAaEstablList().remove(siiAsigRecaudoAaEstabl);
        siiAsigRecaudoAaEstabl.setSiiUbicacion(null);
        return siiAsigRecaudoAaEstabl;
    }

    @OneToMany(mappedBy = "siiUbicacionMunic")
    public List<SiiAutoComisorioAccCon> getSiiAutoComisorioAccConMunicList(){
        return siiAutoComisorioAccConMunicList;
    }

    public void setSiiAutoComisorioAccConMunicList(List<SiiAutoComisorioAccCon> siiAutoComisorioAccConMunicList){
        this.siiAutoComisorioAccConMunicList = siiAutoComisorioAccConMunicList;
    }

    public SiiAutoComisorioAccCon addSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConMunicList().add(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiUbicacionMunic(this);
        return siiAutoComisorioAccCon;
    }

    public SiiAutoComisorioAccCon removeSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConMunicList().remove(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiUbicacionMunic(null);
        return siiAutoComisorioAccCon;
    }

    @OneToMany(mappedBy = "siiUbicacionMunic")
    public List<SiiDireccionPersonaAtien> getSiiDireccionPersonaAtienMunicList(){
        return siiDireccionPersonaAtienMunicList;
    }

    public void setSiiDireccionPersonaAtienMunicList(List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienMunicList){
        this.siiDireccionPersonaAtienMunicList = siiDireccionPersonaAtienMunicList;
    }

    public SiiDireccionPersonaAtien addSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienMunicList().add(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiUbicacionMunic(this);
        return siiDireccionPersonaAtien;
    }

    public SiiDireccionPersonaAtien removeSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienMunicList().remove(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiUbicacionMunic(null);
        return siiDireccionPersonaAtien;
    }

    @OneToMany(mappedBy = "siiUbicacionMunic")
    public List<SiiAccionControl> getSiiAccionControlMunicList(){
        return siiAccionControlMunicList;
    }

    public void setSiiAccionControlMunicList(List<SiiAccionControl> siiAccionControlMunicList){
        this.siiAccionControlMunicList = siiAccionControlMunicList;
    }

    public SiiAccionControl addSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlMunicList().add(siiAccionControl);
        siiAccionControl.setSiiUbicacionMunic(this);
        return siiAccionControl;
    }

    public SiiAccionControl removeSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlMunicList().remove(siiAccionControl);
        siiAccionControl.setSiiUbicacionMunic(null);
        return siiAccionControl;
    }

    @OneToMany(mappedBy = "siiUbicacionMunic")
    public List<SiiActaDestruccion> getSiiActaDestruccionMunicList(){
        return siiActaDestruccionMunicList;
    }

    public void setSiiActaDestruccionMunicList(List<SiiActaDestruccion> siiActaDestruccionMunicList){
        this.siiActaDestruccionMunicList = siiActaDestruccionMunicList;
    }

    public SiiActaDestruccion addSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionMunicList().add(siiActaDestruccion);
        siiActaDestruccion.setSiiUbicacionMunic(this);
        return siiActaDestruccion;
    }

    public SiiActaDestruccion removeSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionMunicList().remove(siiActaDestruccion);
        siiActaDestruccion.setSiiUbicacionMunic(null);
        return siiActaDestruccion;
    }
    
    @OneToMany(mappedBy = "siiUbicacionMunicipio")
    public List<SiiEstablecConCuoCar> getSiiEstablecConCuoCarUbiMunList() {
        return siiEstablecConCuoCarUbiMunList;
    }

    public void setSiiEstablecConCuoCarUbiMunList(List<SiiEstablecConCuoCar> siiEstablecConCuoCarUbiMunList) {
        this.siiEstablecConCuoCarUbiMunList = siiEstablecConCuoCarUbiMunList;
    }

    public SiiEstablecConCuoCar addSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarUbiMunList().add(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiUbicacionMunicipio(this);
        return siiEstablecConCuoCar;
    }

    public SiiEstablecConCuoCar removeSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarUbiMunList().remove(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiUbicacionMunicipio(null);
        return siiEstablecConCuoCar;
    }

    @OneToMany(mappedBy = "siiUbicacion")
    public List<SiiDireccionProcePerIle> getSiiDireccionProcePerIleList() {
        return siiDireccionProcePerIleList;
    }

    public void setSiiDireccionProcePerIleList(List<SiiDireccionProcePerIle> siiDireccionProcePerIleList) {
        this.siiDireccionProcePerIleList = siiDireccionProcePerIleList;
    }

    public SiiDireccionProcePerIle addSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().add(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiUbicacion(this);
        return siiDireccionProcePerIle;
    }

    public SiiDireccionProcePerIle removeSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().remove(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiUbicacion(null);
        return siiDireccionProcePerIle;
    }

    @OneToMany(mappedBy = "siiUbicacionMunicipio")
    public List<SiiDireccionPersona> getSiiDireccionPersonaUbiMunList() {
        return siiDireccionPersonaUbiMunList;
    }

    public void setSiiDireccionPersonaUbiMunList(List<SiiDireccionPersona> siiDireccionPersonaUbiMunList) {
        this.siiDireccionPersonaUbiMunList = siiDireccionPersonaUbiMunList;
    }

    public SiiDireccionPersona addSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaUbiMunList().add(siiDireccionPersona);
        siiDireccionPersona.setSiiUbicacionMunicipio(this);
        return siiDireccionPersona;
    }

    public SiiDireccionPersona removeSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaUbiMunList().remove(siiDireccionPersona);
        siiDireccionPersona.setSiiUbicacionMunicipio(null);
        return siiDireccionPersona;
    }
}
