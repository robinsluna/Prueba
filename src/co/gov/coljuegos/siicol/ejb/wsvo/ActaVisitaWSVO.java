package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrNoCorresp;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioVO;

import co.gov.coljuegos.siicol.ejb.wsvo.InventarioAutoComisWSVO;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ActaVisitaWSVO  implements Serializable{
    
    public String aviNumero;
    public Date aviFechaVisita;
    public Long aviNumeroAutoComisorio;
    public String aviHoraLlegada;
    public String aviHoraFinalizacion;
    public Integer aviNumFolios;

    public String aviNombrePerAten;
    public String aviIdentPerAten;
    public String aviLugarExpedPerAten;
    public String aviCalidadPerAten;

    public String aviVerifAviso;
    public String aviVeriDireccion;
    public String aviVerifNomEst;
    public String aviVerifOtrasAct;
    public String aviVerifCualAct;
    public String aviVerifMantenEle;
    
    public String aviVerifSpIdCli;
    public BigDecimal aviVerifSpMonto;
    public String aviVerifSpDilig;
    public String aviVerifSpSenAler;
    public String aviVerifSpCodCon;
    
    public List<InventarioAutoComisWSVO> listInventarioAutoComisWSVo;
   
    public Long aviTotalElemCoincidentes;
    public Long aviTotalelemNoencontrados;
    public String aviObserEncargado;
    public String aviObserInspector;
 
    
    public List<InstrnoCorrespWSVO> listInstrNoCorrespWSVo;
    public Integer aviTotEleNoInv;
    public List<InstrnoCorrespWSVO> listInstrSinAutorizacionWSVo;
    public Integer aviTotEleTraNoau;
    
    public Integer aviMetEncontrado;
    public Integer aviSillEncontrado;
    public Integer aviMesaEncontrado;
    public Integer aviOtroEncontrado;
    public Integer aviMetAutoriz;
    public Integer aviSillAutoriz;
    public Integer aviMesaAutoriz;
    public Integer aviOtroAutoriz;
    public Integer aviMetNoEncont;
    public Integer aviSillNoEncont;
    public Integer aviMesaNoEncont;
    public Integer aviOtroNoEncont;
    public Integer aviMetSerNoCorr;
    public Integer aviSillSerNoCorr;
    public Integer aviMesaSerNoCorr;
    public Integer aviOtroSerNoCorr;
    public Integer aviMetSinPlaca;
    public Integer aviSillSinPlaca;
    public Integer aviMesaSinPlaca;
    public Integer aviOtroSinPlaca;
    public Integer aviMetApuNoCorr;
    public Integer aviSillApuNoCorr;
    public Integer aviMesaApuNoCorr;
    public Integer aviOtroApuNoCorr;
    public Integer aviMetMayNumAut;
    public Integer aviSillMayNumAut;
    public Integer aviMesaMayNumAut;
    public Integer aviOtroMayNumAut;
    public Integer aviMetNoRegNoOp;
    public Integer aviSillNoRegNoOp;
    public Integer aviMesaNoRegNoOp;
    public Integer aviOtroNoRegNoOp;
    public BigDecimal aviEstLongitud;
    public BigDecimal aviEstLatitud;
    public String aviNomRepOpera;
    public String aviIdRepOpera;
    public String  aviCargoRepOpera;
   
    
    
    
    public ActaVisitaWSVO() {
        super();
    }


  
}
