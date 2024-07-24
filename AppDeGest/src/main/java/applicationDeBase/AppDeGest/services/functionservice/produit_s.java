package applicationDeBase.AppDeGest.services.functionservice;

import applicationDeBase.AppDeGest.Entity.produit;
import applicationDeBase.AppDeGest.Repository.produitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class produit_s {

    private final produitRepository produitrepository;

    public produit_s(produitRepository produitRepository) {
        this.produitrepository = produitRepository;
    }

    public List<produit> afficher() {
        return produitrepository.findAll();
    }

    public produit ajouterProduit(produit produit) {
        return produitrepository.save(produit);
    }

    public produit modifierProduit(Long id_prod, produit produitModifie) {
        Optional<produit> optionalProduit = produitrepository.findById(id_prod);

        if (optionalProduit.isPresent()) {
            produit produit = optionalProduit.get();

            // Mettre à jour les champs nécessaires
            produit.setNom_prod(produitModifie.getNom_prod());
            produit.setQte_prod(produitModifie.getQte_prod());

            // Enregistrer et retourner le produit mis à jour
            return produitrepository.save(produit);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID: " + id_prod);
        }
    }

    public void supprimerProduit(Long id_prod) {
        Optional<produit> optionalProduit = produitrepository.findById(id_prod);

        if (optionalProduit.isPresent()) {
            produit produit = optionalProduit.get();
            produit.setActif(false); // Marquer le produit comme non actif
            produitrepository.save(produit);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID: " + id_prod);
        }
    }
}
