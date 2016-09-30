/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Gestión contractual
 * AUTOR	: Walter Becerra
 * FECHA	: 05-02-2015
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;

import java.util.Date;
import java.util.List;

public class LiquidacionContratoVO {
   
    private Long lcoCodigo;
    private String lcoIndicadorCuenta;
    private Date lcoFechaCita;
    private EstadoLiquidacionContratoVO estadoLiquidacionContratoVo;
    private CausalTerminacionContratoVO causalTerContratoVo;
    private ContratoVO contratoVo;
    private Date lcoFechaGenInfFin;
    private String numeroGenInFinal;
    private Date lcoFechaBorrCit;
    private Date lcoFechaGenOfiCit;
    private String numeroRadGenOfiCita;
    private Date lcoFechaLiq;
    private Long duracionContrato;
    private ArchivoFisicoVO arcFisicoInfFinal;
    private ArchivoFisicoVO arcFisicoOfiCita;
    private ArchivoFisicoVO arcFisicoLiqFir;
    private List<ResolucionLiquidacionVO> listResolucionLiquidacionVo;
    
    private String estadoResolucionLiq;
    private String estadoRecursoRep;

    

    public LiquidacionContratoVO() {
      
    }
    
    public LiquidacionContratoVO(SiiLiquidacionContrato  siiLiquidacionContrato) {
        
        this.lcoCodigo = siiLiquidacionContrato.getLcoCodigo();
        this.lcoIndicadorCuenta = siiLiquidacionContrato.getLcoIndicaEstCta();
        this.lcoFechaCita = siiLiquidacionContrato.getLcoFechaCita();
        this.lcoFechaBorrCit = siiLiquidacionContrato.getLcoFechaBorrCit();
        this.lcoFechaGenInfFin = siiLiquidacionContrato.getLcoFechaGenInfFin();
        this.lcoFechaGenOfiCit = siiLiquidacionContrato.getLcoFechaGenOfiCit();
        this.numeroGenInFinal = siiLiquidacionContrato.getLcoRadicadoInfFin();
        this.numeroRadGenOfiCita = siiLiquidacionContrato.getLcoRadicadoOfiCit();
        this.lcoFechaLiq = siiLiquidacionContrato.getLcoFechaLiq();
        
        if(siiLiquidacionContrato.getSiiEstadoLiquidCont()!= null){
                this.estadoLiquidacionContratoVo = new EstadoLiquidacionContratoVO(siiLiquidacionContrato.getSiiEstadoLiquidCont());
        }
        if(siiLiquidacionContrato.getSiiCausalTermContr()!= null  ){
                this.causalTerContratoVo = new CausalTerminacionContratoVO (siiLiquidacionContrato.getSiiCausalTermContr());
        }
        if(siiLiquidacionContrato.getSiiContrato() != null ){
                this.contratoVo = new ContratoVO(siiLiquidacionContrato.getSiiContrato());
        }
        if (siiLiquidacionContrato.getSiiArchivoFisicoInfFinal()!= null){
            this.arcFisicoInfFinal = new ArchivoFisicoVO(siiLiquidacionContrato.getSiiArchivoFisicoInfFinal());
        }
        if (siiLiquidacionContrato.getSiiArchivoFisicoOficioCita()!= null){
            this.arcFisicoOfiCita = new ArchivoFisicoVO(siiLiquidacionContrato.getSiiArchivoFisicoOficioCita());
        }
        
        
        
    }

    public void setLcoCodigo(Long lcoCodigo) {
        this.lcoCodigo = lcoCodigo;
    }

    public Long getLcoCodigo() {
        return lcoCodigo;
    }


    public void setLcoIndicadorCuenta(String lcoIndicadorCuenta) {
        this.lcoIndicadorCuenta = lcoIndicadorCuenta;
    }

    public String getLcoIndicadorCuenta() {
        return lcoIndicadorCuenta;
    }


    public void setLcoFechaCita(Date lcoFechaCita) {
        this.lcoFechaCita = lcoFechaCita;
    }

    public Date getLcoFechaCita() {
        return lcoFechaCita;
    }

    public void setEstadoLiquidacionContratoVo(EstadoLiquidacionContratoVO estadoLiquidacionContratoVo) {
        this.estadoLiquidacionContratoVo = estadoLiquidacionContratoVo;
    }

    public EstadoLiquidacionContratoVO getEstadoLiquidacionContratoVo() {
        return estadoLiquidacionContratoVo;
    }


    public void setCausalTerContratoVo(CausalTerminacionContratoVO causalTerContratoVo) {
        this.causalTerContratoVo = causalTerContratoVo;
    }

    public CausalTerminacionContratoVO getCausalTerContratoVo() {
        return causalTerContratoVo;
    }


    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setLcoFechaLiq(Date lcoFechaLiq) {
        this.lcoFechaLiq = lcoFechaLiq;
    }

    public Date getLcoFechaLiq() {
        return lcoFechaLiq;
    }

    public void setLcoFechaGenInfFin(Date lcoFechaGenInfFin) {
        this.lcoFechaGenInfFin = lcoFechaGenInfFin;
    }

    public Date getLcoFechaGenInfFin() {
        return lcoFechaGenInfFin;
    }


    public void setLcoFechaBorrCit(Date lcoFechaBorrCit) {
        this.lcoFechaBorrCit = lcoFechaBorrCit;
    }

    public Date getLcoFechaBorrCit() {
        return lcoFechaBorrCit;
    }

    public void setLcoFechaGenOfiCit(Date lcoFechaGenOfiCit) {
        this.lcoFechaGenOfiCit = lcoFechaGenOfiCit;
    }

    public Date getLcoFechaGenOfiCit() {
        return lcoFechaGenOfiCit;
    }


    public void setDuracionContrato(Long duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    public Long getDuracionContrato() {
        return duracionContrato;
    }

    public void setArcFisicoInfFinal(ArchivoFisicoVO arcFisicoInfFinal) {
        this.arcFisicoInfFinal = arcFisicoInfFinal;
    }

    public ArchivoFisicoVO getArcFisicoInfFinal() {
        return arcFisicoInfFinal;
    }

    public void setArcFisicoOfiCita(ArchivoFisicoVO arcFisicoOfiCita) {
        this.arcFisicoOfiCita = arcFisicoOfiCita;
    }

    public ArchivoFisicoVO getArcFisicoOfiCita() {
        return arcFisicoOfiCita;
    }


    public void setListResolucionLiquidacionVo(List<ResolucionLiquidacionVO> listResolucionLiquidacionVo) {
        this.listResolucionLiquidacionVo = listResolucionLiquidacionVo;
    }

    public List<ResolucionLiquidacionVO> getListResolucionLiquidacionVo() {
        return listResolucionLiquidacionVo;
    }

    public void setArcFisicoLiqFir(ArchivoFisicoVO arcFisicoLiqFir) {
        this.arcFisicoLiqFir = arcFisicoLiqFir;
    }

    public ArchivoFisicoVO getArcFisicoLiqFir() {
        return arcFisicoLiqFir;
    }

    public void setNumeroGenInFinal(String numeroGenInFinal) {
        this.numeroGenInFinal = numeroGenInFinal;
    }

    public String getNumeroGenInFinal() {
        return numeroGenInFinal;
    }

    public void setNumeroRadGenOfiCita(String numeroRadGenOfiCita) {
        this.numeroRadGenOfiCita = numeroRadGenOfiCita;
    }

    public String getNumeroRadGenOfiCita() {
        return numeroRadGenOfiCita;
    }

    public void setEstadoResolucionLiq(String estadoResolucionLiq) {
        this.estadoResolucionLiq = estadoResolucionLiq;
    }

    public String getEstadoResolucionLiq() {
        return estadoResolucionLiq;
    }

    public void setEstadoRecursoRep(String estadoRecursoRep) {
        this.estadoRecursoRep = estadoRecursoRep;
    }

    public String getEstadoRecursoRep() {
        return estadoRecursoRep;
    }

}
