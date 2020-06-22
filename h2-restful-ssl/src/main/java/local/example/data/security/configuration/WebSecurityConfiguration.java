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

package local.example.data.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration 
		extends WebSecurityConfigurerAdapter {

	private final String URL = "/rest/api/**";

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
			.withUser("user").password(this.passwordEncoder().encode("qwerty123")).roles("USER")
			.and().withUser("admin").password(this.passwordEncoder().encode("asdfgh098")).roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity.httpBasic()
			.and().authorizeRequests()
			.antMatchers(HttpMethod.GET, this.URL).hasRole("USER")
			.antMatchers(HttpMethod.POST, this.URL).hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, this.URL).hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, this.URL).hasRole("ADMIN")
			.and().csrf().disable().formLogin().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
