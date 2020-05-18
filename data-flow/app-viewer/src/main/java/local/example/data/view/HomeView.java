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

package local.example.data.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route("/")
@RouteAlias("/home")
@PWA(name = "Home Page", shortName = "home")
public class HomeView 
		extends UI {

	private static final long serialVersionUID = -8375389836593224664L;
	private static Accordion accordion;
	private static VerticalLayout verticalLayout;

	public HomeView() {
		accordion = new Accordion();
		verticalLayout = new VerticalLayout();
	}

	@Override
	protected void init(VaadinRequest request) {
		super.init(request);
		verticalLayout.add(new TextField("name"), new TextField("surname"), new TextField("email"));
		accordion.add("contact information", verticalLayout);
		this.add(accordion);
	}
}
