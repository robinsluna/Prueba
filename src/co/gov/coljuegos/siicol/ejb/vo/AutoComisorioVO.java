package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioAutoComis;

import co.gov.coljuegos.siicol.ejb.wsvo.ActaVisitaWSVO;

import co.gov.coljuegos.siicol.ejb.wsvo.InventarioAutoComisWSVO;

import java.util.Date;
import java.util.List;

public class AutoComisorioVO {
    
    private Long aucCodigo;
    private Integer aucNumero;
    private Date aucFecha;
    private String aucTipoVisita;
    private EstablecimientoVO establecimientoVo;
    private ContratoVO contratoVo;
    private Date aucFechaVisita;
    private String aucEstado;
    private Date aucFechaAnulac;
    private String aucMotivoAnulac;
    private GrupoFiscalizacionVO grupoFiscalizacionVo;
    private List<ActaVisitaWSVO> listSiiActaVisitaVo;
    private  List<InventarioAutoComisWSVO> listInventarioAutoComisWSVo;
    
    //datos para grilla
    private String tipoVisita;
    private String municipio;
    private String departamento;
    private String establecimientoDireccion;
    
    
    public AutoComisorioVO(SiiAutoComisorio siiAutoComisorio) {
        this.aucCodigo = siiAutoComisorio.getAucCodigo();
        this.aucNumero = siiAutoComisorio.getAucNumero();
        this.aucFecha = siiAutoComisorio.getAucFecha();
        this.aucTipoVisita = siiAutoComisorio.getAucTipoVisita();
        this.aucFechaVisita = siiAutoComisorio.getAucFechaVisita();
        this.aucEstado = siiAutoComisorio.getAucEstado();
        this.aucMotivoAnulac = siiAutoComisorio.getAucMotivoAnulac();
        this.aucFechaAnulac = siiAutoComisorio.getAucFechaAnulac();
        this.aucMotivoAnulac = siiAutoComisorio.getAucMotivoAnulac();
        if(siiAutoComisorio.getSiiContrato()!= null)
              this.contratoVo = new ContratoVO(siiAutoComisorio.getSiiContrato() ) ;
        if(siiAutoComisorio.getSiiEstablecimiento() != null )
              this.establecimientoVo = new EstablecimientoVO(siiAutoComisorio.getSiiEstablecimiento());
        if(siiAutoComisorio.getSiiGrupoFiscalizacion() != null )
              this.grupoFiscalizacionVo = new GrupoFiscalizacionVO(siiAutoComisorio.getSiiGrupoFiscalizacion());
        
        
    }
    
    public AutoComisorioVO() {
        
    }

    public void setAucCodigo(Long aucCodigo) {
        this.aucCodigo = aucCodigo;
    }

    public Long getAucCodigo() {
        return aucCodigo;
    }

   

    public void setAucFecha(Date aucFecha) {
        this.aucFecha = aucFecha;
    }

    public Date getAucFecha() {
        return aucFecha;
    }

    public void setAucTipoVisita(String aucTipoVisita) {
        this.aucTipoVisita = aucTipoVisita;
    }

    public String getAucTipoVisita() {
        return aucTipoVisita;
    }

    public void setEstablecimientoVo(EstablecimientoVO establecimientoVo) {
        this.establecimientoVo = establecimientoVo;
    }

    public EstablecimientoVO getEstablecimientoVo() {
        return establecimientoVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setAucNumero(Integer aucNumero) {
        this.aucNumero = aucNumero;
    }

    public Integer getAucNumero() {
        return aucNumero;
    }

    public void setAucFechaVisita(Date aucFechaVisita) {
        this.aucFechaVisita = aucFechaVisita;
    }

    public Date getAucFechaVisita() {
        return aucFechaVisita;
    }


    public void setAucEstado(String aucEstado) {
        this.aucEstado = aucEstado;
    }

    public String getAucEstado() {
        return aucEstado;
    }

    public void setAucFechaAnulac(Date aucFechaAnulac) {
        this.aucFechaAnulac = aucFechaAnulac;
    }

    public Date getAucFechaAnulac() {
        return aucFechaAnulac;
    }

    public void setAucMotivoAnulac(String aucMotivoAnulac) {
        this.aucMotivoAnulac = aucMotivoAnulac;
    }

    public void setGrupoFiscalizacionVo(GrupoFiscalizacionVO grupoFiscalizacionVo) {
        this.grupoFiscalizacionVo = grupoFiscalizacionVo;
    }

    public GrupoFiscalizacionVO getGrupoFiscalizacionVo() {
        return grupoFiscalizacionVo;
    }

    public void setListSiiActaVisitaVo(List<ActaVisitaWSVO> listSiiActaVisitaVo) {
        this.listSiiActaVisitaVo = listSiiActaVisitaVo;
    }

    public List<ActaVisitaWSVO> getListSiiActaVisitaVo() {
        return listSiiActaVisitaVo;
    }

    public void setListInventarioAutoComisWSVo(List<InventarioAutoComisWSVO> listInventarioAutoComisWSVo) {
        this.listInventarioAutoComisWSVo = listInventarioAutoComisWSVo;
    }

    public List<InventarioAutoComisWSVO> getListInventarioAutoComisWSVo() {
        return listInventarioAutoComisWSVo;
    }


    public String getAucMotivoAnulac() {
        return aucMotivoAnulac;
    }

    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public String getTipoVisita() {
        return tipoVisita;
    }


    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setEstablecimientoDireccion(String establecimientoDireccion) {
        this.establecimientoDireccion = establecimientoDireccion;
    }

    public String getEstablecimientoDireccion() {
        return establecimientoDireccion;
    }

}
