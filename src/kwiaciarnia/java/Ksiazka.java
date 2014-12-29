/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwiaciarnia.java;

/**
 *
 * @author Wojtek
 */
public class Ksiazka {
    private int id;
    private String tytul;
    private String autor;
    private float cena;

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
 
    public Ksiazka() {}
    public Ksiazka(int id, String tytul, String autor, float cena) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.cena = cena;
    }
 
    @Override
    public String toString() {
        return "["+id+"] - "+tytul+" - "+autor;
    }    
}
