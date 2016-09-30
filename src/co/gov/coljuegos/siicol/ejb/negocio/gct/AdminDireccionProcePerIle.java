/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 17-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcePerIleVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz que gestiona las direcciones procesales de las personas investigadas
 * @author Paola Andrea Rueda León
 */

@Local
public interface AdminDireccionProcePerIle {

    /**
     * Insertar la dirección procesal de la persona investigada en la BD
     * @param direccionProcePerIleVo
     * @return resultado - DireccionProcePerIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    DireccionProcePerIleVO insertarDireccionProcePerIle(DireccionProcePerIleVO direccionProcePerIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     * Actualizar la dirección procesal de la persona investigada del proceso de ilegalidad
     * @param direccionProcePerIleVo
     * @return resultado - DireccionProcePerIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public DireccionProcePerIleVO actualizarDireccionProcePerIle(DireccionProcePerIleVO direccionProcePerIleVo) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     * Buscar las direcciones procesales según id de la persona investigada
     * @param pipCodigo
     * @return resultado - Lista de DireccionProcePerIleVO
     * @throws ExcepcionDAO
     */

    public List<DireccionProcePerIleVO> buscarDireccionProcePerIleXIdPerInvest(Long pipCodigo) throws ExcepcionDAO;


}
