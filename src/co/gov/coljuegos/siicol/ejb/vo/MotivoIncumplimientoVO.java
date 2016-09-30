package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncumplimiento;

import java.util.List;


public class MotivoIncumplimientoVO implements Comparable {
    private Long minCodigo;
    private String minNombre;
    private String minTipo;
    private String minConcepto;
    
    private TipoMultaVO tipoMultaVo;
    
    private List<MotivoIncuInfSupervVO> motivoIncuInfSupervListVo;
    
    
    /**
     * Constructor.
     */
    public MotivoIncumplimientoVO () { }
    
    
    /**
     * Constructor.
     * @param siiMotivoIncumplimiento - Entity
     */
    public MotivoIncumplimientoVO(SiiMotivoIncumplimiento siiMotivoIncumplimiento) 
    {
        if (siiMotivoIncumplimiento!=null) {
            this.minCodigo = siiMotivoIncumplimiento.getMinCodigo();
            this.minNombre = siiMotivoIncumplimiento.getMinNombre();
            this.minTipo = siiMotivoIncumplimiento.getMinTipo();
            this.minConcepto = siiMotivoIncumplimiento.getMinConcepto();
            
            if (siiMotivoIncumplimiento.getSiiTipoMulta()!=null)
                this.tipoMultaVo = new TipoMultaVO(siiMotivoIncumplimiento.getSiiTipoMulta());
        }
    }
    
    
    
    public void setMinCodigo(Long minCodigo) {
        this.minCodigo = minCodigo;
    }

    public Long getMinCodigo() {
        return minCodigo;
    }

    public void setMinNombre(String minNombre) {
        this.minNombre = minNombre;
    }

    public String getMinNombre() {
        return minNombre;
    }

    public void setMinTipo(String minTipo) {
        this.minTipo = minTipo;
    }

    public String getMinTipo() {
        return minTipo;
    }

    public void setMotivoIncuInfSupervListVo(List<MotivoIncuInfSupervVO> motivoIncuInfSupervListVo) {
        this.motivoIncuInfSupervListVo = motivoIncuInfSupervListVo;
    }

    public List<MotivoIncuInfSupervVO> getMotivoIncuInfSupervListVo() {
        return motivoIncuInfSupervListVo;
    }

    public void setTipoMultaVo(TipoMultaVO tipoMultaVo) {
        this.tipoMultaVo = tipoMultaVo;
    }

    public TipoMultaVO getTipoMultaVo() {
        return tipoMultaVo;
    }

    public void setMinConcepto(String minConcepto) {
        this.minConcepto = minConcepto;
    }

    public String getMinConcepto() {
        return minConcepto;
    }

    @Override
    public int compareTo(Object o){
        int result = -1;
        if (o instanceof MotivoIncumplimientoVO) {
            if (minNombre!=null) {
                MotivoIncumplimientoVO pocVo = (MotivoIncumplimientoVO) o;
                result = minNombre.compareTo(pocVo.getMinNombre());
            }
        }
        return result;
    }
}
