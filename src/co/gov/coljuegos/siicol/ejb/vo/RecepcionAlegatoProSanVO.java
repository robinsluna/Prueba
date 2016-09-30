package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionAlegatoProSan;

import java.util.Date;


/**
 * Value Object para la Recepci&oacute;n de Alegatos de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class RecepcionAlegatoProSanVO 
{
    private Long ralCodigo;
    private Date ralFechaRad;
    private String ralPruebas;
    private String ralRadicado;
    private String ralSolicitaPru;
    
    private UsuarioVO usuarioConecVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    
    
    /**
     * Constructor.
     */
    public RecepcionAlegatoProSanVO() { }
    
    
    /**
     * Constructor.
     * @param siiRecepcionAlegatoProSan
     */
    public RecepcionAlegatoProSanVO (SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan) 
    {
        if (siiRecepcionAlegatoProSan!=null) {
            this.ralCodigo = siiRecepcionAlegatoProSan.getRalCodigo();
            this.ralFechaRad = siiRecepcionAlegatoProSan.getRalFechaRad();
            this.ralPruebas = siiRecepcionAlegatoProSan.getRalPruebas();
            this.ralRadicado = siiRecepcionAlegatoProSan.getRalRadicado();
            this.ralSolicitaPru = siiRecepcionAlegatoProSan.getRalSolicitaPru();
            
            if (siiRecepcionAlegatoProSan.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiRecepcionAlegatoProSan.getSiiUsuarioConec());
            
            if (siiRecepcionAlegatoProSan.getSiiProcesoSancionatorio()!=null)
                this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiRecepcionAlegatoProSan.getSiiProcesoSancionatorio());
        }
    }


    public void setRalCodigo(Long ralCodigo) {
        this.ralCodigo = ralCodigo;
    }

    public Long getRalCodigo() {
        return ralCodigo;
    }

    public void setRalFechaRad(Date ralFechaRad) {
        this.ralFechaRad = ralFechaRad;
    }

    public Date getRalFechaRad() {
        return ralFechaRad;
    }

    public void setRalPruebas(String ralPruebas) {
        this.ralPruebas = ralPruebas;
    }

    public String getRalPruebas() {
        return ralPruebas;
    }

    public void setRalRadicado(String ralRadicado) {
        this.ralRadicado = ralRadicado;
    }

    public String getRalRadicado() {
        return ralRadicado;
    }

    public void setRalSolicitaPru(String ralSolicitaPru) {
        this.ralSolicitaPru = ralSolicitaPru;
    }

    public String getRalSolicitaPru() {
        return ralSolicitaPru;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }
    
    
    
    /**
     * Obtiene la representaci&oacute;n String del flag <i>ralSolicitaPru</i>.
     * @return ralSolicitaPru->nombre
     */
    public String getSolicitaPruebas () 
    {
        String solicitaPruebas = null;
        if (ralSolicitaPru!=null)
            solicitaPruebas = EnumDecision.getNombreById(ralSolicitaPru);
        
        return (solicitaPruebas);
    }
}
