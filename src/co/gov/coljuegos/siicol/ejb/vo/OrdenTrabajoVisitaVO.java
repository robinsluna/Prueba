/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 11-09-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Value Object para gestionar las órdenes de trabajo de visitas
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class OrdenTrabajoVisitaVO implements Comparable{

    private Long otvCodigo;
    private String otvEstado;
    private Date otvFecha;
    private Date otvFechaFinal;
    private Date otvFechaInicio;
    private Integer otvNumero;
    private Integer otvNumeroFun;
    private Date otvFechaAnulac;
    private String otvMotivoAnulac;

    private CuadranteOrdenTraVO cuadranteOrdenTraVo;
    private DenunciaOrdenTrabVO denunciaOrdenTraVo;
    private BarrioOrdenVO barrioOrdenVo;
    private MunicipioOrdenTrabVO municipioOrdenTrabVo;
    private AuditorOrdenTrabVO auditorOrdenTrabVo;

    private List<CuadranteOrdenTraVO> cuadranteOrdenTraList;
    private List<DenunciaOrdenTrabVO> denunciaOrdenTrabList;
    private List<BarrioOrdenVO> barrioOrdenList;
    private List<MunicipioOrdenTrabVO> municipioOrdenTrabList;
    private List<AuditorOrdenTrabVO> auditorOrdenTrabList;
    private List<ElementoIlegInfVerVO> listBorradoElementoIlegInfVerVo; 
    private List<DenuncOrdTraInfVerVO> denuncOrdTraInfVerList;

    private String estado;
    
    /**No pertenece a la entidad**/
    private UsuarioVO usuarioLogueado;

    /**
     * Constructor.
     */
    public OrdenTrabajoVisitaVO() {
        super();
    }

    /**
     *  Constructor.
     * @param siiOrdenTrabajoVisita - Entity
     */
    public OrdenTrabajoVisitaVO(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {

        this.otvCodigo = siiOrdenTrabajoVisita.getOtvCodigo();
        this.otvEstado = siiOrdenTrabajoVisita.getOtvEstado();
        this.otvFecha = siiOrdenTrabajoVisita.getOtvFecha();
        this.otvFechaInicio = siiOrdenTrabajoVisita.getOtvFechaInicio();
        this.otvFechaFinal = siiOrdenTrabajoVisita.getOtvFechaFinal();
        this.otvNumero = siiOrdenTrabajoVisita.getOtvNumero();
        this.otvNumeroFun = siiOrdenTrabajoVisita.getOtvNumeroFun();
        this.otvFechaAnulac = siiOrdenTrabajoVisita.getOtvFechaAnulac();
        this.otvMotivoAnulac = siiOrdenTrabajoVisita.getOtvMotivoAnulac();
    }

    /**
     * Agrega un registro a la lista de cuadrantes de la orden de trabajo de visita
     * @param cuadranteOrdenTraVO - Objeto para agregar
     * @return ¿Operación exitosa?
     */
    public boolean addCuadranteOrdenTra(CuadranteOrdenTraVO cuadranteOrdenTraVO) {
        boolean exitoso = false;

        if (cuadranteOrdenTraList == null)
            cuadranteOrdenTraList = new ArrayList<CuadranteOrdenTraVO>();

        exitoso = cuadranteOrdenTraList.add(cuadranteOrdenTraVO);

        if (exitoso)
            cuadranteOrdenTraVO.setOrdenTrabajoVisitaVO(this);

        return (exitoso);
    }

    /**
     * Agrega un registro a la lista de denuncias de la orden de trabajo de visita
     * @param denunciaOrdenTrabVO - Objeto para agregar
     * @return ¿Operación exitosa?
     */
    public boolean addDenunciaOrdenTrab(DenunciaOrdenTrabVO denunciaOrdenTrabVO) {
        boolean exitoso = false;

        if (denunciaOrdenTrabList == null)
            denunciaOrdenTrabList = new ArrayList<DenunciaOrdenTrabVO>();

        exitoso = denunciaOrdenTrabList.add(denunciaOrdenTrabVO);

        if (exitoso)
            denunciaOrdenTrabVO.setOrdenTrabajoVisitaVO(this);

        return (exitoso);
    }

    /**
     * Agrega un registro a la lista de barrios de la orden de trabajo de visita
     * @param barrioOrdenVO - Objeto para agregar
     * @return ¿Operación exitosa?
     */
    public boolean addBarrioOrden(BarrioOrdenVO barrioOrdenVO) {
        boolean exitoso = false;

        if (barrioOrdenList == null)
            barrioOrdenList = new ArrayList<BarrioOrdenVO>();

        exitoso = barrioOrdenList.add(barrioOrdenVO);

        if (exitoso)
            barrioOrdenVO.setOrdenTrabajoVisitaVO(this);

        return (exitoso);
    }

    /**
     * Agrega un registro a la lista de municipios de la orden de trabajo de visita
     * @param municipioOrdenTrabVO - Objeto para agregar
     * @return ¿Operación exitosa?
     */
    public boolean addMunicipioOrdenTrab(MunicipioOrdenTrabVO municipioOrdenTrabVO) {
        boolean exitoso = false;

        if (municipioOrdenTrabList == null)
            municipioOrdenTrabList = new ArrayList<MunicipioOrdenTrabVO>();

        exitoso = municipioOrdenTrabList.add(municipioOrdenTrabVO);

        if (exitoso)
            municipioOrdenTrabVO.setOrdenTrabajoVisitaVO(this);

        return (exitoso);
    }

    /**
     * Agrega un registro a la lista de auditores de la orden de trabajo de visita
     * @param auditorOrdenTrabVO - Objeto para agregar
     * @return ¿Operación exitosa?
     */
    public boolean addAuditorOrdenTrab(AuditorOrdenTrabVO auditorOrdenTrabVO) {
        boolean exitoso = false;

        if (auditorOrdenTrabList == null)
            auditorOrdenTrabList = new ArrayList<AuditorOrdenTrabVO>();

        exitoso = auditorOrdenTrabList.add(auditorOrdenTrabVO);

        if (exitoso)
            auditorOrdenTrabVO.setOrdenTrabajoVisitaVO(this);

        return (exitoso);
    }


    public Long getOtvCodigo() {
        return otvCodigo;
    }

    public String getOtvEstado() {
        return otvEstado;
    }

    public Date getOtvFecha() {
        return otvFecha;
    }

    public Date getOtvFechaFinal() {
        return otvFechaFinal;
    }

    public Date getOtvFechaInicio() {
        return otvFechaInicio;
    }

    public Integer getOtvNumero() {
        return otvNumero;
    }

    public Integer getOtvNumeroFun() {
        return otvNumeroFun;
    }

    public CuadranteOrdenTraVO getCuadranteOrdenTraVo() {
        return cuadranteOrdenTraVo;
    }

    public DenunciaOrdenTrabVO getDenunciaOrdenTraVo() {
        return denunciaOrdenTraVo;
    }

    public BarrioOrdenVO getBarrioOrdenVo() {
        return barrioOrdenVo;
    }

    public MunicipioOrdenTrabVO getMunicipioOrdenTrabVo() {
        return municipioOrdenTrabVo;
    }

    public AuditorOrdenTrabVO getAuditorOrdenTrabVo() {
        return auditorOrdenTrabVo;
    }

    public List<CuadranteOrdenTraVO> getCuadranteOrdenTraList() {
        return cuadranteOrdenTraList;
    }

    public List<DenunciaOrdenTrabVO> getDenunciaOrdenTrabList() {
        return denunciaOrdenTrabList;
    }

    public List<BarrioOrdenVO> getBarrioOrdenList() {
        return barrioOrdenList;
    }

    public List<MunicipioOrdenTrabVO> getMunicipioOrdenTrabList() {
        return municipioOrdenTrabList;
    }

    public List<AuditorOrdenTrabVO> getAuditorOrdenTrabList() {
        return auditorOrdenTrabList;
    }

    public void setOtvCodigo(Long otvCodigo) {
        this.otvCodigo = otvCodigo;
    }

    public void setOtvEstado(String otvEstado) {
        this.otvEstado = otvEstado;
    }

    public void setOtvFecha(Date otvFecha) {
        this.otvFecha = otvFecha;
    }

    public void setOtvFechaFinal(Date otvFechaFinal) {
        this.otvFechaFinal = otvFechaFinal;
    }

    public void setOtvFechaInicio(Date otvFechaInicio) {
        this.otvFechaInicio = otvFechaInicio;
    }

    public void setOtvNumero(Integer otvNumero) {
        this.otvNumero = otvNumero;
    }

    public void setOtvNumeroFun(Integer otvNumeroFun) {
        this.otvNumeroFun = otvNumeroFun;
    }

    public void setCuadranteOrdenTraVo(CuadranteOrdenTraVO cuadranteOrdenTraVo) {
        this.cuadranteOrdenTraVo = cuadranteOrdenTraVo;
    }

    public void setDenunciaOrdenTraVo(DenunciaOrdenTrabVO denunciaOrdenTraVo) {
        this.denunciaOrdenTraVo = denunciaOrdenTraVo;
    }

    public void setBarrioOrdenVo(BarrioOrdenVO barrioOrdenVo) {
        this.barrioOrdenVo = barrioOrdenVo;
    }

    public void setMunicipioOrdenTrabVo(MunicipioOrdenTrabVO municipioOrdenTrabVo) {
        this.municipioOrdenTrabVo = municipioOrdenTrabVo;
    }

    public void setAuditorOrdenTrabVo(AuditorOrdenTrabVO auditorOrdenTrabVo) {
        this.auditorOrdenTrabVo = auditorOrdenTrabVo;
    }

    public void setCuadranteOrdenTraList(List<CuadranteOrdenTraVO> cuadranteOrdenTraList) {
        this.cuadranteOrdenTraList = cuadranteOrdenTraList;
    }

    public void setDenunciaOrdenTrabList(List<DenunciaOrdenTrabVO> denunciaOrdenTrabList) {
        this.denunciaOrdenTrabList = denunciaOrdenTrabList;
    }

    public void setBarrioOrdenList(List<BarrioOrdenVO> barrioOrdenList) {
        this.barrioOrdenList = barrioOrdenList;
    }

    public void setMunicipioOrdenTrabList(List<MunicipioOrdenTrabVO> municipioOrdenTrabList) {
        this.municipioOrdenTrabList = municipioOrdenTrabList;
    }

    public void setAuditorOrdenTrabList(List<AuditorOrdenTrabVO> auditorOrdenTrabList) {
        this.auditorOrdenTrabList = auditorOrdenTrabList;
    }

    public void setOtvFechaAnulac(Date otvFechaAnulac) {
        this.otvFechaAnulac = otvFechaAnulac;
    }

    public Date getOtvFechaAnulac() {
        return otvFechaAnulac;
    }

    public void setOtvMotivoAnulac(String otvMotivoAnulac) {
        this.otvMotivoAnulac = otvMotivoAnulac;
    }

    public String getOtvMotivoAnulac() {
        return otvMotivoAnulac;
    }

    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof OrdenTrabajoVisitaVO) {
            OrdenTrabajoVisitaVO ac = (OrdenTrabajoVisitaVO) o;
            if (ac!=null && this.otvNumero!=null && ac.otvNumero!=null)
                resultado = this.otvNumero.compareTo(ac.otvNumero);
        }
        return resultado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setListBorradoElementoIlegInfVerVo(List<ElementoIlegInfVerVO> listBorradoElementoIlegInfVerVo){
        this.listBorradoElementoIlegInfVerVo = listBorradoElementoIlegInfVerVo;
    }

    public List<ElementoIlegInfVerVO> getListBorradoElementoIlegInfVerVo(){
        return listBorradoElementoIlegInfVerVo;
    }

    public void setDenuncOrdTraInfVerList(List<DenuncOrdTraInfVerVO> denuncOrdTraInfVerList){
        this.denuncOrdTraInfVerList = denuncOrdTraInfVerList;
    }

    public List<DenuncOrdTraInfVerVO> getDenuncOrdTraInfVerList(){
        return denuncOrdTraInfVerList;
    }

    public void setUsuarioLogueado(UsuarioVO usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public UsuarioVO getUsuarioLogueado() {
        return usuarioLogueado;
    }
}
