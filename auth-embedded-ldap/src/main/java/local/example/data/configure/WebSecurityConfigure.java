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

package local.example.data.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure 
		extends WebSecurityConfigurerAdapter {

	private static final String[] LDAP_CONFIG = {
			"ou=people", 
			"(uid={0})", 
			"ou=groups", 
			"(member={0})", 
			"dc=example,dc=local", 
			"classpath:users-allowed.ldif"
			};

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder.ldapAuthentication()
			.userSearchBase(LDAP_CONFIG[0])
			.userSearchFilter(LDAP_CONFIG[1])
			.groupSearchBase(LDAP_CONFIG[2])
			.groupSearchFilter(LDAP_CONFIG[3])
			.contextSource()
			.root(LDAP_CONFIG[4])
			.ldif(LDAP_CONFIG[5]);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}
}
