package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.server.UnboundIdContainer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private AuthTokenFilter authTokenFilter;
	
	public SecurityConfig(AuthTokenFilter authTokenFilter) {
		this.authTokenFilter = authTokenFilter;
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().and()
        	.addFilterBefore(this.authTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
        	.url("ldap://localhost:8399/dc=springframework,dc=org").and().passwordCompare().passwordAttribute("userPassword");
    }
	
	@Bean
	public UnboundIdContainer ldapContainer() {
		UnboundIdContainer unboundIdContainer = new UnboundIdContainer("dc=springframework,dc=org","classpath:ldap-data.ldif");
		unboundIdContainer.setPort(8399);
		return unboundIdContainer;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
