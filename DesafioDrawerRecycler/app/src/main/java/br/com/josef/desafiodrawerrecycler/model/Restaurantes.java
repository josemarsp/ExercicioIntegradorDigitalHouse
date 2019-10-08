package br.com.josef.desafiodrawerrecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurantes implements Parcelable {

    private String nome;
    private String endereço;
    private String horafunc;
    private int image;

    public Restaurantes(String nome, String endereço, String horafunc, int image) {
        this.nome = nome;
        this.endereço = endereço;
        this.horafunc = horafunc;
        this.image = image;
    }

    protected Restaurantes(Parcel in) {
        nome = in.readString();
        endereço = in.readString();
        horafunc = in.readString();
        image = in.readInt();
    }

    public static final Creator<Restaurantes> CREATOR = new Creator<Restaurantes>() {
        @Override
        public Restaurantes createFromParcel(Parcel in) {
            return new Restaurantes(in);
        }

        @Override
        public Restaurantes[] newArray(int size) {
            return new Restaurantes[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getHorafunc() {
        return horafunc;
    }

    public void setHorafunc(String horafunc) {
        this.horafunc = horafunc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereço);
        dest.writeString(horafunc);
        dest.writeInt(image);
    }
}
