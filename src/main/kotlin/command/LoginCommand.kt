package command

import Database
import Outputter
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
) : SingleArgCommand() {
    init {
        println("Creating a new $this")
    }

    override fun handleArg(userName: String): Command.Result {
        val account = database.getAccount(userName)
        outputter.output("$userName is logged in with balance: ${account.balance}")
        return Command.Result.handled()
    }
}