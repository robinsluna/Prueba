package co.gov.coljuegos.siicol.ejb.vo.siito;

import co.gov.coljuegos.siicol.ejb.wsvo.OperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoInstrumentoWSVO;

import java.util.Date;
import java.util.List;

public class InstrumentoWSVO {
    
    public String insActivo;
    public Long insCodigo;
    public Date insFechaModific;
    public Date insFechaRegistro;
    public Long tapCodigo;
    public TipoInstrumentoWSVO tipoInstrumentoVo;
    public MetWSVO metVo;
    public List<InventarioWSVO> inventarioVoList;
    public OperadorWSVO operadorVo;
    
    public InstrumentoWSVO() {
       
    }
}
