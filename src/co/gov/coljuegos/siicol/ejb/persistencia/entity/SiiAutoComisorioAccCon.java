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
@Table(name = "SII_AUTO_COMISORIO_ACC_CON")
public class SiiAutoComisorioAccCon implements Serializable{
    private static final long serialVersionUID = -7683057218313435785L;
    private Long acaCodigo;
    private String acaDireccion;
    private String acaEstado;
    private Date acaFecha;
    private Date acaFechaAccion;
    private Date acaFechaAnulacion;
    private Integer acaNumero;
    private SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon;
    private SiiDenuncia siiDenuncia;
    private SiiUbicacion siiUbicacionMunic;
    private SiiGrupoAccionControl siiGrupoAccionControl;
    private List<SiiAccionControl> siiAccionControlList;

    public SiiAutoComisorioAccCon(){
    }

    public SiiAutoComisorioAccCon(Long acaCodigo, String acaDireccion, String acaEstado, Date acaFecha, Date acaFechaAnulacion, Integer acaNumero, SiiDenuncia siiDenuncia,
                                  SiiGrupoAccionControl siiGrupoAccionControl, SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon, SiiUbicacion siiUbicacionMunic){
        this.acaCodigo = acaCodigo;
        this.acaDireccion = acaDireccion;
        this.acaEstado = acaEstado;
        this.acaFecha = acaFecha;
        this.acaFechaAnulacion = acaFechaAnulacion;
        this.acaNumero = acaNumero;
        this.siiDenuncia = siiDenuncia;
        this.siiGrupoAccionControl = siiGrupoAccionControl;
        this.siiMotivoAnulAuComAcCon = siiMotivoAnulAuComAcCon;
        this.siiUbicacionMunic = siiUbicacionMunic;
    }

    @Id
    @Column(name = "ACA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUTO_COMIS_ACC_CON_COD")
    @SequenceGenerator(name = "SEQ_AUTO_COMIS_ACC_CON_COD", sequenceName = "SEQ_AUTO_COMIS_ACC_CON_COD",allocationSize=1)
    public Long getAcaCodigo(){
        return acaCodigo;
    }

    public void setAcaCodigo(Long acaCodigo){
        this.acaCodigo = acaCodigo;
    }

    @Column(name = "ACA_DIRECCION", nullable = false, length = 100)
    public String getAcaDireccion(){
        return acaDireccion;
    }

    public void setAcaDireccion(String acaDireccion){
        this.acaDireccion = acaDireccion;
    }

    @Column(name = "ACA_ESTADO", nullable = false, length = 1)
    public String getAcaEstado(){
        return acaEstado;
    }

    public void setAcaEstado(String acaEstado){
        this.acaEstado = acaEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACA_FECHA", nullable = false)
    public Date getAcaFecha(){
        return acaFecha;
    }

    public void setAcaFecha(Date acaFecha){
        this.acaFecha = acaFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACA_FECHA_ANULACION")
    public Date getAcaFechaAnulacion(){
        return acaFechaAnulacion;
    }

    public void setAcaFechaAnulacion(Date acaFechaAnulacion){
        this.acaFechaAnulacion = acaFechaAnulacion;
    }

    @Column(name = "ACA_NUMERO", nullable = false)
    public Integer getAcaNumero(){
        return acaNumero;
    }

    public void setAcaNumero(Integer acaNumero){
        this.acaNumero = acaNumero;
    }


    @ManyToOne
    @JoinColumn(name = "MAA_CODIGO")
    public SiiMotivoAnulAuComAcCon getSiiMotivoAnulAuComAcCon(){
        return siiMotivoAnulAuComAcCon;
    }

    public void setSiiMotivoAnulAuComAcCon(SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon){
        this.siiMotivoAnulAuComAcCon = siiMotivoAnulAuComAcCon;
    }

    @ManyToOne
    @JoinColumn(name = "DEN_CODIGO")
    public SiiDenuncia getSiiDenuncia(){
        return siiDenuncia;
    }

    public void setSiiDenuncia(SiiDenuncia siiDenuncia){
        this.siiDenuncia = siiDenuncia;
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
    @JoinColumn(name = "GAC_CODIGO")
    public SiiGrupoAccionControl getSiiGrupoAccionControl(){
        return siiGrupoAccionControl;
    }

    public void setSiiGrupoAccionControl(SiiGrupoAccionControl siiGrupoAccionControl){
        this.siiGrupoAccionControl = siiGrupoAccionControl;
    }

    @OneToMany(mappedBy = "siiAutoComisorioAccCon")
    public List<SiiAccionControl> getSiiAccionControlList(){
        return siiAccionControlList;
    }

    public void setSiiAccionControlList(List<SiiAccionControl> siiAccionControlList){
        this.siiAccionControlList = siiAccionControlList;
    }

    public SiiAccionControl addSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().add(siiAccionControl);
        siiAccionControl.setSiiAutoComisorioAccCon(this);
        return siiAccionControl;
    }

    public SiiAccionControl removeSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlList().remove(siiAccionControl);
        siiAccionControl.setSiiAutoComisorioAccCon(null);
        return siiAccionControl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACA_FECHA_ACCION")
    public Date getAcaFechaAccion() {
        return acaFechaAccion;
    }

    public void setAcaFechaAccion(Date acaFechaAccion) {
        this.acaFechaAccion = acaFechaAccion;
    }}
