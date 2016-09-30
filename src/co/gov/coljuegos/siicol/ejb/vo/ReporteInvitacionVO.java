package co.gov.coljuegos.siicol.ejb.vo;

import java.util.List;

public class ReporteInvitacionVO {
    private ProveedorVO proveedorVo;
    private List<DuplaVO> listReqJuridicos;
    private List<DuplaVO> listReqTecnicos;
    private List<DuplaVO> listReqFinanciero;
    private List<DuplaVO> listReqPuntajes;
    
    public ReporteInvitacionVO() {        
    }

    public void setProveedorVo(ProveedorVO proveedorVo) {
        this.proveedorVo = proveedorVo;
    }

    public ProveedorVO getProveedorVo() {
        return proveedorVo;
    }

    public void setListReqJuridicos(List<DuplaVO> listReqJuridicos) {
        this.listReqJuridicos = listReqJuridicos;
    }

    public List<DuplaVO> getListReqJuridicos() {
        return listReqJuridicos;
    }

    public void setListReqTecnicos(List<DuplaVO> listReqTecnicos) {
        this.listReqTecnicos = listReqTecnicos;
    }

    public List<DuplaVO> getListReqTecnicos() {
        return listReqTecnicos;
    }

    public void setListReqFinanciero(List<DuplaVO> listReqFinanciero) {
        this.listReqFinanciero = listReqFinanciero;
    }

    public List<DuplaVO> getListReqFinanciero() {
        return listReqFinanciero;
    }

    public void setListReqPuntajes(List<DuplaVO> listReqPuntajes) {
        this.listReqPuntajes = listReqPuntajes;
    }

    public List<DuplaVO> getListReqPuntajes() {
        return listReqPuntajes;
    }
}
