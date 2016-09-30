package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumSoporModifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContratacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPlanConItemPlanDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionPlanContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPlanConItemPlanDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionPlanCont;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DocumSoporModifVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.ModPlanConItemPlanDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionPlanContVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminModificacionPlanContBean implements AdminModificacionPlanCont {
    @EJB
    ModificacionPlanContDAO modificacionPlanContDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    DocumSoporModifDAO documSoporModifDao;
    @EJB
    ItemPlanContratacDAO itemPlanContratacDao;
    @EJB
    ModPlanConItemPlanDetRubDAO modPlanConItemPlanDetRubDao;
    @EJB
    ItemPlanContDetRubDAO itemPlanContDetRubDao;
    @EJB
    AdminDocumSoporModif adminDocumSoporModif;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;

    public AdminModificacionPlanContBean() {

    }

    public List<ModificacionPlanContVO> buscarTrasladosPlanContEnTramite() throws ExcepcionDAO {
        List<ModificacionPlanContVO> listaVo = new ArrayList<ModificacionPlanContVO>();
        for(SiiModificacionPlanCont modif : modificacionPlanContDao.buscarTrasladosPlanContEnTramite()) {
            ModificacionPlanContVO modifVo = new ModificacionPlanContVO(modif);
            if(modifVo.getDocumSoporModifListVo() == null || modifVo.getDocumSoporModifListVo().size() == 0) {
                modifVo.setDocumSoporModifListVo(adminDocumSoporModif.documentosSoportePorModif(modifVo.getMpcCodigo()));
            }
            if(modifVo.getDocumSoporModifListVo() != null && modifVo.getDocumSoporModifListVo().size() > 0) {
                modifVo.setDocumSoporModifVo(modifVo.getDocumSoporModifListVo().get(0));
            }
            listaVo.add(modifVo);
        }
        return listaVo;
    }

    public ModificacionPlanContVO actualizarTraslado(ModificacionPlanContVO modificacionPlanContVo, UsuarioVO usuarioVO, boolean cambioEstado) throws ExcepcionDAO {
        List<DocumSoporModifVO> documSoporModifListVo = modificacionPlanContVo.getDocumSoporModifListVo();
        List<ItemPlanContratacVO> itemPlanContratacListVo = modificacionPlanContVo.getItemPlanContratacListVo();
        List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubListVo = modificacionPlanContVo.getModPlanConItemPlanDetRubListVo();

        modificacionPlanContVo = new ModificacionPlanContVO(modificacionPlanContDao.actualizarModificacionPlanCont(conversionVoEntidad.convertir(modificacionPlanContVo)));
        actualizarDocumSoporModif(modificacionPlanContVo, documSoporModifListVo.get(0));
        if(itemPlanContratacListVo.size() == 0) {
            List<SiiItemPlanContratac> itemPlanContratacList = itemPlanContratacDao.itemsPlanContratacionPorModificacion(modificacionPlanContVo.getMpcCodigo());
            for(SiiItemPlanContratac itemPlanContratac : itemPlanContratacList) {
                ItemPlanContratacVO itemVo = new ItemPlanContratacVO(itemPlanContratac);
                itemPlanContratacListVo.add(itemVo);
            }
        }

        for(ItemPlanContratacVO itemPlanContratacVo : itemPlanContratacListVo) {
            if(itemPlanContratacVo.getIpcCodigo() == null) {
                itemPlanContratacVo = new ItemPlanContratacVO(itemPlanContratacDao.insertarItemPlanContratac(conversionVoEntidad.convertir(itemPlanContratacVo)));
            }
            else {
                itemPlanContratacVo = new ItemPlanContratacVO(itemPlanContratacDao.actualizarItemPlanContractac(conversionVoEntidad.convertir(itemPlanContratacVo)));
            }

        }

        List<Long> listaMidCodigoExistente = listaIdModRubrosExistentes(modificacionPlanContVo);

        if (modPlanConItemPlanDetRubListVo.size()==0) {
            for (Long midCodigo :listaMidCodigoExistente) {
                modPlanConItemPlanDetRubDao.eliminarModPlanConItemPlanDetRub(midCodigo);
            }            
        }
        for(ModPlanConItemPlanDetRubVO modPlanConItemPlanDetRubVo : modPlanConItemPlanDetRubListVo) {
            if(modPlanConItemPlanDetRubVo.getMidCodigo() != null) {
                if(!listaMidCodigoExistente.contains(modPlanConItemPlanDetRubVo.getMidCodigo())) {
                    modPlanConItemPlanDetRubDao.eliminarModPlanConItemPlanDetRub(modPlanConItemPlanDetRubVo.getMidCodigo());
                }
            }

        }


        for(ModPlanConItemPlanDetRubVO modPlanConItemPlanDetRubVo : modPlanConItemPlanDetRubListVo) {
            modPlanConItemPlanDetRubVo.setModificacionPlanContVo(modificacionPlanContVo);
            if(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getIdrCodigo() == null) {
                modPlanConItemPlanDetRubVo.setItemPlanContDetRubDesVo(crearItemPlanContDetRub(modPlanConItemPlanDetRubVo));
            }
            if(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getIdrCodigo() != null) {
                modPlanConItemPlanDetRubVo = new ModPlanConItemPlanDetRubVO(modPlanConItemPlanDetRubDao.insertarModPlanConItemPlanDetRub(conversionVoEntidad.convertir(modPlanConItemPlanDetRubVo)));
            }
            else {
                modPlanConItemPlanDetRubVo = new ModPlanConItemPlanDetRubVO(modPlanConItemPlanDetRubDao.actualizarModPlanConItemPlanDetRub(conversionVoEntidad.convertir(modPlanConItemPlanDetRubVo)));
            }
        }
        modificacionPlanContVo.setDocumSoporModifListVo(documSoporModifListVo);
        modificacionPlanContVo.setItemPlanContratacListVo(itemPlanContratacListVo);
        modificacionPlanContVo.setModPlanConItemPlanDetRubListVo(modPlanConItemPlanDetRubListVo);

        if(cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.TRASLADO_ENTRE_ITEMS_DEL_PLAN_DE_CONTRATACION.getId(), modificacionPlanContVo.getEstadoModifPlanContVo().getEmoCodigo(),
                                                         usuarioVO, modificacionPlanContVo.getMpcCodigo());
        }
        return modificacionPlanContVo;
    }

    private List<Long> listaIdModRubrosExistentes(ModificacionPlanContVO modificacionPlanContVo) throws co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO {
        List<Long> listaMidCodigoExistente = new ArrayList<Long>();
        for(SiiModPlanConItemPlanDetRub modPlanConItemPlanDetRub : modPlanConItemPlanDetRubDao.detRubrosPorModPlan(modificacionPlanContVo.getMpcCodigo())) {
            listaMidCodigoExistente.add(modPlanConItemPlanDetRub.getMidCodigo());
        }
        return listaMidCodigoExistente;
    }


    public ModificacionPlanContVO crearTraslado(ModificacionPlanContVO modificacionPlanContVo, UsuarioVO usuarioVO) throws ExcepcionDAO {
        List<DocumSoporModifVO> documSoporModifListVo = modificacionPlanContVo.getDocumSoporModifListVo();
        List<ItemPlanContratacVO> itemPlanContratacListVo = modificacionPlanContVo.getItemPlanContratacListVo();
        List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubListVo = modificacionPlanContVo.getModPlanConItemPlanDetRubListVo();
        modificacionPlanContVo.setMpcConsecutivo(modificacionPlanContDao.calcularSiguienteConsecutivo(modificacionPlanContVo.getMpcVigencia() % 2000));
        modificacionPlanContVo = new ModificacionPlanContVO(modificacionPlanContDao.insertarModifPlanCont(conversionVoEntidad.convertir(modificacionPlanContVo)));
        crearDocumSoporMofif(modificacionPlanContVo, documSoporModifListVo.get(0));
        for(ItemPlanContratacVO itemPlanContratacVo : itemPlanContratacListVo) {
            if(itemPlanContratacVo.getIpcCodigo() == null) {
                itemPlanContratacVo = new ItemPlanContratacVO(itemPlanContratacDao.insertarItemPlanContratac(conversionVoEntidad.convertir(itemPlanContratacVo)));
            }
            else {

            }

        }
        for(ModPlanConItemPlanDetRubVO modPlanConItemPlanDetRubVo : modPlanConItemPlanDetRubListVo) {
            modPlanConItemPlanDetRubVo.setModificacionPlanContVo(modificacionPlanContVo);
            if(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getIdrCodigo() == null) {
                modPlanConItemPlanDetRubVo.setItemPlanContDetRubDesVo(crearItemPlanContDetRub(modPlanConItemPlanDetRubVo));
            }
            if(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getIdrCodigo() != null) {
                modPlanConItemPlanDetRubVo = new ModPlanConItemPlanDetRubVO(modPlanConItemPlanDetRubDao.insertarModPlanConItemPlanDetRub(conversionVoEntidad.convertir(modPlanConItemPlanDetRubVo)));
            }
        }
        modificacionPlanContVo.setDocumSoporModifListVo(documSoporModifListVo);
        modificacionPlanContVo.setItemPlanContratacListVo(itemPlanContratacListVo);
        modificacionPlanContVo.setModPlanConItemPlanDetRubListVo(modPlanConItemPlanDetRubListVo);

        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.TRASLADO_ENTRE_ITEMS_DEL_PLAN_DE_CONTRATACION.getId(), modificacionPlanContVo.getEstadoModifPlanContVo().getEmoCodigo(),
                                                     usuarioVO, modificacionPlanContVo.getMpcCodigo());

        return modificacionPlanContVo;
    }

    private void crearDocumSoporMofif(ModificacionPlanContVO modificacionPlanContVo, DocumSoporModifVO documSoporModifVO) throws ExcepcionDAO {
        documSoporModifVO.setModificacionPlanContVo(modificacionPlanContVo);
        documSoporModifVO.setDsmActivo("S");
        documSoporModifVO = new DocumSoporModifVO(documSoporModifDao.insertarDocumSoporModif(conversionVoEntidad.convertir(documSoporModifVO)));
    }

    private void actualizarDocumSoporModif(ModificacionPlanContVO modificacionPlanContVo, DocumSoporModifVO documSoporModifVO) throws ExcepcionDAO {
        documSoporModifVO.setModificacionPlanContVo(modificacionPlanContVo);
        documSoporModifVO.setDsmActivo("S");
        documSoporModifVO = new DocumSoporModifVO(documSoporModifDao.actualizarDocumSoporModif(conversionVoEntidad.convertir(documSoporModifVO)));
    }


    private ItemPlanContDetRubVO crearItemPlanContDetRub(ModPlanConItemPlanDetRubVO modPlanConItemPlanDetRubVo) throws ExcepcionDAO {
        ItemPlanContDetRubVO itemPlanContDetRubVo = new ItemPlanContDetRubVO();
        itemPlanContDetRubVo.setDetalleRubroVO(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getDetalleRubroVO());
        itemPlanContDetRubVo.setIdrValor(0L);
        itemPlanContDetRubVo.setItemPlanContratacVO(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getItemPlanContratacVO());
        itemPlanContDetRubVo = new ItemPlanContDetRubVO(itemPlanContDetRubDao.insertarItemPlanContDetRub(conversionVoEntidad.convertir(itemPlanContDetRubVo)));
        return itemPlanContDetRubVo;
    }


}
