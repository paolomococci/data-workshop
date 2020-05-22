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

package local.example.data.view.editor;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import local.example.data.entity.Customer;
import local.example.data.repository.CustomerRepository;
import local.example.data.view.handler.CustomerChangeHandler;
import lombok.Getter;
import lombok.Setter;

@SpringComponent
@UIScope
public class CustomerViewEditor 
		extends VerticalLayout 
		implements KeyNotifier {

	private static final long serialVersionUID = -2486816437236479000L;
	private final CustomerRepository customerRepository;
	private final TextField nicknameTextField;
	private final TextField abcClassificationTextField;
	private final Button saveButton;
	private final Button cancelButton;
	private final Button deleteButton;
	private final HorizontalLayout tools;
	private final Binder<Customer> binderOfCustomers;
	private CustomerChangeHandler customerChangeHandler;

	@Getter
	@Setter
	private Customer customer;

	@Autowired
	public CustomerViewEditor(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
		this.nicknameTextField = new TextField("nickname");
		this.abcClassificationTextField = new TextField("abc classification");
		this.saveButton = new Button("save", VaadinIcon.UPLOAD.create());
		this.cancelButton = new Button("cancel", VaadinIcon.DEL.create());
		this.deleteButton = new Button("delete", VaadinIcon.TRASH.create());
		this.tools = new HorizontalLayout(saveButton, cancelButton, deleteButton);
		this.binderOfCustomers = new Binder<>(Customer.class);
		this.binderOfCustomers.bindInstanceFields(this);
		this.setSpacing(true);
		this.add(nicknameTextField, abcClassificationTextField, tools);
		this.setVisible(false);
	}

	public final void edit(Customer temp) {
		// TODO
	}

	public void save() {
		customerRepository.save(this.customer);
		customerChangeHandler.onChange();
	}

	public void cancel() {
		// TODO
	}

	public void delete() {
		// TODO
		customerChangeHandler.onChange();
	}
}
