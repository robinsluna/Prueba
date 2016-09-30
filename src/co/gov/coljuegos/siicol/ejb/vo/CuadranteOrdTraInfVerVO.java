package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdTraInfVer;

import java.util.List;

public class CuadranteOrdTraInfVerVO {
    
    private Long civCodigo;
    private String civDireccion;
    private String civTipoJuego;
    private List<ElementoIlegInfVerVO> listElementoIlegInfVer;
    private List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVer;
    private InformeVerificCampoVO informeVerificCampoVo;
    private CuadranteOrdenTraVO cuadranteOrdenTraVo;
    private String rvcNombre;
    private String civActivo;
    
    private String resultadoVerificacion;
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
 
    
    public CuadranteOrdTraInfVerVO(SiiCuadranteOrdTraInfVer  siiCuadranteOrdTraInfVer ) {
        
        this.civCodigo = siiCuadranteOrdTraInfVer.getCivCodigo();
        this.civDireccion = siiCuadranteOrdTraInfVer.getCivDireccion();
        this.civTipoJuego = siiCuadranteOrdTraInfVer.getCivTipoJuego();
        this.civActivo = siiCuadranteOrdTraInfVer.getCivActivo();
        if(siiCuadranteOrdTraInfVer.getSiiInformeVerificCampo1() != null){
            this.informeVerificCampoVo = new InformeVerificCampoVO( siiCuadranteOrdTraInfVer.getSiiInformeVerificCampo1() );
        }
        
        if(siiCuadranteOrdTraInfVer.getSiiCuadranteOrdenTra() != null ){
            this.cuadranteOrdenTraVo = new CuadranteOrdenTraVO (siiCuadranteOrdTraInfVer.getSiiCuadranteOrdenTra());
        }
        
    }
    
    public CuadranteOrdTraInfVerVO() {
    
    }
    


    public void setCivCodigo(Long civCodigo) {
        this.civCodigo = civCodigo;
    }

    public Long getCivCodigo() {
        return civCodigo;
    }

    public void setCivDireccion(String civDireccion) {
        this.civDireccion = civDireccion;
    }

    public String getCivDireccion() {
        if( civDireccion == null){
            civDireccion =(cprincipal +" " +cprincipal2);
            if(cprincipal3 != null )
                civDireccion =(civDireccion +" "+cprincipal3);
            if(cprincipal4 != null )
                civDireccion =(civDireccion +" "+cprincipal4); 
            if(cprincipal5 != null )
                civDireccion =(civDireccion +" "+cprincipal5); 
            if(calterna != null )
                civDireccion =(civDireccion +" "+calterna); 
            if(calterna2 != null )
                civDireccion =(civDireccion +" "+calterna2);
            if(calterna3 != null )
                civDireccion =(civDireccion +" "+calterna3);
            if(calterna4 != null )
                civDireccion =(civDireccion +" "+calterna4);
            if(calterna5 != null )
                civDireccion =(civDireccion +" "+calterna5);
        }
        
        return civDireccion;
    }

    public void setCivTipoJuego(String civTipoJuego) {
        this.civTipoJuego = civTipoJuego;
    }

    public String getCivTipoJuego() {
        return civTipoJuego;
    }

    public void setListElementoIlegInfVer(List<ElementoIlegInfVerVO> listElementoIlegInfVer) {
        this.listElementoIlegInfVer = listElementoIlegInfVer;
    }

    public List<ElementoIlegInfVerVO> getListElementoIlegInfVer() {
        return listElementoIlegInfVer;
    }


    public void setInformeVerificCampoVo(InformeVerificCampoVO informeVerificCampoVo) {
        this.informeVerificCampoVo = informeVerificCampoVo;
    }

    public InformeVerificCampoVO getInformeVerificCampoVo() {
        return informeVerificCampoVo;
    }

    public void setCuadranteOrdenTraVo(CuadranteOrdenTraVO cuadranteOrdenTraVo) {
        this.cuadranteOrdenTraVo = cuadranteOrdenTraVo;
    }

    public CuadranteOrdenTraVO getCuadranteOrdenTraVo() {
        return cuadranteOrdenTraVo;
    }

    public void setRvcNombre(String rvcNombre){
        this.rvcNombre = rvcNombre;
    }

    public String getRvcNombre(){
        return rvcNombre;
    }

    public void setCivActivo(String civActivo){
        this.civActivo = civActivo;
    }

    public String getCivActivo(){
        return civActivo;
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

    public void setListEliminarElementoIlegInfVer(List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVer){
        this.listEliminarElementoIlegInfVer = listEliminarElementoIlegInfVer;
    }

    public List<ElementoIlegInfVerVO> getListEliminarElementoIlegInfVer(){
        return listEliminarElementoIlegInfVer;
    }

}
