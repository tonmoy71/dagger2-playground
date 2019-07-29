import command.Command
import command.Command.Status.HANDLED
import command.Command.Status.INPUT_COMPLETED
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(
    firstCommandRouter: CommandRouter
) {
    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Command.Status {
        val result = commandRouterStack.peek().route(input)
        if (result.status == INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()) INPUT_COMPLETED else HANDLED
        }
        result.nestedCommandRouter?.let {
            commandRouterStack.push(it)
        }
        return result.status
    }
}