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
 * {@link Fragment_prendas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_prendas extends Fragment {

    private OnFragmentInteractionListener mListener;
    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "VESTIDO",
            "CAMISA",
            "CAMISETA",
            "SUERTER",
            "CASACA",
            "BUFANDA",
            "PANTALONES",
            "ZAPATOS",
            "ZAPATO DEPORTIVO",
            "MEDIAS",
            "PIJAMA",
            "CALZONES",
            "PAÑUELO",
            "TOALLA",
    };

    int[] imagenes = {
            R.drawable.vestido,
            R.drawable.camisa,
            R.drawable.camiseta,
            R.drawable.sueter,
            R.drawable.casaca,
            R.drawable.bufanda,
            R.drawable.pantalones,
            R.drawable.zapatos,
            R.drawable.zapato_depor,
            R.drawable.medias,
            R.drawable.pijama,
            R.drawable.calzones,
            R.drawable.panuelo,
            R.drawable.toalla,
    };

    public Fragment_prendas() {
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
        View view = inflater.inflate(R.layout.fragment_fragment_prendas, container, false);
        final GridView listgridprendas = (GridView)view.findViewById(R.id.listagridprendas);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridprendas.setAdapter(adapter);
        listgridprendas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("vestido");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("camisa");
                }else if(pos == 2){
                    comunicador.enviar("camiseta");
                }else if(pos == 3){
                    comunicador.enviar("sueter");
                }else if(pos == 4){
                    comunicador.enviar("casaca");
                }else if(pos == 5){
                    comunicador.enviar("bufanda");
                }else if(pos == 6){
                    comunicador.enviar("pantalones");
                }else if(pos == 7){
                    comunicador.enviar("zapatos");
                }else if(pos == 8){
                    comunicador.enviar("zapatos deportivos");
                }else if(pos == 9){
                    comunicador.enviar("medias");
                }else if(pos == 10){
                    comunicador.enviar("pijama");
                }else if(pos == 11){
                    comunicador.enviar("calzones");
                }else if(pos == 12){
                    comunicador.enviar("pañuelo");
                }else if(pos == 13){
                    comunicador.enviar("toalla");
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
