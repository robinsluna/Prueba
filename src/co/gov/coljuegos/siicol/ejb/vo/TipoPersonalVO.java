package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;

import java.util.List;

public class TipoPersonalVO {
    
    private Long tpeCodigo;
    private String tpeNombre;
    private List<PersonalEmpresaVO> personalEmpresaVoList;
    
    
    public TipoPersonalVO(SiiTipoPersonal siiTipoPersonal) {
        this.tpeCodigo = siiTipoPersonal.getTpeCodigo();
        this.tpeNombre = siiTipoPersonal.getTpeNombre();
    }
    
    public TipoPersonalVO() {
    }


    public void setTpeCodigo(Long tpeCodigo) {
        this.tpeCodigo = tpeCodigo;
    }

    public Long getTpeCodigo() {
        return tpeCodigo;
    }

    public void setTpeNombre(String tpeNombre) {
        this.tpeNombre = tpeNombre;
    }

    public String getTpeNombre() {
        return tpeNombre;
    }

    public void setPersonalEmpresaVoList(List<PersonalEmpresaVO> personalEmpresaVoList) {
        this.personalEmpresaVoList = personalEmpresaVoList;
    }

    public List<PersonalEmpresaVO> getPersonalEmpresaVoList() {
        return personalEmpresaVoList;
    }
}
