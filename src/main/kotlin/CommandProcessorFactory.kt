import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        SystemOutModule::class,
        CommandsModule::class,
        UserCommandsModule::class
    ]
)
@Singleton
interface CommandProcessorFactory {
    fun processor(): CommandProcessor
}