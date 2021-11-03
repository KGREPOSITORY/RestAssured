package enums;

public enum Endpoint {
    BREEDS("breeds"),
    BREED_BY_NAME("breeds/search?q={name}"),
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
