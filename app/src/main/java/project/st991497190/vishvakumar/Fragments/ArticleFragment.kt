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

        return binding.root
    }


}