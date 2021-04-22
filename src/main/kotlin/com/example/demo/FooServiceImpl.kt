package com.example.demo

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FooServiceImpl(
  private val deniedService: DeniedService,
) : FooService {

  override fun deniedMono(): Mono<String> {
    return deniedService.single()
  }

  override fun deniedFlux(): Flux<String> {
    return deniedService.multiple()
  }

  override fun deniedKotlinMono(): Mono<String> {
    return deniedService.singleKotlinMono()
  }

  override suspend fun deniedSuspendMono(): String {
    return deniedService.singleSuspended()
  }

  override fun deniedFlow(): Flow<String> {
    return deniedService.multipleAsFlow()
  }
}
