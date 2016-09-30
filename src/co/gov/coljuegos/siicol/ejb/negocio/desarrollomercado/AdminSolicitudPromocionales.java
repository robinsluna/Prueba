/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Desarrollo de Mercados
 * AUTOR	: Walter Becerra
 * FECHA	: 24-11-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.vo.CierreRecaudoVO;

import co.gov.coljuegos.siicol.ejb.vo.ExpedienteDocumVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedienteDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPromocionalesVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminSolicitudPromocionales {
    
    public SolicitudPromocionalesVO insertarSiiRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo) throws ExcepcionDAO;

    public SolicitudPromocionalesVO  buscarPorCodigoRifaPromocional(Long idRec)  throws ExcepcionDAO;

    public List<SolicitudPromocionalesVO> buscarTodoSiiRifaPromocional(Long tipoApuesta)  throws ExcepcionDAO;
    
    public List<SolicitudPromocionalesVO> buscarTodoSiiRifaPromoPorRol(String rol, String tipoApuesta,Long usuCodigo) throws ExcepcionDAO;       
    
    public SolicitudPromocionalesVO actualizarRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo) throws ExcepcionDAO;
    
    public SolicitudPromocionalesVO aprobarPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo, UsuarioVO usuarioVo) throws ExcepcionDAO ;
    
    public SolicitudPromocionalesVO aprobarRifa(SolicitudPromocionalesVO solicitudPromocionalesVo, UsuarioVO usuarioVo) throws ExcepcionDAO ;
    
    public SolicitudPromocionalesVO desistimientoRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo, UsuarioVO usuarioVo) throws ExcepcionDAO;
    
    public ExpedienteDocumVO buscarExpedienteDocumPorId(String idExpedienteDocum) throws ExcepcionDAO ;
    
    public SolicitudPromocionalesVO insertarCuotaOperadorPromocionales(SolicitudPromocionalesVO solicitudPromocionalesVo  )throws ExcepcionDAO ;
    
    public String  siguienteNumeroRifaPromocional() throws ExcepcionDAO ;
    
    public List<SolicitudPromocionalesVO> buscarTodoRifaPromocionalTransferenciaBan()  throws ExcepcionDAO;
    
    public List<SolicitudPromocionalesVO> buscarRifaPromocionalTransFerenciaBan(Long idTrasBanco) throws ExcepcionDAO ;
       
     
}
