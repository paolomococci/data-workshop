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

package local.example.data.view.route;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("login page")
public class LoginRoute 
		extends VerticalLayout 
		implements BeforeEnterObserver {

	private static final long serialVersionUID = 6110410247992360704L;
	
	private Dialog dialog;
	private LoginForm loginForm;

	@Autowired
	public LoginRoute() {
		super();
		this.loginForm = new LoginForm();
		this.loginForm.setAction("login");
		this.dialog = new Dialog(this.loginForm);
		this.dialog.setOpened(true);
		this.dialog.setHeight("500x");
		this.dialog.setWidth("380px");
		this.add(this.dialog);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		if (beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error")) {
			loginForm.setError(true);
		}
	}
}
