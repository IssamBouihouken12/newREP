package applicationDeBase.AppDeGest.services.functionservice;

import applicationDeBase.AppDeGest.Entity.matiere_premiere;
import applicationDeBase.AppDeGest.Repository.matiere_premiereRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class matiere_premiere_s {

    private final matiere_premiereRepository matierepremiererepository;

    public matiere_premiere_s(matiere_premiereRepository matierepremiererepository) {
        this.matierepremiererepository = matierepremiererepository;
    }

    public List<matiere_premiere> Afficher() {
        return matierepremiererepository.findAll();
    }

    public matiere_premiere ajouterMatierePremiere(matiere_premiere matierepremiere) {
        return matierepremiererepository.save(matierepremiere);
    }

    public matiere_premiere modifierMatierePremiere(Long id_mat, matiere_premiere matierepremiereModifie) {
        Optional<matiere_premiere> optionalMatierepremiere = matierepremiererepository.findById(id_mat);

        if (optionalMatierepremiere.isPresent()) {
            matiere_premiere matierepremiere = optionalMatierepremiere.get();

            // Mettre à jour les champs nécessaires
            matierepremiere.setCode_article(matierepremiereModifie.getCode_article());
            matierepremiere.setLibelle_article(matierepremiereModifie.getLibelle_article());
            matierepremiere.setFournisseur(matierepremiereModifie.getFournisseur());
            matierepremiere.setQte_mat(matierepremiereModifie.getQte_mat());
            matierepremiere.setDp_mat(matierepremiereModifie.getDp_mat());
            matierepremiere.setUnite_mesure(matierepremiereModifie.getUnite_mesure());
            matierepremiere.setPrix_unitaire(matierepremiereModifie.getPrix_unitaire());
            matierepremiere.setCode_barre(matierepremiereModifie.getCode_barre());
            matierepremiere.setType_mat(matierepremiereModifie.getType_mat());

            // Enregistrer et retourner la matiere premiere mise à jour
            return matierepremiererepository.save(matierepremiere);
        } else {
            // Gérer le cas où la matiere premiere avec cet ID n'est pas trouvée
            throw new RuntimeException("Matiere premiere non trouvée avec l'ID: " + id_mat);
        }
    }

    public void supprimerMatierePremiere(Long id_mat) {
        Optional<matiere_premiere> optionalMatierepremiere = matierepremiererepository.findById(id_mat);

        if (optionalMatierepremiere.isPresent()) {
            matiere_premiere matierepremiere = optionalMatierepremiere.get();
            matierepremiere.setActif(false);
            matierepremiererepository.save(matierepremiere);
        } else {
            throw new RuntimeException("Matiere premiere non trouvée avec l'ID: " + id_mat);
        }
    }
}
