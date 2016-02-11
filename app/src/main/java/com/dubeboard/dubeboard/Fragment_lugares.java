package com.dubeboard.dubeboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_lugares.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_lugares extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "BOSQUE",
            "PLAYA",
            "CINE",
            "TIENDA",
            "PARQUE",
            "ZOOLOGICO",
            "PARQUE DE DIVERSIONES",
            "SUPERMERCADO",
            "PANADERIA",
            "RESTAURANTE",
            "FARMACIA",
            "HOSPITAL"
    };

    int[] imagenes = {
            R.drawable.bosque,
            R.drawable.playa,
            R.drawable.cine,
            R.drawable.tienda,
            R.drawable.parque,
            R.drawable.zoo,
            R.drawable.pardediversiones,
            R.drawable.supermercado,
            R.drawable.panaderia,
            R.drawable.restaurant,
            R.drawable.farmacia,
            R.drawable.hospital
    };


    public Fragment_lugares() {
        // Required empty public constructor
    }
    //COMUNICADOR enviar informacion a Activity
    public interface Comunicador{
        public void enviar (String envia);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_lugares, container, false);
        final GridView listgridlugares = (GridView)view.findViewById(R.id.listagrid_lugares);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridlugares.setAdapter(adapter);
        listgridlugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("bosque");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("playa");
                }else if(pos == 2){
                    comunicador.enviar("cine");
                }else if(pos == 3){
                    comunicador.enviar("tienda");
                }else if(pos == 4){
                    comunicador.enviar("parque");
                }else if(pos == 5){
                    comunicador.enviar("zoológico");
                }else if(pos == 6){
                    comunicador.enviar("parque de diversiones");
                }else if(pos == 7){
                    comunicador.enviar("supermercado");
                }else if(pos == 8){
                    comunicador.enviar("panadería");
                }else if(pos == 9){
                    comunicador.enviar("restaurante");
                }else if(pos == 10){
                    comunicador.enviar("farmacia");
                }else if(pos == 11){
                    comunicador.enviar("hospital");
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        //INICIAMOS el Comunicador y le asignamos el contexto
        comunicador = (Comunicador) context;
        // Nos aseguramos de que la actividad contenedora haya implementado la
        // interfaz de retrollamada. Si no, lanzamos una excepción
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
