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


    @Table(name = "matiere_premieres")
    public class matiere_premiere {

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Long id_mat;
        private String code_article;
        private String libelle_article;
        private String fournisseur;
        private int qte_mat;
        private String dp_mat;
        private String unite_mesure;
        private double prix_unitaire;
        private String code_barre;
        private String type_mat;
        @Column (name="actif")
        private boolean actif = true;

        @Override
        public String toString() {
            return "MatierePremiere [id_mat=" + id_mat +
                    ", code_article=" + code_article +
                    ", libelle_article=" + libelle_article +
                    ", fournisseur=" + fournisseur +
                    ", qte_mat=" + qte_mat +
                    ", dp_mat=" + dp_mat +
                    ", unite_mesure=" + unite_mesure +
                    ", prix_unitaire=" + prix_unitaire +
                    ", code_barre=" + code_barre +
                    ", type_mat=" + type_mat + "]";
        }
    }
