package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOtrosi;

import java.util.List;

public class EstadoOtroSiVO {
    private Long eosCodigo;
    private String eosNombre;
    private List<OtroSiVO> otroSiListVo;

    EstadoOtroSiVO() {
    }

    public EstadoOtroSiVO(SiiEstadoOtrosi siiEstadoOtrosi) {
        this.eosCodigo = siiEstadoOtrosi.getEosCodigo();
        this.eosNombre = siiEstadoOtrosi.getEosNombre();
    }

    public void setEosCodigo(Long eosCodigo) {
        this.eosCodigo = eosCodigo;
    }

    public Long getEosCodigo() {
        return eosCodigo;
    }

    public void setEosNombre(String eosNombre) {
        this.eosNombre = eosNombre;
    }

    public String getEosNombre() {
        return eosNombre;
    }

    public void setOtroSiListVo(List<OtroSiVO> otroSiListVo) {
        this.otroSiListVo = otroSiListVo;
    }

    public List<OtroSiVO> getOtroSiListVo() {
        return otroSiListVo;
    }

}
