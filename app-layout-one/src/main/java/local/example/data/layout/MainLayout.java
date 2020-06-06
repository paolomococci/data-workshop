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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import local.example.data.layout.component.EditorComponent;
import local.example.data.layout.component.HelpComponent;
import local.example.data.layout.component.OverviewComponent;

@Route("")
@RouteAlias("main")
@PageTitle("app layout one - main page")
public class MainLayout 
		extends VerticalLayout {

	private static final long serialVersionUID = -6086472484557942526L;

	private HelpComponent helpComponent;
	private OverviewComponent overviewComponent;
	private EditorComponent editorComponent;

	private HorizontalLayout horizontalLayoutHeader;
	private Anchor logoutAnchor;
	private Dialog dialog;
	private Tab tab0, tab1, tab2;
	private Div div0, div1, div2;
	private Map<Integer, Component> workspace;
	private Tabs tabs;
	private Div contents;
	private Set<Component> contentsShow;
	private Button backButton;
	private Button forwardButton;

	@Autowired
	public MainLayout() {
		super();
		
		this.helpComponent = new HelpComponent();
		this.overviewComponent = new OverviewComponent();
		this.editorComponent = new EditorComponent();
		
		this.logoutAnchor = new Anchor("logout", "log out");
		this.horizontalLayoutHeader = new HorizontalLayout(new DrawerToggle(), this.logoutAnchor);
		this.horizontalLayoutHeader.setDefaultVerticalComponentAlignment(Alignment.AUTO);
		this.horizontalLayoutHeader.setSizeFull();
		
		this.dialog = new Dialog();
		
		this.tab0 = new Tab("help");
		this.div0 = new Div();
		this.div0.add(this.helpComponent);
		
		this.tab1 = new Tab("overview");
		this.div1 = new Div();
		this.div1.add(this.overviewComponent);
		this.div1.setVisible(false);
		
		this.tab2 = new Tab("editor");
		this.div2 = new Div();
		this.div2.add(this.editorComponent);
		this.div2.setVisible(false);
		
		this.workspace = new HashMap<>();
		this.workspace.put(0, this.div0);
		this.workspace.put(1, this.div1);
		this.workspace.put(2, this.div2);
		
		this.tabs = new Tabs(this.tab0, this.tab1, this.tab2);
		
		this.contents = new Div(this.div0, this.div1, this.div2);
		
		this.contentsShow = Stream.of(this.div0).collect(Collectors.toSet());
		
		this.tabs.addSelectedChangeListener(listener -> {
			this.contentsShow.forEach(div -> div.setVisible(false));
			this.contentsShow.clear();
			Component selected = this.workspace.get(this.tabs.getSelectedIndex());
			selected.setVisible(true);
			this.contentsShow.add(selected);
		});
		
		this.backButton = new Button();
		this.backButton.setIcon(VaadinIcon.ARROW_BACKWARD.create());
		this.backButton.setText("back");
		this.backButton.addClickListener(listener -> {
			if (this.tabs.getSelectedIndex() > 0) {
				this.contentsShow.forEach(div -> div.setVisible(false));
				this.contentsShow.clear();
				this.tabs.setSelectedIndex(this.tabs.getSelectedIndex() - 1);
				Component selected = this.workspace.get(this.tabs.getSelectedIndex());
				selected.setVisible(true);
				this.contentsShow.add(selected);
			} else {
				// TODO
			}
		});
		
		this.forwardButton = new Button();
		this.forwardButton.setIcon(VaadinIcon.ARROW_FORWARD.create());
		this.forwardButton.setText("forward");
		this.forwardButton.addClickListener(listener -> {
			if (this.tabs.getSelectedIndex() < (this.workspace.size() - 1)) {
				this.contentsShow.forEach(div -> div.setVisible(false));
				this.contentsShow.clear();
				this.tabs.setSelectedIndex(this.tabs.getSelectedIndex() + 1);
				Component selected = this.workspace.get(this.tabs.getSelectedIndex());
				selected.setVisible(true);
				this.contentsShow.add(selected);
			} else {
				// TODO
			}
		});
		
		this.dialog.add(
				this.backButton, 
				this.forwardButton, 
				this.tabs, 
				this.contents
		);
		this.dialog.setOpened(true);
		this.dialog.setHeight("800px");
		this.dialog.setWidth("900px");
		this.add(this.horizontalLayoutHeader,this.dialog);
	}
}
