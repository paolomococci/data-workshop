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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import local.example.data.service.WelcomeService;

@Route
@PWA(name = "sample authentication with LDAP", shortName = "auth", enableInstallPrompt = false)
@CssImport(value = "style.css")
public class MainView 
		extends VerticalLayout {

	private static final long serialVersionUID = 4241629279709817521L;

	private final TextField nameField;
	private final Button welcomeButton;

	@Autowired
	public MainView() {
		super();
		this.nameField = new TextField("name: ");
		this.nameField.setPlaceholder("your name, please");
		this.welcomeButton = new Button("welcome", VaadinIcon.ALARM.create());
		this.welcomeButton.setVisible(false);

		this.nameField.addValueChangeListener(listener -> {
			this.welcomeButton.setVisible(true);
		});
		this.welcomeButton.addClickListener(listener -> {
			Notification.show(
					WelcomeService.welcomeTo(this.nameField.getValue()), 
					5000, 
					Position.BOTTOM_CENTER
			);
		});
		
		this.add(this.nameField, this.welcomeButton);
		this.addClassName("main-view");
	}
}
