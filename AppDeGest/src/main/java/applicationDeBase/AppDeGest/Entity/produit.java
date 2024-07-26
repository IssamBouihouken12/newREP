package applicationDeBase.AppDeGest.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


@Table(name="produits")

public class produit {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_prod;
    private String nom_prod;
    private int qte_prod;
    @Column (name="actif")
    private boolean actif = true;


    @Override
    public String toString() {
        return "Produit [id_prod=" + id_prod+
                ", qte_prod=" + qte_prod +
                ", nom_prod=" + nom_prod + "]";
    }
}

