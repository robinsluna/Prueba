package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

public class RadicadoOrfeoWSVO implements Serializable {
    
    
    //Código del aplicativo interfaz 
    public Integer cod_app ;
    // La referencia  
    public String referencia;
    //Login del usuario preestablecido para realizar la radicación a través del webservice
    public String usrRadicador;
    //Código de tipo de usuario que genera el radicado. 
    public Integer tipoTercero ;
    //Nombre del ciudadano, entidad, empresa o funcionario según corresponda. 
    public String nombreTercero;
    //Primer apellido del ciudadano, o funcionario según corresponda.
    public String primerApellidoTercero;
    // Segundo apellido del ciudadano, entidad, empresa o funcionario según corresponda. 
    public String segundoApellidoTercero;
    // Código de tipo de identificación. 
    public Long tipoIDTercero;
    //Tercero Referencia según el tipo de identificación (TipoIDTercero).
    public String numeroIDTercero;
    //Correo Electrónico a través del cual se respondería al radicado.
    public String correoElectronicoTercero;
    //Dirección correspondencia del ciudadano/empresa
    public String direccionTercero;
    // CodCont-CodPais-CodDpto-CodMcpio
    public String internacionalizacion;
    // Telefono
    public String telefono;
    //MedioRecep
    public Integer medioRecep;
    //Asunto o descripción del radicado a crear
    public String asuntoRadicado;
    //Dirección correspondencia del ciudadano/empresa
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
    // Descripción de los anexos
    public String radi_desc_anex;
    //
    public String  cuenta_referencia;
    
    
   
    public RadicadoOrfeoWSVO() {
        super();
    }
    
    
    
}
