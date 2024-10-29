package projekti.demo.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PalvelutRepositorio extends CrudRepository<Palvelut, Long> {
    List<Palvelut> findByNimi(String nimi);
    
    /*List<Palvelut> findByHinta(BigDecimal hinta);
    Palvelut findByPalvId(Long palvId); 
    Optional<Palvelut> findByKuvaus(String kuvaus);
    Optional<Palvelut> findByTyontekijat_TTId(Long tTId);
    List<Palvelut> findByAlvoBeauty_aBId(Long aBId);*/
    
}
