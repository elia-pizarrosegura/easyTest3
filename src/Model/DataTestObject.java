package Model;

import java.time.LocalDate;
import java.util.Date;

public class DataTestObject {
    public String producto;
    public boolean matricula;
    public LocalDate fechaMatriculacion;
    public String marca;
    public String cilindrada;
    public String modelo;
    public String version;
    public String anyo;

    public DataTestObject(){
    }

    public DataTestObject(String producto, boolean matricula, LocalDate fechaMatriculacion, String marca, String cilindrada, String modelo, String version, String anyo) {
        this.producto = producto;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.modelo = modelo;
        this.version = version;
        this.anyo= anyo;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public boolean isMatricula() {
        return matricula;
    }

    public void setMatricula(boolean matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }


}
