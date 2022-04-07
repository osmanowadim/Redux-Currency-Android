package osmanov.example.mvicurrencyandroid.data.cache.db

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    application = TestRobolectric.ApplicationStub::class,
    sdk = [Build.VERSION_CODES.M]
)
abstract class TestRobolectric {

    protected lateinit var database: CurrencyDB

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    protected val application: Application by lazy {
        ApplicationProvider.getApplicationContext<ApplicationStub>()
    }
    protected val context: Context by lazy {
        application
    }

    internal class ApplicationStub : Application()

    open fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room
            .inMemoryDatabaseBuilder(context, CurrencyDB::class.java)
            .allowMainThreadQueries()
            .build()
    }

    open fun closeDb() {
        database.close()
    }

}
