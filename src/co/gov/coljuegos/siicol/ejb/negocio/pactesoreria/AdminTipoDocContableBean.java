/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoDocContableBean implements AdminTipoDocContable 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    
    /**
     * Constructor.
     */
    public AdminTipoDocContableBean() {
        super();
    }

    @Override
    public TipoDocContableVO buscarPorCodigoTipoDocContable(String tdcCodigo) throws ExcepcionDAO {
        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo(tdcCodigo);
        if (siiTipoDocContable==null) return null;
        return ( new TipoDocContableVO(siiTipoDocContable) );
    }

    @Override
    public TipoDocContableVO insertarTipoDocContable(TipoDocContableVO tipoDocContableVO) throws ExcepcionDAO, ExcepcionAplicacion {
        SiiTipoDocContable siiTipoDocContableBuscar = tipoDocContableDao.buscarPorCodigo(tipoDocContableVO.getTdcCodigo());
        if(siiTipoDocContableBuscar != null){
            throw new ExcepcionAplicacion("El tipo de documento contable ya existe");
        }
        SiiTipoDocContable siiTipoDocContable = conversionVoEntidad.convertir(tipoDocContableVO);
        siiTipoDocContable = tipoDocContableDao.insertar(siiTipoDocContable);
        return new TipoDocContableVO(siiTipoDocContable);
    }

    @Override
    public TipoDocContableVO actualizarTipoDocContable(TipoDocContableVO tipoDocContableVO,  UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.actualizar(conversionVoEntidad.convertir(tipoDocContableVO));
        
        // SE DEJA EN COMENTARIO ESTA PARTE HASTA TANTO SE DE FORMA AL INGRESO DE REGISTROS EN LOG QUE PERMITAN EN EL ID INGRESAR UN STRING
        // EN ESTE CASO siiTipoDocContable.getTdcCodigo() ES UN STRING Y LA TABLA RECIBE LONG
        
        if(siiTipoDocContable.getTdcActivo()!= null){
        adminLogCambioEstado.insertarLogCambioEstadoConNombreEstadoIDString(EnumTipoDocColjuegos.TIPO_DOCUMENTO_CONTABLE.getId(),
                                                    siiTipoDocContable.getTdcActivo(),
                                                    usuarioLogueado, siiTipoDocContable.getTdcCodigo());
        }
        
        if (siiTipoDocContable==null) return null;
        return ( new TipoDocContableVO(siiTipoDocContable) );
    }

    @Override
    public void borrarTipoDocContable(TipoDocContableVO tipoDocContableVO) throws ExcepcionDAO {
        SiiTipoDocContable siiTipoDocContable = 
        conversionVoEntidad.convertir(tipoDocContableVO);
        tipoDocContableDao.eliminar(siiTipoDocContable);
    }

    @Override
    public List<TipoDocContableVO> buscarTodoTipoDocContable() throws ExcepcionDAO {
        List<TipoDocContableVO> listaTipoDocContable = null;
        List<SiiTipoDocContable> lista = tipoDocContableDao.buscarTodo();
        if (lista!=null) {
            listaTipoDocContable = new ArrayList<TipoDocContableVO>();
            for (SiiTipoDocContable siiTipoDocContable: lista) {
                listaTipoDocContable.add(new TipoDocContableVO(siiTipoDocContable));
            }
        }
        return (listaTipoDocContable);
    }
    
    @Override
    public List<TipoDocContableVO> buscarPermitidosRegistroManual() throws ExcepcionDAO {
        List<TipoDocContableVO> listaTipoDocContable = null;
        List<SiiTipoDocContable> lista = tipoDocContableDao.buscarPermitidosRegistroManual();
        if (lista!=null) {
            listaTipoDocContable = new ArrayList<TipoDocContableVO>();
            for (SiiTipoDocContable siiTipoDocContable: lista) {
                listaTipoDocContable.add(new TipoDocContableVO(siiTipoDocContable));
            }
        }
        return (listaTipoDocContable);
    }
}
