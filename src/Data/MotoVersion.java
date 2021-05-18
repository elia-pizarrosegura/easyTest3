package Data;

public class MotoVersion {

    public String Marca;
    public String Cilindrada;
    public String Modelo;
    public String Version;
    public String Anyo;

    public MotoVersion(String marca, String cilindrada, String modelo, String version, String anyo) {
        Marca = marca;
        Cilindrada = cilindrada;
        Modelo = modelo;
        Version = version;
        Anyo = anyo;
    }

    public MotoVersion() {
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        Cilindrada = cilindrada;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getAnyo() {
        return Anyo;
    }

    public void setAnyo(String anyo) {
        Anyo = anyo;
    }
}
