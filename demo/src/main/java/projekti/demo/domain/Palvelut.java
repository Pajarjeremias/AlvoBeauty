package projekti.demo.domain;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="palvelut")
public class Palvelut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "palvId", nullable=false)
    private Long palvId;

    @ManyToOne
    @JoinColumn(name="aBId")
    private AlvoBeauty alvoBeauty;
    
    @ManyToOne
    @JoinColumn(name="tTId")
    private Tyontekijat tyontekija;
    
    @NotNull(message = "Tämä kenttä ei saa olla tyhjä ja muista käyttää pistettä pilkun sijaan.")
    @Column(name= "hinta", nullable=true)
   private BigDecimal hinta;
   
   @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
   @Column(name= "nimi", nullable=false)
   private String nimi;
   
   @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
   @Column(name= "kuvaus", nullable=true)
   private String kuvaus;

   public Palvelut() {
    super();
   }

public Palvelut(Tyontekijat tyontekija, BigDecimal hinta, String nimi, String kuvaus) {
    this.tyontekija = tyontekija;
    this.hinta = hinta;
    this.nimi = nimi;
    this.kuvaus = kuvaus;
}

public Long getPalvId() {
    return palvId;
}

public void setPalvId(Long palvId) {
    this.palvId = palvId;
}

public AlvoBeauty getAlvoBeauty() {
    return alvoBeauty;
}

public void setAlvoBeauty(AlvoBeauty alvoBeauty) {
    this.alvoBeauty = alvoBeauty;
}

public Tyontekijat getTyontekija() {
    return tyontekija;
}

public void setTyontekija(Tyontekijat tyontekija) {
    this.tyontekija = tyontekija;
}

public BigDecimal getHinta() {
    return hinta;
}

public void setHinta(BigDecimal hinta) {
    this.hinta = hinta;
}

public String getNimi() {
    return nimi;
}

public void setNimi(String nimi) {
    this.nimi = nimi;
}

public String getKuvaus() {
    return kuvaus;
}

public void setKuvaus(String kuvaus) {
    this.kuvaus = kuvaus;
}



  

}



   
