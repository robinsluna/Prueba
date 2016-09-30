/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 07-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz que maneja las personas investigadas
 * @author Paola Andrea Rueda León
 */

@Local
public interface AdminPersonaInvestProIle {
    /**
     * Insertar la persona investigada del proceso sancionatorio de ilegalidad a la base de datos.
     * @param personaInvestProIleVo
     * @return resultado - PersonaInvestProIleVO insertada
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public PersonaInvestProIleVO insertarPersonaInvestProIle(PersonaInvestProIleVO personaInvestProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    
    
    /**
     * Actualiza la persona investigada del proceso sancionatorio de ilegalidad en la base de datos.
     * @param personaInvestProIleVo
     * @param cascadeUpdate
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public PersonaInvestProIleVO actualizarPersonaInvestProIle(PersonaInvestProIleVO personaInvestProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    
    
    public List<PersonaInvestProIleVO> buscarPersonasInvestPorProcesoIleId(Long prsCodigo) throws ExcepcionDAO, ExcepcionAplicacion;
}
