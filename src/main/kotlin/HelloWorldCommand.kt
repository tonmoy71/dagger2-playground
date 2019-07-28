import Command.Status
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
) : Command {
    override fun key(): String {
        return "hello"
    }

    override fun handleInput(input: List<String>): Status {
        if (input.isNotEmpty()) {
            return Status.INVALID
        }
        outputter.output("world!")
        return Status.HANDLED
    }
}