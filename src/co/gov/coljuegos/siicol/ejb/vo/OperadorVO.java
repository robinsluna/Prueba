/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;

import java.util.Date;
import java.util.List;


public class OperadorVO 
{   
    private Long opeCodigo;   
    private String opePotencial;
    private String opeTipoPoblac;
    private String opeEstado;
    private Date opeFechaFinInhab;
    private Date opeFechaIniInhab;
    
    private PersonaVO personaVo;
    
    private List<ContratoVO> contratoVoList;
    private List<InstrumentoVO> instrumentoVoList;    
    private List<EstablecimientoVO> establecimientoVoList;
    private List<CuotaOperadorVO> cuotaOperadorVoList;
    private List<DireccionProcesalIncVO> direccionProcesalIncVoList;
    private List<ResolucionDesisSolAutVO> resolucionDesisSolAutVoList;
    
    
    /**
     * Constructor.
     */
    public OperadorVO() { }
    
    
    /**
     * Constructor.
     * @param operador
     */
    public OperadorVO(SiiOperador operador) 
    {
       this.opeCodigo = operador.getOpeCodigo();
       this.opePotencial = operador.getOpePotencial();
       this.opeTipoPoblac = operador.getOpeTipoPoblac();
       this.opeEstado = operador.getOpeEstado();
       this.opeFechaFinInhab = operador.getOpeFechaFinInhab();
       this.opeFechaIniInhab = operador.getOpeFechaIniInhab();
      
       if(operador.getSiiPersona() != null){
           this.personaVo = new PersonaVO(operador.getSiiPersona());
       }          
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof OperadorVO) {
            OperadorVO opVo = (OperadorVO) o;
            if (opVo!=null) {
                igual = ((opVo.opeCodigo != null && opVo.opeCodigo.equals(this.opeCodigo)) || (opVo.opeCodigo == null && this.opeCodigo == null)) && 
                        ((opVo.opePotencial != null && opVo.opePotencial.equals(this.opePotencial)) || (opVo.opePotencial == null && this.opePotencial == null)) &&
                        ((opVo.opeTipoPoblac != null && opVo.opeTipoPoblac.equals(this.opeTipoPoblac)) || (opVo.opeTipoPoblac == null && this.opeTipoPoblac == null)) && 
                        ((opVo.opeEstado != null && opVo.opeEstado.equals(this.opeEstado)) || (opVo.opeEstado == null && this.opeEstado == null)) && 
                        ((opVo.opeFechaFinInhab != null && opVo.opeFechaFinInhab.equals(this.opeFechaFinInhab)) || (opVo.opeFechaFinInhab == null && this.opeFechaFinInhab == null)) && 
                        ((opVo.opeFechaIniInhab != null && opVo.opeFechaIniInhab.equals(this.opeFechaIniInhab)) || (opVo.opeFechaIniInhab == null && this.opeFechaIniInhab == null)) && 
                        ((opVo.personaVo != null && opVo.personaVo.equals(this.personaVo)) || (opVo.personaVo == null && this.personaVo == null));
            }
        }
        
        return (igual);
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hashcode = 0;
        if (this.personaVo!=null) {
            hashcode = this.personaVo.hashCode();
        }
        
        return (hashcode);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () 
    {
        String resultado = "";
        if (opeCodigo!=null) resultado += opeCodigo+" ";
        if (personaVo!=null) resultado += personaVo.toString();
        
        return (resultado.trim());
    }
    
    
    
    
    /**
     * Obtiene el Nombre del Estado del Operador, a partir del id <i>opeEstado</i>.
     * @return opeEstado=>nombre
     */
    public String getEstado () 
    {
        String estado = null;
        if (opeEstado!=null)
            estado = EnumEstadoOperador.getNombreById(opeEstado);
        
        return (estado);
    }
    
    

    public void setOpeCodigo(Long opeCodigo) {
        this.opeCodigo = opeCodigo;
    }

    public Long getOpeCodigo() {
        return opeCodigo;
    }

    

    public void setContratoVoList(List<ContratoVO> contratoVoList) {
        this.contratoVoList = contratoVoList;
    }

    public List<ContratoVO> getContratoVoList() {
        return contratoVoList;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setInstrumentoVoList(List<InstrumentoVO> instrumentoVoList) {
        this.instrumentoVoList = instrumentoVoList;
    }

    public List<InstrumentoVO> getInstrumentoVoList() {
        return instrumentoVoList;
    }

  

    public void setEstablecimientoVoList(List<EstablecimientoVO> establecimientoVoList) {
        this.establecimientoVoList = establecimientoVoList;
    }

    public List<EstablecimientoVO> getEstablecimientoVoList() {
        return establecimientoVoList;
    }

    public void setOpePotencial(String opePotencial) {
        this.opePotencial = opePotencial;
    }

    public String getOpePotencial() {
        return opePotencial;
    }

    public void setOpeTipoPoblac(String opeTipoPoblac) {
        this.opeTipoPoblac = opeTipoPoblac;
    }

    public String getOpeTipoPoblac() {
        return opeTipoPoblac;
    }

    public void setOpeEstado(String opeEstado) {
        this.opeEstado = opeEstado;
    }

    public String getOpeEstado() {
        return opeEstado;
    }

    public void setOpeFechaFinInhab(Date opeFechaFinInhab) {
        this.opeFechaFinInhab = opeFechaFinInhab;
    }

    public Date getOpeFechaFinInhab() {
        return opeFechaFinInhab;
    }

    public void setOpeFechaIniInhab(Date opeFechaIniInhab) {
        this.opeFechaIniInhab = opeFechaIniInhab;
    }

    public Date getOpeFechaIniInhab() {
        return opeFechaIniInhab;
    }

    public void setCuotaOperadorVoList(List<CuotaOperadorVO> cuotaOperadorVoList) {
        this.cuotaOperadorVoList = cuotaOperadorVoList;
    }

    public List<CuotaOperadorVO> getCuotaOperadorVoList() {
        return cuotaOperadorVoList;
    }

    public void setDireccionProcesalIncVoList(List<DireccionProcesalIncVO> direccionProcesalIncVoList) {
        this.direccionProcesalIncVoList = direccionProcesalIncVoList;
    }

    public List<DireccionProcesalIncVO> getDireccionProcesalIncVoList() {
        return direccionProcesalIncVoList;
    }

    public void setResolucionDesisSolAutVoList(List<ResolucionDesisSolAutVO> resolucionDesisSolAutVoList) {
        this.resolucionDesisSolAutVoList = resolucionDesisSolAutVoList;
    }

    public List<ResolucionDesisSolAutVO> getResolucionDesisSolAutVoList() {
        return resolucionDesisSolAutVoList;
    }


}
