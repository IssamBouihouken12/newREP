package applicationDeBase.AppDeGest.controller;

import applicationDeBase.AppDeGest.Entity.produit;
import applicationDeBase.AppDeGest.services.functionservice.produit_s;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produits")
public class produitcontroller {

    private final produit_s produitService;

    public produitcontroller(produit_s produitService) {
        this.produitService = produitService;
    }

    @GetMapping()
    public String listProduits(Model model) {
        List<produit> produits = produitService.afficher();
        model.addAttribute("produits", produits);
        return "produits/list";
    }

    @GetMapping("/create")
    public String createProduitForm(Model model) {
        model.addAttribute("produit", new produit());
        return "produits/form";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute("produit") produit produit) {
        produitService.ajouterProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/edit/{id}")
    public String editProduitForm(@PathVariable("id") Long id, Model model) {
        Optional<produit> produitOpt = produitService.afficher().stream().filter(p -> p.getId_prod().equals(id)).findFirst();
        if (produitOpt.isPresent()) {
            model.addAttribute("produit", produitOpt.get());
            return "produits/form";
        } else {
            return "redirect:/produits";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProduit(@PathVariable("id") Long id, @ModelAttribute("produit") produit produit) {
        produit.setId_prod(id);
        produitService.modifierProduit(id, produit);
        return "redirect:/produits";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Long id) {
        produitService.supprimerProduit(id);
        return "redirect:/produits";
    }
}

