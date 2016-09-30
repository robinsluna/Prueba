package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.vo.siito.InventarioWSVO;

import java.util.Date;
import java.util.List;

public class NovedadWSVO {
    
    public Long novCodigo;
    public Date novFecha;;
    public ContratoWSVO contratoVO;
    public TipoNovedadWSVO tipoNovedad;
    public List<InventarioWSVO> inventarioVoList;    
    //public SolicitudAutorizaWSVO solicitudAutorizaVO; 
    
    public NovedadWSVO() {
        
    }
}
