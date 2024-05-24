package br.com.fiap.irrigationapi.model;

public class User {

    private Long _id;
    public Long getId() { return _id; }

    private String _name;
    public String getName() { return _name; }
    public void setName(String name) { this._name = name; }

    private String _email;
    public String getEmail() { return _email; }
    public void setEmail(String email) { this._email = email; }

    private String _password;
    public String getPassword() { return _password; }
    public void setPassword(String password) { this._password = password; }

    private UserRole _role;
    public UserRole getRole() { return _role; }
    public void setRole(UserRole role) { this._role = role; }

    public User(Long id, String name, String email, String password, UserRole role) {
        this._id = id;
        this._name = name;
        this._email = email;
        this._password = password;
        this._role = role;
    }

    public User(String name, String email, String password, UserRole role) {
        this._name = name;
        this._email = email;
        this._password = password;
        this._role = role;
    }

}