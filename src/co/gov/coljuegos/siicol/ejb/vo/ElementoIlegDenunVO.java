/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-09-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegDenun;

/**
 * Value Object que gestiona los elementos ilegales de las denuncias
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class ElementoIlegDenunVO {

    private String eidActivo;
    private Long eidCodigo;
    private Integer eidNumero;
    private TipoElemenIlegalidadVO tipoElemenIlegalidadVo;
    private DenunciaVO denunciaVo;

    /**
     * Constructor.
     */
    public ElementoIlegDenunVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiElementoIlegDenun
     */
    public ElementoIlegDenunVO(SiiElementoIlegDenun siiElementoIlegDenun) {
        this.eidActivo = siiElementoIlegDenun.getEidActivo();
        this.eidCodigo = siiElementoIlegDenun.getEidCodigo();
        this.eidNumero = siiElementoIlegDenun.getEidNumero();

        if (siiElementoIlegDenun.getSiiTipoElemenIlegalidad() != null)
            this.tipoElemenIlegalidadVo = new TipoElemenIlegalidadVO(siiElementoIlegDenun.getSiiTipoElemenIlegalidad());
        
        if (siiElementoIlegDenun.getSiiDenuncia() != null)
            this.denunciaVo = new DenunciaVO(siiElementoIlegDenun.getSiiDenuncia());
    }


    public void setEidActivo(String eidActivo) {
        this.eidActivo = eidActivo;
    }

    public String getEidActivo() {
        return eidActivo;
    }

    public void setEidCodigo(Long eidCodigo) {
        this.eidCodigo = eidCodigo;
    }

    public Long getEidCodigo() {
        return eidCodigo;
    }

    public void setEidNumero(Integer eidNumero) {
        this.eidNumero = eidNumero;
    }

    public Integer getEidNumero() {
        return eidNumero;
    }

    public void setTipoElemenIlegalidadVo(TipoElemenIlegalidadVO tipoElemenIlegalidadVo) {
        this.tipoElemenIlegalidadVo = tipoElemenIlegalidadVo;
    }

    public TipoElemenIlegalidadVO getTipoElemenIlegalidadVo() {
        return tipoElemenIlegalidadVo;
    }

    public void setDenunciaVo(DenunciaVO denunciaVo) {
        this.denunciaVo = denunciaVo;
    }

    public DenunciaVO getDenunciaVo() {
        return denunciaVo;
    }
}
