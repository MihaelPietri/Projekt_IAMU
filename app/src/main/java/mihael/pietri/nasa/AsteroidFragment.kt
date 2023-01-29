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
        asteroidList.add(Asteroid("101955 Bennu","Bennu—discovered in 1999—is a small asteroid that passes close to Earth about every six years. Bennu is slightly wider than New York City's Empire State Building is tall.",R.drawable.bennu))
        asteroidList.add(Asteroid("10199 Chariklo","10199 Chariklo was found on Feb. 15, 1997 by the Spacewatch team at the University of Arizona's Lunar and Planetary Laboratory.",R.drawable.chariklo))
        asteroidList.add(Asteroid("2019 OK","Near-Earth asteroid 2019 OK is a football-field-sized asteroid that safely passed close to Earth on July 24, 2019, with very little warning.",R.drawable.ok))
        asteroidList.add(Asteroid("243 IDA","243 Ida is the second asteroid visited by a spacecraft and the first found to have its own moon.",R.drawable.idadactyle))
        asteroidList.add(Asteroid("25143 Itokawa","25143 Itokawa was discovered Sept. 26, 1998 by the Lincoln Laboratory Near-Earth Asteroid Research Team at Socorro, New Mexico.",R.drawable.itokawa))
        asteroidList.add(Asteroid(" 253Mathilde","Nineteenth-century Austrian astronomer Johann Palisa, who found more than 100 asteroids during his career, discovered 253 Mathilde on November 12, 1885. V. A. Lebeuf, another Austrian astronomer, first calculated its orbit.",R.drawable.matilde))
        asteroidList.add(Asteroid("433 Eros","433 Eros was discovered on Aug. 13, 1898, by Gustav Witt, director of the Urania Observatory in Berlin, and independently on the same day by Auguste H.P. Charlois at Nice, France.",R.drawable.eros))
        asteroidList.add(Asteroid("4 Vesta","4 Vesta’s discoverer, Heinrich Wilhelm Olbers, gave the honor of naming the new asteroid to German mathematician Carl Friedrich Gauss, who had computed its orbit. Gauss named it Vesta after the goddess of the hearth and household in Roman mythology.",R.drawable.vesta))
        asteroidList.add(Asteroid("Apophis","Asteroid 99942 Apophis is a near-Earth object (NEO) estimated to be about 1,100 feet (340 meters) across. When it was discovered in 2004, Apophis was identified as one of the most hazardous asteroids that could impact Earth. But that impact assessment changed after astronomers tracked Apophis and its orbit became better determined.",R.drawable.apophis2))
        asteroidList.add(Asteroid("Asteroid Psyche","One of the most intriguing targets in the main asteroid belt, Psyche is a giant metal-rich asteroid, about three times farther away from the Sun than is Earth. Its average diameter is about 140 miles (226 kilometers) – about one-sixteenth the diameter of Earth’s Moon or about the distance between Los Angeles and San Diego.",R.drawable.psyche))
        asteroidList.add(Asteroid("Didymos & Dimorphos","Asteroid Didymos and its small moonlet Dimorphos make up what’s called a binary asteroid system – meaning the small moon (Dimorphos) orbits the larger body (Didymos)",R.drawable.dart_imager))
    }



}






