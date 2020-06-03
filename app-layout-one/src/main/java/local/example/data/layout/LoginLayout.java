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

package local.example.data.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginLayout 
		extends VerticalLayout {

	private static final long serialVersionUID = 7296126119319793087L;

	private Dialog dialog;
	private LoginForm login;

	@Autowired
	public LoginLayout() {
		super();
		this.login = new LoginForm();
		this.dialog = new Dialog(this.login);
		this.dialog.setOpened(true);
		this.dialog.setHeight("420px");
		this.dialog.setWidth("380px");
		this.add(this.dialog);
	}
}
