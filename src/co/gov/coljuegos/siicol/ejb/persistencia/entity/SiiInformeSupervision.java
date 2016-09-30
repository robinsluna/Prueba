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
@Table(name = "SII_INFORME_SUPERVISION")
public class SiiInformeSupervision implements Serializable {
    private static final long serialVersionUID = 700337312103419978L;
    private Long isuCodigo;
    private String isuEstado;
    private Date isuFechaRadicacion;
    private String isuRadicado;
    private SiiContrato siiContrato;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrList;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiUsuario siiUsuario;
    private List<SiiMotivoIncuInfSuperv> siiMotivoIncuInfSupervList;
    private SiiTipoActuacion siiTipoActuacion;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioList;


    public SiiInformeSupervision() {
    }

    public SiiInformeSupervision(SiiArchivoFisico siiArchivoFisico, SiiContrato siiContrato, Long isuCodigo,
                                 String isuEstado, Date isuFechaRadicacion, String isuRadicado,
                                 SiiUsuario siiUsuario) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.siiContrato = siiContrato;
        this.isuCodigo = isuCodigo;
        this.isuEstado = isuEstado;
        this.isuFechaRadicacion = isuFechaRadicacion;
        this.isuRadicado = isuRadicado;
        this.siiUsuario = siiUsuario;
    }


    @Id
    @Column(name = "ISU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INFORME_SUPERVISION_COD")
    @SequenceGenerator(name = "SEQ_INFORME_SUPERVISION_COD", sequenceName = "SEQ_INFORME_SUPERVISION_COD",allocationSize=1)
    public Long getIsuCodigo() {
        return isuCodigo;
    }

    public void setIsuCodigo(Long isuCodigo) {
        this.isuCodigo = isuCodigo;
    }

    @Column(name = "ISU_ESTADO", nullable = false, length = 1)
    public String getIsuEstado() {
        return isuEstado;
    }

    public void setIsuEstado(String isuEstado) {
        this.isuEstado = isuEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ISU_FECHA_RADICACION", nullable = false)
    public Date getIsuFechaRadicacion() {
        return isuFechaRadicacion;
    }

    public void setIsuFechaRadicacion(Date isuFechaRadicacion) {
        this.isuFechaRadicacion = isuFechaRadicacion;
    }

    @Column(name = "ISU_RADICADO", nullable = false, length = 30)
    public String getIsuRadicado() {
        return isuRadicado;
    }

    public void setIsuRadicado(String isuRadicado) {
        this.isuRadicado = isuRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @OneToMany(mappedBy = "siiInformeSupervision")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrList() {
        return siiIncumplimientoContrList;
    }

    public void setSiiIncumplimientoContrList(List<SiiIncumplimientoContr> siiIncumplimientoContrList) {
        this.siiIncumplimientoContrList = siiIncumplimientoContrList;
    }

    public SiiIncumplimientoContr addSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrList().add(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiInformeSupervision(this);
        return siiIncumplimientoContr;
    }

    public SiiIncumplimientoContr removeSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrList().remove(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiInformeSupervision(null);
        return siiIncumplimientoContr;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }
    
    @OneToMany(mappedBy = "siiInformeSupervision")
    public List<SiiMotivoIncuInfSuperv> getSiiMotivoIncuInfSupervList() {
        return siiMotivoIncuInfSupervList;
    }

    public void setSiiMotivoIncuInfSupervList(List<SiiMotivoIncuInfSuperv> siiMotivoIncuInfSupervList) {
        this.siiMotivoIncuInfSupervList = siiMotivoIncuInfSupervList;
    }

    public SiiMotivoIncuInfSuperv addSiiMotivoIncuInfSuperv(SiiMotivoIncuInfSuperv siiMotivoIncuInfSuperv) {
        getSiiMotivoIncuInfSupervList().add(siiMotivoIncuInfSuperv);
        siiMotivoIncuInfSuperv.setSiiInformeSupervision(this);
        return siiMotivoIncuInfSuperv;
    }

    public SiiMotivoIncuInfSuperv removeSiiMotivoIncuInfSuperv(SiiMotivoIncuInfSuperv siiMotivoIncuInfSuperv) {
        getSiiMotivoIncuInfSupervList().remove(siiMotivoIncuInfSuperv);
        siiMotivoIncuInfSuperv.setSiiInformeSupervision(null);
        return siiMotivoIncuInfSuperv;
    }
    
    @ManyToOne
    @JoinColumn(name = "TAC_CODIGO")
    public SiiTipoActuacion getSiiTipoActuacion() {
        return siiTipoActuacion;
    }

    public void setSiiTipoActuacion(SiiTipoActuacion siiTipoActuacion) {
        this.siiTipoActuacion = siiTipoActuacion;
    }

    @OneToMany(mappedBy = "siiInformeSupervision")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioList(){
        return siiProcesoSancionatorioList;
    }

    public void setSiiProcesoSancionatorioList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioList){
        this.siiProcesoSancionatorioList = siiProcesoSancionatorioList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio){
        getSiiProcesoSancionatorioList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiInformeSupervision(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio){
        getSiiProcesoSancionatorioList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiInformeSupervision(null);
        return siiProcesoSancionatorio;
    }

}
