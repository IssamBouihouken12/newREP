package applicationDeBase.AppDeGest.controller;

import applicationDeBase.AppDeGest.Entity.stock;
import applicationDeBase.AppDeGest.Repository.stockRepository;
import applicationDeBase.AppDeGest.services.functionservice.stock_s;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stocks")
public class stockcontroller {

    private final stock_s stockService;
    private final stockRepository stockRepository;

    public stockcontroller(stock_s stockService, stockRepository stockRepository) {
        this.stockService = stockService;
        this.stockRepository = stockRepository;
    }

    // Afficher la liste des stocks
    @GetMapping
    public String listStocks(Model model) {
        List<stock> stocks = stockService.Afficher();
        model.addAttribute("stocks", stocks);
        return "list_stocks";  // Nom du template Thymeleaf pour afficher la liste
    }

    // Afficher le formulaire pour ajouter un nouveau stock
    @GetMapping("/create")
    public String createStockForm(Model model) {
        model.addAttribute("stock", new stock());
        return "create_stock";  // Nom du template Thymeleaf pour créer un nouveau stock
    }

    // Ajouter un nouveau stock
    @PostMapping("/save")
    public String saveStock(@ModelAttribute("stock") stock stock) {
        stockService.ajouterstock(stock);
        return "redirect:/stocks";  // Redirection vers la liste des stocks après ajout
    }

    // Afficher le formulaire pour modifier un stock existant
    @GetMapping("/edit/{id_stock}")
    public String editStockForm(@PathVariable("id_stock") Long id_stock, Model model) {
        Optional<stock> stockOpt = stockRepository.findById(id_stock);  // Méthode à ajouter dans votre service pour récupérer un stock par ID
        if (stockOpt.isPresent()) {
            model.addAttribute("stock", stockOpt.get());
            return "edit_stock";  // Nom du template Thymeleaf pour modifier un stock
        }
        return "redirect:/stocks";  // Redirection si le stock n'existe pas
    }

    // Mettre à jour un stock existant
    @PostMapping("/update/{id_stock}")
    public String updateStock(@PathVariable("id_stock") Long id_stock, @ModelAttribute("stock") stock stock) {
        stock.setId_stock(id_stock);  // Assurer que l'ID du stock est correctement mis à jour
        stockService.modifierstock(id_stock, stock);
        return "redirect:/stocks";  // Redirection vers la liste des stocks après modification
    }

    // Supprimer un stock
    @GetMapping("/delete/{id_stock}")
    public String deleteStock(@PathVariable("id_stock") Long id_stock) {
        stockService.supprimerstock(id_stock);
        return "redirect:/stocks";  // Redirection vers la liste des stocks après suppression
    }
}
