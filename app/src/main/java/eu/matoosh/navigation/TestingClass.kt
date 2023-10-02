package eu.matoosh.navigation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        val childJob1 = launch {
            repeat(40) {
                println("Child Job 1: $it")
                delay(100)
            }
        }

        val childJob2 = launch {
            try {
                repeat(10) {
                    println("Child Job 2: $it")
                    delay(100)
                }
                throw RuntimeException("An exception in childJob2") // Simulating an exception
            } catch (e: Exception) {
                println("Exception in childJob2: $e")
            }
        }

        println("Parent Job is waiting for child jobs to complete")
    }

    parentJob.join()
    println("Parent Job and its child jobs are complete")
}