package applicationDeBase.AppDeGest.services.functionservice;
import applicationDeBase.AppDeGest.Entity.user;
import applicationDeBase.AppDeGest.Repository.userRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class user_s {
    public user_s(userRepository userrepository) {
        this.userrepository = userrepository;
    }
    userRepository userrepository;
    public List<user> Afficher()
    { return userrepository.findAll();}
    public user ajouteruser(user user) {
        return userrepository.save(user);
    }
    public user modifieruser(Long id_user, user userModifie) {
        Optional<user> optionalUser = userrepository.findById(id_user);

        if (optionalUser.isPresent()) {
            user user = optionalUser.get();
            user.setId_user(userModifie.getId_user());
            user.setNom_user(userModifie.getNom_user());
            user.setAdresse_user(userModifie.getAdresse_user());
            user.setTel_user(userModifie.getTel_user());
            user.setPoste_user(userModifie.getPoste_user());
            user.setDepartement_user(userModifie.getDepartement_user());
            return userrepository.save(user);
        } else {
            throw new RuntimeException("utilisateur  non trouvé avec l'ID: " + id_user);
        }
    }
    public void supprimeruser(Long id_user) {
        user f=  userrepository.findById(id_user).get();
        if (f!=null) {
            f.setActif(false);
            userrepository.save(f);
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID: " + id_user);
        }
    }
}

