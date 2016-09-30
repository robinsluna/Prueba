package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

public class RadicadoOrfeoWSVO implements Serializable {
    
    
    //C�digo del aplicativo interfaz 
    public Integer cod_app ;
    // La referencia  
    public String referencia;
    //Login del usuario preestablecido para realizar la radicaci�n a trav�s del webservice
    public String usrRadicador;
    //C�digo de tipo de usuario que genera el radicado. 
    public Integer tipoTercero ;
    //Nombre del ciudadano, entidad, empresa o funcionario seg�n corresponda. 
    public String nombreTercero;
    //Primer apellido del ciudadano, o funcionario seg�n corresponda.
    public String primerApellidoTercero;
    // Segundo apellido del ciudadano, entidad, empresa o funcionario seg�n corresponda. 
    public String segundoApellidoTercero;
    // C�digo de tipo de identificaci�n. 
    public Long tipoIDTercero;
    //Tercero Referencia seg�n el tipo de identificaci�n (TipoIDTercero).
    public String numeroIDTercero;
    //Correo Electr�nico a trav�s del cual se responder�a al radicado.
    public String correoElectronicoTercero;
    //Direcci�n correspondencia del ciudadano/empresa
    public String direccionTercero;
    // CodCont-CodPais-CodDpto-CodMcpio
    public String internacionalizacion;
    // Telefono
    public String telefono;
    //MedioRecep
    public Integer medioRecep;
    //Asunto o descripci�n del radicado a crear
    public String asuntoRadicado;
    //Direcci�n correspondencia del ciudadano/empresa
    public Date fechaOficioRadicado;
    // TRD Correspondiente al tramite
    public String trd;
    // Cantidad de folios del documento anexar
    public String dignatario;
    //Cantidad de folios del documento anexar
    public Integer folios;
    //Causal
    public String causal;
    // tipo_radicado
    public Integer tipo_radicado;
    // Descripci�n de los anexos
    public String radi_desc_anex;
    //
    public String  cuenta_referencia;
    
    
   
    public RadicadoOrfeoWSVO() {
        super();
    }
    
    
    
}
