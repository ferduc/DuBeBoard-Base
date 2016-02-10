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
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmentuno.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragmentuno extends Fragment {
    AdaptadorDeImagenes adapter;
    Activity activity;
    Comunicador comunicador;

    private MediaPlayer mp;

    private OnFragmentInteractionListener mListener;

    String[] titulo = new String[]{
            "YO",
            "EL",
            "ELLA",
            "ELLOS",
            "NOSOTROS"
    };

    int[] imagenes = {
            R.drawable.yo,
            R.drawable.el,
            R.drawable.ella,
            R.drawable.ellos,
            R.drawable.nosotros
    };

    public Fragmentuno() {
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
        View view = inflater.inflate(R.layout.fragment_fragmentuno, container, false);
        //Declaramos el Gridview
        final GridView listgrid1 = (GridView)view.findViewById(R.id.listagrid1);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgrid1.setAdapter(adapter);
        listgrid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                if (pos == 0) {
                    comunicador.enviar("yo");
                    mp = MediaPlayer.create(getContext(),R.raw.pedro);
                    mp.start();
                }else if(pos == 1){
                    comunicador.enviar("el");
                }else if(pos == 2){
                    comunicador.enviar("ella");
                }else if(pos == 3){
                    comunicador.enviar("ellos");
                }else if(pos == 4){
                    comunicador.enviar("nosotros");
                }

            }
        });
        return view;
    }



    // TODO: Rename method, update argument and hook method into UI event]
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    //Fijar las callback para interactuar con el Activity durante onAttach():
    @Override
    public void onAttach(Context context) {
        //INICIAMOS el Comunicador y le asignamos el contexto
        comunicador = (Comunicador) context;
        super.onAttach(context);
        // Nos aseguramos de que la actividad contenedora haya implementado la
        // interfaz de retrollamada. Si no, lanzamos una excepción

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
