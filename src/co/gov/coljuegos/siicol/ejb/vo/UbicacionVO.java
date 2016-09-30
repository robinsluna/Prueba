package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;

import java.util.List;


public class UbicacionVO implements Comparable{
    private String ubiCodigo;
    private String ubiCodigoPadre;
    private String ubiDescripcion;
    private String ubiNombre;
    private TipoUbicacionVO tipoUbicacionVo;
    private UbicacionVO ubicacionPadreVo;    
    
    private List<ConsolidadoDistVO> consolidadoDistList;

    
    /**
     * Constructor.
     * @param siiUbicacion
     */
    public UbicacionVO(SiiUbicacion siiUbicacion) {
        this.ubiCodigo = siiUbicacion.getUbiCodigo();
        this.ubiCodigoPadre = siiUbicacion.getUbiCodigoPadre();
        this.ubiDescripcion = siiUbicacion.getUbiNombre();
        this.ubiNombre = siiUbicacion.getUbiNombre();
        if (siiUbicacion.getSiiTipoUbicacion()!= null) {
            this.tipoUbicacionVo = new TipoUbicacionVO(siiUbicacion.getSiiTipoUbicacion());
        }
        if (siiUbicacion.getSiiUbicacionPadre() != null) {
            this.ubicacionPadreVo = new UbicacionVO(siiUbicacion.getSiiUbicacionPadre());
        }
        
    }

    
    public UbicacionVO(){
        
    }
    public void setUbiCodigo(String ubiCodigo) {
        this.ubiCodigo = ubiCodigo;
    }

    public String getUbiCodigo() {
        return ubiCodigo;
    }

    public void setUbiCodigoPadre(String ubiCodigoPadre) {
        this.ubiCodigoPadre = ubiCodigoPadre;
    }

    public String getUbiCodigoPadre() {
        return ubiCodigoPadre;
    }

    public void setUbiDescripcion(String ubiDescripcion) {
        this.ubiDescripcion = ubiDescripcion;
    }

    public String getUbiDescripcion() {
        return ubiDescripcion;
    }

    public void setUbiNombre(String ubiNombre) {
        this.ubiNombre = ubiNombre;
    }

    public String getUbiNombre() {
        return ubiNombre;
    }

    public void setTipoUbicacionVo(TipoUbicacionVO tipoUbicacionVo) {
        this.tipoUbicacionVo = tipoUbicacionVo;
    }

    public TipoUbicacionVO getTipoUbicacionVo() {
        return tipoUbicacionVo;
    }

    public void setConsolidadoDistList(List<ConsolidadoDistVO> consolidadoDistList) {
        this.consolidadoDistList = consolidadoDistList;
    }

    public List<ConsolidadoDistVO> getConsolidadoDistList() {
        return consolidadoDistList;
    }


    public void setUbicacionPadreVo(UbicacionVO ubicacionPadreVo) {
        this.ubicacionPadreVo = ubicacionPadreVo;
    }

    public UbicacionVO getUbicacionPadreVo() {
        return ubicacionPadreVo;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        if (o instanceof UbicacionVO) {
            UbicacionVO uVO = (UbicacionVO) o;
            if (uVO!=null) {
                igual = ( (uVO.ubiCodigo!=null && uVO.ubiCodigo.equals(this.ubiCodigo)) || (uVO.ubiCodigo==null && this.ubiCodigo==null) ) && 
                        ( (uVO.ubiCodigoPadre!=null && uVO.ubiCodigoPadre.equals(this.ubiCodigoPadre)) || (uVO.ubiCodigoPadre==null && this.ubiCodigoPadre==null) ) &&
                        ( (uVO.ubiDescripcion!=null && uVO.ubiDescripcion.equals(this.ubiDescripcion)) || (uVO.ubiDescripcion==null && this.ubiDescripcion==null) ) && 
                        ( (uVO.ubiNombre!=null && uVO.ubiNombre.equals(this.ubiNombre)) || (uVO.ubiNombre==null && this.ubiNombre==null) ) && 
                        ( (uVO.tipoUbicacionVo!=null && uVO.tipoUbicacionVo.equals(this.tipoUbicacionVo)) || (uVO.tipoUbicacionVo==null && this.tipoUbicacionVo==null) );
            }
        }
        return (igual);
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof UbicacionVO) {
            UbicacionVO ac = (UbicacionVO) o;
            if (ac!=null && this.ubiNombre!=null && ac.ubiNombre!=null)
                resultado = this.ubiNombre.compareTo(ac.ubiNombre);
        }
        return resultado;
    }

}
