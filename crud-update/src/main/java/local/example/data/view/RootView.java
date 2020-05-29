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

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;

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
	private Tab helpTab;
	private Tab overviewTab;
	private Tab editorTab;
	private Tabs tabs;
	private Label title;

	@Autowired
	public RootView(HelpComponent help, OverviewComponent overview, EditorComponent editor) {
		super();
		this.helpComponent = help;
		this.overviewComponent = overview;
		this.editorComponent = editor;
		this.helpTab = new Tab("help");
		this.helpTab.add(helpComponent);
		this.overviewTab = new Tab("view");
		this.overviewTab.add(overviewComponent);
		this.editorTab = new Tab("editor");
		this.editorTab.add(editorComponent);
		this.tabs = new Tabs(helpTab, overviewTab, editorTab);
		this.tabs.addThemeVariants(TabsVariant.LUMO_SMALL);
		this.tabs.setWidth("350px");
		this.tabs.setOrientation(Tabs.Orientation.VERTICAL);
		this.addToNavbar(new DrawerToggle());
		this.title = new Label("CRUD update");
		this.addToNavbar(title);
		this.addToDrawer(tabs);
	}
}
