/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionUbicaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoConpesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocConpesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionUbica;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionUbicaVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoConpesVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocConpesVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminDocumentoConpesBean implements AdminDocumentoConpes {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DocumentoConpesDAO documentoConpesDao;
    @EJB
    private EstadoDocConpesDAO estadoDocConpesDao;
    @EJB
    private DistribucionUbicaDAO distribucionUbicaDao;
    @EJB
    private EnteTerritorialDAO enteTerritorialDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminDocumentoConpesBean() {

    }

    public List<DocumentoConpesVO> buscarTodosDocumentoConpes() throws ExcepcionDAO {
        List<SiiDocumentoConpes> listaSiiDocumentoConpes = documentoConpesDao.buscarTodosDocumentoConpes();
        List<DocumentoConpesVO> listaDocumentoConpesVo = new ArrayList();
        for (SiiDocumentoConpes unaSiiDocumentoConpes : listaSiiDocumentoConpes) {
            SiiEstadoDocConpes siiEstadoDocConpes =
                estadoDocConpesDao.buscarEstadoDocConpesPorId(unaSiiDocumentoConpes.getSiiEstadoDocConpes().getEdcCodigo());
            unaSiiDocumentoConpes.setSiiEstadoDocConpes(siiEstadoDocConpes);
            DocumentoConpesVO nuevaDocumentoConpesVo = new DocumentoConpesVO(unaSiiDocumentoConpes);
            listaDocumentoConpesVo.add(nuevaDocumentoConpesVo);
        }
        return listaDocumentoConpesVo;
    }

    public DocumentoConpesVO buscarDocumentoConpesPorId(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO {
        DocumentoConpesVO undocumentoConpesVo;
        SiiDocumentoConpes siiDocumentoConpes =
            documentoConpesDao.buscarDocumentoConpesPorId(documentoConpesVo.getDcnCodigo());
        if (siiDocumentoConpes != null)
            undocumentoConpesVo = new DocumentoConpesVO(siiDocumentoConpes);
        else
            undocumentoConpesVo = new DocumentoConpesVO();
        return undocumentoConpesVo;
    }

    public DocumentoConpesVO insertarDocumentoConpes(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO {
        documentoConpesVo.setDcnActivo("N");
        SiiDocumentoConpes siiDocumentoConpes = conversionVoEntidad.convertir(documentoConpesVo);
        siiDocumentoConpes = documentoConpesDao.insertarDocumentoConpes(siiDocumentoConpes);
        for (DistribucionUbicaVO unDistribucionUbicaVO : documentoConpesVo.getListaDistribucionUbicaVo()) {
            SiiDistribucionUbica siiDistribucionUbica = conversionVoEntidad.convertir(unDistribucionUbicaVO);
            siiDistribucionUbica.setSiiDocumentoConpes(siiDocumentoConpes);
            siiDistribucionUbica = distribucionUbicaDao.insertarDistribucionUbica(siiDistribucionUbica);
        }
        DocumentoConpesVO undocumentoConpesVo = new DocumentoConpesVO(siiDocumentoConpes);
        return undocumentoConpesVo;
    }

    /**
     * @author Modifica Giovanni
     * @param documentoConpesVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public DocumentoConpesVO actualizarDocumentoConpes(DocumentoConpesVO documentoConpesVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                         ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiDocumentoConpes siiDocumentoConpesTemp = new SiiDocumentoConpes();
        siiDocumentoConpesTemp = documentoConpesDao.buscarDocumentoConpesPorId(documentoConpesVo.getDcnCodigo());
        if (siiDocumentoConpesTemp.getSiiEstadoDocConpes().getEdcCodigo() != documentoConpesVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del documento conpes fue cambiado durante la modificación. Seleccione nuevamente el documento conpes");
        }*/
        
        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (documentoConpesVo.getEstadoDocConpesVo().getEdcCodigo() != documentoConpesVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DOCUMENTO_CONPES.getId(),
                                                         documentoConpesVo.getEstadoDocConpesVo().getEdcCodigo(),
                                                         usuarioLogueado, documentoConpesVo.getDcnCodigo());
        }

        DocumentoConpesVO unDocumentoConpesVo = new DocumentoConpesVO();
        if (documentoConpesVo.getEstadoDocConpesVo().getEdcNombre().equals("DESCARTADO")) {
            SiiDocumentoConpes siiDocumentoConpes = conversionVoEntidad.convertir(documentoConpesVo);
            unDocumentoConpesVo =
                new DocumentoConpesVO(documentoConpesDao.actualizarDocumentoConpes(siiDocumentoConpes));
        } else {
            SiiDocumentoConpes siiDocumentoConpesActivo = documentoConpesDao.buscarDocumentoConpesActivo();
            if (siiDocumentoConpesActivo != null) {
                siiDocumentoConpesActivo.setDcnActivo("N");
                documentoConpesDao.actualizarDocumentoConpes(siiDocumentoConpesActivo);

                documentoConpesVo.setDcnActivo("S");
                SiiDocumentoConpes siiDocumentoConpes = conversionVoEntidad.convertir(documentoConpesVo);
                unDocumentoConpesVo =
                    new DocumentoConpesVO(documentoConpesDao.actualizarDocumentoConpes(siiDocumentoConpes));
            } else {
                documentoConpesVo.setDcnActivo("S");
                SiiDocumentoConpes siiDocumentoConpes = conversionVoEntidad.convertir(documentoConpesVo);
                unDocumentoConpesVo =
                    new DocumentoConpesVO(documentoConpesDao.actualizarDocumentoConpes(siiDocumentoConpes));
            }

        }
        return unDocumentoConpesVo;
    }

    public List<DocumentoConpesVO> buscarTodosDocumentoConpesXNumeroYVigencia(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO {
        List<SiiDocumentoConpes> listaSiiDocumentoConpes =
            documentoConpesDao.buscarTodosDocumentoConpesXNumeroYVigencia(documentoConpesVo.getDcnFecha(),
                                                                          documentoConpesVo.getDcnNumero());
        List<DocumentoConpesVO> listaDocumentoConpesVo = new ArrayList();
        for (SiiDocumentoConpes unaSiiDocumentoConpes : listaSiiDocumentoConpes) {
            DocumentoConpesVO nuevaDocumentoConpesVo = new DocumentoConpesVO(unaSiiDocumentoConpes);
            listaDocumentoConpesVo.add(nuevaDocumentoConpesVo);
        }

        return listaDocumentoConpesVo;

    }

    public EstadoDocConpesVO buscarEstadoDocConpesXNombre(EstadoDocConpesVO estadoDocConpesVo) throws ExcepcionDAO {
        SiiEstadoDocConpes siiEstadoDocConpes =
            estadoDocConpesDao.buscarEstadoDocConpesXNombre(estadoDocConpesVo.getEdcNombre());
        return new EstadoDocConpesVO(siiEstadoDocConpes);
    }

    public DocumentoConpesVO buscarDocumentoConpesActivo() throws ExcepcionDAO {
        SiiDocumentoConpes siiDocumentoConpes = null;
        DocumentoConpesVO unDocumentoConpesVo;
        siiDocumentoConpes = documentoConpesDao.buscarDocumentoConpesActivo();

        if (siiDocumentoConpes.getDcnCodigo() != null)
            unDocumentoConpesVo = new DocumentoConpesVO(siiDocumentoConpes);
        else
            unDocumentoConpesVo = null;

        return unDocumentoConpesVo;


    }

    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String idUbicacion) throws ExcepcionDAO {
        EnteTerritorialVO unEnteTerritorialVo;
        SiiEnteTerritorial siiEnteterritorial = enteTerritorialDao.buscarEnteTerritorialXIdUbicacion(idUbicacion);
        if (siiEnteterritorial != null)
            unEnteTerritorialVo = new EnteTerritorialVO(siiEnteterritorial);
        else
            unEnteTerritorialVo = null;

        return unEnteTerritorialVo;
    }

    public List<DistribucionUbicaVO> buscarDistribucionUbicaXIdDocConpes(Long idDocCompes) throws ExcepcionDAO {
        List<SiiDistribucionUbica> listasiiDistribucionUbica = new ArrayList<SiiDistribucionUbica>();
        List<DistribucionUbicaVO> listaDistribucionUbicaVo = new ArrayList<DistribucionUbicaVO>();
        listasiiDistribucionUbica = distribucionUbicaDao.buscarDistribucionUbicaXIdDocConpes(idDocCompes);
        for (SiiDistribucionUbica unaSiiDistribucionUbicaVo : listasiiDistribucionUbica) {
            DistribucionUbicaVO unDistribucionUbicaVo = new DistribucionUbicaVO(unaSiiDistribucionUbicaVo);
            listaDistribucionUbicaVo.add(unDistribucionUbicaVo);
        }
        return listaDistribucionUbicaVo;


    }


}
