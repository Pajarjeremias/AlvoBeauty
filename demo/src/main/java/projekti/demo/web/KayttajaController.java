package projekti.demo.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.*;
import projekti.demo.domain.IlmoittautumisLomake;
import projekti.demo.domain.Kayttaja;
import projekti.demo.domain.KayttajaRepositorio;

@Controller
public class KayttajaController {
    @Autowired
    private KayttajaRepositorio repositorio;

   /*  @RequestMapping(value="ilmoittautuminen", method = RequestMethod.POST)
    public String lisaaKayttaja(Model model){
        model.addAttribute("ilmoittautumislomake", new IlmoittautumisLomake());
        return "ilmoittautuminen";
    }*/
    @RequestMapping(value="ilmoittautuminen", method = RequestMethod.POST)
    public String tallennaKayttaja(@Valid @ModelAttribute("ilmoittautumislomake")IlmoittautumisLomake lomake, 
    BindingResult tulokset, Model model){
        if (tulokset.hasErrors()){
            return "ilmoittautuminen";
        }
        Kayttaja uusiKayttaja = new Kayttaja();
        repositorio.save(uusiKayttaja);

        model.addAttribute("successMessage", "Ilmoittautuminen onnistui");
        return "redirect:/login";
    }

}
