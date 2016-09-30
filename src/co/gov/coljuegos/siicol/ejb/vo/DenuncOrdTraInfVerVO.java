package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;


import java.math.BigDecimal;

import java.util.List;

public class DenuncOrdTraInfVerVO {
   
    private Long  divCodigo;
    private String divDireccion;
    private String divTipoJuego;
    private List<ElementoIlegInfVerVO> listElementoIlegInfVerVo;
    private ResultadoVerifCampoVO resultadoVerifCampoVo;
    private InformeVerificCampoVO informeVerificCampoVo;
    private DenunciaOrdenTrabVO denunciaOrdenTrabVo;
    private String bivActivo;
    //campos para grilla
    private List<ResultadoVerifCampoVO> listResultadoVerifCampoVo;
    private String cprincipal;
    private String cprincipal2;
    private String cprincipal3;
    private String cprincipal4;
    private String cprincipal5;
    private String calterna;
    private String calterna2;
    private String calterna3;
    private String calterna4;
    private String calterna5;
    private String resultadoVerificacion;
    private List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVerVo;
   
    public DenuncOrdTraInfVerVO(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        this.divCodigo = siiDenuncOrdTraInfVer.getDivCodigo();
        this.divDireccion = siiDenuncOrdTraInfVer.getDivDireccion();
        this.divTipoJuego = siiDenuncOrdTraInfVer.getDivTipoJuego();
        this.bivActivo = siiDenuncOrdTraInfVer.getDivActivo();
        if(siiDenuncOrdTraInfVer.getSiiResultadoVerifCampo() != null ){
            this.resultadoVerifCampoVo = new ResultadoVerifCampoVO (siiDenuncOrdTraInfVer.getSiiResultadoVerifCampo());
        }
        
        if(siiDenuncOrdTraInfVer.getSiiDenunciaOrdenTrab() != null ){
            this.denunciaOrdenTrabVo = new DenunciaOrdenTrabVO (siiDenuncOrdTraInfVer.getSiiDenunciaOrdenTrab());
        }
        
        if(siiDenuncOrdTraInfVer.getSiiInformeVerificCampo() != null ){
            this.informeVerificCampoVo = new InformeVerificCampoVO (siiDenuncOrdTraInfVer.getSiiInformeVerificCampo());
        }
        
    }
   
    public DenuncOrdTraInfVerVO( ) {
     
    }


    public void setDivCodigo(Long divCodigo){
        this.divCodigo = divCodigo;
    }

    public Long getDivCodigo(){
        return divCodigo;
    }


    public void setDivDireccion(String divDireccion) {
        this.divDireccion = divDireccion;
    }

    public String getDivDireccion() {
        if( divDireccion == null){
            divDireccion =(cprincipal +" " +cprincipal2);
            if(cprincipal3 != null )
                divDireccion =(divDireccion +" "+cprincipal3);
            if(cprincipal4 != null )
                divDireccion =(divDireccion +" "+cprincipal4); 
            if(cprincipal5 != null )
                divDireccion =(divDireccion +" "+cprincipal5); 
            if(calterna != null )
                divDireccion =(divDireccion +" "+calterna); 
            if(calterna2 != null )
                divDireccion =(divDireccion +" "+calterna2);
            if(calterna3 != null )
                divDireccion =(divDireccion +" "+calterna3);
            if(calterna4 != null )
                divDireccion =(divDireccion +" "+calterna4);
            if(calterna5 != null )
                divDireccion =(divDireccion +" "+calterna5);
        }
        
        return divDireccion;
    }

    public void setDivTipoJuego(String divTipoJuego) {
        this.divTipoJuego = divTipoJuego;
    }

    public String getDivTipoJuego() {
        return divTipoJuego;
    }

    public void setListElementoIlegInfVerVo(List<ElementoIlegInfVerVO> listElementoIlegInfVerVo) {
        this.listElementoIlegInfVerVo = listElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getListElementoIlegInfVerVo() {
        return listElementoIlegInfVerVo;
    }

    public void setResultadoVerifCampoVo(ResultadoVerifCampoVO resultadoVerifCampoVo) {
        this.resultadoVerifCampoVo = resultadoVerifCampoVo;
    }

    public ResultadoVerifCampoVO getResultadoVerifCampoVo() {
        return resultadoVerifCampoVo;
    }

    public void setInformeVerificCampoVo(InformeVerificCampoVO informeVerificCampoVo) {
        this.informeVerificCampoVo = informeVerificCampoVo;
    }

    public InformeVerificCampoVO getInformeVerificCampoVo() {
        return informeVerificCampoVo;
    }

    public void setDenunciaOrdenTrabVo(DenunciaOrdenTrabVO denunciaOrdenTrabVo) {
        this.denunciaOrdenTrabVo = denunciaOrdenTrabVo;
    }

    public DenunciaOrdenTrabVO getDenunciaOrdenTrabVo() {
        return denunciaOrdenTrabVo;
    }

    public void setBivActivo(String bivActivo){
        this.bivActivo = bivActivo;
    }

    public String getBivActivo(){
        return bivActivo;
    }

    public void setListResultadoVerifCampoVo(List<ResultadoVerifCampoVO> listResultadoVerifCampoVo){
        this.listResultadoVerifCampoVo = listResultadoVerifCampoVo;
    }

    public List<ResultadoVerifCampoVO> getListResultadoVerifCampoVo(){
        return listResultadoVerifCampoVo;
    }


    public void setCprincipal(String cprincipal){
        this.cprincipal = cprincipal;
    }

    public String getCprincipal(){
        return cprincipal;
    }

    public void setCprincipal2(String cprincipal2){
        this.cprincipal2 = cprincipal2;
    }

    public String getCprincipal2(){
        return cprincipal2;
    }

    public void setCprincipal3(String cprincipal3){
        this.cprincipal3 = cprincipal3;
    }

    public String getCprincipal3(){
        return cprincipal3;
    }

    public void setCprincipal4(String cprincipal4){
        this.cprincipal4 = cprincipal4;
    }

    public String getCprincipal4(){
        return cprincipal4;
    }

    public void setCprincipal5(String cprincipal5){
        this.cprincipal5 = cprincipal5;
    }

    public String getCprincipal5(){
        return cprincipal5;
    }

    public void setCalterna(String calterna){
        this.calterna = calterna;
    }

    public String getCalterna(){
        return calterna;
    }

    public void setCalterna2(String calterna2){
        this.calterna2 = calterna2;
    }

    public String getCalterna2(){
        return calterna2;
    }

    public void setCalterna3(String calterna3){
        this.calterna3 = calterna3;
    }

    public String getCalterna3(){
        return calterna3;
    }

    public void setCalterna4(String calterna4){
        this.calterna4 = calterna4;
    }

    public String getCalterna4(){
        return calterna4;
    }

    public void setCalterna5(String calterna5){
        this.calterna5 = calterna5;
    }

    public String getCalterna5(){
        return calterna5;
    }

    public void setResultadoVerificacion(String resultadoVerificacion){
        this.resultadoVerificacion = resultadoVerificacion;
    }

    public String getResultadoVerificacion(){
        return resultadoVerificacion;
    }

    public void setListEliminarElementoIlegInfVerVo(List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVerVo){
        this.listEliminarElementoIlegInfVerVo = listEliminarElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getListEliminarElementoIlegInfVerVo(){
        return listEliminarElementoIlegInfVerVo;
    }
}
