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

package local.example.data.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/session")
public class JdbcHttpSessionServlet 
		extends HttpServlet {

	private static final long serialVersionUID = 2899699266653113167L;

	@Override
	protected void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
					throws ServletException, IOException {
		String attributeName = httpServletRequest.getParameter("attributeName");
		String attributeValue = httpServletRequest.getParameter("attributeValue");
		httpServletRequest.getSession().setAttribute(attributeName, attributeValue);
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
	}
}
