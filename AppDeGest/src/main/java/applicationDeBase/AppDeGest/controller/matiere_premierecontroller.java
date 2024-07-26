package applicationDeBase.AppDeGest.controller;

import applicationDeBase.AppDeGest.Entity.matiere_premiere;
import applicationDeBase.AppDeGest.services.functionservice.matiere_premiere_s;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/matieres_premieres")
public class matiere_premierecontroller {

    private final matiere_premiere_s matiere_premiere_service;

    public matiere_premierecontroller(matiere_premiere_s matiere_premiere_service) {
        this.matiere_premiere_service = matiere_premiere_service;
    }

    @GetMapping
    public String listMatieresPremieres(Model model) {
        List<matiere_premiere> matieresPremieres = matiere_premiere_service.Afficher();
        model.addAttribute("matieres_premieres", matieresPremieres);
        return "matieres_premieres/list";
    }

    @GetMapping("/create")
    public String createMatierePremiereForm(Model model) {
        model.addAttribute("matiere_premiere", new matiere_premiere());
        return "matieres_premieres/form";
    }

    @PostMapping("/save")
    public String saveMatierePremiere(@ModelAttribute("matiere_premiere") matiere_premiere matiere_premiere) {
        matiere_premiere_service.ajouterMatierePremiere(matiere_premiere);
        return "redirect:/matieres_premieres";
    }

    @GetMapping("/edit/{id}")
    public String editMatierePremiereForm(@PathVariable("id") Long id, Model model) {
        Optional<matiere_premiere> matierePremiereOpt = matiere_premiere_service.Afficher().stream().filter(m -> m.getId_mat().equals(id)).findFirst();
        if (matierePremiereOpt.isPresent()) {
            model.addAttribute("matiere_premiere", matierePremiereOpt.get());
            return "matieres_premieres/form";
        } else {
            return "redirect:/matieres_premieres";
        }
    }

    @PostMapping("/update/{id}")
    public String updateMatierePremiere(@PathVariable("id") Long id, @ModelAttribute("matiere_premiere") matiere_premiere matiere_premiere) {
        matiere_premiere.setId_mat(id);
        matiere_premiere_service.modifierMatierePremiere(id, matiere_premiere);
        return "redirect:/matieres_premieres";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatierePremiere(@PathVariable("id") Long id) {
        matiere_premiere_service.supprimerMatierePremiere(id);
        return "redirect:/matieres_premieres";
    }
}
