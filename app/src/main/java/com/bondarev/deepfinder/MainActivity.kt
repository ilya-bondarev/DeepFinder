package com.bondarev.deepfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authLauncher.launch(arrayListOf(VKScope.WALL))
        setContentView(R.layout.activity_main)
    }
    private val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
        when (result) {
            is VKAuthenticationResult.Success -> Toast.makeText(this, "Авторизация прошла успешно", Toast.LENGTH_LONG).show()
            is VKAuthenticationResult.Failed -> Toast.makeText(this, "Ошибка авторизации", Toast.LENGTH_LONG).show()
        }
    }
}