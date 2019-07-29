import Command.Status.HANDLED
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
) : Command {
    init {
        println("Creating a new $this")
    }

    override fun handleInput(input: List<String>): Command.Status {
        if (input.size != 2) {
            return Command.Status.INVALID
        }
        val account = database.getAccount(input[0])
        account.deposit(BigDecimal(input[1]))
        outputter.output("${account.userName} now has: ${account.balance} ")
        return HANDLED
    }
}