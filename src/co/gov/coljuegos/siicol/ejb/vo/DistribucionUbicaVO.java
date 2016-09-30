/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionUbica;

import java.math.BigDecimal;

public class DistribucionUbicaVO {
   
   private Long dubCodigo;
   private BigDecimal dubValor;
   private EnteTerritorialVO  enteTerritorialVo;
   private DocumentoConpesVO documentoConpesVo;
   
   
    public DistribucionUbicaVO() {
       
    }
    public DistribucionUbicaVO(SiiDistribucionUbica siiDistribucionUbica) {
        this.setDubCodigo(siiDistribucionUbica.getDubCodigo());
        this.setDubValor(siiDistribucionUbica.getDubValor());
        
    //Padres
        if(siiDistribucionUbica.getSiiDocumentoConpes()!= null )
            this.documentoConpesVo= new DocumentoConpesVO(siiDistribucionUbica.getSiiDocumentoConpes());
        if(siiDistribucionUbica.getSiiEnteTerritorial()!= null)
            this.enteTerritorialVo= new EnteTerritorialVO(siiDistribucionUbica.getSiiEnteTerritorial());
       
    }


    public void setDubCodigo(Long dubCodigo) {
        this.dubCodigo = dubCodigo;
    }

    public Long getDubCodigo() {
        return dubCodigo;
    }

    public void setDubValor(BigDecimal dubValor) {
        this.dubValor = dubValor;
    }

    public BigDecimal getDubValor() {
        return dubValor;
    }


    public void setEnteTerritorialVo(EnteTerritorialVO enteTerritorialVo) {
        this.enteTerritorialVo = enteTerritorialVo;
    }

    public EnteTerritorialVO getEnteTerritorialVo() {
        return enteTerritorialVo;
    }

    public void setDocumentoConpesVo(DocumentoConpesVO documentoConpesVo) {
        this.documentoConpesVo = documentoConpesVo;
    }

    public DocumentoConpesVO getDocumentoConpesVo() {
        return documentoConpesVo;
    }

}
