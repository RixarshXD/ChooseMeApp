package com.example.rikiapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        //referencia al toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tl = (TabLayout) findViewById(R.id.tabLayaout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int posicion = tab.getPosition();

                switch (posicion){
                    case 0:
                        //se llama al primer tab seleccionado
                        Inicio i = new Inicio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, i).commit();
                        break;
                    case 1:
                        //se llama al segundo tab seleccionado
                        Nuevo n = new Nuevo();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, n).commit();
                        break;

                    case 2:
                        //se llama al tercero tab seleccionado
                        Informacion in = new Informacion();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, in).commit();
                        break;
                    case 3:
                        //se llama al cuarto tab seleccionado
                        Perfil p = new Perfil();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, p).commit();
                        break;
                }

                //incorporar el menu lateral
                NavigationView nav = (NavigationView) findViewById(R.id.nav);
                nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //recuperar opciones del menu lateral
                        int id = item.getItemId(); // recupera el id del item seleccionado
                        if (id == R.id.opInicio){
                            Toast.makeText(getApplicationContext(), "se va a la inicio", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.opPerfil){
                            Toast.makeText(getApplicationContext(), "se va a la perfil", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.opPuestos){
                            Toast.makeText(getApplicationContext(), "se va a la puestos", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.opOrganizaciones) {
                            Toast.makeText(getApplicationContext(), "se va a la organizaciones", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.opInsignias){
                            Toast.makeText(getApplicationContext(), "se va a la insignias", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.opConfiguracion){
                            Toast.makeText(getApplicationContext(), "se va a la configuracion", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });


        DrawerLayout dl = (DrawerLayout) findViewById(R.id.Principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else {
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //se incorpora el menu dentro del activity
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    public void perfil(MenuItem item) {
        Toast.makeText(this, "Perfil seleccionado", Toast.LENGTH_SHORT).show();
    }
    public void insigniasCertificaciones(MenuItem item) {
        Toast.makeText(this, "Insignias y certificaciones seleccionado", Toast.LENGTH_SHORT).show();
    }
}

