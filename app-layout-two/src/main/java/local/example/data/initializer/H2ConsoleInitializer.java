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

package local.example.data.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;

public class H2ConsoleInitializer 
		implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) 
			throws ServletException {
		servletContext.addServlet("h2Console", new WebServlet())
			.addMapping("/h2-console/*");
	}
}
