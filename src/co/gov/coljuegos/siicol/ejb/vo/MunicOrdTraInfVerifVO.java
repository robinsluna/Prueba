package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicOrdTraInfVerif;

import java.util.List;

public class MunicOrdTraInfVerifVO {
    
    private Long mivCodigo;
    private String mivDireccion;
    private String mivTipoJuego;
    private MunicipioOrdenTrabVO municipioOrdenTrabVo;
    private InformeVerificCampoVO informeVerificCampoVo;
    private List<ElementoIlegInfVerVO> elementoIlegInfVerVo;
    private List<ElementoIlegInfVerVO> lisEliminarElementoIlegInfVerVo;
    private ResultadoVerifCampoVO resultadoVerifCampoVo;
    private String  rvcNombre; 
    private String mivActivo;
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
    
    public MunicOrdTraInfVerifVO(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif ) {
        this.mivCodigo = siiMunicOrdTraInfVerif.getMivCodigo();
        this.mivDireccion = siiMunicOrdTraInfVerif.getMivDireccion();
        this.mivTipoJuego = siiMunicOrdTraInfVerif.getMivTipoJuego();
        this.mivActivo = siiMunicOrdTraInfVerif.getMivActivo();
        if(siiMunicOrdTraInfVerif.getSiiMunicipioOrdenTrab()!= null ){
            this.municipioOrdenTrabVo = new MunicipioOrdenTrabVO (siiMunicOrdTraInfVerif.getSiiMunicipioOrdenTrab());
        }
        if(siiMunicOrdTraInfVerif.getSiiInformeVerificCampo() != null ){
            this.informeVerificCampoVo = new InformeVerificCampoVO (siiMunicOrdTraInfVerif.getSiiInformeVerificCampo());
        }

    }
    
    public MunicOrdTraInfVerifVO() {
    
    }

    public void setMivCodigo(Long mivCodigo) {
        this.mivCodigo = mivCodigo;
    }

    public Long getMivCodigo() {
        return mivCodigo;
    }

    public void setMivDireccion(String mivDireccion) {
        this.mivDireccion = mivDireccion;
    }

    public String getMivDireccion() {
        if( mivDireccion == null){
            mivDireccion =(cprincipal +" " +cprincipal2);
            if(cprincipal3 != null )
                mivDireccion =(mivDireccion +" "+cprincipal3);
            if(cprincipal4 != null )
                mivDireccion =(mivDireccion +" "+cprincipal4); 
            if(cprincipal5 != null )
                mivDireccion =(mivDireccion +" "+cprincipal5); 
            if(calterna != null )
                mivDireccion =(mivDireccion +" "+calterna); 
            if(calterna2 != null )
                mivDireccion =(mivDireccion +" "+calterna2);
            if(calterna3 != null )
                mivDireccion =(mivDireccion +" "+calterna3);
            if(calterna4 != null )
                mivDireccion =(mivDireccion +" "+calterna4);
            if(calterna5 != null )
                mivDireccion =(mivDireccion +" "+calterna5);
        }
        
        return mivDireccion;
    }

    public void setMivTipoJuego(String mivTipoJuego) {
        this.mivTipoJuego = mivTipoJuego;
    }

    public String getMivTipoJuego() {
        return mivTipoJuego;
    }

    public void setMunicipioOrdenTrabVo(MunicipioOrdenTrabVO municipioOrdenTrabVo) {
        this.municipioOrdenTrabVo = municipioOrdenTrabVo;
    }

    public MunicipioOrdenTrabVO getMunicipioOrdenTrabVo() {
        return municipioOrdenTrabVo;
    }

    public void setInformeVerificCampoVo(InformeVerificCampoVO informeVerificCampoVo) {
        this.informeVerificCampoVo = informeVerificCampoVo;
    }

    public InformeVerificCampoVO getInformeVerificCampoVo() {
        return informeVerificCampoVo;
    }

    public void setElementoIlegInfVerVo(List<ElementoIlegInfVerVO> elementoIlegInfVerVo) {
        this.elementoIlegInfVerVo = elementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getElementoIlegInfVerVo() {
        return elementoIlegInfVerVo;
    }


    public void setResultadoVerifCampoVo(ResultadoVerifCampoVO resultadoVerifCampoVo){
        this.resultadoVerifCampoVo = resultadoVerifCampoVo;
    }

    public ResultadoVerifCampoVO getResultadoVerifCampoVo(){
        return resultadoVerifCampoVo;
    }


    public void setRvcNombre(String rvcNombre){
        this.rvcNombre = rvcNombre;
    }

    public String getRvcNombre(){
        return rvcNombre;
    }

    public void setMivActivo(String mivActivo){
        this.mivActivo = mivActivo;
    }

    public String getMivActivo(){
        return mivActivo;
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

    public void setLisEliminarElementoIlegInfVerVo(List<ElementoIlegInfVerVO> lisEliminarElementoIlegInfVerVo){
        this.lisEliminarElementoIlegInfVerVo = lisEliminarElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getLisEliminarElementoIlegInfVerVo(){
        return lisEliminarElementoIlegInfVerVo;
    }

}
