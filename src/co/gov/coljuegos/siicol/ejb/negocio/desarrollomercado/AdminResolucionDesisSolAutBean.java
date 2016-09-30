package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioResolDesisDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionDesisSolAutDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioResolDesis;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDesisSolAut;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InventarioResolDesisVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDesisSolAutVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminResolucionDesisSolAutBean implements AdminResolucionDesisSolAut {
    
    @EJB
    private ResolucionDesisSolAutDAO resolucionDesisSolAutDao;
    @EJB 
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private OperadorDAO operadorDao;    
    @EJB
    private InventarioResolDesisDAO inventarioResolDesisDao;
    @EJB
    private AdminInventarioResolDesis adminInventarioResolDesis;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
  
    
    private List<InventarioResolDesisVO> listaInvResDesVoEliminar;
    

    public AdminResolucionDesisSolAutBean() {
        super();
    }
    
    
    private void eliminarListaInvResDesVo () throws ExcepcionDAO {
        if (listaInvResDesVoEliminar!=null) {
            for (InventarioResolDesisVO invRD: listaInvResDesVoEliminar) {
                if (invRD!=null && invRD.getIrdCodigo()!=null) {
                    // Inactivar registro
                    invRD.setIrdActivo(EnumDecision.NO.getId());
                    adminInventarioResolDesis.actualizarInventarioResolDesis(invRD);
                }
            }
        }
    }
    

    @Override
    public ResolucionDesisSolAutVO buscarResolucionDesisSolAutPorId(Long rdsCodigo) throws ExcepcionDAO {
        List<InventarioResolDesisVO> listInvResolDesisVo = new ArrayList();
        SiiResolucionDesisSolAut  siiResolucionDesisSolAut = resolucionDesisSolAutDao.buscarPorCodigo(rdsCodigo);
       
        List<SiiInventarioResolDesis> listSiiInventarioResolDesis =inventarioResolDesisDao.buscarInventarioResolDesisPorIdResolucionDesisSolAut(rdsCodigo );
        for(SiiInventarioResolDesis siiInventarioResolDesis : listSiiInventarioResolDesis){
            InventarioResolDesisVO inventarioResolDesisVo = new InventarioResolDesisVO(siiInventarioResolDesis);
            listInvResolDesisVo.add(inventarioResolDesisVo);
        }
    
        ResolucionDesisSolAutVO resolucionDesisSolAutVo = new ResolucionDesisSolAutVO(siiResolucionDesisSolAut);
        resolucionDesisSolAutVo.setListInvResDesVo(listInvResolDesisVo);
        return (resolucionDesisSolAutVo);
    }
  
    @Override
    public ResolucionDesisSolAutVO insertarResolucionDesisSolAut(ResolucionDesisSolAutVO resolucionDesisSolAutVo, UsuarioVO usuarioVo) throws ExcepcionDAO {
        
            ResolucionDesisSolAutVO resultado = null;   
            
        SiiResolucionDesisSolAut siiResolucionDesisSolAut = new SiiResolucionDesisSolAut();//resolucionDesisSolAutVo
        
        SiiOperador siiOperador = new SiiOperador();
        SiiPersona siiPersona = new SiiPersona();
       
            try {
                
                // Eliminar los elementos que se encuentran pendientes en el inventario
                this.eliminarListaInvResDesVo();
                
                siiOperador = operadorDao.buscarOperadorXCodigoPersona(resolucionDesisSolAutVo.getPersonaVo().getPerCodigo());
               
                siiResolucionDesisSolAut  = conversionVoEntidad.convertir(resolucionDesisSolAutVo);
                siiResolucionDesisSolAut.setSiiOperador(siiOperador);
                siiResolucionDesisSolAut = resolucionDesisSolAutDao.insertar(siiResolucionDesisSolAut);                      
   
               for (InventarioResolDesisVO inventarioResolDesisVo : resolucionDesisSolAutVo.getListInvResDesVo()) {
                    inventarioResolDesisVo.setIrdActivo(EnumDecision.SI.getId());
                    TipoApuestaVO tipoApuestaVo = new TipoApuestaVO();
                    tipoApuestaVo.setTapCodigo(inventarioResolDesisVo.getTipoApuestaVo().getTapCodigo());
                    inventarioResolDesisVo.setTipoApuestaVo(tipoApuestaVo);
                    inventarioResolDesisVo.setTipoApuestaVo(inventarioResolDesisVo.getTipoApuestaVo());
                    inventarioResolDesisVo.setUsuarioConectVo(usuarioVo);
                    SiiInventarioResolDesis siiInventarioResolDesis = conversionVoEntidad.convertir(inventarioResolDesisVo);
                    siiInventarioResolDesis.setSiiResolucionDesisSolAut(siiResolucionDesisSolAut);
                    
                    siiInventarioResolDesis = inventarioResolDesisDao.insertar(siiInventarioResolDesis);
                   
                }
            
                throw new ExcepcionAplicacion("No se encontro un operador por ese nit por favor verifique.");
            } catch (ExcepcionAplicacion e) {
            }
        
            if(resolucionDesisSolAutVo.getEstado()!=null){
                adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.RESOLUCION_DESISTIMIENTO_LOCALIZADOS.getId(),
                                                                            resolucionDesisSolAutVo.getEstado(), usuarioVo, siiResolucionDesisSolAut.getRdsCodigo());
            }
            if (siiResolucionDesisSolAut!=null){
                
                    resultado = (new ResolucionDesisSolAutVO(siiResolucionDesisSolAut));
            }
                return resultado;
        }
    
    @Override
    public ResolucionDesisSolAutVO actualizarResolucionDesisSolAut(ResolucionDesisSolAutVO resolucionDesisSolAutVo, UsuarioVO usuarioVo) throws ExcepcionDAO {
        
        ResolucionDesisSolAutVO resultado = null;
        
        SiiResolucionDesisSolAut siiResolucionDesisSolAut = new SiiResolucionDesisSolAut();//resolucionDesisSolAutVo
        
        SiiOperador siiOperador = new SiiOperador();
        
        try {
            
            // Eliminar los elementos que se encuentran pendientes en el inventario
            this.eliminarListaInvResDesVo();
            
            siiOperador = operadorDao.buscarOperadorXCodigoPersona(resolucionDesisSolAutVo.getOperadorVo().getPersonaVo().getPerCodigo());
            
           
            siiResolucionDesisSolAut  = conversionVoEntidad.convertir(resolucionDesisSolAutVo);
            siiResolucionDesisSolAut.setSiiOperador(siiOperador);
            siiResolucionDesisSolAut = resolucionDesisSolAutDao.actualizar(siiResolucionDesisSolAut);               
        
           for (InventarioResolDesisVO inventarioResolDesisVo : resolucionDesisSolAutVo.getListInvResDesVo()) {
               if(inventarioResolDesisVo.getIrdCodigo() == null ){
                inventarioResolDesisVo.setIrdActivo(EnumDecision.SI.getId());
                inventarioResolDesisVo.setUsuarioConectVo(usuarioVo);
                SiiInventarioResolDesis siiInventarioResolDesis = conversionVoEntidad.convertir(inventarioResolDesisVo);
                siiInventarioResolDesis.setSiiResolucionDesisSolAut(siiResolucionDesisSolAut);
                
                siiInventarioResolDesis = inventarioResolDesisDao.insertar(siiInventarioResolDesis);   
                }
            }
            if(resolucionDesisSolAutVo.getEstado()!=null){
                adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.RESOLUCION_DESISTIMIENTO_LOCALIZADOS.getId(),
                                                                            resolucionDesisSolAutVo.getEstado(), usuarioVo, siiResolucionDesisSolAut.getRdsCodigo());
            }        
            throw new ExcepcionAplicacion("No se encontro un operador por ese nit por favor verifique.");
        } catch (ExcepcionAplicacion e) {
        }
        
             
        if (siiResolucionDesisSolAut!=null){
            
                resultado = (new ResolucionDesisSolAutVO(siiResolucionDesisSolAut));
        }
            return resultado;
    }

    @Override
    public void eliminarResolucionDesisSolAut(Long rdsCodigo) throws ExcepcionDAO {
        // TODO Implement this method
    }

    @Override
    public List<ResolucionDesisSolAutVO> buscarTodaResolucionDesisSolAut() throws ExcepcionDAO {
        List<ResolucionDesisSolAutVO> resultado = null;
        List<SiiResolucionDesisSolAut> lista = resolucionDesisSolAutDao.buscarTodo();
       
            if (lista!=null) {
            resultado = new ArrayList<ResolucionDesisSolAutVO>();
            
            for (SiiResolucionDesisSolAut siiResolucionDesisSolAut: lista) {
                if (siiResolucionDesisSolAut!=null)
                    resultado.add(new ResolucionDesisSolAutVO(siiResolucionDesisSolAut));
            }
        }       
        return resultado;
    }

    
    
    public void setListaInvResDesVoEliminar(List<InventarioResolDesisVO> listaInvResDesVoEliminar) {
        this.listaInvResDesVoEliminar = listaInvResDesVoEliminar;
    }

    public List<InventarioResolDesisVO> getListaInvResDesVoEliminar() {
        return listaInvResDesVoEliminar;
    }
}
