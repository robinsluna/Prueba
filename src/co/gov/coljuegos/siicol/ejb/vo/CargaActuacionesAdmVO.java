package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class CargaActuacionesAdmVO{
   
    private Long caaCodigo;
    private Integer caaDiasPlazo;
    private String caaEstado;
    private Date caaFechaEjecut;
    private Date caaFechaFinInhab;
    private Date caaFechaIniInhab;
    private Date caaFechaMigracion;
    private Date caaFechaResoluc;
    private Long caaNumResolucion;
    private String caaTipoDias;
    private ContratoVO contratoVo;
    private List<ConcepCuotCarActAdmVO> listConcepCuotCarActAdmVO;
    private PersonaVO  personaVo;
    private List<PagoCargaActAdmVO> listPgoCargaActAdmVo;
    private List<AjusteContCarActVO> listAjusteContCarActVo;
    private DocumentoContableVO documentoContableVo;
    private ProcesoOriCargaVO procesoOriCargaVo;
    private MotivoIncumplimientoVO motivoIncumplimientoVo;
    private UsuarioVO usuarioConectadoVo;
    private ProyeccionCargaActVO proyeccionCargaActVo;
    private Integer caaConsecutivo;
    
    //para trabajo
    private List<PagoCargaActAdmVO> listeliminarPgoCargaActAdmVo;
    private List<ConcepCuotCarActAdmVO> listeliminarConcepCuotCarActAdmVO;
    private List<EstablecConCuoCarVO> listEliminarEstablecConCuoCarVo;
    private List<AjusteContCarActVO> listEliminarAjusteContCarActVo;
    private BigDecimal valorInicial;
       

    public CargaActuacionesAdmVO(SiiCargaActuacionesAdm siiCargaActuacionesAdm){
        
        this.caaCodigo = siiCargaActuacionesAdm.getCaaCodigo();
        this.caaDiasPlazo = siiCargaActuacionesAdm.getCaaDiasPlazo();
        this.caaEstado = siiCargaActuacionesAdm.getCaaEstado();
        this.caaFechaEjecut = siiCargaActuacionesAdm.getCaaFechaEjecut();
        this.caaFechaFinInhab = siiCargaActuacionesAdm.getCaaFechaFinInhab();
        this.caaFechaIniInhab = siiCargaActuacionesAdm.getCaaFechaIniInhab();
        this.caaFechaMigracion = siiCargaActuacionesAdm.getCaaFechaMigracion();
        this.caaFechaResoluc = siiCargaActuacionesAdm.getCaaFechaResoluc();
        this.caaNumResolucion = siiCargaActuacionesAdm.getCaaNumResolucion();
        this.caaTipoDias = siiCargaActuacionesAdm.getCaaTipoDias();
        this.caaConsecutivo = siiCargaActuacionesAdm.getCaaConsecutivo();
       
        if(siiCargaActuacionesAdm.getSiiContrato() != null  ) 
            this.contratoVo = new ContratoVO (siiCargaActuacionesAdm.getSiiContrato());
        
        if(siiCargaActuacionesAdm.getSiiPersona() != null )
            this.personaVo = new PersonaVO (siiCargaActuacionesAdm.getSiiPersona());
            
        if(siiCargaActuacionesAdm.getSiiDocumentoContable() != null ) 
            this.documentoContableVo = new DocumentoContableVO(siiCargaActuacionesAdm.getSiiDocumentoContable());
        
        if(siiCargaActuacionesAdm.getSiiProcesoOriCarga() != null )
            this.procesoOriCargaVo = new ProcesoOriCargaVO (siiCargaActuacionesAdm.getSiiProcesoOriCarga());
        
        if(siiCargaActuacionesAdm.getSiiMotivoIncumplimiento() != null )
            this.motivoIncumplimientoVo = new MotivoIncumplimientoVO (siiCargaActuacionesAdm.getSiiMotivoIncumplimiento());
        
        if(siiCargaActuacionesAdm.getSiiUsuarioConectado() != null)
            this.usuarioConectadoVo = new UsuarioVO(siiCargaActuacionesAdm.getSiiUsuarioConectado());
                
    }
   
    public CargaActuacionesAdmVO(){
       
    }


    public void setCaaCodigo(Long caaCodigo){
        this.caaCodigo = caaCodigo;
    }

    public Long getCaaCodigo(){
        return caaCodigo;
    }

    public void setCaaDiasPlazo(Integer caaDiasPlazo){
        this.caaDiasPlazo = caaDiasPlazo;
    }

    public Integer getCaaDiasPlazo(){
        return caaDiasPlazo;
    }

    public void setCaaEstado(String caaEstado){
        this.caaEstado = caaEstado;
    }

    public String getCaaEstado(){
        return caaEstado;
    }

    public void setCaaFechaEjecut(Date caaFechaEjecut){
        this.caaFechaEjecut = caaFechaEjecut;
    }

    public Date getCaaFechaEjecut(){
        return caaFechaEjecut;
    }

    public void setCaaFechaFinInhab(Date caaFechaFinInhab){
        this.caaFechaFinInhab = caaFechaFinInhab;
    }

    public Date getCaaFechaFinInhab(){
        return caaFechaFinInhab;
    }

    public void setCaaFechaIniInhab(Date caaFechaIniInhab){
        this.caaFechaIniInhab = caaFechaIniInhab;
    }

    public Date getCaaFechaIniInhab(){
        return caaFechaIniInhab;
    }

    public void setCaaFechaMigracion(Date caaFechaMigracion){
        this.caaFechaMigracion = caaFechaMigracion;
    }

    public Date getCaaFechaMigracion(){
        return caaFechaMigracion;
    }

    public void setCaaFechaResoluc(Date caaFechaResoluc){
        this.caaFechaResoluc = caaFechaResoluc;
    }

    public Date getCaaFechaResoluc(){
        return caaFechaResoluc;
    }

    public void setCaaNumResolucion(Long caaNumResolucion){
        this.caaNumResolucion = caaNumResolucion;
    }

    public Long getCaaNumResolucion(){
        return caaNumResolucion;
    }

    public void setCaaTipoDias(String caaTipoDias){
        this.caaTipoDias = caaTipoDias;
    }

    public String getCaaTipoDias(){
        return caaTipoDias;
    }

    public void setContratoVo(ContratoVO contratoVo){
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo(){
        return contratoVo;
    }

    public void setPersonaVo(PersonaVO personaVo){
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo(){
        return personaVo;
    }


    public void setDocumentoContableVo(DocumentoContableVO documentoContableVo){
        this.documentoContableVo = documentoContableVo;
    }

    public DocumentoContableVO getDocumentoContableVo(){
        return documentoContableVo;
    }


    public void setProcesoOriCargaVo(ProcesoOriCargaVO procesoOriCargaVo){
        this.procesoOriCargaVo = procesoOriCargaVo;
    }

    public ProcesoOriCargaVO getProcesoOriCargaVo(){
        return procesoOriCargaVo;
    }

    public void setMotivoIncumplimientoVo(MotivoIncumplimientoVO motivoIncumplimientoVo){
        this.motivoIncumplimientoVo = motivoIncumplimientoVo;
    }

    public MotivoIncumplimientoVO getMotivoIncumplimientoVo(){
        return motivoIncumplimientoVo;
    }


    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo){
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo(){
        return usuarioConectadoVo;
    }

    public void setListConcepCuotCarActAdmVO(List<ConcepCuotCarActAdmVO> listConcepCuotCarActAdmVO){
        this.listConcepCuotCarActAdmVO = listConcepCuotCarActAdmVO;
    }

    public List<ConcepCuotCarActAdmVO> getListConcepCuotCarActAdmVO(){
        return listConcepCuotCarActAdmVO;
    }

    public void setListPgoCargaActAdmVo(List<PagoCargaActAdmVO> listPgoCargaActAdmVo){
        this.listPgoCargaActAdmVo = listPgoCargaActAdmVo;
    }

    public List<PagoCargaActAdmVO> getListPgoCargaActAdmVo(){
        return listPgoCargaActAdmVo;
    }

    public void setListeliminarPgoCargaActAdmVo(List<PagoCargaActAdmVO> listeliminarPgoCargaActAdmVo){
        this.listeliminarPgoCargaActAdmVo = listeliminarPgoCargaActAdmVo;
    }

    public List<PagoCargaActAdmVO> getListeliminarPgoCargaActAdmVo(){
        return listeliminarPgoCargaActAdmVo;
    }

    public void setListeliminarConcepCuotCarActAdmVO(List<ConcepCuotCarActAdmVO> listeliminarConcepCuotCarActAdmVO){
        this.listeliminarConcepCuotCarActAdmVO = listeliminarConcepCuotCarActAdmVO;
    }

    public List<ConcepCuotCarActAdmVO> getListeliminarConcepCuotCarActAdmVO(){
        return listeliminarConcepCuotCarActAdmVO;
    }

    public void setValorInicial(BigDecimal valorInicial){
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorInicial(){
        return valorInicial;
    }

    public void setListEliminarEstablecConCuoCarVo(List<EstablecConCuoCarVO> listEliminarEstablecConCuoCarVo){
        this.listEliminarEstablecConCuoCarVo = listEliminarEstablecConCuoCarVo;
    }

    public List<EstablecConCuoCarVO> getListEliminarEstablecConCuoCarVo(){
        return listEliminarEstablecConCuoCarVo;
    }


    public void setListEliminarAjusteContCarActVo(List<AjusteContCarActVO> listEliminarAjusteContCarActVo){
        this.listEliminarAjusteContCarActVo = listEliminarAjusteContCarActVo;
    }

    public List<AjusteContCarActVO> getListEliminarAjusteContCarActVo(){
        return listEliminarAjusteContCarActVo;
    }

    public void setListAjusteContCarActVo(List<AjusteContCarActVO> listAjusteContCarActVo){
        this.listAjusteContCarActVo = listAjusteContCarActVo;
    }

    public List<AjusteContCarActVO> getListAjusteContCarActVo(){
        return listAjusteContCarActVo;
    }

    public void setProyeccionCargaActVo(ProyeccionCargaActVO proyeccionCargaActVo){
        this.proyeccionCargaActVo = proyeccionCargaActVo;
    }

    public ProyeccionCargaActVO getProyeccionCargaActVo(){
        return proyeccionCargaActVo;
    }

    public void setCaaConsecutivo(Integer caaConsecutivo){
        this.caaConsecutivo = caaConsecutivo;
    }

    public Integer getCaaConsecutivo(){
        return caaConsecutivo;
    }

}
