package com.example.blocdenotas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {
    RecyclerView recyclerView;
    MyNotaRecyclerViewAdapter adapterNotas;
    List<Nota> NotasLis;
    OnListFragmentInteractionListener mlistener = null;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            NotasLis = new ArrayList<>();
            NotasLis.add(new Nota("Ir de compras", "comprar pan", 1.00f));
            NotasLis.add(new Nota("Hacer tarea", "Hacer tarea de matematicas", 0.00f));
            NotasLis.add(new Nota("Ir a la iglesia", "ir a la iglesia a las 7", 1.00f));
            NotasLis.add(new Nota("Pasear al perro", "Pasearlo a las 6AM", 1.00f));
            NotasLis.add(new Nota("Llamar a Mama", "saludar a mama", 0.00f));
            NotasLis.add(new Nota("Ir al doctor", "ir al dentista", 1.00f));
            NotasLis.add(new Nota("Leer un libro", "Leer libro de ciencias", 1.00f));

            OnListFragmentInteractionListener mlistener = null;
            adapterNotas = new MyNotaRecyclerViewAdapter(getContext() , NotasLis, mlistener);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Nota item);

    }
}