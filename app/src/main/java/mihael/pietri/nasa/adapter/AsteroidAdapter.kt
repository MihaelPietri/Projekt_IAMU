package mihael.pietri.nasa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mihael.pietri.nasa.R
import mihael.pietri.nasa.model.Asteroid

class AsteroidAdapter(private var asteroidList:ArrayList<Asteroid>) :RecyclerView.Adapter<AsteroidAdapter.AsteroidViewHolder>() {
   inner class AsteroidViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)
    {
        val textDescription:TextView=itemView.findViewById(R.id.textDescription)
        val imageView : ImageView =itemView.findViewById(R.id.imageView)
        val textView : TextView =itemView.findViewById(R.id.textView)
        val linearLayout: LinearLayout=itemView.findViewById(R.id.DesctriptionLayout)
        fun collapseExpandedView(){
            textDescription.visibility=View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.each_asteroid,parent,false)
        return  AsteroidViewHolder(view)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        val asteroid = asteroidList[position]
        holder.imageView.setImageResource(asteroid.logo)
        holder.textView.text=asteroid.title
        holder.textDescription.text=asteroid.explanation

        val isExpandable: Boolean =asteroid.isExpandable
        holder.textDescription.visibility=if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener{
            isAnyItemExpanded(position)
            asteroid.isExpandable =!asteroid.isExpandable
            notifyItemChanged(position,Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = asteroidList.indexOfFirst { it.isExpandable }
        if (temp >=0 && temp !=position){
            asteroidList[temp].isExpandable =false
            notifyItemChanged(temp,0)
        }
    }

    override fun getItemCount(): Int {
        return asteroidList.size
    }

    override fun onBindViewHolder(
        holder: AsteroidViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()&&payloads[0]==0)
        {
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }
}