package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSectorDirec;

import java.util.List;

public class TipoSectorDirecVO implements Comparable{
    
    private Long tsdCodigo;
    private String tsdNombre;
    private List<DireccionVO> direccionPpalListVo;
    private List<DireccionVO> direccionNum2ListVo;
    
    public TipoSectorDirecVO() {

    }
    
    public TipoSectorDirecVO(SiiTipoSectorDirec siiTipoSectorDirec) {
        
        this.tsdCodigo = siiTipoSectorDirec.getTsdCodigo();
        this.tsdNombre = siiTipoSectorDirec.getTsdNombre();

    }

    public Long getTsdCodigo() {
        return tsdCodigo;
    }

    public void setTsdCodigo(Long tsdCodigo) {
        this.tsdCodigo = tsdCodigo;
    }

    public String getTsdNombre() {
        return tsdNombre;
    }

    public void setTsdNombre(String tsdNombre) {
        this.tsdNombre = tsdNombre;
    }

    public List<DireccionVO> getDireccionPpalListVo() {
        return direccionPpalListVo;
    }

    public void setDireccionPpalListVo(List<DireccionVO> direccionPpalListVo) {
        this.direccionPpalListVo = direccionPpalListVo;
    }

    public List<DireccionVO> getDireccionNum2ListVo() {
        return direccionNum2ListVo;
    }

    public void setDireccionNum2ListVo(List<DireccionVO> direccionNum2ListVo) {
        this.direccionNum2ListVo = direccionNum2ListVo;
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TipoSectorDirecVO) {
            TipoSectorDirecVO ac = (TipoSectorDirecVO) o;
            if (ac!=null && this.tsdNombre!=null && ac.tsdNombre!=null)
                resultado = this.tsdNombre.compareTo(ac.tsdNombre);
        }
        return resultado;
    }

}
