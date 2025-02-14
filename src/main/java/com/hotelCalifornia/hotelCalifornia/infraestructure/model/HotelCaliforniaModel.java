package com.hotelCalifornia.hotelCalifornia.infraestructure.model;

import java.util.UUID;

public class HotelCaliforniaModel {


    private UUID id;

    private String name;

    private String local;

    private int capacidade;

    private String cnpj;

    public HotelCaliforniaModel() {
    }

    public HotelCaliforniaModel(UUID id, String name, String local, int capacidade, String cnpj) {
        this.id = id;
        this.name = name;
        this.local = local;
        this.capacidade = capacidade;
        this.cnpj = cnpj;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        HotelCaliforniaModel that = (HotelCaliforniaModel) object;
        return java.util.Objects.equals(id, that.id);
    }

}
