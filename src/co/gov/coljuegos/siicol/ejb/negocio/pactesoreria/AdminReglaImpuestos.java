package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ReglaImpuestosVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminReglaImpuestos 
{
    public ReglaImpuestosVO buscarReglaImpuestosPorId(Long idReglaImpuestos) throws ExcepcionDAO;
    public List<ReglaImpuestosVO> buscarTodoReglaImpuestos() throws ExcepcionDAO;
    public List<ReglaImpuestosVO> buscarReglaImpuestosPorTipoContribuyenteTipoProveedorGrupoRetenciones (String tipoContribuyente, String tipoProveedor, Long idGrupoRetenciones) throws ExcepcionDAO;
    public List<ReglaImpuestosVO> buscarPorDatosPersonaResponsabilidades(Long greCodigo, String rimTipoContrib, String rimTipoProveed, String rimGrupoRespon) throws ExcepcionDAO;
    public List<ReglaImpuestosVO> buscarReglaImpuestosPorTipoRetencion(String tipoRetencion, String tipoContribuyente, String tipoProveedor) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ReglaImpuestosVO> buscarGruposReglaImpuestos() throws ExcepcionDAO;
}
