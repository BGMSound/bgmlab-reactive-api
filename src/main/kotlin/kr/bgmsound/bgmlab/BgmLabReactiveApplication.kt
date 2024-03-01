package kr.bgmsound.bgmlab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BgmLabReactiveApplication

fun main(args: Array<String>) {
    runApplication<BgmLabReactiveApplication>(*args)
}