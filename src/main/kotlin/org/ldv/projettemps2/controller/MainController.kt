package org.ldv.projettemps2.controller

import org.ldv.projettemps2.model.dao.UtilisateurDAO
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class MainController (val utilisateurDAO: UtilisateurDAO){


    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/TheWatchers")
    fun home():String{
        return "index"
    }

    @GetMapping("/TheWatchers/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }

    @GetMapping("/TheWatchers/profil")
    fun profile(authentication: Authentication,  model: Model): String {
        // Récupération des informations utilisateurs :
        val email = authentication.name
        val utilisateur = utilisateurDAO.findByEmail(authentication.name)

        model.addAttribute("user" , utilisateur)

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/TheWatchers/admin/dashboard"
        }

        // Sinon → on affiche la page profile

        return "pagesClient/profile"
    }

}
