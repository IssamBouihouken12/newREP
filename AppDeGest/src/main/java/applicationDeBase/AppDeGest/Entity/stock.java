package applicationDeBase.AppDeGest.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Entity
    @Setter
    @Getter
    @ToString
    @Table(name="stocks")
    public class stock{

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        @Column(name = "id_stock")
        private Long id_stock;
        @Column(name = "id_mat")
        private Long id_mat;
        @Column(name = "qte_mat")
        private float qte_mat;
        @Column (name="actif")
        private boolean actif = true;



    }


