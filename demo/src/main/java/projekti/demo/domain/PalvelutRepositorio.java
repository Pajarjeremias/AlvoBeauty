package projekti.demo.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PalvelutRepositorio extends CrudRepository<Palvelut, Long> {
    List<Palvelut> findByNimi(String nimi);
}
