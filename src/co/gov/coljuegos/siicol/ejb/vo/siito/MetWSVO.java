package co.gov.coljuegos.siicol.ejb.vo.siito;

import co.gov.coljuegos.siicol.ejb.wsvo.MarcaWSVO;

import java.util.Date;
import java.util.List;

public class MetWSVO {
    
    public Long tipoNOvedad; //Para poder identificar el tipo de novedad en la operacion del WS cargarSolicitudLocalizados
    public Long codApuesta; //Para poder identificar el tipo de apuesta en la operacion del WS cargarSolicitudLocalizados
    
    public Long metCodigo;
    public Date metFechaFab;
    public String metHomologado;
    public String metOnline;
    public String metSerial;
    public String metUid;
    public List<InstrumentoWSVO> instrumentoList1;   
    public MarcaWSVO marcaVo;
    public String metMarcaAnterior;
    public String metModelo;
    public String metNuid;
    
    public MetWSVO() {
        
    }
}
