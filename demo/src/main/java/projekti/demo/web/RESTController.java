package projekti.demo.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projekti.demo.domain.AlvoBeautyRepositorio;
import projekti.demo.domain.Palvelut;
import projekti.demo.domain.PalvelutRepositorio;
import projekti.demo.domain.Tyontekijat;
import projekti.demo.domain.TyontekijatRepositorio;
import projekti.demo.domain.Kayttaja;
import projekti.demo.domain.KayttajaRepositorio;

@RestController
public class RESTController {
    
    @Autowired
    AlvoBeautyRepositorio abrepo;

    @Autowired
    PalvelutRepositorio palvrepo;

    @Autowired
    TyontekijatRepositorio tyorepo;

    @Autowired
    KayttajaRepositorio kaytrepo;


    @GetMapping("/palvelut")
    public Iterable<Palvelut> getPalvelut(){
        return palvrepo.findAll();
    }

    @GetMapping("/tyontekijat")
    public Iterable<Tyontekijat> getTyontekijat()  {
        return tyorepo.findAll();
    }


    @GetMapping("/palvelut/{palvId}")
    public Optional<Palvelut> getYksipalvelu(@PathVariable("palvId") Long palvId){
        return palvrepo.findById(palvId);
    }
    @GetMapping("/tyontekijat/{tTId}")
    public Optional<Tyontekijat> getYksityontekija(@PathVariable("tTId") Long tTId){
        return tyorepo.findById(tTId);
    }
   

    @PostMapping("/uusipalvelut")
    Palvelut newPalvelut(@RequestBody Palvelut uusiPalvelu) {
        return palvrepo.save(uusiPalvelu);
    }

    @PostMapping("/uusityontekijat")
    Tyontekijat newTyontekijat(@RequestBody Tyontekijat uusiTyontekijat){
        return tyorepo.save(uusiTyontekijat);
    }

    @PostMapping("/uusikayttajat")
    Kayttaja newKayttaja(@RequestBody Kayttaja uusiKayttaja){
        return kaytrepo.save(uusiKayttaja);
    }

    @PutMapping("/muokkaapalvelut/{palvId}")
    Palvelut editPalvelut(@RequestBody Palvelut editioituPalvelu, @PathVariable Long palvId){
    editioituPalvelu.setPalv_id(palvId);
    return palvrepo.save(editioituPalvelu);
    }
    @PutMapping("/muokkaatyontekijat/{tTId}")
    Tyontekijat editTyontekijat(@RequestBody Tyontekijat editioituTyontekija, @PathVariable Long tTId){
    editioituTyontekija.settTId(tTId);
    return tyorepo.save(editioituTyontekija);
    }
    @PutMapping("/muokkaakayttajat/{kaytId}")
    Kayttaja editKayttaja(@RequestBody Kayttaja editioituKayttaja, @PathVariable Long kaytId){
    editioituKayttaja.setKaytId(kaytId);
    return kaytrepo.save(editioituKayttaja);
    }

    @DeleteMapping("/poistapalvelut/{palvId}")
    public Iterable<Palvelut> poistaPalvelu(@PathVariable Long palvId) {
        palvrepo.deleteById(palvId);
        return palvrepo.findAll();
    }
    @DeleteMapping("/poistatyontekijat/{tTId}")
    public Iterable<Tyontekijat> poistaTyontekija(@PathVariable Long tTId) {
        tyorepo.deleteById(tTId);
        return tyorepo.findAll();
    }
    @DeleteMapping("/poistakayttaja/{kaytId}")
    public Iterable<Kayttaja> poistaKayttaja(@PathVariable Long kaytId) {
        kaytrepo.deleteById(kaytId);
        return kaytrepo.findAll();
    }

}
