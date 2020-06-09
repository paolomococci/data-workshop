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

package local.example.data.view.component.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class OverviewLayoutComponent 
		extends VerticalLayout {

	private static final long serialVersionUID = 8503074663645043168L;

	public static final String[] COLUMNS = {"id", "name", "surname", "username"};
	private Label label = new Label("#overview");

	@Autowired
	public OverviewLayoutComponent() {
		super();
		this.add(label);
	}
}
