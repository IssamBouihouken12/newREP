package applicationDeBase.AppDeGest.services.functionservice;

import applicationDeBase.AppDeGest.Entity.fournisseur;
import applicationDeBase.AppDeGest.Repository.fournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class fournisseur_s {
    public fournisseur_s(fournisseurRepository fournisseurrepository) {
        this.fournisseurrepository = fournisseurrepository;
    }

    fournisseurRepository fournisseurrepository;



    public List<fournisseur> Afficher()
    { return fournisseurrepository.findAll();}
    public fournisseur ajouterfournisseur(fournisseur fournisseur) {
        return fournisseurrepository.save(fournisseur);
    }
    public fournisseur modifierfournisseur(Long id_four, fournisseur fournisseurModifie) {
        Optional<fournisseur> optionalFournisseur = fournisseurrepository.findById(id_four);

        if (optionalFournisseur.isPresent()) {
            fournisseur fournisseur = optionalFournisseur.get();
            fournisseur.setNom_four(fournisseurModifie.getNom_four());
            fournisseur.setTel_four(fournisseurModifie.getTel_four());
            fournisseur.setAdresse_four(fournisseurModifie.getAdresse_four());
            return fournisseurrepository.save(fournisseur);
        } else {
            throw new RuntimeException("Fournisseur non trouvé avec l'ID: " + id_four);
        }
    }
    public void supprimerfournisseur(Long id_four) {
        fournisseur f =  fournisseurrepository.findById(id_four).get();
        if (f!=null) {
            f.setActif(false);
            fournisseurrepository.save(f);
        } else {
            throw new RuntimeException("Fournisseur non trouvé avec l'ID: " + id_four);
        }
    }
}
