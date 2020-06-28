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
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

import local.example.data.model.CustomerStatus;

public class CustomerForm 
		extends FormLayout {

	private static final long serialVersionUID = 8460707291910308110L;

	private final TextField name;
	private final TextField surname;
	private final DatePicker birthday;
	private final TextField email;
	private final ComboBox<CustomerStatus> status;
	private final Button save;
	private final Button delete;

	public CustomerForm() {
		super();
		this.name = new TextField("name");
		this.surname = new TextField("surname");
		this.birthday = new DatePicker("birthday");
		this.email = new TextField("email");
		this.status = new ComboBox<>("status");
		this.save = new Button();
		this.delete = new Button();
		this.add(name, surname, birthday, email, status, save, delete);
		// TODO
	}
}
