package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioAccConVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoAccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulAuComAcConVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAutoComisorio {
    public AutoComisorioVO buscarPorCodigoAutoComisorio (Long aucCodigo) throws ExcepcionDAO ;
    public List<AutoComisorioVO> buscarTodoAutoComisorio() throws ExcepcionDAO ;
    public AutoComisorioVO insertarAutoComisorio(AutoComisorioVO autoComisorioVo ) throws ExcepcionDAO ;
    public String siguienteNumeroAutoComisorio() throws ExcepcionDAO ;
    public AutoComisorioVO actualizarAutoComisorio (AutoComisorioVO autoComisorioVo, UsuarioVO usuarioLogueado ) throws ExcepcionDAO ;
    public List<EstablecimientoVO>  buscarEstablecimientoXIdContrato(Long conCodigo )throws ExcepcionDAO;
    public List<GrupoFiscalizacionVO> buscarGruposAutoComisiorio(Date fechaIni)throws ExcepcionDAO, ExcepcionDAO ;
    public List<AutoComisorioVO> buscarAutoComisorioPorTipoVisitaYCodigoContrato (String tipoVisita, Long conCodigo) throws ExcepcionDAO;
    public List<AutoComisorioAccConVO> buscarTodoAutoComisorioAcc( ) throws ExcepcionDAO ;
    public String siguienteNumeroAutoComisorioAcc() throws ExcepcionDAO ;
    public List<GrupoAccionControlVO> buscarGruposAutoComisiorioAccFecha(Date fecha,Integer numGrupos)throws ExcepcionDAO  ;
    public List<GrupoAccionControlVO> buscarGrupoAccionControlXFecha (Date fecha) throws ExcepcionDAO ;
    public AutoComisorioAccConVO insertarAutoComisorioAcc(AutoComisorioAccConVO autoComisorioAccConVo ) throws ExcepcionDAO ;
    public AutoComisorioAccConVO actualizarAutoComisorioAcc (AutoComisorioAccConVO autoComisorioAccConVo, UsuarioVO usuarioLogueado )throws ExcepcionDAO ;
    public AutoComisorioAccConVO buscaSiiAutoComisorioAccConPorId(Long idAutCodigo) throws ExcepcionDAO ;
    public List<MotivoAnulAuComAcConVO> buscarTodoMotivoAnulAuComAcCon() throws ExcepcionDAO ;
    public List<AutoComisorioAccConVO> buscarAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO;
    public List<DenunciaVO> buscarDenunciasSinAutoAcc() throws ExcepcionDAO ;
      
    
}
