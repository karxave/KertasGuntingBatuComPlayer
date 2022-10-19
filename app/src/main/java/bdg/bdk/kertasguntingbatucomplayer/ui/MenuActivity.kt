package bdg.bdk.kertasguntingbatucomplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

import bdg.bdk.kertasguntingbatucomplayer.databinding.ActivityMenuBinding
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMenuBinding

//    private var playerName: String = intent.getStringExtra("databaru").toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root

        var playerName: String = intent.getStringExtra("databaru").toString()

        setContentView(view)


        binding.tvNameVsPlayerMenuActivity.text = "$playerName vs Pemain"
        binding.tvComVsPlayerMenuActivity.text = "$playerName vs CPU"

        val parent = binding.clMenuActivity

        val snackbar = Snackbar.make(
            parent, "Selamat Datang $playerName ",
            Snackbar.LENGTH_INDEFINITE
        )

        snackbar.setAction("Tutup") {
            snackbar.dismiss()
        }

        snackbar.show()

        letsPlay()


    }

    private fun letsPlay() {
        val playVsPemain = binding.ivNameVsPlayerMenuActivity
        val playVsCpu = binding.ivComVsPlayerMenuActivity
        var playerName: String = intent.getStringExtra("databaru").toString()

        playVsPemain.setOnClickListener {
            val intent = Intent(this@MenuActivity, PlayerVsPemainActivity::class.java)
            intent.putExtra("databaru", playerName)
            startActivity(intent)

        }


        playVsCpu.setOnClickListener {
            var playerName: String = intent.getStringExtra("databaru").toString()
            val intent = Intent(this@MenuActivity, PlayerVsCpuActivity::class.java)
            intent.putExtra("databaru", playerName)
            startActivity(intent)

        }

    }


}