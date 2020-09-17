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

package local.example.data.layout

import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.*
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.AfterNavigationEvent
import com.vaadin.flow.router.AfterNavigationObserver
import com.vaadin.flow.router.RouterLink
import com.vaadin.flow.server.PWA
import local.example.data.view.MainView

@Push
@CssImport(value = "style.css")
@PWA(enableInstallPrompt = false, name = "zen-operations-admin", shortName = "operations-admin", startPath = "/main")
@Viewport(value = "width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
class MainLayout : AppLayout(), AfterNavigationObserver {

    internal var title: H1? = null
    internal var mainView: RouterLink? = null

    private fun listLinks(): Array<RouterLink?> {
        return arrayOf(
                mainView
        )
    }

    override fun afterNavigation(afterNavigationEvent: AfterNavigationEvent?) {
        for (routerLink in listLinks()) {
            if (routerLink!!.highlightCondition.shouldHighlight(
                            routerLink,
                            afterNavigationEvent
                    )) {
                title!!.text = routerLink.text
            }
        }
    }

}

fun mainLayout(mainLayout: MainLayout) {
    mainLayout.title = H1("reactive RESTful web service data accessing")
    mainLayout.mainView = RouterLink("main view", MainView::class.java)
    val orderedList = OrderedList(
            ListItem(mainLayout.mainView)
    )
    val header = Header(DrawerToggle(), mainLayout.title)
    val nav = Nav(orderedList)
    mainLayout.addToNavbar(header)
    mainLayout.addToDrawer(nav)
    mainLayout.primarySection = AppLayout.Section.DRAWER
    mainLayout.isDrawerOpened = true
}
