package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContDetRub;

import java.util.List;

public class ItemPlanContDetRubVO implements Comparable<ItemPlanContDetRubVO> {
    private Long idrCodigo;
    private Long idrValor;
    private DetalleRubroVO detalleRubroVO;
    private ItemPlanContratacVO itemPlanContratacVO;
    private List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubDesListVo;
    private String codigoPresupuestal; // no corresponde a un campo de la tabla. corresponde al codigo presupuestal traido de las tablas de nivles de rubros.
    private String nombreRubro; // no corresponde a un campo de la tabla. corresponde al nombre del rubro presupuestal traido de por rubro.
    private Long valorCredito; // no corresponde a un campo de la tabla, se usa para traslados de items del plan
    private Long valorContracredito; // no corresponde a un campo de la tabla, se usa para traslados de items del plan
    private Long midCodigo; // no corresponde a un campo de la tabla, se usa para traslados de items del plan


    public ItemPlanContDetRubVO() {
    }

    public ItemPlanContDetRubVO(SiiItemPlanContDetRub itemPlanContDetRub) {
        this.idrCodigo = itemPlanContDetRub.getIdrCodigo();
        this.idrValor = itemPlanContDetRub.getIdrValor();
        //Padres:
        this.detalleRubroVO = new DetalleRubroVO(itemPlanContDetRub.getSiiDetalleRubro());
        this.itemPlanContratacVO = new ItemPlanContratacVO(itemPlanContDetRub.getSiiItemPlanContratac());
    }

    public void setIdrCodigo(Long idrCodigo) {
        this.idrCodigo = idrCodigo;
    }

    public Long getIdrCodigo() {
        return idrCodigo;
    }

    public void setIdrValor(Long idrValor) {
        this.idrValor = idrValor;
    }

    public Long getIdrValor() {
        return idrValor;
    }

    public void setDetalleRubroVO(DetalleRubroVO detalleRubroVO) {
        this.detalleRubroVO = detalleRubroVO;
    }

    public DetalleRubroVO getDetalleRubroVO() {
        return detalleRubroVO;
    }

    public void setItemPlanContratacVO(ItemPlanContratacVO itemPlanContratacVO) {
        this.itemPlanContratacVO = itemPlanContratacVO;
    }

    public ItemPlanContratacVO getItemPlanContratacVO() {
        return itemPlanContratacVO;
    }

    public void setCodigoPresupuestal(String codigoPresupuestal) {
        this.codigoPresupuestal = codigoPresupuestal;
    }

    public String getCodigoPresupuestal() {
        return codigoPresupuestal;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setValorCredito(Long valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Long getValorCredito() {
        return valorCredito;
    }

    public void setValorContracredito(Long valorContracredito) {
        this.valorContracredito = valorContracredito;
    }

    public Long getValorContracredito() {
        return valorContracredito;
    }

    public void setMidCodigo(Long midCodigo) {
        this.midCodigo = midCodigo;
    }

    public Long getMidCodigo() {
        return midCodigo;
    }

    public void setModPlanConItemPlanDetRubDesListVo(List<ModPlanConItemPlanDetRubVO> modPlanConItemPlanDetRubDesListVo) {
        this.modPlanConItemPlanDetRubDesListVo = modPlanConItemPlanDetRubDesListVo;
    }

    public List<ModPlanConItemPlanDetRubVO> getModPlanConItemPlanDetRubDesListVo() {
        return modPlanConItemPlanDetRubDesListVo;
    }

    public int compareTo(ItemPlanContDetRubVO o) {
        int value1 = this.codigoPresupuestal.compareTo(o.codigoPresupuestal);
        if(value1 == 0) {
            int value2 = this.nombreRubro.compareTo(o.nombreRubro);
            if(value2 == 0) {
                int value3 =
                    this.getDetalleRubroVO().getDetFuenteFinanciacionVo().getFuenteFinanciacionVo().getFfiCodigoFuente().compareTo(o.getDetalleRubroVO().getDetFuenteFinanciacionVo().getFuenteFinanciacionVo().getFfiCodigoFuente());
                if(value3 == 0) {
                    int value4 = this.getDetalleRubroVO().getDetFuenteFinanciacionVo().getDffCodigoRecurso().compareTo(o.getDetalleRubroVO().getDetFuenteFinanciacionVo().getDffCodigoRecurso());
                    if(value4 == 0) {
                        int value5 = this.getIdrValor().compareTo(o.getIdrValor());
                        if(value5 == 0) {
                            int value6 = this.getValorContracredito().compareTo(o.getValorContracredito());
                            if(value6 == 0) {
                                return this.getValorCredito().compareTo(o.getValorCredito());
                            }
                            else {
                                return value6;
                            }
                        }
                        else {
                            return value5;
                        }
                    }
                    else {
                        return value4;
                    }
                }
                else {
                    return value3;
                }
            }
            else {
                return value2;
            }
        }
        else {
            return value1;
        }
    }
}
