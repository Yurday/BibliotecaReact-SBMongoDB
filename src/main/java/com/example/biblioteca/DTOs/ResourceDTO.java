package com.example.biblioteca.DTOs;

import java.time.LocalDate;
import java.util.Objects;

public class ResourceDTO {

    private String id;
    private String areaThemeId;
    private String resourceType;
    private boolean status;
    private String name;
    private String date;

    //Builder


    public ResourceDTO() {
    }

    public ResourceDTO(String id, String areaThemeId, String resourceType, boolean status, String name, String date) {
        this.id = id;
        this.areaThemeId = areaThemeId;
        this.resourceType = resourceType;
        this.status = status;
        this.name = name;
        this.date = date;
    }

    public ResourceDTO(String areaThemeId, String resourceType, boolean status, String name, String date) {
        this.areaThemeId = areaThemeId;
        this.resourceType = resourceType;
        this.status = status;
        this.name = name;
        this.date = date;
    }

    //Getter

    public String getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getAreaThemeId() {
        return areaThemeId;
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    //Setter

    public void setId(String id) {
        this.id = id;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setAreaThemeId(String areaThemeId) {
        this.areaThemeId = areaThemeId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceDTO that = (ResourceDTO) o;
        return status == that.status &&
                Objects.equals(id, that.id) &&
                Objects.equals(resourceType, that.resourceType) &&
                Objects.equals(areaThemeId, that.areaThemeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, resourceType, areaThemeId, status, name, date);
    }
}
