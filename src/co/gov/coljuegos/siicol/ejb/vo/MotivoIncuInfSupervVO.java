package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncuInfSuperv;

public class MotivoIncuInfSupervVO {
    private String miiActivo;
    private Long miiCodigo;
    private MotivoIncumplimientoVO motivoIncumplimientoVo;
    private InformeSupervisionVO informeSupervisionVo;
    
    public MotivoIncuInfSupervVO() {
        
    }

    public MotivoIncuInfSupervVO(SiiMotivoIncuInfSuperv motivoIncuInfSuperv) {
        this.miiActivo = motivoIncuInfSuperv.getMiiActivo();
        this.miiCodigo = motivoIncuInfSuperv.getMiiCodigo();
        //Padres:
        if (motivoIncuInfSuperv.getSiiInformeSupervision() != null) {
            this.informeSupervisionVo = new InformeSupervisionVO(motivoIncuInfSuperv.getSiiInformeSupervision());
        }
        if (motivoIncuInfSuperv.getSiiMotivoIncumplimiento() != null) {
            this.motivoIncumplimientoVo = new MotivoIncumplimientoVO(motivoIncuInfSuperv.getSiiMotivoIncumplimiento());
        }
        
    }

    public void setMiiActivo(String miiActivo) {
        this.miiActivo = miiActivo;
    }

    public String getMiiActivo() {
        return miiActivo;
    }

    public void setMiiCodigo(Long miiCodigo) {
        this.miiCodigo = miiCodigo;
    }

    public Long getMiiCodigo() {
        return miiCodigo;
    }

    public void setMotivoIncumplimientoVo(MotivoIncumplimientoVO motivoIncumplimientoVo) {
        this.motivoIncumplimientoVo = motivoIncumplimientoVo;
    }

    public MotivoIncumplimientoVO getMotivoIncumplimientoVo() {
        return motivoIncumplimientoVo;
    }

    public void setInformeSupervisionVo(InformeSupervisionVO informeSupervisionVo) {
        this.informeSupervisionVo = informeSupervisionVo;
    }

    public InformeSupervisionVO getInformeSupervisionVo() {
        return informeSupervisionVo;
    }
}
