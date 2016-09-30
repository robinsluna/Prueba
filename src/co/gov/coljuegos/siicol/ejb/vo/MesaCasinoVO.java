package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiJuegoMesa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class MesaCasinoVO {   
    private Long mcaCodigo;
    private JuegoMesaVO juegoMesa;
    private List<InstrumentoVO> instrumentoList;   
   
    
    public MesaCasinoVO() {
    }
    
    public MesaCasinoVO(SiiMesaCasino mesaCasino) {
        this.mcaCodigo = mesaCasino.getMcaCodigo();
        if(mesaCasino.getSiiJuegoMesa()!= null){
            this.juegoMesa= new JuegoMesaVO(mesaCasino.getSiiJuegoMesa());
        }
                      
    }


    public void setMcaCodigo(Long mcaCodigo) {
        this.mcaCodigo = mcaCodigo;
    }

    public Long getMcaCodigo() {
        return mcaCodigo;
    }

    public void setJuegoMesa(JuegoMesaVO juegoMesa) {
        this.juegoMesa = juegoMesa;
    }

    public JuegoMesaVO getJuegoMesa() {
        return juegoMesa;
    }

    public void setInstrumentoList(List<InstrumentoVO> instrumentoList) {
        this.instrumentoList = instrumentoList;
    }

    public List<InstrumentoVO> getInstrumentoList() {
        return instrumentoList;
    }


}
