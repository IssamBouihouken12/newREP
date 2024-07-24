package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.user;
import applicationDeBase.AppDeGest.services.functionservice.user_s;
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
public class usercontroller {
    public user_s user_service;


    public usercontroller(user_s user_service) {
        this.user_service=user_service;
    }

    @GetMapping("/show_user")
    public List<user> Afficher() {
        return user_service.Afficher();
    }
    @PostMapping("/add_user")
    public user ajouterfournisseur(@RequestBody user user) {
        return user_service.ajouteruser(user);
    }
    @PutMapping("/modify_fuser")
    public user modifieruser(@PathVariable Long id_user, @RequestBody user userModifie) {
        return user_service.modifieruser(id_user, userModifie);
    }
    @DeleteMapping("/delete_user")
    public void supprimeruser(@PathVariable Long id_user) {
        user_service.supprimeruser(id_user);
    }
}


