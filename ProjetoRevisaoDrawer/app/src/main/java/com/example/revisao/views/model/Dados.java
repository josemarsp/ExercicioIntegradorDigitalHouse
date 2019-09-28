package com.example.revisao.views.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dados implements Parcelable {

    private String nomeBanda;

    public Dados(String texto) {
        this.nomeBanda = texto;
    }

    protected Dados(Parcel in) {
        nomeBanda = in.readString();
    }


    public String getNomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nomeBanda) {
        this.nomeBanda = nomeBanda;
    }

    public static final Creator<Dados> CREATOR = new Creator<Dados>() {
        @Override
        public Dados createFromParcel(Parcel in) {
            return new Dados(in);
        }

        @Override
        public Dados[] newArray(int size) {
            return new Dados[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeBanda);
    }
}
