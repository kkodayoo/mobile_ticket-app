package com.example.rafli_jpop.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rafli_jpop.MainActivity
import com.example.rafli_jpop.R
import com.example.rafli_jpop.databinding.ActivityThirdBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "{Third Activity} dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnKirim.setOnClickListener{
            val noTujuan = binding.inputNoTujuan.text
            /*tambahkan bagian berikut*/
            intent.putExtra("nomor", "$noTujuan")
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah nomor {$noTujuan} benar")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                    Log.e("Info Dialog","Alert Dialog Ditutup")
                    val intent = Intent(this, ThirdResultActivity::class.java)
                    intent.putExtra("nomor", "$noTujuan")
                    startActivity(intent)
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                    Log.e("Info Dialog","Alert Dialog Ditutup")
                    Snackbar.make(binding.root, "Silahkan masukkan kembali nomor yang sesuai", Snackbar.LENGTH_LONG)
                        .setAction("Tutup"){
                            Log.e("Info Snackbar","Snackbar ditutup")
                        }
                        .show()
                    Log.e("Info Snackbar","Snackbar dibuka")
                }
                .show()

            Log.e("Info Dialog","Alert Dialog Berhasil Dibuka!")

        }

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: {Third Activity} terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "{Third Activity} dihapus dari stack")
    }
}