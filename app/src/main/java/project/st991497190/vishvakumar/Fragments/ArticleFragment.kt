package project.st991497190.vishvakumar.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import project.st991497190.vishvakumar.R
import project.st991497190.vishvakumar.databinding.AppScreenBinding

class ArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<AppScreenBinding>(
            inflater,
            R.layout.fragment_article, container, false
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

        return binding.root
    }


}