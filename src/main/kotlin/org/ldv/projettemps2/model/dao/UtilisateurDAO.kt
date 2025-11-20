package org.ldv.projettemps2.model.dao

import org.ldv.projettemps2.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {


    @Query("select u from Utilisateur u where u.email = ?1")
    fun findByEmail(email: String): Utilisateur

}
