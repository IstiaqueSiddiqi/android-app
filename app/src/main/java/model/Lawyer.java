package model;

import java.io.Serializable;

/**
 * Created by Istiaq Haq on 07-Oct-15.
 */

public class Lawyer implements Serializable{
    String name, address, state, city, contact, notary, property, divorce, matrimonial, criminal, family,civil,consumer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNotary() {
        return notary;
    }

    public void setNotary(String notary) {
        this.notary = notary;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDivorce() {
        return divorce;
    }

    public void setDivorce(String divorce) {
        this.divorce = divorce;
    }

    public String getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(String matrimonial) {
        this.matrimonial = matrimonial;
    }

    public String getCriminal() {
        return criminal;
    }

    public void setCriminal(String criminal) {
        this.criminal = criminal;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCivil() {
        return civil;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}
