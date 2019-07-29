import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

/** Installs basic commands */
@Module
abstract class CommandsModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command

    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(loginCommand: LoginCommand): Command
}