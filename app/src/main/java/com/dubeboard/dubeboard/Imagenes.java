package com.dubeboard.dubeboard;

/**
 * Created by PC on 07/02/2016.
 */
public class Imagenes {
    // private variables
    int _id;
    String _name;
    int _category;
    byte[] _image;

    // Empty constructor
    public Imagenes() {

    }

    // constructor
    public Imagenes(int keyId, String name, int category, byte[] image) {
        this._id = keyId;
        this._name = name;
        this._category = category;
        this._image = image;
    }

    // constructor
    public Imagenes(String name, byte[] image) {
        this._name = name;
        this._image = image;
    }

    public Imagenes(int keyId) {
        this._id = keyId;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int keyId) {
        this._id = keyId;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

    // getting Category
    public int getCategory() {
        return this._category;
    }

    // setting Category
    public void setCategory(int category) {
        this._category = category;
    }

    // getting phone number
    public byte[] getImage() {
        return this._image;
    }

    // setting phone number
    public void setImage(byte[] image) {
        this._image = image;
    }
}

