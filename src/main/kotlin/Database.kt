import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    private val accounts = mutableMapOf<String, Account>()

    init {
        println("Creating a new $this")
    }

    fun getAccount(userName: String): Account {
        return accounts.computeIfAbsent(userName) { Account(userName) }
    }

    companion object {
        class Account(val userName: String) {
            private var _balance: BigDecimal = BigDecimal.ZERO
            val balance: BigDecimal
                get() = _balance

            fun deposit(amount: BigDecimal) {
                checkNonNegative(amount, "deposit")
                _balance = _balance.add(amount)
            }

            private fun checkNonNegative(amount: BigDecimal, action: String) {
                if (amount.signum() == -1) {
                    throw IllegalArgumentException("Cannot $action negative amounts: $amount")
                }
            }
        }
    }
}