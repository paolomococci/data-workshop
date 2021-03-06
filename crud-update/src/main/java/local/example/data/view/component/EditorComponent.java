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

package local.example.data.view.component;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import local.example.data.entity.EndUser;
import local.example.data.repository.EndUserRepository;

@SpringComponent
@UIScope
public class EditorComponent 
		extends VerticalLayout 
		implements KeyNotifier {

	private static final long serialVersionUID = 2510377311669291491L;

	private Label label = new Label("#editor");
	@SuppressWarnings("unused")
	private EndUser endUser;
	@SuppressWarnings("unused")
	private final EndUserRepository endUserRepository;
	@SuppressWarnings("unused")
	private Binder<EndUser> binderOfEndUser;
	@SuppressWarnings("unused")
	private FormLayout editor;

	@Autowired
	public EditorComponent(EndUserRepository endUserRepository) {
		super();
		this.endUserRepository = endUserRepository;
		this.binderOfEndUser = new Binder<>();
		this.editor = new FormLayout();
		this.add(this.label);
	}
}
