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

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class OverviewComponent 
		extends VerticalLayout {

	private static final long serialVersionUID = 7293973219485438417L;

	public static final String[] COLUMNS = {"id", "name", "surname", "username"};
	private VerticalLayout main;
	private Div content;

	@Autowired
	public OverviewComponent() {
		super();
		this.content = new Div();
		this.content.setTitle("overview page");
		this.content.setText("overview TODO");
		this.main = new VerticalLayout();
		// TODO
		this.add(main);
	}
}
