package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_NOVEDAD")
public class SiiNovedad implements Serializable {
    private static final long serialVersionUID = -1797315956560739874L;
    private Long novCodigo;
    private Date novFecha;
    private SiiContrato siiContrato;
    private SiiTipoNovedad siiTipoNovedad;
    private List<SiiInventario> siiInventarioList2;
    private SiiSolicitudAutoriza siiSolicitudAutoriza;
    private SiiOtrosi siiOtrosi;
    private List<SiiEstablecimiento> siiEstablecimientoList;
    private SiiLicenciaAcdv siiLicenciaAcdv;
    private SiiSuspensionContr siiSuspensionContr;
    private SiiTerminacionAnticip siiTerminacionAnticip;

    public SiiNovedad() {
    }

    public SiiNovedad(SiiContrato siiContrato, Long novCodigo, Date novFecha, SiiTipoNovedad siiTipoNovedad,
					SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiContrato = siiContrato;
        this.novCodigo = novCodigo;
        this.novFecha = novFecha;
        this.siiTipoNovedad = siiTipoNovedad;
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }


    @Id
    @Column(name = "NOV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_NOVEDAD_COD")
    @SequenceGenerator(name = "SEQ_NOVEDAD_COD", sequenceName = "SEQ_NOVEDAD_COD",allocationSize=1)
    public Long getNovCodigo() {
        return novCodigo;
    }

    public void setNovCodigo(Long novCodigo) {
        this.novCodigo = novCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NOV_FECHA", nullable = false)
    public Date getNovFecha() {
        return novFecha;
    }

    public void setNovFecha(Date novFecha) {
        this.novFecha = novFecha;
    }


    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @ManyToOne
    @JoinColumn(name = "TNO_CODIGO")
    public SiiTipoNovedad getSiiTipoNovedad() {
        return siiTipoNovedad;
    }

    public void setSiiTipoNovedad(SiiTipoNovedad siiTipoNovedad) {
        this.siiTipoNovedad = siiTipoNovedad;
    }

    @OneToMany(mappedBy = "siiNovedad")
    public List<SiiInventario> getSiiInventarioList2() {
        return siiInventarioList2;
    }

    public void setSiiInventarioList2(List<SiiInventario> siiInventarioList2) {
        this.siiInventarioList2 = siiInventarioList2;
    }

    public SiiInventario addSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList2().add(siiInventario);
        siiInventario.setSiiNovedad(this);
        return siiInventario;
    }

    public SiiInventario removeSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList2().remove(siiInventario);
        siiInventario.setSiiNovedad(null);
        return siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "SAU_CODIGO")
    public SiiSolicitudAutoriza getSiiSolicitudAutoriza() {
        return siiSolicitudAutoriza;
    }

    public void setSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }

    @ManyToOne
    @JoinColumn(name = "OSI_CODIGO")
    public SiiOtrosi getSiiOtrosi() {
        return siiOtrosi;
    }

    public void setSiiOtrosi(SiiOtrosi siiOtrosi) {
        this.siiOtrosi = siiOtrosi;
    }

    @OneToMany(mappedBy = "siiNovedad")
    public List<SiiEstablecimiento> getSiiEstablecimientoList() {
        return siiEstablecimientoList;
    }

    public void setSiiEstablecimientoList(List<SiiEstablecimiento> siiEstablecimientoList) {
        this.siiEstablecimientoList = siiEstablecimientoList;
    }

    public SiiEstablecimiento addSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList().add(siiEstablecimiento);
        siiEstablecimiento.setSiiNovedad(this);
        return siiEstablecimiento;
    }

    public SiiEstablecimiento removeSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList().remove(siiEstablecimiento);
        siiEstablecimiento.setSiiNovedad(null);
        return siiEstablecimiento;
    }

    @ManyToOne
    @JoinColumn(name = "LAC_CODIGO")
    public SiiLicenciaAcdv getSiiLicenciaAcdv() {
        return siiLicenciaAcdv;
    }

    public void setSiiLicenciaAcdv(SiiLicenciaAcdv siiLicenciaAcdv) {
        this.siiLicenciaAcdv = siiLicenciaAcdv;
    }
    
    @ManyToOne
    @JoinColumn(name = "SCO_CODIGO")
    public SiiSuspensionContr getSiiSuspensionContr() {
        return siiSuspensionContr;
    }

    public void setSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        this.siiSuspensionContr = siiSuspensionContr;
    }

    @ManyToOne
    @JoinColumn(name = "TAN_CODIGO")
    public SiiTerminacionAnticip getSiiTerminacionAnticip() {
        return siiTerminacionAnticip;
    }

    public void setSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        this.siiTerminacionAnticip = siiTerminacionAnticip;
    }
}
