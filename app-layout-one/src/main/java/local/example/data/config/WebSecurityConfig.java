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
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig 
		extends WebSecurityConfigurerAdapter {

	private static final String[] patterns = {"", "signinto", "/VAADIN/**"};
	private static final String loginPage = "signinto";
	private static final String username = "guest";
	private static final String rawPassword = "123qwerty456";
	private static final String roles = "USER";

	
	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers(patterns).permitAll().anyRequest().authenticated()
			.and().formLogin().loginPage(loginPage).permitAll()
			.and().logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
			.withUser(username)
			.password(this.passwordEncoder().encode(rawPassword))
			.roles(roles);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
