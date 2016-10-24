package com.example.usuario.editor_texto;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.graphics.Paint;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,CheckBox.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgTamanos = (RadioGroup)findViewById(R.id.rgTamanos);
        rgTamanos.setOnCheckedChangeListener(this);
        
        CheckBox  chbNegrita = (CheckBox)findViewById(R.id.chbNegrita);
        CheckBox  chbCursiva = (CheckBox)findViewById(R.id.chbCursiva);
        CheckBox  chbSubrayado = (CheckBox)findViewById(R.id.chbSubrayado);
        
        chbNegrita.setOnCheckedChangeListener(this);
        chbCursiva.setOnCheckedChangeListener(this);
        chbSubrayado.setOnCheckedChangeListener(this);

        Switch subrayado = (Switch) findViewById(R.id.swSubrayado);
        subrayado.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        EditText textoMuestra = (EditText)findViewById(R.id.lblTexto);
        switch (checkedId){
            case R.id.rbTam22:
                textoMuestra.setTextSize(22);
                break;
            case R.id.rbTam24:
                textoMuestra.setTextSize(24);
                break;
            case R.id.rbTam26:
                textoMuestra.setTextSize(26);
                break;
            case R.id.rbTam28:
                textoMuestra.setTextSize(28);
                break;
            case R.id.rbTam30:
                textoMuestra.setTextSize(30);
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        /*EditText textoMuestra = (EditText)findViewById(R.id.lblTexto);

        if (buttonView.getId() == R.id.chbNegrita){
            if(isChecked){
                textoMuestra.setTypeface(textoMuestra.getTypeface(), Typeface.BOLD);
            }else{
                textoMuestra.setTypeface(null, Typeface.NORMAL);
            }
        }

        if (buttonView.getId() == R.id.chbCursiva){
            if(isChecked){
                textoMuestra.setTypeface(textoMuestra.getTypeface(), Typeface.ITALIC);
            }else{
                textoMuestra.setTypeface(null, Typeface.NORMAL);
            }
        }

        if (buttonView.getId() == R.id.chbSubrayado){
            if(isChecked){
                textoMuestra.setTypeface(textoMuestra.getTypeface(), Typeface.NORMAL);
            }else{
                textoMuestra.setTypeface(null, Typeface.NORMAL);
            }
        }*/


        EditText txtTexto = (EditText) findViewById(R.id.lblTexto);
        CheckBox chbNegrita = (CheckBox) findViewById(R.id.chbNegrita);
        CheckBox chbCurisva = (CheckBox) findViewById(R.id.chbCursiva);
        CheckBox chbSubrayado = (CheckBox) findViewById(R.id.chbSubrayado);
        Switch swSubrayado = (Switch) findViewById(R.id.swSubrayado);
        if(chbCurisva.isChecked() && chbNegrita.isChecked()){
            txtTexto.setTypeface(txtTexto.getTypeface(), Typeface.BOLD_ITALIC);

        }
        else if(!chbCurisva.isChecked() && chbNegrita.isChecked()){
            txtTexto.setTypeface(null, Typeface.BOLD);
        }
        else if(chbCurisva.isChecked() && !chbNegrita.isChecked()){
            txtTexto.setTypeface(null, Typeface.ITALIC);
        } else if(!chbCurisva.isChecked() && !chbNegrita.isChecked()){
            txtTexto.setTypeface(null, Typeface.NORMAL);
        }

        if(buttonView.getId() == R.id.swSubrayado) {
            txtTexto.setPaintFlags(txtTexto.getPaintFlags() ^ Paint.UNDERLINE_TEXT_FLAG);
        }




    }
}
