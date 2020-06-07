/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import local.example.data.cache.CustomizedRequestCache;
import local.example.data.util.SecurityUtil;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig 
		extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login?error";
	private static final String[] ANT_PATTERNS = {
			"/VAADIN/**", 
			//"favicon.ico",
			"robots.txt", 
			"manifest.webmanifest", 
			"sw.js", 
			"offline.html", 
			"/icons/**", 
			"/images/**", 
			"/styles/**", 
			"/h2-console/**"
			};

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
			.withUser("julie").password(this.passwordEncoder().encode("julie123")).roles("USER", "ADMIN")
			.and().withUser("john").password(this.passwordEncoder().encode("john123")).roles("USER")
			.and().withUser("keith").password(this.passwordEncoder().encode("keith123")).roles("USER")
			.and().withUser("michelle").password(this.passwordEncoder().encode("michelle123")).roles("USER")
			.and().withUser("neil").password(this.passwordEncoder().encode("neil123")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity
			.csrf().disable()
			.requestCache().requestCache(new CustomizedRequestCache())
			.and().authorizeRequests()
			.requestMatchers(SecurityUtil::isFrameworkInternalRequest).permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage(LOGIN_URL).permitAll()
			.loginProcessingUrl(LOGIN_URL)
			.failureUrl(LOGIN_FAILURE_URL)
			.and().logout().logoutSuccessUrl(LOGIN_URL);
	}

	@Override
	public void configure(WebSecurity webSecurity) 
			throws Exception {
		webSecurity.ignoring().antMatchers(HttpMethod.GET, ANT_PATTERNS);
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withUsername("guest").password("guest")
				.roles("USER").build();
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
