package kr.bgmsound.bgmlab.presentation.controller

import kotlinx.coroutines.Dispatchers
import kr.bgmsound.bgmlab.domain.model.User
import kr.bgmsound.bgmlab.domain.repository.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@Controller
@ResponseBody
class UserController(
    private val userRepository: UserRepository,
) {

    @GetMapping("/user/{id}")
    suspend fun getUser(@PathVariable id: Long): User {
        return coroutineScope {
            async(Dispatchers.IO) {
                userRepository.findById(id) ?: User(0, "User Not Found")
            }
        }.await()
    }

    @PostMapping("/user/{id}")
    suspend fun registerUser(@PathVariable id: Long): User {
        return coroutineScope {
            async(Dispatchers.IO) {
                userRepository.save(User(id, "test"))
            }
        }.await()
    }

}