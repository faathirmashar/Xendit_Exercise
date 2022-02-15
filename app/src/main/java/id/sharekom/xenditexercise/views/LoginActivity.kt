package id.sharekom.xenditexercise.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.sharekom.xenditexercise.R
import id.sharekom.xenditexercise.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_login) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}