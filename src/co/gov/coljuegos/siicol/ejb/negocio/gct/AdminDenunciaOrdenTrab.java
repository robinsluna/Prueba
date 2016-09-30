/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;

import java.util.List;

/**
 * Interface de AdminDenunciaOrdenTrab
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public interface AdminDenunciaOrdenTrab {

    public DenunciaOrdenTrabVO insertarDenunciaOrdenTrab(DenunciaOrdenTrabVO denunciaOrdenTrabVo) throws ExcepcionDAO;

    public DenunciaOrdenTrabVO actualizarDenunciaOrdenTrab(DenunciaOrdenTrabVO denunciaOrdenTrabVo) throws ExcepcionDAO;

    public List<DenunciaVO> buscarDenunciasXPendienteTrabajoCampoNoAgregadas(List<DenunciaVO> listaSeleccionDenuncia) throws ExcepcionDAO;

    public List<DenunciaVO> buscarDenunciasXOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO;

    /**
     * Buscar todas las denuncias de orden de trabajo, según id de orden de trabajo y id de denuncia.
     * @param otvCodigo
     * @param denCodigo
     * @return resultado - Lista de denuncias de orden de trabajo
     * @throws ExcepcionDAO
     */

    public DenunciaOrdenTrabVO buscarDenunciaOrdTrabXIdOrdTrabXIdDenuncia(Long otvCodigo,
                                                                          Long denCodigo) throws ExcepcionDAO;
}
