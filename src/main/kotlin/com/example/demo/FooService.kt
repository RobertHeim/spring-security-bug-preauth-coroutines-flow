package com.example.demo

import kotlinx.coroutines.flow.Flow
import org.springframework.security.access.prepost.PreAuthorize
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FooService {

  @PreAuthorize("denyAll")
  fun deniedMono(): Mono<String>

  @PreAuthorize("denyAll")
  fun deniedFlux(): Flux<String>

  @PreAuthorize("denyAll")
  fun deniedKotlinMono(): Mono<String>

  @PreAuthorize("denyAll")
  suspend fun deniedSuspendMono(): String

  @PreAuthorize("denyAll")
  fun deniedFlow(): Flow<String>

}
