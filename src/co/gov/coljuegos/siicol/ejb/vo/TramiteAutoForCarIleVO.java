package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumPasoTramiteAutoForCarIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoForCarIle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TramiteAutoForCarIleVO implements Comparable<TramiteAutoForCarIleVO>
{
    private Long tafCodigo;
    private Date tafFecha;
    private String tafPaso;
    private AutoFormCargProIleVO autoFormCargProIleVo;
    private UsuarioVO usuarioConecVo;

    
    /**
     * Constructor.
     */
    public TramiteAutoForCarIleVO (){ }
    
    
    /**
     * Constructor.
     * @param tramiteAutoForCarIle
     */
    public TramiteAutoForCarIleVO(SiiTramiteAutoForCarIle tramiteAutoForCarIle){
        this.tafCodigo = tramiteAutoForCarIle.getTafCodigo();
        this.tafFecha = tramiteAutoForCarIle.getTafFecha();
        this.tafPaso = tramiteAutoForCarIle.getTafPaso();
        //Padres
        if (tramiteAutoForCarIle.getSiiAutoFormCargProIle()!= null) {
            this.autoFormCargProIleVo = new AutoFormCargProIleVO(tramiteAutoForCarIle.getSiiAutoFormCargProIle());
        }
        if (tramiteAutoForCarIle.getSiiUsuarioConec()!= null) {
            this.usuarioConecVo = new UsuarioVO(tramiteAutoForCarIle.getSiiUsuarioConec());
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TramiteAutoForCarIleVO t) {
        int resultado = -1;
        
        if (t!=null && t.tafPaso!=null && this.tafPaso!=null) {
            if (this.tafPaso.equals(t.tafPaso)) {
                resultado = 0;
            }
            else {
                // Construir un Map con el orden de cada Paso
                Map<String, Integer> mapOrdenPasos = new HashMap<String, Integer>();
                mapOrdenPasos.put(EnumPasoTramiteAutoForCarIle.SOLICITUD_NUMERACION.getIdPaso(), 1);
                mapOrdenPasos.put(EnumPasoTramiteAutoForCarIle.NUMERACION.getIdPaso(), 2);
                mapOrdenPasos.put(EnumPasoTramiteAutoForCarIle.COMUNICACION.getIdPaso(), 3);
                mapOrdenPasos.put(EnumPasoTramiteAutoForCarIle.NOTIFICACION.getIdPaso(), 4);
                
                Integer orden1 = mapOrdenPasos.get(this.tafPaso);
                Integer orden2 = mapOrdenPasos.get(t.tafPaso);
                
                if (orden1!=null && orden2!=null)
                    resultado = orden1.compareTo(orden2);
            }
        }
        
        return (resultado);
    }
    
    
    
    public void setTafCodigo(Long tafCodigo) {
        this.tafCodigo = tafCodigo;
    }

    public Long getTafCodigo() {
        return tafCodigo;
    }

    public void setTafFecha(Date tafFecha) {
        this.tafFecha = tafFecha;
    }

    public Date getTafFecha() {
        return tafFecha;
    }

    public void setTafPaso(String tafPaso) {
        this.tafPaso = tafPaso;
    }

    public String getTafPaso() {
        return tafPaso;
    }

    public void setAutoFormCargProIleVo(AutoFormCargProIleVO autoFormCargProIleVo) {
        this.autoFormCargProIleVo = autoFormCargProIleVo;
    }

    public AutoFormCargProIleVO getAutoFormCargProIleVo() {
        return autoFormCargProIleVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
