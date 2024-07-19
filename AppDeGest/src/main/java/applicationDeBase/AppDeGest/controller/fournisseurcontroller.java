package applicationDeBase.AppDeGest.controller;
import applicationDeBase.AppDeGest.Entity.fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import applicationDeBase.AppDeGest.Repository.fournisseurRepository;

import java.util.List;

import applicationDeBase.AppDeGest.services.functionservice.fournisseur_s;

import javax.validation.Valid;
@Service
@Repository

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class fournisseurcontroller {
    fournisseur_s fournisseur_service;

    @Autowired
    private fournisseurRepository fournisseurRepository;

    public fournisseurcontroller(fournisseur_s fournisseur_service) {
        this.fournisseur_service = fournisseur_service;
    }

    @GetMapping("/show")
    public List<fournisseur> Afficher() {
        return fournisseur_service.Afficher();
    }
}
//    }
//    @GetMapping("/new")
//    public String createfournisseur(fournisseur newfournisseur)
//    {newfournisseur.addAttribute("salam")}
//    ;
//@PostMapping ("/add")
//public fournisseur addfournisseur (fournisseur newfournisseur) {
//        return fournisseur_s.save(newfournisseur);
//}
//        @PostMapping
//        public ResponseEntity<fournisseur> createFournisseur(@Valid @RequestBody fournisseur nouveauFournisseur) {
//            fournisseur fournisseurCree = fournisseur_s.sauvegarderFournisseur(nouveauFournisseur);
//            return new ResponseEntity<>(fournisseurCree, HttpStatus.CREATED);
//        }
//}

//    public Optional<fournisseur> findById(Long id) {
//        return fournisseurRepository.findById(id);
//
//    }


//    @GetMapping("/fournisseurs/{id}")
//    public ResponseEntity<fournisseur> getfournisseurByid_four(@PathVariable(value = "id_four") Long id_four)
//            throws ResourceNotFoundException {
//        fournisseur fournisseur = fournisseurRepository.findById(id_four);
//                return ResponseEntity.ok().body(fournisseur);
//    }


//    @PostMapping("/fournisseurs")
//    public fournisseur createfournisseur(@Valid @RequestBody fournisseur fournisseur) {
//        return fournisseurRepository.save(fournisseur);
//    }
//
//    @PutMapping("/fournisseurs/{id}")
//    public ResponseEntity<fournisseur> updatefournisseur(@PathVariable(value = "id") Long id_four,
//                                                      @Valid @RequestBody fournisseur fournisseurRepository) throws ResourceNotFoundException {
//        fournisseur fournisseur = fournisseurRepository.findById(id_four);
//
//        fournisseur.setId_four(fournisseurRepository.getId_four());
//        fournisseur.setNom_four(fournisseurRepository.getnom_four());
//        fournisseur.settel_four(fournisseurRepository.gettel_four());
//        fournisseur.setadresse_four(fournisseurRepository.getadresse_four());
//        final fournisseur updatedFournisseur = repository.fournisseurRepository.save(fournisseur);
//        return ResponseEntity.ok(updatedFournisseur);
//    }
//
//    @DeleteMapping("/fournisseurs/{id}")
//    public Map<String, Boolean> deletefournisseur(@PathVariable(value = "id") Long id_four)
//            throws ResourceNotFoundException {
//        fournisseur fournisseur = fournisseurRepository.findById(id_four)
//
//        fournisseurRepository.delete(fournisseur);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }




