package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaVisita;
import co.gov.coljuegos.siicol.ejb.wsvo.InstrnoCorrespWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InventarioAutoComisWSVO;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ActaVisitaVO {
    
        private Long avicodigo;
        private Date aviFechaVisita;
        private AutoComisorioVO  autoComisorioVo;
        private List<InstrnoCorrespWSVO> listInstrnoCorrespWSVo;
        private List<InventarioAutoComisWSVO> listInventarioAutoComisWSVo;
        private Date aviFechaLlegada;
        private Date aviFechaFin;
        private Integer aviNumFolios;
        private String aviNombrePerAten;
        private String aviIdentPerAten;
        private String aviExpedPerAten;
        private String aviCalidadPerAten;
        private String aviVerifAviso;
        private String aviVeriDireccion;
        private String aviVerifNomEst;
        private String aviVerifOtrasAct;
        private String aviVerifCualAct;
        private String aviVerifMantenEle;
        private String aviVerifSpIdCli;
        private BigDecimal aviVerifSpMonto;
        private String aviVerifSpDilig;
        private String aviVerifSpSenAler;
        private String aviVerifSpCodCon;
        private Integer aviTotEleNoInv;
        private Integer aviTotEleTraNoau;
        private Integer aviMetEncontrado;
        private Integer aviSillEncontrado;
        private Integer aviMesaEncontrado;
        private Integer aviOtroEncontrado;
        private Integer aviMetAutoriz;
        private Integer aviSillAutoriz;
        private Integer aviMesaAutoriz;
        private Integer aviOtroAutoriz;
        private Integer aviMetNoEncont;
        private Integer aviSillNoEncont;
        private Integer aviMesaNoEncont;
        private Integer aviOtroNoEncont;
        private Integer aviMetSerNoCorr;
        private Integer aviSillSerNoCorr;
        private Integer aviMesaSerNoCorr;
        private Integer aviOtroSerNoCorr;
        private Integer aviMetSinPlaca;
        private Integer aviSillSinPlaca;
        private Integer aviMesaSinPlaca;
        private Integer aviOtroSinPlaca;
        private Integer aviMetApuNoCorr;
        private Integer aviSillApuNoCorr;
        private Integer aviMesaApuNoCorr;
        private Integer aviOtroApuNoCorr;
        private Integer aviMetMayNumAut;
        private Integer aviSillMayNumAut;
        private Integer aviMesaMayNumAut;
        private Integer aviOtroMayNumAut;
        private Integer aviMetNoRegNoOp;
        private Integer aviSillNoRegNoOp;
        private Integer aviMesaNoRegNoOp;
        private Integer aviOtroNoRegNoOp;
        private BigDecimal aviEstLongitud;
        private BigDecimal aviEstLatitud;
        private String aviNomRepOpera;
        private String aviIdRepOpera;
        private String  aviCargoRepOpera;
        
   
  
        public  ActaVisitaVO()  {
                              
        }
       
    
        public ActaVisitaVO(SiiActaVisita actaVisita){
            this.aviCalidadPerAten = actaVisita.getAviCalidadPerAten();
            this.aviCargoRepOpera = actaVisita.getAviCargoRepOpera();
            this.aviEstLatitud = actaVisita.getAviEstLatitud();
            this.aviEstLongitud = actaVisita.getAviEstLongitud();
            this.aviExpedPerAten = actaVisita.getAviExpedPerAten();
            this.aviFechaFin = actaVisita.getAviFechaFin();
            this.aviFechaLlegada = actaVisita.getAviFechaLlegada();
            this.aviFechaVisita = actaVisita.getAviFechaVisita();
            this.aviIdRepOpera = actaVisita.getAviIdRepOpera();
            this.aviIdentPerAten = actaVisita.getAviIdentPerAten();
            this.aviMesaApuNoCorr = actaVisita.getAviMesaApuNoCorr();
            this.aviMesaAutoriz = actaVisita.getAviMesaAutoriz();
            this.aviMesaEncontrado = actaVisita.getAviMesaEncontrado();
            this.aviMesaMayNumAut = actaVisita.getAviMesaMayNumAut();
            this.aviMesaNoEncont = actaVisita.getAviMesaNoEncont();
            this.aviMetNoRegNoOp = actaVisita.getAviMetNoRegNoOp();
            this.aviMesaSerNoCorr = actaVisita.getAviMesaSerNoCorr();
            this.aviMesaSinPlaca = actaVisita.getAviMesaSinPlaca();
            this.aviMetApuNoCorr = actaVisita.getAviMetApuNoCorr();
            this.aviMetAutoriz = actaVisita.getAviMetAutoriz();
            this.aviMesaEncontrado = actaVisita.getAviMesaEncontrado();
            this.aviMesaMayNumAut = actaVisita.getAviMesaMayNumAut();
            this.aviMetNoEncont = actaVisita.getAviMetNoEncont();
            this.aviMesaNoRegNoOp = actaVisita.getAviMesaNoRegNoOp();            
            this.aviMetSerNoCorr = actaVisita.getAviMetSerNoCorr();
            this.aviMetSinPlaca = actaVisita.getAviMetSinPlaca();
            this.aviNomRepOpera = actaVisita.getAviNomRepOpera();
            this.aviNombrePerAten = actaVisita.getAviNombrePerAten();
            this.aviNumFolios = actaVisita.getAviNumFolios();
            this.aviOtroApuNoCorr = actaVisita.getAviOtroApuNoCorr();
            this.aviOtroAutoriz = actaVisita.getAviOtroAutoriz();
            this.aviOtroEncontrado = actaVisita.getAviOtroEncontrado();
            this.aviOtroMayNumAut = actaVisita.getAviOtroMayNumAut();
            this.aviOtroNoEncont = actaVisita.getAviOtroNoEncont();
            this.aviOtroNoRegNoOp = actaVisita.getAviOtroNoRegNoOp();
            this.aviOtroSerNoCorr = actaVisita.getAviOtroSerNoCorr();
            this.aviOtroSinPlaca = actaVisita.getAviOtroSinPlaca();
            this.aviSillApuNoCorr = actaVisita.getAviSillApuNoCorr();
            this.aviSillAutoriz = actaVisita.getAviSillAutoriz();
            this.aviSillEncontrado = actaVisita.getAviSillEncontrado();
            this.aviSillMayNumAut = actaVisita.getAviSillMayNumAut();
            this.aviSillNoEncont = actaVisita.getAviSillNoEncont();
            this.aviSillNoRegNoOp = actaVisita.getAviSillNoRegNoOp();
            this.aviSillSerNoCorr = actaVisita.getAviSillSerNoCorr();
            this.aviSillSinPlaca = actaVisita.getAviSillSinPlaca();
            this.aviTotEleNoInv = actaVisita.getAviTotEleNoInv();
            this.aviTotEleTraNoau = actaVisita.getAviTotEleTraNoau();
            this.aviVeriDireccion = actaVisita.getAviVerifDireccion();
            this.aviVerifAviso = actaVisita.getAviVerifAviso();
            this.aviVerifCualAct = actaVisita.getAviVerifCualAct_();
            this.aviVerifMantenEle = actaVisita.getAviVerifMantenEle();
            this.aviVerifNomEst = actaVisita.getAviVerifNomEst();
            this.aviVerifOtrasAct = actaVisita.getAviVerifOtrasAct();
            this.aviVerifSpCodCon = actaVisita.getAviVerifSpCodCon();
            this.aviVerifSpDilig = actaVisita.getAviVerifSpDilig();
            this.aviVerifSpIdCli = actaVisita.getAviVerifSpIdCli();
            this.aviVerifSpMonto = actaVisita.getAviVerifSpMonto();
            this.aviVerifSpSenAler = actaVisita.getAviVerifSpSenAler();
            this.avicodigo = actaVisita.getAviCodigo();
            if (actaVisita.getSiiAutoComisorio() != null){
                this.autoComisorioVo = new AutoComisorioVO(actaVisita.getSiiAutoComisorio());
            }
        }

        public void setAvicodigo(Long avicodigo) {
            this.avicodigo = avicodigo;
        }

        public Long getAvicodigo() {
            return avicodigo;
        }

        public void setAviFechaVisita(Date aviFechaVisita) {
            this.aviFechaVisita = aviFechaVisita;
        }

        public Date getAviFechaVisita() {
            return aviFechaVisita;
        }

        public void setAutoComisorioVo(AutoComisorioVO autoComisorioVo) {
            this.autoComisorioVo = autoComisorioVo;
        }

        public AutoComisorioVO getAutoComisorioVo() {
            return autoComisorioVo;
        }

        public void setAviFechaLlegada(Date aviFechaLlegada) {
            this.aviFechaLlegada = aviFechaLlegada;
        }

        public Date getAviFechaLlegada() {
            return aviFechaLlegada;
        }

        public void setAviFechaFin(Date aviFechaFin) {
            this.aviFechaFin = aviFechaFin;
        }

        public Date getAviFechaFin() {
            return aviFechaFin;
        }


        public void setAviNumFolios(Integer aviNumFolios) {
            this.aviNumFolios = aviNumFolios;
        }

        public Integer getAviNumFolios() {
            return aviNumFolios;
        }

        public void setAviNombrePerAten(String aviNombrePerAten) {
            this.aviNombrePerAten = aviNombrePerAten;
        }

        public String getAviNombrePerAten() {
            return aviNombrePerAten;
        }

        public void setAviIdentPerAten(String aviIdentPerAten) {
            this.aviIdentPerAten = aviIdentPerAten;
        }

        public String getAviIdentPerAten() {
            return aviIdentPerAten;
        }

        public void setAviExpedPerAten(String aviExpedPerAten) {
            this.aviExpedPerAten = aviExpedPerAten;
        }

        public String getAviExpedPerAten() {
            return aviExpedPerAten;
        }

        public void setAviCalidadPerAten(String aviCalidadPerAten) {
            this.aviCalidadPerAten = aviCalidadPerAten;
        }

        public String getAviCalidadPerAten() {
            return aviCalidadPerAten;
        }

        public void setAviVerifAviso(String aviVerifAviso) {
            this.aviVerifAviso = aviVerifAviso;
        }

        public String getAviVerifAviso() {
            return aviVerifAviso;
        }

        public void setAviVeriDireccion(String aviVeriDireccion) {
            this.aviVeriDireccion = aviVeriDireccion;
        }

        public String getAviVeriDireccion() {
            return aviVeriDireccion;
        }

        public void setAviVerifNomEst(String aviVerifNomEst) {
            this.aviVerifNomEst = aviVerifNomEst;
        }

        public String getAviVerifNomEst() {
            return aviVerifNomEst;
        }

        public void setAviVerifOtrasAct(String aviVerifOtrasAct) {
            this.aviVerifOtrasAct = aviVerifOtrasAct;
        }

        public String getAviVerifOtrasAct() {
            return aviVerifOtrasAct;
        }

        public void setAviVerifCualAct(String aviVerifCualAct) {
            this.aviVerifCualAct = aviVerifCualAct;
        }

        public String getAviVerifCualAct() {
            return aviVerifCualAct;
        }

        public void setAviVerifMantenEle(String aviVerifMantenEle) {
            this.aviVerifMantenEle = aviVerifMantenEle;
        }

        public String getAviVerifMantenEle() {
            return aviVerifMantenEle;
        }

        public void setAviVerifSpIdCli(String aviVerifSpIdCli) {
            this.aviVerifSpIdCli = aviVerifSpIdCli;
        }

        public String getAviVerifSpIdCli() {
            return aviVerifSpIdCli;
        }


        public void setAviVerifSpMonto(BigDecimal aviVerifSpMonto) {
            this.aviVerifSpMonto = aviVerifSpMonto;
        }

        public BigDecimal getAviVerifSpMonto() {
            return aviVerifSpMonto;
        }

        public void setAviVerifSpDilig(String aviVerifSpDilig) {
            this.aviVerifSpDilig = aviVerifSpDilig;
        }

        public String getAviVerifSpDilig() {
            return aviVerifSpDilig;
        }

        public void setAviVerifSpSenAler(String aviVerifSpSenAler) {
            this.aviVerifSpSenAler = aviVerifSpSenAler;
        }

        public String getAviVerifSpSenAler() {
            return aviVerifSpSenAler;
        }

        public void setAviVerifSpCodCon(String aviVerifSpCodCon) {
            this.aviVerifSpCodCon = aviVerifSpCodCon;
        }

        public String getAviVerifSpCodCon() {
            return aviVerifSpCodCon;
        }


        public void setAviTotEleNoInv(Integer aviTotEleNoInv) {
            this.aviTotEleNoInv = aviTotEleNoInv;
        }

        public Integer getAviTotEleNoInv() {
            return aviTotEleNoInv;
        }


        public void setAviTotEleTraNoau(Integer aviTotEleTraNoau) {
            this.aviTotEleTraNoau = aviTotEleTraNoau;
        }

        public Integer getAviTotEleTraNoau() {
            return aviTotEleTraNoau;
        }


        public void setAviMetEncontrado(Integer aviMetEncontrado) {
            this.aviMetEncontrado = aviMetEncontrado;
        }

        public Integer getAviMetEncontrado() {
            return aviMetEncontrado;
        }


        public void setAviSillEncontrado(Integer aviSillEncontrado) {
            this.aviSillEncontrado = aviSillEncontrado;
        }

        public Integer getAviSillEncontrado() {
            return aviSillEncontrado;
        }

        public void setAviMesaEncontrado(Integer aviMesaEncontrado) {
            this.aviMesaEncontrado = aviMesaEncontrado;
        }

        public Integer getAviMesaEncontrado() {
            return aviMesaEncontrado;
        }

        public void setAviOtroEncontrado(Integer aviOtroEncontrado) {
            this.aviOtroEncontrado = aviOtroEncontrado;
        }

        public Integer getAviOtroEncontrado() {
            return aviOtroEncontrado;
        }

        public void setAviMetAutoriz(Integer aviMetAutoriz) {
            this.aviMetAutoriz = aviMetAutoriz;
        }

        public Integer getAviMetAutoriz() {
            return aviMetAutoriz;
        }

        public void setAviSillAutoriz(Integer aviSillAutoriz) {
            this.aviSillAutoriz = aviSillAutoriz;
        }

        public Integer getAviSillAutoriz() {
            return aviSillAutoriz;
        }

        public void setAviMesaAutoriz(Integer aviMesaAutoriz) {
            this.aviMesaAutoriz = aviMesaAutoriz;
        }

        public Integer getAviMesaAutoriz() {
            return aviMesaAutoriz;
        }

        public void setAviOtroAutoriz(Integer aviOtroAutoriz) {
            this.aviOtroAutoriz = aviOtroAutoriz;
        }

        public Integer getAviOtroAutoriz() {
            return aviOtroAutoriz;
        }

        public void setAviMetNoEncont(Integer aviMetNoEncont) {
            this.aviMetNoEncont = aviMetNoEncont;
        }

        public Integer getAviMetNoEncont() {
            return aviMetNoEncont;
        }

        public void setAviSillNoEncont(Integer aviSillNoEncont) {
            this.aviSillNoEncont = aviSillNoEncont;
        }

        public Integer getAviSillNoEncont() {
            return aviSillNoEncont;
        }

        public void setAviMesaNoEncont(Integer aviMesaNoEncont) {
            this.aviMesaNoEncont = aviMesaNoEncont;
        }

        public Integer getAviMesaNoEncont() {
            return aviMesaNoEncont;
        }

        public void setAviOtroNoEncont(Integer aviOtroNoEncont) {
            this.aviOtroNoEncont = aviOtroNoEncont;
        }

        public Integer getAviOtroNoEncont() {
            return aviOtroNoEncont;
        }

        public void setAviMetSerNoCorr(Integer aviMetSerNoCorr) {
            this.aviMetSerNoCorr = aviMetSerNoCorr;
        }

        public Integer getAviMetSerNoCorr() {
            return aviMetSerNoCorr;
        }

        public void setAviSillSerNoCorr(Integer aviSillSerNoCorr) {
            this.aviSillSerNoCorr = aviSillSerNoCorr;
        }

        public Integer getAviSillSerNoCorr() {
            return aviSillSerNoCorr;
        }

        public void setAviMesaSerNoCorr(Integer aviMesaSerNoCorr) {
            this.aviMesaSerNoCorr = aviMesaSerNoCorr;
        }

        public Integer getAviMesaSerNoCorr() {
            return aviMesaSerNoCorr;
        }

        public void setAviOtroSerNoCorr(Integer aviOtroSerNoCorr) {
            this.aviOtroSerNoCorr = aviOtroSerNoCorr;
        }

        public Integer getAviOtroSerNoCorr() {
            return aviOtroSerNoCorr;
        }

        public void setAviMetSinPlaca(Integer aviMetSinPlaca) {
            this.aviMetSinPlaca = aviMetSinPlaca;
        }

        public Integer getAviMetSinPlaca() {
            return aviMetSinPlaca;
        }

        public void setAviOtroSinPlaca(Integer aviOtroSinPlaca) {
            this.aviOtroSinPlaca = aviOtroSinPlaca;
        }

        public Integer getAviOtroSinPlaca() {
            return aviOtroSinPlaca;
        }

        public void setAviMetApuNoCorr(Integer aviMetApuNoCorr) {
            this.aviMetApuNoCorr = aviMetApuNoCorr;
        }

        public Integer getAviMetApuNoCorr() {
            return aviMetApuNoCorr;
        }

        public void setAviSillApuNoCorr(Integer aviSillApuNoCorr) {
            this.aviSillApuNoCorr = aviSillApuNoCorr;
        }

        public Integer getAviSillApuNoCorr() {
            return aviSillApuNoCorr;
        }

        public void setAviMesaApuNoCorr(Integer aviMesaApuNoCorr) {
            this.aviMesaApuNoCorr = aviMesaApuNoCorr;
        }

        public Integer getAviMesaApuNoCorr() {
            return aviMesaApuNoCorr;
        }

        public void setAviOtroApuNoCorr(Integer aviOtroApuNoCorr) {
            this.aviOtroApuNoCorr = aviOtroApuNoCorr;
        }

        public Integer getAviOtroApuNoCorr() {
            return aviOtroApuNoCorr;
        }

        public void setAviMetMayNumAut(Integer aviMetMayNumAut) {
            this.aviMetMayNumAut = aviMetMayNumAut;
        }

        public Integer getAviMetMayNumAut() {
            return aviMetMayNumAut;
        }

        public void setAviSillMayNumAut(Integer aviSillMayNumAut) {
            this.aviSillMayNumAut = aviSillMayNumAut;
        }

        public Integer getAviSillMayNumAut() {
            return aviSillMayNumAut;
        }

        public void setAviMesaMayNumAut(Integer aviMesaMayNumAut) {
            this.aviMesaMayNumAut = aviMesaMayNumAut;
        }

        public Integer getAviMesaMayNumAut() {
            return aviMesaMayNumAut;
        }

        public void setAviOtroMayNumAut(Integer aviOtroMayNumAut) {
            this.aviOtroMayNumAut = aviOtroMayNumAut;
        }

        public Integer getAviOtroMayNumAut() {
            return aviOtroMayNumAut;
        }

        public void setAviMetNoRegNoOp(Integer aviMetNoRegNoOp) {
            this.aviMetNoRegNoOp = aviMetNoRegNoOp;
        }

        public Integer getAviMetNoRegNoOp() {
            return aviMetNoRegNoOp;
        }

        public void setAviSillNoRegNoOp(Integer aviSillNoRegNoOp) {
            this.aviSillNoRegNoOp = aviSillNoRegNoOp;
        }

        public Integer getAviSillNoRegNoOp() {
            return aviSillNoRegNoOp;
        }

        public void setAviMesaNoRegNoOp(Integer aviMesaNoRegNoOp) {
            this.aviMesaNoRegNoOp = aviMesaNoRegNoOp;
        }

        public Integer getAviMesaNoRegNoOp() {
            return aviMesaNoRegNoOp;
        }

        public void setAviOtroNoRegNoOp(Integer aviOtroNoRegNoOp) {
            this.aviOtroNoRegNoOp = aviOtroNoRegNoOp;
        }

        public Integer getAviOtroNoRegNoOp() {
            return aviOtroNoRegNoOp;
        }

        public void setAviSillSinPlaca(Integer aviSillSinPlaca) {
            this.aviSillSinPlaca = aviSillSinPlaca;
        }

        public Integer getAviSillSinPlaca() {
            return aviSillSinPlaca;
        }

        public void setAviMesaSinPlaca(Integer aviMesaSinPlaca) {
            this.aviMesaSinPlaca = aviMesaSinPlaca;
        }

        public Integer getAviMesaSinPlaca() {
            return aviMesaSinPlaca;
        }


        public void setAviEstLongitud(BigDecimal aviEstLongitud) {
            this.aviEstLongitud = aviEstLongitud;
        }

        public BigDecimal getAviEstLongitud() {
            return aviEstLongitud;
        }

        public void setAviEstLatitud(BigDecimal aviEstLatitud) {
            this.aviEstLatitud = aviEstLatitud;
        }

        public BigDecimal getAviEstLatitud() {
            return aviEstLatitud;
        }


        public void setAviNomRepOpera(String aviNomRepOpera) {
            this.aviNomRepOpera = aviNomRepOpera;
        }

        public String getAviNomRepOpera() {
            return aviNomRepOpera;
        }


        public void setAviIdRepOpera(String aviIdRepOpera) {
            this.aviIdRepOpera = aviIdRepOpera;
        }

        public String getAviIdRepOpera() {
            return aviIdRepOpera;
        }


        public void setAviCargoRepOpera(String aviCargoRepOpera) {
            this.aviCargoRepOpera = aviCargoRepOpera;
        }

        public String getAviCargoRepOpera() {
            return aviCargoRepOpera;
        }


        public void setListInstrnoCorrespWSVo(List<InstrnoCorrespWSVO> listInstrnoCorrespWSVo) {
            this.listInstrnoCorrespWSVo = listInstrnoCorrespWSVo;
        }

        public List<InstrnoCorrespWSVO> getListInstrnoCorrespWSVo() {
            return listInstrnoCorrespWSVo;
        }


        public void setListInventarioAutoComisWSVo(List<InventarioAutoComisWSVO> listInventarioAutoComisWSVo) {
            this.listInventarioAutoComisWSVo = listInventarioAutoComisWSVo;
        }

        public List<InventarioAutoComisWSVO> getListInventarioAutoComisWSVo() {
            return listInventarioAutoComisWSVo;
        }

    
   
}
