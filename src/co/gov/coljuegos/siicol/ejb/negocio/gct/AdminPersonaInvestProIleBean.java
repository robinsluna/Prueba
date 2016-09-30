/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 07-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.contratacion.AdminPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvestProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ComunicResolPersIleVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcePerIleVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO;

import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean que maneja las personas investigadas del proceso sancionatorio de ilegalidad
 * @author Paola Andrea Rueda León
 */
@Stateless
public class AdminPersonaInvestProIleBean implements AdminPersonaInvestProIle {

    @EJB
    private PersonaInvestProIleDAO personaInvestProIleDao;
    @EJB
    private AdminComunicResolPersIle adminComunicResolPersIle;
    @EJB
    private AdminDireccionProcePerIle adminDireccionProcePerIle;
    @EJB
    private AdminPersona adminPersona;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor
     */
    public AdminPersonaInvestProIleBean() {
        super();
    }

    /**
     * Persisitir la comunicación de la resolución de personas investigadas
     * @param personaInvestProIleVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirComunicResolPersIleList(PersonaInvestProIleVO personaInvestProIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if(personaInvestProIleVo != null && personaInvestProIleVo.getComunicResolPersIleListVo() != null) {
            for(ComunicResolPersIleVO crpiVo : personaInvestProIleVo.getComunicResolPersIleListVo()) {
                if(crpiVo != null) {
                    crpiVo.setPersonaInvestProIleVo(personaInvestProIleVo);

                    if(personaInvestProIleVo.getPipCodigo() == null) {
                        // OPERACION INSERTAR
                        adminComunicResolPersIle.insertarComunicResolPersIle(crpiVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminComunicResolPersIle.actualizarComunicResolPersIle(crpiVo);
                    }
                }
            }
        }
    }
    

    /**
     * Persistir las direcciones procesales de las personas investigadas de un proceso sancionatorio de ilegalidad
     * @param personaInvestProIleVo - persona investigada
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirDireccionProcePerIleListVo(PersonaInvestProIleVO personaInvestProIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if(personaInvestProIleVo != null && personaInvestProIleVo.getDireccionProcePerIleListVo() != null) {
            for(DireccionProcePerIleVO dppiVo : personaInvestProIleVo.getDireccionProcePerIleListVo()) {
                if(dppiVo != null) {
                    dppiVo.setPersonaInvestProIleVo(personaInvestProIleVo);

                    if(dppiVo.getDipCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDireccionProcePerIle.insertarDireccionProcePerIle(dppiVo, true);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminDireccionProcePerIle.actualizarDireccionProcePerIle(dppiVo);
                    }
                }
            }
        }
    }

    /**
     * Persistir PersonaVO
     * @param personaInvestProIleVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private PersonaVO persistirPersonaVo(PersonaInvestProIleVO personaInvestProIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        PersonaVO personaVo = new PersonaVO();

        if(personaInvestProIleVo.getPersonaVo().getPerCodigo() == null) {
            // OPERACION INSERTAR
            personaVo = adminPersona.insertarPersona(true, personaInvestProIleVo.getPersonaVo());
        }
        else {
            // OPERACION ACTUALIZAR
            personaVo = adminPersona.actualizarPersona(personaInvestProIleVo.getPersonaVo());

        }

        return personaVo;
    }

    /**
     * Asignar los hijos del objeto persona investigada
     * @param resultado
     * @param personaInvestProIleVo
     */

    private void asignarHijos(PersonaInvestProIleVO resultado, PersonaInvestProIleVO personaInvestProIleVo) {
        if(resultado != null && personaInvestProIleVo != null) {

            // establecer hijos
            resultado.setPersonaVo(personaInvestProIleVo.getPersonaVo());
            resultado.setUsuarioConecVo(personaInvestProIleVo.getUsuarioConecVo());

            // establecer las listas a persistir
            resultado.setComunicResolPersIleListVo(personaInvestProIleVo.getComunicResolPersIleListVo());
            resultado.setDireccionProcePerIleListVo(personaInvestProIleVo.getDireccionProcePerIleListVo());
            resultado.setPersonaInvProIleAutoListVo(personaInvestProIleVo.getPersonaInvProIleAutoListVo());
        }
    }

    /**
     * Persistir los hijos de la entidad persona investigada
     * @param personaInvestProIleVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirHijos(PersonaInvestProIleVO personaInvestProIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirComunicResolPersIleList(personaInvestProIleVo);
        this.persistirDireccionProcePerIleListVo(personaInvestProIleVo);
    }


    /**
     * Insertar la persona investigada del proceso sancionatorio de ilegalidad a la base de datos
     * @param personaInvestProIleVo
     * @return resultado - PersonaInvestProIleVO insertada
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public PersonaInvestProIleVO insertarPersonaInvestProIle(PersonaInvestProIleVO personaInvestProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        PersonaInvestProIleVO resultado = null;

        try {

            if(cascadeUpdate) {
                if(personaInvestProIleVo.getPipCreada().equals(EnumDecision.SI.getId())){
                    personaInvestProIleVo.setPersonaVo(this.persistirPersonaVo(personaInvestProIleVo));
                }
            }

            SiiPersonaInvestProIle siiPersonaInvestProIleVo = personaInvestProIleDao.insertar(conversionVoEntidad.convertir(personaInvestProIleVo));
            if(siiPersonaInvestProIleVo != null) {
                resultado = new PersonaInvestProIleVO(siiPersonaInvestProIleVo);
            }

            if(cascadeUpdate) {
                this.asignarHijos(resultado, personaInvestProIleVo);
                this.persistirHijos(resultado);
            }
        } catch(ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Persona Investigada: " + e.getMessage());
        }

        return (resultado);
    }

    public List<PersonaInvestProIleVO> buscarPersonasInvestPorProcesoIleId(Long prsCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        List<PersonaInvestProIleVO> personas = new ArrayList<PersonaInvestProIleVO>();

        for(SiiPersonaInvestProIle persona : personaInvestProIleDao.buscarPersonasInvestPorProcesoIleId(prsCodigo)) {
            personas.add(new PersonaInvestProIleVO(persona));
        }

        return personas;
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.negocio.gct.AdminPersonaInvestProIle#actualizarPersonaInvestProIle(co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO, boolean)
     */
    @Override
    public PersonaInvestProIleVO actualizarPersonaInvestProIle(PersonaInvestProIleVO personaInvestProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        PersonaInvestProIleVO resultado = null;

        try {
            SiiPersonaInvestProIle siiPersonaInvestProIleVo = personaInvestProIleDao.actualizar(conversionVoEntidad.convertir(personaInvestProIleVo));
            if(siiPersonaInvestProIleVo != null) {
                resultado = new PersonaInvestProIleVO(siiPersonaInvestProIleVo);

                if(cascadeUpdate) {
                    this.asignarHijos(resultado, personaInvestProIleVo);
                    this.persistirHijos(resultado);
                    adminPersona.actualizarPersona(personaInvestProIleVo.getPersonaVo());
                }
            }
        } catch(ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Persona Investigada: " + e.getMessage());
        }

        return (resultado);
    }
}
