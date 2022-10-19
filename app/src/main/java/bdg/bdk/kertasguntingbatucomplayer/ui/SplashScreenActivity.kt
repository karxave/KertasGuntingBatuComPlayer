package bdg.bdk.kertasguntingbatucomplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import bdg.bdk.kertasguntingbatucomplayer.R
import bdg.bdk.kertasguntingbatucomplayer.databinding.ActivitySplashScreenBinding
import com.bumptech.glide.Glide
import java.util.concurrent.CountDownLatch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setTimer()
        Glide.with(this)

            .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_baseline_wifi_off_24)
            .into(binding.ivSplashScreenInternet)

    }


    override fun onDestroy() {
        super.onDestroy()
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }

    private fun setTimer() {
        timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, LandingPageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer?.start()

    }
}