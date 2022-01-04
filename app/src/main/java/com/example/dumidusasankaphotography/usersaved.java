package com.example.dumidusasankaphotography;

public class usersaved {
    String Name11,email11,Vanue11,date11,time11,event11,teleno11,crew11,Photographer_name,Note11;


    public usersaved(){
        
    }

    public usersaved(String Name11, String email11, String vanue11, String date11, String time11, String event11, String teleno11, String crew11,String Photographer_name,String Note11) {
        this.Name11 = Name11;
        this.email11 = email11;  
        this.Vanue11 = vanue11;
        this.date11 = date11;
        this.time11 = time11;
        this.event11 = event11;
        this.teleno11 = teleno11;
        this.crew11 = crew11;
        this.Photographer_name = Photographer_name;
        this.Note11 = Note11;

    }

    public String getName11() { return Name11; }

    public void setName11(String name11) {
        this.Name11 = name11;
    }

    public String getEmail11() {
        return email11;
    }

    public void setEmail11(String email11) {
        this.email11 = email11;
    }

    public String getVanue11() {
        return Vanue11;
    }

    public void setVanue11(String vanue11) {
        Vanue11 = vanue11;
    }

    public String getDate11() {
        return date11;
    }

    public void setDate11(String date11) {
        this.date11 = date11;
    }

    public String getTime11() {
        return time11;
    }

    public void setTime11(String time11) {
        this.time11 = time11;
    }

    public String getEvent11() {
        return event11;
    }

    public void setEvent11(String event11) {
        this.event11 = event11;
    }

    public String getTeleno11() {
        return teleno11;
    }

    public void setTeleno11(String teleno11) {
        this.teleno11 = teleno11;
    }

    public String getCrew11() { return  crew11; }

    public void setCrew11(String crew11){this.crew11=crew11;}

    public String getPhotographer_name() { return Photographer_name; }

    public void setPhotographer_name(String Photographer_name) { this.Photographer_name = Photographer_name; }

    public String getNote11() { return Note11; }

    public void setNote11(String note11) { Note11 = note11; }
}
