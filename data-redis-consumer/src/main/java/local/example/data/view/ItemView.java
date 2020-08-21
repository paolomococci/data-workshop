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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.data.model.Item;
import local.example.data.service.ItemRestfulRetrieverService;
import local.example.data.view.layout.MainLayout;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;

@Route(value = "item", layout = MainLayout.class)
@PageTitle(value = "item view")
public class ItemView
		extends Main {

	private static final String RESTFUL_URI = "http://127.0.0.1:8080/api/reactive";
	
	private final Grid<Item> itemGrid;
	private final Button retrieveButton;

	public ItemView() {
		super();
		this.itemGrid = new Grid<>();
		this.itemGrid.addColumn(item -> item.getCode()).setHeader("code").setSortable(true).setTextAlign(ColumnTextAlign.START);
		this.itemGrid.addColumn(item -> item.getName()).setHeader("name").setSortable(true);
		this.itemGrid.addColumn(item -> item.getDescription()).setHeader("description").setSortable(false);
		this.retrieveButton = new Button(
				"recovers all items", 
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(), 
				listener -> {
						try {
							this.itemGrid.setItems(ItemRestfulRetrieverService.getListOfItems(new URI(RESTFUL_URI)));
						} catch (
								ResponseStatusException | URISyntaxException exception) {
							exception.printStackTrace();
						}
				});
		this.retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.add(this.retrieveButton, this.itemGrid);
	}
}
