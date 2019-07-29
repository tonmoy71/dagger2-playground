import command.Command
import command.Command.Status
import javax.inject.Inject

class CommandRouter @Inject constructor(
    private val commands: MutableMap<String, Command>,
    private val outputter: Outputter
) {
    init {
        println("Creating a new $this")
    }

    fun route(input: String): Command.Result {
        val splitInput: List<String> = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val args = splitInput.subList(1, splitInput.size)
        val result = command.handleInput(args)
        if (result.status == Status.INVALID) {
            invalidCommand(input)
        }
        return result
    }

    private fun invalidCommand(input: String): Command.Result {
        outputter.output("Couldn't understand $input, please try again.")
        return Command.Result.invalid()
    }

    /** Split on whitespace */
    private fun split(input: String): List<String> {
        return input.trim().split(" ")
    }
}