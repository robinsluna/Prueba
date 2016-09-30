/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 10-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoBanco;

import java.util.Date;
import java.util.List;


public class PagoOperadoresVO {
   
   private Long opeCodigo;
   private ArchivoFisicoVO archivoFisicoVo;
   private Date opeFechaRecaudo;
   private BancoVO  bancoVo;
   private String opeNumeroCuenta;
   private Date opeFechaArchivo;
   private String opeOrdenDia;
   private TipoCuentaVO  tipoCuentaVo;
   private List<DetalleRecaudoVO>  detalleRecaudoVoList;
   
    
    public PagoOperadoresVO(  ) {
        
    }
    public PagoOperadoresVO(SiiRecaudoBanco  siiRecaudoBanco  ) {
         this.setOpeCodigo(siiRecaudoBanco.getRbaCodigo());
         this.setOpeFechaArchivo(siiRecaudoBanco.getRbaFechaArchivo());
         this.setOpeFechaRecaudo(siiRecaudoBanco.getRbaFechaRec());
         this.setOpeNumeroCuenta(siiRecaudoBanco.getRbaNumCuenta());
         this.setOpeOrdenDia(siiRecaudoBanco.getRbaOrdenDia());
        
        //padres  
         if(siiRecaudoBanco.getSiiArchivoFisico()!= null)
           this.archivoFisicoVo = new ArchivoFisicoVO(siiRecaudoBanco.getSiiArchivoFisico());
         if(siiRecaudoBanco.getSiiBanco() != null)
           this.bancoVo = new BancoVO(siiRecaudoBanco.getSiiBanco());
         if(siiRecaudoBanco.getSiiTipoCuenta()!=null)
           this.tipoCuentaVo= new TipoCuentaVO(siiRecaudoBanco.getSiiTipoCuenta());

    }


    public void setOpeCodigo(Long opeCodigo) {
        this.opeCodigo = opeCodigo;
    }

    public Long getOpeCodigo() {
        return opeCodigo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setBancoVo(BancoVO bancoVo) {
        this.bancoVo = bancoVo;
    }

    public BancoVO getBancoVo() {
        return bancoVo;
    }

    public void setTipoCuentaVo(TipoCuentaVO tipoCuentaVo) {
        this.tipoCuentaVo = tipoCuentaVo;
    }

    public TipoCuentaVO getTipoCuentaVo() {
        return tipoCuentaVo;
    }

    public void setDetalleRecaudoVoList(List<DetalleRecaudoVO> detalleRecaudoVoList) {
        this.detalleRecaudoVoList = detalleRecaudoVoList;
    }

    public List<DetalleRecaudoVO> getDetalleRecaudoVoList() {
        return detalleRecaudoVoList;
    }


    public void setOpeFechaRecaudo(Date opeFechaRecaudo) {
        this.opeFechaRecaudo = opeFechaRecaudo;
    }

    public Date getOpeFechaRecaudo() {
        return opeFechaRecaudo;
    }

    public void setOpeNumeroCuenta(String opeNumeroCuenta) {
        this.opeNumeroCuenta = opeNumeroCuenta;
    }

    public String getOpeNumeroCuenta() {
        return opeNumeroCuenta;
    }

    public void setOpeFechaArchivo(Date opeFechaArchivo) {
        this.opeFechaArchivo = opeFechaArchivo;
    }

    public Date getOpeFechaArchivo() {
        return opeFechaArchivo;
    }

   

    public void setOpeOrdenDia(String opeOrdenDia) {
        this.opeOrdenDia = opeOrdenDia;
    }

    public String getOpeOrdenDia() {
        return opeOrdenDia;
    }

   


}
