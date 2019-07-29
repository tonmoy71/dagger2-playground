import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {
    private val accounts = mutableMapOf<String, Account>()

    fun getAccount(userName: String): Account {
        return accounts.computeIfAbsent(userName) { Account(userName) }
    }

    companion object {
        class Account(val userName: String, val balance: BigDecimal = BigDecimal.ZERO)
    }
}