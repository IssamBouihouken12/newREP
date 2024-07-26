package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.fournisseur;
import applicationDeBase.AppDeGest.services.functionservice.fournisseur_s;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/fournisseurs")
public class fournisseurcontroller {

    private final fournisseur_s fournisseurService;

    public fournisseurcontroller(fournisseur_s fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/list")
    public String listFournisseurs(Model model) {
        List<fournisseur> fournisseurs = fournisseurService.Afficher();
        model.addAttribute("fournisseurs", fournisseurs);
        return "fournisseurs/index";
    }

    @GetMapping("/create")
    public String createFournisseurForm(Model model) {
        model.addAttribute("fournisseur", new fournisseur());
        return "fournisseurs/form";
    }

    @PostMapping("/save")
    public String saveFournisseur(@ModelAttribute("fournisseur") fournisseur fournisseur) {
        fournisseurService.ajouterfournisseur(fournisseur);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/edit/{id}")
    public String editFournisseurForm(@PathVariable("id") Long id, Model model) {
        Optional<fournisseur> fournisseurOpt = fournisseurService.Afficher().stream().filter(f -> f.getId_four().equals(id)).findFirst();
        if (fournisseurOpt.isPresent()) {
            model.addAttribute("fournisseur", fournisseurOpt.get());
            return "fournisseurs/form";
        } else {
            return "redirect:/fournisseurs";
        }
    }

    @PostMapping("/update/{id}")
    public String updateFournisseur(@PathVariable("id") Long id, @ModelAttribute("fournisseur") fournisseur fournisseur) {
        fournisseur.setId_four(id);
        fournisseurService.modifierfournisseur(id, fournisseur);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/delete/{id}")
    public String deleteFournisseur(@PathVariable("id") Long id) {
        fournisseurService.supprimerfournisseur(id);
        return "redirect:/fournisseurs";
    }
}
