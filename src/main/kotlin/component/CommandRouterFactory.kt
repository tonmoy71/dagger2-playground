package component

import CommandRouter
import dagger.Component
import module.CommandsModule
import module.SystemOutModule
import module.UserCommandsModule
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