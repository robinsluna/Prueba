package co.gov.coljuegos.siicol.ejb.wsvo;

import java.util.Date;

public class ConsultaInventarioWSVO {
    //Posici�n
    public int posicion;
    //Mensaje de error
    public String mensajeError;
    //N�mero de solicitud
    public String numeroSolicitud;
    //Mosdalidad de Juego
    public String modalidadJuego;
    //Tipo Solicitud
    public Long tipoSolicitud;
    //Fecha de la Solicitud
    public Date fechaSolicitud;
    //Nit del Operador
    public String nitOperador;
    //N�mero del contrato
    public String contratoOperador;
    //Codigo del local
    public String codigoLocal;
    //Nombre del local
    public String nombreLocal;
    //Direcci�n Local
    public String direccionLocal;
    //C�digo Municip�o local
    public String codigoMunicipioLocal;
    //Tipo de elemento
    public Long tipoElemento;
    //Tipo de Juego
    public Long tipoJuego;
    //N�mero unico de Coljuegos
    public String nuc;
    //Id unica digital
    public String nuid;
    //Serial 
    public String serial;
    //C�digo de marca
    public String codigoMarca;
    //Modelo
    public String modelo;
    //A�o de fabricaci�n
    public int annoFabricacion;
    //N�mero de registro fabricante SCLM
    public int numRegistroFabricante;
    //Indicador conexi�n en linea
    public int indicadorConexion;
    //N�mero de registro fabricante MET
    public String numRegistroFabMET;
    //Indicador MET homologada
    public String indicadorMetHomo;
    //C�digo de la apuesta
    public int codApuesta;
    //Cantidad de sillas
    public int cantidadSillas;
    //Valor del cart�n 
    public Long valorCarton;
    //Estado Ubicaci�n instrumento
    public int estadoUbicacionElemento;
    //Latitud
    public Long latitud;
    //Longitud
    public Long longitud;
    //Tenencia legal
    public String tenenciaLegal;
    //Barrio de la direcci�n
    public String direccion;
    //N�mero de la licencia
    public String numLicencia;
    //Modalidad de la licencia
    public int modalidadLicencia;
    //Cantidad de terminales licencia 
    public int cantTerminalesLicencia;
    //Estado del elemento en el inventario
    public String estadoElemento;
    //Fecha inicio elemento
    public Date fechaInicioElemento;
    //Fecha fin elemento
    public Date fechaFinElemento;
}
