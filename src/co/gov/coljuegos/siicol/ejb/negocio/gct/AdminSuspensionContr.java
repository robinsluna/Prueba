package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.SuspensionContrVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;


public interface AdminSuspensionContr {
    public List<SuspensionContrVO> solicitudesSuspension() throws ExcepcionDAO;

    public SuspensionContrVO insertarSolicitudSuspension(SuspensionContrVO suspensionContrVo,List<EstablecimientoVO> establecimientosSeleccionadosVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;

    public SuspensionContrVO actualizarSolicitudSuspension(SuspensionContrVO suspensionContrVo, UsuarioVO usuarioLogueado, boolean cambioEstado) throws ExcepcionDAO;

    public SuspensionContrVO aprobarSolicitudSuspension(SuspensionContrVO suspensionContrVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO;

    public SuspensionContrVO modificarTermino(SuspensionContrVO suspensionContrVo) throws ExcepcionDAO;
}
