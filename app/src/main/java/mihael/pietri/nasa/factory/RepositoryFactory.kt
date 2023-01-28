package mihael.pietri.nasa.factory

import android.content.Context
import mihael.pietri.nasa.dao.NasaSqlHelper

fun getNasaRepository(context: Context?)= NasaSqlHelper(context)
