package enums;

public enum Endpoint {
    BREEDS("breeds"),
    VOTE("votes"),
    CATEGORIES("categories");


    private String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
