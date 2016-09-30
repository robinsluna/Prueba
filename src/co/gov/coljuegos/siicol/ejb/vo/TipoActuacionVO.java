package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoActuacion;

import java.util.List;

public class TipoActuacionVO {

    private Long tacCodigo;
    private String tacNombre;
    private List<FiscalizadorSustancVO> fiscalizadorSustancListVo;
    private List<InformeSupervisionVO> informeSupervisionListVo;


    public TipoActuacionVO() {

    }

    public TipoActuacionVO(SiiTipoActuacion siiTipoActuacion) {
        this.tacCodigo = siiTipoActuacion.getTacCodigo();
        this.tacNombre = siiTipoActuacion.getTacNombre();

    }

    public void setTacCodigo(Long tacCodigo) {
        this.tacCodigo = tacCodigo;
    }

    public Long getTacCodigo() {
        return tacCodigo;
    }

    public void setTacNombre(String tacNombre) {
        this.tacNombre = tacNombre;
    }

    public String getTacNombre() {
        return tacNombre;
    }

    public void setFiscalizadorSustancListVo(List<FiscalizadorSustancVO> fiscalizadorSustancListVo) {
        this.fiscalizadorSustancListVo = fiscalizadorSustancListVo;
    }

    public List<FiscalizadorSustancVO> getFiscalizadorSustancListVo() {
        return fiscalizadorSustancListVo;
    }

    public void setInformeSupervisionListVo(List<InformeSupervisionVO> informeSupervisionListVo) {
        this.informeSupervisionListVo = informeSupervisionListVo;
    }

    public List<InformeSupervisionVO> getInformeSupervisionListVo() {
        return informeSupervisionListVo;
    }

    public String getInicialTipoActuacion() {
        if(this.getTacNombre().equals("Proceso Fiscalización")) {
            return "S";
        }
        else if(this.getTacNombre().equals("Proceso Incumplimiento")) {
            return "I";
        }
        else
            return "";
    }
}
