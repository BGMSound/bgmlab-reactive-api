package kr.bgmsound.bgmlab.presentation.controller

import kr.bgmsound.bgmlab.domain.model.User
import kr.bgmsound.bgmlab.domain.repository.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
class UserController(
    private val userRepository: UserRepository,
) {

    @GetMapping("user")
    suspend fun getUser(): User {
        return userRepository.findById(1) ?: User(0, "User Not Found")
    }

    @PostMapping("user")
    suspend fun registerUser(): User {
        return userRepository.save(User(2, "test"))
    }

}