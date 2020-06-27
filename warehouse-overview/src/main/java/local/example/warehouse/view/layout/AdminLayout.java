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

package local.example.warehouse.view.layout;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import local.example.warehouse.model.entity.CategoryEntity;
import local.example.warehouse.model.repository.CategoryRepository;

public class AdminLayout extends VerticalLayout {

	private static final long serialVersionUID = -629028535067863373L;

	@Autowired
	CategoryRepository categoryRepository;

	public static final String VIEW_NAME = "Admin";

	private final Button addCategoryButton;
	@SuppressWarnings("unused")
	private final ArrayList<CategoryEntity> categories;
	@SuppressWarnings("unused")
	private final IronList<CategoryEntity> ironListOfCategories;

	@Autowired
	public AdminLayout() {
		super();
		this.addCategoryButton = new Button("add", VaadinIcon.PLUS_CIRCLE.create());
		this.categories = new ArrayList<CategoryEntity>(categoryRepository.findAll());
		this.ironListOfCategories = new IronList<CategoryEntity>();
		
		this.add(
				new H2("admin overview"), 
				new H4("categories editor"), 
				this.addCategoryButton
		);
	}
	
}
