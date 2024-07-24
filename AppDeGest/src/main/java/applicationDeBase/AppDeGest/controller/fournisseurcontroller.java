package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.fournisseur;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import applicationDeBase.AppDeGest.services.functionservice.fournisseur_s;
@Service
@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class fournisseurcontroller {
public fournisseur_s fournisseur_service;


    public fournisseurcontroller(fournisseur_s fournisseur_service) {
        this.fournisseur_service = fournisseur_service;
    }

    @GetMapping("/show_fournisseur")
    public List<fournisseur> Afficher() {
        return fournisseur_service.Afficher();
    }
    @PostMapping("/add_fournisseur")
    public fournisseur ajouterfournisseur(@RequestBody fournisseur fournisseur) {
        return fournisseur_service.ajouterfournisseur(fournisseur);
    }
    @PutMapping("/modify_fournisseur")
    public fournisseur modifierfournisseur(@PathVariable Long id_four, @RequestBody fournisseur fournisseurModifie) {
        return fournisseur_service.modifierfournisseur(id_four, fournisseurModifie);
    }
    @DeleteMapping("/delete_fournisseur")
    public void supprimerfournisseur(@PathVariable Long id_four) {
        fournisseur_service.supprimerfournisseur(id_four);
    }
}


