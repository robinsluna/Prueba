package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;

import java.util.List;

public class TipoIdentificacionVO  implements Cloneable, Comparable{
    private static final long serialVersionUID = -4670002270291754929L;
    private String tidActivo;
    private Long tidCodigo;
    private String tidNombre;
    private String tidNombreCorto;
    private List<SolicitudEstMercadoVO> solicitudEstMercadoListVo;
    private List<PersonaVO> personaListVo;

    public TipoIdentificacionVO(SiiTipoIdentificacion tipoIdentificacion){
        this.tidActivo = tipoIdentificacion.getTidActivo();
        this.tidCodigo = tipoIdentificacion.getTidCodigo();
        this.tidNombre = tipoIdentificacion.getTidNombre();
        this.tidNombreCorto = tipoIdentificacion.getTidNombreCorto();
    }
    public TipoIdentificacionVO(){
    }
    
    @Override
    public Object clone() {
        TipoIdentificacionVO t = new TipoIdentificacionVO();
        t.tidActivo = tidActivo;
        t.tidCodigo = tidCodigo;
        t.tidNombre = tidNombre;
        t.tidNombreCorto = t.tidNombreCorto;
        return t;
    }
    
    public void setTidActivo(String tidActivo) {
        this.tidActivo = tidActivo;
    }

    public String getTidActivo() {
        return tidActivo;
    }

    public void setTidCodigo(Long tidCodigo) {
        this.tidCodigo = tidCodigo;
    }

    public Long getTidCodigo() {
        return tidCodigo;
    }

    public void setTidNombre(String tidNombre) {
        this.tidNombre = tidNombre;
    }

    public String getTidNombre() {
        return tidNombre;
    }

    public void setTidNombreCorto(String tidNombreCorto) {
        this.tidNombreCorto = tidNombreCorto;
    }

    public String getTidNombreCorto() {
        return tidNombreCorto;
    }

    public void setSiiSolicitudEstMercadoList(List<SolicitudEstMercadoVO> solicitudEstMercadoListVo) {
        this.solicitudEstMercadoListVo = solicitudEstMercadoListVo;
    }

    public List<SolicitudEstMercadoVO> getSiiSolicitudEstMercadoList() {
        return solicitudEstMercadoListVo;
    }

    public void setSiiPersonaList(List<PersonaVO> siiPersonaList) {
        this.personaListVo = siiPersonaList;
    }

    public List<PersonaVO> getSiiPersonaList() {
        return personaListVo;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        if (o instanceof TipoIdentificacionVO) {
            TipoIdentificacionVO tiVO = (TipoIdentificacionVO) o;
            if (tiVO!=null) {
                igual = ( (tiVO.tidActivo!=null && tiVO.tidActivo.equals(this.tidActivo)) || (tiVO.tidActivo==null && this.tidActivo==null) ) && 
                        ( (tiVO.tidCodigo!=null && tiVO.tidCodigo.equals(this.tidCodigo)) || (tiVO.tidCodigo==null && this.tidCodigo==null) ) &&
                        ( (tiVO.tidNombre!=null && tiVO.tidNombre.equals(this.tidNombre)) || (tiVO.tidNombre==null && this.tidNombre==null) ) && 
                        ( (tiVO.tidNombreCorto!=null && tiVO.tidNombreCorto.equals(this.tidNombreCorto)) || (tiVO.tidNombreCorto==null && this.tidNombreCorto==null) );
            }
        }
        return (igual);
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TipoIdentificacionVO) {
            TipoIdentificacionVO ac = (TipoIdentificacionVO) o;
            if (ac!=null && this.tidNombre!=null && ac.tidNombre!=null)
                resultado = this.tidNombre.compareTo(ac.tidNombre);
        }
        return resultado;
    }


    @Override
    public String toString() {
        // TODO Implement this method
        return this.tidNombre;
    }
}
