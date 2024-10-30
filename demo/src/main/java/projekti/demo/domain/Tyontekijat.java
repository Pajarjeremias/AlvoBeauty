package projekti.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;


@Entity
@Table(name="tyontekijat")
public class Tyontekijat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "tTId", nullable=false)
     private Long tTId;

     @JsonIgnore
    @OneToMany(mappedBy = "tyontekija", cascade = CascadeType.ALL)
    private List<Palvelut> palvelut;

     @ManyToOne
    @JoinColumn(name="aBId")
    private AlvoBeauty alvoBeauty;

    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
    //@Size(min = 5, max = 200)
    @Column(name= "nimi", nullable=false)
    private String nimi;

    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
    @Column(name= "role", nullable=false)
    private String role;

    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
    @Column(name= "puhnumero", nullable=false)
    private String puhnumero;

    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
    @Column(name= "email", nullable=false)
    private String email;

    @Column(name= "osoite", nullable=false)
    private String osoite;

    @Column(name= "tyosuhdealku", nullable=false)
    private int tyosuhdealku;

    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä.")
    @Column(name= "lisatiedot", nullable=false)
    private String lisatiedot;


    public Tyontekijat(){
        super();
    }


    public Tyontekijat(String nimi, String role, String puhnumero, String email, String osoite, int tyosuhdealku,
            String lisatiedot) {
        this.nimi = nimi;
        this.role = role;
        this.puhnumero = puhnumero;
        this.email = email;
        this.osoite = osoite;
        this.tyosuhdealku = tyosuhdealku;
        this.lisatiedot = lisatiedot;
    }


    public Long gettTId() {
        return tTId;
    }


    public void settTId(Long tTId) {
        this.tTId = tTId;
    }


    public List<Palvelut> getPalvelut() {
        return palvelut;
    }


    public void setPalvelut(List<Palvelut> palvelut) {
        this.palvelut = palvelut;
    }


    public AlvoBeauty getAlvoBeauty() {
        return alvoBeauty;
    }


    public void setAlvoBeauty(AlvoBeauty alvoBeauty) {
        this.alvoBeauty = alvoBeauty;
    }


    public String getNimi() {
        return nimi;
    }


    public void setNimi(String nimi) {
        this.nimi = nimi;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public String getPuhnumero() {
        return puhnumero;
    }


    public void setPuhnumero(String puhnumero) {
        this.puhnumero = puhnumero;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getOsoite() {
        return osoite;
    }


    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }


    public int getTyosuhdealku() {
        return tyosuhdealku;
    }


    public void setTyosuhdealku(int tyosuhdealku) {
        this.tyosuhdealku = tyosuhdealku;
    }


    public String getLisatiedot() {
        return lisatiedot;
    }


    public void setLisatiedot(String lisatiedot) {
        this.lisatiedot = lisatiedot;
    }


    


    
}

    
