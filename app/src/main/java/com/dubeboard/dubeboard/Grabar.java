package com.dubeboard.dubeboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 03/02/2016.
 */
public class Grabar extends Activity {

    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME ="temporal.jpg";
    private final int PHOTO_CODE = 100;
    String[] datos = {"PRONOMBRES","FAMILIA","COSAS","VERBOS","COCINA",
        "COMIDA", "POSTRES","PARTES DEL CUERPO","HOGAR","TRANSPORTE" +
            "PRENDAS DE VESTIR","ESCUELA","LUGARES"};
    EditText nom_imag;
    String valtxt;
    Button agimagen;
    private ImageView ImageView;
    private EditText txtNombre;
    //final AlertDialog.Builder builder2;

    private Spinner spinner;
    ArrayList<Imagenes> imageArry = new ArrayList<Imagenes>();
    ContactImageAdapter imageAdapter;
    private static final int CAMERA_REQUEST = 1;
    private static final int PICK_FROM_GALLERY = 2;
    GridView dataList;
    String imageName;
    int imageCategory;
    byte[] imageFile;
    int imageId;
    Bitmap theImage;
    DataBaseHandler db;
    String[] noms;
    int[] imagn;
   // AdaptadorDeImagenes adaptador;
    byte imageInByte[];
    Bitmap yourImage;
    ByteArrayInputStream imageStream;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grabar);

        dataList = (GridView) findViewById(R.id.list_base_datos);
        ImageView = (ImageView) findViewById(R.id.imView_imagen);
        txtNombre = (EditText) findViewById(R.id.edtxt_nom_imagen);
        agimagen = (Button) findViewById(R.id.btn_agimagen);
        nom_imag = (EditText) findViewById(R.id.edtxt_nom_imagen);

        //------------------DECLARAMOS LA BASE DE DATOS------------------------
        db = new DataBaseHandler(this);
        /*
        * Lectura y conseguir todos los registros de la base de datos
        */

        //---------------LEER LOS CONTACTOS DE LA BASE DE DATOS-----------------
        final List<Imagenes> imagenes = db.getAllContacts();
        for(Imagenes im : imagenes){
            String log = "ID:" + im.getID() + "Nombre: " + im.getName()
                    + " ,Imagen:" + im.getImage();

            Log.d("Resultado: ",log);
            imageArry.add(im);
        }

        /**
         * PONER LA IMAGEN EN EL LISTVIEW
         */

        //---------------------CUADRO DE DIALOGO ELIMINAR/SELECIONAR--------------------------
        final String[] opcionimagen = new String[]{"Seleccionar", "Eliminar"};
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,opcionimagen);
        final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Seleccionar Opcion");

        imageAdapter = new ContactImageAdapter(this, R.layout.screen_list,
                imageArry);
        dataList.setAdapter(imageAdapter);

        dataList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,final int position, long id) {

            builder2.setAdapter(adapter2, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("Item Seleccionado",String.valueOf(which));
                    if(which == 0){


                        imageFile = imageArry.get(position).getImage();
                        imageName = imageArry.get(position).getName();
                        imageId = imageArry.get(position).getID();



                        Log.d("Antes enviar:****", imageName + "-" + imageId);

                        //CONVERTIR BYTE A BITMAP
                        imageStream = new ByteArrayInputStream(imageFile);
                        theImage = BitmapFactory.decodeStream(imageStream);
                        ImageView.setImageBitmap(theImage);

                        //Poner el nombre de la imagen en el Edit Text
                        txtNombre.setText(imageName);
/*
                        Intent intent = new Intent(Grabar.this, Fragmentuno.class);
                        intent.putExtra("imagename",theImage);
                        intent.putExtra("imageid",imageId); // pass your values and retrieve them in the other Activity using "imageid"
                        startActivity(intent);*/

                    }
                    if(which == 1){

                            imageFile = imageArry.get(position).getImage();
                            imageId = imageArry.get(position).getID();

                            Log.d("Antes enviar:****", imageName + "-" + imageId);

                            //CONVERTIR BYTE A BITMAP
                            imageStream = new ByteArrayInputStream(imageFile);
                            theImage = BitmapFactory.decodeStream(imageStream);
                            Intent intent = new Intent(Grabar.this,
                                    DisplayImageActivity.class);
                            intent.putExtra("imagename", theImage);
                            intent.putExtra("imageid", imageId);
                            startActivity(intent);
                    }
                }
            });
                final AlertDialog dialog2 = builder2.create();
                dialog2.show();
        };
        });

        //CUADRO DE DIALOGO PARA CAMARA/GALERIA
        final String[] option = new String[]{"Tomar de camara",
                "Seleccionar de galeria"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,option);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Seleccionar Opcion");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("Item Seleccionado",String.valueOf(which));
                if(which == 0){
                    callCamera();
                }
                if(which == 1){
                    callGallery();
                }
            }
        });

        final AlertDialog dialog = builder.create();

        //----------------ONCLICKLISTENER BOTON AGREGAR IMAGEN-------------------
        agimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        //------------------------------SPINNER----------------------------------
        spinner = (Spinner) findViewById(R.id.spin_menu);
        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        //----------------------------BOTON GRABAR-------------------------------
        Button btn_grabar = (Button) findViewById(R.id.btn_grabimagen);
        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorspinner = (String)spinner.getSelectedItem();
                txtNombre = (EditText) findViewById(R.id.edtxt_nom_imagen);
                String imageNameToUpdate = txtNombre.getText() + "";
                if (valorspinner == "PRONOMBRES") {
                    db.updateCategory(1, imageNameToUpdate);
                }
                Toast.makeText(getBaseContext(), "Actualizada categoria de " + imageNameToUpdate, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK)
            return;

        switch (requestCode){
            case PHOTO_CODE:
                Bundle extras = data.getExtras();
                if(extras != null){

                     //guardamos en un string la Direccion en donde esta guardada
                    //nuestra nueva foto
                    String dir = Environment.getExternalStorageDirectory()+ File.separator
                            + MEDIA_DIRECTORY + File.separator + TEMPORAL_PICTURE_NAME;
                    //Decodificamos la imagen para mostrarla en el image view
                    decodeBitmap(dir);
                }
                break;

            case PICK_FROM_GALLERY:
                Bundle extra2 = data.getExtras();

                if(extra2 != null){
                    valtxt = nom_imag.getText().toString();
                    yourImage = extra2.getParcelable("data");
                    // convert bitmap to byte
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();
                    Log.e("Sal despues de la conv", imageInByte.toString());
                    // Inserting Contacts
                    Log.d("Insert: ", "Inserting ..");
                    db.addContact(new Imagenes(valtxt, imageInByte));
                    Intent i = new Intent(Grabar.this,Grabar.class);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }

    //--------------------------FUNCION ABRIR CAMARA-----------------------------
    public void callCamera(){
        //(Direccion donde se guardara la foto, nombre de foto)
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        //lo va almacenar en una memoria externa
        file.mkdir();//Crea el file
        //path.- direccion donde esta la foto, la ruta
        String path = Environment.getExternalStorageDirectory() + file.separator
                + MEDIA_DIRECTORY + file.separator + TEMPORAL_PICTURE_NAME;

        File newfile = new File(path);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//Abrir camara
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newfile));
        startActivityForResult(intent, PHOTO_CODE); //Para comenzar la aplicacion camara
        //PHOTOCODE es solo un identificador tipo INT
    }

    //--------------------------FUNCION ABRIR GALERIA-----------------------------

    public void callGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"),
                PICK_FROM_GALLERY);
    }

    //-------------------DECODIFICACION A MAPA DE BITS------------------------
    private void decodeBitmap(String dir){
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeFile(dir);
        //Pone la imagen en la pantalla
        ImageView.setImageBitmap(bitmap);

    }
}
