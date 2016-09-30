package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegDenunVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDenunciaHallazgoBean implements AdminDenunciaHallazgo {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DenunciaDAO denunciaDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminElementoIlegDenun adminElemento;
    @EJB
    private DireccionDAO direccionDao;


    public AdminDenunciaHallazgoBean() {
        super();
    }

    @Override
    public DenunciaVO buscarPorCodigoDenuncia(Long denCodigo) throws ExcepcionDAO {
        SiiDenuncia siiDenuncia = denunciaDao.buscarPorCodigo(denCodigo);
        if(siiDenuncia == null)
            return null;
        DenunciaVO denunciaVo = new DenunciaVO(siiDenuncia);
        denunciaVo.setDenDenunDireccion(direccionDao.buscarDireccionCompletaXIdDenuncia(denunciaVo.getDenCodigo())); 
        return (denunciaVo);
    }

    @Override
    public DenunciaVO actualizar(DenunciaVO denunciaVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        actualizarDirecciones(denunciaVO);

        SiiDenuncia siiDenuncia = denunciaDao.actualizar(conversionVoEntidad.convertir(denunciaVO));

        // SE DEJA EN COMENTARIO ESTA PARTE HASTA TANTO SE CREE UN NUEVO TIPO DOCUMENTO EN TIPO DOCUMENTO COLJUEGOS PARA DENUINCIAS
        /*
        if(siiDenuncia.getSiiEstadoDenuncia().getEdnCodigo()!= null){
        adminLogCambioEstado.insertarLogCambioEstado(22L,siiDenuncia.getSiiEstadoDenuncia().getEdnCodigo(),usuarioLogueado, siiDenuncia.getDenCodigo());
        }
        */
        if(siiDenuncia == null)
            return null;

        persistirHijos(denunciaVO);

        return (new DenunciaVO(siiDenuncia));
    }

    private void actualizarDirecciones(DenunciaVO denunciaVO) throws ExcepcionDAO {
        if(denunciaVO != null) {
            if(denunciaVO.getDenDenunDireccionVo() != null) {
                if(denunciaVO.getDenDenunDireccionVo().getDirCodigo() != null)
                    direccionDao.actualizar(conversionVoEntidad.convertir(denunciaVO.getDenDenunDireccionVo()));
                else
                    denunciaVO.getDenDenunDireccionVo().setDirCodigo(direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDenunDireccionVo())).getDirCodigo());
            }

            if(denunciaVO.getDenDnadoDireccionVo() != null) {
                if(denunciaVO.getDenDnadoDireccionVo().getDirCodigo() != null)
                    direccionDao.actualizar(conversionVoEntidad.convertir(denunciaVO.getDenDnadoDireccionVo()));
                else
                    denunciaVO.getDenDnadoDireccionVo().setDirCodigo(direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDnadoDireccionVo())).getDirCodigo());
            }

            if(denunciaVO.getDenDireccionVo() != null) {
                if(denunciaVO.getDenDireccionVo().getDirCodigo() != null)
                    direccionDao.actualizar(conversionVoEntidad.convertir(denunciaVO.getDenDireccionVo()));
                else
                    denunciaVO.getDenDireccionVo().setDirCodigo(direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDireccionVo())).getDirCodigo());
            }

        }
    }

    @Override
    public List<DenunciaVO> buscarTodo() throws ExcepcionDAO {
        List<DenunciaVO> listaDenucias = null;
        List<SiiDenuncia> lista = denunciaDao.buscarTodo();
        if(lista != null) {
            listaDenucias = new ArrayList<DenunciaVO>();
            for(SiiDenuncia siiDenuncia : lista) {
                listaDenucias.add(new DenunciaVO(siiDenuncia));
            }
        }
        return (listaDenucias);
    }

    @Override
    public DenunciaVO insertarDenuncia(DenunciaVO denunciaVO) throws ExcepcionDAO, ExcepcionAplicacion {

        persistirDirecciones(denunciaVO);

        //
        SiiDenuncia siiDenuncia;
        /*siiDenuncia = denunciaDao.buscarPorCodigo(denunciaVO.getDenNumero());
        if(siiDenuncia != null){
            throw new ExcepcionAplicacion("La Denuncia ya existe");
        }
        */

        SiiDenuncia siiDenunc = conversionVoEntidad.convertir(denunciaVO);
        siiDenuncia = denunciaDao.insertar(siiDenunc);

        denunciaVO.setDenCodigo(siiDenuncia.getDenCodigo());
        persistirHijos(denunciaVO);

        return new DenunciaVO(siiDenuncia);
    }

    @Override
    public List<SiiDenuncia> buscarDenunciasPorEstado(Long estado) throws ExcepcionDAO {
        return denunciaDao.buscarDenunciasPorEstado(estado);
    }

    @Override
    public List<DenunciaVO> buscarDenunciasPorEstadoVO(Long estado) throws ExcepcionDAO {

        List<DenunciaVO> listaDenucias = null;
        List<SiiDenuncia> lista = this.buscarDenunciasPorEstado(estado);
        if(lista != null) {
            listaDenucias = new ArrayList<DenunciaVO>();
            for(SiiDenuncia siiDenuncia : lista) {
                listaDenucias.add(new DenunciaVO(siiDenuncia));
            }
        }
        return listaDenucias;
    }
    
    /**
     * Buscar las denuncias que tengan resoluciones de decomiso y destrucción
     * @return listaDenuncias - Lista de denuncias
     * @throws ExcepcionDAO
     */
    
    public List<DenunciaVO> buscarDenunciasConResolucionDecomisoDestruccion() throws ExcepcionDAO {
        List<DenunciaVO> listaDenuncias = null;
        List<SiiDenuncia> lista = this.denunciaDao.buscarDenunciasConResolucionDecomisoDestruccion();
        if(lista != null) {
            listaDenuncias = new ArrayList<DenunciaVO>();
            for(SiiDenuncia siiDenuncia : lista) {
                listaDenuncias.add(new DenunciaVO(siiDenuncia));
            }
        }
        return listaDenuncias;
    }

    private void persistirHijos(DenunciaVO denunciaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirElementosIleg(denunciaVo);
    }

    private void persistirDirecciones(DenunciaVO denunciaVO) throws ExcepcionDAO {
        if(denunciaVO != null) {
            if(denunciaVO.getDenDenunDireccionVo().getDirCallePpal() != null) {
                SiiDireccion siiDenDenunDireccion = direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDenunDireccionVo()));
                if(siiDenDenunDireccion != null && siiDenDenunDireccion.getDirCodigo() != null)
                    denunciaVO.getDenDenunDireccionVo().setDirCodigo(siiDenDenunDireccion.getDirCodigo());
            }
            if(denunciaVO.getDenDnadoDireccionVo().getDirCallePpal() != null) {
                SiiDireccion siiDireccion = direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDnadoDireccionVo()));
                if(siiDireccion != null && siiDireccion.getDirCodigo() != null)
                    denunciaVO.getDenDnadoDireccionVo().setDirCodigo(siiDireccion.getDirCodigo());
            }
            if(denunciaVO.getDenDireccionVo().getDirCallePpal() != null) {
                SiiDireccion siiDireccion = direccionDao.insertar(conversionVoEntidad.convertir(denunciaVO.getDenDireccionVo()));
                if(siiDireccion != null && siiDireccion.getDirCodigo() != null)
                    denunciaVO.getDenDireccionVo().setDirCodigo(siiDireccion.getDirCodigo());
            }
        }
    }

    private void persistirElementosIleg(DenunciaVO denunciaVo) throws ExcepcionDAO, ExcepcionAplicacion {
// se inactivan los elementos no encotrados en la nueva lista de elementos denuciados

        List<ElementoIlegDenunVO> elementos = adminElemento.buscarTodoElementoIlegDenunXCodDenuncia(denunciaVo.getDenCodigo());
        for(ElementoIlegDenunVO elemento : elementos) {
            elemento.setEidActivo("S");
            
            if(denunciaVo.getElementoIlegDenunListVo()!=null){ //Se verifica ya que si no tiene elementos sale una excepción
                if(!denunciaVo.getElementoIlegDenunListVo().contains(elemento)) {
                    elemento.setEidActivo("N");
                }
                elemento = adminElemento.actualizarElementoIlegDenun(elemento);
            }
            
        }
        

// se actualizan los elementos registrados en la nueva lista de elementos denunciados
        if(denunciaVo != null && denunciaVo.getElementoIlegDenunListVo() != null) {
            for(ElementoIlegDenunVO elementoVo : denunciaVo.getElementoIlegDenunListVo()) {
                if(elementoVo != null) {
                    elementoVo.setDenunciaVo(denunciaVo);
                    ElementoIlegDenunVO elementoInactivoVo = adminElemento.buscarElementoInactivo(elementoVo);
                    if (elementoInactivoVo.getEidCodigo()!= null) {
                        elementoVo.setEidCodigo(elementoInactivoVo.getEidCodigo());                        
                    }
                    if(denunciaVo.getDenCodigo() == null) {

                        adminElemento.insertarElementoIlegDenun(elementoVo);
                    }
                    else {

                        adminElemento.actualizarElementoIlegDenun(elementoVo);
                    }
                }
            }
        }
    }

    public List<DenunciaVO> denunciasHallazgosEnEstadoAutoComisorio() throws ExcepcionDAO {
        List<DenunciaVO> denunciasVo = new ArrayList<DenunciaVO>();
        for(SiiDenuncia denuncia : denunciaDao.denunciasHallazgosEnEstadoAutoComisorioSinAccionControl()) {
            denunciasVo.add(new DenunciaVO(denuncia));
        }
        return denunciasVo;
    }

    public Integer buscarConsecutivoDenuncia() throws ExcepcionDAO {
        return denunciaDao.buscarConsecutivoDenuncia();
    }
}
