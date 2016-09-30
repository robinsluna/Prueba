/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDecomDest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Value object que gestiona las resoluciones de decomiso y destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class ResolucionDecomDestVO {
    private Long rddCodigo;
    private Date rddFechaGener;
    private Date rddFechaRadicac;
    private Date rddFechaResolucion;
    private String rddResolucion;

    private UsuarioVO usuarioConectVo;
    private ActaDestruccionVO actaDestruccionVo;
    private ResultadoResDecDesVO resultadoResDecDesVo;
    private TramiteResolDecDesVO tramiteResolDecDesVO;

    private List<TramiteResolDecDesVO> tramiteResolDecDesVoList;
    private List<AccionControlVO> accionControlVoList;
    private List<AccionControlVO> accionControlResuelveVoList;
    private Date  rddFechaResolNumerado;
    private String rddNumeroResolNumerado;
    
    //datos grilla
    private Date fechaEjecutora;
    private Integer numeroAutocomisorio;
    private String  numActaHechosRetiroBienes;
    private String bodega;
    private String sucursal;
    private List<ElementoRetiradoAccVO> elementoRetiradoAccVoList; 

    
    /**
     * Constructor.
     */

    public ResolucionDecomDestVO() {
        super();
        resultadoResDecDesVo = new ResultadoResDecDesVO();
    }
    
    /**
     * Constructor.
     * @param siiResolucionDecomDest
     */

    public ResolucionDecomDestVO(SiiResolucionDecomDest siiResolucionDecomDest) {
        this.rddCodigo = siiResolucionDecomDest.getRddCodigo();
        this.rddFechaGener = siiResolucionDecomDest.getRddFechaGener();
        this.rddFechaRadicac = siiResolucionDecomDest.getRddFechaRadicac();
        this.rddResolucion = siiResolucionDecomDest.getRddResolucion();
        this.rddFechaResolucion= siiResolucionDecomDest.getRddFechaResolucion();
        this.rddFechaResolNumerado = siiResolucionDecomDest.getRddFechaResolNumera();
        this.rddNumeroResolNumerado = siiResolucionDecomDest.getRddResolucionNumera();

        if (siiResolucionDecomDest.getSiiUsuarioConect() != null) {
            this.usuarioConectVo = new UsuarioVO(siiResolucionDecomDest.getSiiUsuarioConect());
        }

        if (siiResolucionDecomDest.getSiiActaDestruccion() != null) {
            this.actaDestruccionVo = new ActaDestruccionVO(siiResolucionDecomDest.getSiiActaDestruccion());
        }
        
        if (siiResolucionDecomDest.getSiiResultadoResDecDes() != null) {
            this.resultadoResDecDesVo = new ResultadoResDecDesVO(siiResolucionDecomDest.getSiiResultadoResDecDes());
        }

    }

    /**
     * Adiciona un nuevo objecto a la lista de acciones de control.
     * @param accionControlVo
     * @return exitoso - boolean
     */

    public boolean addAccionControlVo(AccionControlVO accionControlVo) {
        boolean exitoso = false;

        if (accionControlVoList == null)
            accionControlVoList = new ArrayList<AccionControlVO>();

        exitoso = accionControlVoList.add(accionControlVo);

        if (exitoso)
            accionControlVo.setResolucionDecomDestVo(this);

        return (exitoso);
    }

    /**
     * Eliminar un registro de la lista de acción control.
     * @param accionControlVo
     * @return exitoso - boolean
     */
    
    public boolean removeAccionControlVo(AccionControlVO accionControlVo) {
        boolean exitoso = false;

        if (this.accionControlVoList != null) {
            exitoso = accionControlVoList.remove(accionControlVo);

            if (exitoso)
                accionControlVo.setResolucionDecomDestVo(null);
        }

        return (exitoso);
    }
    
    /**
     * Adiciona un nuevo registro de acción de control que resuelve
     * @param accionControlResuelveVo
     * @return exitoso - boolean
     */
    
    public boolean addAccionControlResuelveVo(AccionControlVO accionControlResuelveVo) {
        boolean exitoso = false;

        if (this.accionControlResuelveVoList == null)
            accionControlResuelveVoList = new ArrayList<AccionControlVO>();

        exitoso = accionControlResuelveVoList.add(accionControlResuelveVo);

        if (exitoso)
            accionControlResuelveVo.setResolucionDecomDestVo(this);

        return (exitoso);
    }

    /**
     * Remueve un registro de acción de control que resuelve
     * @param accionControlResuelveVo
     * @return exitoso - boolean
     */
    
    public boolean removeAccionControlResuelveVo(AccionControlVO accionControlResuelveVo) {
        boolean exitoso = false;

        if (this.accionControlResuelveVoList != null) {
            exitoso = accionControlResuelveVoList.remove(accionControlResuelveVo);

            if (exitoso)
                accionControlResuelveVo.setResolucionDecomDestVo(null);
        }

        return (exitoso);
    }

    /**
     * Adiciona un nuevo objecto a la lista de Trámites de Resolución de Decomiso y Destrucción
     * @param tramiteResolDecDesVo
     * @return exitoso - boolean
     */

    public boolean addTramiteResolDecDesVo(TramiteResolDecDesVO tramiteResolDecDesVo) {
        boolean exitoso = false;

        if (this.tramiteResolDecDesVoList == null)
            tramiteResolDecDesVoList = new ArrayList<TramiteResolDecDesVO>();

        exitoso = tramiteResolDecDesVoList.add(tramiteResolDecDesVo);

        if (exitoso)
            tramiteResolDecDesVo.setResolucionDecomDestVo(this);

        return (exitoso);
    }

    /**
     * Eliminar un registro de la lista de Trámites de Resolución de Decomiso y Destrucción
     * @param tramiteResolDecDesVo
     * @return exitoso - boolean
     */
    
    public boolean removeTramiteResolDecDesVo(TramiteResolDecDesVO tramiteResolDecDesVo) {
        boolean exitoso = false;

        if (this.tramiteResolDecDesVoList!= null) {
            exitoso = tramiteResolDecDesVoList.remove(tramiteResolDecDesVo);

            if (exitoso)
                tramiteResolDecDesVo.setResolucionDecomDestVo(null);
        }

        return (exitoso);
    }
    
    public AccionControlVO getAccionControlVO () {
        return ( accionControlVoList!=null && !accionControlVoList.isEmpty()?accionControlVoList.get(0):null );
    }

    public void setRddCodigo(Long rddCodigo) {
        this.rddCodigo = rddCodigo;
    }

    public Long getRddCodigo() {
        return rddCodigo;
    }

    public void setRddFechaGener(Date rddFechaGener) {
        this.rddFechaGener = rddFechaGener;
    }

    public Date getRddFechaGener() {
        return rddFechaGener;
    }

    public void setRddFechaRadicac(Date rddFechaRadicac) {
        this.rddFechaRadicac = rddFechaRadicac;
    }

    public Date getRddFechaRadicac() {
        return rddFechaRadicac;
    }

    public void setRddResolucion(String rddResolucion) {
        this.rddResolucion = rddResolucion;
    }

    public String getRddResolucion() {
        return rddResolucion;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setActaDestruccionVo(ActaDestruccionVO actaDestruccionVo) {
        this.actaDestruccionVo = actaDestruccionVo;
    }

    public ActaDestruccionVO getActaDestruccionVo() {
        return actaDestruccionVo;
    }

    public void setAccionControlVoList(List<AccionControlVO> accionControlVoList) {
        this.accionControlVoList = accionControlVoList;
    }

    public List<AccionControlVO> getAccionControlVoList() {
        return accionControlVoList;
    }

    public void setAccionControlResuelveVoList(List<AccionControlVO> accionControlResuelveVoList) {
        this.accionControlResuelveVoList = accionControlResuelveVoList;
    }

    public List<AccionControlVO> getAccionControlResuelveVoList() {
        return accionControlResuelveVoList;
    }

    public void setRddFechaResolucion(Date rddFechaResolucion) {
        this.rddFechaResolucion = rddFechaResolucion;
    }

    public Date getRddFechaResolucion() {
        return rddFechaResolucion;
    }

    public void setTramiteResolDecDesVoList(List<TramiteResolDecDesVO> tramiteResolDecDesVoList) {
        this.tramiteResolDecDesVoList = tramiteResolDecDesVoList;
    }

    public List<TramiteResolDecDesVO> getTramiteResolDecDesVoList() {
        return tramiteResolDecDesVoList;
    }

    public ResultadoResDecDesVO getResultadoResDecDesVo() {
        return resultadoResDecDesVo;
    }

    public void setResultadoResDecDesVo(ResultadoResDecDesVO resultadoResDecDesVo) {
        this.resultadoResDecDesVo = resultadoResDecDesVo;
    }

    public TramiteResolDecDesVO getTramiteResolDecDesVO() {
        if(tramiteResolDecDesVoList != null && tramiteResolDecDesVoList.size() > 0)
           return tramiteResolDecDesVoList.get(0);
        else 
        return new TramiteResolDecDesVO();
    }

    public void setTramiteResolDecDesVO(TramiteResolDecDesVO tramiteResolDecDesVO) {
        this.tramiteResolDecDesVO = tramiteResolDecDesVO;
    }

    public TramiteResolDecDesVO getTramiteResolDecDesVO1(){
        return tramiteResolDecDesVO;
    }

    public void setFechaEjecutora(Date fechaEjecutora){
        this.fechaEjecutora = fechaEjecutora;
    }

    public Date getFechaEjecutora(){
        return fechaEjecutora;
    }

    public void setNumeroAutocomisorio(Integer numeroAutocomisorio){
        this.numeroAutocomisorio = numeroAutocomisorio;
    }

    public Integer getNumeroAutocomisorio(){
        return numeroAutocomisorio;
    }


    public void setNumActaHechosRetiroBienes(String numActaHechosRetiroBienes){
        this.numActaHechosRetiroBienes = numActaHechosRetiroBienes;
    }

    public String getNumActaHechosRetiroBienes(){
        return numActaHechosRetiroBienes;
    }

    public void setBodega(String bodega){
        this.bodega = bodega;
    }

    public String getBodega(){
        return bodega;
    }

    public void setSucursal(String sucursal){
        this.sucursal = sucursal;
    }

    public String getSucursal(){
        return sucursal;
    }

    public void setElementoRetiradoAccVoList(List<ElementoRetiradoAccVO> elementoRetiradoAccVoList){
        this.elementoRetiradoAccVoList = elementoRetiradoAccVoList;
    }

    public List<ElementoRetiradoAccVO> getElementoRetiradoAccVoList(){
        return elementoRetiradoAccVoList;
    }


    public void setRddFechaResolNumerado(Date rddFechaResolNumerado){
        this.rddFechaResolNumerado = rddFechaResolNumerado;
    }

    public Date getRddFechaResolNumerado(){
        return rddFechaResolNumerado;
    }

    public void setRddNumeroResolNumerado(String rddNumeroResolNumerado){
        this.rddNumeroResolNumerado = rddNumeroResolNumerado;
    }

    public String getRddNumeroResolNumerado(){
        return rddNumeroResolNumerado;
    }

}
