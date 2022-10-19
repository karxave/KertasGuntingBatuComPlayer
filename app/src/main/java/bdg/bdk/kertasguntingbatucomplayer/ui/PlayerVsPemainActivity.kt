package bdg.bdk.kertasguntingbatucomplayer.ui

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.core.view.isVisible
import bdg.bdk.kertasguntingbatucomplayer.R

import bdg.bdk.kertasguntingbatucomplayer.databinding.ActivityPlayerVsPemainBinding
import kotlin.random.Random

private lateinit var binding: ActivityPlayerVsPemainBinding


class PlayerVsPemainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerVsPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namePlayer = intent.getStringExtra("databaru").toString()

        binding.tvTextPlayerLeft.text = namePlayer

        player2ClickDisable()

        player1Choose()

    }

    private fun player2ClickDisable() {
        binding.ivPlayer2Rock.isClickable = false
        binding.ivPlayer2Paper.isClickable = false
        binding.ivPlayer2Scissor.isClickable = false
    }

    private fun player2ClickEnabled() {
        binding.ivPlayer2Rock.isClickable = true
        binding.ivPlayer2Paper.isClickable = true
        binding.ivPlayer2Scissor.isClickable = true
    }

    private fun player1Choose() {

        binding.ivPlayer1Rock.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 1 Click BATU")

            player2ClickEnabled()

            binding.ivPlayer1Rock.isClickable = false

            playerChoice = 1

            showPicRockPlayer1()

            player2Choose()


        }

        binding.ivPlayer1Paper.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 1 Click KERTAS")

            player2ClickEnabled()

            binding.ivPlayer1Paper.isClickable = false

            playerChoice = 2

            showPicPaperPlayer1()

            player2Choose()


        }

        binding.ivPlayer1Scissor.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 1 Click GUNTING")

            player2ClickEnabled()

            binding.ivPlayer1Scissor.isClickable = false


            playerChoice = 3

            showPicScissorPlayer1()

            player2Choose()


        }

        binding.ivClose.setOnClickListener {

            goToMenuActivity()

        }

        binding.ivRefresh.setOnClickListener {

            Log.d(TAG, "initButton: Pemain 1 Click REFRESH->RESTART")

            setRestart()

        }
    }

    private fun player2Choose() {

        binding.ivPlayer2Rock.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 2 Click BATU")

            binding.ivPlayer1Rock.isClickable = false

            computerChoice = 1

            showPicRockPlayer2()

            computerRandom()


        }

        binding.ivPlayer2Paper.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 2 Click KERTAS")

            binding.ivPlayer1Paper.isClickable = false

            computerChoice = 2

            showPicPaperPlayer2()

            computerRandom()


        }

        binding.ivPlayer2Scissor.setOnClickListener {
            Log.d(TAG, "initButton: Pemain 2 Click GUNTING")

            binding.ivPlayer2Scissor.isClickable = false


            computerChoice = 3

            showPicScissorPlayer2()

            computerRandom()


        }

        binding.ivClose.setOnClickListener {

            goToMenuActivity()

        }

        binding.ivRefresh.setOnClickListener {

            Log.d(TAG, "initButton: Pemain 1 Click REFRESH->RESTART")

            setRestart()

        }
    }


    private fun setRestart() {
        timer = 1
        playerChoice = 0
        computerChoice = 0

        setTextVs()

        reSetPlayer1Paper()

        reSetPlayer1Rock()

        reSetPlayer1Scissor()

        reSetPlayerCom()

    }

    private fun reSetPlayerCom() {
        binding.ivPlayer2Rock.isVisible = true
        binding.ivPlayer2Paper.isVisible = true
        binding.ivPlayer2Scissor.isVisible = true
        binding.ivPlayer2Rock.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        binding.ivPlayer2Paper.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        binding.ivPlayer2Scissor.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
    }

    private fun reSetPlayer1Scissor() {
        binding.ivPlayer1Scissor.isVisible = true
        binding.ivPlayer1Scissor.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        binding.ivPlayer1Scissor.isClickable = true

    }

    private fun reSetPlayer1Rock() {
        binding.ivPlayer1Rock.isVisible = true
        binding.ivPlayer1Rock.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        binding.ivPlayer1Rock.isClickable = true
    }

    private fun reSetPlayer1Paper() {
        binding.ivPlayer1Paper.isVisible = true
        binding.ivPlayer1Paper.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        binding.ivPlayer1Paper.isClickable = true
    }


    private fun setTextVs() {
        binding.tvResult.text = getString(R.string.textVS)
        binding.tvResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50F)
        binding.tvResult.setTextColor(Color.parseColor("#FA0202"))
        binding.tvResult.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
    }

    private fun computerRandom() {


        when (computerChoice) {
            1 -> {
                showPicRockPlayer2()
                comparePlayerVsCom()
            }
            2 -> {
                showPicPaperPlayer2()
                comparePlayerVsCom()
            }
            3 -> {
                showPicScissorPlayer2()
                comparePlayerVsCom()

            }
            else -> Toast.makeText(this, "Timer = 0", Toast.LENGTH_LONG)
                .show()
        }


    }

    private fun comparePlayerVsCom() {
        if ((playerChoice == 3) && (computerChoice == 3)) {

            runDialogDraw()

        } else if ((playerChoice == 2) && (computerChoice == 2)) {

            runDialogDraw()


        } else if ((playerChoice == 1) && (computerChoice == 1)) {

            runDialogDraw()

        }
        //         GUNTING VS KERTAS : GUNTING WIN
        else if ((playerChoice == 3) && (computerChoice == 2)) {

            runDialog()

        }
//        GUNTING VS BATU : BATU WIN

        else if ((playerChoice == 3) && (computerChoice == 1)) {


            runDialogPlayer2Win()

        }
//        BATU VS GUNTING
        else if ((playerChoice == 1) && (computerChoice == 3)) {

            runDialog()

        }
//        BATU VS KERTAS : KERTAS MENANG
        else if ((playerChoice == 1) && (computerChoice == 2)) {

            runDialogPlayer2Win()


        }
//        KERTAS VS GUNTING : GUNTING WIN
        else if ((playerChoice == 2) && (computerChoice == 3)) {

            runDialogPlayer2Win()

        }
//        KERTAS VS BATU : kertas WIN
        else if ((playerChoice == 2) && (computerChoice == 1)) {


            runDialog()

        } else {
//            Log.d("OUTPUT", "PLAYER CHOICE : ${playerChoice} + COM = $computerChoice")
            Toast.makeText(
                this,
                "wow PLAYER CHOICE : $playerChoice + COM = $computerChoice",
                Toast.LENGTH_LONG
            )
                .show()

        }
    }


    private fun runDialogPlayer2Win() {

        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setTitle("Hasil Permainan")
            setMessage(" Pemain 2 MENANG !")
            setPositiveButton(
                "Main Lagi"
            ) { dialog, id ->

                setRestart()
            }
            setNegativeButton(
                "Kembali Ke Menu"
            ) { dialog, id ->

                goToMenuActivity()

            }

        }.create().show()
    }


    private fun runDialogDraw() {


        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setTitle("Hasil Permainan")
            setMessage(" SERI ")
            setPositiveButton(
                "Main Lagi"
            ) { dialog, id ->

                setRestart()
            }
            setNegativeButton(
                "Kembali Ke Menu"
            ) { dialog, id ->

                goToMenuActivity()

            }

        }.create().show()
    }


    private fun runDialog() {

        val namePlayer = intent.getStringExtra("databaru").toString()

        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setTitle("Hasil Permainan")
            setMessage(" $namePlayer MENANG !")
            setPositiveButton(
                "Main Lagi"
            ) { dialog, id ->

                setRestart()
            }
            setNegativeButton(
                "Kembali Ke Menu"
            ) { dialog, id ->

                goToMenuActivity()

            }

        }.create().show()
    }

    private fun goToMenuActivity() {

        val namePlayer = intent.getStringExtra("databaru").toString()

        var intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("databaru", namePlayer)
        startActivity(intent)
    }


    private fun showPicScissorPlayer2() {
        binding.ivPlayer2Rock.isVisible = false
        binding.ivPlayer2Paper.isVisible = false
        binding.ivPlayer2Scissor.setBackgroundColor(Color.parseColor("#c3dae9"))
    }

    private fun showPicPaperPlayer2() {
        binding.ivPlayer2Rock.isVisible = false
        binding.ivPlayer2Scissor.isVisible = false
        binding.ivPlayer2Paper.setBackgroundColor(Color.parseColor("#c3dae9"))
    }

    private fun showPicRockPlayer2() {
        binding.ivPlayer2Paper.isVisible = false
        binding.ivPlayer2Scissor.isVisible = false
        binding.ivPlayer2Rock.setBackgroundColor(Color.parseColor("#c3dae9"))
    }

    private fun showPicRockPlayer1() {
        binding.ivPlayer1Scissor.isVisible = false
        binding.ivPlayer1Paper.isVisible = false
        binding.ivPlayer1Rock.setBackgroundColor(Color.parseColor("#c3dae9"))

    }

    private fun showPicPaperPlayer1() {
        binding.ivPlayer1Scissor.isVisible = false
        binding.ivPlayer1Rock.isVisible = false
        binding.ivPlayer1Paper.setBackgroundColor(Color.parseColor("#c3dae9"))
    }

    private fun showPicScissorPlayer1() {
        binding.ivPlayer1Paper.isVisible = false
        binding.ivPlayer1Rock.isVisible = false
        binding.ivPlayer1Scissor.setBackgroundColor(Color.parseColor("#c3dae9"))
    }

    //    FULL SCREEN SHOW
    private fun hideSystemUI(mainActivity: PlayerVsCpuActivity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            mainActivity.window.insetsController?.let {
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                it.hide(WindowInsets.Type.systemBars())
            }
        } else {
            @Suppress("DEPRECATION")
            mainActivity.window?.apply {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }

    }

    companion object {
        private val TAG = PlayerVsCpuActivity::class.java.simpleName


    }
}
