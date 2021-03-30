// @Component makes Dagger create a graph of dependencies
@Component
interface ApplicationGraph {
    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun repository(): UserRepository
}

// ------------------------------------------------------------------------------------ 

// Create an instance of the application graph
val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()
// Grab an instance of UserRepository from the application graph
val userRepository: UserRepository = applicationGraph.repository()

// ------------------------------------------------------------------------------------ 
val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()

val userRepository: UserRepository = applicationGraph.repository()
val userRepository2: UserRepository = applicationGraph.repository()

assert(userRepository != userRepository2)

// ------------------------------------------------------------------------------------ 

// Scope annotations on a @Component interface informs Dagger that classes annotated
// with this annotation (i.e. @Singleton) are bound to the life of the graph and so
// the same instance of that type is provided every time the type is requested.
@Singleton
@Component
interface ApplicationGraph {
    fun repository(): UserRepository
}

// Creates MyCustomScope
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class MyCustomScope


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


// Definition of the Application graph
@Component
interface ApplicationComponent { ... }

// appComponent lives in the Application class to share its lifecycle
class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()
}

@Component
interface ApplicationComponent {
    // This tells Dagger that LoginActivity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that LoginActivity is requesting.
    fun inject(activity: LoginActivity)
}

class LoginActivity: Activity() {
  // You want Dagger to provide an instance of LoginViewModel from the graph
  @Inject lateinit var loginViewModel: LoginViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
      // Make Dagger instantiate @Inject fields in LoginActivity
      (applicationContext as MyApplication).appComponent.inject(this)
      // Now loginViewModel is available

      super.onCreate(savedInstanceState)
  }
}

class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) { ... }

class UserLocalDataSource @Inject constructor() { ... }
class UserRemoteDataSource @Inject constructor(
    private val loginService: LoginRetrofitService
) { ... }



// @Inject tells Dagger how to create instances of LoginViewModel
class LoginViewModel @Inject constructor(
  private val userRepository: UserRepository
) { ... }


class LoginActivity: Activity() {
  // You want Dagger to provide an instance of LoginViewModel from the graph
  @Inject lateinit var loginViewModel: LoginViewModel
}


// Scope this class to a component using @Singleton scope (i.e. ApplicationGraph)
@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) { ... }

// Container of objects shared across the whole app
class AppContainer {

    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    private val retrofit = Retrofit.Builder()
                            .baseUrl("https://example.com")
                            .build()
                            .create(LoginService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()

    // userRepository is not private; it'll be exposed
    val userRepository = UserRepository(localDataSource, remoteDataSource)
}

class LoginActivity: Activity() {

  private lateinit var loginViewModel: LoginViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      // Gets userRepository from the instance of AppContainer in Application
      val appContainer = (application as MyApplication).appContainer
      loginViewModel = LoginViewModel(appContainer.userRepository)
  }
}


@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: LoginActivity)
}

@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) { ... }

@Module
class NetworkModule {
    // Way to scope types inside a Dagger Module
    @Singleton
    @Provides
    fun provideLoginRetrofitService(): LoginRetrofitService { ... }
}


// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(subcomponents = LoginComponent::class)
class SubcomponentsModule {}



// Including SubcomponentsModule, tell ApplicationComponent that
// LoginComponent is its subcomponent.
@Singleton
@Component(modules = [NetworkModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
}

@Singleton
@Component(modules = [NetworkModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
// This function exposes the LoginComponent Factory out of the graph so consumers
// can use it to obtain new instances of LoginComponent
fun loginComponent(): LoginComponent.Factory
}