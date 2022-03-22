package com.felipe.bhaskaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText valor1, valor2, valor3;
    public TextView saidadelta,saidadelta2,saidadelta3, saida2;
    Button esvaziar, resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText)findViewById(R.id.a);
        valor2 = (EditText)findViewById(R.id.b);
        valor3 = (EditText)findViewById(R.id.c);

        saidadelta = (TextView) findViewById(R.id.resultado);
        saidadelta2 = (TextView) findViewById(R.id.resultado2);
        saidadelta3 = (TextView) findViewById(R.id.resultado3);
        saida2 = (TextView)findViewById(R.id.saida);
        Button resposta = (Button)findViewById(R.id.calcular);
        Button esvaziar = (Button)findViewById(R.id.limpar);
        resposta.setOnClickListener(new View.OnClickListener(){
            @Override



            public void onClick(View v) {

                    int a = Integer.parseInt(valor1.getText().toString());
                    int b = Integer.parseInt(valor2.getText().toString());
                    int c = Integer.parseInt(valor3.getText().toString());



                if (a==0) {

                    Toast.makeText(getApplicationContext(), "Valor de A não pode ser 0", Toast.LENGTH_SHORT).show();
                } else {
                    int calculo = ((b * b) - (4 * a * c));
                    int raizdelta = calculo;
                    raizdelta = (int) Math.sqrt(calculo);

                    String delta = "Delta = " + "(" + (b * b) + ")" + "- 4 x " + "(" + a + ")" + " x " + "(" + c + ")";

                    saidadelta.setText(delta + "\n" + "Delta = " + "(" + (b * b) + ") " + (-(4 * a)) + " x " + "(" + (c * 1) + ") " + " = " + Integer.toString(calculo) + "\n"
                            + "\n" + "Raiz do Delta = " + raizdelta);

                    if (calculo < 0) {

                        deltanegativo();

                    } else if (calculo == 0) {
                        saida2.setText("Uma raiz");
                        delta1();

                    } else if (calculo > 0) {
                        saida2.setText("Duas raízes");
                        delta1();
                        delta2();

                    }

                }
            }
        });



        esvaziar.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {

                saidadelta.setText("Delta");
                saidadelta2.setText("X'");
                saidadelta3.setText("X''");
                valor1.setText("");
                valor2.setText("");
                valor3.setText("");
                saida2.setText("Malloc");
            }
        });



    }

    public void deltanegativo (){

        int a = Integer.parseInt(valor1.getText().toString());
        int b = Integer.parseInt(valor2.getText().toString());
        int c = Integer.parseInt(valor3.getText().toString());

        int calculo = ((b * b) - (4 * a * c));


        String delta = "Delta = " + "("+(b * b) +")"+ "- 4 x " + "("+a+ ")"+ " x " + "("+c+")";

        saidadelta.setText(delta + "\n" + "Delta = "+"("+(b*b)+") "+(-(4*a))+" x "+"("+(c*1)+") " +" = " + Integer.toString(calculo));
        saida2.setText("Delta Negativo");

    }


    public void delta1 (){

        int a = Integer.parseInt(valor1.getText().toString());
        int b = Integer.parseInt(valor2.getText().toString());
        int c = Integer.parseInt(valor3.getText().toString());


        //calculo do delta
        int calculo = ((b * b) - (4 * a * c));
        int raizdelta= (int) Math.sqrt(calculo);
        String delta = "Delta = " + "("+(b * b) +")"+ "- 4 x " + "("+a+ ")"+ " x " + "("+c+")";


        saidadelta.setText(delta + "\n" + "Delta = "+"("+(b*b)+") "+(-(4*a))+" x "+"("+(c*1)+") " +"= " + Integer.toString(calculo)+"\n"
                +"\n"+"Raiz do Delta = "+ raizdelta);



        int calcn1;
        int numerador1;
        int calcde1;
        int denominador1;

        calcn1 = (-b -((int) Math.sqrt((Math.pow(b, 2) - (4*a*c)  ))));
        numerador1 = calcn1;

        calcde1 = (2*a);
        denominador1 = calcde1;
        // ------------------------------------------ Primeiro bloco de calculo

        int calcn1_repetido;
        int numerador1_repetido;
        int calcde1_repetido;
        int denominador1_repetido;


        calcn1_repetido =  (-b -((int) Math.sqrt((Math.pow(b, 2) - (4*a*c)  ))));
        numerador1_repetido = calcn1_repetido;
        calcde1_repetido = (2*a);
        denominador1_repetido = calcde1_repetido;


        int mdc = 0;
        int resto;

        while (denominador1 !=0) {
            resto = numerador1 % denominador1;
            numerador1 = denominador1;
            denominador1 = resto;

        }
        System.out.println("O MDC é = "+ numerador1); //teste da saida do MDC entre 2 números

        mdc = numerador1;

        System.out.println("A variável mdc recebe " +mdc);

        if (mdc < 0) {
            mdc = mdc *(-1);
            System.out.println("Multiplicação de -1 para mdc = "+mdc);
        } else {

            mdc = mdc *1;
        }

        // condição abaixo caso o denominador seja igual a 1.
        if ((denominador1_repetido ==1) || (denominador1_repetido== -1)){
            numerador1_repetido = numerador1_repetido / denominador1_repetido;

            saidadelta2.setText(-b +"-"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+"x' = "+Integer.toString(numerador1_repetido));

        } else {

            numerador1_repetido = numerador1_repetido / mdc;
            denominador1_repetido = denominador1_repetido / mdc;

            saidadelta2.setText(-b +"-"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+
                    "x' = " +Integer.toString(numerador1_repetido)+"/"+(denominador1_repetido));


        }

        if ((denominador1_repetido ==1) || (denominador1_repetido== -1)){
            numerador1_repetido = numerador1_repetido / denominador1_repetido;
            saidadelta2.setText(-b +"-"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+"x' = "+Integer.toString(numerador1_repetido));
        }
    }




    public void delta2() {

        int a = Integer.parseInt(valor1.getText().toString());
        int b = Integer.parseInt(valor2.getText().toString());
        int c = Integer.parseInt(valor3.getText().toString());


        //calculo do delta
        int calculo = ((b * b) - (4 * a * c));
        int raizdelta= (int) Math.sqrt(calculo);
        String delta = "Delta = " + "("+(b * b) +")"+ "- 4 x " + "("+a+ ")"+ " x " + "("+c+")";

        saidadelta.setText(delta + "\n" + "Delta = "+"("+(b*b)+") "+(-(4*a))+" x "+"("+(c*1)+") " +"= " + Integer.toString(calculo)+"\n"
                +"\n"+"Raiz do Delta = "+ raizdelta);


        int calcn1;
        int numerador1;
        int calcde1;
        int denominador1;

        calcn1 = (-b +((int) Math.sqrt((Math.pow(b, 2) - (4*a*c)  ))));
        numerador1 = calcn1;

        calcde1 = (2*a);
        denominador1 = calcde1;
        // ------------------------------------------ Primeiro bloco de calculo

        int calcn1_repetido;
        int numerador1_repetido;
        int calcde1_repetido;
        int denominador1_repetido;


        calcn1_repetido =  (-b +((int) Math.sqrt((Math.pow(b, 2) - (4*a*c)  ))));
        numerador1_repetido = calcn1_repetido;
        calcde1_repetido = (2*a);
        denominador1_repetido = calcde1_repetido;

        System.out.println("resultado do primeiro numerador = "+numerador1); // testes
        System.out.println("resultado do primeiro denominador = "+denominador1); // testes

        int mdc = 0;
        int resto;

        while (denominador1 !=0) {
            resto = numerador1 % denominador1;
            numerador1 = denominador1;
            denominador1 = resto;

        }
        System.out.println("O MDC é = "+ numerador1); //teste da saida do MDC entre 2 números

        mdc = numerador1;

        System.out.println("A variável mdc recebe " +mdc);

        if (mdc < 0) {
            mdc = mdc *(-1);
            System.out.println("Multiplicação de -1 para mdc = "+mdc);
        } else {

            mdc = mdc *1;
        }

        // condição abaixo caso o denominador seja igual a 1.
        if ((denominador1_repetido ==1) || (denominador1_repetido== -1)){
            numerador1_repetido = numerador1_repetido / denominador1_repetido;

            saidadelta3.setText(-b +"+"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+"x'' = "+Integer.toString(numerador1_repetido));

        } else { // condição para dividir o numerador e denominador pelo mdc

            numerador1_repetido = numerador1_repetido / mdc;
            denominador1_repetido = denominador1_repetido / mdc;

            saidadelta3.setText(-b +"+"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+
                    "x'' = " +Integer.toString(numerador1_repetido)+"/"+(denominador1_repetido));


        }

        // condição repetida para o caso de outro numero 1 ou -1 aparecer

        if ((denominador1_repetido ==1) || (denominador1_repetido== -1)){
            numerador1_repetido = numerador1_repetido / denominador1_repetido;
            saidadelta3.setText(-b +"+"+(int) Math.sqrt(calculo)+"\n"+"-------"+"\n"+calcde1+"\n"+"\n"+"x'' = "+Integer.toString(numerador1_repetido));
        }


    }


}