## Minimal reproducible example

```
@PreAuthorize("denyAll")
fun deniedFlow(): Flow<String>
```

and the implementation

```
override fun deniedFlow(): Flow<String> {
  return deniedService.multipleAsFlow()
}
```

I expect that `deniedService.multipleAsFlow` is not executed, but it is.

## Run

Please see [FlowService](src/main/kotlin/com/example/demo/FooService.kt) and its test
[FooServiceTest](src/test/kotlin/com/example/demo/FooServiceTest.kt) which contains test for all different
Mono/Flux/Flow cases. All succeed, but the one returning `Flow`.

```
./gradlew test
```

## Expected

Build success

## Actual

Fails with:

```
Caused by: io.mockk.MockKException: no answer found for: DeniedService(com.example.demo.DeniedService#0 bean#1).multipleAsFlow()
```

The error complains a missing mock because the `deniedService` was executed, but it should have been denied.
