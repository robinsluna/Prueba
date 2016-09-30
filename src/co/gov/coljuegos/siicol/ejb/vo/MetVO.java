/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 27-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;

import java.util.Date;
import java.util.List;

public class MetVO {
    
     private Long metCodigo;
    private Date metFechaFab;
    private String metHomologado;
    private String metOnline;
    private String metSerial;
    private String metUid;
    private List<InstrumentoVO> instrumentoList1;   
    private MarcaVO marcaVo;
    private String metMarcaAnterior;
    private String metModelo;
    private String metNuid;
    private Date metFechaMarcaOnline;
    
    public MetVO(SiiMet siiMet){
       this.metCodigo       =  siiMet.getMetCodigo();
       this.metFechaFab     = siiMet.getMetFechaFab();
       this.metHomologado   = siiMet.getMetHomologado();
       this.metOnline       = siiMet.getMetOnline();
       this.metSerial       = siiMet.getMetSerial();
       this.metUid          = siiMet.getMetUid();
       this.metMarcaAnterior = siiMet.getMetMarcaAnterior();
       this.metModelo       = siiMet.getMetModelo();
       this.metNuid         = siiMet.getMetNuid();
       this.metFechaMarcaOnline = siiMet.getMetFechaMarcOnline();
       
       if(siiMet.getSiiMarca()!= null){
           this.marcaVo = new MarcaVO(siiMet.getSiiMarca());
       }
    }
    
    public MetVO() {
    }

    public void setMetModelo(String metModelo) {
        this.metModelo = metModelo;
    }

    public String getMetModelo() {
        return metModelo;
    }

    public void setMetNuid(String metNuid) {
        this.metNuid = metNuid;
    }

    public String getMetNuid() {
        return metNuid;
    }

    public void setMetMarcaAnterior(String metMarcaAnterior) {
        this.metMarcaAnterior = metMarcaAnterior;
    }

    public String getMetMarcaAnterior() {
        return metMarcaAnterior;
    }

    public void setMetCodigo(Long metCodigo) {
        this.metCodigo = metCodigo;
    }

    public Long getMetCodigo() {
        return metCodigo;
    }

    public void setMetFechaFab(Date metFechaFab) {
        this.metFechaFab = metFechaFab;
    }

    public Date getMetFechaFab() {
        return metFechaFab;
    }

    public void setMetHomologado(String metHomologado) {
        this.metHomologado = metHomologado;
    }

    public String getMetHomologado() {
        return metHomologado;
    }

    public void setMetOnline(String metOnline) {
        this.metOnline = metOnline;
    }

    public String getMetOnline() {
        return metOnline;
    }

    public void setMetSerial(String metSerial) {
        this.metSerial = metSerial;
    }

    public String getMetSerial() {
        return metSerial;
    }

    public void setMetUid(String metUid) {
        this.metUid = metUid;
    }

    public String getMetUid() {
        return metUid;
    }

    public void setInstrumentoList1(List<InstrumentoVO> instrumentoList1) {
        this.instrumentoList1 = instrumentoList1;
    }

    public List<InstrumentoVO> getInstrumentoList1() {
        return instrumentoList1;
    }


    public void setMarcaVo(MarcaVO marcaVo) {
        this.marcaVo = marcaVo;
    }

    public MarcaVO getMarcaVo() {
        return marcaVo;
    }

    public void setMetFechaMarcaOnline(Date metFechaMarcaOnline) {
        this.metFechaMarcaOnline = metFechaMarcaOnline;
    }

    public Date getMetFechaMarcaOnline() {
        return metFechaMarcaOnline;
    }
}
