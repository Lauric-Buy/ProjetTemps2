package org.ldv.projettemps2.controller.admincontrollers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class admin {
    @GetMapping("TheWatchers/admin/dashboard")
    fun dashboard(model : Model): String {
    return "/pageAdmin/dashboard"
    }
}
