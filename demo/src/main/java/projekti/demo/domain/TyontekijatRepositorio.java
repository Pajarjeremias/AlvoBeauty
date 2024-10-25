package projekti.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TyontekijatRepositorio extends CrudRepository<Tyontekijat, Long> {

   List<Tyontekijat> findByNimi(String nimi);
    /*List<Tyontekijat> findByRooli(String rooli);
    List<Tyontekijat> findByPuhnumero(String puhnumero);
    List<Tyontekijat> findByEmail(String email);
    List<Tyontekijat> findByOsoite(String osoite);
    List<Tyontekijat> findByTyosuhdealku(int tyosuhdealku);
    Optional<Tyontekijat> findByLisatiedot(String lisatiedot);
    Optional<Tyontekijat> findByTTId(Long tTId);  
    List<Tyontekijat> findByAlvoBeauty_aBId(Long aBId);
    List<Tyontekijat> findByPalvelu_PalvId(Long palvId);*/
} 
