package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioDenuncia;

import java.util.List;

public class MedioDenunciaVO implements Comparable{
    
    private Long medCodigo;
    private String medNombre;    
    
    public MedioDenunciaVO() {
        
    }
    
    public MedioDenunciaVO(SiiMedioDenuncia siiMedioDenuncia) {
        
        if( siiMedioDenuncia != null ){
            this.medCodigo = siiMedioDenuncia.getMedCodigo();
            this.medNombre = siiMedioDenuncia.getMedNombre();
        }
    }
    

    public Long getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(Long medCodigo) {
        this.medCodigo = medCodigo;
    }

    public String getMedNombre() {
        return medNombre;
    }

    public void setMedNombre(String medNombre) {
        this.medNombre = medNombre;
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof MedioDenunciaVO) {
            MedioDenunciaVO ac = (MedioDenunciaVO) o;
            if (ac!=null && this.medNombre!=null && ac.medNombre!=null)
                resultado = this.medNombre.compareTo(ac.medNombre);
        }
        return resultado;
    }


}
