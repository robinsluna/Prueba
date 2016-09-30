package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ItemPlanContratacVO {

    private Long ipcCodigo;
    private String ipcDescripcion;
    private Date ipcFechaFinCon;
    private Date ipcFechaIniCon;
    private Date ipcFechaIniProc;
    private String ipcModContrat;
    private String ipcNombre;
    private String ipcTipologia;
    private Long ipcValorEst;
    private AreaColjuegosVO areaColjuegosVo;
    private List<SolicitudEstMercadoVO> solicitudEstMercadoVoList;
    private List<CdpVO> cdpVoList;
    private List<ItemPlanContDetRubVO> itemPlanContDetRubVoList;
    private List<EstudioPrevioVO> estudioPrevioVoList;
    private PlanContratacionVO planContratacionVo;
    private BigDecimal ipcValorNacion;
    private BigDecimal ipcValorPropios;
    private BigDecimal ipcValorVigFut;

    private BigDecimal ipcValorCaducos;
    private BigDecimal ipcValorTransfSalud;
    private BigDecimal ipcValorVigFutRecursosPropios;
    private String niveles;
    private Long valorContracredito;
    private Long valorCredito;


    public ItemPlanContratacVO(SiiItemPlanContratac itemPlanContratac) {
        this.ipcCodigo = itemPlanContratac.getIpcCodigo();
        this.ipcDescripcion = itemPlanContratac.getIpcDescripcion();
        this.ipcFechaIniCon = itemPlanContratac.getIpcFechaIniCon();
        this.ipcFechaIniProc = itemPlanContratac.getIpcFechaIniProc();
        this.ipcValorEst = itemPlanContratac.getIpcValorEst();
        if (itemPlanContratac.getSiiAreaColjuegos() != null) {
            this.areaColjuegosVo = new AreaColjuegosVO(itemPlanContratac.getSiiAreaColjuegos());
        }
        if (itemPlanContratac.getSiiPlanContratacion() != null) {
            this.planContratacionVo = new PlanContratacionVO(itemPlanContratac.getSiiPlanContratacion());
        }
        this.ipcModContrat = itemPlanContratac.getIpcModContrat();
        this.ipcNombre = itemPlanContratac.getIpcNombre();
        this.ipcTipologia = itemPlanContratac.getIpcTipologia();
        this.ipcFechaFinCon = itemPlanContratac.getIpcFechaFinCon();
        this.ipcValorNacion = itemPlanContratac.getIpcValorNacion();
        this.ipcValorPropios = itemPlanContratac.getIpcValorPropios();
        this.ipcValorVigFut = itemPlanContratac.getIpcValorVigFut();
    }

    public ItemPlanContratacVO() {
    }

    public void setNiveles(String niveles) {
        this.niveles = niveles;
    }

    public String getNiveles() {
        return niveles;
    }

    public void setIpcCodigo(Long ipcCodigo) {
        this.ipcCodigo = ipcCodigo;
    }

    public Long getIpcCodigo() {
        return ipcCodigo;
    }

    public void setIpcDescripcion(String ipcDescripcion) {
        this.ipcDescripcion = ipcDescripcion;
    }

    public String getIpcDescripcion() {
        return ipcDescripcion;
    }

    public void setIpcFechaIniCon(Date ipcFechaIniCon) {
        this.ipcFechaIniCon = ipcFechaIniCon;
    }

    public Date getIpcFechaIniCon() {
        return ipcFechaIniCon;
    }

    public void setIpcFechaIniProc(Date ipcFechaIniProc) {
        this.ipcFechaIniProc = ipcFechaIniProc;
    }

    public Date getIpcFechaIniProc() {
        return ipcFechaIniProc;
    }

    public void setIpcValorEst(Long ipcValorEst) {
        this.ipcValorEst = ipcValorEst;
    }

    public Long getIpcValorEst() {
        return ipcValorEst;
    }


    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }

    public void setSolicitudEstMercadoVoList(List<SolicitudEstMercadoVO> solicitudEstMercadoVoList) {
        this.solicitudEstMercadoVoList = solicitudEstMercadoVoList;
    }

    public List<SolicitudEstMercadoVO> getSolicitudEstMercadoVoList() {
        return solicitudEstMercadoVoList;
    }


    public void setCdpVoList(List<CdpVO> cdpVoList) {
        this.cdpVoList = cdpVoList;
    }

    public List<CdpVO> getCdpVoList() {
        return cdpVoList;
    }

    public void setItemPlanContDetRubVoList(List<ItemPlanContDetRubVO> itemPlanContDetRubVoList) {
        this.itemPlanContDetRubVoList = itemPlanContDetRubVoList;
    }

    public List<ItemPlanContDetRubVO> getItemPlanContDetRubVoList() {
        return itemPlanContDetRubVoList;
    }

    public void setEstudioPrevioVoList(List<EstudioPrevioVO> estudioPrevioVoList) {
        this.estudioPrevioVoList = estudioPrevioVoList;
    }

    public List<EstudioPrevioVO> getEstudioPrevioVoList() {
        return estudioPrevioVoList;
    }

    public void setPlanContratacionVo(PlanContratacionVO planContratacionVo) {
        this.planContratacionVo = planContratacionVo;
    }

    public PlanContratacionVO getPlanContratacionVo() {
        return planContratacionVo;
    }


    public void setIpcModContrat(String ipcModContrat) {
        this.ipcModContrat = ipcModContrat;
    }

    public String getIpcModContrat() {
        return ipcModContrat;
    }

    public void setIpcNombre(String ipcNombre) {
        this.ipcNombre = ipcNombre;
    }

    public String getIpcNombre() {
        return ipcNombre;
    }

    public void setIpcTipologia(String ipcTipologia) {
        this.ipcTipologia = ipcTipologia;
    }

    public String getIpcTipologia() {
        return ipcTipologia;
    }


    public void setIpcFechaFinCon(Date ipcFechaFinCon) {
        this.ipcFechaFinCon = ipcFechaFinCon;
    }

    public Date getIpcFechaFinCon() {
        return ipcFechaFinCon;
    }

    public void setIpcValorNacion(BigDecimal ipcValorNacion) {
        this.ipcValorNacion = ipcValorNacion;
    }

    public BigDecimal getIpcValorNacion() {
        return ipcValorNacion;
    }

    public void setIpcValorPropios(BigDecimal ipcValorPropios) {
        this.ipcValorPropios = ipcValorPropios;
    }

    public BigDecimal getIpcValorPropios() {
        return ipcValorPropios;
    }

    public void setIpcValorVigFut(BigDecimal ipcValorVigFut) {
        this.ipcValorVigFut = ipcValorVigFut;
    }

    public BigDecimal getIpcValorVigFut() {
        return ipcValorVigFut;
    }

    public void setIpcValorCaducos(BigDecimal ipcValorCaducos) {
        this.ipcValorCaducos = ipcValorCaducos;
    }

    public BigDecimal getIpcValorCaducos() {
        return ipcValorCaducos;
    }

    public void setIpcValorTransfSalud(BigDecimal ipcValorTransfSalud) {
        this.ipcValorTransfSalud = ipcValorTransfSalud;
    }

    public BigDecimal getIpcValorTransfSalud() {
        return ipcValorTransfSalud;
    }

    public void setIpcValorVigFutRecursosPropios(BigDecimal ipcValorVigFutRecursosPropios) {
        this.ipcValorVigFutRecursosPropios = ipcValorVigFutRecursosPropios;
    }

    public BigDecimal getIpcValorVigFutRecursosPropios() {
        return ipcValorVigFutRecursosPropios;
    }


    public Long getValorContracredito() {
        valorContracredito = 0L;
        if (this.getItemPlanContDetRubVoList() != null) {
            for (ItemPlanContDetRubVO item : this.getItemPlanContDetRubVoList()) {
                if (item.getValorContracredito() == null)
                    item.setValorContracredito(0L);
                valorContracredito = valorContracredito + item.getValorContracredito();
            }
        }

        return valorContracredito;
    }

    public Long getValorCredito() {
        valorCredito = 0L;
        if (this.getItemPlanContDetRubVoList() != null) {
            for (ItemPlanContDetRubVO item : this.getItemPlanContDetRubVoList()) {
                if (item.getValorCredito() == null)
                    item.setValorCredito(0L);
                valorCredito = valorCredito + item.getValorCredito();
            }
        }

        return valorCredito;
    }
}
