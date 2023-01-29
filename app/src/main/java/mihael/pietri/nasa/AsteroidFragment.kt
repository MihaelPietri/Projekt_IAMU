package mihael.pietri.nasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mihael.pietri.nasa.adapter.AsteroidAdapter
import mihael.pietri.nasa.databinding.FragmentAsteroidBinding
import mihael.pietri.nasa.databinding.FragmentItemsBinding
import mihael.pietri.nasa.model.Asteroid


class AsteroidFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var asteroidList = ArrayList<Asteroid>()
    private lateinit var adapter: AsteroidAdapter
    private lateinit var binding: FragmentAsteroidBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAsteroidBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {

        binding.recyclerView.findViewById<RecyclerView>(R.id.recyclerView)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),1)
        addDataTolist()
        adapter=AsteroidAdapter(asteroidList)
        binding.recyclerView.adapter=adapter

    }

    private fun addDataTolist(){
        asteroidList.add(Asteroid("Bennu","Asteroids, sometimes called minor planets, are rocky, airless remnants left over from the early formation of our solar system about 4.6 billion years ago.",R.drawable.bennu))
        asteroidList.add(Asteroid("Chariklo","Asteroids, sometimes called minor planets, are rocky, airless remnants left over from the early formation of our solar system about 4.6 billion years ago.",R.drawable.chariklo))
        asteroidList.add(Asteroid("2019 OK","Asteroids, sometimes called minor planets, are rocky, airless remnants left over from the early formation of our solar system about 4.6 billion years ago.",R.drawable.ok))
        asteroidList.add(Asteroid("243 IDA","Asteroids, sometimes called minor planets, are rocky, airless remnants left over from the early formation of our solar system about 4.6 billion years ago.",R.drawable.idadactyle))
    }



}






