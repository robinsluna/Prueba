
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;

public class ElementoIlegInfVerVO {
   
    private Long eivCodigo;
    private Integer eivNumElementos;
    private CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo;
    private DenuncOrdTraInfVerVO denuncOrdTraInfVerVo;
    private BarrioOrdenInfVerVO barrioOrdenInfVerVo;
    private MunicOrdTraInfVerifVO municOrdTraInfVerif;
    private TipoElemenIlegalidadVO tipoElemenIlegalidad;
    private String eivActivo;
    //Utilizado en grilla
    private String tipoElemento;
    
    
    public ElementoIlegInfVerVO(SiiElementoIlegInfVer siiElementoIlegInfVer) {
    
       this.eivCodigo = siiElementoIlegInfVer.getEivCodigo();
       this.eivNumElementos = siiElementoIlegInfVer.getEivNumElementos();
       if(siiElementoIlegInfVer.getSiiTipoElemenIlegalidad() != null ){
           this.tipoElemenIlegalidad = new TipoElemenIlegalidadVO(siiElementoIlegInfVer.getSiiTipoElemenIlegalidad());
       }
       
       if(siiElementoIlegInfVer.getSiiBarrioOrdenInfVer() != null ){
           this.barrioOrdenInfVerVo = new BarrioOrdenInfVerVO(siiElementoIlegInfVer.getSiiBarrioOrdenInfVer() );
       }
       
       if(siiElementoIlegInfVer.getSiiCuadranteOrdTraInfVer() != null  ){
           this.cuadranteOrdTraInfVerVo = new CuadranteOrdTraInfVerVO (siiElementoIlegInfVer.getSiiCuadranteOrdTraInfVer());
       }
       
       if(siiElementoIlegInfVer.getSiiDenuncOrdTraInfVer() != null ){
           this.denuncOrdTraInfVerVo = new DenuncOrdTraInfVerVO (siiElementoIlegInfVer.getSiiDenuncOrdTraInfVer());
       }
       
       if(siiElementoIlegInfVer.getSiiMunicOrdTraInfVerif() != null ){
           this.municOrdTraInfVerif = new MunicOrdTraInfVerifVO (siiElementoIlegInfVer.getSiiMunicOrdTraInfVerif()); 
       }
       
       if(siiElementoIlegInfVer.getSiiTipoElemenIlegalidad() != null  ){
           this.tipoElemenIlegalidad = new TipoElemenIlegalidadVO (siiElementoIlegInfVer.getSiiTipoElemenIlegalidad());
           this.tipoElemento = tipoElemenIlegalidad.getTeiNombre();
       }
       
       
    }
    
   
    public ElementoIlegInfVerVO() {
       
    }


    public void setEivCodigo(Long eivCodigo) {
        this.eivCodigo = eivCodigo;
    }

    public Long getEivCodigo() {
        return eivCodigo;
    }

    public void setEivNumElementos(Integer eivNumElementos) {
        this.eivNumElementos = eivNumElementos;
    }

    public Integer getEivNumElementos() {
        return eivNumElementos;
    }

    public void setCuadranteOrdTraInfVerVo(CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo){
        this.cuadranteOrdTraInfVerVo = cuadranteOrdTraInfVerVo;
    }

    public CuadranteOrdTraInfVerVO getCuadranteOrdTraInfVerVo(){
        return cuadranteOrdTraInfVerVo;
    }

    public void setDenuncOrdTraInfVerVo(DenuncOrdTraInfVerVO denuncOrdTraInfVerVo) {
        this.denuncOrdTraInfVerVo = denuncOrdTraInfVerVo;
    }

    public DenuncOrdTraInfVerVO getDenuncOrdTraInfVerVo() {
        return denuncOrdTraInfVerVo;
    }

    public void setBarrioOrdenInfVerVo(BarrioOrdenInfVerVO barrioOrdenInfVerVo) {
        this.barrioOrdenInfVerVo = barrioOrdenInfVerVo;
    }

    public BarrioOrdenInfVerVO getBarrioOrdenInfVerVo() {
        return barrioOrdenInfVerVo;
    }

    public void setMunicOrdTraInfVerif(MunicOrdTraInfVerifVO municOrdTraInfVerif) {
        this.municOrdTraInfVerif = municOrdTraInfVerif;
    }

    public MunicOrdTraInfVerifVO getMunicOrdTraInfVerif() {
        return municOrdTraInfVerif;
    }

    public void setTipoElemenIlegalidad(TipoElemenIlegalidadVO tipoElemenIlegalidad) {
        this.tipoElemenIlegalidad = tipoElemenIlegalidad;
    }

    public TipoElemenIlegalidadVO getTipoElemenIlegalidad() {
        return tipoElemenIlegalidad;
    }

    public void setTipoElemento(String tipoElemento){
        this.tipoElemento = tipoElemento;
    }

    public String getTipoElemento(){
        return tipoElemento;
    }

    public void setEivActivo(String eivActivo){
        this.eivActivo = eivActivo;
    }

    public String getEivActivo(){
        return eivActivo;
    }
    
}


