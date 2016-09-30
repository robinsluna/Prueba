package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MES")
public class SiiMes implements Serializable {
    private static final long serialVersionUID = 7617710137489123308L;
    private Integer mesCodigo;
    private String mesNombre;
    private String mesNombreCorto;
    private List<SiiDistribucionPfc> siiDistribucionPfcList;
    private List<SiiObligacionPago> siiObligacionPagoList;
    private List<SiiObligacionPago> siiObligacionPagoList1;
    private List<SiiSolicitudPfcMens> siiSolicitudPfcMensList;
    private List<SiiLiquidacionMes> siiLiquidacionMesList1;
    private List<SiiSolicitudPago> siiSolicitudPagoList2;
    private List<SiiCierreContable> siiCierreContableList;
    private List<SiiVentasMet> siiVentasMetList;
    private List<SiiCorteCartera> siiCorteCarteraList;
    private List<SiiDetCorteCartera> siiDetCorteCarteraList;
    private List<SiiDistribucionMes> siiDistribucionMesList;
    private List<SiiHlpCuotaAcuerdo> siiHlpCuotaAcuerdoList;
    private List<SiiBeneficiarioEnte> siiBeneficiarioEnteList;
    private List<SiiReporteVentas> siiReporteVentasList;


    public SiiMes() {
    }

    public SiiMes(Integer mesCodigo, String mesNombre, String mesNombreCorto) {
        this.mesCodigo = mesCodigo;
        this.mesNombre = mesNombre;
        this.mesNombreCorto = mesNombreCorto;
    }

    @Id
    @Column(name = "MES_CODIGO", nullable = false)
    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }

    @Column(name = "MES_NOMBRE", nullable = false, length = 15)
    public String getMesNombre() {
        return mesNombre;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    @Column(name = "MES_NOMBRE_CORTO", nullable = false, length = 3)
    public String getMesNombreCorto() {
        return mesNombreCorto;
    }

    public void setMesNombreCorto(String mesNombreCorto) {
        this.mesNombreCorto = mesNombreCorto;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiDistribucionPfc> getSiiDistribucionPfcList() {
        return siiDistribucionPfcList;
    }

    public void setSiiDistribucionPfcList(List<SiiDistribucionPfc> siiDistribucionPfcList) {
        this.siiDistribucionPfcList = siiDistribucionPfcList;
    }

    public SiiDistribucionPfc addSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList().add(siiDistribucionPfc);
        siiDistribucionPfc.setSiiMes(this);
        return siiDistribucionPfc;
    }

    public SiiDistribucionPfc removeSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList().remove(siiDistribucionPfc);
        siiDistribucionPfc.setSiiMes(null);
        return siiDistribucionPfc;
    }

	@OneToMany(mappedBy = "siiMes")
    public List<SiiObligacionPago> getSiiObligacionPagoList() {
        return siiObligacionPagoList;
    }

    public void setSiiObligacionPagoList(List<SiiObligacionPago> siiObligacionPagoList) {
        this.siiObligacionPagoList = siiObligacionPagoList;
    }

    public SiiObligacionPago addSiiObligacionPago(SiiObligacionPago siiObligacionPago) {
        getSiiObligacionPagoList().add(siiObligacionPago);
        siiObligacionPago.setSiiMes(this);
        return siiObligacionPago;
    }

    public SiiObligacionPago removeSiiObligacionPago(SiiObligacionPago siiObligacionPago) {
        getSiiObligacionPagoList().remove(siiObligacionPago);
        siiObligacionPago.setSiiMes(null);
        return siiObligacionPago;
    }

    @OneToMany(mappedBy = "siiMes1")
    public List<SiiObligacionPago> getSiiObligacionPagoList1() {
        return siiObligacionPagoList1;
    }

    public void setSiiObligacionPagoList1(List<SiiObligacionPago> siiObligacionPagoList1) {
        this.siiObligacionPagoList1 = siiObligacionPagoList1;
    }

    @OneToMany(mappedBy = "siiMes1")
    public List<SiiSolicitudPfcMens> getSiiSolicitudPfcMensList() {
        return siiSolicitudPfcMensList;
    }

    public void setSiiSolicitudPfcMensList(List<SiiSolicitudPfcMens> siiSolicitudPfcMensList) {
        this.siiSolicitudPfcMensList = siiSolicitudPfcMensList;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiLiquidacionMes> getSiiLiquidacionMesList1() {
        return siiLiquidacionMesList1;
    }

    public void setSiiLiquidacionMesList1(List<SiiLiquidacionMes> siiLiquidacionMesList1) {
        this.siiLiquidacionMesList1 = siiLiquidacionMesList1;
    }

    public SiiLiquidacionMes addSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList1().add(siiLiquidacionMes);
        siiLiquidacionMes.setSiiMes(this);
        return siiLiquidacionMes;
    }

    public SiiLiquidacionMes removeSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList1().remove(siiLiquidacionMes);
        siiLiquidacionMes.setSiiMes(null);
        return siiLiquidacionMes;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiSolicitudPago> getSiiSolicitudPagoList2() {
        return siiSolicitudPagoList2;
    }

    public void setSiiSolicitudPagoList2(List<SiiSolicitudPago> siiSolicitudPagoList2) {
        this.siiSolicitudPagoList2 = siiSolicitudPagoList2;
    }

    public SiiSolicitudPago addSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList2().add(siiSolicitudPago);
        siiSolicitudPago.setSiiMes(this);
        return siiSolicitudPago;
    }

    public SiiSolicitudPago removeSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList2().remove(siiSolicitudPago);
        siiSolicitudPago.setSiiMes(null);
        return siiSolicitudPago;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiCierreContable> getSiiCierreContableList() {
        return siiCierreContableList;
    }

    public void setSiiCierreContableList(List<SiiCierreContable> siiCierreContableList) {
        this.siiCierreContableList = siiCierreContableList;
    }

    public SiiCierreContable addSiiCierreContable(SiiCierreContable siiCierreContable) {
        getSiiCierreContableList().add(siiCierreContable);
        siiCierreContable.setSiiMes(this);
        return siiCierreContable;
    }

    public SiiCierreContable removeSiiCierreContable(SiiCierreContable siiCierreContable) {
        getSiiCierreContableList().remove(siiCierreContable);
        siiCierreContable.setSiiMes(null);
        return siiCierreContable;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiVentasMet> getSiiVentasMetList() {
        return siiVentasMetList;
    }

    public void setSiiVentasMetList(List<SiiVentasMet> siiVentasMetList) {
        this.siiVentasMetList = siiVentasMetList;
    }

    public SiiVentasMet addSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().add(siiVentasMet);
        siiVentasMet.setSiiMes(this);
        return siiVentasMet;
    }

    public SiiVentasMet removeSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().remove(siiVentasMet);
        siiVentasMet.setSiiMes(null);
        return siiVentasMet;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiCorteCartera> getSiiCorteCarteraList() {
        return siiCorteCarteraList;
    }

    public void setSiiCorteCarteraList(List<SiiCorteCartera> siiCorteCarteraList) {
        this.siiCorteCarteraList = siiCorteCarteraList;
    }

    public SiiCorteCartera addSiiCorteCartera(SiiCorteCartera siiCorteCartera) {
        getSiiCorteCarteraList().add(siiCorteCartera);
        siiCorteCartera.setSiiMes(this);
        return siiCorteCartera;
    }

    public SiiCorteCartera removeSiiCorteCartera(SiiCorteCartera siiCorteCartera) {
        getSiiCorteCarteraList().remove(siiCorteCartera);
        siiCorteCartera.setSiiMes(null);
        return siiCorteCartera;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiDetCorteCartera> getSiiDetCorteCarteraList() {
        return siiDetCorteCarteraList;
    }

    public void setSiiDetCorteCarteraList(List<SiiDetCorteCartera> siiDetCorteCarteraList) {
        this.siiDetCorteCarteraList = siiDetCorteCarteraList;
    }

    public SiiDetCorteCartera addSiiDetCorteCartera(SiiDetCorteCartera siiDetCorteCartera) {
        getSiiDetCorteCarteraList().add(siiDetCorteCartera);
        siiDetCorteCartera.setSiiMes(this);
        return siiDetCorteCartera;
    }

    public SiiDetCorteCartera removeSiiDetCorteCartera(SiiDetCorteCartera siiDetCorteCartera) {
        getSiiDetCorteCarteraList().remove(siiDetCorteCartera);
        siiDetCorteCartera.setSiiMes(null);
        return siiDetCorteCartera;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiDistribucionMes> getSiiDistribucionMesList() {
        return siiDistribucionMesList;
    }

    public void setSiiDistribucionMesList(List<SiiDistribucionMes> siiDistribucionMesList) {
        this.siiDistribucionMesList = siiDistribucionMesList;
    }

    public SiiDistribucionMes addSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().add(siiDistribucionMes);
        siiDistribucionMes.setSiiMes(this);
        return siiDistribucionMes;
    }

    public SiiDistribucionMes removeSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().remove(siiDistribucionMes);
        siiDistribucionMes.setSiiMes(null);
        return siiDistribucionMes;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiHlpCuotaAcuerdo> getSiiHlpCuotaAcuerdoList() {
        return siiHlpCuotaAcuerdoList;
    }

    public void setSiiHlpCuotaAcuerdoList(List<SiiHlpCuotaAcuerdo> siiHlpCuotaAcuerdoList) {
        this.siiHlpCuotaAcuerdoList = siiHlpCuotaAcuerdoList;
    }

    public SiiHlpCuotaAcuerdo addSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
        getSiiHlpCuotaAcuerdoList().add(siiHlpCuotaAcuerdo);
        siiHlpCuotaAcuerdo.setSiiMes(this);
        return siiHlpCuotaAcuerdo;
    }

    public SiiHlpCuotaAcuerdo removeSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
        getSiiHlpCuotaAcuerdoList().remove(siiHlpCuotaAcuerdo);
        siiHlpCuotaAcuerdo.setSiiMes(null);
        return siiHlpCuotaAcuerdo;
    }

    @OneToMany(mappedBy = "siiMes")
    public List<SiiBeneficiarioEnte> getSiiBeneficiarioEnteList() {
        return siiBeneficiarioEnteList;
    }

    public void setSiiBeneficiarioEnteList(List<SiiBeneficiarioEnte> siiBeneficiarioEnteList) {
        this.siiBeneficiarioEnteList = siiBeneficiarioEnteList;
    }

    public SiiBeneficiarioEnte addSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().add(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiMes(this);
        return siiBeneficiarioEnte;
    }

    public SiiBeneficiarioEnte removeSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().remove(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiMes(null);
        return siiBeneficiarioEnte;
    }
    
    @OneToMany(mappedBy = "siiMes")
    public List<SiiReporteVentas> getSiiReporteVentasList() {
        return siiReporteVentasList;
    }

    public void setSiiReporteVentasList(List<SiiReporteVentas> siiReporteVentasList) {
        this.siiReporteVentasList = siiReporteVentasList;
    }

    public SiiReporteVentas addSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        getSiiReporteVentasList().add(siiReporteVentas);
        siiReporteVentas.setSiiMes(this);
        return siiReporteVentas;
    }

    public SiiReporteVentas removeSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        getSiiReporteVentasList().remove(siiReporteVentas);
        siiReporteVentas.setSiiMes(null);
        return siiReporteVentas;
    }


}
