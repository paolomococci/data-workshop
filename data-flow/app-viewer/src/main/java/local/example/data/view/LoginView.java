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
import com.vaadin.flow.router.Route;

import local.example.data.view.component.LoginViewComponent;
import lombok.Getter;

@Route("/login")
public class LoginView 
		extends UI {

	private static final long serialVersionUID = 1791246927321006095L;

	@Getter
	private final LoginViewComponent loginViewComponent;

	public LoginView() {
		loginViewComponent = new LoginViewComponent();
		this.add(loginViewComponent);
	}
}
