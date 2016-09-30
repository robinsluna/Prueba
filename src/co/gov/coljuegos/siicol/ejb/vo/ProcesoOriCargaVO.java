package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoOriCarga;

import java.util.List;

public class ProcesoOriCargaVO implements Comparable{
   
    private Long pocCodigo;
    private String pocNombre;

   
    public ProcesoOriCargaVO(  ){
        
    }
   
    public ProcesoOriCargaVO(SiiProcesoOriCarga siiProcesoOriCarga ){
        this.pocCodigo = siiProcesoOriCarga.getPocCodigo();
        this.pocNombre = siiProcesoOriCarga.getPocNombre();
        
    }

    public void setPocCodigo(Long pocCodigo){
        this.pocCodigo = pocCodigo;
    }

    public Long getPocCodigo(){
        return pocCodigo;
    }

    public void setPocNombre(String pocNombre){
        this.pocNombre = pocNombre;
    }

    public String getPocNombre(){
        return pocNombre;
    }


    @Override
    public int compareTo(Object o){
        int result = -1;
        if (o instanceof ProcesoOriCargaVO) {
            if (pocNombre!=null) {
                ProcesoOriCargaVO pocVo = (ProcesoOriCargaVO) o;
                result = pocNombre.compareTo(pocVo.getPocNombre());
            }
        }
        return result;
    }
}
