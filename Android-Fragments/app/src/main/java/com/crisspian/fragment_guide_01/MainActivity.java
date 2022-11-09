package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.method.BaseKeyListener;
import android.view.View;
import android.widget.Toast;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private boolean isFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
                if(isFragmentShow){
                    CloseQuestionFragment();
                }else {
                openFragment();
            }}
        });




        mBinding.opensecondfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpendSecondFragment("Mario","Canedo");
            }
        });
    }




        private void openFragment(){
        // primer paso es instanciar el fragmento
            BlankFragment blankFragment = new BlankFragment();
        // segundo paso es tener la instancia del fragmento
            FragmentManager manager = getSupportFragmentManager();
            // tercer paso es crear la transaccion
            FragmentTransaction transaction = manager.beginTransaction()
                    .replace(mBinding.Contenedor.getId(), blankFragment,
                            BlankFragment.class.getSimpleName());
            // carga la pila del fragmento.. añade el fragmento a la pila puedo referenciarla si vuelo atras
            // no se cierra aplicacion
                    //.addToBackStack(null);
            // activar la transaccion
            transaction.commit();
            mBinding.button.setText("Abrir");
            isFragmentShow = true;
        }

    private void CloseQuestionFragment() {
        //Generar Instancia del FragmentManager
        FragmentManager manager = getSupportFragmentManager();
        //Instanciar la instancia si existe en el contenedor

        BlankFragment blankFragment = (BlankFragment) manager.findFragmentById(mBinding.Contenedor.getId());


        if (blankFragment != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(blankFragment).commit();
            mBinding.button.setText("Cerrar");
            isFragmentShow = false;}
        }






// este metodo abre el segundo fragmento pasado parametros y utilizando factory nethods
    private void OpendSecondFragment(String name, String lastName) {

        // primer paso instanciar fragmento
        SecondFragment secondFragment = SecondFragment.newInstance(name, lastName);
        // segundo paso es tener una instancia del fragment manager
        FragmentManager manager = getSupportFragmentManager();

        // tecer paso es crear la transaccion el add monta el fragmento el replace reemplaza
        //FragmentTransaction transaction = manager.beginTransaction()
        //        .replace(mBinding.Contenedor.getId(), secondFragment,
        //               SecondFragment.class.getSimpleName());
        //.addToBackStack(null);
        // Activar La transaccion.


        //---------------------------------------------------------


// verificamos si el contendor no esta ocupado

        if (secondFragment != null) {
            FragmentTransaction transaction = manager.beginTransaction()
                            .replace(mBinding.Contenedor.getId(),secondFragment,
                    SecondFragment.class.getSimpleName());

            mBinding.button.setText("Cerrar");
            isFragmentShow = false;
            transaction.commit();
        }
    }}


















