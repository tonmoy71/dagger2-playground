package module

import Outputter
import dagger.Module
import dagger.Provides

@Module
abstract class SystemOutModule {
    //Reference: https://github.com/google/dagger/issues/900#issuecomment-337043187
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun textOutputter(): Outputter {
            return object : Outputter {
                override fun output(output: String) {
                    println(output)
                }
            }
        }
    }


}