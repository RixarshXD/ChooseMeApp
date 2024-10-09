package com.example.rikiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_cuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void registrarCuenta (View v) {
        //recuperar las views
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellido = findViewById(R.id.etApellido);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etContrasenia = findViewById(R.id.etContrasenia);
        EditText etNumeroTelefonico = findViewById(R.id.etNumeroTelefonico);
        EditText etCuentanosSobreTi = findViewById(R.id.etCuentanosSobreTi);
        EditText etQueTeAtrajoaSerVoluntario = findViewById(R.id.etQueTeAtrajoaSerVoluntario);
        EditText etTienesExperienciaComoVoluntario = findViewById(R.id.etTienesExperienciaComoVoluntario);

        //recuperar los valores de los campos
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String email = etEmail.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        String numeroTelefonico = etNumeroTelefonico.getText().toString();
        String cuentanosSobreTi = etCuentanosSobreTi.getText().toString();
        String queTeAtrajoaSerVoluntario = etQueTeAtrajoaSerVoluntario.getText().toString();
        String tienesExperienciaComoVoluntario = etTienesExperienciaComoVoluntario.getText().toString();

        //validar que los campos no esten vacios
        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasenia.isEmpty() || numeroTelefonico.isEmpty() ||
                cuentanosSobreTi.isEmpty() || queTeAtrajoaSerVoluntario.isEmpty() || tienesExperienciaComoVoluntario.isEmpty()) {
            //mostrar mensaje de error
            Toast toast = Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT);
        } else {
            // pasar los datos a perfil
            Intent i = new Intent(this, Perfil.class);
            i.putExtra("nombre", nombre);
            i.putExtra("apellido", apellido);
            i.putExtra("email", email);
            startActivity(i);
        }
    }
}