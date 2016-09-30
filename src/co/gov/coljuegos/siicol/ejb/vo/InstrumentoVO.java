/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Proceso recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;

import java.util.Date;
import java.util.List;

public class InstrumentoVO {
     
    private String insActivo;
    private Long insCodigo;
    private Date insFechaModific;
    private Date insFechaRegistro;
    private Long tapCodigo;
    private TipoInstrumentoVO tipoInstrumentoVo;
    private MetVO metVo;
    private List<InventarioVO> inventarioVoList;
    private OperadorVO operadorVo;
    private MesaCasinoVO mesaCasino;
    private TipoApuestaVO tipoApuestaVo;
    
    public InstrumentoVO(){
    }
    
    public InstrumentoVO(SiiInstrumento siiInstrumento){
        this.insActivo = siiInstrumento.getInsActivo();
        this.insCodigo = siiInstrumento.getInsCodigo();
        this.insFechaModific = siiInstrumento.getInsFechaModific();
        this.insFechaRegistro = siiInstrumento.getInsFechaRegistro();
        this.tapCodigo = siiInstrumento.getTapCodigo();
        if(siiInstrumento.getSiiTipoInstrumento()!= null){
            this.tipoInstrumentoVo = new TipoInstrumentoVO(siiInstrumento.getSiiTipoInstrumento());
            }
        if(siiInstrumento.getSiiMet()!= null){
            this.metVo = new MetVO(siiInstrumento.getSiiMet());
        }
        if(siiInstrumento.getSiiOperador1()!= null){
            this.operadorVo = new OperadorVO(siiInstrumento.getSiiOperador1());
            }
        if(siiInstrumento.getSiiMesaCasino()!= null){
            this.mesaCasino= new MesaCasinoVO(siiInstrumento.getSiiMesaCasino());
            }
        
    }

    public void setInsActivo(String insActivo) {
        this.insActivo = insActivo;
    }

    public String getInsActivo() {
        return insActivo;
    }

    public void setInsCodigo(Long insCodigo) {
        this.insCodigo = insCodigo;
    }

    public Long getInsCodigo() {
        return insCodigo;
    }

    public void setInsFechaModific(Date insFechaModific) {
        this.insFechaModific = insFechaModific;
    }

    public Date getInsFechaModific() {
        return insFechaModific;
    }

    public void setInsFechaRegistro(Date insFechaRegistro) {
        this.insFechaRegistro = insFechaRegistro;
    }

    public Date getInsFechaRegistro() {
        return insFechaRegistro;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }

    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTipoInstrumentoVo(TipoInstrumentoVO tipoInstrumentoVo) {
        this.tipoInstrumentoVo = tipoInstrumentoVo;
    }

    public TipoInstrumentoVO getTipoInstrumentoVo() {
        return tipoInstrumentoVo;
    }

    public void setMetVo(MetVO metVo) {
        this.metVo = metVo;
    }

    public MetVO getMetVo() {
        return metVo;
    }

    public void setInventarioVoList(List<InventarioVO> inventarioVoList) {
        this.inventarioVoList = inventarioVoList;
    }

    public List<InventarioVO> getInventarioVoList() {
        return inventarioVoList;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }


    public void setMesaCasino(MesaCasinoVO mesaCasino) {
        this.mesaCasino = mesaCasino;
    }

    public MesaCasinoVO getMesaCasino() {
        return mesaCasino;
    }


    public void setOperadorVo(PersonaVO personaVO) {
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

}
