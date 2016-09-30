package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcesalInc;

import java.util.Date;


/**
 * Value Object para la Direcci&oacute;n Procesal de un proceso de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
public class DireccionProcesalIncVO 
{
    private String dpiActivo;
    private Long dpiCodigo;
    private String dpiDireccion;
    private Date dpiFechaActiv;
    private Date dpiFechaInac;
    
    private IncumplimientoContrVO incumplimientoContrVo;
    private OperadorVO operadorVo;
    
    
    /**
     * Constructor.
     */
    public DireccionProcesalIncVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiDireccionProcesalInc - Entity.
     */
    public DireccionProcesalIncVO(SiiDireccionProcesalInc siiDireccionProcesalInc) 
    { 
        if (siiDireccionProcesalInc!=null) {
            this.dpiActivo = siiDireccionProcesalInc.getDpiActivo();
            this.dpiCodigo = siiDireccionProcesalInc.getDpiCodigo();
            this.dpiDireccion = siiDireccionProcesalInc.getDpiDireccion();
            this.dpiFechaActiv = siiDireccionProcesalInc.getDpiFechaActiv();
            this.dpiFechaInac = siiDireccionProcesalInc.getDpiFechaInac();
            
            if (siiDireccionProcesalInc.getSiiIncumplimientoContr()!=null) {
                this.incumplimientoContrVo = new IncumplimientoContrVO(siiDireccionProcesalInc.getSiiIncumplimientoContr());
            }
            
            if (siiDireccionProcesalInc.getSiiOperador()!=null) {
                this.operadorVo = new OperadorVO(siiDireccionProcesalInc.getSiiOperador());
            }
        }
    }


    public void setDpiActivo(String dpiActivo) {
        this.dpiActivo = dpiActivo;
    }

    public String getDpiActivo() {
        return dpiActivo;
    }

    public void setDpiCodigo(Long dpiCodigo) {
        this.dpiCodigo = dpiCodigo;
    }

    public Long getDpiCodigo() {
        return dpiCodigo;
    }

    public void setDpiDireccion(String dpiDireccion) {
        this.dpiDireccion = dpiDireccion;
    }

    public String getDpiDireccion() {
        return dpiDireccion;
    }

    public void setDpiFechaActiv(Date dpiFechaActiv) {
        this.dpiFechaActiv = dpiFechaActiv;
    }

    public Date getDpiFechaActiv() {
        return dpiFechaActiv;
    }

    public void setDpiFechaInac(Date dpiFechaInac) {
        this.dpiFechaInac = dpiFechaInac;
    }

    public Date getDpiFechaInac() {
        return dpiFechaInac;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }
}
