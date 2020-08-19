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

package local.example.data.view.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import local.example.data.view.ItemView;
import local.example.data.view.MainView;

@Push
@CssImport(value = "style.css")
public class MainLayout 
		extends AppLayout 
		implements AfterNavigationObserver {
	
	private final H1 title;
	private final RouterLink mainView;
	
	private final RouterLink itemView;

	public MainLayout() {
		super();
		this.title = new H1("reactive RESTful web service data accessing");
		this.mainView = new RouterLink("main view", MainView.class);
		this.itemView = new RouterLink("address view", ItemView.class);

		UnorderedList unorderedList = new UnorderedList(
				new ListItem(this.mainView),
				new ListItem(this.itemView)
		);

		Header header = new Header(new DrawerToggle(), this.title);
		Nav nav = new Nav(unorderedList);
		
		this.addToNavbar(header);
		this.addToDrawer(nav);
		this.setPrimarySection(Section.DRAWER);
		this.setDrawerOpened(false);
	}

	private RouterLink[] listLinks() {
		return new RouterLink[] {
				this.mainView, 
				this.itemView
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
