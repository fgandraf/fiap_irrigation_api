package br.com.fiap.irrigationapi.model;

public class Area {

    private final Integer _id;
    public Integer getId() { return _id; }

    private final String _description;
    public String getDescription() { return _description; }

    private final String _location;
    public String getLocation() { return _location; }

    private final String _size;
    public String getSize() { return _size; }

    public Area(Integer id, String description, String location, String size) {
        this._id = id;
        this._description = description;
        this._location = location;
        this._size = size;
    }

}
