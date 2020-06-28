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

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import local.example.data.service.GreetingService;

@Route
@PWA(name = "sample crm", shortName = "crm", enableInstallPrompt = false)
@CssImport(value = "default.css")
public class MainView 
		extends VerticalLayout {

	private static final long serialVersionUID = 4241629279709817521L;

	@Autowired
	public MainView() {
		super();

		TextField name = new TextField("your name, please");
		
		Button greet = new Button("greeting", VaadinIcon.SMILEY_O.create(), event -> {
			Notification.show(GreetingService.greet(name.getValue()), 2000, Position.BOTTOM_CENTER);
		});
		greet.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		greet.addClickShortcut(Key.ENTER);
		this.addClassName("centered");
		this.add(name, greet);
		this.setSizeFull();
	}
}
