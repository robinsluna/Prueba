package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;

import java.util.List;


public class BarrioOrdenInfVerVO {
   
   private Long  bivCodigo;
   private String bivDireccion;
   private String bivTipoJuego;
   private BarrioOrdenVO barrioOrdenVo;
   private InformeVerificCampoVO informeVerificCampo;
   private List<ElementoIlegInfVerVO> listElementoIlegInfVerVo;
   private List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVerVo;
   private String bivActivo;

   //utilizado en grilla
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
   
    public BarrioOrdenInfVerVO(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
     this.bivCodigo = siiBarrioOrdenInfVer.getBivCodigo();
     this.bivDireccion = siiBarrioOrdenInfVer.getBivDireccion();
     this.bivTipoJuego = siiBarrioOrdenInfVer.getBivTipoJuego();
     this.bivActivo = siiBarrioOrdenInfVer.getBivActivo();
     if( siiBarrioOrdenInfVer.getSiiBarrioOrden() != null ){
        this.barrioOrdenVo = new BarrioOrdenVO(siiBarrioOrdenInfVer.getSiiBarrioOrden());
     }
     if( siiBarrioOrdenInfVer.getSiiInformeVerificCampo() != null ){
        this.informeVerificCampo = new InformeVerificCampoVO(siiBarrioOrdenInfVer.getSiiInformeVerificCampo());
     }
    
    }
    
    public BarrioOrdenInfVerVO( ) {
    
    }
    
   
    public void setBivCodigo(Long bivCodigo) {
        this.bivCodigo = bivCodigo;
    }

    public Long getBivCodigo() {
        return bivCodigo;
    }

    public void setBivDireccion(String bivDireccion) {
        this.bivDireccion = bivDireccion;
    }

    public String getBivDireccion() {
        if( bivDireccion == null){
            bivDireccion =(cprincipal +" " +cprincipal2);
            if(cprincipal3 != null )
                bivDireccion =(bivDireccion +" "+cprincipal3);
            if(cprincipal4 != null )
                bivDireccion =(bivDireccion +" "+cprincipal4); 
            if(cprincipal5 != null )
                bivDireccion =(bivDireccion +" "+cprincipal5); 
            if(calterna != null )
                bivDireccion =(bivDireccion +" "+calterna); 
            if(calterna2 != null )
                bivDireccion =(bivDireccion +" "+calterna2);
            if(calterna3 != null )
                bivDireccion =(bivDireccion +" "+calterna3);
            if(calterna4 != null )
                bivDireccion =(bivDireccion +" "+calterna4);
            if(calterna5 != null )
                bivDireccion =(bivDireccion +" "+calterna5);
        }
        
        return bivDireccion;
    }

    public void setBivTipoJuego(String bivTipoJuego) {
        this.bivTipoJuego = bivTipoJuego;
    }

    public String getBivTipoJuego() {
        return bivTipoJuego;
    }

    public void setBarrioOrdenVo(BarrioOrdenVO barrioOrdenVo) {
        this.barrioOrdenVo = barrioOrdenVo;
    }

    public BarrioOrdenVO getBarrioOrdenVo() {
        return barrioOrdenVo;
    }

    public void setInformeVerificCampo(InformeVerificCampoVO informeVerificCampo) {
        this.informeVerificCampo = informeVerificCampo;
    }

    public InformeVerificCampoVO getInformeVerificCampo() {
        return informeVerificCampo;
    }


    public void setListElementoIlegInfVerVo(List<ElementoIlegInfVerVO> listElementoIlegInfVerVo){
        this.listElementoIlegInfVerVo = listElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getListElementoIlegInfVerVo(){
        return listElementoIlegInfVerVo;
    }


    public void setResultadoVerificacion(String resultadoVerificacion){
        this.resultadoVerificacion = resultadoVerificacion;
    }

    public String getResultadoVerificacion(){
        return resultadoVerificacion;
    }


    public void setBivActivo(String bivActivo){
        this.bivActivo = bivActivo;
    }

    public String getBivActivo(){
        return bivActivo;
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

    public void setListEliminarElementoIlegInfVerVo(List<ElementoIlegInfVerVO> listEliminarElementoIlegInfVerVo){
        this.listEliminarElementoIlegInfVerVo = listEliminarElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getListEliminarElementoIlegInfVerVo(){
        return listEliminarElementoIlegInfVerVo;
    }
}
