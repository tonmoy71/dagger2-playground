package component

import CommandProcessor
import dagger.Component
import module.CommandsModule
import module.SystemOutModule
import module.UserCommandsModule
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