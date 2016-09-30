package co.gov.coljuegos.siicol.ejb.vo.siito;

import co.gov.coljuegos.siicol.ejb.wsvo.EstablecimientoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.NovedadWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.TipoApuestaWSVO;

import java.util.Date;

public class InventarioWSVO {
    
    public Long invCodigo;
    public String invEstado;
    public Date invFechaFinLiq;
    public Date invFechaFinOfi;
    public Date invFechaIniLiq;
    public Date invFechaIniOfi;
    public Integer invSillas;
    public TipoApuestaWSVO tipoApuestaVo;
    public InstrumentoWSVO instrumentoVo;
    public NovedadWSVO novedadVo;
    public EstablecimientoWSVO establecimientoVo;
    
    public InventarioWSVO() {
        
    }
}
