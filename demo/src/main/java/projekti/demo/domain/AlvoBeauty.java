package projekti.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name="alvo_beauty")
public class AlvoBeauty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "aBId", nullable=false, unique=true)
    private Long aBId;
    
    @JsonIgnore
    @OneToMany(mappedBy="alvoBeauty", cascade = CascadeType.ALL)
    private List<Palvelut> palvelut;

    @JsonIgnore
    @OneToMany(mappedBy ="alvoBeauty", cascade = CascadeType.ALL)
    private List<Tyontekijat> tyontekijat;

    public AlvoBeauty() {
        super();
    }

    public AlvoBeauty(List<Palvelut> palvelut) {
        this.palvelut = palvelut;
    }

    public Long getaBId() {
        return aBId;
    }

    public void setaBId(Long aBId) {
        this.aBId = aBId;
    }

    public List<Palvelut> getPalvelut() {
        return palvelut;
    }

    public void setPalvelut(List<Palvelut> palvelut) {
        this.palvelut = palvelut;
    }

    public List<Tyontekijat> getTyontekijat() {
        return tyontekijat;
    }

    public void setTyontekijat(List<Tyontekijat> tyontekijat) {
        this.tyontekijat = tyontekijat;
    }
}

