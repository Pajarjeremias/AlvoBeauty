package projekti.demo.web;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import projekti.demo.web.WebTurvaKonfiguraatio;

@Configuration
@EnableMethodSecurity(securedEnabled = true)

public class WebTurvaKonfiguraatio {
    @Autowired
	private KayttajaTietoToteutus kayttajaToteutus;

	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
		new AntPathRequestMatcher("/palvelut**"),
		new AntPathRequestMatcher("/palvelut/{palvId}**"),
		new AntPathRequestMatcher("/uusipalvelut**"),
		new AntPathRequestMatcher("/muokkaapalvelut/{palvId}"),
		new AntPathRequestMatcher("/poistapalvelut/{palvId}"),
		new AntPathRequestMatcher("/tyontekijat**"),
		new AntPathRequestMatcher("/tyontekijat/{tTId}**"),
		new AntPathRequestMatcher("/uusityontekijat**"),
		new AntPathRequestMatcher("/muokkaatyontekijat/{tTId}"),
		new AntPathRequestMatcher("/poistatyontekijat/{tTId}"),
		new AntPathRequestMatcher("/api/palvelut**"),
		new AntPathRequestMatcher("/api/tyontekijat**"),
		new AntPathRequestMatcher("/h2-console/**") };
  	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers(antMatcher ("/css/**")).permitAll()
				.requestMatchers(antMatcher("/ilmoittautuminen")).permitAll()
				.requestMatchers(antMatcher("/tallennailmoittautuminen")).permitAll()
				.requestMatchers(WHITE_LIST_URLS).permitAll()
				.anyRequest().authenticated())
				.headers(headers -> 
				headers.frameOptions(frameOptions -> frameOptions 
						.disable()))
				.formLogin(formlogin -> 
					formlogin.loginPage("/login")
					.defaultSuccessUrl("/alvobeauty", true)
					.permitAll())
				.logout(logout -> logout.permitAll())
				.csrf(csrf -> csrf.disable());
						

		return http.build();
    }

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(kayttajaToteutus).passwordEncoder(new BCryptPasswordEncoder());}
		
}


