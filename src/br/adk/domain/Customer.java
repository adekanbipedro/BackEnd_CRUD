package br.adk.domain;

import java.util.Objects;

public class Customer {
    private String name;
    private Long id;
    private Long tel;
    private String adress;
    private Integer number;
    private String city;
    private String state;

    public Customer(String name, String id, String tel, String adress, String number, String city, String state) {
        this.name = name;
        this.id = Long.valueOf(id.trim());
        this.tel = Long.valueOf(tel.trim());
        this.adress = adress;
        this.number = Integer.valueOf(number);
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTel() {
        return this.tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Customer customer = (Customer)o;
            return Objects.equals(this.id, customer.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String toString() {
        return "domain.Costumers{name='" + this.name + "', id=" + this.id + "}";
    }
}
