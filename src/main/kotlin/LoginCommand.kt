import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter
) : SingleArgCommand() {
    override fun handleArg(userName: String): Command.Status {
        outputter.output("$userName is logged in.")
        return Command.Status.HANDLED
    }

}