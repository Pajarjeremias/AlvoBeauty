package projekti.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import projekti.demo.domain.Kayttaja;
import projekti.demo.domain.KayttajaRepositorio;
import projekti.demo.domain.PalvelutRepositorio;
import projekti.demo.domain.TyontekijatRepositorio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import projekti.demo.domain.Tyontekijat;
import projekti.demo.domain.Palvelut;
@Controller
public class AlvoBeautyController {

    @Autowired
    private PalvelutRepositorio palvrepo;

    @Autowired
    private TyontekijatRepositorio tyorepo;

    @Autowired
    private KayttajaRepositorio kaytrepo;

    @RequestMapping(value= "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value= {"/", "/alvobeauty"})
    public String alvoBeauty(Model model) {
        model.addAttribute("tyontekijat", tyorepo.findAll());
        model.addAttribute("palvelut", palvrepo.findAll());
        return "alvobeauty";
    }
    @RequestMapping("/palvelutLista")
    public String palvelutLista(Model model) {
    model.addAttribute("palvelut", palvrepo.findAll());
    return "palvelutLista";
    }

    @RequestMapping("/tyontekijaLista")
    public String tyontekijaLista(Model model) {
    model.addAttribute("tyontekijat", tyorepo.findAll());
    return "tyontekijaLista";
    }


    @GetMapping("/lisaaTyontekija")
    @PreAuthorize("hasRole('toimitusjohtaja')")
    public String lisaaTyontekija(Model model) {
        model.addAttribute("tyontekija", new Tyontekijat());
        return "lisaaTyontekija";
    }

    @GetMapping("/lisaaPalvelu")
    @PreAuthorize("hasRole('toimitusjohtaja')")
    public String lisaaPalvelu(Model model) {
        model.addAttribute("tyontekijat", tyorepo.findAll());
         model.addAttribute("palvelu", new Palvelut());
        return "lisaaPalvelu";
    }
    @GetMapping("/lisaakayttaja")
    @PreAuthorize("hasRole('toimitusjohtaja')")
    public String lisaaKayttaja(Model model) {
        model.addAttribute("kayttaja", new Kayttaja());
        return "lisaaKayttaja";
    }

   @RequestMapping( value = "/tallennatyontekija", method = RequestMethod.POST)
    public String tallennaTyontekija(@Valid @ModelAttribute("tyontekija") Tyontekijat tyontekija, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("tyontekija", tyontekija);
            return "/lisaaTyontekija";
        }
        System.out.println("Tallenna" + tyontekija);
        tyorepo.save(tyontekija);
        return "redirect:/tyontekijaLista";
    }
  
    @RequestMapping(value ="/tallennapalvelu", method = RequestMethod.POST)
        public String tallennaPalvelu(@Valid @ModelAttribute("palvelu") Palvelut palvelu, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("palvelu", palvelu);
            model.addAttribute("tyontekijat", tyorepo.findAll());
            return "/lisaaPalvelu";
        }
        System.out.println("Tallenna " + palvelu);
        palvrepo.save(palvelu);
        return "redirect:/palvelutLista";
    }
    @PostMapping("/tallennakayttaja")
    public String tallennaKayttaja(@ModelAttribute Kayttaja kayttaja){
        kaytrepo.save(kayttaja);
        return "redirect:/kayttajaLista";
    }

    @GetMapping("/editoityontekija/{tTId}")
    @PreAuthorize("hasRole('toimitusjohtaja')")
    public String editoiTyontekija(@PathVariable("tTId") Long tTId, Model model){
        model.addAttribute("editoiTyontekija", tyorepo.findById(tTId));
        return "editoiTyontekija";
    }
    @GetMapping("/editoipalvelu/{palvId}")
    @PreAuthorize("hasRole('toimitusjohtaja')")
    public String editoiPalvelu(@PathVariable("palvId") Long palvId, Model model){
        model.addAttribute("editoiPalvelu", palvrepo.findById(palvId));
        model.addAttribute("tyontekijat", tyorepo.findAll());
        return "editoiPalvelu";
    }

   /*  @PostMapping("/tallennaeditoitutyontekija")
    public String tallennaEditoituTyontekija(Tyontekijat tyontekija){
        tyorepo.save(tyontekija);
        return "redirect:/tyontekijaLista";}*/
    
    @RequestMapping(value = "/tallennaeditoitutyontekija", method = RequestMethod.POST)
    public String tallennaEditoituTyontekija(@Valid @ModelAttribute("tyontekija")Tyontekijat tyontekija, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("tyontekija", tyontekija);
            return "editoityontekija";
        }
        tyorepo.save(tyontekija);
        return "redirect:/tyontekijaLista";
    }

    @PostMapping("/tallennaeditoitupalvelu")
    public String tallennaEditoituPalvelu(Palvelut palvelu){
        palvrepo.save(palvelu);
        return "redirect:/palvelutLista";
    }


    @PreAuthorize("hasRole('toimitusjohtaja')")
    @RequestMapping(value = "/poistatyontekija/{tTId}", method = RequestMethod.GET)
    
    public String poistaTyontekija(@PathVariable("tTId") Long tTId) {
        tyorepo.deleteById(tTId);
        return "redirect:/tyontekijaLista";
    }

    @PreAuthorize("hasRole('toimitusjohtaja')")
    @RequestMapping(value = "/poistapalvelu/{palvId}", method = RequestMethod.GET)
    
    public String poistaPalvelu(@PathVariable("palvId") Long palvId) {
        palvrepo.deleteById(palvId);
        return "redirect:/palvelutLista";
    }
    
}
