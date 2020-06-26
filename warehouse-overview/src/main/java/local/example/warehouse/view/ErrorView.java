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

package local.example.warehouse.view;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;

public class ErrorView 
		extends VerticalLayout 
		implements HasErrorParameter<NotFoundException> {

	private static final long serialVersionUID = 8927010568144212309L;

	@Autowired
	public ErrorView() {
		super();
		H1 header = new H1("could not be found");
		this.add(header);
		
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent beforeEnterEvent, 
			ErrorParameter<NotFoundException> errorParameter) {
		return HttpServletResponse.SC_NOT_FOUND;
	}
}
