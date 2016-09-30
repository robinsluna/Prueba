package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumPasoTramiteAutoPrueTras;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoAutoProcSancIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoPrueTras;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TramiteAutoPrueTrasVO implements Comparable<TramiteAutoPrueTrasVO>
{
    private Long traCodigo;
    private Date traFecha;
    private String traPaso;
    
    private AutoDecretaPrueProIleVO autoDecretaPrueProIleVo;
    private UsuarioVO usuarioConecVo;
    
    
    /**
     * Constructor.
     */
    public TramiteAutoPrueTrasVO() { }
    
    
    /**
     * Constructor.
     * @param siiTramiteAutoPrueTras
     */
    public TramiteAutoPrueTrasVO(SiiTramiteAutoPrueTras siiTramiteAutoPrueTras) 
    {
        if (siiTramiteAutoPrueTras!=null) {
            this.traCodigo = siiTramiteAutoPrueTras.getTraCodigo();
            this.traFecha = siiTramiteAutoPrueTras.getTraFecha();
            this.traPaso = siiTramiteAutoPrueTras.getTraPaso();
            //Padres
            if (siiTramiteAutoPrueTras.getSiiAutoDecretaPrueProIle()!= null) {
                this.autoDecretaPrueProIleVo = new AutoDecretaPrueProIleVO(siiTramiteAutoPrueTras.getSiiAutoDecretaPrueProIle());
            }
            if (siiTramiteAutoPrueTras.getSiiUsuarioConec()!= null) {
                this.usuarioConecVo = new UsuarioVO(siiTramiteAutoPrueTras.getSiiUsuarioConec());
            }
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TramiteAutoPrueTrasVO t) {
        int resultado = -1;
        
        if (t!=null && t.traPaso!=null && this.traPaso!=null) {
            if (this.traPaso.equals(t.traPaso)) {
                resultado = 0;
            }
            else {
                
                if (t.autoDecretaPrueProIleVo!=null && t.autoDecretaPrueProIleVo.getAtpTipoAuto()!=null) {
                    
                    // Construir un Map con el Orden de los Pasos.
                    Map<String, Integer> mapOrdenPasos = new HashMap<String, Integer>();
                    
                    
                    String tipoAuto = t.autoDecretaPrueProIleVo.getAtpTipoAuto();
                    if (EnumTipoAutoProcSancIleg.DECRETA_PRUEBAS.getId().equals(tipoAuto)) {
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.SOLICITUD_NUMERACION_AUTO_DECRETA_PRUEBAS.getIdPaso(), 1);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.NUMERACION_AUTO_DECRETA_PRUEBAS.getIdPaso(), 2);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.COMUNICACION_AUTO_DECRETA_PRUEBAS.getIdPaso(), 3);
                    }
                    else if (EnumTipoAutoProcSancIleg.NIEGA_PRUEBAS.getId().equals(tipoAuto)) {
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.SOLICITUD_NUMERACION_AUTO_NIEGA_PRUEBAS.getIdPaso(), 1);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.NUMERACION_AUTO_NIEGA_PRUEBAS.getIdPaso(), 2);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.COMUNICACION_AUTO_NIEGA_PRUEBAS.getIdPaso(), 3);
                    }
                    else if (EnumTipoAutoProcSancIleg.TRASLADO_ALEGATOS.getId().equals(tipoAuto)) {
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.SOLICITUD_NUMERACION_AUTO_TRASLADO_ALEGATOS.getIdPaso(), 1);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.NUMERACION_AUTO_TRASLADO_ALEGATOS.getIdPaso(), 2);
                        mapOrdenPasos.put(EnumPasoTramiteAutoPrueTras.COMUNICACION_AUTO_TRASLADO_ALEGATOS.getIdPaso(), 3);
                    }
                    
                    Integer orden1 = mapOrdenPasos.get(this.traPaso);
                    Integer orden2 = mapOrdenPasos.get(t.traPaso);
                    
                    if (orden1!=null && orden2!=null) {
                        resultado = orden1.compareTo(orden2);
                    }
                }
            }
        }
        
        return (resultado);
    }
    
    
    
    public void setTraCodigo(Long traCodigo) {
        this.traCodigo = traCodigo;
    }

    public Long getTraCodigo() {
        return traCodigo;
    }

    public void setTraFecha(Date traFecha) {
        this.traFecha = traFecha;
    }

    public Date getTraFecha() {
        return traFecha;
    }

    public void setTraPaso(String traPaso) {
        this.traPaso = traPaso;
    }

    public String getTraPaso() {
        return traPaso;
    }

    public void setAutoDecretaPrueProIleVo(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) {
        this.autoDecretaPrueProIleVo = autoDecretaPrueProIleVo;
    }

    public AutoDecretaPrueProIleVO getAutoDecretaPrueProIleVo() {
        return autoDecretaPrueProIleVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
