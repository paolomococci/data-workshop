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

import org.springframework.util.StringUtils;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import local.example.data.entity.Customer;
import local.example.data.repository.CustomerRepository;
import local.example.data.view.editor.CustomerViewEditor;

@Route(value = "root")
@RouteAlias(value = "")
public class DataUiRootView 
		extends VerticalLayout {

	private static final long serialVersionUID = 7646412135200145396L;
	private final CustomerRepository customerRepository;
	private final Grid<Customer> gridOfCustomers;
	private final TextField idFilter;
	private final TextField nicknameFilter;
	private final TextField abcClassificationFilter;
	private final HorizontalLayout filters;
	private final CustomerViewEditor customerViewEditor;
	private final Button addNewCustomer;
	private final VerticalLayout uploadNewCustomer;

	public DataUiRootView(
			CustomerRepository customerRepository, 
			CustomerViewEditor viewEditor
			) {
		this.customerRepository = customerRepository;
		this.gridOfCustomers = new Grid<>(Customer.class);
		this.gridOfCustomers.setColumns("id", "nickname", "abcClassification");
		this.gridOfCustomers.getColumnByKey("id").setWidth("200px").setFlexGrow(0);
		this.idFilter = new TextField();
		this.idFilter.setPlaceholder("by id");
		this.idFilter.setValueChangeMode(ValueChangeMode.LAZY);
		this.idFilter.addValueChangeListener(
				listener -> listOfIds(listener.getValue())
		);
		this.nicknameFilter = new TextField();
		this.nicknameFilter.setPlaceholder("by nickname");
		this.nicknameFilter.setValueChangeMode(ValueChangeMode.LAZY);
		this.nicknameFilter.addValueChangeListener(
				listener -> listOfCustomers(listener.getValue())
		);
		this.abcClassificationFilter = new TextField();
		this.abcClassificationFilter.setPlaceholder("by ABC classification");
		this.abcClassificationFilter.setValueChangeMode(ValueChangeMode.LAZY);
		this.abcClassificationFilter.addValueChangeListener(
				listener -> listOfAbcClassifications(listener.getValue())
		);
		this.filters = new HorizontalLayout();
		this.filters.add(idFilter, nicknameFilter, abcClassificationFilter);
		this.customerViewEditor = viewEditor;
		this.addNewCustomer = new Button("new", VaadinIcon.ELLIPSIS_V.create());
		this.addNewCustomer.setSizeFull();
		this.addNewCustomer.setSizeUndefined();
		this.addNewCustomer.addClickListener(
				listener -> {
					boolean visible = customerViewEditor.getElement().isVisible();
					if (!visible) {
						customerViewEditor.setVisible(true);
					} else {
						customerViewEditor.setVisible(false);
					}
				}
		);
		this.uploadNewCustomer = new VerticalLayout(addNewCustomer, customerViewEditor);
		this.uploadNewCustomer.setSizeFull();
		this.add(filters, gridOfCustomers, uploadNewCustomer);
	}

	private void listOfIds(String id) {
		// TODO 
	}

	private void listOfCustomers(String nickname) {
		if (StringUtils.isEmpty(nickname)) {
			gridOfCustomers.setItems(customerRepository.findAll());
		}
		else {
			gridOfCustomers.setItems(customerRepository.findByNickname(nickname));
		}
	}

	private void listOfAbcClassifications(String abcClassification) {
		// TODO 
	}
}
