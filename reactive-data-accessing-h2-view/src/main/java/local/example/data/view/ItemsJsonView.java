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

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.retrieve.RestDataRetriever;

@Route(value = "items", layout = RetrieveLayout.class)
@PageTitle(value = "items")
public class ItemsJsonView 
		extends Main {

	private static final long serialVersionUID = -3993561314677468608L;

	@Autowired RestDataRetriever restDataRetriever;
	
	private final Grid<JsonNode> itemsGrid;
	private final Button retrieveButton;

	public ItemsJsonView() {
		this.itemsGrid = new Grid<>();
		this.itemsGrid.addColumn(jsonNode -> jsonNode.get("id")).setHeader("id").setTextAlign(ColumnTextAlign.START);
		this.itemsGrid.addColumn(jsonNode -> jsonNode.get("code")).setHeader("code");
		this.itemsGrid.addColumn(jsonNode -> jsonNode.get("description")).setHeader("description");
		this.itemsGrid.addColumn(jsonNode -> jsonNode.get("status")).setHeader("status");
		this.retrieveButton = new Button(
				"retrieve", 
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create());
		// TODO
		this.retrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.add(this.retrieveButton, this.itemsGrid);
	}
}
