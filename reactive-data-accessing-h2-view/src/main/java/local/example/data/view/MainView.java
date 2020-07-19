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

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle(value = "reactive data accessing")
public class MainView 
		extends Main {

	private static final long serialVersionUID = 4241629279709817521L;

	private final Section mainSection;
	private final H2 subtitle;
	private final Paragraph paragraph;

	public MainView() {
		this.paragraph = new Paragraph();
		this.subtitle = new H2("access through a RESTful service of item data");
		this.paragraph.add("open the navigation bar and click on the link that interests you");
		this.mainSection = new Section(this.subtitle, this.paragraph);
		this.add(this.mainSection);
	}
}
