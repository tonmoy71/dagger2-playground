import Command.Status

class CommandRouter {
    private val commands: Map<String, Command> = mutableMapOf()

    fun route(input: String): Status {
        val splitInput: List<String> = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val status = command.handleInput(splitInput.subList(1, splitInput.size))
        if (status == Status.INVALID) {
            println("$commandKey : invalid arguments")
        }
        return status
    }

    private fun invalidCommand(input: String): Status {
        println("Couldn't understand $input, please try again.")
        return Status.INVALID
    }

    /** Split on whitespace */
    private fun split(input: String): List<String> {
        return input.trim().split(" ")
    }
}