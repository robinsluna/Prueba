package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_APUESTA")
public class SiiTipoApuesta implements Serializable {
    private static final long serialVersionUID = -3199613110982475326L;
    private String tapApuesta;
    private Long tapCodigo;
    private String tapCodigoApuesta;
    private String tapDerechosExpl;
    private String tapDerExplFormula;
    private String tapGastosAdm;
    private String tapGastAdmFormula;
    private Integer tapMinSillas;
    private String tapNombre;
    private List<SiiInventario> siiInventarioList;
    private SiiClaseJuego siiClaseJuego;
    private SiiTipoJuego siiTipoJuego;
    private List<SiiOficLiqTipoApuesta> siiOficLiqTipoApuestaList;
    private List<SiiRifaPromocional> siiRifaPromocionalList;
    private List<SiiInventarioProcSan> siiInventarioProcSanList;
    private List<SiiResumenNoConectado> siiResumenNoConectadoList;
    private List<SiiInventarioProcSan> siiInventarioProcSanEncontList;
    private List<SiiInventarioResolDesis> siiInventarioResolDesisList;
    private List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacList;

    public SiiTipoApuesta() {
    }

    public SiiTipoApuesta(SiiClaseJuego siiClaseJuego, String tapApuesta, Long tapCodigo, String tapCodigoApuesta,
                          String tapDerExplFormula, String tapDerechosExpl, String tapGastAdmFormula,
                          String tapGastosAdm, Integer tapMinSillas, String tapNombre, SiiTipoJuego siiTipoJuego) {
        this.siiClaseJuego = siiClaseJuego;
        this.tapApuesta = tapApuesta;
        this.tapCodigo = tapCodigo;
        this.tapCodigoApuesta = tapCodigoApuesta;
        this.tapDerExplFormula = tapDerExplFormula;
        this.tapDerechosExpl = tapDerechosExpl;
        this.tapGastAdmFormula = tapGastAdmFormula;
        this.tapGastosAdm = tapGastosAdm;
        this.tapMinSillas = tapMinSillas;
        this.tapNombre = tapNombre;
        this.siiTipoJuego = siiTipoJuego;
    }


    @Column(name = "TAP_APUESTA", nullable = false, length = 20)
    public String getTapApuesta() {
        return tapApuesta;
    }

    public void setTapApuesta(String tapApuesta) {
        this.tapApuesta = tapApuesta;
    }

    @Id
    @Column(name = "TAP_CODIGO", nullable = false)
    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }

    @Column(name = "TAP_CODIGO_APUESTA", nullable = false, length = 3)
    public String getTapCodigoApuesta() {
        return tapCodigoApuesta;
    }

    public void setTapCodigoApuesta(String tapCodigoApuesta) {
        this.tapCodigoApuesta = tapCodigoApuesta;
    }

    @Column(name = "TAP_DERECHOS_EXPL", nullable = false, length = 200)
    public String getTapDerechosExpl() {
        return tapDerechosExpl;
    }

    public void setTapDerechosExpl(String tapDerechosExpl) {
        this.tapDerechosExpl = tapDerechosExpl;
    }

    @Column(name = "TAP_DER_EXPL_FORMULA", nullable = false, length = 50)
    public String getTapDerExplFormula() {
        return tapDerExplFormula;
    }

    public void setTapDerExplFormula(String tapDerExplFormula) {
        this.tapDerExplFormula = tapDerExplFormula;
    }

    @Column(name = "TAP_GASTOS_ADM", nullable = false, length = 50)
    public String getTapGastosAdm() {
        return tapGastosAdm;
    }

    public void setTapGastosAdm(String tapGastosAdm) {
        this.tapGastosAdm = tapGastosAdm;
    }

    @Column(name = "TAP_GAST_ADM_FORMULA", nullable = false, length = 50)
    public String getTapGastAdmFormula() {
        return tapGastAdmFormula;
    }

    public void setTapGastAdmFormula(String tapGastAdmFormula) {
        this.tapGastAdmFormula = tapGastAdmFormula;
    }

    @Column(name = "TAP_MIN_SILLAS")
    public Integer getTapMinSillas() {
        return tapMinSillas;
    }

    public void setTapMinSillas(Integer tapMinSillas) {
        this.tapMinSillas = tapMinSillas;
    }

    @Column(name = "TAP_NOMBRE", nullable = false, length = 250)
    public String getTapNombre() {
        return tapNombre;
    }

    public void setTapNombre(String tapNombre) {
        this.tapNombre = tapNombre;
    }


    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiInventario> getSiiInventarioList() {
        return siiInventarioList;
    }

    public void setSiiInventarioList(List<SiiInventario> siiInventarioList) {
        this.siiInventarioList = siiInventarioList;
    }

    public SiiInventario addSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList().add(siiInventario);
        siiInventario.setSiiTipoApuesta(this);
        return siiInventario;
    }

    public SiiInventario removeSiiInventario(SiiInventario siiInventario) {
        getSiiInventarioList().remove(siiInventario);
        siiInventario.setSiiTipoApuesta(null);
        return siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "CJU_CODIGO")
    public SiiClaseJuego getSiiClaseJuego() {
        return siiClaseJuego;
    }

    public void setSiiClaseJuego(SiiClaseJuego siiClaseJuego) {
        this.siiClaseJuego = siiClaseJuego;
    }

    @ManyToOne
    @JoinColumn(name = "TJU_CODIGO")
    public SiiTipoJuego getSiiTipoJuego() {
        return siiTipoJuego;
    }

    public void setSiiTipoJuego(SiiTipoJuego siiTipoJuego) {
        this.siiTipoJuego = siiTipoJuego;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiOficLiqTipoApuesta> getSiiOficLiqTipoApuestaList() {
        return siiOficLiqTipoApuestaList;
    }

    public void setSiiOficLiqTipoApuestaList(List<SiiOficLiqTipoApuesta> siiOficLiqTipoApuestaList) {
        this.siiOficLiqTipoApuestaList = siiOficLiqTipoApuestaList;
    }

    public SiiOficLiqTipoApuesta addSiiOficLiqTipoApuesta(SiiOficLiqTipoApuesta siiOficLiqTipoApuesta) {
        getSiiOficLiqTipoApuestaList().add(siiOficLiqTipoApuesta);
        siiOficLiqTipoApuesta.setSiiTipoApuesta(this);
        return siiOficLiqTipoApuesta;
    }

    public SiiOficLiqTipoApuesta removeSiiOficLiqTipoApuesta(SiiOficLiqTipoApuesta siiOficLiqTipoApuesta) {
        getSiiOficLiqTipoApuestaList().remove(siiOficLiqTipoApuesta);
        siiOficLiqTipoApuesta.setSiiTipoApuesta(null);
        return siiOficLiqTipoApuesta;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiRifaPromocional> getSiiRifaPromocionalList() {
        return siiRifaPromocionalList;
    }

    public void setSiiRifaPromocionalList(List<SiiRifaPromocional> siiRifaPromocionalList) {
        this.siiRifaPromocionalList = siiRifaPromocionalList;
    }

    public SiiRifaPromocional addSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        getSiiRifaPromocionalList().add(siiRifaPromocional);
        siiRifaPromocional.setSiiTipoApuesta(this);
        return siiRifaPromocional;
    }

    public SiiRifaPromocional removeSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        getSiiRifaPromocionalList().remove(siiRifaPromocional);
        siiRifaPromocional.setSiiTipoApuesta(null);
        return siiRifaPromocional;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiInventarioProcSan> getSiiInventarioProcSanList() {
        return siiInventarioProcSanList;
    }

    public void setSiiInventarioProcSanList(List<SiiInventarioProcSan> siiInventarioProcSanList) {
        this.siiInventarioProcSanList = siiInventarioProcSanList;
    }

    public SiiInventarioProcSan addSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().add(siiInventarioProcSan);
        siiInventarioProcSan.setSiiTipoApuesta(this);
        return siiInventarioProcSan;
    }

    public SiiInventarioProcSan removeSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().remove(siiInventarioProcSan);
        siiInventarioProcSan.setSiiTipoApuesta(null);
        return siiInventarioProcSan;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiResumenNoConectado> getSiiResumenNoConectadoList() {
        return siiResumenNoConectadoList;
    }

    public void setSiiResumenNoConectadoList(List<SiiResumenNoConectado> siiResumenNoConectadoList) {
        this.siiResumenNoConectadoList = siiResumenNoConectadoList;
    }

    public SiiResumenNoConectado addSiiResumenNoConectado(SiiResumenNoConectado siiResumenNoConectado) {
        getSiiResumenNoConectadoList().add(siiResumenNoConectado);
        siiResumenNoConectado.setSiiTipoApuesta(this);
        return siiResumenNoConectado;
    }

    public SiiResumenNoConectado removeSiiResumenNoConectado(SiiResumenNoConectado siiResumenNoConectado) {
        getSiiResumenNoConectadoList().remove(siiResumenNoConectado);
        siiResumenNoConectado.setSiiTipoApuesta(null);
        return siiResumenNoConectado;
    }

    @OneToMany(mappedBy = "siiTipoApuestaEncont")
    public List<SiiInventarioProcSan> getSiiInventarioProcSanEncontList(){
        return siiInventarioProcSanEncontList;
    }

    public void setSiiInventarioProcSanEncontList(List<SiiInventarioProcSan> siiInventarioProcSanEncontList){
        this.siiInventarioProcSanEncontList = siiInventarioProcSanEncontList;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiInventarioResolDesis> getSiiInventarioResolDesisList(){
        return siiInventarioResolDesisList;
    }

    public void setSiiInventarioResolDesisList(List<SiiInventarioResolDesis> siiInventarioResolDesisList){
        this.siiInventarioResolDesisList = siiInventarioResolDesisList;
    }

    public SiiInventarioResolDesis addSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().add(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiTipoApuesta(this);
        return siiInventarioResolDesis;
    }

    public SiiInventarioResolDesis removeSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().remove(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiTipoApuesta(null);
        return siiInventarioResolDesis;
    }

    @OneToMany(mappedBy = "siiTipoApuesta")
    public List<SiiTipoApuestPolizaRenovac> getSiiTipoApuestPolizaRenovacList() {
        return siiTipoApuestPolizaRenovacList;
    }

    public void setSiiTipoApuestPolizaRenovacList(List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacList) {
        this.siiTipoApuestPolizaRenovacList = siiTipoApuestPolizaRenovacList;
    }

    public SiiTipoApuestPolizaRenovac addSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacList().add(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiTipoApuesta(this);
        return siiTipoApuestPolizaRenovac;
    }

    public SiiTipoApuestPolizaRenovac removeSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacList().remove(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiTipoApuesta(null);
        return siiTipoApuestPolizaRenovac;
    }
}
