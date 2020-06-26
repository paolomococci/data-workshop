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

package local.example.warehouse.view.route;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;

@Route("")
@RouteAlias("warehouse")
@PWA(name = "Warehouse", shortName = "Warehouse", enableInstallPrompt = false)
public class MainRoute 
		extends AppLayout 
		implements RouterLayout {

	private static final long serialVersionUID = -1899543193616113831L;

	@SuppressWarnings("unused")
	private final Button logout;

	@Autowired
	public MainRoute() {
		super();
		this.logout = new Button("logout", VaadinIcon.SIGN_OUT.create());
	}
}
