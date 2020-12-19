package br.com.kodigos.mysofie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.kodigos.mysofie.Sofie.SofieList.SofieListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        startActivity(Intent(this, SofieListActivity::class.java))
        finish()


    }
}