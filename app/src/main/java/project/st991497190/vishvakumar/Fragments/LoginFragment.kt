package project.st991497190.vishvakumar.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.login_screen.*
//import org.rohan.patel.finalprojectandroid.R
//import org.rohan.patel.finalprojectandroid.databinding.LoginScreenBinding
import project.st991497190.vishvakumar.Database.FitDatabase
import project.st991497190.vishvakumar.R
import project.st991497190.vishvakumar.databinding.LoginScreenBinding

class LoginFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<LoginScreenBinding>(inflater,
                R.layout.login_screen,container,false)

        val application = requireNotNull(this.activity).application
        val loginDao = FitDatabase.getInstance(application).loginDao()

        binding.buttonLogin.setOnClickListener {
            if(binding.editTextEmail.text.trim().isEmpty()) {
                Toast.makeText(activity, "Enter your Email Address!", Toast.LENGTH_SHORT).show()
            }else if(binding.editTextPassword.text.trim().isEmpty()){
                Toast.makeText(activity, "Enter your PASSWORD!", Toast.LENGTH_SHORT).show()
            }else{
                val user = loginDao.checkUser(editTextEmail.text.toString(), editTextPassword.text.toString())
                if(user==false){
                    Toast.makeText(activity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }else{
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_appFragment)
                }
            }
        }

        return binding.root
    }
}