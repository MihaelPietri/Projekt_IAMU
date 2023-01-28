package mihael.pietri.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mihael.pietri.nasa.adapter.ItemPagerAdapter
import mihael.pietri.nasa.databinding.ActivityItemPagerBinding
import mihael.pietri.nasa.framework.fetchItems
import mihael.pietri.nasa.model.Item

const val POSITION ="mihael.pietri.nasa.position"
class ItemPagerActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityItemPagerBinding
    private lateinit var  items:MutableList<Item>
    private var itemPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityItemPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPager()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initPager() {
        items = fetchItems()
        itemPosition = intent.getIntExtra(POSITION,itemPosition)
        binding.viewPager.adapter=ItemPagerAdapter(this,items)
        binding.viewPager.currentItem = itemPosition
    }
}