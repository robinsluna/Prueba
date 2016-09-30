package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo1Calle;

import java.util.List;

public class TipoSufijo1CalleVO implements Comparable{
    
    private Long tscCodigo;
    private String tscNombre;
    private List<DireccionVO> direccionPpal1ListVo;
    private List<DireccionVO> direccionPpal2ListVo;
    private List<DireccionVO> direccionNum1ListVo;

    
    public TipoSufijo1CalleVO() {
        
    }
    
    public TipoSufijo1CalleVO(SiiTipoSufijo1Calle siiTipoSufijo1Calle) {
        
        this.tscCodigo = siiTipoSufijo1Calle.getTscCodigo();
        this.tscNombre = siiTipoSufijo1Calle.getTscNombre();
        
    }

    public Long getTscCodigo() {
        return tscCodigo;
    }

    public void setTscCodigo(Long tscCodigo) {
        this.tscCodigo = tscCodigo;
    }

    public String getTscNombre() {
        return tscNombre;
    }

    public void setTscNombre(String tscNombre) {
        this.tscNombre = tscNombre;
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TipoSufijo1CalleVO) {
            TipoSufijo1CalleVO ac = (TipoSufijo1CalleVO) o;
            if (ac!=null && this.tscNombre!=null && ac.tscNombre!=null)
                resultado = this.tscNombre.compareTo(ac.tscNombre);
        }
        return resultado;
    }

}
