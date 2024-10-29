package projekti.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import projekti.demo.domain.AlvoBeautyRepositorio;
import projekti.demo.domain.Tyontekijat;
import projekti.demo.domain.TyontekijatRepositorio;
import projekti.demo.domain.Palvelut;
import projekti.demo.domain.PalvelutRepositorio;

import projekti.demo.domain.Kayttaja;
import projekti.demo.domain.KayttajaRepositorio;
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@Bean
public CommandLineRunner alvoBeautyData(AlvoBeautyRepositorio abRepo, TyontekijatRepositorio tyoRepo, PalvelutRepositorio palRepo,
KayttajaRepositorio kaytRepo ){
	return(args) -> {
		
		Tyontekijat tyontekija1 = new Tyontekijat("admin", "admin", "04492345325",
		 "shfdssgfd", "Vanhatie 3", 2007, "Lisätiedot");

		Tyontekijat tyontekija2 = new Tyontekijat("user", "user", "04492345325",
		 "sahssgh", "Vanhatie 3", 2007, "Lisätiedot");

		 Tyontekijat tyontekija3 = new Tyontekijat("erica", "ADMIN", "04492345325",
		 "sghsdsgdf", "Vanhatie 3", 2007, "Lisätiedot");

		 Tyontekijat tyontekija4 = new Tyontekijat("leo", "toimitusjohtaja", "04492345325",
		 "sfhdg", "Vanhatie 3", 2007, "Lisätiedot");

		 Tyontekijat tyontekija5 = new Tyontekijat("jeremias", "päällikkö", "04492345325",
		 "fhfdhsgf", "Vanhatie 3", 2007, "Lisätiedot");

		 Tyontekijat tyontekija6 = new Tyontekijat("jack", "koira", "04492345325",
		 "hgshdgsdf", "Vanhatie 3", 2007, "Lisätiedot");
		
		tyoRepo.save(tyontekija1);
		tyoRepo.save(tyontekija2);
		tyoRepo.save(tyontekija3);
		tyoRepo.save(tyontekija4);
		tyoRepo.save(tyontekija5);
		tyoRepo.save(tyontekija6);


		 palRepo.save(new Palvelut(tyontekija1, new BigDecimal("9.99"), "kynsipalvleu", "ashgdsfadgfg" ));
		 palRepo.save(new Palvelut(tyontekija2, new BigDecimal("9.99"), "ripset", "ashgdsfadgfg" ));
		 palRepo.save(new Palvelut(tyontekija3, new BigDecimal("9.99"), "naama", "ashgdsfadgfg" ));
		 palRepo.save(new Palvelut(tyontekija4, new BigDecimal("9.99"), "hiukset", "ashgdsfadgfg" ));
		 palRepo.save(new Palvelut(tyontekija5, new BigDecimal("9.99"), "jotain", "ashgdsfadgfg" ));
		
		Kayttaja kayttaja1 = new Kayttaja("erica", "$2a$10$xo3vNn7uwYMTZPUAPLhQQ.GUoYSyZ/lBIWgQcKoYw9OhBxuAfxmu.", "toimitusjohtaja");
		Kayttaja kayttaja2 = new Kayttaja("raquel", "$2a$10$SUeD/lzpiOnVRvOUME/Kv.KO.PNfgkjUa6lnBBcnNJxlJgNPPBnbK", "Työntekijä" );
		Kayttaja kayttaja3 = new Kayttaja("milla", "$2a$10$v73zm2h1ToiK4oamxyV7ZufJquN7zV8c3VU85ouyUb1TQAXhZz3My", "Työntekijä");
		Kayttaja kayttaja4 = new Kayttaja("jack", "$2a$10$ftVbxn.dHHV6LWxOFPyXl.J5XWZCwr7gBvTVnIgXrR1Mfi1Lalb3W", "toimitusjohtaja");
		Kayttaja kayttaja5 = new Kayttaja("admin", "$2a$10$NstqhK2hJwVkOmYrNgzaxu6823b9ea6cFG5BiD/d9CTt.Pwp1WZAm", "toimitusjohtaja" );
		Kayttaja kayttaja6 = new Kayttaja("user", "$2a$10$ByD.6qqYUBkHgAouMjoSl.SChORIAeDw4vunHHbJbr7d/ZY6FGHAe", "user");
		kaytRepo.save(kayttaja1);
		kaytRepo.save(kayttaja2);
		kaytRepo.save(kayttaja3);
		kaytRepo.save(kayttaja4);
		kaytRepo.save(kayttaja5);
		kaytRepo.save(kayttaja6);
	
		};
}
}
