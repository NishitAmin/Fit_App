package org.rohan.patel.finalprojectandroid.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_view_logs.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.rohan.patel.finalprojectandroid.Entity.WeightLiftingEntity
import org.rohan.patel.finalprojectandroid.R
import org.rohan.patel.finalprojectandroid.RecyclerView.MyRecyclerViewRunning
import org.rohan.patel.finalprojectandroid.RecyclerView.MyRecyclerViewSwimming
import org.rohan.patel.finalprojectandroid.RecyclerView.MyRecyclerViewWeightLifting
import org.rohan.patel.finalprojectandroid.databinding.FragmentViewLogsBinding
import org.rohan.patel.finalprojectandroid.viewModels.ViewLogsViewModel
import org.rohan.patel.finalprojectandroid.viewModelsFactory.ViewLogViewModelFactory
import org.rohan.patel.roomdatabasesample.FitDatabase

class ViewLogsFragment : Fragment() {
    private lateinit var database : FitDatabase
    private var weightLiftingList = listOf<WeightLiftingEntity>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var binding: FragmentViewLogsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_view_logs,container,false)

        //Database
        val application = requireNotNull(this.activity).application
        database = FitDatabase.getInstance(application)

        // Binding
        val exerciseList = resources.getStringArray(R.array.exercisesList)
        val adapter = ArrayAdapter(container!!.context,android.R.layout.simple_list_item_1,exerciseList)
        binding.spinner2.adapter = adapter
        binding.recyclerView.adapter = MyRecyclerViewWeightLifting(weightLiftingList)
        getWeightLiftingData()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        //View Model
        val weightLiftingDao = database.weightLiftingDao()
        val runningDao = database.runningDao()
        val swimmingDao = database.swimmingDao()
        val viewModelFactory = ViewLogViewModelFactory(weightLiftingDao,runningDao,swimmingDao,application)
        val viewLogsViewModel = ViewModelProviders.of(this,viewModelFactory).get(ViewLogsViewModel::class.java)
        binding.viewLogsViewModel = viewLogsViewModel

        //Spinner
        binding.spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("POSITION", ""+position)
                if (position == 0){
                    getWeightLiftingData()
                }
                if(position == 1){
                    getRunningData()
                }
                if(position == 2){
                    getSwimmingData()
                }

            }

        }

        return binding.root


    }

    private fun getWeightLiftingData(){
        doAsync {
            val list = database.weightLiftingDao().getAll()
            uiThread {
                recyclerView.adapter = MyRecyclerViewWeightLifting(list)
            }
        }

    }
    private fun getRunningData(){
        doAsync {
            val list = database.runningDao().getAll()
            uiThread {
                recyclerView.adapter = MyRecyclerViewRunning(list)
            }
        }

    }
    private fun getSwimmingData(){
        doAsync {
            val list = database.swimmingDao().getAll()
            uiThread {
                recyclerView.adapter = MyRecyclerViewSwimming(list)
            }
        }

    }

}