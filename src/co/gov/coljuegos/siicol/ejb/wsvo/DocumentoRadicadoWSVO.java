package co.gov.coljuegos.siicol.ejb.wsvo;

import java.util.Date;

public class DocumentoRadicadoWSVO {

    public String draCodigo;
    public Date draFecha;
    public Long codigoTipoDocRadicado;
    public String perNumIdentificacion;
    public Long perTipoIdentificacion;
    public Long cargo;  //Equivalente a tpe_codigo de SII_TIPO_PERSONAL

    public DocumentoRadicadoWSVO() {
        super();
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        try{
            result.append("draCodigo: " + draCodigo + "\r\n");
            result.append("draFecha: " + draFecha + "\r\n");
            result.append("codigoTipoDocRadicado: " + codigoTipoDocRadicado + "\r\n");
            result.append("perNumIdentificacion: " + perNumIdentificacion + "\r\n");
            result.append("perTipoIdentificacion: " + perTipoIdentificacion + "\r\n");
        } catch (Exception ex){
            
        }
    
        return result.toString();
    }

}
