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
@Table(name = "SII_PROVEEDOR")
public class SiiProveedor implements Serializable {
    private static final long serialVersionUID = -7885104445340941885L;
    private Long proCodigo;
    private String proEjecutivoCuenta;
    private List<SiiCotizacionEstudio> siiCotizacionEstudioList1;
    private SiiPersona siiPersona;
    private List<SiiProveedorInvitacion> siiProveedorInvitacionList;
    private List<SiiPropuestaRecib> siiPropuestaRecibList;
    private List<SiiOficioAdjudica> siiOficioAdjudicaList1;
    private List<SiiRp> siiRpList;
    private List<SiiOrdenPago> siiOrdenPagoList;

    public SiiProveedor() {
    }

    public SiiProveedor(SiiPersona siiPersona, Long proCodigo, String proEjecutivoCuenta) {
        this.siiPersona = siiPersona;
        this.proCodigo = proCodigo;
        this.proEjecutivoCuenta = proEjecutivoCuenta;
    }

    @Id
    @Column(name = "PRO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROVEEDOR_CODIGO")
    @SequenceGenerator(name = "SEQ_PROVEEDOR_CODIGO", sequenceName = "SEQ_PROVEEDOR_CODIGO",allocationSize=1)
    public Long getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Long proCodigo) {
        this.proCodigo = proCodigo;
    }

    @Column(name = "PRO_EJECUTIVO_CUENTA", nullable = false, length = 50)
    public String getProEjecutivoCuenta() {
        return proEjecutivoCuenta;
    }

    public void setProEjecutivoCuenta(String proEjecutivoCuenta) {
        this.proEjecutivoCuenta = proEjecutivoCuenta;
    }

	@OneToMany(mappedBy = "siiProveedor")
    public List<SiiProveedorInvitacion> getSiiProveedorInvitacionList() {
        return siiProveedorInvitacionList;
    }

    public void setSiiProveedorInvitacionList(List<SiiProveedorInvitacion> siiProveedorInvitacionList) {
        this.siiProveedorInvitacionList = siiProveedorInvitacionList;
    }

    @OneToMany(mappedBy = "siiProveedor")
    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList1() {
        return siiCotizacionEstudioList1;
    }

    public void setSiiCotizacionEstudioList1(List<SiiCotizacionEstudio> siiCotizacionEstudioList1) {
        this.siiCotizacionEstudioList1 = siiCotizacionEstudioList1;
    }

    public SiiCotizacionEstudio addSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList1().add(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiProveedor(this);
        return siiCotizacionEstudio;
    }

    public SiiCotizacionEstudio removeSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList1().remove(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiProveedor(null);
        return siiCotizacionEstudio;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiProveedor")
    public List<SiiPropuestaRecib> getSiiPropuestaRecibList() {
        return siiPropuestaRecibList;
    }

    public void setSiiPropuestaRecibList(List<SiiPropuestaRecib> siiPropuestaRecibList) {
        this.siiPropuestaRecibList = siiPropuestaRecibList;
    }

    public SiiPropuestaRecib addSiiPropuestaRecib(SiiPropuestaRecib siiPropuestaRecib) {
        getSiiPropuestaRecibList().add(siiPropuestaRecib);
        siiPropuestaRecib.setSiiProveedor(this);
        return siiPropuestaRecib;
    }

    public SiiPropuestaRecib removeSiiPropuestaRecib(SiiPropuestaRecib siiPropuestaRecib) {
        getSiiPropuestaRecibList().remove(siiPropuestaRecib);
        siiPropuestaRecib.setSiiProveedor(null);
        return siiPropuestaRecib;
    }

    @OneToMany(mappedBy = "siiProveedor")
    public List<SiiOficioAdjudica> getSiiOficioAdjudicaList1() {
        return siiOficioAdjudicaList1;
    }

    public void setSiiOficioAdjudicaList1(List<SiiOficioAdjudica> siiOficioAdjudicaList1) {
        this.siiOficioAdjudicaList1 = siiOficioAdjudicaList1;
    }

    public SiiOficioAdjudica addSiiOficioAdjudica(SiiOficioAdjudica siiOficioAdjudica) {
        getSiiOficioAdjudicaList1().add(siiOficioAdjudica);
        siiOficioAdjudica.setSiiProveedor(this);
        return siiOficioAdjudica;
    }

    public SiiOficioAdjudica removeSiiOficioAdjudica(SiiOficioAdjudica siiOficioAdjudica) {
        getSiiOficioAdjudicaList1().remove(siiOficioAdjudica);
        siiOficioAdjudica.setSiiProveedor(null);
        return siiOficioAdjudica;
    }

    @OneToMany(mappedBy = "siiProveedor")
    public List<SiiRp> getSiiRpList() {
        return siiRpList;
    }

    public void setSiiRpList(List<SiiRp> siiRpList) {
        this.siiRpList = siiRpList;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList().add(siiRp);
        siiRp.setSiiProveedor(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList().remove(siiRp);
        siiRp.setSiiProveedor(null);
        return siiRp;
    }

    @OneToMany(mappedBy = "siiProveedor")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiProveedor(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiProveedor(null);
        return siiOrdenPago;
    }

}
