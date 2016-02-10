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
 * {@link Fragment_postres.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_postres extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "POSTRE",
            "CHOCOLATE",
            "GALLETAS",
            "PASTEL",
            "BROWNIE",
            "TARTA",
            "GELATINA",
            "CHICLE",
            "DULCES"
    };

    int[] imagenes = {
            R.drawable.postre,
            R.drawable.chocolate,
            R.drawable.galleta,
            R.drawable.pastel,
            R.drawable.brownie,
            R.drawable.tarta,
            R.drawable.gelatina,
            R.drawable.chicle,
            R.drawable.dulces
    };

    public Fragment_postres() {
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
        View view = inflater.inflate(R.layout.fragment_fragment_postres, container, false);
        final GridView listgridpostres = (GridView)view.findViewById(R.id.listagridpostres);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridpostres.setAdapter(adapter);
        listgridpostres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("postre");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("chocolate");
                }else if(pos == 2){
                    comunicador.enviar("galleta");
                }else if(pos == 3){
                    comunicador.enviar("pastel");
                }else if(pos == 4){
                    comunicador.enviar("brownie");
                }else if(pos == 5){
                    comunicador.enviar("tarta");
                }else if(pos == 6){
                    comunicador.enviar("gelatina");
                }else if(pos == 7){
                    comunicador.enviar("chicles");
                }else if(pos == 8){
                    comunicador.enviar("dulces");
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
