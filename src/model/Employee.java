package model;

public class Employee {
    private long id;
    private String name;
    private String posisi;

    public Employee(long id, String name, String posisi) {
        this.id = id;
        this.name = name;
        this.posisi = posisi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

}
