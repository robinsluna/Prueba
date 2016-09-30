package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrProv;


public class EstadoContrProvVO {
    private Long ecpCodigo;
    private String ecpNombre;


    public EstadoContrProvVO() {
    }
    public EstadoContrProvVO(SiiEstadoContrProv siiEstadoContrProv){
        this.ecpCodigo = siiEstadoContrProv.getEcpCodigo();
        this.ecpNombre = siiEstadoContrProv.getEcpNombre();
    }

    public void setEcpCodigo(Long ecpCodigo) {
        this.ecpCodigo = ecpCodigo;
    }

    public Long getEcpCodigo() {
        return ecpCodigo;
    }

    public void setEcpNombre(String ecpNombre) {
        this.ecpNombre = ecpNombre;
    }

    public String getEcpNombre() {
        return ecpNombre;
    }
}

