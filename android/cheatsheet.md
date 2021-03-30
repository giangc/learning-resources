#### Describe @Inject annotator in Dagger. 

* @Inject annotator is used to connect injector and injectee. 

``` JAVA
  // kotlin
  // This's injector
  class Car @Inject constructor(val e: Engine, var wheel: Wheel) {
    // .. 
  }

  // Injectees
  class Engine @Inject constructor(){
    
  }
  class Wheel @Inject constructor(){

  }
  ```
#### Provide classes that your project doesn't own
``` JAVA
// kotlin
// @Module informs Dagger that this class is a Dagger Module
@Module
class NetworkModule {

    // @Provides tell Dagger how to create instances of the type that this function
    @Provides
    fun provideLoginRetrofitService(): LoginRetrofitService {
        return Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(LoginService::class.java)
    }
}

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    ...
}

```


#### Create a custom scope

``` JAVA
// kotlin
// Creates MyCustomScope
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class MyCustomScope
```

``` JAVA
// Kotlin
@MyCustomScope
@Component
interface ApplicationGraph {
    fun repository(): UserRepository
}

@MyCustomScope
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val service: UserService
) { ... }
```

#### Use @Singleton as scope

``` JAVA
// Kotlin
@Singleton
@Component
interface ApplicationGraph {
    fun repository(): UserRepository
}

@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val service: UserService
) { ... }
```
