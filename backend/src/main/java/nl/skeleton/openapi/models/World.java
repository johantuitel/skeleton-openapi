package nl.skeleton.openapi.models;

public class World {
    private String message;

    public World(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
