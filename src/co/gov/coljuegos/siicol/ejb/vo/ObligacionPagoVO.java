package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;


import java.util.List;

public class ObligacionPagoVO {
    private static final long serialVersionUID = -6522759016681309414L;
    private Long opaCodigo;
    private String opaNumeroDocSop;
    private Integer opaVigencia;
    private MesVO mesVo;
    private MesVO mes1Vo;
    private TipoDocSoporteVO tipoDocSoporteVo;
    private List<ObligDetRubroCdpVO> listaBorrarObligDetRubroCdpListVo;
    private List<ObligDetRubroCdpVO> listaGuardarObligDetRubroCdpListVo;
    private Long tdsCodigo;
    
    
    
    public ObligacionPagoVO( ){
        
    }
    
    public ObligacionPagoVO(SiiObligacionPago siiObligacionesPago){
        this.opaCodigo = siiObligacionesPago.getOpaCodigo();
        this.opaNumeroDocSop = siiObligacionesPago.getOpaNumeroDocSop();
        this.opaVigencia = siiObligacionesPago.getOpaVigencia();
        this.tdsCodigo = siiObligacionesPago.getTdsCodigo();
        //Padres:
        if(siiObligacionesPago.getSiiMes()!=null){
            this.mesVo=new MesVO(siiObligacionesPago.getSiiMes());
        }
        if(siiObligacionesPago.getSiiMes1()!=null){
            this.mes1Vo=new MesVO(siiObligacionesPago.getSiiMes1());
        }
       
        if(siiObligacionesPago.getSiiTipoDocSoporte()!=null){
            this.tipoDocSoporteVo=new TipoDocSoporteVO (siiObligacionesPago.getSiiTipoDocSoporte());
        }      
        
    }

    public void setOpaCodigo(Long opaCodigo) {
        this.opaCodigo = opaCodigo;
    }

    public Long getOpaCodigo() {
        return opaCodigo;
    }

    public void setOpaNumeroDocSop(String opaNumeroDocSop) {
        this.opaNumeroDocSop = opaNumeroDocSop;
    }

    public String getOpaNumeroDocSop() {
        return opaNumeroDocSop;
    }

    public void setOpaVigencia(Integer opaVigencia) {
        this.opaVigencia = opaVigencia;
    }

    public Integer getOpaVigencia() {
        return opaVigencia;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setMes1Vo(MesVO mes1Vo) {
        this.mes1Vo = mes1Vo;
    }

    public MesVO getMes1Vo() {
        return mes1Vo;
    }

    public void setTipoDocSoporteVo(TipoDocSoporteVO tipoDocSoporteVo) {
        this.tipoDocSoporteVo = tipoDocSoporteVo;
    }

    public TipoDocSoporteVO getTipoDocSoporteVo() {
        return tipoDocSoporteVo;
    }


    public void setListaBorrarObligDetRubroCdpListVo(List<ObligDetRubroCdpVO> listaBorrarObligDetRubroCdpListVo) {
        this.listaBorrarObligDetRubroCdpListVo = listaBorrarObligDetRubroCdpListVo;
    }

    public List<ObligDetRubroCdpVO> getListaBorrarObligDetRubroCdpListVo() {
        return listaBorrarObligDetRubroCdpListVo;
    }

    public void setListaGuardarObligDetRubroCdpListVo(List<ObligDetRubroCdpVO> listaGuardarObligDetRubroCdpListVo) {
        this.listaGuardarObligDetRubroCdpListVo = listaGuardarObligDetRubroCdpListVo;
    }

    public List<ObligDetRubroCdpVO> getListaGuardarObligDetRubroCdpListVo() {
        return listaGuardarObligDetRubroCdpListVo;
    }


    public void setTdsCodigo(Long tdsCodigo) {
        this.tdsCodigo = tdsCodigo;
    }

    public Long getTdsCodigo() {
        return tdsCodigo;
    }

  

    
}

