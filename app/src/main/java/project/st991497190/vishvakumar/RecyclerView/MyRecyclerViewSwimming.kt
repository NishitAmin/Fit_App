package project.st991497190.vishvakumar.RecyclerView
// Rohan Patel - 991496523
import kotlinx.android.synthetic.main.list_view.view.*
//import org.rohan.patel.finalprojectandroid.R


// Rohan Patel - 991496523
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import project.st991497190.vishvakumar.Entity.SwimmingEntity
import project.st991497190.vishvakumar.R

class MyRecyclerViewSwimming(private var sampleList:List<SwimmingEntity>): RecyclerView.Adapter<MyRecyclerViewWeightLifting.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewWeightLifting.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false);
        itemView.setOnClickListener{
            Toast.makeText(itemView.logDate.context,"You have selected ",Toast.LENGTH_SHORT).show()
        }
        return MyRecyclerViewWeightLifting.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewWeightLifting.MyViewHolder, position: Int) {
        val currentItem = sampleList[position]
        holder.date.text = currentItem.date
        holder.textView1.text = ""+currentItem.reps
        holder.textView2.text = ""+currentItem.sets
        holder.textView3.text = ""+currentItem.weight+" kg"


    }

    override fun getItemCount() = sampleList.size
}