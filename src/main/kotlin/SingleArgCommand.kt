import Command.Result

/** Abstract command that accepts a single argument */

abstract class SingleArgCommand : Command {
    override fun handleInput(input: List<String>): Result {
        return if (input.size == 1) handleArg(input[0]) else Result.invalid()
    }

    abstract fun handleArg(userName: String): Result
}