package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    //Declaro las variables que usaremos para las operaciones y el manejo de los resultados
    String numero="";
    String bandera="";
    Double Resultado=0.0;
    String signo="";
    String GuardarResultado="vacio";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //Para quitar el ActionBar
        getSupportActionBar().hide();
    }
    // OPERACIONES
    public void Sumar(View Vista){
        if (GuardarResultado.equals("vacio")){ //Con esto lo que comprobamos es que no se haya pulsado el boton de "=" y no haya que sumarle nada a lo guardado en esa variable
            bandera=numero;
            numero=" ";
            signo="+"; //A la variable "signo" le damos en este caso el valor "+" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"+"); //Lo que estamos haciendo es añadir al TextView el simbolo mas, precedido del numero al que le vamos a sumar algo, guardandolo en una variable

        }else{ //En caso de que el boton igual ya haya sido pulsado una vez, lo que hacemos es coger ese valor del resultado anterior y darselo a la variable que usamos en caso de que no lo hayan pulsado para proceder a sumarle la nueva cantidad
            bandera=GuardarResultado;
            signo="+"; //A la variable "signo" le damos en este caso el valor "+" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"+"); //Lo que estamos haciendo es añadir al TextView el simbolo mas, precedido del numero al que le vamos a sumar algo, guardandolo en una variable

        }

    }
    public void Restar(View Vista){
        if (GuardarResultado.equals("vacio")){
            bandera=numero;
            numero=" ";
            signo="-"; //A la variable "signo" le damos en este caso el valor "-" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"-"); //Lo que estamos haciendo es añadir al TextView el simbolo menos, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }else{ //En caso de que el boton igual ya haya sido pulsado una vez, lo que hacemos es coger ese valor del resultado anterior y darselo a la variable que usamos en caso de que no lo hayan pulsado para proceder a sumarle la nueva cantidad
            bandera=GuardarResultado;
            signo="-"; //A la variable "signo" le damos en este caso el valor "-" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"-"); //Lo que estamos haciendo es añadir al TextView el simbolo menos, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }

    }
    public void Dividir(View Vista){
        if(GuardarResultado.equals("vacio")){
            bandera=numero;
            numero=" ";
            signo="/"; //A la variable "signo" le damos en este caso el valor "/" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"/"); //Lo que estamos haciendo es añadir al TextView el simbolo dividir, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }else{ //En caso de que el boton igual ya haya sido pulsado una vez, lo que hacemos es coger ese valor del resultado anterior y darselo a la variable que usamos en caso de que no lo hayan pulsado para proceder a sumarle la nueva cantidad
            bandera=GuardarResultado;
            signo="/"; //A la variable "signo" le damos en este caso el valor "/" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"/"); //Lo que estamos haciendo es añadir al TextView el simbolo dividir, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }

    }
    public void Multiplicar(View Vista){
        if(GuardarResultado.equals("vacio")){
            bandera=numero;
            numero=" ";
            signo="*"; //A la variable "signo" le damos en este caso el valor "*" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"*"); //Lo que estamos haciendo es añadir al TextView el simbolo multiplicar, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }else{ //En caso de que el boton igual ya haya sido pulsado una vez, lo que hacemos es coger ese valor del resultado anterior y darselo a la variable que usamos en caso de que no lo hayan pulsado para proceder a sumarle la nueva cantidad
            bandera=GuardarResultado;
            signo="*"; //A la variable "signo" le damos en este caso el valor "*" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
            ActualizarCambiante(Vista); //Llamamos al método para que cambie lo que se va viendo en pantalla mientras pulsamos los botones
            double Bandera = Double.parseDouble(bandera);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"*"); //Lo que estamos haciendo es añadir al TextView el simbolo multiplicar, precedido del numero al que le vamos a sumar algo, guardandolo en una variable
        }

    }
    public void Porcentaje(View Vista){
        bandera=numero;
        signo="%"; //A la variable "signo" le damos en este caso el valor "%" para que a la hora de dar al botón "=" sepa lo que tiene que hacer
        Resultado(Vista);
    }

    public void Seno (View Vista){
        double a;
        double Numero = Double.parseDouble(numero);
        a=Numero;
        //Pasamos el numero a radianes ya que la funcion "Math" los opera de esa manera
        double b = Math.toRadians(a);
        //Utilizamos la funcion "Math.sin()" para sacar el valor del seno
        Math.sin(b);
        String sSeno= String.valueOf(b);
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(sSeno);
    }
    public void Coseno (View Vista){
        double a;
        double Numero = Double.parseDouble(numero);
        a=Numero;
        //Pasamos el numero a radianes ya que la funcion "Math" los opera de esa manera
        double b = Math.toRadians(a);
        //Utilizamos la funcion "Math.cos()" para sacar el valor del seno
        Math.cos(b);
        String sCoseno= String.valueOf(b);
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(sCoseno);
    }
    public void Tangente (View Vista){
        double a;
        double Numero = Double.parseDouble(numero);
        a=Numero;
        //Pasamos el numero a radianes ya que la funcion "Math" los opera de esa manera
        double b = Math.toRadians(a);
        //Utilizamos la funcion "Math.tan()" para sacar el valor del seno
        Math.tan(b);
        String sTangente= String.valueOf(b);
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(sTangente);
    }
    public void Logaritmo (View Vista){
        double a;
        double Numero = Double.parseDouble(numero);
        a=Numero;
        double b = Math.log10(a);
        //Utilizamos la funcion "Math.log()" para sacar el valor del seno
        Math.log10(b);
        String sLog= String.valueOf(b);
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(sLog);
    }
    public void RaizCuadrada (View Vista){
        double a;
        double Numero = Double.parseDouble(numero);
        a=Numero;
        double b = Math.sqrt(a);
        //Utilizamos la funcion "Math.sqrt()" para sacar el valor del seno
        Math.sqrt(b);
        String sRaiz= String.valueOf(b);
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(sRaiz);
    }

    // RESULTADO
    //Método para obtener el resultado de la operacion
    public void Resultado(View Vista){
        double Bandera = Double.parseDouble(bandera);
        double Numero = Double.parseDouble(numero);

        // PARA SUMAR
        if(signo.equals("+")){ //Como he mencionado antes, en funcion del valor dado a la variable signo, hará la operacion deseada
            Resultado= Bandera + Numero; //La operacion se realiza tipo Double para poder sumar
            String sResultado= String.valueOf(Resultado); //Pero aqui lo pasamos a tipo String para que se puedca mostrar en el TextView
            TextView textView = findViewById(R.id.TextoCambiante);
            textView.setText(sResultado);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"+"+Numero+"="+sResultado);
            GuardarResultado=sResultado;
            bandera="";
            numero="";
        }
        // PARA RESTAR
        if(signo.equals("-")){ //Como he mencionado antes, en funcion del valor dado a la variable signo, hará la operacion deseada
            Resultado= Bandera - Numero; //La operacion se realiza tipo Double para poder restar
            String sResultado= String.valueOf(Resultado); //Pero aqui lo pasamos a tipo String para que se puedca mostrar en el TextView
            TextView textView = findViewById(R.id.TextoCambiante);
            textView.setText(sResultado);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"-"+Numero+"="+sResultado);
            GuardarResultado=sResultado;
            bandera="";
            numero="";
        }
        // PARA DIVIDIR
        if(signo.equals("/")){ //Como he mencionado antes, en funcion del valor dado a la variable signo, hará la operacion deseada
            Resultado= Bandera / Numero; //La operacion se realiza tipo Double para poder dividir
            String sResultado= String.valueOf(Resultado); //Pero aqui lo pasamos a tipo String para que se puedca mostrar en el TextView
            TextView textView = findViewById(R.id.TextoCambiante);
            textView.setText(sResultado);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"/"+Numero+"="+sResultado);
            GuardarResultado=sResultado;
            bandera="";
            numero="";
        }
        // PARA MULTIPLICAR
        if(signo.equals("*")){ //Como he mencionado antes, en funcion del valor dado a la variable signo, hará la operacion deseada
            Resultado= Bandera * Numero; //La operacion se realiza tipo Double para poder multiplicar
            String sResultado= String.valueOf(Resultado); //Pero aqui lo pasamos a tipo String para que se puedca mostrar en el TextView
            TextView textView = findViewById(R.id.TextoCambiante);
            textView.setText(sResultado);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+"*"+Numero+"="+sResultado);
            GuardarResultado=sResultado;
            bandera="";
            numero="";
        }
        // PARA PORCENTAJE
        if(signo.equals("%")){ //Como he mencionado antes, en funcion del valor dado a la variable signo, hará la operacion deseada
            Resultado= (Bandera/100); //La operacion se realiza tipo Double para poder ralizar el porcentaje
            String sResultado= String.valueOf(Resultado); //Pero aqui lo pasamos a tipo String para que se puedca mostrar en el TextView
            TextView textView = findViewById(R.id.TextoCambiante);
            textView.setText(sResultado);
            TextView textView2 = findViewById(R.id.MuestraOperacion);
            textView2.setText(Bandera+" en % "+ "es " +sResultado);
            bandera="";
            numero="";
        }


    }

    // NUMEROS
    //Metodos para asignar un valor a un numero en funcion del boton que se pulse
    public void Uno(View Vista){
        numero=numero+"1";
        ActualizarCambiante(Vista);
    }
    public void Dos(View Vista){
        numero=numero+"2";
        ActualizarCambiante(Vista);
    }
    public void Tres(View Vista){
        numero=numero+"3";
        ActualizarCambiante(Vista);
    }
    public void Cuatro(View Vista){
        numero=numero+"4";
        ActualizarCambiante(Vista);
    }
    public void Cinco(View Vista){
        numero=numero+"5";
        ActualizarCambiante(Vista);
    }
    public void Seis(View Vista){
        numero=numero+"6";
        ActualizarCambiante(Vista);
    }
    public void Siete(View Vista){
        numero=numero+"7";
        ActualizarCambiante(Vista);
    }
    public void Ocho(View Vista){
        numero=numero+"8";
        ActualizarCambiante(Vista);
    }
    public void Nueve(View Vista){
        numero=numero+"9";
        ActualizarCambiante(Vista);
    }
    public void Cero(View Vista){
        numero=numero+"0";
        ActualizarCambiante(Vista);

    }
    public void NumeroPi(View Vista){
        String Pi = "3.1415926535";
        numero = Pi;
        ActualizarCambiante(Vista);
    }


    // OTROS METODOS
    public void Resetear(View Vista){ //Metodo para poner la calculadora a 0
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText("0"); //Establecemos la caculadora en 0
        TextView textView2 = findViewById(R.id.MuestraOperacion);
        textView2.setText(""); //Y la muestra de operacion vacia ya que está reseteada
        //Damos un valor vacio a las variables que usamos para que se resetee
        numero="";
        bandera="";
        signo="";
        Resultado=0.0;
        GuardarResultado="vacio";
    }
    public void ActualizarCambiante(View Vista){ //Metodo para que cambie la vista en funcion de lo que va mos pulsando
        //Aqui vamos actualizando la 2º vista en la que se va poniendo lo que vamos pulsando
        TextView textView = findViewById(R.id.TextoCambiante);
        textView.setText(numero);
        TextView textView2 = findViewById(R.id.MuestraOperacion);
        textView2.setText(numero);
    }
    public void BorrarNumero(View Vista){ //Metodo para borrar el ultim,o numero introducido por si nos hemos equivocado
        
        if(numero.length()!=0){ //Si la variable numero tiene una longitud distinta de cero, hará lo siguiente
            numero=(numero.substring(0, numero.length()-1)); //Va a la ultima posicion, es decir, el ultimo caracter, y lo elimina
            ActualizarCambiante(Vista);
        }
    }


}
