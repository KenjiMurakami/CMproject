package com.example.practicacomputacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.UnresolvedAddressException;

public class MainActivity extends AppCompatActivity {
    EditText etEdad,etEmail,etNombre,etCelular;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText) findViewById(R.id.txtnombre);
        etCelular = (EditText) findViewById(R.id.txtcelular);
        etEmail = (EditText) findViewById(R.id.txtemail);
        etEdad = (EditText) findViewById(R.id.txtedad);
    }
    public void saludar(View view) {
        String Nombre = etNombre.getText().toString();
        if(validar()){
            if(validaredad() && validarnombre() && validarcelular()){
                if(validarcorreo()){
                Toast.makeText(this,"Hola "+Nombre+" eres un "+val,Toast.LENGTH_LONG).show();
                } else {
                    etEmail.setText("");
                    etEmail.setError("Ingrese un correo válido");
                }
            }
        }

    }
    public boolean validaredad(){
        boolean retorno = true;
        String e = etEdad.getText().toString();

        int edad = Integer.parseInt(e);
        if (edad < 0 || edad>99){
            retorno = false;
            etEdad.setText("");
            etEdad.setError("Los parámetros de edad son de 0 a 99");
        } else {
            if(edad<=2){
                val = "Bebé";
            }
            if(edad>=3 && edad<=12){
                val = "niño";
            }
            if(edad>=13 && edad<=18){
                val = "Adolescente";
            }
            if(edad>=19 &&  edad<=50){
                val="adulto";
            }
            if(edad>50){
                val="Anciano";
            }
        } return retorno;

    }
    public boolean validar(){

        String case1,case2,case3,case4;
        boolean retorno = true;

        case1 = etNombre.getText().toString();
        case2 = etEdad.getText().toString();
        case3 = etCelular.getText().toString();
        case4 = etEmail.getText().toString();

        if (case1.isEmpty()){
            retorno = false;
            etNombre.setError("Debe ingresar un nombre");
        }
        if (case2.isEmpty())
        {
            retorno = false;
            etEdad.setError("Debe ingresar una edad");
        }
        if (case3.isEmpty())
        {
            retorno = false;
            etCelular.setError("Debe ingresar un número de celular");
        }
        if (case4.isEmpty())
        {
            retorno = false;
            etEmail.setError("Debe ingresar un email");
        }

        return retorno;
    }
    public boolean validarnombre(){
        boolean retorno = true;
        String nombre=etNombre.getText().toString();
        if (nombre.length()>50){
            retorno = false;
            etNombre.setError("El nombre no debe pasar de 50 dígitos");
            etNombre.setText("");
        }
        return retorno;
    }
    public boolean validarcelular(){
        boolean retorno = true;
        String celular = etCelular.getText().toString();
        if (celular.length()<8){
            retorno = false;
            etCelular.setError("El celular no debe tener menos de 8 dígitos");
            etCelular.setText("");
        }
        if(celular.length()>8){
            retorno = false;
            etCelular.setError("El celular no debe tener más de 8 dígitos");
            etCelular.setText("");
        }
        return retorno;
    }
    public boolean validarcorreo(){
        String correo = etEmail.getText().toString();
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}