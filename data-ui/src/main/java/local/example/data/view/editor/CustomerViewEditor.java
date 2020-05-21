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
	private final TextField nickname;
	private final TextField abcClassification;
	private final Button save;
	private final Button cancel;
	private final Button delete;
	private final HorizontalLayout tools;
	private final Binder<Customer> binderOfCustomers;
	private CustomerChangeHandler changeHandler;

	@Getter
	@Setter
	private Customer customer;

	@Autowired
	public CustomerViewEditor(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
		this.nickname = new TextField("nickname");
		this.abcClassification = new TextField("abc classification");
		this.save = new Button("save", VaadinIcon.UPLOAD.create());
		this.cancel = new Button("cancel", VaadinIcon.MINUS_CIRCLE.create());
		this.delete = new Button("delete", VaadinIcon.TRASH.create());
		this.tools = new HorizontalLayout(save, cancel, delete);
		this.binderOfCustomers = new Binder<>(Customer.class);
		this.binderOfCustomers.bindInstanceFields(this);
		this.setSpacing(true);
		this.add(nickname, abcClassification, tools);
		this.setVisible(false);
	}

	public void save() {
		// TODO
		changeHandler.onChange();
	}

	public void cancel() {
		// TODO
	}

	public void delete() {
		// TODO
		changeHandler.onChange();
	}
}
