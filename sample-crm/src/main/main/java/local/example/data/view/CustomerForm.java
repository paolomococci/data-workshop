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

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import local.example.data.model.Customer;
import local.example.data.model.CustomerRepository;
import local.example.data.model.CustomerStatus;

@UIScope
@SpringComponent
public class CustomerForm 
		extends FormLayout {

	private static final long serialVersionUID = 8460707291910308110L;

	private final CustomerRepository customerRepository;
	private Customer customer;
	private Binder<Customer> binder;
	private CustomerChangeHandler customerChangeHandler;

	private final TextField name;
	private final TextField surname;
	private final DatePicker birthday;
	private final TextField email;
	private final Select<CustomerStatus> status;
	private final VerticalLayout personalData;
	private final Button save;
	private final Button delete;
	private final Button cancel;
	private final HorizontalLayout buttons;
	private final VerticalLayout form;

	@Autowired
	public CustomerForm(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
		this.binder = new Binder<>(Customer.class);
		
		this.name = new TextField("name");
		this.surname = new TextField("surname");
		this.birthday = new DatePicker("birthday");
		this.email = new TextField("email");
		this.status = new Select<>();
		this.status.setLabel("status");
		this.status.setItems(CustomerStatus.values());
		this.personalData = new VerticalLayout(
				this.name, 
				this.surname, 
				this.birthday, 
				this.email, 
				this.status
		);
		this.save = new Button("save", VaadinIcon.PLUS_CIRCLE.create());
		this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.save.addClickListener(listener -> {
			this.save();
		});
		this.save.addClickShortcut(Key.ENTER);
		this.delete = new Button("delete", VaadinIcon.TRASH.create());
		this.delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
		this.delete.addClickListener(listener -> {
			this.delete();
		});
		this.delete.addClickShortcut(Key.DELETE);
		this.cancel = new Button("cancel", VaadinIcon.CHECK_CIRCLE.create());
		this.cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
		this.cancel.addClickListener(listener -> {
			this.editCustomer(customer);
			this.setVisible(false);
		});
		this.cancel.addClickShortcut(Key.ESCAPE);
		this.buttons = new HorizontalLayout(this.save, this.delete, this.cancel);
		
		this.form = new VerticalLayout(
				this.personalData, 
				this.buttons
		);
		this.add(this.form);
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

	public final void editCustomer(Customer temp) {
		if (temp != null) {
			this.edit(temp);
		} else {
			this.setVisible(false);
		}
	}

	private void edit(Customer temp) {
		Long id = temp.getId();
		final boolean alreadyExisting = (temp.getId() != null);
		if (alreadyExisting) {
			this.customer = this.customerRepository.findById(id).get();
		} else {
			this.customer = temp;
		}
		this.cancel.setVisible(alreadyExisting);
		this.binder.setBean(this.customer);
		this.setVisible(true);
		this.name.focus();
	}
}
