package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;


import java.util.List;

public class AreaColjuegosVO implements Comparable, Cloneable {
    
    private Long acoCodigo;
    private Long acoCodigoPadre;
    private String acoNombre;
    private String acoAbreviatura;
    private String acoActivo;
    private String acoDescripcion;
    
    private List<SolicitudEstMercadoVO> solicitudEstMercadoVoList;
    private List<UsuarioVO> usuarioVoList;
    
    
    public AreaColjuegosVO(SiiAreaColjuegos siiAreaColjuegos){
        this.acoCodigo = siiAreaColjuegos.getAcoCodigo();
        this.acoCodigoPadre = siiAreaColjuegos.getAcoCodigoPadre();
        this.acoNombre = siiAreaColjuegos.getAcoNombre();
        this.acoAbreviatura = siiAreaColjuegos.getAcoAbreviatura();
        this.acoActivo = siiAreaColjuegos.getAcoActivo();
        this.acoDescripcion = siiAreaColjuegos.getAcoDescripcion();
    }
    
    public AreaColjuegosVO(){

    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public AreaColjuegosVO clone() 
    {
        AreaColjuegosVO areaColjuegosVo = new AreaColjuegosVO();
        areaColjuegosVo.acoCodigo = this.acoCodigo;
        areaColjuegosVo.acoCodigoPadre = this.acoCodigoPadre;
        areaColjuegosVo.acoNombre = this.acoNombre;
        areaColjuegosVo.acoAbreviatura = this.acoAbreviatura;
        areaColjuegosVo.acoActivo = this.acoActivo;
        areaColjuegosVo.acoDescripcion = this.acoDescripcion;
        
        return (areaColjuegosVo);
    }
    
    
    
    public void setAcoCodigo(Long acoCodigo) {
        this.acoCodigo = acoCodigo;
    }

    public Long getAcoCodigo() {
        return acoCodigo;
    }

    public void setAcoCodigoPadre(Long acoCodigoPadre) {
        this.acoCodigoPadre = acoCodigoPadre;
    }

    public Long getAcoCodigoPadre() {
        return acoCodigoPadre;
    }


    public void setAcoNombre(String acoNombre) {
        this.acoNombre = acoNombre;
    }

    public String getAcoNombre() {
        return acoNombre;
    }


    public void setSolicitudEstMercadoVoList(List<SolicitudEstMercadoVO> solicitudEstMercadoVoList) {
        this.solicitudEstMercadoVoList = solicitudEstMercadoVoList;
    }

    public List<SolicitudEstMercadoVO> getSolicitudEstMercadoVoList() {
        return solicitudEstMercadoVoList;
    }

    public void setUsuarioVoList(List<UsuarioVO> usuarioVoList) {
        this.usuarioVoList = usuarioVoList;
    }

    public List<UsuarioVO> getUsuarioVoList() {
        return usuarioVoList;
    }

    public void setAcoAbreviatura(String acoAbreviatura) {
        this.acoAbreviatura = acoAbreviatura;
    }

    public String getAcoAbreviatura() {
        return acoAbreviatura;
    }

    public void setAcoDescripcion(String acoDescripcion) {
        this.acoDescripcion = acoDescripcion;
    }

    public String getAcoDescripcion() {
        return acoDescripcion;
    }

    public void setAcoActivo(String acoActivo) {
        this.acoActivo = acoActivo;
    }

    public String getAcoActivo() {
        return acoActivo;
    }
    
    
    
    /**
     * Obtiene el Estado del &Aacute;rea Coljuegos.
     * @return nombre[acoActivo]
     */
    public String getEstado () 
    {
        String estado = null;
        if (acoActivo!=null) {
            estado = EnumEstado.getNombreById(acoActivo);
        }
        return (estado);
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof AreaColjuegosVO) {
            AreaColjuegosVO ac = (AreaColjuegosVO) o;
            if (ac!=null && this.acoNombre!=null && ac.acoNombre!=null)
                resultado = this.acoNombre.compareTo(ac.acoNombre);
        }
        return resultado;
    }

}
