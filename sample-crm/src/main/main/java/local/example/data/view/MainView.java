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
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import local.example.data.model.Customer;
import local.example.data.model.CustomerRepository;

@Route
@PWA(name = "sample crm", shortName = "crm", enableInstallPrompt = false)
@CssImport(value = "default.css")
public class MainView 
		extends VerticalLayout {

	private static final long serialVersionUID = 4241629279709817521L;

	@SuppressWarnings("unused")
	private final CustomerRepository customerRepository;

	@SuppressWarnings("unused")
	private final CustomerForm customerForm;

	final Grid<Customer> gridOfCustomer;
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
	
		this.gridOfCustomer = new Grid<>(Customer.class);
		this.gridOfCustomer.addClassName("data-grid");
		this.filterField = new TextField();
		this.addCustomer = new Button("add customer", VaadinIcon.PLUS.create());
		this.tools = new HorizontalLayout(this.filterField, this.addCustomer);
	
		this.addClassName("main");
		this.add(this.tools, this.gridOfCustomer);
		this.setSizeFull();
	}
}
