/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoNoDestruccion;

import java.util.ArrayList;
import java.util.List;

/**
 * Value object que gestiona el motivo de no destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class MotivoNoDestruccionVO {

    private Long mndCodigo;
    private String mndNombre;

    private List<ActaDestruccionVO> actaDestruccionVoList;

    /**
     * Construcción
     */

    public MotivoNoDestruccionVO() {
        super();
    }

    /**
     * Construcción.
     * @param siiMotivoNoDestruccion
     */

    public MotivoNoDestruccionVO(SiiMotivoNoDestruccion siiMotivoNoDestruccion) {
        this.mndCodigo = siiMotivoNoDestruccion.getMndCodigo();
        this.mndNombre = siiMotivoNoDestruccion.getMndNombre();
    }

    /**
     * Agregar un nuevo registro de acta de destrucción.
     * @param actaDestruccionVO
     * @return exitoso - boolean
     */

    public boolean addActaDestruccionVO(ActaDestruccionVO actaDestruccionVO) {
        boolean exitoso = false;

        if (this.actaDestruccionVoList == null)
            actaDestruccionVoList = new ArrayList<ActaDestruccionVO>();

        exitoso = actaDestruccionVoList.add(actaDestruccionVO);

        if (exitoso)
            actaDestruccionVO.setMotivoNoDestruccionVo(this);

        return (exitoso);
    }

    /**
     * Remover un registro de acta de destrucción.
     * @param actaDestruccionVo
     * @return exitoso - boolean
     */

    public boolean removeActaDestruccionVO(ActaDestruccionVO actaDestruccionVo) {
        boolean exitoso = false;

        if (this.actaDestruccionVoList != null) {
            exitoso = actaDestruccionVoList.remove(actaDestruccionVo);

            if (exitoso)
                actaDestruccionVo.setMotivoNoDestruccionVo(null);
        }

        return (exitoso);
    }

    public void setMndCodigo(Long mndCodigo) {
        this.mndCodigo = mndCodigo;
    }

    public Long getMndCodigo() {
        return mndCodigo;
    }

    public void setMndNombre(String mndNombre) {
        this.mndNombre = mndNombre;
    }

    public String getMndNombre() {
        return mndNombre;
    }

    public void setActaDestruccionVoList(List<ActaDestruccionVO> actaDestruccionVoList) {
        this.actaDestruccionVoList = actaDestruccionVoList;
    }

    public List<ActaDestruccionVO> getActaDestruccionVoList() {
        return actaDestruccionVoList;
    }
}
