package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoUbicacion;

import java.util.List;

public class TipoUbicacionVO {
    private Long tiuCodigo;
    private String tiuNombre;
    private List<UbicacionVO> ubicacionListVo;
    
    public TipoUbicacionVO() {
    }
    
    public TipoUbicacionVO(SiiTipoUbicacion siiTipoUbicacion) {
        this.tiuCodigo = siiTipoUbicacion.getTiuCodigo();
        this.tiuNombre = siiTipoUbicacion.getTiuNombre();
    }

    public void setTiuCodigo(Long tiuCodigo) {
        this.tiuCodigo = tiuCodigo;
    }

    public Long getTiuCodigo() {
        return tiuCodigo;
    }

    public void setTiuNombre(String tiuNombre) {
        this.tiuNombre = tiuNombre;
    }

    public String getTiuNombre() {
        return tiuNombre;
    }

    public void setUbicacionListVo(List<UbicacionVO> ubicacionListVo) {
        this.ubicacionListVo = ubicacionListVo;
    }

    public List<UbicacionVO> getUbicacionListVo() {
        return ubicacionListVo;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        if (o instanceof TipoUbicacionVO) {
            TipoUbicacionVO tuVO = (TipoUbicacionVO) o;
            if (tuVO!=null) {
                igual = ( (tuVO.tiuCodigo!=null && tuVO.tiuCodigo.equals(this.tiuCodigo)) || (tuVO.tiuCodigo==null && this.tiuCodigo==null) ) && 
                        ( (tuVO.tiuNombre!=null && tuVO.tiuNombre.equals(this.tiuNombre)) || (tuVO.tiuNombre==null && this.tiuNombre==null) );
            }
        }
        return (igual);
    }
}
