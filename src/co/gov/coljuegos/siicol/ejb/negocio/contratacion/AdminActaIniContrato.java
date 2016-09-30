package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ActaIniContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasDocumentosVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeActaIniVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminActaIniContrato {

    public ActaIniContratoVO actualizarActaIniContrato(ActaIniContratoVO actaIniContratoVo) throws ExcepcionDAO;

    public ActaIniContratoVO buscarActaIniContratoPorProceso(Long prcCodigo) throws ExcepcionDAO;

    public ActaIniContratoVO guardarActaIniContrato(ActaIniContratoVO actaIniContratoVo, UsuarioVO usuarioLogueado,
                                                    boolean cambioEstado,
                                                    List<FirmasRequeridasDocumentosVO> listaFirmaRequeridasDocumentoVo,
                                                    List<FirmaDocumentoVO> listaFirmaDocumentoVo,
                                                    List<InformeActaIniVO> listaInformeActaIniInicial) throws ExcepcionDAO;


}
