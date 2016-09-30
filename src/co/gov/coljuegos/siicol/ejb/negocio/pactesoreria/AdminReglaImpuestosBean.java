package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReglaImpuestosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReglaImpuestos;
import co.gov.coljuegos.siicol.ejb.vo.ReglaImpuestosVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminReglaImpuestosBean implements AdminReglaImpuestos{
    
    
    @EJB
    private ReglaImpuestosDAO reglaImpuestosDao;
    
    public AdminReglaImpuestosBean() {
    }
    
    public ReglaImpuestosVO buscarReglaImpuestosPorId(Long idReglaImpuestos) throws ExcepcionDAO{
        SiiReglaImpuestos siiReglaImpuestos = reglaImpuestosDao.buscarReglaImpuestosPorId(idReglaImpuestos);
        return new ReglaImpuestosVO(siiReglaImpuestos);
    }
    
    public List<ReglaImpuestosVO> buscarTodoReglaImpuestos() throws ExcepcionDAO{
        List<SiiReglaImpuestos> listaReglaImpuestos = reglaImpuestosDao.buscarTodoReglaImpuestos();
        List<ReglaImpuestosVO> listaReglaImpuestosVo = new ArrayList();
        for (SiiReglaImpuestos unReglaImpuestos:listaReglaImpuestos){
            listaReglaImpuestosVo.add(new ReglaImpuestosVO(unReglaImpuestos));
        }
        return listaReglaImpuestosVo;
    }
    
    public List<ReglaImpuestosVO> buscarReglaImpuestosPorTipoContribuyenteTipoProveedorGrupoRetenciones 
    (String tipoContribuyente, String tipoProveedor, Long idGrupoRetenciones) throws ExcepcionDAO{
        List<SiiReglaImpuestos> listaReglaImpuestos = reglaImpuestosDao.buscarReglaImpuestosPorTipoContribuyenteTipoProveedorGrupoRetenciones(tipoContribuyente, tipoProveedor, idGrupoRetenciones);
        List<ReglaImpuestosVO> listaReglaImpuestosVo = new ArrayList();
        for (SiiReglaImpuestos unReglaImpuestos:listaReglaImpuestos){
            listaReglaImpuestosVo.add(new ReglaImpuestosVO(unReglaImpuestos));
        }
        return listaReglaImpuestosVo;
    }
    
    
    @Override
    public List<ReglaImpuestosVO> buscarPorDatosPersonaResponsabilidades(Long greCodigo, String rimTipoContrib, String rimTipoProveed, String rimGrupoRespon) throws ExcepcionDAO 
    {
        List<ReglaImpuestosVO> resultado = null;
        List<SiiReglaImpuestos> lista = reglaImpuestosDao.buscarPorDatosPersonaResponsabilidades(greCodigo, rimTipoContrib, rimTipoProveed, rimGrupoRespon);
        if (lista!=null) {
            resultado = new ArrayList<ReglaImpuestosVO>();
            for (SiiReglaImpuestos siiReglaImpuestos: lista) {
                resultado.add(new ReglaImpuestosVO(siiReglaImpuestos));
            }
        }
        return (resultado);
    }
    
    
    public List<ReglaImpuestosVO> buscarReglaImpuestosPorTipoRetencion(String tipoRetencion, String tipoContribuyente, String tipoProveedor) throws ExcepcionDAO{
        List<SiiReglaImpuestos> listaReglaImpuestos = reglaImpuestosDao.buscarReglaImpuestosPorTipoRetencion(tipoRetencion, tipoContribuyente, tipoProveedor);
        List<ReglaImpuestosVO> listaReglaImpuestosVo = new ArrayList();
        for (SiiReglaImpuestos unReglaImpuestos:listaReglaImpuestos){
            listaReglaImpuestosVo.add(new ReglaImpuestosVO(unReglaImpuestos));
        }
        return listaReglaImpuestosVo;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ReglaImpuestosVO> buscarGruposReglaImpuestos() throws ExcepcionDAO {
        List<ReglaImpuestosVO> reglaImpuestosVOs = null;
        List<SiiReglaImpuestos> siiReglaImpuestoss = null;
        siiReglaImpuestoss = reglaImpuestosDao.buscarGruposReglaImpuestos();
        if (siiReglaImpuestoss != null && !siiReglaImpuestoss.isEmpty()) {
            reglaImpuestosVOs = new ArrayList<ReglaImpuestosVO>();
            for (SiiReglaImpuestos siiReglaImpuestos : siiReglaImpuestoss) {
                ReglaImpuestosVO reglaImpuestosVO = new ReglaImpuestosVO(siiReglaImpuestos);
                reglaImpuestosVOs.add(reglaImpuestosVO);
            }
        }
        return reglaImpuestosVOs;
    }
    
}
