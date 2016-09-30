package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.List;

public class DetalleOperadorWSVO implements Serializable {

    public OperadorWSVO operador;
    public PersonaWSVO representanteLegal;
    public PersonaWSVO revisorFiscal;
    public PersonaWSVO contador;
    public PersonaWSVO contactoEmpresa;
    public PersonaWSVO apoderado;
    public PersonaWSVO socio1;
    public PersonaWSVO socio2;
    public PersonaWSVO socio3;
    public PersonaWSVO socio4;
    public PersonaWSVO socio5;
    public DetalleFinancieroWSVO detalleFinanciero;
    public PersonaWSVO representanteLegalSuplente;
    public PersonaWSVO revisorFiscalSuplente;
    public List<ContratoInformacionWSVO> listaContratosWSVO;
    public List<DocumentoRadicadoWSVO> listaDocumentosRadicadosWSVO;

    public DetalleOperadorWSVO() {
    }

}
