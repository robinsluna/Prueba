package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.List;

public class OperadorWSVO implements Serializable {

    public String razonSocial;
    public String numIdentificacion;
    public String direccion;
    public String telefono;
    public String telefono2;
    public String correoElectronico;
    public String codMunicipioDane;
    public String codDepartamentoDane;
    public String ciudad;
    public String departamento;
    public String representanteLegal;
    public String revisorFiscal;
    public Long codigo;
    public List<ContratoWSVO> listaContratos;
    public CuotaOperadorWSVO cuotaAcuerdosPagoActual;
    public CuotaOperadorWSVO cuotaIlegalidadActual;
    public List<CuotaOperadorWSVO> listaCuotasAcuerdosVencidas;
    public List<CuotaOperadorWSVO> listaCuotasAcuerdosNoVencidas;
    public List<CuotaOperadorWSVO> listaCuotasSanciones;
    public List<CuotaOperadorWSVO> listaCuotasMultas;
    public List<CuotaOperadorWSVO> listaCuotasCobroCoactivo;
    public List<CuotaOperadorWSVO> listaCuotasLiquidacionAforo;
    public ContratoWSVO contrato;
    public Long tipoSociedad;
    public Integer digitoVerificacion;
    public CuotaOperadorWSVO cuotaMultasSancionesActual;
    public List<CuotaOperadorWSVO> listaCuotasMultasSancionesVencidas;
    public List<CuotaOperadorWSVO> listaCuotasMultasSancionesNoVencidas;
    public List<CuotaOperadorWSVO> listaCuotasIlegalidadActual;
    public List<CuotaOperadorWSVO> listaCuotasIlegalidadVencida;
    public List<CuotaOperadorWSVO> listaCuotasIlegalidadNoVencida;

    public OperadorWSVO() {
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        try{
            result.append("razonSocial: " + razonSocial + "\r\n");
            result.append("numIdentificacion: " + numIdentificacion + "\r\n");
            result.append("direccion: " + direccion + "\r\n");
            result.append("telefono: " + telefono + "\r\n");
            result.append("telefono2: " + telefono2 + "\r\n");
            result.append("correoElectronico: " + correoElectronico + "\r\n");
            result.append("codMunicipioDane: " + codMunicipioDane + "\r\n");
            result.append("codDepartamentoDane: " + codDepartamentoDane + "\r\n");
            result.append("ciudad: " + ciudad + "\r\n");
            result.append("departamento: " + departamento + "\r\n");
            result.append("representanteLegal: " + representanteLegal + "\r\n");
            result.append("revisorFiscal: " + revisorFiscal + "\r\n");
            result.append("codigo: " + codigo + "\r\n");
            result.append("tipoSociedad: " + tipoSociedad + "\r\n");
            result.append("digitoVerificacion: " + digitoVerificacion + "\r\n");
        } catch (Exception ex){
            
        }
        
        return result.toString();
    }

}
