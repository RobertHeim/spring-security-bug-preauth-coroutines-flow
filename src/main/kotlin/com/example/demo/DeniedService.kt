package com.example.demo

import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DeniedService {
  fun single(): Mono<String>
  fun multiple(): Flux<String>
  fun singleKotlinMono(): Mono<String>
  suspend fun singleSuspended(): String
  fun multipleAsFlow(): Flow<String>
}
