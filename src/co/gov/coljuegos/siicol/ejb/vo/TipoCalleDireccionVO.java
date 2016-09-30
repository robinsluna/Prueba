package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCalleDireccion;
import java.util.List;



public class TipoCalleDireccionVO implements Comparable{
    
    private Long tcdCodigo;
    private String tcdNombre;
    private String tdcAbreviatura;
    private List<DireccionVO> direccionListVo;
    
    public TipoCalleDireccionVO(){
        
    }

    public TipoCalleDireccionVO(SiiTipoCalleDireccion siiTipoCalleDireccion) {
        
        this.tcdCodigo = siiTipoCalleDireccion.getTcdCodigo();
        this.tcdNombre = siiTipoCalleDireccion.getTcdNombre();
        this.tdcAbreviatura = siiTipoCalleDireccion.getTdcAbreviatura();

    }

    public Long getTcdCodigo() {
        return tcdCodigo;
    }

    public void setTcdCodigo(Long tcdCodigo) {
        this.tcdCodigo = tcdCodigo;
    }

    public String getTcdNombre() {
        return tcdNombre;
    }

    public void setTcdNombre(String tcdNombre) {
        this.tcdNombre = tcdNombre;
    }

    public String getTdcAbreviatura() {
        return tdcAbreviatura;
    }

    public void setTdcAbreviatura(String tdcAbreviatura) {
        this.tdcAbreviatura = tdcAbreviatura;
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
        if (o instanceof TipoCalleDireccionVO) {
            TipoCalleDireccionVO ac = (TipoCalleDireccionVO) o;
            if (ac!=null && this.tcdNombre!=null && ac.tcdNombre!=null)
                resultado = this.tcdNombre.compareTo(ac.tcdNombre);
        }
        return resultado;
    }

}
