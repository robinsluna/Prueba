/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 03-12-2013
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;

import java.util.List;

public class MesVO {
    
    private Integer mesCodigo;
    private String mesNombre;
    private String mesNombreCorto;
    private List<DistribucionPfcVO> distribucionPfcVoList;
    
    public MesVO(SiiMes siiMes){
        if (siiMes!=null) {
            this.mesCodigo = siiMes.getMesCodigo();
            this.mesNombre = siiMes.getMesNombre();
            this.mesNombreCorto = siiMes.getMesNombreCorto();
        }
    }
    public MesVO() {
        

    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean esIgual = false;
        
        if (o!=null && o instanceof MesVO) {
            MesVO mVo = (MesVO) o;
            
            esIgual =   ((mVo.mesCodigo != null && mVo.mesCodigo.equals(this.mesCodigo)) || (mVo.mesCodigo == null && this.mesCodigo == null)) &&
                        ((mVo.mesNombre != null && mVo.mesNombre.equals(this.mesNombre)) || (mVo.mesNombre == null && this.mesNombre == null)) &&
                        ((mVo.mesNombreCorto != null && mVo.mesNombreCorto.equals(this.mesNombreCorto)) || (mVo.mesNombreCorto == null && this.mesNombreCorto == null));
        }
        
        return (esIgual);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hashcode = 0;
        
        if (mesCodigo!=null)
            hashcode = mesCodigo.hashCode();
        
        return (hashcode);
    }
    
    
    
    
    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }

    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    public String getMesNombre() {
        return mesNombre;
    }

    public void setMesNombreCorto(String mesNombreCorto) {
        this.mesNombreCorto = mesNombreCorto;
    }

    public String getMesNombreCorto() {
        return mesNombreCorto;
    }

    public void setDistribucionPfcVoList(List<DistribucionPfcVO> distribucionPfcVoList) {
        this.distribucionPfcVoList = distribucionPfcVoList;
    }

    public List<DistribucionPfcVO> getDistribucionPfcVoList() {
        return distribucionPfcVoList;
    }
}

