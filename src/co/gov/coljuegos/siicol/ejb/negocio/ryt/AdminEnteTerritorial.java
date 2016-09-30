/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Camilo Miranda
 * FECHA	: 21-05-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Entes Territoriales.
 * @author Camilo Miranda
 */
@Local
public interface AdminEnteTerritorial 
{
    public EnteTerritorialVO buscarEnteTerritorialPorId (Long etiCodigo) throws ExcepcionDAO;
    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String ubiCodigo) throws ExcepcionDAO;
    public EnteTerritorialVO buscarEnteTerritorialPorUbicacion (String ubiCodigo) throws ExcepcionDAO;
}
