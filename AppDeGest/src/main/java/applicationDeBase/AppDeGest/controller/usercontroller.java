package applicationDeBase.AppDeGest.controller;

import applicationDeBase.AppDeGest.Entity.user;
import applicationDeBase.AppDeGest.Repository.userRepository;
import applicationDeBase.AppDeGest.services.functionservice.user_s;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class usercontroller {

    private final user_s userService;
    private final applicationDeBase.AppDeGest.Repository.userRepository userRepository;

    public usercontroller(user_s userService, userRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // Afficher la liste des utilisateurs
    @GetMapping
    public String listUsers(Model model) {
        List<user> users = userService.Afficher();
        model.addAttribute("users", users);
        return "list_users";  // Nom du template Thymeleaf pour afficher la liste
    }

    // Afficher le formulaire pour ajouter un nouvel utilisateur
    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new user());
        return "create_user";  // Nom du template Thymeleaf pour créer un nouvel utilisateur
    }

    // Ajouter un nouvel utilisateur
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") user user) {
        userService.ajouteruser(user);
        return "redirect:/users";  // Redirection vers la liste des utilisateurs après ajout
    }

    // Afficher le formulaire pour modifier un utilisateur existant
    @GetMapping("/edit/{id_user}")
    public String editUserForm(@PathVariable("id_user") Long id_user, Model model) {
        user user = userRepository.findById(id_user).get();  // Méthode à ajouter dans votre service pour récupérer un utilisateur par ID
        if (user != null) {
            model.addAttribute("user", user);
            return "edit_user";  // Nom du template Thymeleaf pour modifier un utilisateur
        }
        return "redirect:/users";  // Redirection si l'utilisateur n'existe pas
    }

    // Mettre à jour un utilisateur existant
    @PostMapping("/update/{id_user}")
    public String updateUser(@PathVariable("id_user") Long id_user, @ModelAttribute("user") user user) {
        user.setId_user(id_user);  // Assurer que l'ID de l'utilisateur est correctement mis à jour
        userService.modifieruser(id_user, user);
        return "redirect:/users";  // Redirection vers la liste des utilisateurs après modification
    }

    // Supprimer un utilisateur
    @GetMapping("/delete/{id_user}")
    public String deleteUser(@PathVariable("id_user") Long id_user) {
        userService.supprimeruser(id_user);
        return "redirect:/users";  // Redirection vers la liste des utilisateurs après suppression
    }
}
