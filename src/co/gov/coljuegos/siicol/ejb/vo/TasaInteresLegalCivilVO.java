package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteresLegalCivil;


/**
 * Value Object para el manejo de Tasas de Inter&eacute;s Legal Civil.
 * @author Camilo Miranda
 */
public class TasaInteresLegalCivilVO 
{
    private String tilActivo;
    private Long tilCodigo;
    private Integer tilTasa;
    
    
    /**
     * Constructor.
     */
    public TasaInteresLegalCivilVO() { }
    
    
    /**
     * Constructor.
     * @param siiTasaInteresLegalCivil - Entity.
     */
    public TasaInteresLegalCivilVO(SiiTasaInteresLegalCivil siiTasaInteresLegalCivil) 
    { 
        if (siiTasaInteresLegalCivil!=null) {
            this.tilActivo = siiTasaInteresLegalCivil.getTilActivo();
            this.tilCodigo = siiTasaInteresLegalCivil.getTilCodigo();
            this.tilTasa = siiTasaInteresLegalCivil.getTilTasa();
        }
    }
    


    public void setTilActivo(String tilActivo) {
        this.tilActivo = tilActivo;
    }

    public String getTilActivo() {
        return tilActivo;
    }

    public void setTilCodigo(Long tilCodigo) {
        this.tilCodigo = tilCodigo;
    }

    public Long getTilCodigo() {
        return tilCodigo;
    }

    public void setTilTasa(Integer tilTasa) {
        this.tilTasa = tilTasa;
    }

    public Integer getTilTasa() {
        return tilTasa;
    }
}
