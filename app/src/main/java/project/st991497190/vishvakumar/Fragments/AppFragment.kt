package project.st991497190.vishvakumar.Fragments

//import org.rohan.patel.finalprojectandroid.R
//import org.rohan.patel.finalprojectandroid.databinding.AppScreenBinding
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import project.st991497190.vishvakumar.R
import project.st991497190.vishvakumar.databinding.AppScreenBinding
import java.util.zip.Inflater
import kotlin.math.log


class AppFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<AppScreenBinding>(
            inflater,
            R.layout.app_screen, container, false
        )

        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navView)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.signUpFragment)
        target.setVisible(false)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(false)
        val target3: MenuItem = menu.findItem(R.id.homeScreenFragment)
        target3.setVisible(true)
        val target4: MenuItem = menu.findItem(R.id.bmiFragment)
        target4.setVisible(true)
        val target5: MenuItem = menu.findItem(R.id.addLogFragment)
        target5.setVisible(true)
        val target6: MenuItem = menu.findItem(R.id.viewLogsFragment)
        target6.setVisible(true)
        val target7: MenuItem = menu.findItem(R.id.articleFragment)
        target7.setVisible(true)

        binding.buttonCalculateBMI.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_bmiFragment)
        }

        binding.buttonAddLog.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_addLogFragment)
        }

        binding.buttonViewLogs.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_viewLogsFragment)
        }


        return binding.root
    }


}