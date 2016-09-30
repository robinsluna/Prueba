package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiJuegoMesa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class JuegoMesaVO {
    
    private Long jmeCodigo;
    private String jmeNombre;
    private List<SiiMesaCasino> mesaCasinoList;
    
    
    public JuegoMesaVO() {
    }
    
    public JuegoMesaVO(SiiJuegoMesa juegoMesa) {
        this.jmeCodigo = juegoMesa.getJmeCodigo();
        this.jmeNombre = juegoMesa.getJmeNombre();                              
    }


    public void setJmeCodigo(Long jmeCodigo) {
        this.jmeCodigo = jmeCodigo;
    }

    public Long getJmeCodigo() {
        return jmeCodigo;
    }

    public void setJmeNombre(String jmeNombre) {
        this.jmeNombre = jmeNombre;
    }

    public String getJmeNombre() {
        return jmeNombre;
    }

    public void setMesaCasinoList(List<SiiMesaCasino> mesaCasinoList) {
        this.mesaCasinoList = mesaCasinoList;
    }

    public List<SiiMesaCasino> getMesaCasinoList() {
        return mesaCasinoList;
    }


}
