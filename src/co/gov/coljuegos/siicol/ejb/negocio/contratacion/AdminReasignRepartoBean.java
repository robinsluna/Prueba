package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FiscalizadorSustancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoFiscalizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.IncumplimientoContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RepartoFiscalizadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRepartoFiscalizador;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;
import co.gov.coljuegos.siicol.ejb.vo.RepartoFiscalizadorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminReasignRepartoBean implements AdminReasignReparto 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private RepartoFiscalizadorDAO repartoFiscalizadorDAO;
    @EJB
    private IncumplimientoContrDAO incumplimientoContrDAO;
    @EJB
    private FiscalizadorSustancDAO fiscalizadorSustancDAO;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private HistEstadoFiscalizDAO histEstadoFiscalizDao;


    public AdminReasignRepartoBean() {
        super();
    }
    
    public List<IncumplimientoContrVO> buscarTodoIncumplimientos() throws ExcepcionDAO {
        List<IncumplimientoContrVO> listaIncumplimientoContrVO = null;
        List<SiiIncumplimientoContr> lista = incumplimientoContrDAO.buscarTodo();
        if (lista!=null) {
            listaIncumplimientoContrVO = new ArrayList<IncumplimientoContrVO>();
            for (SiiIncumplimientoContr siiIncumplimientoContr: lista) {
                
                IncumplimientoContrVO incumplimiento = new IncumplimientoContrVO(siiIncumplimientoContr);
                incumplimiento.getRepartoFiscalizadorListVo().add(buscarRepartoPorIncCodigoYActivo(incumplimiento.getIcnCodigo()));
                
                listaIncumplimientoContrVO.add(incumplimiento);
            }
        }
        return (listaIncumplimientoContrVO);
    }
    
    public RepartoFiscalizadorVO actualizarReparto(RepartoFiscalizadorVO repartoFiscalizadorVO,  UsuarioVO usuarioLogueado) throws ExcepcionDAO {
         SiiRepartoFiscalizador siiRepartoFiscalizador = repartoFiscalizadorDAO.actualizarSiiReparto(conversionVoEntidad.convertir(repartoFiscalizadorVO));
         if (siiRepartoFiscalizador==null) return null;
        
        
        if(siiRepartoFiscalizador.getRfsCodigo()!= null){
        adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.REPARTO_FISCALIZADOR.getId(),
                                                    siiRepartoFiscalizador.getRfsActivo(),
                                                    usuarioLogueado, siiRepartoFiscalizador.getRfsCodigo());
        }
                                               
         return ( new RepartoFiscalizadorVO(siiRepartoFiscalizador) );
    }
    
    public RepartoFiscalizadorVO insertarReprato(RepartoFiscalizadorVO reparto) throws ExcepcionDAO
    {
        SiiRepartoFiscalizador siiRepartoFiscalizador = repartoFiscalizadorDAO.insertarSiiRepartoFiscalizador(conversionVoEntidad.convertir(reparto));
        reparto.setRfsCodigo(siiRepartoFiscalizador.getRfsCodigo());
        return reparto;
    }
    
  
    public IncumplimientoContrVO actualizarIncumplimiento(IncumplimientoContrVO incumplimientoContrVO) throws ExcepcionDAO {
           SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDAO.actualizarSiiIncumplimientoContr(conversionVoEntidad.convertir(incumplimientoContrVO));
           if (siiIncumplimientoContr==null) return null;
           return ( new IncumplimientoContrVO(siiIncumplimientoContr) );
    }
     
    public RepartoFiscalizadorVO buscarRepartoPorIncCodigoYActivo(Long icnCodigo) throws ExcepcionDAO {
         RepartoFiscalizadorVO reparto = null;
         reparto = new RepartoFiscalizadorVO(repartoFiscalizadorDAO.buscarRepartoFiscalizPorIcnCodigoYActivo(icnCodigo));
         return (reparto);
     }
    
    public List<RepartoFiscalizadorVO> buscarRepartoFiscalizActivos() throws ExcepcionDAO{
        List<RepartoFiscalizadorVO> repartos = new ArrayList<RepartoFiscalizadorVO>();
        
        List<SiiRepartoFiscalizador> siiRepartos = repartoFiscalizadorDAO.buscarRepartoFiscalizActivos();
        
        if(siiRepartos != null){
            for(SiiRepartoFiscalizador siiReparto: siiRepartos){
                repartos.add(new RepartoFiscalizadorVO(siiReparto));
            }
        }
        Date hoy = new Date();
        int i = 0;
        for (RepartoFiscalizadorVO reparto : repartos) {
            
            List<SiiHistEstadoFiscaliz> historia = histEstadoFiscalizDao.buscarHistEstadoFiscalizPorFiscaliz(reparto.getFiscalizadorSustancVo().getFsuCodigo());
            if (historia.size()>0) {
                if (historia.get(0).getHefFechaAct().before(hoy) && historia.get(0).getHefFechaInact().after(hoy)) {
                    reparto.getFiscalizadorSustancVo().setEstadoActual(historia.get(0).getHefEstado());
                    reparto.getFiscalizadorSustancVo().setFechaActivo(historia.get(0).getHefFechaAct());
                } else {
                    reparto.getFiscalizadorSustancVo().setEstadoActual("");
                }
                
            }
        }

        
        return repartos;
    }
    
    public FiscalizadorSustancVO reasignarSustanciador(Long fsuCodigo, Long tacCodigo   ) throws ExcepcionDAO {
         
         return new FiscalizadorSustancVO(fiscalizadorSustancDAO.buscarPorCodigo(fiscalizadorSustancDAO.reasignarSustanciador(fsuCodigo, tacCodigo)));
         
     }
    
/*    public RepartoFiscalizadorVO cambiarEstadoReparto(RepartoFiscalizadorVO reparto) throws ExcepcionDAO{
        
        reparto.setRfsActivo("N");
        return new RepartoFiscalizadorVO(repartoFiscalizadorDAO.actualizarSiiReparto(conversionVoEntidad.convertir(reparto)));
    }
    */
    public RepartoFiscalizadorVO insertarRepartoFiscalizador(RepartoFiscalizadorVO reparto) throws ExcepcionDAO{
        
        return new RepartoFiscalizadorVO(repartoFiscalizadorDAO.insertarSiiRepartoFiscalizador(conversionVoEntidad.convertir(reparto)));
            
    }

    public void reasignarReparto(RepartoFiscalizadorVO repartoOriginalVo, RepartoFiscalizadorVO nuevoRepartoVo) throws ExcepcionDAO {
        
        repartoFiscalizadorDAO.actualizarSiiReparto(conversionVoEntidad.convertir(repartoOriginalVo));
        repartoFiscalizadorDAO.insertarSiiRepartoFiscalizador(conversionVoEntidad.convertir(nuevoRepartoVo));
    }
}


