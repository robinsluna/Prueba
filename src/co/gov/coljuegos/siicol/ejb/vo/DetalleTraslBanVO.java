/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Proceso PAC y Tesorería
 * AUTOR	: Walter Becerra
 * FECHA	: 25-05-2015
 */

package co.gov.coljuegos.siicol.ejb.vo;

public class DetalleTraslBanVO {
    
    private Long dtbCodigo;
    private SolicitudPromocionalesVO solicitudPromocionalesVo;
    private TrasladoCuentasBancariasVO trasladoCuentasBancariasVo;
    private String dtbConcepto;
    
    public DetalleTraslBanVO() {
       
    }


    public void setDtbCodigo(Long dtbCodigo) {
        this.dtbCodigo = dtbCodigo;
    }

    public Long getDtbCodigo() {
        return dtbCodigo;
    }

    public void setSolicitudPromocionalesVo(SolicitudPromocionalesVO solicitudPromocionalesVo) {
        this.solicitudPromocionalesVo = solicitudPromocionalesVo;
    }

    public SolicitudPromocionalesVO getSolicitudPromocionalesVo() {
        return solicitudPromocionalesVo;
    }

    public void setTrasladoCuentasBancariasVo(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo) {
        this.trasladoCuentasBancariasVo = trasladoCuentasBancariasVo;
    }

    public TrasladoCuentasBancariasVO getTrasladoCuentasBancariasVo() {
        return trasladoCuentasBancariasVo;
    }

    public void setDtbConcepto(String dtbConcepto) {
        this.dtbConcepto = dtbConcepto;
    }

    public String getDtbConcepto() {
        return dtbConcepto;
    }

}
