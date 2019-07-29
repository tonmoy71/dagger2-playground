import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(depositCommand: DepositCommand): Command
}