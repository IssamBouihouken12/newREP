package applicationDeBase.AppDeGest.Repository;

import applicationDeBase.AppDeGest.Entity.produit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface produitRepository extends JpaRepository<produit, Long>{
}
