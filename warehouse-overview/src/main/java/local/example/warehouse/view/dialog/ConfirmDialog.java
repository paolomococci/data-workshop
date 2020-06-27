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

package local.example.warehouse.view.dialog;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ConfirmDialog 
		extends Dialog {

	private static final long serialVersionUID = 3684165462625772563L;

	@SuppressWarnings("unused")
	private final VerticalLayout rootContent;
	@SuppressWarnings("unused")
	private final HorizontalLayout buttonsBar;
	@SuppressWarnings("unused")
	private final Button confirmButton;
	@SuppressWarnings("unused")
	private final Button cancelButton;

	public ConfirmDialog() {
		super();
		this.rootContent = new VerticalLayout();
		this.buttonsBar = new HorizontalLayout();
		this.confirmButton = new Button();
		this.cancelButton = new Button();
	}
}
