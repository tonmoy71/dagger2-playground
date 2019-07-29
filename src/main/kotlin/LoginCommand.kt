import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
) : SingleArgCommand() {
    override fun handleArg(userName: String): Command.Status {
        val account = database.getAccount(userName)
        outputter.output("$userName is logged in with balance: ${account.balance}")
        return Command.Status.HANDLED
    }
}