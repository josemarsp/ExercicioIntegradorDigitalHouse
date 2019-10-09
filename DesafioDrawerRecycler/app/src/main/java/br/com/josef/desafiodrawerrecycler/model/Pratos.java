package br.com.josef.desafiodrawerrecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pratos implements Parcelable {

    private String nomePrato;
    private int imgPrato;
    private String descrPrato;

    public Pratos(String nomePrato, int imgPrato, String descrPrato) {
        this.nomePrato = nomePrato;
        this.imgPrato = imgPrato;
        this.descrPrato = descrPrato;
    }

    protected Pratos(Parcel in) {
        nomePrato = in.readString();
        imgPrato = in.readInt();
        descrPrato= in.readString();
    }

    public static final Creator<Pratos> CREATOR = new Creator<Pratos>() {
        @Override
        public Pratos createFromParcel(Parcel in) {
            return new Pratos(in);
        }

        @Override
        public Pratos[] newArray(int size) {
            return new Pratos[size];
        }
    };

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public int getImgPrato() {
        return imgPrato;
    }

    public String getDescrPrato() {
        return descrPrato;
    }

    public void setDescrPrato(String descrPrato) {
        this.descrPrato = descrPrato;
    }

    public void setImgPrato(int imgPrato) {
        this.imgPrato = imgPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomePrato);
        dest.writeInt(imgPrato);
        dest.writeString(descrPrato);
    }
}
