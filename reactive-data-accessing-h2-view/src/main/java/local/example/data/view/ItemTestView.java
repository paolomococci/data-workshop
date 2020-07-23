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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.server.ResponseStatusException;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.retrieve.mapper.ItemMapper;
import local.example.data.retrieve.representation.Item;

@Route(value = "test", layout = MainLayout.class)
@PageTitle(value = "test")
public class ItemTestView 
		extends Main {
	private static final long serialVersionUID = -18184019387211095L;
	
	private static final String RESTFUL_URI = "http://127.0.0.1:8091/items";
	
	private final Grid<Item> itemGrid;
	private final Button retrieveButton;

	public ItemTestView() {
		this.itemGrid = new Grid<>();
		this.itemGrid.addColumn(item -> item.getId()).setHeader("id").setSortable(true).setTextAlign(ColumnTextAlign.START);
		this.itemGrid.addColumn(item -> item.getCode()).setHeader("code").setSortable(true);
		this.itemGrid.addColumn(item -> item.getDescription()).setHeader("description");
		this.itemGrid.addColumn(item -> item.getStatus()).setHeader("status").setSortable(true);
		this.retrieveButton = new Button(
				"recovers all items", 
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(), 
				listener -> {
						try {
							this.itemGrid.setItems(ItemMapper.getItems(new URI(RESTFUL_URI)));
						} catch (
								ResponseStatusException | IOException | URISyntaxException exception) {
							exception.printStackTrace();
						}
				});
		this.retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.add(this.retrieveButton, this.itemGrid);
	}
}
