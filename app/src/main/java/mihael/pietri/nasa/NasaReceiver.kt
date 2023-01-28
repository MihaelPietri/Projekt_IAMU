package mihael.pietri.nasa

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import mihael.pietri.nasa.framework.setBooleanPreference
import mihael.pietri.nasa.framework.startActivity

class NasaReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.setBooleanPreference(DATA_IMPORTED)
        context.startActivity<HostActivity>()
    }
}