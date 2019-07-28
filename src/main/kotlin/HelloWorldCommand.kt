import Command.Status
import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {
    override fun key(): String {
        return "hello"
    }

    override fun handleInput(input: List<String>): Status {
        if (input.isNotEmpty()) {
            return Status.INVALID
        }
        println("world!")
        return Status.HANDLED
    }
}