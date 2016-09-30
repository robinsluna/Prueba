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
@Table(name = "SII_HIST_PERSONA")
public class SiiHistPersona implements Serializable {
    private static final long serialVersionUID = -4544286440162234101L;
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
    private List<SiiHistPersonalEmp> siiHistPersonalEmpEmpresaList;
    private SiiUbicacion siiUbicacion;
    private SiiTipoRetencion siiTipoRetencionVent;
    private SiiTipoRetencion siiTipoRetencionRent;
    private SiiPersona siiPersonaOrigen;
    private List<SiiHistPersonalEmp> siiHistPersonalEmpPersonaList;
    private SiiHistPersona siiHistPersonaRepLegal;
    private List<SiiHistPersona> siiHistPersonaRepLegalList;
    private SiiTipoIdentificacion siiTipoIdentificacion;

    public SiiHistPersona() {
    }

    public SiiHistPersona(String hpeCelular, Long hpeCodigo, SiiHistPersona siiHistPersonaRepLegal,
                          Integer hpeDigitoVerif, String hpeDireccion, String hpeEmail, String hpeFax,
                          String hpeJurNombreCorto, String hpeJurNombreLargo, String hpeNumIdentificacion,
                          String hpeOrigen, String hpePrimerApellido, String hpePrimerNombre, String hpeSegundoApellido,
                          String hpeSegundoNombre, String hpeTelefono, String hpeTelefono2, String hpeTipoPersona,
                          String hpeTipoProveedor, SiiPersona siiPersonaOrigen, Long rdiCodigoRenta,
                          Long rdiCodigoVentas, SiiTipoIdentificacion siiTipoIdentificacion, Long treCodigo,
                          SiiTipoRetencion siiTipoRetencionRent, SiiTipoRetencion siiTipoRetencionVent,
                          SiiUbicacion siiUbicacion) {
        this.hpeCelular = hpeCelular;
        this.hpeCodigo = hpeCodigo;
        this.siiHistPersonaRepLegal = siiHistPersonaRepLegal;
        this.hpeDigitoVerif = hpeDigitoVerif;
        this.hpeDireccion = hpeDireccion;
        this.hpeEmail = hpeEmail;
        this.hpeFax = hpeFax;
        this.hpeJurNombreCorto = hpeJurNombreCorto;
        this.hpeJurNombreLargo = hpeJurNombreLargo;
        this.hpeNumIdentificacion = hpeNumIdentificacion;
        this.hpeOrigen = hpeOrigen;
        this.hpePrimerApellido = hpePrimerApellido;
        this.hpePrimerNombre = hpePrimerNombre;
        this.hpeSegundoApellido = hpeSegundoApellido;
        this.hpeSegundoNombre = hpeSegundoNombre;
        this.hpeTelefono = hpeTelefono;
        this.hpeTelefono2 = hpeTelefono2;
        this.hpeTipoPersona = hpeTipoPersona;
        this.hpeTipoProveedor = hpeTipoProveedor;
        this.siiPersonaOrigen = siiPersonaOrigen;
        this.rdiCodigoRenta = rdiCodigoRenta;
        this.rdiCodigoVentas = rdiCodigoVentas;
        this.siiTipoIdentificacion = siiTipoIdentificacion;
        this.treCodigo = treCodigo;
        this.siiTipoRetencionRent = siiTipoRetencionRent;
        this.siiTipoRetencionVent = siiTipoRetencionVent;
        this.siiUbicacion = siiUbicacion;
    }

    @Column(name = "HPE_CELULAR", length = 50)
    public String getHpeCelular() {
        return hpeCelular;
    }

    public void setHpeCelular(String hpeCelular) {
        this.hpeCelular = hpeCelular;
    }

    @Id
    @Column(name = "HPE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HIST_PERSONA_COD")
    @SequenceGenerator(name = "SEQ_HIST_PERSONA_COD", sequenceName = "SEQ_HIST_PERSONA_COD",allocationSize=1)
    public Long getHpeCodigo() {
        return hpeCodigo;
    }

    public void setHpeCodigo(Long hpeCodigo) {
        this.hpeCodigo = hpeCodigo;
    }


    @Column(name = "HPE_DIGITO_VERIF")
    public Integer getHpeDigitoVerif() {
        return hpeDigitoVerif;
    }

    public void setHpeDigitoVerif(Integer hpeDigitoVerif) {
        this.hpeDigitoVerif = hpeDigitoVerif;
    }

    @Column(name = "HPE_DIRECCION", length = 100)
    public String getHpeDireccion() {
        return hpeDireccion;
    }

    public void setHpeDireccion(String hpeDireccion) {
        this.hpeDireccion = hpeDireccion;
    }

    @Column(name = "HPE_EMAIL", length = 50)
    public String getHpeEmail() {
        return hpeEmail;
    }

    public void setHpeEmail(String hpeEmail) {
        this.hpeEmail = hpeEmail;
    }

    @Column(name = "HPE_FAX", length = 20)
    public String getHpeFax() {
        return hpeFax;
    }

    public void setHpeFax(String hpeFax) {
        this.hpeFax = hpeFax;
    }

    @Column(name = "HPE_JUR_NOMBRE_CORTO", length = 50)
    public String getHpeJurNombreCorto() {
        return hpeJurNombreCorto;
    }

    public void setHpeJurNombreCorto(String hpeJurNombreCorto) {
        this.hpeJurNombreCorto = hpeJurNombreCorto;
    }

    @Column(name = "HPE_JUR_NOMBRE_LARGO", length = 100)
    public String getHpeJurNombreLargo() {
        return hpeJurNombreLargo;
    }

    public void setHpeJurNombreLargo(String hpeJurNombreLargo) {
        this.hpeJurNombreLargo = hpeJurNombreLargo;
    }

    @Column(name = "HPE_NUM_IDENTIFICACION", nullable = false, length = 20)
    public String getHpeNumIdentificacion() {
        return hpeNumIdentificacion;
    }

    public void setHpeNumIdentificacion(String hpeNumIdentificacion) {
        this.hpeNumIdentificacion = hpeNumIdentificacion;
    }

    @Column(name = "HPE_ORIGEN", length = 1)
    public String getHpeOrigen() {
        return hpeOrigen;
    }

    public void setHpeOrigen(String hpeOrigen) {
        this.hpeOrigen = hpeOrigen;
    }

    @Column(name = "HPE_PRIMER_APELLIDO", length = 20)
    public String getHpePrimerApellido() {
        return hpePrimerApellido;
    }

    public void setHpePrimerApellido(String hpePrimerApellido) {
        this.hpePrimerApellido = hpePrimerApellido;
    }

    @Column(name = "HPE_PRIMER_NOMBRE", length = 30)
    public String getHpePrimerNombre() {
        return hpePrimerNombre;
    }

    public void setHpePrimerNombre(String hpePrimerNombre) {
        this.hpePrimerNombre = hpePrimerNombre;
    }

    @Column(name = "HPE_SEGUNDO_APELLIDO", length = 20)
    public String getHpeSegundoApellido() {
        return hpeSegundoApellido;
    }

    public void setHpeSegundoApellido(String hpeSegundoApellido) {
        this.hpeSegundoApellido = hpeSegundoApellido;
    }

    @Column(name = "HPE_SEGUNDO_NOMBRE", length = 20)
    public String getHpeSegundoNombre() {
        return hpeSegundoNombre;
    }

    public void setHpeSegundoNombre(String hpeSegundoNombre) {
        this.hpeSegundoNombre = hpeSegundoNombre;
    }

    @Column(name = "HPE_TELEFONO", length = 20)
    public String getHpeTelefono() {
        return hpeTelefono;
    }

    public void setHpeTelefono(String hpeTelefono) {
        this.hpeTelefono = hpeTelefono;
    }

    @Column(name = "HPE_TELEFONO2", length = 20)
    public String getHpeTelefono2() {
        return hpeTelefono2;
    }

    public void setHpeTelefono2(String hpeTelefono2) {
        this.hpeTelefono2 = hpeTelefono2;
    }

    @Column(name = "HPE_TIPO_PERSONA", nullable = false, length = 1)
    public String getHpeTipoPersona() {
        return hpeTipoPersona;
    }

    public void setHpeTipoPersona(String hpeTipoPersona) {
        this.hpeTipoPersona = hpeTipoPersona;
    }

    @Column(name = "HPE_TIPO_PROVEEDOR", length = 1)
    public String getHpeTipoProveedor() {
        return hpeTipoProveedor;
    }

    public void setHpeTipoProveedor(String hpeTipoProveedor) {
        this.hpeTipoProveedor = hpeTipoProveedor;
    }


    @Column(name = "RDI_CODIGO_RENTA")
    public Long getRdiCodigoRenta() {
        return rdiCodigoRenta;
    }

    public void setRdiCodigoRenta(Long rdiCodigoRenta) {
        this.rdiCodigoRenta = rdiCodigoRenta;
    }

    @Column(name = "RDI_CODIGO_VENTAS")
    public Long getRdiCodigoVentas() {
        return rdiCodigoVentas;
    }

    public void setRdiCodigoVentas(Long rdiCodigoVentas) {
        this.rdiCodigoVentas = rdiCodigoVentas;
    }


    @Column(name = "TRE_CODIGO")
    public Long getTreCodigo() {
        return treCodigo;
    }

    public void setTreCodigo(Long treCodigo) {
        this.treCodigo = treCodigo;
    }


    @OneToMany(mappedBy = "siiHistPersonaEmpresa")
    public List<SiiHistPersonalEmp> getSiiHistPersonalEmpEmpresaList() {
        return siiHistPersonalEmpEmpresaList;
    }

    public void setSiiHistPersonalEmpEmpresaList(List<SiiHistPersonalEmp> siiHistPersonalEmpEmpresaList) {
        this.siiHistPersonalEmpEmpresaList = siiHistPersonalEmpEmpresaList;
    }

    public SiiHistPersonalEmp addSiiHistPersonalEmp(SiiHistPersonalEmp siiHistPersonalEmp) {
        getSiiHistPersonalEmpEmpresaList().add(siiHistPersonalEmp);
        siiHistPersonalEmp.setSiiHistPersonaEmpresa(this);
        return siiHistPersonalEmp;
    }

    public SiiHistPersonalEmp removeSiiHistPersonalEmp(SiiHistPersonalEmp siiHistPersonalEmp) {
        getSiiHistPersonalEmpEmpresaList().remove(siiHistPersonalEmp);
        siiHistPersonalEmp.setSiiHistPersonaEmpresa(null);
        return siiHistPersonalEmp;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion() {
        return siiUbicacion;
    }

    public void setSiiUbicacion(SiiUbicacion siiUbicacion) {
        this.siiUbicacion = siiUbicacion;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_VENTAS")
    public SiiTipoRetencion getSiiTipoRetencionVent() {
        return siiTipoRetencionVent;
    }

    public void setSiiTipoRetencionVent(SiiTipoRetencion siiTipoRetencionVent) {
        this.siiTipoRetencionVent = siiTipoRetencionVent;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_RENTA")
    public SiiTipoRetencion getSiiTipoRetencionRent() {
        return siiTipoRetencionRent;
    }

    public void setSiiTipoRetencionRent(SiiTipoRetencion siiTipoRetencionRent) {
        this.siiTipoRetencionRent = siiTipoRetencionRent;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersonaOrigen() {
        return siiPersonaOrigen;
    }

    public void setSiiPersonaOrigen(SiiPersona siiPersonaOrigen) {
        this.siiPersonaOrigen = siiPersonaOrigen;
    }

    @OneToMany(mappedBy = "siiHistPersonaPersona")
    public List<SiiHistPersonalEmp> getSiiHistPersonalEmpPersonaList() {
        return siiHistPersonalEmpPersonaList;
    }

    public void setSiiHistPersonalEmpPersonaList(List<SiiHistPersonalEmp> siiHistPersonalEmpPersonaList) {
        this.siiHistPersonalEmpPersonaList = siiHistPersonalEmpPersonaList;
    }

    @ManyToOne
    @JoinColumn(name = "HPE_CODIGO_REPRESENTANTE")
    public SiiHistPersona getSiiHistPersonaRepLegal() {
        return siiHistPersonaRepLegal;
    }

    public void setSiiHistPersonaRepLegal(SiiHistPersona siiHistPersonaRepLegal) {
        this.siiHistPersonaRepLegal = siiHistPersonaRepLegal;
    }

    @OneToMany(mappedBy = "siiHistPersonaRepLegal")
    public List<SiiHistPersona> getSiiHistPersonaRepLegalList() {
        return siiHistPersonaRepLegalList;
    }

    public void setSiiHistPersonaRepLegalList(List<SiiHistPersona> siiHistPersonaRepLegalList) {
        this.siiHistPersonaRepLegalList = siiHistPersonaRepLegalList;
    }

    public SiiHistPersona addSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaRepLegalList().add(siiHistPersona);
        siiHistPersona.setSiiHistPersonaRepLegal(this);
        return siiHistPersona;
    }

    public SiiHistPersona removeSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaRepLegalList().remove(siiHistPersona);
        siiHistPersona.setSiiHistPersonaRepLegal(null);
        return siiHistPersona;
    }

    @ManyToOne
    @JoinColumn(name = "TID_CODIGO")
    public SiiTipoIdentificacion getSiiTipoIdentificacion() {
        return siiTipoIdentificacion;
    }

    public void setSiiTipoIdentificacion(SiiTipoIdentificacion siiTipoIdentificacion) {
        this.siiTipoIdentificacion = siiTipoIdentificacion;
    }
}
