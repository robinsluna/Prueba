package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.AseguradoraVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPolizaContVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficInfPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaRequisitosPolVO;

import java.util.Date;
import java.util.List;

public class PolizaContratoWSVO {
    private Long pccCodigo;
    private Date pccFechaExped;
    private Date pccFechaRecep;
    private String pccNumero;
    private String pccObservaciones;
   /* private AseguradoraVO aseguradoraVO;
    private List<PolizaRequisitosPolVO> polizaRequisitosPolVO;
    private EstadoPolizaContVO estadoPolizaContVO;
    private ArchivoFisicoVO archivoFisicoVO;
    private List<GarantiaPolizaVO> garantiaPolizaListVO;
    private List<OficInfPolizaVO> oficInfPolizaListVO;
    private ContratoVO contratoVO;*/
    private Long idEstadoAnterior;
    
    
    public PolizaContratoWSVO() {
        
    }
}
