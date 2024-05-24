package br.com.fiap.irrigationapi.model;

public enum UserRole {
    ADMIN( "admin"),
    USER ("user");

    private final String _role;
    public String getRole() { return _role; }

    UserRole (String role) {
        this._role = role;
    }

}
