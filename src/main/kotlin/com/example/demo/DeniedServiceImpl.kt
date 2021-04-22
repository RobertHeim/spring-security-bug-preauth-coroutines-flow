package com.example.demo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.reactor.mono
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DeniedServiceImpl : DeniedService {
  override fun single(): Mono<String> {
    return Mono.just("deniedMono")
  }

  override fun multiple(): Flux<String> {
    return Flux.just("deniedFlux")
  }

  override fun singleKotlinMono(): Mono<String> {
    return mono { "deniedSuspendMono" }
  }

  override suspend fun singleSuspended(): String {
    return "deniedSuspendMono"
  }


  override fun multipleAsFlow(): Flow<String> {
    return flowOf("deniedFlow")
  }
}
