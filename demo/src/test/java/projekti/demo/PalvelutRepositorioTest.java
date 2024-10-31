package projekti.demo;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import projekti.demo.domain.Palvelut;
import projekti.demo.domain.PalvelutRepositorio;
import projekti.demo.domain.Tyontekijat;
import projekti.demo.domain.TyontekijatRepositorio;

@SpringBootTest
public class PalvelutRepositorioTest {

    @Autowired
    PalvelutRepositorio repositorio;

    @Autowired
    TyontekijatRepositorio trepo;

    @Test
    public void LoydaNimellaPitaisiPalauttaa(){
        List<Palvelut> palvelut = repositorio.findByNimi("naama");

        assertThat(palvelut).hasSize(1);
        assertThat(palvelut.get(0).getNimi()).isEqualTo("naama");
    }

    @Test
    public void lisaaUusiTyontekijaJaAnnaSilleUusiPalvelu(){
        Tyontekijat tyontekijat = new Tyontekijat("Jukka", "floristi", "0449542323", "jukka.floristi@hortonomit.fi",
         "hortonomiensalakerhonkatu 5", 2024, "Pitää kasvuston rehevänä.");
        trepo.save(tyontekijat); 

        assertThat(trepo.findById(tyontekijat.gettTId())).isPresent();

        Palvelut palvelut = new Palvelut(tyontekijat, new BigDecimal("4.44"), "floristi", "maisemointi");
        repositorio.save(palvelut);

        Palvelut tallennettuPalvelu = repositorio.findById(palvelut.getPalv_id()).get();
        assertThat(tallennettuPalvelu.getTyontekija().gettTId()).isEqualTo(tyontekijat.gettTId());
    

    }

    @Test
    public void poistaUusiPalveluJaTyontekija() {
        Tyontekijat tyontekijat = new Tyontekijat("Jukka", "floristi", "0449542323", "jukka.floristi@hortonomit.fi",
         "hortonomiensalakerhonkatu 5", 2024, "Pitää kasvuston rehevänä.");
        trepo.save(tyontekijat); 

        assertThat(trepo.findById(tyontekijat.gettTId())).isPresent();
        
        Palvelut palvelut = new Palvelut(tyontekijat, new BigDecimal("4.44"), "floristi", "maisemointi");
        repositorio.save(palvelut);

         assertThat(repositorio.findById(palvelut.getPalv_id())).isPresent();

        List<Palvelut> poistaPalvelu = repositorio.findByNimi("floristi");
        //assertThat(poistaPalvelu).isNotEmpty();
        Palvelut palvelu = poistaPalvelu.get(0);
        repositorio.delete(palvelu);
        List<Palvelut> uusiPalvelu = repositorio.findByNimi("floristi");
        assertThat(uusiPalvelu).hasSize(0);

       
        List<Tyontekijat> poistaTyontekija = trepo.findByNimi("Jukka");
        Tyontekijat tyontekija = poistaTyontekija.get(0);
        trepo.delete(tyontekija);
        List<Tyontekijat> uusiTyontekija = trepo.findByNimi("Jukka");
        assertThat(uusiTyontekija).hasSize(0);

        

    }

    
}
