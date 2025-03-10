package hu.obuda.devops.fibonaccirestapi.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FibonacciService {
    fun fibonacci(n: Int): Int {
        if(n > 0){
            if (n <= 1) return n
            if( n > 46) throw ResponseStatusException(HttpStatus.BAD_REQUEST, "n > 46 is not allowed")
            var a = 0
            var b = 1
            for (i in 2..n) {
                val temp = a + b
                a = b
                b = temp
            }
            return b
        }
        else
            throw IllegalArgumentException("n must be greater than 0")
    }
}