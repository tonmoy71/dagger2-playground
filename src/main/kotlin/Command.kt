import Command.Status.*

/** Logic to process some user input */

interface Command {
    /** Process the rest of the command's words and do something */
    fun handleInput(input: List<String>): Result

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }

    class Result(val status: Status, val nestedCommandRouter: CommandRouter?) {

        companion object {
            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter?): Result {
                return Result(HANDLED, nestedCommandRouter)
            }

            fun invalid(): Result {
                return Result(INVALID, null)
            }

            fun handled(): Result {
                return Result(HANDLED, null)
            }

            fun inputCompleted(): Result {
                return Result(INPUT_COMPLETED, null)
            }
        }
    }

}