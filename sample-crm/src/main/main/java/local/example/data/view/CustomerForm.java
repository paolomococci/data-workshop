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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import local.example.data.model.Customer;
import local.example.data.model.CustomerRepository;
import local.example.data.model.CustomerStatus;

public class CustomerForm 
		extends FormLayout {

	private static final long serialVersionUID = 8460707291910308110L;

	private final CustomerRepository customerRepository;
	private Optional<Customer> customer;
	private Binder<Customer> binder;
	private CustomerChangeHandler customerChangeHandler;

	private final TextField name;
	private final TextField surname;
	private final DatePicker birthday;
	private final TextField email;
	private final ComboBox<CustomerStatus> status;
	private final Button save;
	private final Button delete;
	private final Button cancel;
	private final HorizontalLayout buttons;

	@Autowired
	public CustomerForm(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
		this.binder = new Binder<>(Customer.class);
		this.name = new TextField("name");
		this.surname = new TextField("surname");
		this.birthday = new DatePicker("birthday");
		this.email = new TextField("email");
		this.status = new ComboBox<>("status");
		this.save = new Button("save", VaadinIcon.PLUS_CIRCLE.create());
		this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.save.addClickListener(listener -> {
			this.save();
		});
		this.save.addClickShortcut(Key.ENTER);
		this.delete = new Button("cancel", VaadinIcon.MINUS_CIRCLE.create());
		this.delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
		this.delete.addClickListener(listener -> {
			this.delete();
		});
		this.delete.addClickShortcut(Key.DELETE);
		this.cancel = new Button("cancel", VaadinIcon.CIRCLE_THIN.create());
		this.cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
		this.cancel.addClickListener(listener -> {
			this.setVisible(false);
		});
		this.buttons = new HorizontalLayout(this.save, this.delete, this.cancel);
		this.add(name, surname, birthday, email, status, buttons);
		this.setSizeFull();
		this.binder.bindInstanceFields(this);
		this.setVisible(false);
	}

	private void save() {
		this.customerRepository.save(this.customer);
		this.customerChangeHandler.onChange();
	}

	private void delete() {
		this.customerRepository.delete(this.customer);
		this.customerChangeHandler.onChange();
	}

	public void setChangeHandler(CustomerChangeHandler customerChangeHandler) {
		this.customerChangeHandler = customerChangeHandler;
	}

	public final void edit(Customer customer) {
	
		if (customer == null) {
			this.setVisible(false);
			return;
		}
	
		final boolean isPersist = (customer.getId() != null);
		if (isPersist) {
			this.customer = this.customerRepository.findById(customer.getId());
		} else {
			this.customer = Optional.of(customer);
		}
		this.cancel.setVisible(isPersist);
		this.binder.setBean(customer);
		this.setVisible(true);
		this.name.focus();
	}
}
