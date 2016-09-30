package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AccionControlDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionPersonaAtienDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoRetiradoAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaAtiendeAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaAtiendeAcc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaAtienVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoRetiradoAccVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaAtiendeAccVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminAccionControlBean implements AdminAccionControl {
    @EJB
    private AccionControlDAO accionControlDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ElementoRetiradoAccDAO elementoRetiradoAccDao;
    @EJB
    private PersonaAtiendeAccDAO personaAtiendeAccDao;
    @EJB
    private DireccionPersonaAtienDAO direccionPersonaAtienDao;
    @EJB
    private DenunciaDAO denunciaDao;

    public AdminAccionControlBean() {
    }

    public List<AccionControlVO> accionesDeControl() throws ExcepcionDAO {
        List<AccionControlVO> accionesVo = new ArrayList<AccionControlVO>();
        for(SiiAccionControl accion : accionControlDao.buscarTodaAccionControlPorCodigoDesc()) {
            accionesVo.add(new AccionControlVO(accion));
        }
        return accionesVo;
    }
    
    /**
     * Buscar las acciones de control que tengan acta de hechos
     * @return accionesVo - Lista de AccionControlVO
     * @throws ExcepcionDAO
     */
    
    public List<AccionControlVO> buscarAccionControlConActaHechosDesc() throws ExcepcionDAO {
        List<AccionControlVO> accionesVo = new ArrayList<AccionControlVO>();
        for(SiiAccionControl accion : accionControlDao.buscarAccionControlConActaHechosDesc()) {
            accionesVo.add(new AccionControlVO(accion));
        }
        return accionesVo;
    }
    
    public List<AccionControlVO> buscarAccionesControlAprobadas() throws ExcepcionDAO {
        List<AccionControlVO> accionesVo = new ArrayList<AccionControlVO>();
        for(SiiAccionControl accion : accionControlDao.buscarAccionesControlAprobadas()) {
            accionesVo.add(new AccionControlVO(accion));
        }
        return accionesVo;
    }

    /**
     * Buscar acciones de control sin proceso sancionatorio de ilegalidad
     * @return accionesVo - Lista de acciones de control
     * @throws ExcepcionDAO
     */
    
    public List<AccionControlVO> buscarAccionControlSinProcesoSancIleg() throws ExcepcionDAO {
        List<AccionControlVO> accionesVo = new ArrayList<AccionControlVO>();
        for(SiiAccionControl accion : accionControlDao.buscarTodaAccionControlSinProcesoSancIleg()) {
            accionesVo.add(new AccionControlVO(accion));
        }
        return accionesVo;
    }

    public AccionControlVO insertarAccionControl(AccionControlVO accionControlVo) throws ExcepcionDAO {
        accionControlVo.setAccEstado("B");
        AccionControlVO nuevaAccionControl = new AccionControlVO(accionControlDao.insertar(conversionVoEntidad.convertir(accionControlVo)));

        if(accionControlVo.getElementoRetiradoAccListVo() != null && accionControlVo.getElementoRetiradoAccListVo().size() > 0) {
            for(ElementoRetiradoAccVO elemento : accionControlVo.getElementoRetiradoAccListVo()) {
                System.out.println(elemento.getElrCodigo());
                elemento.setAccionControlVo(nuevaAccionControl);
                elemento = new ElementoRetiradoAccVO(elementoRetiradoAccDao.insertarSiiElementoRetiradoAcc(conversionVoEntidad.convertir(elemento)));
                System.out.println(elemento.getElrCodigo());
            }
        }
        if(accionControlVo.getPersonaAtiendeAccListVo() != null && accionControlVo.getPersonaAtiendeAccListVo().size() > 0) {
            for(PersonaAtiendeAccVO persona : accionControlVo.getPersonaAtiendeAccListVo()) {
                persona.setAccionControlVo(nuevaAccionControl);
                SiiPersonaAtiendeAcc personaGuardada = personaAtiendeAccDao.insertarSiiPersonaAtiendeAcc(conversionVoEntidad.convertir(persona));
                guardarDireccionesPersonaAtiendeAcc(persona, personaGuardada);
            }

        }
        return nuevaAccionControl;
    }

    /**
     * Buscar Accion Control según Id de resolución de decomiso y destrucción
     * @param rddCodigo
     * @return  resultado - lista de acciones de control
     * @throws ExcepcionDAO
     */

    public List<AccionControlVO> buscarAccionControlXIdResolucionDecomDest(Long rddCodigo) throws ExcepcionDAO {
        List<AccionControlVO> resultado = null;
        List<SiiAccionControl> lista = accionControlDao.buscarAccionControlXIdResolucionDecomDest(rddCodigo);
        if(lista != null) {
            resultado = new ArrayList<AccionControlVO>();
            for(SiiAccionControl siiAccionControl : lista) {
                if(siiAccionControl != null)
                    resultado.add(new AccionControlVO(siiAccionControl));
            }

        }

        return (resultado);
    }

    /**
     * Buscar un acción control según Id de Auto comisorio.
     * @param acaCodigo
     * @return resultado - AccionControlVO
     * @throws ExcepcionDAO
     */

    public AccionControlVO buscarAccionControlXIdAutoComisorio(Long acaCodigo) throws ExcepcionDAO {
        AccionControlVO resultado = null;
        SiiAccionControl siiAccionControl = accionControlDao.buscarAccionControlXIdAutoComisorio(acaCodigo);

        if(siiAccionControl != null)
            resultado = new AccionControlVO(siiAccionControl);

        return (resultado);
    }

    public AccionControlVO actualizarAccionControl(AccionControlVO accionControlVo, UsuarioVO usuarioVo) throws ExcepcionDAO {
        denunciaDao.actualizar(conversionVoEntidad.convertir(accionControlVo.getAutoComisorioAccConVo().getDenunciaVo()));
        AccionControlVO nuevaAccionControlVo = new AccionControlVO(accionControlDao.actualizar(conversionVoEntidad.convertir(accionControlVo)));
        if(accionControlVo.getElementoRetiradoAccListVo() != null) {
            for(ElementoRetiradoAccVO elemento : accionControlVo.getElementoRetiradoAccListVo()) {
                elemento.setAccionControlVo(nuevaAccionControlVo);
                if(elemento.getElrCodigo() == null) {
                    elementoRetiradoAccDao.insertarSiiElementoRetiradoAcc(conversionVoEntidad.convertir(elemento));
                }
                else {
                    elementoRetiradoAccDao.actualizar(conversionVoEntidad.convertir(elemento));
                }
            }
        }
        if(accionControlVo.getPersonaAtiendeAccListVo() != null) {
            for(PersonaAtiendeAccVO persona : accionControlVo.getPersonaAtiendeAccListVo()) {
                persona.setAccionControlVo(nuevaAccionControlVo);
                if (persona.getDireccionPersonaAtienListVo()!=null){
                    for(DireccionPersonaAtienVO direccion : persona.getDireccionPersonaAtienListVo()) {
                        if(direccion.getUsuarioConectVo() == null) {
                            direccion.setUsuarioConectVo(usuarioVo);
                        }
                    }  
                }
                
                SiiPersonaAtiendeAcc personaGuardada;
                if(persona.getPeaCodigo() == null) {
                    personaGuardada = personaAtiendeAccDao.insertarSiiPersonaAtiendeAcc(conversionVoEntidad.convertir(persona));
                }
                else {
                    personaGuardada = personaAtiendeAccDao.actualizar(conversionVoEntidad.convertir(persona));
                }
                guardarDireccionesPersonaAtiendeAcc(persona, personaGuardada);                

            }

        }

        return nuevaAccionControlVo;
    }

    private void guardarDireccionesPersonaAtiendeAcc(PersonaAtiendeAccVO persona, SiiPersonaAtiendeAcc personaGuardada) throws ExcepcionDAO {
        if (persona.getDireccionPersonaAtienListVo()!=null) {
            for(DireccionPersonaAtienVO direccion : persona.getDireccionPersonaAtienListVo()) {
                if (direccion.getPersonaAtiendeAccVo().getPeaCodigo()==null) {
                    direccion.getPersonaAtiendeAccVo().setPeaCodigo(personaGuardada.getPeaCodigo());
                }
                if(direccion.getDpaCodigo() == null) {
                    direccionPersonaAtienDao.insertarSiiDireccionPersonaAtien(conversionVoEntidad.convertir(direccion));
                }
                else {
                    direccionPersonaAtienDao.actualizar(conversionVoEntidad.convertir(direccion));
                }
            }
        }
    }

    public AccionControlVO buscarAccionControlXId(Long codigo) throws ExcepcionDAO {
        return new AccionControlVO(accionControlDao.buscarPorCodigo(codigo));
    }
}


