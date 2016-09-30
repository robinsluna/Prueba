package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;

import java.util.Date;
import java.util.List;

public class AutoComisorioAccConVO {
    private Long acaCodigo;
    private String acaDireccion;
    private String acaEstado;
    private Date acaFecha;
    private Date acaFechaAnulacion;
    private Date acaFechaAccionControl;
    private Integer acaNumero;
    private MotivoAnulAuComAcConVO siiMotivoAnulAuComAcCon;
    private DenunciaVO denunciaVo;
    private UbicacionVO ubicacionMunicVo;
    private GrupoAccionControlVO grupoAccionControlVo;
    private List<AccionControlVO> accionControlListVo;
    private AccionControlVO accionControlVo;

    public AutoComisorioAccConVO() {
        
    }
    public AutoComisorioAccConVO(SiiAutoComisorioAccCon siiAutoComisorioAccCon) {
        this.acaCodigo = siiAutoComisorioAccCon.getAcaCodigo();
        this.acaDireccion = siiAutoComisorioAccCon.getAcaDireccion();
        this.acaEstado = siiAutoComisorioAccCon.getAcaEstado();
        this.acaFecha = siiAutoComisorioAccCon.getAcaFecha();
        this.acaFechaAnulacion = siiAutoComisorioAccCon.getAcaFechaAnulacion();
        this.acaNumero = siiAutoComisorioAccCon.getAcaNumero();
        this.acaFechaAccionControl = siiAutoComisorioAccCon.getAcaFechaAccion();
        //Padres:
        if (siiAutoComisorioAccCon.getSiiDenuncia()!= null){
            this.denunciaVo = new DenunciaVO(siiAutoComisorioAccCon.getSiiDenuncia());
        }
        if (siiAutoComisorioAccCon.getSiiGrupoAccionControl()!=null) {
            this.grupoAccionControlVo = new GrupoAccionControlVO(siiAutoComisorioAccCon.getSiiGrupoAccionControl());
        }
        if (siiAutoComisorioAccCon.getSiiUbicacionMunic()!= null) {
            this.ubicacionMunicVo = new UbicacionVO(siiAutoComisorioAccCon.getSiiUbicacionMunic());
        }
            
            
    }

    public void setAcaCodigo(Long acaCodigo) {
        this.acaCodigo = acaCodigo;
    }

    public Long getAcaCodigo() {
        return acaCodigo;
    }

    public void setAcaDireccion(String acaDireccion) {
        this.acaDireccion = acaDireccion;
    }

    public String getAcaDireccion() {
        return acaDireccion;
    }

    public void setAcaEstado(String acaEstado) {
        this.acaEstado = acaEstado;
    }

    public String getAcaEstado() {
        return acaEstado;
    }

    public void setAcaFecha(Date acaFecha) {
        this.acaFecha = acaFecha;
    }

    public Date getAcaFecha() {
        return acaFecha;
    }

    public void setAcaFechaAnulacion(Date acaFechaAnulacion) {
        this.acaFechaAnulacion = acaFechaAnulacion;
    }

    public Date getAcaFechaAnulacion() {
        return acaFechaAnulacion;
    }

    public void setAcaNumero(Integer acaNumero) {
        this.acaNumero = acaNumero;
    }

    public Integer getAcaNumero() {
        return acaNumero;
    }

    public void setSiiMotivoAnulAuComAcCon(MotivoAnulAuComAcConVO siiMotivoAnulAuComAcCon) {
        this.siiMotivoAnulAuComAcCon = siiMotivoAnulAuComAcCon;
    }

    public MotivoAnulAuComAcConVO getSiiMotivoAnulAuComAcCon() {
        return siiMotivoAnulAuComAcCon;
    }

    public void setDenunciaVo(DenunciaVO denunciaVo) {
        this.denunciaVo = denunciaVo;
    }

    public DenunciaVO getDenunciaVo() {
        return denunciaVo;
    }

    public void setUbicacionMunicVo(UbicacionVO ubicacionMunicVo) {
        this.ubicacionMunicVo = ubicacionMunicVo;
    }

    public UbicacionVO getUbicacionMunicVo() {
        return ubicacionMunicVo;
    }

    public void setGrupoAccionControlVo(GrupoAccionControlVO grupoAccionControlVo) {
        this.grupoAccionControlVo = grupoAccionControlVo;
    }

    public GrupoAccionControlVO getGrupoAccionControlVo() {
        return grupoAccionControlVo;
    }

    public void setAccionControlListVo(List<AccionControlVO> accionControlListVo) {
        this.accionControlListVo = accionControlListVo;
    }

    public List<AccionControlVO> getAccionControlListVo() {
        return accionControlListVo;
    }

    public void setAcaFechaAccionControl(Date acaFechaAccionControl){
        this.acaFechaAccionControl = acaFechaAccionControl;
    }

    public Date getAcaFechaAccionControl(){
        return acaFechaAccionControl;
    }

    public AccionControlVO getAccionControlVo() {
        if (accionControlListVo != null && accionControlListVo.size()!= 0) {
            return this.accionControlListVo.get(0);            
        } else {
            return new AccionControlVO();
        }
    }

    public void setAccionControlVo(AccionControlVO accionControlVo) {
        this.accionControlVo = accionControlVo;
    }
}
