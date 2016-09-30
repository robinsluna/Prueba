package co.gov.coljuegos.siicol.ejb.negocio.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.MovCargueInventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.SiitoConsultaInvSiicolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoConsultaInvSiicol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueInventario;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminSiitoBean implements AdminSiito {

    @EJB
    private MovCargueInventarioDAO movCargueInventarioDAO;
    @EJB
    private SiitoConsultaInvSiicolDAO siitoConsultaInvSiicolDAO;

    /**
     *Metodo encargado de consulta la tabla intermedia entre siicol y siito para traer el lista
     * de inventarios que tengan el numero siito y el codigo de movimiento
     * @param solicitudAutorizaWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public List<MovCargueInventarioWSVO> consultarListaInventarioTablaIntermediaSiito(SolicitudAutorizaWSVO solicitudAutorizaWSVO) throws ExcepcionDAO,
                              
                                                                                                                                          Exception {

        if (solicitudAutorizaWSVO.numeroSiito == null || solicitudAutorizaWSVO.numeroSiito.equals("")) {
            throw new Exception("El numero siito no puede ser nulo por favor verifique.");
        }

        if (solicitudAutorizaWSVO.codigoMovimiento == null || solicitudAutorizaWSVO.codigoMovimiento.equals("")) {
            throw new Exception("El codigo de movimiento no puede ser nulo por favor verifique.");
        }

        if (solicitudAutorizaWSVO.radicado == null || solicitudAutorizaWSVO.radicado.equals("")) {
            throw new Exception("El codigo del radicado no puede ser nulo por favor verifique.");
        }

        /*
         * Consultamos por el codigo de movimiento y por el codigo de la solicitud en la tabla intermedia entre las dos aplicaciones que almacena la informacion pertinente a los inventarios
         */
        List<SiitoMovCargueInventario> listaInventario = new ArrayList<SiitoMovCargueInventario>();
        List<MovCargueInventarioWSVO> listaInventarioWSVO = new ArrayList<MovCargueInventarioWSVO>();
        listaInventario = 
            movCargueInventarioDAO.consultarMovCargueInventarioXCodSolicitudYCodigoMov(Long.parseLong(solicitudAutorizaWSVO.radicado),
                                                                                       solicitudAutorizaWSVO.tipoSolicitud);

        for (SiitoMovCargueInventario siitoMovCargueInventario : listaInventario) {
            MovCargueInventarioWSVO movCargueInventarioWSVO = new MovCargueInventarioWSVO();

            movCargueInventarioWSVO.movCargueInvAnoFab = siitoMovCargueInventario.getMovCargueInvAnoFab();
            movCargueInventarioWSVO.movCargueInvCantSillas = siitoMovCargueInventario.getMovCargueInvCantSillas();
            movCargueInventarioWSVO.movCargueInvCodigo = siitoMovCargueInventario.getMovCargueInvCodigo();
            movCargueInventarioWSVO.movCargueInvCodApuesta = siitoMovCargueInventario.getMovCargueInvCodApuesta();
            movCargueInventarioWSVO.movCargueInvCodApuestaNew = siitoMovCargueInventario.getMovCargueInvCodApuestaNew();
            movCargueInventarioWSVO.movCargueInvCodGestDoc = siitoMovCargueInventario.getMovCargueInvCodGestDoc();
            movCargueInventarioWSVO.movCargueInvCodLocal = siitoMovCargueInventario.getMovCargueInvCodLocal();
            movCargueInventarioWSVO.movCargueInvCodLocalDest = siitoMovCargueInventario.getMovCargueInvCodLocalDest();
            movCargueInventarioWSVO.movCargueInvCodMarca = siitoMovCargueInventario.getMovCargueInvCodMarca();
            movCargueInventarioWSVO.movCargueInvCodModelo = siitoMovCargueInventario.getMovCargueInvCodModelo();
            movCargueInventarioWSVO.movCargueInvCodMunLoc = siitoMovCargueInventario.getMovCargueInvCodMunLoc();
            movCargueInventarioWSVO.movCargueInvCodMunLocDest = siitoMovCargueInventario.getMovCargueInvCodMunLocDest();
            if (siitoMovCargueInventario.getMovCargueInvCont() != null){
                movCargueInventarioWSVO.movCargueInvCont = siitoMovCargueInventario.getMovCargueInvCont();
                
            }
            movCargueInventarioWSVO.movCargueInvDirBarrio = siitoMovCargueInventario.getMovCargueInvDirBarrio();
            movCargueInventarioWSVO.movCargueInvDirDesc = siitoMovCargueInventario.getMovCargueInvDirDesc();
            movCargueInventarioWSVO.movCargueInvDirInfoAdi = siitoMovCargueInventario.getMovCargueInvDirInfoAdi();
            movCargueInventarioWSVO.movCargueInvDirNumPre = siitoMovCargueInventario.getMovCargueInvDirNumPre();
            movCargueInventarioWSVO.movCargueInvDirNumViaG = siitoMovCargueInventario.getMovCargueInvDirNumViaG();
            movCargueInventarioWSVO.movCargueInvDirNumViaP = siitoMovCargueInventario.getMovCargueInvDirNumViaP();
            movCargueInventarioWSVO.movCargueInvDirSecCiu = siitoMovCargueInventario.getMovCargueInvDirSecCiu();
            movCargueInventarioWSVO.movCargueInvDirSufiViaG = siitoMovCargueInventario.getMovCargueInvDirSufiViaG();
            movCargueInventarioWSVO.movCargueInvDirSufiViaP = siitoMovCargueInventario.getMovCargueInvDirSufiViaP();
            movCargueInventarioWSVO.movCargueInvDirViaPriCod = siitoMovCargueInventario.getMovCargueInvDirViaPriCod();
            movCargueInventarioWSVO.movCargueInvEstUbiInst = siitoMovCargueInventario.getMovCargueInvEstUbiInst();
            movCargueInventarioWSVO.movCargueInvFechSol = siitoMovCargueInventario.getMovCargueInvFechSol();
            movCargueInventarioWSVO.movCargueInvIndAmpDis = siitoMovCargueInventario.getMovCargueInvIndAmpDis();
            movCargueInventarioWSVO.movCargueInvIndDup = siitoMovCargueInventario.getMovCargueInvIndDup();
            movCargueInventarioWSVO.movCargueInvIndIle = siitoMovCargueInventario.getMovCargueInvIndIle();
            movCargueInventarioWSVO.movCargueInvIndImpTip1 = siitoMovCargueInventario.getMovCargueInvIndImpTip1();
            movCargueInventarioWSVO.movCargueInvIndImpTip2 = siitoMovCargueInventario.getMovCargueInvIndImpTip2();
            movCargueInventarioWSVO.movCargueInvIndInstHomo = siitoMovCargueInventario.getMovCargueInvIndInstHomo();
            movCargueInventarioWSVO.movCargueInvIndInstSclmIn = siitoMovCargueInventario.getMovCargueInvIndInstSclmIn();
            movCargueInventarioWSVO.movCargueInvIucAd = siitoMovCargueInventario.getMovCargueInvIucAd();
            movCargueInventarioWSVO.movCargueInvIucRet = siitoMovCargueInventario.getMovCargueInvIucRet();
            movCargueInventarioWSVO.movCargueInvLatEstableci = siitoMovCargueInventario.getMovCargueInvLatEstableci();
            movCargueInventarioWSVO.movCargueInvLonEstableci = siitoMovCargueInventario.getMovCargueInvLonEstableci();
            movCargueInventarioWSVO.movCargueInvModJuego = siitoMovCargueInventario.getMovCargueInvModJuego();
            movCargueInventarioWSVO.movCargueInvNit = siitoMovCargueInventario.getMovCargueInvNit();
            movCargueInventarioWSVO.movCargueInvNomLocal = siitoMovCargueInventario.getMovCargueInvNomLocal();
            movCargueInventarioWSVO.movCargueInvNomLocalDest = siitoMovCargueInventario.getMovCargueInvNomLocalDest();
            movCargueInventarioWSVO.movCargueInvNuidAd = siitoMovCargueInventario.getMovCargueInvNuidAd();
            movCargueInventarioWSVO.movCargueInvNuidRet = siitoMovCargueInventario.getMovCargueInvNuidRet();
            movCargueInventarioWSVO.movCargueInvNumFab = siitoMovCargueInventario.getMovCargueInvNumFab();
            movCargueInventarioWSVO.movCargueInvNumFabSclm = siitoMovCargueInventario.getMovCargueInvNumFabSclm();
            movCargueInventarioWSVO.movCargueInvSerialInstAd = siitoMovCargueInventario.getMovCargueInvSerialInstAd();
            movCargueInventarioWSVO.movCargueInvSerialInstRet = siitoMovCargueInventario.getMovCargueInvSerialInstRet();
            movCargueInventarioWSVO.movCargueInvTenLegal = siitoMovCargueInventario.getMovCargueInvTenLegal();
            movCargueInventarioWSVO.movCargueInvTipInst = siitoMovCargueInventario.getMovCargueInvTipInst();
            movCargueInventarioWSVO.movCargueInvTipJuegos = siitoMovCargueInventario.getMovCargueInvTipJuegos();
            movCargueInventarioWSVO.movCargueInvTipNov = siitoMovCargueInventario.getMovCargueInvTipNov();
            movCargueInventarioWSVO.movCargueInvTipSolCodigo = siitoMovCargueInventario.getMovCargueInvTipSolCodigo();
            movCargueInventarioWSVO.movCargueInvVlrCarton = siitoMovCargueInventario.getMovCargueInvVlrCarton();
            movCargueInventarioWSVO.movCargueInvVlrInd = siitoMovCargueInventario.getMovCargueInvVlrInd();
            movCargueInventarioWSVO.movSolCodigo = siitoMovCargueInventario.getMovSolCodigo();
            movCargueInventarioWSVO.movSolSiito = siitoMovCargueInventario.getMovSolSiito();
            movCargueInventarioWSVO.movCargueInvNumLic = siitoMovCargueInventario.getMovCargueInvNumLic();
            movCargueInventarioWSVO.movCargueInvCantTerm = siitoMovCargueInventario.getMovCargueInvCantTerm();            
            
            listaInventarioWSVO.add(movCargueInventarioWSVO);
        }

        return listaInventarioWSVO;
    }

    public String insertarInventarioTablaIntermediaConsultaSiito(List<ConsultaInventarioWSVO> inventario, String acure) throws ExcepcionDAO,
                                                                                                       Exception {
        String retorno = siitoConsultaInvSiicolDAO.insertarInventarioTablaIntermediaConsultaSiito(inventario,acure);

        return retorno;
    }
    
   public boolean insertarSiitoConsultaInvSiicol(SiitoConsultaInvSiicol entidad) throws ExcepcionDAO{
        boolean retorno = siitoConsultaInvSiicolDAO.insertarSiitoConsultaInvSiicol(entidad);
        return retorno;
    }
   
   public boolean insertarSiitoConsultaInvSiicol(List<SiiInventario> entidad) throws Exception,ExcepcionDAO{
    boolean retorno = siitoConsultaInvSiicolDAO.insertarSiitoConsultaInvSiicol(entidad);
    return retorno;  
}
    
    public boolean borrarInventarioSiicolASincronizar()throws ExcepcionDAO,Exception {
        boolean retorno = siitoConsultaInvSiicolDAO.borrarInventarioSiicolASincronizar();  
        return retorno;
    }

}
