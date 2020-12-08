package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.register_screen.*
import kotlinx.coroutines.flow.combine
import org.jetbrains.anko.doAsync
import org.rohan.patel.finalprojectandroid.Entity.LoginEntity
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.databinding.RegisterScreenBinding
import org.rohan.patel.finalprojectandroid.viewModels.AddLogViewModel
import org.rohan.patel.finalprojectandroid.viewModels.LoginViewModel
import org.rohan.patel.finalprojectandroid.viewModelsFactory.AddLogViewModelFactory
import org.rohan.patel.roomdatabasesample.FitDatabase
import kotlin.math.log

class SignUpFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<RegisterScreenBinding>(inflater,
            R.layout.register_screen,container,false)

        val application = requireNotNull(this.activity).application
        val loginDao = FitDatabase.getInstance(application).loginDao()

        binding.btnRegister.setOnClickListener {
            if(binding.editTextName.text.trim().length>0 && binding.editTextEmail.text.trim().length>0 && binding.editTextPassword.text.trim().length>0 && binding.checkBoxTerms.isChecked==true){
                val newUser = LoginEntity(0, editTextName.text.toString(), editTextEmail.text.toString(), editTextPassword.text.toString())
                loginDao.userRegistration(newUser)
                Toast.makeText(activity, "Registered!", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_signUpFragment_to_homeScreenFragment)
            }else{
                Toast.makeText(activity, "Fields cannot be empty!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}