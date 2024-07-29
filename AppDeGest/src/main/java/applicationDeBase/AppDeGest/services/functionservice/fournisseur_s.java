package applicationDeBase.AppDeGest.services.functionservice;

import applicationDeBase.AppDeGest.Entity.fournisseur;
import applicationDeBase.AppDeGest.Repository.fournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class fournisseur_s {

    private final fournisseurRepository fournisseurRepo;

    public fournisseur_s(fournisseurRepository fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }


    public List<fournisseur> Afficher() {
        return fournisseurRepo.findAll();
    }


    public Optional<fournisseur> findById(Long id) {
        return fournisseurRepo.findById(id);
    }


    public fournisseur ajouterfournisseur(fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }


    public fournisseur modifierfournisseur(Long id, fournisseur fournisseur) {
        if (fournisseurRepo.existsById(id)) {
            fournisseur.setId_four(id);
            return fournisseurRepo.save(fournisseur);
        }
        return null; // ou lancer une exception si le fournisseur n'existe pas
    }


    public void supprimerfournisseur(Long id) {
        if (fournisseurRepo.existsById(id)) {
            fournisseurRepo.deleteById(id);
        }
    }
}
