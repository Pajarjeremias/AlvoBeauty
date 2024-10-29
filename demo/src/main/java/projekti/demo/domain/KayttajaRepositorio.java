package projekti.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepositorio extends CrudRepository<Kayttaja, Long> {
    Kayttaja findByKaytId(Long kaytId);
    Kayttaja findByUsername(String username);
    Kayttaja findByRole(String role);
    Kayttaja findByPassword(String password);
}
