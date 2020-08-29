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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import local.example.data.model.Customer;
import local.example.data.model.CustomerRepository;

@Route
@PWA(name = "sample crm", shortName = "crm", enableInstallPrompt = false)
@CssImport(value = "default.css")
public class MainView 
		extends VerticalLayout {

	private final CustomerRepository customerRepository;

	private final CustomerForm customerForm;

	final Grid<Customer> gridOfCustomer;
	final HeaderRow addressInformation;
	final TextField filterField;
	final Button addCustomer;
	final HorizontalLayout tools;

	@Autowired
	public MainView(
			CustomerRepository customerRepository,
			CustomerForm customerForm) {
		super();
		
		this.customerRepository = customerRepository;

		this.customerForm = customerForm;
	
		this.gridOfCustomer = new Grid<>(Customer.class, false);
		this.gridOfCustomer.setSelectionMode(SelectionMode.SINGLE);
		this.gridOfCustomer.addColumn(Customer::getId)
				.setHeader("id").setResizable(true).setSortable(true);
		Column<Customer> name = this.gridOfCustomer.addColumn(Customer::getName)
				.setHeader("name").setResizable(true).setSortable(true);
		Column<Customer> surname = this.gridOfCustomer.addColumn(Customer::getSurname)
				.setHeader("surname").setResizable(true).setSortable(true);
		Column<Customer> email = this.gridOfCustomer.addColumn(Customer::getEmail)
				.setHeader("email").setResizable(true).setSortable(true);
		this.gridOfCustomer.addColumn(Customer::getBirthday)
				.setHeader("birthday").setResizable(true).setSortable(true);
		this.gridOfCustomer.addColumn(Customer::getStatus)
				.setHeader("status").setResizable(true).setSortable(true);
		this.gridOfCustomer.addClassName("data-grid");
		this.gridOfCustomer.asSingleSelect().addValueChangeListener(listener -> {
			this.customerForm.editCustomer(listener.getValue());
		});
		this.addressInformation = this.gridOfCustomer.prependHeaderRow();
		this.addressInformation.join(name, surname, email).setComponent(new Label("address information"));
	
		this.filterField = new TextField();
		this.filterField.setPlaceholder("filter by surname");
		this.filterField.setClearButtonVisible(true);
		this.filterField.setValueChangeMode(ValueChangeMode.LAZY);
		this.filterField.addValueChangeListener(listener -> {
			this.showCustomerList(listener.getValue());
		});
		this.addCustomer = new Button("add customer", VaadinIcon.PLUS.create());
		this.addCustomer.addClickListener(listener -> {
			this.gridOfCustomer.asSingleSelect().clear();
			this.customerForm.editCustomer(new Customer());
		});
		this.tools = new HorizontalLayout(this.filterField, this.addCustomer);
	
		this.addClassName("main");
		this.add(this.tools, this.gridOfCustomer, this.customerForm);
		this.setSizeFull();
		
		this.customerForm.setChangeHandler(() -> {
			this.customerForm.setVisible(false);
			this.showCustomerList(this.filterField.getValue());
		});
		
		this.showCustomerList("");
	}

	private void showCustomerList(String surname) {
		if (surname.isEmpty() || surname.isBlank()) {
			this.gridOfCustomer.setItems(this.customerRepository.findAll());
		} else {
			this.gridOfCustomer.setItems(this.customerRepository.findBySurname(surname));
		}
	}
}
