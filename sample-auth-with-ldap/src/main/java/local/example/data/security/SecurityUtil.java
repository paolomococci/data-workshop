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

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.server.HandlerHelper;
import com.vaadin.flow.shared.ApplicationConstants;

public class SecurityUtil {

	public SecurityUtil() {
		super();
	}

	public static boolean isFrameworkInternalRequest(HttpServletRequest httpServletRequest) {
		final String parameterValue = httpServletRequest.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
		return (parameterValue != null) && 
				(Stream.of(HandlerHelper.RequestType.values()).anyMatch(arg -> arg.getIdentifier().equals(parameterValue))
		);		
	}

	public static boolean isUserLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (authentication != null) && 
				!(authentication instanceof AnonymousAuthenticationToken) && 
				(authentication.isAuthenticated());		
	}
}
