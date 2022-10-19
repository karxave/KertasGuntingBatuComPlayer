package bdg.bdk.kertasguntingbatucomplayer.model

import android.os.Parcelable
import android.text.Editable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SliderData(
    val title: String,
    val imgSlider: Int,
    var name: String
) : Parcelable