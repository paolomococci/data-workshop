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

package local.example.data.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfiguration 
		extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login?error";
	private static final String[] ANT_PATTERNS = {
			"/VAADIN/**", 
			"/robots.txt", 
			"/favicon.ico", 
			"/manifest.webmanifest",
			"/sw.js", 
			"/offline-page.html", 
			"/frontend/**", 
			"/frontend-es5/**", 
			"/frontend-es6/**", 
			"/webjars/**",
			"/icons/**", 
			"/images/**", 
			"/styles/**", 
			"/h2-console/**" };
	private static final String USER_DN_PATTERNS = "uid={0},ou=people";
	private static final String USER_SEARCH_BASE = "ou=people";
	private static final String USER_SEARCH_FILTER = "uid={0}";
	private static final String GROUP_SEARCH_BASE = "ou=groups";
	private static final String GROUP_SEARCH_FILTER = "uniqueMember={0}";
	private static final String LDAP_URL = "ldap://127.0.0.1:8091/dc=example,dc=local";
	private static final String PASSWORD_ATTRIBUTE = "userPassword";

	@Override
	public void configure(WebSecurity webSecurity) 
			throws Exception {
		webSecurity.ignoring().antMatchers(ANT_PATTERNS);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated()
			.and().formLogin().loginPage(LOGIN_URL).permitAll().loginProcessingUrl(LOGIN_URL)
				.failureUrl(LOGIN_FAILURE_URL).and().logout().logoutSuccessUrl(LOGIN_URL);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder.ldapAuthentication()
			.userDnPatterns(USER_DN_PATTERNS)
			.userSearchBase(USER_SEARCH_BASE)
			.userSearchFilter(USER_SEARCH_FILTER)
			.groupSearchBase(GROUP_SEARCH_BASE)
			.groupSearchFilter(GROUP_SEARCH_FILTER)
			.contextSource()
			.url(LDAP_URL)
			.and().passwordCompare()
				.passwordEncoder(this.passwordEncoder())
				.passwordAttribute(PASSWORD_ATTRIBUTE);
			
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
