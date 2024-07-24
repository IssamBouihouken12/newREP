package applicationDeBase.AppDeGest.controller;

import applicationDeBase.AppDeGest.Entity.matiere_premiere;
import applicationDeBase.AppDeGest.services.functionservice.matiere_premiere_s;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres_premieres")
public class matiere_premierecontroller {

    private final matiere_premiere_s matiere_premiere_service;

    public matiere_premierecontroller(matiere_premiere_s matiere_premiere_service) {
        this.matiere_premiere_service = matiere_premiere_service;
    }

    @GetMapping("/show_matiere_premiere")
    public List<matiere_premiere> Afficher() {
        return matiere_premiere_service.Afficher();
    }

    @PostMapping("/add_matiere_premiere")
    public matiere_premiere ajoutermatierepremiere(@RequestBody matiere_premiere matierepremiere) {
        return matiere_premiere_service.ajouterMatierePremiere(matierepremiere);
    }

    @PutMapping("/modify_matiere_premiere/{id_mat}")
    public matiere_premiere modifiermatiere_premiere(@PathVariable Long id_mat, @RequestBody matiere_premiere matierepremiereModifie) {
        return matiere_premiere_service.modifierMatierePremiere(id_mat, matierepremiereModifie);
    }

    @DeleteMapping("/delete_matierepremiere/{id_mat}")
    public void supprimermatierepremiere(@PathVariable Long id_mat) {
        matiere_premiere_service.supprimerMatierePremiere(id_mat);
    }
}
