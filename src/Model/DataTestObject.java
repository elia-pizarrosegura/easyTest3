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
    public String momentoCompra;
    public String leHago;
    public String duerme;
    public String usoHabitual;
    public String situacionPersonal;
    public String situacionProfesional;
    public String sexo;
    public String carne;
    public boolean seguroAnterior;
    public Boolean otroConductor;
    public LocalDate fechaInicio;
    public LocalDate fechaCarne;
    public int edadConductor;

    public DataTestObject(){
    }

    public DataTestObject(String producto, boolean matricula, LocalDate fechaMatriculacion,
                          String marca, String cilindrada, String modelo, String version,
                          String anyo, String momentoCompra, String leHago, String duerme,
                          String usoHabitual, String situacionPersonal, String situacionProfesional,
                          String sexo, String carne, boolean seguroAnterior, Boolean otroConductor,
                          LocalDate fechaInicio, LocalDate fechaCarne, int edadConductor) {
        this.producto = producto;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.modelo = modelo;
        this.version = version;
        this.anyo = anyo;
        this.momentoCompra = momentoCompra;
        this.leHago = leHago;
        this.duerme = duerme;
        this.usoHabitual = usoHabitual;
        this.situacionPersonal = situacionPersonal;
        this.situacionProfesional = situacionProfesional;
        this.sexo = sexo;
        this.carne = carne;
        this.seguroAnterior = seguroAnterior;
        this.otroConductor = otroConductor;
        this.fechaInicio = fechaInicio;
        this.fechaCarne = fechaCarne;
        this.edadConductor = edadConductor;
    }

    public String getMomentoCompra() {
        return momentoCompra;
    }

    public void setMomentoCompra(String momentoCompra) {
        this.momentoCompra = momentoCompra;
    }

    public String getLeHago() {
        return leHago;
    }

    public void setLeHago(String leHago) {
        this.leHago = leHago;
    }

    public String getDuerme() {
        return duerme;
    }

    public void setDuerme(String duerme) {
        this.duerme = duerme;
    }

    public String getUsoHabitual() {
        return usoHabitual;
    }

    public void setUsoHabitual(String usoHabitual) {
        this.usoHabitual = usoHabitual;
    }

    public String getSituacionPersonal() {
        return situacionPersonal;
    }

    public void setSituacionPersonal(String situacionPersonal) {
        this.situacionPersonal = situacionPersonal;
    }

    public String getSituacionProfesional() {
        return situacionProfesional;
    }

    public void setSituacionProfesional(String situacionProfesional) {
        this.situacionProfesional = situacionProfesional;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public boolean isSeguroAnterior() {
        return seguroAnterior;
    }

    public void setSeguroAnterior(boolean seguroAnterior) {
        this.seguroAnterior = seguroAnterior;
    }

    public Boolean getOtroConductor() {
        return otroConductor;
    }

    public void setOtroConductor(Boolean otroConductor) {
        this.otroConductor = otroConductor;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCarne() {
        return fechaCarne;
    }

    public void setFechaCarne(LocalDate fechaCarne) {
        this.fechaCarne = fechaCarne;
    }

    public int getEdadConductor() {
        return edadConductor;
    }

    public void setEdadConductor(int edadConductor) {
        this.edadConductor = edadConductor;
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
