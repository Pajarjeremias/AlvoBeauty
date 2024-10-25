package projekti.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import projekti.demo.domain.Kayttaja;
import projekti.demo.domain.KayttajaRepositorio;

@Service
public class KayttajaTietoToteutus implements UserDetailsService {
    
    @Autowired
    KayttajaRepositorio repositorio;
    
   /*  @Override
    public UserDetails loadUserByUsername(String kayttajatunnus) throws UsernameNotFoundException{

        Kayttaja tamanhetkinen = repositorio.findByKayttajatunnus(kayttajatunnus);
       
        UserDetails kayttaja = new org.springframework.security.core.userdetails.User(tamanhetkinen.getKayttajatunnus(), tamanhetkinen.getSalasana(),
        AuthorityUtils.createAuthorityList("ROLE_" + tamanhetkinen.getRooli()));
        return kayttaja;
    }    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Kayttaja tamanhetkinen = repositorio.findByUsername(username);
        
        if (tamanhetkinen == null) {
            throw new UsernameNotFoundException("Käyttäjää ei löytynyt: " + username);
        }
        
        UserDetails user = new org.springframework.security.core.userdetails.User(
            tamanhetkinen.getUsername(), 
            tamanhetkinen.getPassword(),
            AuthorityUtils.createAuthorityList("ROLE_" + tamanhetkinen.getRole())
        );
        return user;
}

}

