package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TerminoReferenciaVO {
    private Long tdrCodigo;
    private Date tdrFechaApAud;
    private Date tdrFechaApDef;
    private Date tdrFechaApObs;
    private Date tdrFechaApObsDef;
    private Date tdrFechaApProy;
    private Date tdrFechaEnAud;
    private Date tdrFechaPbProy;
    private Date tdrFechaPbObs;
    private Date tdrFechaPbDef;
    private Date tdrFechaPbObsDef;
    private Date tdrFechaPbAud;
    private Date tdrFechaEnProy;
    private Date tdrFechaEnObs;
    private Date tdrFechaEnDef;
    private Date tdrFechaEnObsDef;   
    private ProcesoContratacionVO procesoContratacionVO;
    private String tdrRadicAud;
    private String tdrRadicDef;
    private String tdrRadicObs;
    private String tdrRadicObsDef;
    private String tdrRadicProy;
    private String objeto;
    private String areaSolicitante;
    
    
   
    
    public TerminoReferenciaVO() {
    }
    
    public TerminoReferenciaVO(SiiTerminosReferencia terminoReferencia) {
       this.tdrCodigo = terminoReferencia.getTdrCodigo();
       this.tdrFechaApAud = terminoReferencia.getTdrFechaApAud();
       this.tdrFechaApDef = terminoReferencia.getTdrFechaApDef();
       this.tdrFechaApObs = terminoReferencia.getTdrFechaApObs();
       this.tdrFechaApObsDef= terminoReferencia.getTdrFechaApObsDef();
       this.tdrFechaApProy = terminoReferencia.getTdrFechaApProy();
       this.tdrFechaEnAud = terminoReferencia.getTdrFechaEnAud();
       this.tdrFechaEnDef = terminoReferencia.getTdrFechaEnDef();
       this.tdrFechaEnObs = terminoReferencia.getTdrFechaEnObs();
       this.tdrFechaEnObsDef = terminoReferencia.getTdrFechaEnObsDef();
       this.tdrFechaEnProy = terminoReferencia.getTdrFechaEnProy();
       this.tdrFechaPbAud = terminoReferencia.getTdrFechaPbAud();
       this.tdrFechaPbDef = terminoReferencia.getTdrFechaPbDef();
       this.tdrFechaPbObs = terminoReferencia.getTdrFechaPbObs();
       this.tdrFechaPbObsDef = terminoReferencia.getTdrFechaPbObsDef();
       this.tdrFechaPbProy = terminoReferencia.getTdrFechaPbProy();
       this.tdrRadicAud = terminoReferencia.getTdrRadicAud();
       this.tdrRadicDef = terminoReferencia.getTdrRadicDef();
       this.tdrRadicObs = terminoReferencia.getTdrRadicObs();
       this.tdrRadicObsDef = terminoReferencia.getTdrRadicObsDef();
       this.tdrRadicProy = terminoReferencia.getTdrRadicProy();
       
              
       if(terminoReferencia.getSiiProcesoContratacion()!=null){
           this.procesoContratacionVO = new ProcesoContratacionVO(terminoReferencia.getSiiProcesoContratacion());
       }
           
       
       
       
              
    }

    public void setProcesoContratacionVO(ProcesoContratacionVO procesoContratacionVO) {
        this.procesoContratacionVO = procesoContratacionVO;
    }

    public ProcesoContratacionVO getProcesoContratacionVO() {
        return procesoContratacionVO;
    }
   
    
    
    

    public void setTdrCodigo(Long tdrCodigo) {
        this.tdrCodigo = tdrCodigo;
    }

    public Long getTdrCodigo() {
        return tdrCodigo;
    }

    public void setTdrFechaApAud(Date tdrFechaApAud) {
        this.tdrFechaApAud = tdrFechaApAud;
    }

    public Date getTdrFechaApAud() {
        return tdrFechaApAud;
    }

    public void setTdrFechaApDef(Date tdrFechaApDef) {
        this.tdrFechaApDef = tdrFechaApDef;
    }

    public Date getTdrFechaApDef() {
        return tdrFechaApDef;
    }

    public void setTdrFechaApObs(Date tdrFechaApObs) {
        this.tdrFechaApObs = tdrFechaApObs;
    }

    public Date getTdrFechaApObs() {
        return tdrFechaApObs;
    }

    public void setTdrFechaApObsDef(Date tdrFechaApObsDef) {
        this.tdrFechaApObsDef = tdrFechaApObsDef;
    }

    public Date getTdrFechaApObsDef() {
        return tdrFechaApObsDef;
    }

    public void setTdrFechaApProy(Date tdrFechaApProy) {
        this.tdrFechaApProy = tdrFechaApProy;
    }

    public Date getTdrFechaApProy() {
        return tdrFechaApProy;
    }

    public void setTdrFechaEnAud(Date tdrFechaEnAud) {
        this.tdrFechaEnAud = tdrFechaEnAud;
    }

    public Date getTdrFechaEnAud() {
        return tdrFechaEnAud;
    }

    public void setTdrFechaEnDef(Date tdrFechaEnDef) {
        this.tdrFechaEnDef = tdrFechaEnDef;
    }

    public Date getTdrFechaEnDef() {
        return tdrFechaEnDef;
    }

    public void setTdrFechaEnObs(Date tdrFechaEnObs) {
        this.tdrFechaEnObs = tdrFechaEnObs;
    }

    public Date getTdrFechaEnObs() {
        return tdrFechaEnObs;
    }

    public void setTdrFechaEnObsDef(Date tdrFechaEnObsDef) {
        this.tdrFechaEnObsDef = tdrFechaEnObsDef;
    }

    public Date getTdrFechaEnObsDef() {
        return tdrFechaEnObsDef;
    }

    public void setTdrFechaEnProy(Date tdrFechaEnProy) {
        this.tdrFechaEnProy = tdrFechaEnProy;
    }

    public Date getTdrFechaEnProy() {
        return tdrFechaEnProy;
    }

    public void setTdrFechaPbAud(Date tdrFechaPbAud) {
        this.tdrFechaPbAud = tdrFechaPbAud;
    }

    public Date getTdrFechaPbAud() {
        return tdrFechaPbAud;
    }

    public void setTdrFechaPbDef(Date tdrFechaPbDef) {
        this.tdrFechaPbDef = tdrFechaPbDef;
    }

    public Date getTdrFechaPbDef() {
        return tdrFechaPbDef;
    }

    public void setTdrFechaPbObs(Date tdrFechaPbObs) {
        this.tdrFechaPbObs = tdrFechaPbObs;
    }

    public Date getTdrFechaPbObs() {
        return tdrFechaPbObs;
    }

    public void setTdrFechaPbObsDef(Date tdrFechaPbObsDef) {
        this.tdrFechaPbObsDef = tdrFechaPbObsDef;
    }

    public Date getTdrFechaPbObsDef() {
        return tdrFechaPbObsDef;
    }

    public void setTdrFechaPbProy(Date tdrFechaPbProy) {
        this.tdrFechaPbProy = tdrFechaPbProy;
    }

    public Date getTdrFechaPbProy() {
        return tdrFechaPbProy;
    }

   

   

    public void setTdrRadicAud(String tdrRadicAud) {
        this.tdrRadicAud = tdrRadicAud;
    }

    public String getTdrRadicAud() {
        return tdrRadicAud;
    }

    public void setTdrRadicDef(String tdrRadicDef) {
        this.tdrRadicDef = tdrRadicDef;
    }

    public String getTdrRadicDef() {
        return tdrRadicDef;
    }

    public void setTdrRadicObs(String tdrRadicObs) {
        this.tdrRadicObs = tdrRadicObs;
    }

    public String getTdrRadicObs() {
        return tdrRadicObs;
    }

    public void setTdrRadicObsDef(String tdrRadicObsDef) {
        this.tdrRadicObsDef = tdrRadicObsDef;
    }

    public String getTdrRadicObsDef() {
        return tdrRadicObsDef;
    }

    public void setTdrRadicProy(String tdrRadicProy) {
        this.tdrRadicProy = tdrRadicProy;
    }

    public String getTdrRadicProy() {
        return tdrRadicProy;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
    }

    public String getAreaSolicitante() {
        return areaSolicitante;
    }
}
