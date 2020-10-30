package com.example.proyectofinal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.Products;
import com.example.proyectofinal.R;
import com.example.proyectofinal.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Products> products;
    RecyclerView rv;

    private void initializeData() {
        products = new ArrayList<>();
        //(String pname, String description, String price, int image+)
        products.add(new Products("Laptop HP Notebook 240 G7" ,"Conéctate con este económico equipo portátil HP 240 que ofrece la tecnología más reciente y un chasis duradero que ayuda a protegerlo. Complete tareas profesionales con un procesador Intel Core i5-8265U y herramientas de colaboración esenciales.", "S/.20,999.000",R.drawable.producto01));
        products.add(new Products("Tablet Huawei MediaPad T5" ,"El Huawei MediaPad T5 es un tablet Android con una pantalla Full HD de 10.1 pulgadas, procesador Kirin 659 3GB de RAM y 32GB de almacenamiento, cámaras de 5 MP y 2 MP, parlantes stereo, GPS y batería de 5100 mAh.", "S/.5,499.000", R.drawable.producto02));
        products.add(new Products("Impresora Multifuncional Brother" ,"La DCP-T310 InkBenefit Tank de Brother viene equipada con las funciones que usted necesita para obtener resultados excepcionales. Imprima y ahorre dinero con las botellas de tinta de ultra alto rendimiento (6.500 páginas en negro y 5.000 páginas a color aprox.).", "S/.3,799.000", R.drawable.producto03));
        products.add(new Products("Televisión Samsung UN50TU7000FXZX" ,"Expresión de colores nítidos y vivos. Crystal Display. Sumérgete en la imagen con una gama de colores mucho más amplia. Crystal Display garantiza una expresión del color optimizada mejorando la nitidez para que no te pierdas ni un detalle. Potente calidad de imagen Procesador Crystal 4K. Impresionante calidad de imagen, gracias a un chip que optimiza el color y el alto rango dinámico (HDR).", "S/.10,999.000", R.drawable.producto04));


    }
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
      /*  final TextView textView = root.findViewById(R.id.text_home);
       homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        rv = (RecyclerView) root.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);

        initializeData();

        RVAdapter rvAdapter = new RVAdapter(products, getContext());


        rvAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hola ", Toast.LENGTH_LONG);
            }
        });


        rv.setAdapter(rvAdapter);

        return root;
    }
}