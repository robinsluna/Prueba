package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;

import java.util.List;

public class LiquidacionVO {
    
    private List<SiiLiquidacionMes> listaLiq;
    private List<SiiResumenNoConectado> listaNoConectados;
    private List<SiiLiquidacionEstabl>listaLiqEstabDE;
    private List<SiiLiquidacionEstabl>listaLiqEstabGA;
    
    public LiquidacionVO() {
        
    }

    public void setListaLiq(List<SiiLiquidacionMes> listaLiq) {
        this.listaLiq = listaLiq;
    }

    public List<SiiLiquidacionMes> getListaLiq() {
        return listaLiq;
    }

    public void setListaNoConectados(List<SiiResumenNoConectado> listaNoConectados) {
        this.listaNoConectados = listaNoConectados;
    }

    public List<SiiResumenNoConectado> getListaNoConectados() {
        return listaNoConectados;
    }


    public void setListaLiqEstabDE(List<SiiLiquidacionEstabl> listaLiqEstabDE) {
        this.listaLiqEstabDE = listaLiqEstabDE;
    }

    public List<SiiLiquidacionEstabl> getListaLiqEstabDE() {
        return listaLiqEstabDE;
    }

    public void setListaLiqEstabGA(List<SiiLiquidacionEstabl> listaLiqEstabGA) {
        this.listaLiqEstabGA = listaLiqEstabGA;
    }

    public List<SiiLiquidacionEstabl> getListaLiqEstabGA() {
        return listaLiqEstabGA;
    }

}
