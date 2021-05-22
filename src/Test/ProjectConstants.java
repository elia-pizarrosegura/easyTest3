package Test;

public final class ProjectConstants {

    public enum PRODUCT {
        SEGURO_COCHE("Coche", "AU01"),
        SEGURO_MOTO("Moto", "AU02"),
        SEGURO_HOGAR("Hogar", "HG01"),
        SEGURO_MASCOTA("Mascota", null),
        SEGURO_CUENTAKM("CuentaKms", null);
        private final String name;
        private final String serviceName;

        PRODUCT(String name, String serviceName) {
            this.name = name;
            this.serviceName = serviceName;
        }

        public String getName() {
            return name;
        }

        public String getServiceName() {
            return serviceName;
        }
    }

    public static final String CLIENT = "Verti";
}
