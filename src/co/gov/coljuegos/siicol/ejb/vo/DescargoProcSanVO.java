/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcSan;

import java.util.Date;

/**
 * Value object que gestiona el descargo del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class DescargoProcSanVO {

    private Long dpsCodigo;
    private Date dpsFechaRad;
    private String dpsPruebasSol;
    private String dpsRadicado;
    private String dpsSolicitaPru;

    private ProcesoSancionatorioVO procesoSancionatorioVo;

    /**
     * Constructor.
     */
    public DescargoProcSanVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiDescargoProcSan - Entity
     */
    public DescargoProcSanVO(SiiDescargoProcSan siiDescargoProcSan) {
        this.dpsCodigo = siiDescargoProcSan.getDpsCodigo();
        this.dpsFechaRad = siiDescargoProcSan.getDpsFechaRad();
        this.dpsPruebasSol = siiDescargoProcSan.getDpsPruebasSol();
        this.dpsRadicado = siiDescargoProcSan.getDpsRadicado();
        this.dpsSolicitaPru = siiDescargoProcSan.getDpsSolicitaPru();

        if (siiDescargoProcSan.getSiiProcesoSancionatorio() != null)
            this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiDescargoProcSan.getSiiProcesoSancionatorio());
    }

    public void setDpsCodigo(Long dpsCodigo) {
        this.dpsCodigo = dpsCodigo;
    }

    public Long getDpsCodigo() {
        return dpsCodigo;
    }

    public void setDpsFechaRad(Date dpsFechaRad) {
        this.dpsFechaRad = dpsFechaRad;
    }

    public Date getDpsFechaRad() {
        return dpsFechaRad;
    }

    public void setDpsPruebasSol(String dpsPruebasSol) {
        this.dpsPruebasSol = dpsPruebasSol;
    }

    public String getDpsPruebasSol() {
        return dpsPruebasSol;
    }

    public void setDpsRadicado(String dpsRadicado) {
        this.dpsRadicado = dpsRadicado;
    }

    public String getDpsRadicado() {
        return dpsRadicado;
    }

    public void setDpsSolicitaPru(String dpsSolicitaPru) {
        this.dpsSolicitaPru = dpsSolicitaPru;
    }

    public String getDpsSolicitaPru() {
        return dpsSolicitaPru;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }
    
    
    /**
     * Obtiene la representaci&oacute;n textual del flag <i>dpsSolicitaPru</i>.
     * @return Solicita Pruebas? (SI/NO)
     */
    public String getSolicitaPruebas () 
    {
        String solicitaPruebas = null;
        
        if (dpsSolicitaPru!=null)
            solicitaPruebas = EnumDecision.getNombreById(dpsSolicitaPru);
        
        return (solicitaPruebas);
    }
}
