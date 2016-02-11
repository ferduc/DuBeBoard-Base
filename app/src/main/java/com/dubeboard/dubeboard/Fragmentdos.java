package com.dubeboard.dubeboard;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
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
 * {@link Fragmentdos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragmentdos extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Activity activity;
    Comunicador comunicador;

    private MediaPlayer mp;

    String[] titulo = new String[]{
            "HIJO",
            "HIJA",
            "PAPÁ",
            "ABUELO",
            "ABUELA",
            "MAESTRO",
            "MAESTRA",
            "FAMILIA",
            "DOCTOR",
            "MAMÁ",
            "HERMANO",
            "HERMANA"
    };

    int[] imagenes = {
            R.drawable.hijo,
            R.drawable.hija,
            R.drawable.papa,
            R.drawable.abuelo,
            R.drawable.abuela,
            R.drawable.profesor,
            R.drawable.profesora,
            R.drawable.familia,
            R.drawable.doctor,
            R.drawable.mam,
            R.drawable.hermano,
            R.drawable.hermana
    };

    public Fragmentdos() {
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
        View view = inflater.inflate(R.layout.fragment_fragmentdos, container, false);
        final GridView listgrid2 = (GridView)view.findViewById(R.id.listagri2);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgrid2.setAdapter(adapter);
        listgrid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("hijo");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("hija");
                }else if(pos == 2){
                    comunicador.enviar("papá");
                }else if(pos == 3){
                    comunicador.enviar("abuelo");
                }else if(pos == 4){
                    comunicador.enviar("abuela");
                }else if(pos == 5){
                    comunicador.enviar("profesor");
                }else if(pos == 6){
                    comunicador.enviar("profesora");
                }else if(pos == 7){
                    comunicador.enviar("familia");
                }else if(pos == 8){
                    comunicador.enviar("doctor");
                }else if(pos == 9){
                    comunicador.enviar("mamá");
                }else if(pos == 10){
                    comunicador.enviar("hermano");
                }else if(pos == 11){
                    comunicador.enviar("hermana");
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
