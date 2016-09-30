package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.Date;

public class AutoComisorioSivoWSVO  implements Serializable {
     
    public String numAutoCom;
    public String fechaAutoCom;
    public String actaVisita;
    public String numcontrato;
    public String nit;
    public String direccion;
    public String nombreEst;
    public String nombreOperador;
    public String ciudadMunicipio;
    public String departamento;
    public String  fechaFinCon;
    public String mail;
    

    public AutoComisorioSivoWSVO() {
        super();
    }
}
