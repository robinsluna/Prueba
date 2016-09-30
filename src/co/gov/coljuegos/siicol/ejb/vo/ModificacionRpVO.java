package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionRp;

import java.util.Date;
import java.util.List;

public class ModificacionRpVO implements Comparable<ModificacionRpVO> {
    private Long mrpCodigo;
    private String mrpTipoModif;
    private List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVo;
    private RpVO RpVo;
    private EstadoModificRpVO estadoModificRpVo;
    private Date mrpFecha;
    private Long mrpConsecutivo;
    private Long idEstadoAnterior;
    private String mrpMotivoAnula;

    public ModificacionRpVO() {
    }

    public ModificacionRpVO(SiiModificacionRp modificacionRp) {
        this.mrpCodigo = modificacionRp.getMrpCodigo();
        this.mrpTipoModif = modificacionRp.getMrpTipoModif();
        this.mrpFecha = modificacionRp.getMrpFecha();
        this.mrpConsecutivo = modificacionRp.getMrpConsecutivo();
        this.mrpMotivoAnula = modificacionRp.getMrpMotivoAnula();
        //Padres:
        if (modificacionRp.getSiiRp1() != null) {
            this.RpVo = new RpVO(modificacionRp.getSiiRp1());
        }

        if (modificacionRp.getSiiEstadoModificRp() != null) {
            this.estadoModificRpVo = new EstadoModificRpVO(modificacionRp.getSiiEstadoModificRp());
            this.idEstadoAnterior = modificacionRp.getSiiEstadoModificRp().getEmrCodigo();
        }
    }

    public void setMrpCodigo(Long mrpCodigo) {
        this.mrpCodigo = mrpCodigo;
    }

    public Long getMrpCodigo() {
        return mrpCodigo;
    }

    public void setMrpTipoModif(String mrpTipoModif) {
        this.mrpTipoModif = mrpTipoModif;
    }

    public String getMrpTipoModif() {
        return mrpTipoModif;
    }

    public void setListaModifRpDetRubCdpVo(List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVo) {
        this.listaModifRpDetRubCdpVo = listaModifRpDetRubCdpVo;
    }

    public List<ModifRpDetRubCdpVO> getListaModifRpDetRubCdpVo() {
        return listaModifRpDetRubCdpVo;
    }

    public void setRpVo(RpVO RpVo) {
        this.RpVo = RpVo;
    }

    public RpVO getRpVo() {
        return RpVo;
    }

    public void setEstadoModificRpVo(EstadoModificRpVO estadoModificRpVo) {
        this.estadoModificRpVo = estadoModificRpVo;
    }

    public EstadoModificRpVO getEstadoModificRpVo() {
        return estadoModificRpVo;
    }

    public void setMrpFecha(Date mrpFecha) {
        this.mrpFecha = mrpFecha;
    }

    public Date getMrpFecha() {
        return mrpFecha;
    }

    public void setMrpConsecutivo(Long mrpConsecutivo) {
        this.mrpConsecutivo = mrpConsecutivo;
    }

    public Long getMrpConsecutivo() {
        return mrpConsecutivo;
    }

    public void setMrpMotivoAnula(String mrpMotivoAnula) {
        this.mrpMotivoAnula = mrpMotivoAnula;
    }

    public String getMrpMotivoAnula() {
        return mrpMotivoAnula;
    }

    public int compareTo(ModificacionRpVO compareModificacionRpVo) {


        //descending order
        if (compareModificacionRpVo.getMrpConsecutivo() != null && this.mrpConsecutivo != null)
            return compareModificacionRpVo.getMrpConsecutivo().compareTo(this.mrpConsecutivo);
        else if (compareModificacionRpVo.getMrpConsecutivo() != null)
            return 1;
        else if (this.mrpConsecutivo != null)
            return -1;
        else
            return 0;

    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    /*    public static Comparator<ModificacionRpVO> ConsecModifRpComparator
                              = new Comparator<ModificacionRpVO>() {

                public int compare(ModificacionRpVO modif1, ModificacionRpVO modif2) {

                  Long consec1 = modif1.getMrpConsecutivo();
                  Long consec2 = modif2.getMrpConsecutivo();

                  //ascending order
                  return consec1.compareTo(consec2);

                  //descending order
                  //return fruitName2.compareTo(fruitName1);
                }

            };
    */

}
