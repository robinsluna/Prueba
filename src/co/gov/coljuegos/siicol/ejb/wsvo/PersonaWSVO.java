package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

/*
 * Clase utilizada para recibir por WebServices los datos provenientes de SIITO
 * no posee Entidad correspondiente
 */

public class PersonaWSVO implements Serializable {

    public String primerApellido;
    public String primerNombre;
    public String segundoApellido;
    public String segundoNombre;
    public int tipoIdentificacion;
    public String numIdentificacion;
    public String direccion;
    public String telefono;
    public String telefono2;
    public String correoElectronico;
    public String codMunicipioDane;
    public String perCelular;
    public Integer perDigitoVerif;
    public String perTipoPersona;
    public String numTarjetaProfesional;
    public String numSocio;

    public PersonaWSVO() {
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        try{
            result.append("primerApellido: " + primerApellido + "\r\n");
            result.append("primerNombre: " + primerNombre + "\r\n");
            result.append("segundoApellido: " + segundoApellido + "\r\n");
            result.append("segundoNombre: " + segundoNombre + "\r\n");
            result.append("tipoIdentificacion: " + tipoIdentificacion + "\r\n");
            result.append("numIdentificacion: " + numIdentificacion + "\r\n");
            result.append("direccion: " + direccion + "\r\n");
            result.append("telefono: " + telefono + "\r\n");
            result.append("telefono2: " + telefono2 + "\r\n");
            result.append("correoElectronico: " + correoElectronico + "\r\n");
            result.append("codMunicipioDane: " + codMunicipioDane + "\r\n");
            result.append("perCelular: " + perCelular + "\r\n");
            result.append("perDigitoVerif: " + perDigitoVerif + "\r\n");
            result.append("perTipoPersona: " + perTipoPersona + "\r\n");
            result.append("numTarjetaProfesional: " + numTarjetaProfesional + "\r\n");
            result.append("numSocio: " + numSocio + "\r\n");
        } catch (Exception ex){
            
        }
        
        return result.toString();
    }

}
