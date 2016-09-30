package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersona;

import java.util.ArrayList;
import java.util.List;

/**
 * author Giovanni
 */
public class HistPersonaVO {

    private String hpeCelular;
    private Long hpeCodigo;
    private Integer hpeDigitoVerif;
    private String hpeDireccion;
    private String hpeEmail;
    private String hpeFax;
    private String hpeJurNombreCorto;
    private String hpeJurNombreLargo;
    private String hpeNumIdentificacion;
    private String hpeOrigen;
    private String hpePrimerApellido;
    private String hpePrimerNombre;
    private String hpeSegundoApellido;
    private String hpeSegundoNombre;
    private String hpeTelefono;
    private String hpeTelefono2;
    private String hpeTipoPersona;
    private String hpeTipoProveedor;
    private Long rdiCodigoRenta;
    private Long rdiCodigoVentas;
    private Long treCodigo;
    private List<HistPersonalEmpVO> histPersonalEmpEmpresaListVO;
    private UbicacionVO ubicacionVO;
    private TipoRetencionVO tipoRetencionVentVO;
    private TipoRetencionVO tipoRetencionRentVO;
    private PersonaVO personaOrigenVO;
    private List<HistPersonalEmpVO> histPersonalEmpPersonaListVO;
    private HistPersonaVO histPersonaRepLegalVO;
    private List<HistPersonaVO> histPersonaRepLegalListVO;
    private TipoIdentificacionVO tipoIdentificacionVO;

    public HistPersonaVO() {

    }

    public HistPersonaVO(SiiHistPersona siiHistPersona) {

        this.hpeCelular = siiHistPersona.getHpeCelular();
        this.hpeCodigo = siiHistPersona.getHpeCodigo();
        this.hpeDigitoVerif = siiHistPersona.getHpeDigitoVerif();
        this.hpeDireccion = siiHistPersona.getHpeDireccion();
        this.hpeEmail = siiHistPersona.getHpeEmail();
        this.hpeFax = siiHistPersona.getHpeFax();
        this.hpeJurNombreCorto = siiHistPersona.getHpeJurNombreCorto();
        this.hpeJurNombreLargo = siiHistPersona.getHpeJurNombreLargo();
        this.hpeNumIdentificacion = siiHistPersona.getHpeNumIdentificacion();
        this.hpeOrigen = siiHistPersona.getHpeOrigen();
        this.hpePrimerApellido = siiHistPersona.getHpePrimerApellido();
        this.hpePrimerNombre = siiHistPersona.getHpePrimerNombre();
        this.hpeSegundoApellido = siiHistPersona.getHpeSegundoApellido();
        this.hpeSegundoNombre = siiHistPersona.getHpeSegundoNombre();
        this.hpeTelefono = siiHistPersona.getHpeTelefono();
        this.hpeTelefono2 = siiHistPersona.getHpeTelefono2();
        this.hpeTipoPersona = siiHistPersona.getHpeTipoPersona();
        this.hpeTipoProveedor = siiHistPersona.getHpeTipoProveedor();
        this.rdiCodigoRenta = siiHistPersona.getRdiCodigoRenta();
        this.rdiCodigoVentas = siiHistPersona.getRdiCodigoVentas();
        this.treCodigo = siiHistPersona.getTreCodigo();

        this.histPersonalEmpEmpresaListVO = new ArrayList<HistPersonalEmpVO>();

        if (siiHistPersona.getSiiUbicacion() != null && !siiHistPersona.getSiiUbicacion().getUbiCodigo().equals("")) {
            this.ubicacionVO = new UbicacionVO();
            this.ubicacionVO.setUbiCodigo(siiHistPersona.getSiiUbicacion().getUbiCodigo());
        }

        if (siiHistPersona.getSiiTipoRetencionVent() != null &&
            !siiHistPersona.getSiiTipoRetencionVent().getTreCodigo().equals("")) {
            this.tipoRetencionVentVO = new TipoRetencionVO();
            this.tipoRetencionVentVO.setTreCodigo(siiHistPersona.getSiiTipoRetencionVent().getTreCodigo());
        }

        if (siiHistPersona.getSiiTipoRetencionRent() != null &&
            !siiHistPersona.getSiiTipoRetencionRent().getTreCodigo().equals("")) {
            this.tipoRetencionRentVO = new TipoRetencionVO();
            this.tipoRetencionRentVO.setTreCodigo(siiHistPersona.getSiiTipoRetencionRent().getTreCodigo());
        }

        if (siiHistPersona.getSiiPersonaOrigen() != null && siiHistPersona.getSiiPersonaOrigen().getPerCodigo() > 0) {
            this.personaOrigenVO = new PersonaVO();
            this.personaOrigenVO.setPerCodigo(siiHistPersona.getSiiPersonaOrigen().getPerCodigo());
        }

        this.histPersonalEmpPersonaListVO = new ArrayList<>();

        if (siiHistPersona.getSiiHistPersonaRepLegal() != null &&
            !siiHistPersona.getSiiHistPersonaRepLegal().getTreCodigo().equals("")) {
            this.histPersonaRepLegalVO = new HistPersonaVO();
            this.histPersonaRepLegalVO.setTreCodigo(siiHistPersona.getSiiHistPersonaRepLegal().getTreCodigo());
        }

        this.histPersonaRepLegalListVO = new ArrayList<HistPersonaVO>();

        if (siiHistPersona.getSiiTipoIdentificacion() != null &&
            siiHistPersona.getSiiTipoIdentificacion().getTidCodigo() > 0) {
            this.tipoIdentificacionVO = new TipoIdentificacionVO();
            this.tipoIdentificacionVO.setTidCodigo(siiHistPersona.getHpeCodigo());
        }

    }


    public String getHpeCelular() {
        return hpeCelular;
    }

    public void setHpeCelular(String hpeCelular) {
        this.hpeCelular = hpeCelular;
    }

    public Long getHpeCodigo() {
        return hpeCodigo;
    }

    public void setHpeCodigo(Long hpeCodigo) {
        this.hpeCodigo = hpeCodigo;
    }

    public Integer getHpeDigitoVerif() {
        return hpeDigitoVerif;
    }

    public void setHpeDigitoVerif(Integer hpeDigitoVerif) {
        this.hpeDigitoVerif = hpeDigitoVerif;
    }

    public String getHpeDireccion() {
        return hpeDireccion;
    }

    public void setHpeDireccion(String hpeDireccion) {
        this.hpeDireccion = hpeDireccion;
    }

    public String getHpeEmail() {
        return hpeEmail;
    }

    public void setHpeEmail(String hpeEmail) {
        this.hpeEmail = hpeEmail;
    }

    public String getHpeFax() {
        return hpeFax;
    }

    public void setHpeFax(String hpeFax) {
        this.hpeFax = hpeFax;
    }

    public String getHpeJurNombreCorto() {
        return hpeJurNombreCorto;
    }

    public void setHpeJurNombreCorto(String hpeJurNombreCorto) {
        this.hpeJurNombreCorto = hpeJurNombreCorto;
    }

    public String getHpeJurNombreLargo() {
        return hpeJurNombreLargo;
    }

    public void setHpeJurNombreLargo(String hpeJurNombreLargo) {
        this.hpeJurNombreLargo = hpeJurNombreLargo;
    }

    public String getHpeNumIdentificacion() {
        return hpeNumIdentificacion;
    }

    public void setHpeNumIdentificacion(String hpeNumIdentificacion) {
        this.hpeNumIdentificacion = hpeNumIdentificacion;
    }

    public String getHpeOrigen() {
        return hpeOrigen;
    }

    public void setHpeOrigen(String hpeOrigen) {
        this.hpeOrigen = hpeOrigen;
    }

    public String getHpePrimerApellido() {
        return hpePrimerApellido;
    }

    public void setHpePrimerApellido(String hpePrimerApellido) {
        this.hpePrimerApellido = hpePrimerApellido;
    }

    public String getHpePrimerNombre() {
        return hpePrimerNombre;
    }

    public void setHpePrimerNombre(String hpePrimerNombre) {
        this.hpePrimerNombre = hpePrimerNombre;
    }

    public String getHpeSegundoApellido() {
        return hpeSegundoApellido;
    }

    public void setHpeSegundoApellido(String hpeSegundoApellido) {
        this.hpeSegundoApellido = hpeSegundoApellido;
    }

    public String getHpeSegundoNombre() {
        return hpeSegundoNombre;
    }

    public void setHpeSegundoNombre(String hpeSegundoNombre) {
        this.hpeSegundoNombre = hpeSegundoNombre;
    }

    public String getHpeTelefono() {
        return hpeTelefono;
    }

    public void setHpeTelefono(String hpeTelefono) {
        this.hpeTelefono = hpeTelefono;
    }

    public String getHpeTelefono2() {
        return hpeTelefono2;
    }

    public void setHpeTelefono2(String hpeTelefono2) {
        this.hpeTelefono2 = hpeTelefono2;
    }

    public String getHpeTipoPersona() {
        return hpeTipoPersona;
    }

    public void setHpeTipoPersona(String hpeTipoPersona) {
        this.hpeTipoPersona = hpeTipoPersona;
    }

    public String getHpeTipoProveedor() {
        return hpeTipoProveedor;
    }

    public void setHpeTipoProveedor(String hpeTipoProveedor) {
        this.hpeTipoProveedor = hpeTipoProveedor;
    }

    public Long getRdiCodigoRenta() {
        return rdiCodigoRenta;
    }

    public void setRdiCodigoRenta(Long rdiCodigoRenta) {
        this.rdiCodigoRenta = rdiCodigoRenta;
    }

    public Long getRdiCodigoVentas() {
        return rdiCodigoVentas;
    }

    public void setRdiCodigoVentas(Long rdiCodigoVentas) {
        this.rdiCodigoVentas = rdiCodigoVentas;
    }

    public Long getTreCodigo() {
        return treCodigo;
    }

    public void setTreCodigo(Long treCodigo) {
        this.treCodigo = treCodigo;
    }

    public List<HistPersonalEmpVO> getHistPersonalEmpEmpresaListVO() {
        return histPersonalEmpEmpresaListVO;
    }

    public void setHistPersonalEmpEmpresaListVO(List<HistPersonalEmpVO> histPersonalEmpEmpresaListVO) {
        this.histPersonalEmpEmpresaListVO = histPersonalEmpEmpresaListVO;
    }

    public UbicacionVO getUbicacionVO() {
        return ubicacionVO;
    }

    public void setUbicacionVO(UbicacionVO ubicacionVO) {
        this.ubicacionVO = ubicacionVO;
    }

    public TipoRetencionVO getTipoRetencionVentVO() {
        return tipoRetencionVentVO;
    }

    public void setTipoRetencionVentVO(TipoRetencionVO tipoRetencionVentVO) {
        this.tipoRetencionVentVO = tipoRetencionVentVO;
    }

    public TipoRetencionVO getTipoRetencionRentVO() {
        return tipoRetencionRentVO;
    }

    public void setTipoRetencionRentVO(TipoRetencionVO tipoRetencionRentVO) {
        this.tipoRetencionRentVO = tipoRetencionRentVO;
    }

    public PersonaVO getPersonaOrigenVO() {
        return personaOrigenVO;
    }

    public void setPersonaOrigenVO(PersonaVO personaOrigenVO) {
        this.personaOrigenVO = personaOrigenVO;
    }

    public List<HistPersonalEmpVO> getHistPersonalEmpPersonaListVO() {
        return histPersonalEmpPersonaListVO;
    }

    public void setHistPersonalEmpPersonaListVO(List<HistPersonalEmpVO> histPersonalEmpPersonaListVO) {
        this.histPersonalEmpPersonaListVO = histPersonalEmpPersonaListVO;
    }

    public HistPersonaVO getHistPersonaRepLegalVO() {
        return histPersonaRepLegalVO;
    }

    public void setHistPersonaRepLegalVO(HistPersonaVO histPersonaRepLegalVO) {
        this.histPersonaRepLegalVO = histPersonaRepLegalVO;
    }

    public List<HistPersonaVO> getHistPersonaRepLegalListVO() {
        return histPersonaRepLegalListVO;
    }

    public void setHistPersonaRepLegalListVO(List<HistPersonaVO> histPersonaRepLegalListVO) {
        this.histPersonaRepLegalListVO = histPersonaRepLegalListVO;
    }

    public TipoIdentificacionVO getTipoIdentificacionVO() {
        return tipoIdentificacionVO;
    }

    public void setTipoIdentificacionVO(TipoIdentificacionVO tipoIdentificacionVO) {
        this.tipoIdentificacionVO = tipoIdentificacionVO;
    }
}
