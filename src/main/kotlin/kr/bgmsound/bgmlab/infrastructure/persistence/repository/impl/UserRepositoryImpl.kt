package kr.bgmsound.bgmlab.infrastructure.persistence.repository.impl

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kr.bgmsound.bgmlab.domain.model.User
import kr.bgmsound.bgmlab.domain.repository.UserRepository
import kr.bgmsound.bgmlab.infrastructure.persistence.entity.UserEntity
import kr.bgmsound.bgmlab.infrastructure.persistence.repository.r2dbc.R2dbcUserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val r2dbcRepository: R2dbcUserRepository,
) : UserRepository {

    override suspend fun findById(id: Long): User? {
        return r2dbcRepository.findById(id).awaitSingleOrNull()?.toDomain()
    }

    override suspend fun save(user: User): User {
        val entity = if (findById(user.id) == null) {
            UserEntity.new(user)
        } else {
            UserEntity.of(user)
        }
        return r2dbcRepository.save(entity).awaitSingle().toDomain()
    }

}