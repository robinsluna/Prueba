package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOpeCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;

public class CuotaOpeCuotaAcuerdoVO {
    
    
    private Long cocCodigo;
    private CuotaOperadorVO cuotaOperadorAcuerdoVo;
    private CuotaOperadorVO cuotaOperadorVo;
    
    public CuotaOpeCuotaAcuerdoVO(SiiCuotaOpeCuotaAcuerdo siiCuotaOpeCuotaAcuerdo) {
       this.cocCodigo = siiCuotaOpeCuotaAcuerdo.getCocCodigo();
       if(siiCuotaOpeCuotaAcuerdo.getSiiCuotaOperadorAcuerdo()!= null){
           this.cuotaOperadorAcuerdoVo = new CuotaOperadorVO(siiCuotaOpeCuotaAcuerdo.getSiiCuotaOperadorAcuerdo());
        }
       if(siiCuotaOpeCuotaAcuerdo.getSiiCuotaOperador()!= null){
           this.cuotaOperadorVo = new CuotaOperadorVO(siiCuotaOpeCuotaAcuerdo.getSiiCuotaOperador());
        }
    }
    
    public CuotaOpeCuotaAcuerdoVO() {       
    }

    public void setCocCodigo(Long cocCodigo) {
        this.cocCodigo = cocCodigo;
    }

    public Long getCocCodigo() {
        return cocCodigo;
    }

    public void setCuotaOperadorAcuerdoVo(CuotaOperadorVO cuotaOperadorAcuerdoVo) {
        this.cuotaOperadorAcuerdoVo = cuotaOperadorAcuerdoVo;
    }

    public CuotaOperadorVO getCuotaOperadorAcuerdoVo() {
        return cuotaOperadorAcuerdoVo;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }
}
