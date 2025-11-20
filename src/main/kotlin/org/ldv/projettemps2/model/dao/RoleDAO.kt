package org.ldv.projettemps2.model.dao

import org.ldv.projettemps2.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {
}