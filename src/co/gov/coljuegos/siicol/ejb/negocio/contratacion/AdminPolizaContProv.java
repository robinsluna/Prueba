package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoPolContProvVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContProvVO;

import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminPolizaContProv {
    
    public PolizaContProvVO buscarPolizaContProvPorId (Long idPolizaContProv) throws ExcepcionDAO;
    public PolizaContProvVO actualizarPolizaContProv(PolizaContProvVO polizaContProvVo) throws ExcepcionDAO;
    public PolizaContProvVO insertarPolizaContProv (PolizaContProvVO polizaContProvVo) throws ExcepcionDAO;
    public List<PolizaContProvVO> buscarTodosPolizaContProv () throws ExcepcionDAO;
    public PolizaContProvVO insertarPolizaGarantia (PolizaContProvVO polizaContProvVo) throws ExcepcionDAO;
    public List<PolizaContProvVO> buscarPolizaContProvPorIdProcesoContratacion (Long idProcesoContratacion) throws ExcepcionDAO;
    public PolizaContProvVO actualizarPolizaGarantia (PolizaContProvVO polizaContProvVo, List<AmparoPolContProvVO> listaAgregarAmparoPolContProv, List<AmparoPolContProvVO> listaEliminarAmparoPolContProv, ProcesoContratacionVO procesoContratacionVo, ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO;    
    public PolizaContProvVO registrarPolizaGarantia (PolizaContProvVO polizaContProvVo, ProcesoContratacionVO procesoContratacionVo, ContratoProveedorVO contratoProveedorVo ) throws ExcepcionDAO;
}
