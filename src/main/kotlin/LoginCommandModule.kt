import dagger.Binds
import dagger.Module

@Module
abstract class LoginCommandModule {
    @Binds
    abstract fun loginCommand(loginCommand: LoginCommand): Command
}