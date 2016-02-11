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
 * {@link Fragment_animales.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_animales extends Fragment {

    private OnFragmentInteractionListener mListener;
    AdaptadorDeImagenes adapter;
    Activity activity;
    Comunicador comunicador;

    private MediaPlayer mp;

    String[] titulo = new String[]{
            "PERRO",
            "GATO",
            "LEON",
            "TORTUGA",
            "CABALLO",
            "LORO",
            "CAMELLO",
            "VACA",
            "RATON",
            "CONEJO",
            "ELEFANTE",
            "PATO",
            "GALLO",
            "CANGURO",
            "OVEJA",
            "LLAMA",
            "TIGRE",
            "OSO",
            "OSO POLAR",
            "LOBO",
            "JAGUAR",
            "PANTERA"
    };

    int[] imagenes = {
            R.drawable.perro,
            R.drawable.gato,
            R.drawable.leon,
            R.drawable.tortuga,
            R.drawable.caballo,
            R.drawable.loro,
            R.drawable.camello,
            R.drawable.vaca,
            R.drawable.raton,
            R.drawable.conejo,
            R.drawable.elefante,
            R.drawable.pato,
            R.drawable.gallo,
            R.drawable.canguro,
            R.drawable.oveja,
            R.drawable.llama,
            R.drawable.tigre,
            R.drawable.oso,
            R.drawable.oso_polar,
            R.drawable.lobo,
            R.drawable.jaguar,
            R.drawable.pantera
    };

    public Fragment_animales() {
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
        View view=inflater.inflate(R.layout.fragment_fragment_animales, container, false);
        //Declaramos el Gridview
        final GridView listGridanimales = (GridView)view.findViewById(R.id.listagridanimales);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listGridanimales.setAdapter(adapter);
        listGridanimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("perro");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("gato");
                }else if(pos == 2){
                    comunicador.enviar("león");
                }else if(pos == 3){
                    comunicador.enviar("tortuga");
                }else if(pos == 4){
                    comunicador.enviar("caballo");
                }else if(pos == 5){
                    comunicador.enviar("loro");
                }else if(pos == 6){
                    comunicador.enviar("camello");
                }else if(pos == 7){
                    comunicador.enviar("vaca");
                }else if(pos == 8){
                    comunicador.enviar("ratón");
                }else if(pos == 9){
                    comunicador.enviar("conejo");
                }else if(pos == 10){
                    comunicador.enviar("elefante");
                }else if(pos == 11){
                    comunicador.enviar("pato");
                }else if(pos == 12){
                    comunicador.enviar("gallo");
                }else if(pos == 13){
                    comunicador.enviar("canguro");
                }else if(pos == 14){
                    comunicador.enviar("oveja");
                }else if(pos == 15){
                    comunicador.enviar("llama");
                }else if(pos == 16){
                    comunicador.enviar("tigre");
                }else if(pos == 17){
                    comunicador.enviar("oso");
                }else if(pos == 18){
                    comunicador.enviar("oso polar");
                }else if(pos == 19){
                    comunicador.enviar("lobo");
                }else if(pos == 20){
                    comunicador.enviar("jaguar");
                }else if(pos == 21){
                    comunicador.enviar("pantera");
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
