package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcIleg;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Value Object para los Descargos del Proceso Sancionatorio de Ilegalidad.
 * @author Carlos Arciniegas
 */
public class DescargoProcIlegVO 
{
    private Long dprCodigo;
    private Date dprFechaRadic;
    private String dprRadicado;
    private String dprSolicitaPrue;
    private String dprObservaciones;
    
    private UsuarioVO usuarioVo;
    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    
    private List<PruebaDescargoProIleVO> pruebaDescargoProIleList;
    
    
    
    /**
     * Constructor.
     */
    public DescargoProcIlegVO() { }
    
    
    /**
     * Constructor.
     * @param siiDescargoProcIleg - Entity.
     */
    public DescargoProcIlegVO (SiiDescargoProcIleg siiDescargoProcIleg) 
    {
        if (siiDescargoProcIleg!=null) {
            this.dprCodigo = siiDescargoProcIleg.getDprCodigo();
            this.dprFechaRadic = siiDescargoProcIleg.getDprFechaRadic();
            this.dprRadicado = siiDescargoProcIleg.getDprRadicado();
            this.dprSolicitaPrue = siiDescargoProcIleg.getDprSolicitaPrue();
            this.dprObservaciones = siiDescargoProcIleg.getDprObservaciones();
            
            //Padres
            if (siiDescargoProcIleg.getSiiProcesoSancIlegalidad()!=null) {
                this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiDescargoProcIleg.getSiiProcesoSancIlegalidad());
            }
            if (siiDescargoProcIleg.getSiiUsuario()!=null){
                this.usuarioVo = new UsuarioVO(siiDescargoProcIleg.getSiiUsuario());
            }
        }
    }
    
    
    public void setDprCodigo(Long dprCodigo) {
        this.dprCodigo = dprCodigo;
    }

    public Long getDprCodigo() {
        return dprCodigo;
    }

    public void setDprFechaRadic(Date dprFechaRadic) {
        this.dprFechaRadic = dprFechaRadic;
    }

    public Date getDprFechaRadic() {
        return dprFechaRadic;
    }

    public void setDprRadicado(String dprRadicado) {
        this.dprRadicado = dprRadicado;
    }

    public String getDprRadicado() {
        return dprRadicado;
    }

    public void setDprSolicitaPrue(String dprSolicitaPrue) {
        this.dprSolicitaPrue = dprSolicitaPrue;
    }

    public String getDprSolicitaPrue() {
        return dprSolicitaPrue;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }

    public void setDprObservaciones(String dprObservaciones) {
        this.dprObservaciones = dprObservaciones;
    }

    public String getDprObservaciones() {
        return dprObservaciones;
    }

    public void setPruebaDescargoProIleList(List<PruebaDescargoProIleVO> pruebaDescargoProIleList) {
        this.pruebaDescargoProIleList = pruebaDescargoProIleList;
    }

    public List<PruebaDescargoProIleVO> getPruebaDescargoProIleList() {
        return pruebaDescargoProIleList;
    }
    
    
    
    /**
     * Adiciona un registro de Prueba de Descargo de Proceso Sancionatorio de Ilegalidad a la lista.
     * @param pruebaDescargoProIleVo
     * @return
     */
    public boolean addPruebaDescargoProIle (PruebaDescargoProIleVO pruebaDescargoProIleVo) 
    {
        boolean exitoso = false;
        
        if (pruebaDescargoProIleList==null)
            pruebaDescargoProIleList = new ArrayList<PruebaDescargoProIleVO>();
        
        exitoso = pruebaDescargoProIleList.add(pruebaDescargoProIleVo);
        if (exitoso)
            pruebaDescargoProIleVo.setDescargoProcIlegVo(this);
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de Prueba de Descargo de Proceso Sancionatorio de Ilegalidad de la lista.
     * @param pruebaDescargoProIleVo
     * @return
     */
    public boolean removePruebaDescargoProIle (PruebaDescargoProIleVO pruebaDescargoProIleVo) 
    {
        boolean exitoso = false;
        exitoso = pruebaDescargoProIleList.remove(pruebaDescargoProIleVo);
        if (exitoso)
            pruebaDescargoProIleVo.setDescargoProcIlegVo(null);
        return (exitoso);
    }
    
    
    
    /**
     * Devuelve la cadena que representa el campo dprSolicitaPrue.
     * @return Solicita Pruebas (SI/NO)?
     */
    public String getSolicitaPruebas () 
    {
        String solicitaPruebas = null;
        
        if (dprSolicitaPrue!=null) {
            solicitaPruebas = EnumDecision.SI.getId().equals(dprSolicitaPrue) ? EnumDecision.SI.getNombre() : EnumDecision.NO.getNombre();
        }
        
        return (solicitaPruebas);
    }
    
    
    /**
     * Construye una Cadena con los nombres de los Tipos de Prueba asociados a c/u de las Pruebas del Descargo del Proceso Sancionatorio de Ilegalidad.
     * @return Cadena con el listado de nombres de Tipos de Prueba correspondientes a cada Prueba de Descargo, separada por comas.
     */
    public String getPruebasSolicitadas () 
    {
        String pruebasSolicitadas = null;
        if (pruebaDescargoProIleList!=null && !pruebaDescargoProIleList.isEmpty()) {
            StringBuilder txtPruebas = new StringBuilder();
            Iterator<PruebaDescargoProIleVO> itPruebas = pruebaDescargoProIleList.iterator();
            while (itPruebas.hasNext()) {
                PruebaDescargoProIleVO pdpVo = itPruebas.next();
                if (pdpVo!=null && pdpVo.getTipoPruebaIlegVo()!=null && pdpVo.getTipoPruebaIlegVo().getTpiNombre()!=null) {
                    txtPruebas.append(pdpVo.getTipoPruebaIlegVo().getTpiNombre());
                    
                    if (itPruebas.hasNext())
                    txtPruebas.append(", ");
                }
            }
            
            pruebasSolicitadas = txtPruebas.toString();
        }
        
        return (pruebasSolicitadas);
    }
}

