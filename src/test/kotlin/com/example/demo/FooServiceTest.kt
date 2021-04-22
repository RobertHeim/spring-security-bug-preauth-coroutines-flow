package com.example.demo

import com.ninjasquad.springmockk.MockkBean
import io.mockk.Called
import io.mockk.verify
import kotlinx.coroutines.reactor.asFlux
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.security.access.AccessDeniedException
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [FooServiceImpl::class])
@Import(TestSecurityConfig::class)
class FooServiceTest {

  @MockkBean
  lateinit var deniedService: DeniedService

  @Autowired
  lateinit var fooService: FooService

  @Test
  fun `deniedMono throws`() {
    assertThrows<AccessDeniedException> {
      fooService.deniedMono().block()
    }
    verify { deniedService wasNot Called }
  }

  @Test
  fun `deniedFlux throws`() {
    assertThrows<AccessDeniedException> {
      fooService.deniedFlux().blockFirst()
    }
    verify { deniedService wasNot Called }
  }

  @Test
  fun `deniedKotlinMono throws`() {
    assertThrows<AccessDeniedException> {
      fooService.deniedKotlinMono().block()
    }
    verify { deniedService wasNot Called }
  }

  @Test
  fun `deniedSuspendMono throws`() {
    runBlocking {
      assertThrows<AccessDeniedException> {
        fooService.deniedSuspendMono()
      }
    }
    verify { deniedService wasNot Called }
  }

  @Test
  fun `deniedFlow throws`() {
    assertThrows<AccessDeniedException> {
      fooService.deniedFlow().asFlux().blockFirst()
    }
    verify { deniedService wasNot Called }
  }
}
