package es.ieseduardoprimo.rest;

public class APIRestConfig {
/*  IP del servidor, se puede leer de properties
    private static final String server = "localhost";

    Puerto del microservicio
    private static final String port = "4000";

    endpint del microservicio
    private static final String endpoint = "/rest/"; */
    // IP del servicio
    public static final String API_URL = "https://sheetdb.io/api/v1/5tx3h841vv55j";

    private APIRestConfig() {
    }

    // Constructor del servicio con los elementos de la interfaz
    public static AccesoDatosRest getService() {
        System.out.println("API URL: "+API_URL);
        return RetrofitRestClient.getClient(API_URL).create(AccesoDatosRest.class);
    }
}
