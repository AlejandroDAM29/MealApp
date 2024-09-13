package alejandro.developer.data.remote.model.exception

import java.io.IOException

data class RemoteException(
    val code: Int, val body: String? = null
): IOException()