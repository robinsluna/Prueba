/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEmpresaDestruye;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Value object que gestiona la empresa que destruye.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class EmpresaDestruyeVO {
    
    private String emdActivo;
    private Long emdCodigo;
    private Date emdFechaActiv;
    private Date emdFechaInac;
    private Integer emdVigencia;
    
    private PersonaVO personaVo;
    private UsuarioVO usuarioConectVo;
    
    private List<ActaDestruccionVO> actaDestruccionVoList;
    
    /**
     * Constructor.
     */
    public EmpresaDestruyeVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiEmpresaDestruye
     */
    
    public EmpresaDestruyeVO(SiiEmpresaDestruye siiEmpresaDestruye) {
        if (siiEmpresaDestruye != null) {
            this.emdActivo = siiEmpresaDestruye.getEmdActivo();
            this.emdCodigo = siiEmpresaDestruye.getEmdCodigo();
            this.emdFechaActiv = siiEmpresaDestruye.getEmdFechaActiv();
            this.emdFechaInac = siiEmpresaDestruye.getEmdFechaInac();
            this.emdVigencia = siiEmpresaDestruye.getEmdVigencia();

            if (siiEmpresaDestruye.getSiiPersona() != null) {
                this.personaVo = new PersonaVO(siiEmpresaDestruye.getSiiPersona());
            }

            if (siiEmpresaDestruye.getSiiUsuarioConect() != null) {
                this.usuarioConectVo = new UsuarioVO(siiEmpresaDestruye.getSiiUsuarioConect());
            }
        }
    }
    
    /**
     * Agregar un nuevo registro de acta de destrucción.
     * @param actaDestruccionVO
     * @return exitoso - boolean
     */
    
    public boolean addActaDestruccionVo (ActaDestruccionVO actaDestruccionVO) 
    {
        boolean exitoso = false;
        
        if (this.actaDestruccionVoList==null)
            actaDestruccionVoList = new ArrayList<ActaDestruccionVO>();
        
        exitoso = actaDestruccionVoList.add(actaDestruccionVO);
        
        if (exitoso)
            actaDestruccionVO.setEmpresaDestruyeVo(this);
        
        return (exitoso);
    }
    
    /**
     * Remover un registro de acta de destrucción
     * @param actaDestruccionVo
     * @return exitoso - boolean
     */
    
    public boolean removeActaDestruccionVo (ActaDestruccionVO actaDestruccionVo) {
        boolean exitoso = false;
        
        if (this.actaDestruccionVoList!=null) {
            exitoso = actaDestruccionVoList.remove(actaDestruccionVo);
            
            if (exitoso)
                actaDestruccionVo.setEmpresaDestruyeVo(null);
        }
        
        return (exitoso);
    }

    public void setEmdActivo(String emdActivo) {
        this.emdActivo = emdActivo;
    }

    public String getEmdActivo() {
        return emdActivo;
    }

    public void setEmdCodigo(Long emdCodigo) {
        this.emdCodigo = emdCodigo;
    }

    public Long getEmdCodigo() {
        return emdCodigo;
    }

    public void setEmdFechaActiv(Date emdFechaActiv) {
        this.emdFechaActiv = emdFechaActiv;
    }

    public Date getEmdFechaActiv() {
        return emdFechaActiv;
    }

    public void setEmdFechaInac(Date emdFechaInac) {
        this.emdFechaInac = emdFechaInac;
    }

    public Date getEmdFechaInac() {
        return emdFechaInac;
    }

    public void setEmdVigencia(Integer emdVigencia) {
        this.emdVigencia = emdVigencia;
    }

    public Integer getEmdVigencia() {
        return emdVigencia;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setActaDestruccionVoList(List<ActaDestruccionVO> actaDestruccionVoList) {
        this.actaDestruccionVoList = actaDestruccionVoList;
    }

    public List<ActaDestruccionVO> getActaDestruccionVoList() {
        return actaDestruccionVoList;
    }
}
