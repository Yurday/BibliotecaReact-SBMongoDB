package com.example.biblioteca.DTOs;

import java.util.Objects;

public class ResourceAreaThemeDTO {

    private String id;
    private String name;

    public ResourceAreaThemeDTO(){
    }

    public ResourceAreaThemeDTO(String name) {
        this.name = name;
    }

    public ResourceAreaThemeDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getter

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //Setter

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceAreaThemeDTO that = (ResourceAreaThemeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
