import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CommandsModule::class,
        UserCommandsModule::class,
        SystemOutModule::class]
)
interface CommandRouterFactory {
    fun router(): CommandRouter
}