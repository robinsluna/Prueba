package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminDenunciaHallazgo {

    public DenunciaVO buscarPorCodigoDenuncia(Long denCodigo) throws ExcepcionDAO;
    public DenunciaVO actualizar(DenunciaVO denunciaVO,  UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<DenunciaVO> buscarTodo() throws ExcepcionDAO;
    public DenunciaVO insertarDenuncia(DenunciaVO denunciaVO) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<DenunciaVO> denunciasHallazgosEnEstadoAutoComisorio() throws ExcepcionDAO;
    public Integer buscarConsecutivoDenuncia() throws ExcepcionDAO;
    public List<SiiDenuncia> buscarDenunciasPorEstado(Long estado) throws ExcepcionDAO;
    public List<DenunciaVO> buscarDenunciasPorEstadoVO(Long estado) throws ExcepcionDAO;
    /**
     * Buscar las denuncias que tengan resoluciones de decomiso y destrucción
     * @return listaDenuncias - Lista de denuncias
     * @throws ExcepcionDAO
     */
    
    public List<DenunciaVO> buscarDenunciasConResolucionDecomisoDestruccion() throws ExcepcionDAO;
}
