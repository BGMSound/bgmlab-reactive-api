package kr.bgmsound.bgmlab.domain.repository

import kr.bgmsound.bgmlab.domain.model.User

interface UserRepository {

    suspend fun findById(id: Long): User?

    suspend fun save(user: User): User

}