package kr.bgmsound.bgmlab.presentation.controller

import kr.bgmsound.bgmlab.domain.model.User
import kr.bgmsound.bgmlab.domain.repository.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
class UserController(
    private val userRepository: UserRepository,
) {

    @GetMapping("/user/{id}")
    suspend fun getUser(@PathVariable id: Long): User {
        return userRepository.findById(id) ?: User(0, "User Not Found")
    }

    @PostMapping("/user/{id}")
    suspend fun registerUser(@PathVariable id: Long): User {
        return userRepository.save(User(id, "test"))
    }

}