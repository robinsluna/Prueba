/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-10-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;

import java.util.Date;


/**
 * Value Object para la relaci&oacute;n entre Beneficiarios y Entes Territoriales.
 * @author Camilo Miranda
 */
public class BeneficiarioEnteVO 
{
    private Long benCodigo;
    private String benActivo;
    private Date benFecha;
    private Integer benVigencia;
    private Date benFechaIniAct;
    private Date benFechaFinAct;
    
    private PersonaVO personaVo;
    private EnteTerritorialVO enteTerritorialVo;
    private MesVO mesVo;
    private String idEstadoAnterior;
    
    
    
    /**
     * Constructor.
     */
    public BeneficiarioEnteVO() { }
    
    
    /**
     * Constructor.
     * @param siiBeneficiarioEnte - Entity.
     */
    public BeneficiarioEnteVO (SiiBeneficiarioEnte siiBeneficiarioEnte) {
        if (siiBeneficiarioEnte!=null) {
            this.benCodigo = siiBeneficiarioEnte.getBenCodigo();
            this.benActivo = siiBeneficiarioEnte.getBenActivo();
            this.benFecha = siiBeneficiarioEnte.getBenFecha();
            this.benVigencia = siiBeneficiarioEnte.getBenVigencia();
            this.benFechaIniAct = siiBeneficiarioEnte.getBenFechaIniAct();
            this.benFechaFinAct = siiBeneficiarioEnte.getBenFechaFinAct();
            
            
            if (siiBeneficiarioEnte.getSiiPersona()!=null) {
                this.personaVo = new PersonaVO(siiBeneficiarioEnte.getSiiPersona());
            }
            
            if (siiBeneficiarioEnte.getSiiEnteTerritorial()!=null) {
                this.enteTerritorialVo = new EnteTerritorialVO(siiBeneficiarioEnte.getSiiEnteTerritorial());
            }
            
            if (siiBeneficiarioEnte.getSiiMes()!=null) {
                this.mesVo = new MesVO(siiBeneficiarioEnte.getSiiMes());
            }
        }
    }
    
    
    
    public void setBenCodigo(Long benCodigo) {
        this.benCodigo = benCodigo;
    }

    public Long getBenCodigo() {
        return benCodigo;
    }
    
    public void setBenActivo(String benActivo) {
        this.benActivo = benActivo;
    }

    public String getBenActivo() {
        return benActivo;
    }

    public void setBenFecha(Date benFecha) {
        this.benFecha = benFecha;
    }

    public Date getBenFecha() {
        return benFecha;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setEnteTerritorialVo(EnteTerritorialVO enteTerritorialVo) {
        this.enteTerritorialVo = enteTerritorialVo;
    }

    public EnteTerritorialVO getEnteTerritorialVo() {
        return enteTerritorialVo;
    }

    public void setBenVigencia(Integer benVigencia) {
        this.benVigencia = benVigencia;
    }

    public Integer getBenVigencia() {
        return benVigencia;
    }

    public void setBenFechaIniAct(Date benFechaIniAct) {
        this.benFechaIniAct = benFechaIniAct;
    }

    public Date getBenFechaIniAct() {
        return benFechaIniAct;
    }

    public void setBenFechaFinAct(Date benFechaFinAct) {
        this.benFechaFinAct = benFechaFinAct;
    }

    public Date getBenFechaFinAct() {
        return benFechaFinAct;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setIdEstadoAnterior(String idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public String getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

}
