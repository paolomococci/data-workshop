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

package local.example.data.view

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

@Route(value = "")
@CssImport(value = "style.css")
@PWA(name = "consumer template", shortName = "consumer", enableInstallPrompt = false)
@Viewport(value = "width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
class MainView : KComposite() {

    private lateinit var nameField: TextField
    private lateinit var welcomeButton: Button

    private val mainView = ui {
        verticalLayout {
            addClassName("centered-content")
            nameField = textField("name")
            welcomeButton = button("welcome") {
                setPrimary()
                addClickShortcut(Key.ENTER)
            }
        }
    }

    init {
        welcomeButton.onLeftClick {
            Notification.show("Welcome, ${nameField.value}")
        }
    }
}
