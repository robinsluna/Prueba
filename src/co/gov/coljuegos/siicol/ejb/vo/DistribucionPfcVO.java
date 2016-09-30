/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;

public class DistribucionPfcVO {
    private Long dpfCodigo;
    private Long dpfValor;
    private DetalleRubroVO detalleRubroVo;
    private ProyeccionFlujoCajaVO proyeccionFlujoCajaVo;
    private MesVO mesVo;
    private Long dpfValorAprobado;
    private String vigencia;

    public DistribucionPfcVO(SiiDistribucionPfc siiDistribucionPfc){
        this.dpfCodigo = siiDistribucionPfc.getDpfCodigo();
        this.dpfValor = siiDistribucionPfc.getDpfValor();
        this.dpfValorAprobado = siiDistribucionPfc.getDpfValorAprobado();
        //Padres:
        this.detalleRubroVo = new DetalleRubroVO(siiDistribucionPfc.getSiiDetalleRubro());
        this.mesVo = new MesVO(siiDistribucionPfc.getSiiMes());
        this.proyeccionFlujoCajaVo = new ProyeccionFlujoCajaVO(siiDistribucionPfc.getSiiProyeccionFlujoCaja());  
    }


    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setDpfValorAprobado(Long dpfValorAprobado) {
        this.dpfValorAprobado = dpfValorAprobado;
    }

    public Long getDpfValorAprobado() {
        return dpfValorAprobado;
    }

    public DistribucionPfcVO(){
    
    }
    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }


   public void setDpfCodigo(Long dpfCodigo) {
        this.dpfCodigo = dpfCodigo;
    }

    public Long getDpfCodigo() {
        return dpfCodigo;
    }

    public Long getDpfValor() {
        return dpfValor;
    }

    public void setDpfValor(Long dpfValor) {
        this.dpfValor = dpfValor;
    }

    public void setDetalleRubroVo(DetalleRubroVO siiDetalleRubroVo) {
        this.detalleRubroVo = siiDetalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }

    public void setProyeccionFlujoCajaVo(ProyeccionFlujoCajaVO siiProyeccionFlujoCajaVo) {
        this.proyeccionFlujoCajaVo = siiProyeccionFlujoCajaVo;
    }

    public ProyeccionFlujoCajaVO getProyeccionFlujoCajaVo() {
        return proyeccionFlujoCajaVo;
    }    
}
