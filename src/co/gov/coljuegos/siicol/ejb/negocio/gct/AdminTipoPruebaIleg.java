package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoPruebaIlegVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tipos de Pruebas para Procesos Sancionatorios de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoPruebaIleg 
{
    public TipoPruebaIlegVO buscarTipoPruebaIlegPorId (Long tpiCodigo) throws ExcepcionDAO;
    public List<TipoPruebaIlegVO> buscarTodoTipoPruebaIleg () throws ExcepcionDAO;
}
