package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.produit;
import applicationDeBase.AppDeGest.services.functionservice.produit_s;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Service
@RestController
@RequestMapping("/produits")
public class produitcontroller {

    public produit_s produitService;

    public produitcontroller(produit_s produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/show_produits")
    public List<produit> afficher() {
        return produitService.afficher();
    }

    @PostMapping("/add_produit")
    public produit ajouterProduit(@RequestBody produit nouveauProduit) {
        return produitService.ajouterProduit(nouveauProduit);
    }

    @PutMapping("/modify_produit/{id_prod}")
    public produit modifierProduit(@PathVariable Long id_prod, @RequestBody produit produitModifie) {
        return produitService.modifierProduit(id_prod, produitModifie);
    }

    @DeleteMapping("/delete_produit/{id_prod}")
    public void supprimerProduit(@PathVariable Long id_prod) {
        produitService.supprimerProduit(id_prod);
    }
}
