/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioProcSan;

/**
 * Value Object que gestiona el inventario del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class InventarioProcSanVO {

    private Long ipsCodigo;
    private String ipsActivo;
    
    /** Tipo de Apuesta Autorizado. */
    private TipoApuestaVO tipoApuestaVo;
    /** Tipo de Apuesta con el que realmente operan. */
    private TipoApuestaVO tipoApuestaEncontVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    private InventarioVO inventarioVo;

    /**
     * Constructor.
     */
    public InventarioProcSanVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiInventarioProcSan - Entity
     */
    public InventarioProcSanVO(SiiInventarioProcSan siiInventarioProcSan) {
        if (siiInventarioProcSan!=null) {
            this.ipsCodigo = siiInventarioProcSan.getIpsCodigo();
            this.ipsActivo = siiInventarioProcSan.getIpsActivo();
    
            if (siiInventarioProcSan.getSiiTipoApuesta() != null)
                this.tipoApuestaVo = new TipoApuestaVO(siiInventarioProcSan.getSiiTipoApuesta());
            
            if (siiInventarioProcSan.getSiiTipoApuestaEncont()!=null)
                this.tipoApuestaEncontVo = new TipoApuestaVO(siiInventarioProcSan.getSiiTipoApuestaEncont());
    
            if (siiInventarioProcSan.getSiiProcesoSancionatorio() != null)
                this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiInventarioProcSan.getSiiProcesoSancionatorio());
    
            if (siiInventarioProcSan.getSiiInventario() != null)
                this.inventarioVo = new InventarioVO(siiInventarioProcSan.getSiiInventario());
        }
    }

    public void setIpsCodigo(Long ipsCodigo) {
        this.ipsCodigo = ipsCodigo;
    }

    public Long getIpsCodigo() {
        return ipsCodigo;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setTipoApuestaEncontVo(TipoApuestaVO tipoApuestaEncontVo) {
        this.tipoApuestaEncontVo = tipoApuestaEncontVo;
    }

    public TipoApuestaVO getTipoApuestaEncontVo() {
        return tipoApuestaEncontVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }

    public void setInventarioVo(InventarioVO inventarioVo) {
        this.inventarioVo = inventarioVo;
    }

    public InventarioVO getInventarioVo() {
        return inventarioVo;
    }

    public void setIpsActivo(String ipsActivo) {
        this.ipsActivo = ipsActivo;
    }

    public String getIpsActivo() {
        return ipsActivo;
    }
}
