public class NetworkService {
    private NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {
        String connectionResult = networkClient.connect();
        return "Connected to " + connectionResult;
    }
}
