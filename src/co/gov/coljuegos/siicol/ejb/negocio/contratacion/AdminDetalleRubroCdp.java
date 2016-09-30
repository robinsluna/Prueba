package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDetalleRubroCdp {
    public DetalleRubroCdpVO buscarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO;

    public DetalleRubroCdpVO insertarSiiDetalleRubroCdp(DetalleRubroCdpVO detalleRubroCdpVO) throws ExcepcionDAO;

    public DetalleRubroCdpVO actualizarSiiDetalleRubroCdp(DetalleRubroCdpVO detalleRubroCdpVO) throws ExcepcionDAO;

    public void borrarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO;

    public List<DetalleRubroCdpVO> buscarTodoSiiDetalleRubroCdp() throws ExcepcionDAO;

    public List<DetalleRubroCdpVO> buscarDetalleRubroCdpPorIdCdp(Long idCdp) throws ExcepcionDAO;

    public List<DetalleRubroCdpVO>  buscarDetalleRubroCdpPorDetalleRubroYcdp(Long druCodigo, Long cdpCodigo ) throws ExcepcionDAO;
    
    public DetalleRubroCdpVO buscarDetalleRubroCdpPorDetalleRubroYcdpYgmf(Long druCodigo, Long cdpCodigo , String drcAplicaGmf) throws ExcepcionDAO;
    
    public String aplicaGmfAlRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO;
    
    public List<DetalleRubroCdpVO> buscarDetallesRubroCdpPorDruCodigo(Long druCodigo) throws ExcepcionDAO;
}
