package kr.bgmsound.bgmlab.infrastructure.persistence.entity

import kr.bgmsound.bgmlab.domain.model.User
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("public.user")
class UserEntity(
    @Id
    val id: Long,

    @Column("name")
    val name: String
) : Persistable<Long> {

    @Transient
    private var isNew: Boolean = false

    constructor(id: Long, name: String, isNew: Boolean) : this(id, name) {
        this.isNew = isNew
    }

    override fun getId() = id

    override fun isNew() = isNew

    fun toDomain() = User(this.id, this.name)

    companion object {
        fun of(user: User) = UserEntity(user.id, user.name)

        fun new(user: User) = UserEntity(user.id, user.name, true)
    }

}