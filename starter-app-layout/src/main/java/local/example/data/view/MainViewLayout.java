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

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(Lumo.class)
@Route(value = "main")
@RouteAlias(value = "")
@Viewport(value = "width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class MainViewLayout 
		extends AppLayout {

	private static final long serialVersionUID = 253624385892644238L;

	public static final String URL = "";

	private final Tabs tabs;
	private Map<Tab, Component> workspace;
	private Label title;

	public MainViewLayout() {
		super();
		this.tabs = new Tabs();
		this.workspace = new HashMap<>();
		this.title = new Label("Starter application layout");
		this.addToNavbar(new DrawerToggle(), title);
		this.tabs.add(
				this.blank(), 
				this.overview(), 
				this.editor(), 
				this.compute(), 
				this.logout()
		);
		this.tabs.setOrientation(Tabs.Orientation.VERTICAL);
		this.tabs.addSelectedChangeListener(listener -> {
			final Tab selected = listener.getSelectedTab();
			final Component component = this.workspace.get(selected);
			this.setContent(component);
		});
		this.addToDrawer(this.tabs);
	}

	private Tab logout() {
		final Icon icon = VaadinIcon.SIGN_OUT.create();
		final Button button = new Button();
		final Tab tab;
		button.setText("Logout");
		button.setIcon(icon);
		button.addClickListener(listener -> {
			UI ui = UI.getCurrent();
			VaadinSession vaadinSession = ui.getSession();
			// TODO
			vaadinSession.close();
			ui.navigate(MainViewLayout.class);
		});
		button.setSizeFull();
		tab = new Tab(button);
		return tab;
	}

	private Tab compute() {
		final Span label = new Span("compute");
		final Icon icon = VaadinIcon.ABACUS.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, label));
		this.workspace.put(tab, new VerticalLayout(new Label("#compute")));
		return tab;
	}

	private Tab editor() {
		final Span label = new Span("editor");
		final Icon icon = VaadinIcon.USER.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, label));
		this.workspace.put(tab, new VerticalLayout(new Label("#editor")));
		return tab;
	}

	private Tab overview() {
		final Span label = new Span("overview");
		final Icon icon = VaadinIcon.USERS.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, label));
		this.workspace.put(tab, new VerticalLayout(new Label("#overview")));
		return tab;
	}

	private Tab blank() {
		final Span label = new Span("blank");
		final Icon icon = VaadinIcon.DOT_CIRCLE.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, label));
		this.workspace.put(tab, new VerticalLayout(new Label("")));
		return tab;
	}
}
