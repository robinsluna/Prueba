package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;

import java.util.Date;
import java.util.List;

public class InformeVerificCampoVO {
    
    private Long ivcCodigo;
    private Date ivcFecha;
    private BarrioOrdenInfVerVO barrioOrdenInfVerVo;
    private MunicOrdTraInfVerifVO municOrdTraInfVerifVo;
    private CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVo;
    private DenuncOrdTraInfVerVO DenuncOrdTraInfVerVo;
    private AuditorOrdenTrabVO  auditorOrdenTrabVo;
    private List<MunicOrdTraInfVerifVO> listMunicOrdTraInfVerifVo;
    private List<CuadranteOrdTraInfVerVO> listCuadranteOrdTraInfVerVo;
    private List<BarrioOrdenInfVerVO> listBarrioOrdenInfVerVo;
    private List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVerVo;
    
    private List<BarrioOrdenVO> listBarrioOrdenVo;
    private List<MunicipioOrdenTrabVO> listMunicipioOrdenTrabVo;
    private List<CuadranteOrdenTraVO> listCuadranteOrdenTraVo;
    private List<DenunciaOrdenTrabVO> denunciaOrdenTrabList;
  
    public InformeVerificCampoVO(SiiInformeVerificCampo siiInformeVerificCampo) {
       this.ivcCodigo = siiInformeVerificCampo.getIvcCodigo();
       this.ivcFecha = siiInformeVerificCampo.getIvcFecha();
    
       if(siiInformeVerificCampo.getSiiOrdenTrabajoVisita()!= null){
           this.ordenTrabajoVisitaVo = new OrdenTrabajoVisitaVO(siiInformeVerificCampo.getSiiOrdenTrabajoVisita());
       }   
       
       if(siiInformeVerificCampo.getSiiAuditorOrdenTrab()!= null){
           this.auditorOrdenTrabVo= new AuditorOrdenTrabVO (siiInformeVerificCampo.getSiiAuditorOrdenTrab());
       }
       
    }
    public InformeVerificCampoVO( ) {
    
    
    }

    public void setIvcCodigo(Long ivcCodigo) {
        this.ivcCodigo = ivcCodigo;
    }

    public Long getIvcCodigo() {
        return ivcCodigo;
    }

    public void setIvcFecha(Date ivcFecha) {
        this.ivcFecha = ivcFecha;
    }

    public Date getIvcFecha() {
        return ivcFecha;
    }

    public void setBarrioOrdenInfVerVo(BarrioOrdenInfVerVO barrioOrdenInfVerVo) {
        this.barrioOrdenInfVerVo = barrioOrdenInfVerVo;
    }

    public BarrioOrdenInfVerVO getBarrioOrdenInfVerVo() {
        return barrioOrdenInfVerVo;
    }

    public void setMunicOrdTraInfVerifVo(MunicOrdTraInfVerifVO municOrdTraInfVerifVo) {
        this.municOrdTraInfVerifVo = municOrdTraInfVerifVo;
    }

    public MunicOrdTraInfVerifVO getMunicOrdTraInfVerifVo() {
        return municOrdTraInfVerifVo;
    }

    public void setCuadranteOrdTraInfVerVo(CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo) {
        this.cuadranteOrdTraInfVerVo = cuadranteOrdTraInfVerVo;
    }

    public CuadranteOrdTraInfVerVO getCuadranteOrdTraInfVerVo() {
        return cuadranteOrdTraInfVerVo;
    }

    public void setOrdenTrabajoVisitaVo(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) {
        this.ordenTrabajoVisitaVo = ordenTrabajoVisitaVo;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVo() {
        return ordenTrabajoVisitaVo;
    }

    public void setDenuncOrdTraInfVerVo(DenuncOrdTraInfVerVO DenuncOrdTraInfVerVo) {
        this.DenuncOrdTraInfVerVo = DenuncOrdTraInfVerVo;
    }

    public DenuncOrdTraInfVerVO getDenuncOrdTraInfVerVo() {
        return DenuncOrdTraInfVerVo;
    }

    public void setListDenuncOrdTraInfVerVo(List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVerVo) {
        this.listDenuncOrdTraInfVerVo = listDenuncOrdTraInfVerVo;
    }

    public List<DenuncOrdTraInfVerVO> getListDenuncOrdTraInfVerVo() {
        return listDenuncOrdTraInfVerVo;
    }

    public void setAuditorOrdenTrabVo(AuditorOrdenTrabVO auditorOrdenTrabVo) {
        this.auditorOrdenTrabVo = auditorOrdenTrabVo;
    }

    public AuditorOrdenTrabVO getAuditorOrdenTrabVo() {
        return auditorOrdenTrabVo;
    }

    public void setListBarrioOrdenInfVerVo(List<BarrioOrdenInfVerVO> listBarrioOrdenInfVerVo) {
        this.listBarrioOrdenInfVerVo = listBarrioOrdenInfVerVo;
    }

    public List<BarrioOrdenInfVerVO> getListBarrioOrdenInfVerVo() {
        return listBarrioOrdenInfVerVo;
    }

    public void setListBarrioOrdenVo(List<BarrioOrdenVO> listBarrioOrdenVo){
        this.listBarrioOrdenVo = listBarrioOrdenVo;
    }

    public List<BarrioOrdenVO> getListBarrioOrdenVo(){
        return listBarrioOrdenVo;
    }

    public void setListMunicOrdTraInfVerifVo(List<MunicOrdTraInfVerifVO> listMunicOrdTraInfVerifVo){
        this.listMunicOrdTraInfVerifVo = listMunicOrdTraInfVerifVo;
    }

    public List<MunicOrdTraInfVerifVO> getListMunicOrdTraInfVerifVo(){
        return listMunicOrdTraInfVerifVo;
    }

    public void setListCuadranteOrdTraInfVerVo(List<CuadranteOrdTraInfVerVO> listCuadranteOrdTraInfVerVo){
        this.listCuadranteOrdTraInfVerVo = listCuadranteOrdTraInfVerVo;
    }

    public List<CuadranteOrdTraInfVerVO> getListCuadranteOrdTraInfVerVo(){
        return listCuadranteOrdTraInfVerVo;
    }

    public void setListMunicipioOrdenTrabVo(List<MunicipioOrdenTrabVO> listMunicipioOrdenTrabVo){
        this.listMunicipioOrdenTrabVo = listMunicipioOrdenTrabVo;
    }

    public List<MunicipioOrdenTrabVO> getListMunicipioOrdenTrabVo(){
        return listMunicipioOrdenTrabVo;
    }

    public void setListCuadranteOrdenTraVo(List<CuadranteOrdenTraVO> listCuadranteOrdenTraVo){
        this.listCuadranteOrdenTraVo = listCuadranteOrdenTraVo;
    }

    public List<CuadranteOrdenTraVO> getListCuadranteOrdenTraVo(){
        return listCuadranteOrdenTraVo;
    }

    public void setDenunciaOrdenTrabList(List<DenunciaOrdenTrabVO> denunciaOrdenTrabList){
        this.denunciaOrdenTrabList = denunciaOrdenTrabList;
    }

    public List<DenunciaOrdenTrabVO> getDenunciaOrdenTrabList(){
        return denunciaOrdenTrabList;
    }
}
