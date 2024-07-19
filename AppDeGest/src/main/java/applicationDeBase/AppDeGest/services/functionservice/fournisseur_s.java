package applicationDeBase.AppDeGest.services.functionservice;

import applicationDeBase.AppDeGest.Entity.fournisseur;
import applicationDeBase.AppDeGest.Repository.fournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class fournisseur_s {
    public fournisseur_s(fournisseurRepository fournisseurrepository) {
        this.fournisseurrepository = fournisseurrepository;
    }

    fournisseurRepository fournisseurrepository;



    public List<fournisseur> Afficher()
    { return fournisseurrepository.findAll();}
 public static fournisseur addfournisseur(fournisseur newfournisseur){
        newfournisseur.setNom_four("salim");
        return newfournisseur;
 }
//    public fournisseur sauvegarderFournisseur(fournisseur fournisseur) {
//        return fournisseurRepository.save(fournisseur);
//    }
}
