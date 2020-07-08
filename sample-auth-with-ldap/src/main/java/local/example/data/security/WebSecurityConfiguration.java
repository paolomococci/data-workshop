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
		// TODO
		super.configure(authenticationManagerBuilder);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
