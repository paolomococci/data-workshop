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

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;

@Push
@CssImport(value = "style.css")
public class MainLayout 
		extends AppLayout 
		implements AfterNavigationObserver {

	private static final long serialVersionUID = 6447759746309346198L;

	private final H1 title;
	private final RouterLink mainView;
	private final RouterLink itemReadView;
	private final RouterLink itemCreateView;
	private final RouterLink itemUpdateView;
	private final RouterLink itemDeleteView;
	private final UnorderedList unorderedList;
	private final Header header;
	private final Nav nav;

	public MainLayout() {
		this.title = new H1("reactive data accessing");
		this.mainView = new RouterLink("main view", MainView.class);
		this.itemReadView = new RouterLink("items read", ItemReadView.class);
		this.itemCreateView = new RouterLink("item create", ItemCreateView.class);
		this.itemUpdateView = new RouterLink("item update", ItemUpdateView.class);
		this.itemDeleteView = new RouterLink("item delete", ItemDeleteView.class);
		this.unorderedList = new UnorderedList(
				new ListItem(this.mainView), 
				new ListItem(this.itemReadView),  
				new ListItem(this.itemCreateView), 
				new ListItem(this.itemUpdateView), 
				new ListItem(this.itemDeleteView)
		);
		this.header = new Header(new DrawerToggle(), this.title);
		this.nav = new Nav(this.unorderedList);
		this.addToNavbar(this.header);
		this.addToDrawer(this.nav);
		this.setPrimarySection(Section.DRAWER);
		this.setDrawerOpened(false);
	}

	private RouterLink[] listLinks() {
		return new RouterLink[] {
				this.mainView, 
				this.itemReadView,  
				this.itemCreateView, 
				this.itemUpdateView, 
				this.itemDeleteView
				};
	}

	@Override
	public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
		for (final RouterLink link : this.listLinks()) {
			if (link.getHighlightCondition().shouldHighlight(link, afterNavigationEvent)) {
				this.title.setText(link.getText());
			}
		}
	}
}
