package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class PolizaContratVO implements Comparable {

    private Long pccCodigo;
    private Date pccFechaExped;
    private Date pccFechaRecep;
    private String pccNumero;
    private String pccObservaciones;
    private AseguradoraVO aseguradoraVO;
    private List<PolizaRequisitosPolVO> polizaRequisitosPolVO;
    private EstadoPolizaContVO estadoPolizaContVO;
    private ArchivoFisicoVO archivoFisicoVO;
    private List<GarantiaPolizaVO> garantiaPolizaListVO;
    private List<OficInfPolizaVO> oficInfPolizaListVO;
    private ContratoVO contratoVO;
    private Long idEstadoAnterior;
    private OtroSiVO otroSiVO;
    private String pccContratoNue;
    private String pccRenovacion;
    private Date pccFechaAprobac;
    private Date pccFechaIniOpera;
    private String pccRadicado;
    private Date pccFechaRadicado;
    //variables para imputación contable
    private BigDecimal valorDe;
    private BigDecimal valorGa;
    private List<TipoApuestPolizaRenovacVO> tipoApuestPolizaRenovacListVo;
    private BigDecimal pccTiempoEjecCon;
    
    /*
     * Campos adicionales a la entidad
     */
    private Date fechaAprobacion;

    public PolizaContratVO() {

    }

    public PolizaContratVO(SiiPolizaContrat polizaContrat) {
        this.pccCodigo = polizaContrat.getPccCodigo();
        this.pccFechaExped = polizaContrat.getPccFechaExped();
        this.pccFechaRecep = polizaContrat.getPccFechaRecep();
        this.pccNumero = polizaContrat.getPccNumero();
        this.pccObservaciones = polizaContrat.getPccObservaciones();
        this.pccContratoNue = polizaContrat.getPccContratoNue();
        this.pccRenovacion = polizaContrat.getPccRenovacion();
        this.pccFechaAprobac = polizaContrat.getPccFechaAprobac();
        this.pccFechaIniOpera = polizaContrat.getPccFechaIniOpera();
        this.pccRadicado = polizaContrat.getPccRadicado();
        this.pccFechaRadicado = polizaContrat.getPccFechaRadicado();
        this.pccTiempoEjecCon = polizaContrat.getPccTiempoEjecCon();
        
        //Padres:
        if (polizaContrat.getSiiArchivoFisico() != null) {
            this.archivoFisicoVO = new ArchivoFisicoVO(polizaContrat.getSiiArchivoFisico());
        }
        if (polizaContrat.getSiiAseguradora() != null) {
            this.aseguradoraVO = new AseguradoraVO(polizaContrat.getSiiAseguradora());
        }
        if (polizaContrat.getSiiContrato() != null) {
            this.contratoVO = new ContratoVO(polizaContrat.getSiiContrato());
        }
        if (polizaContrat.getSiiEstadoPolizaCont() != null) {
            this.estadoPolizaContVO = new EstadoPolizaContVO(polizaContrat.getSiiEstadoPolizaCont());
            this.idEstadoAnterior = polizaContrat.getSiiEstadoPolizaCont().getEpoCodigo();

        }
        //Otrosi
        if (polizaContrat.getSiiOtrosi() != null) {
            this.otroSiVO = new OtroSiVO(polizaContrat.getSiiOtrosi());
        }

    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -2;
        if (o instanceof PolizaContratVO) {
            PolizaContratVO p = (PolizaContratVO) o;
            // comparar por medio del codigo de la poliza de contrato
            if (this.pccCodigo!=null)
                resultado = this.pccCodigo.compareTo(p.pccCodigo);
        }
        
        return ( resultado );
    }
    
    
    
    public void setPccCodigo(Long pccCodigo) {
        this.pccCodigo = pccCodigo;
    }

    public Long getPccCodigo() {
        return pccCodigo;
    }

    public void setPccFechaExped(Date pccFechaExped) {
        this.pccFechaExped = pccFechaExped;
    }

    public Date getPccFechaExped() {
        return pccFechaExped;
    }

    public void setPccFechaRecep(Date pccFechaRecep) {
        this.pccFechaRecep = pccFechaRecep;
    }

    public Date getPccFechaRecep() {
        return pccFechaRecep;
    }

    public void setPccNumero(String pccNumero) {
        this.pccNumero = pccNumero;
    }

    public String getPccNumero() {
        return pccNumero;
    }

    public void setPccObservaciones(String pccObservaciones) {
        this.pccObservaciones = pccObservaciones;
    }

    public String getPccObservaciones() {
        return pccObservaciones;
    }

    public void setAseguradoraVO(AseguradoraVO aseguradoraVO) {
        this.aseguradoraVO = aseguradoraVO;
    }

    public AseguradoraVO getAseguradoraVO() {
        return aseguradoraVO;
    }

    public void setPolizaRequisitosPolVO(List<PolizaRequisitosPolVO> polizaRequisitosPolVO) {
        this.polizaRequisitosPolVO = polizaRequisitosPolVO;
    }

    public List<PolizaRequisitosPolVO> getPolizaRequisitosPolVO() {
        return polizaRequisitosPolVO;
    }

    public void setEstadoPolizaContVO(EstadoPolizaContVO estadoPolizaContVO) {
        this.estadoPolizaContVO = estadoPolizaContVO;
    }

    public EstadoPolizaContVO getEstadoPolizaContVO() {
        return estadoPolizaContVO;
    }

    public void setArchivoFisicoVO(ArchivoFisicoVO archivoFisicoVO) {
        this.archivoFisicoVO = archivoFisicoVO;
    }

    public ArchivoFisicoVO getArchivoFisicoVO() {
        return archivoFisicoVO;
    }

    public void setGarantiaPolizaListVO(List<GarantiaPolizaVO> garantiaPolizaListVO) {
        this.garantiaPolizaListVO = garantiaPolizaListVO;
    }

    public List<GarantiaPolizaVO> getGarantiaPolizaListVO() {
        return garantiaPolizaListVO;
    }

    public void setOficInfPolizaListVO(List<OficInfPolizaVO> oficInfPolizaListVO) {
        this.oficInfPolizaListVO = oficInfPolizaListVO;
    }

    public List<OficInfPolizaVO> getOficInfPolizaListVO() {
        return oficInfPolizaListVO;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public OtroSiVO getOtroSiVO() {
        return otroSiVO;
    }

    public void setOtroSiVO(OtroSiVO otroSiVO) {
        this.otroSiVO = otroSiVO;
    }

    public String getPccRenovacion() {
        return pccRenovacion;
    }

    public void setPccRenovacion(String pccRenovacion) {
        this.pccRenovacion = pccRenovacion;
    }

    public String getPccContratoNue() {
        return pccContratoNue;
    }

    public void setPccContratoNue(String pccContratoNue) {
        this.pccContratoNue = pccContratoNue;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Date getPccFechaAprobac() {
        return pccFechaAprobac;
    }

    public void setPccFechaAprobac(Date pccFechaAprobac) {
        this.pccFechaAprobac = pccFechaAprobac;
    }

    public Date getPccFechaIniOpera() {
        return pccFechaIniOpera;
    }

    public void setPccFechaIniOpera(Date pccFechaIniOpera) {
        this.pccFechaIniOpera = pccFechaIniOpera;
    }

    public void setPccRadicado(String pccRadicado) {
        this.pccRadicado = pccRadicado;
    }

    public String getPccRadicado() {
        return pccRadicado;
    }

    public void setPccFechaRadicado(Date pccFechaRadicado) {
        this.pccFechaRadicado = pccFechaRadicado;
    }

    public Date getPccFechaRadicado() {
        return pccFechaRadicado;
    }

    public void setValorDe(BigDecimal valorDe) {
        this.valorDe = valorDe;
    }

    public BigDecimal getValorDe() {
        return valorDe;
    }

    public void setValorGa(BigDecimal valorGa) {
        this.valorGa = valorGa;
    }

    public BigDecimal getValorGa() {
        return valorGa;
    }

    public void setTipoApuestPolizaRenovacListVo(List<TipoApuestPolizaRenovacVO> tipoApuestPolizaRenovacListVo) {
        this.tipoApuestPolizaRenovacListVo = tipoApuestPolizaRenovacListVo;
    }

    public List<TipoApuestPolizaRenovacVO> getTipoApuestPolizaRenovacListVo() {
        return tipoApuestPolizaRenovacListVo;
    }

    public void setPccTiempoEjecCon(BigDecimal pccTiempoEjecCon) {
        this.pccTiempoEjecCon = pccTiempoEjecCon;
    }

    public BigDecimal getPccTiempoEjecCon() {
        return pccTiempoEjecCon;
    }
}
