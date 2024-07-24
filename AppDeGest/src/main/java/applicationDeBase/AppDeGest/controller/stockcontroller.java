package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.stock;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import applicationDeBase.AppDeGest.services.functionservice.stock_s;
@Service
@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class stockcontroller {
    public stock_s stock_service;


    public stockcontroller(stock_s stock_service) {
        this.stock_service = stock_service;
    }

    @GetMapping("/show_stock")
    public List<stock> Afficher() {
        return stock_service.Afficher();
    }
    @PostMapping("/add_stock")
    public stock ajouterstock(@RequestBody stock stock) {
        return stock_service.ajouterstock(stock);
    }
    @PutMapping("/modify_stock")
    public stock modifierstock(@PathVariable Long id_stock, @RequestBody stock stockModifie) {
        return stock_service.modifierstock(id_stock, stockModifie);
    }
    @DeleteMapping("/delete_stock")
    public void supprimerstock(@PathVariable Long id_stock) {
        stock_service.supprimerstock(id_stock);
    }
}


