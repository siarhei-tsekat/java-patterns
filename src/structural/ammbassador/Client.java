package structural.ammbassador;

public class Client {
    private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

    public long useService(int value) {

        long res = serviceAmbassador.doRemoteFunction(value);
        System.out.println("Service result: " + res);
        return res;
    }
}
