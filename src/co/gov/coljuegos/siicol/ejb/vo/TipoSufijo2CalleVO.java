package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo2Calle;

import java.util.List;

public class TipoSufijo2CalleVO implements Comparable{
    
    private Long tsuCodigo;
    private String tsuNombre;
    private List<DireccionVO> direccionListVo;

    
    public TipoSufijo2CalleVO() {
        
    }
    
    public TipoSufijo2CalleVO(SiiTipoSufijo2Calle siiTipoSufijo2Calle) {
        
        this.tsuCodigo = siiTipoSufijo2Calle.getTsuCodigo();
        this.tsuNombre = siiTipoSufijo2Calle.getTsuNombre();
        
    }

    public Long getTsuCodigo() {
        return tsuCodigo;
    }

    public void setTsuCodigo(Long tsuCodigo) {
        this.tsuCodigo = tsuCodigo;
    }

    public String getTsuNombre() {
        return tsuNombre;
    }

    public void setTsuNombre(String tsuNombre) {
        this.tsuNombre = tsuNombre;
    }

    public List<DireccionVO> getDireccionListVo() {
        return direccionListVo;
    }

    public void setDireccionListVo(List<DireccionVO> direccionListVo) {
        this.direccionListVo = direccionListVo;
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TipoSufijo2CalleVO) {
            TipoSufijo2CalleVO ac = (TipoSufijo2CalleVO) o;
            if (ac!=null && this.tsuNombre!=null && ac.tsuNombre!=null)
                resultado = this.tsuNombre.compareTo(ac.tsuNombre);
        }
        return resultado;
    }

}
