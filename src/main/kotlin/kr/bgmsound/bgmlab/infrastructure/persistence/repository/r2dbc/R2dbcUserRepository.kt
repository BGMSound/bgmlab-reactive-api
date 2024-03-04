package kr.bgmsound.bgmlab.infrastructure.persistence.repository.r2dbc

import kr.bgmsound.bgmlab.infrastructure.persistence.entity.UserEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface R2dbcUserRepository : R2dbcRepository<UserEntity, Long>