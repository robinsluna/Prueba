package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionCargaAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

public class ConceptoProyeccionCarVO{
    
    private String cpcActivo;
    private Long cpcCodigo;
    private BigDecimal cpcSaldoInt;
    private BigDecimal cpcTotalInteres;
    private BigDecimal cpcTotalPagInt;
    private BigDecimal cpcTotalPagado;
    private BigDecimal cpcValorResoluc;
    private ProyeccionCargaActVO proyeccionCargaActVo;
    private UsuarioVO usuarioConectadoVo;
    private ConcepCuotCarActAdmVO concepCuotCarActAdmVo;
    private BigDecimal cpcSaldoCapital;
    private BigDecimal cpcTotalAjustes;
    
    
    public ConceptoProyeccionCarVO(){
       
    }

    public void setCpcActivo(String cpcActivo){
        this.cpcActivo = cpcActivo;
    }

    public String getCpcActivo(){
        return cpcActivo;
    }

    public void setCpcCodigo(Long cpcCodigo){
        this.cpcCodigo = cpcCodigo;
    }

    public Long getCpcCodigo(){
        return cpcCodigo;
    }

    public void setCpcSaldoInt(BigDecimal cpcSaldoInt){
        this.cpcSaldoInt = cpcSaldoInt;
    }

    public BigDecimal getCpcSaldoInt(){
        return cpcSaldoInt;
    }

    public void setCpcTotalInteres(BigDecimal cpcTotalInteres){
        this.cpcTotalInteres = cpcTotalInteres;
    }

    public BigDecimal getCpcTotalInteres(){
        return cpcTotalInteres;
    }

    public void setCpcTotalPagInt(BigDecimal cpcTotalPagInt){
        this.cpcTotalPagInt = cpcTotalPagInt;
    }

    public BigDecimal getCpcTotalPagInt(){
        return cpcTotalPagInt;
    }

    public void setCpcTotalPagado(BigDecimal cpcTotalPagado){
        this.cpcTotalPagado = cpcTotalPagado;
    }

    public BigDecimal getCpcTotalPagado(){
        return cpcTotalPagado;
    }

    public void setCpcValorResoluc(BigDecimal cpcValorResoluc){
        this.cpcValorResoluc = cpcValorResoluc;
    }

    public BigDecimal getCpcValorResoluc(){
        return cpcValorResoluc;
    }

    public void setProyeccionCargaActVo(ProyeccionCargaActVO proyeccionCargaActVo){
        this.proyeccionCargaActVo = proyeccionCargaActVo;
    }

    public ProyeccionCargaActVO getProyeccionCargaActVo(){
        return proyeccionCargaActVo;
    }

    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo){
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo(){
        return usuarioConectadoVo;
    }

    public void setConcepCuotCarActAdmVo(ConcepCuotCarActAdmVO concepCuotCarActAdmVo){
        this.concepCuotCarActAdmVo = concepCuotCarActAdmVo;
    }

    public ConcepCuotCarActAdmVO getConcepCuotCarActAdmVo(){
        return concepCuotCarActAdmVo;
    }

    public void setCpcSaldoCapital(BigDecimal cpcSaldoCapital){
        this.cpcSaldoCapital = cpcSaldoCapital;
    }

    public BigDecimal getCpcSaldoCapital(){
        return cpcSaldoCapital;
    }

    public void setCpcTotalAjustes(BigDecimal cpcTotalAjustes){
        this.cpcTotalAjustes = cpcTotalAjustes;
    }

    public BigDecimal getCpcTotalAjustes(){
        return cpcTotalAjustes;
    }

}
