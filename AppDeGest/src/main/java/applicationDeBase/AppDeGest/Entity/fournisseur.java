package applicationDeBase.AppDeGest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fournisseurs")
public class fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_four")
    private Long id_four;
    @Column(nullable = false)
    private Boolean actif=false;
    @Column(name = "nom_four", nullable = false)
    private String nom_four;

    @Column(name = "tel_four", nullable = false)
    private Long tel_four;

    @Column(name = "adresse_four", nullable = false)
    private String adresse_four;

    public fournisseur(Optional<fournisseur> byId) {
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return "Fournisseur [id=" + id_four + ", nom fournisseur=" + nom_four +
                ", telephone fournisseur=" + tel_four + ", adresse fournisseur=" + adresse_four + "]";
    }
}
