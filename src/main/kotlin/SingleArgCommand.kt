import Command.Status

/** Abstract command that accepts a single argument */

abstract class SingleArgCommand : Command {
    override fun handleInput(input: List<String>): Status {
        return if (input.size == 1) handleArg(input[0]) else Status.INVALID
    }

    abstract fun handleArg(userName: String): Status
}