package com.example.katherine.postconsumo;

/**
 * Created by katherine on 7/11/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Punto {
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("codigodepto")
    @Expose
    private String codigodepto;
    @SerializedName("codigomunicipio")
    @Expose
    private String codigomunicipio;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("latitud")
    @Expose
    private String latitud;
    @SerializedName("longitud")
    @Expose
    private String longitud;
    @SerializedName("municipio")
    @Expose
    private String municipio;
    @SerializedName("noid")
    @Expose
    private String noid;
    @SerializedName("subcategoria")
    @Expose
    private String subcategoria;
    @SerializedName("vocero")
    @Expose
    private String vocero;
    @SerializedName("email")
    @Expose
    private String email;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigodepto() {
        return codigodepto;
    }

    public void setCodigodepto(String codigodepto) {
        this.codigodepto = codigodepto;
    }

    public String getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(String codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNoid() {
        return noid;
    }

    public void setNoid(String noid) {
        this.noid = noid;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getVocero() {
        return vocero;
    }

    public void setVocero(String vocero) {
        this.vocero = vocero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
