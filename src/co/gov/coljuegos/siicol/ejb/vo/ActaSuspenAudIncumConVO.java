package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumMotivoSuspensionAudiencia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaSuspenAudIncumCon;

import java.util.Date;


/**
 * Value Object para las Actas de Suspensi&oacute;n de Audiencia de procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
public class ActaSuspenAudIncumConVO 
{
    private Long asaCodigo;
    private Date asaFecha;
    private Date asaFechaReanud;
    private String asaMotivo;
    private String asaObservaciones;
    
    private IncumplimientoContrVO incumplimientoContrVo;
    
    
    
    /**
     * Constructor.
     */
    public ActaSuspenAudIncumConVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiActaSuspenAudIncumCon - Entity.
     */
    public ActaSuspenAudIncumConVO (SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon) 
    {
        if (siiActaSuspenAudIncumCon!=null) {
            this.asaCodigo = siiActaSuspenAudIncumCon.getAsaCodigo();
            this.asaFecha = siiActaSuspenAudIncumCon.getAsaFecha();
            this.asaFechaReanud = siiActaSuspenAudIncumCon.getAsaFechaReanud();
            this.asaMotivo = siiActaSuspenAudIncumCon.getAsaMotivo();
            this.asaObservaciones = siiActaSuspenAudIncumCon.getAsaObservaciones();
            
            if (siiActaSuspenAudIncumCon.getSiiIncumplimientoContr()!=null)
                this.incumplimientoContrVo = new IncumplimientoContrVO(siiActaSuspenAudIncumCon.getSiiIncumplimientoContr());
        }
    }
    
    
    
    
    public void setAsaCodigo(Long asaCodigo) {
        this.asaCodigo = asaCodigo;
    }

    public Long getAsaCodigo() {
        return asaCodigo;
    }

    public void setAsaFecha(Date asaFecha) {
        this.asaFecha = asaFecha;
    }

    public Date getAsaFecha() {
        return asaFecha;
    }

    public void setAsaFechaReanud(Date asaFechaReanud) {
        this.asaFechaReanud = asaFechaReanud;
    }

    public Date getAsaFechaReanud() {
        return asaFechaReanud;
    }

    public void setAsaMotivo(String asaMotivo) {
        this.asaMotivo = asaMotivo;
    }

    public String getAsaMotivo() {
        return asaMotivo;
    }

    public void setAsaObservaciones(String asaObservaciones) {
        this.asaObservaciones = asaObservaciones;
    }

    public String getAsaObservaciones() {
        return asaObservaciones;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }
    
    
    /**
     * Obtiene el nombre del Motivo de Suspensi&oacute;n de la Audiencia.
     * @return asaMotivo=>nombre.
     */
    public String getMotivo () 
    {
        String motivo = null;
        if (asaMotivo!=null) {
            motivo = EnumMotivoSuspensionAudiencia.getNombreById(asaMotivo);
        }
        return (motivo);
    }
}
