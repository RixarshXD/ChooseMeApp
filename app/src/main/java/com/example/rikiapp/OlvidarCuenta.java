package com.example.rikiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OlvidarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_olvidar_cuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText emailEditText = findViewById(R.id.email);
        Button recuperarButton = findViewById(R.id.btnRecuperar);

        recuperarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(OlvidarCuenta.this, "Por favor ingrese su dirección de correo electrónico", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OlvidarCuenta.this, "Se ha enviado un enlace a su correo electrónico para restablecer la contraseña", Toast.LENGTH_SHORT).show();
                }
                // Aquí se debería enviar un correo con un enlace para restablecer la contraseña
            }
        });
    }
}