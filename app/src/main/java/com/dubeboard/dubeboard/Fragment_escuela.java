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
 * {@link Fragment_escuela.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_escuela extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "ESCUELA",
            "REGLA",
            "TAREA",
            "PINTURAS",
            "PAPEL",
            "BORRADOR",
            "LIBROS",
            "LAPIZ",
            "CUADERNO",
            "PIZARRON",
            "TIJERAS",
            "MOCHILA"
    };

    int[] imagenes = {
            R.drawable.escuela,
            R.drawable.regla,
            R.drawable.tarea,
            R.drawable.pinturas,
            R.drawable.papel,
            R.drawable.borrador,
            R.drawable.libros,
            R.drawable.lapiz,
            R.drawable.cuaderno,
            R.drawable.pizarron,
            R.drawable.tijeras,
            R.drawable.mochila
    };

    public Fragment_escuela() {
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
        View view = inflater.inflate(R.layout.fragment_fragment_escuela, container, false);
        final GridView listgridescuela = (GridView)view.findViewById(R.id.listagridescuela);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridescuela.setAdapter(adapter);
        listgridescuela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("escuela");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("regla");
                }else if(pos == 2){
                    comunicador.enviar("tarea");
                }else if(pos == 3){
                    comunicador.enviar("pinturas");
                }else if(pos == 4){
                    comunicador.enviar("papel");
                }else if(pos == 5){
                    comunicador.enviar("borrador");
                }else if(pos == 6){
                    comunicador.enviar("libros");
                }else if(pos == 7){
                    comunicador.enviar("lapiz");
                }else if(pos == 8){
                    comunicador.enviar("cuaderno");
                }else if(pos == 9){
                    comunicador.enviar("pizarron");
                }else if(pos == 10){
                    comunicador.enviar("tijeras");
                }else if(pos == 11){
                    comunicador.enviar("mochila");
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
