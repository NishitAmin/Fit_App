package project.st991497190.vishvakumar.viewModelsFactory
// Rohan Patel - 991496523
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import project.st991497190.vishvakumar.Dao.LoginDao
import project.st991497190.vishvakumar.viewModels.AddLogViewModel
import project.st991497190.vishvakumar.viewModels.LoginViewModel

class AddLoginViewModelFactory(
    private val loginDao : LoginDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddLogViewModel::class.java)) {
            return LoginViewModel(loginDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

