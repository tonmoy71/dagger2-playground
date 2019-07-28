/** Logic to process some user input */

interface Command {
    /** Process the rest of the command's words and oo something */
    fun handleInput(input: List<String>): Status

    enum class Status {
        INVALID,
        HANDLED
    }

}