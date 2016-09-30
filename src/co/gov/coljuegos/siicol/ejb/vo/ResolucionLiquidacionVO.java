package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;

import java.util.Date;

public class ResolucionLiquidacionVO {
   
   private Long rliCodigo;
   private String rlinumero;
   private Date rlifecha;
   private Date rliFechaFirma;
   private String rliTipoRes;
   private String rliResultadoRec;
   private ArchivoFisicoVO archivoFisicoVo;
   private LiquidacionContratoVO liquidacionContratoVo;
   private EstadoResolucionLiqVO estadoResolucionLiqVo;
   private Date fechaNotificacion;

   
    public ResolucionLiquidacionVO(SiiResolucionLiquid siiResolucionLiquid) {
        this.rliCodigo=siiResolucionLiquid.getRliCodigo();
        this.rlinumero=siiResolucionLiquid.getRliNumero();
        this.rliFechaFirma= siiResolucionLiquid.getRliFechaFirme();
        this.rliTipoRes= siiResolucionLiquid.getRliTipoRes();
        this.rlifecha=siiResolucionLiquid.getRliFecha();
        this.rliResultadoRec= siiResolucionLiquid.getRliResultadoRec();
        this.fechaNotificacion = siiResolucionLiquid.getRliFechaNotifica();
        
        if(siiResolucionLiquid.getSiiArchivoFisico()!= null)
             this.archivoFisicoVo= new ArchivoFisicoVO(siiResolucionLiquid.getSiiArchivoFisico() );
        if(siiResolucionLiquid.getSiiEstadoResolucLiq()!= null )
             this.estadoResolucionLiqVo= new EstadoResolucionLiqVO (siiResolucionLiquid.getSiiEstadoResolucLiq());
        if(siiResolucionLiquid.getSiiLiquidacionContrato()!= null )
              this.liquidacionContratoVo= new LiquidacionContratoVO (siiResolucionLiquid.getSiiLiquidacionContrato()) ;        
        
    }
    
    public ResolucionLiquidacionVO() {
        
    }


    public void setRliCodigo(Long rliCodigo) {
        this.rliCodigo = rliCodigo;
    }

    public Long getRliCodigo() {
        return rliCodigo;
    }

    public void setRlinumero(String rlinumero) {
        this.rlinumero = rlinumero;
    }

    public String getRlinumero() {
        return rlinumero;
    }

    public void setRlifecha(Date rlifecha) {
        this.rlifecha = rlifecha;
    }

    public Date getRlifecha() {
        return rlifecha;
    }

    public void setRliFechaFirma(Date rliFechaFirma) {
        this.rliFechaFirma = rliFechaFirma;
    }

    public Date getRliFechaFirma() {
        return rliFechaFirma;
    }

    public void setRliTipoRes(String rliTipoRes) {
        this.rliTipoRes = rliTipoRes;
    }

    public String getRliTipoRes() {
        return rliTipoRes;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setLiquidacionContratoVo(LiquidacionContratoVO liquidacionContratoVo) {
        this.liquidacionContratoVo = liquidacionContratoVo;
    }

    public LiquidacionContratoVO getLiquidacionContratoVo() {
        return liquidacionContratoVo;
    }

    public void setEstadoResolucionLiqVo(EstadoResolucionLiqVO estadoResolucionLiqVo) {
        this.estadoResolucionLiqVo = estadoResolucionLiqVo;
    }

    public EstadoResolucionLiqVO getEstadoResolucionLiqVo() {
        return estadoResolucionLiqVo;
    }

    public void setRliResultadoRec(String rliResultadoRec) {
        this.rliResultadoRec = rliResultadoRec;
    }

    public String getRliResultadoRec() {
        return rliResultadoRec;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }


}
