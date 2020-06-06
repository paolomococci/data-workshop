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

package local.example.data.listener;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import local.example.data.layout.LoginLayout;
import local.example.data.util.SecurityUtil;

@Component
public class ServiceInitListener 
		implements VaadinServiceInitListener {

	private static final long serialVersionUID = -8202546063729313388L;

	@Override
	public void serviceInit(ServiceInitEvent serviceInitEvent) {
		serviceInitEvent.getSource().addUIInitListener(listener -> {
			final UI ui = listener.getUI();
			ui.addBeforeEnterListener(this::authenticatedNavigation);
		});
	}

	private void authenticatedNavigation(BeforeEnterEvent beforeEnterEvent) {
		if (!LoginLayout.class.equals(beforeEnterEvent.getNavigationTarget()) && 
				!SecurityUtil.isUserLoggedIn()) {
			beforeEnterEvent.rerouteTo(LoginLayout.class);
		}
	}
}
