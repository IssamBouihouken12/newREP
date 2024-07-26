package applicationDeBase.AppDeGest.services.functionservice;
import applicationDeBase.AppDeGest.Entity.stock;
import applicationDeBase.AppDeGest.Repository.fournisseurRepository;
import applicationDeBase.AppDeGest.Repository.stockRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
    public  class stock_s {
    public stock_s(stockRepository stockrepository) {
        this.stockrepository = stockrepository;
    }
    stockRepository stockrepository;
    public List<stock> Afficher()
    { return stockrepository.findAll();}
    public stock ajouterstock(stock stock) {
        return stockrepository.save(stock);
    }
    public stock modifierstock(Long id_stock, stock stockModifie) {
        Optional<stock> optionalStock = stockrepository.findById(id_stock);

        if (optionalStock.isPresent()) {
            stock stock = optionalStock.get();
            stock.setId_stock(stockModifie.getId_stock());
            stock.setId_mat(stockModifie.getId_mat());
            stock.setQte_mat(stockModifie.getQte_mat());
            return stockrepository.save(stock);
        } else {
            throw new RuntimeException("stock non trouvé avec l'ID: " + id_stock);
        }
    }
    public void supprimerstock(Long id_stock) {
        stock f =  stockrepository.findById(id_stock).get();
        if (f!=null) {
            f.setActif(false);
            stockrepository.save(f);
        } else {
            throw new RuntimeException("Stock non trouvé avec l'ID: " + id_stock);
        }
    }
}
