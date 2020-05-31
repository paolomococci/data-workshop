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

import org.springframework.beans.factory.annotation.Autowired;

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
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinSession;

import local.example.data.view.component.EditorComponent;
import local.example.data.view.component.HelpComponent;
import local.example.data.view.component.OverviewComponent;

@Route(value = "root")
@RouteAlias(value = "")
@PWA(name = "crud update", shortName = "crud")
@Viewport(value = "width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class RootView 
		extends AppLayout {

	private static final long serialVersionUID = -847263394035462160L;

	private final HelpComponent helpComponent;
	private final OverviewComponent overviewComponent;
	private final EditorComponent editorComponent;
	private Tabs tabs;
	private Map<Tab, Component> workspace;
	private Label title;

	@Autowired
	public RootView(
			HelpComponent help, 
			OverviewComponent overview, 
			EditorComponent editor) {
		super();
		this.title = new Label("CRUD update");
		this.helpComponent = help;
		this.overviewComponent = overview;
		this.editorComponent = editor;
		this.workspace = new HashMap<>();
		this.tabs = new Tabs(
				this.blank(),
				this.help(), 
				this.overview(), 
				this.editor(), 
				this.logout()
				);
		this.tabs.setOrientation(Tabs.Orientation.VERTICAL);
		this.tabs.addSelectedChangeListener(listener -> {
			final Tab selected = listener.getSelectedTab();
			final Component component = this.workspace.get(selected);
			this.setContent(component);
		});
		this.addToNavbar(new DrawerToggle(), this.title);
		this.addToDrawer(tabs);
	}

	private Tab blank() {
		final Span span = new Span("blank");
		final Icon icon = VaadinIcon.DOT_CIRCLE.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, span));
		this.workspace.put(tab, new VerticalLayout(new Label("")));
		return tab;
	}

	private Tab help() {
		final Span span = new Span("help");
		final Icon icon = VaadinIcon.BOOK.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, span));
		this.workspace.put(tab, this.helpComponent);
		return tab;
	}

	private Tab overview() {
		final Span span = new Span("overview");
		final Icon icon = VaadinIcon.OPEN_BOOK.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, span));
		this.workspace.put(tab, this.overviewComponent);
		return tab;
	}

	private Tab editor() {
		final Span span = new Span("edit");
		final Icon icon = VaadinIcon.EDIT.create();
		final Tab tab = new Tab(new HorizontalLayout(icon, span));
		this.workspace.put(tab, this.editorComponent);
		return tab;
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
			ui.navigate(RootView.class);
		});
		tab = new Tab(button);
		return tab;
	}
}
