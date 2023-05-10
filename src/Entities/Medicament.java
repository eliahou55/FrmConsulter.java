package Entities;

public class Medicament
{
    private int numero;
    private String nom;
    private double prix;
    private int quantite;
    public Medicament(){}

    public Medicament(int unNum, String unNom,  double unPrix,int uneQte)
    {
        this.numero = unNum;
        this.nom = unNom;
        this.prix = unPrix;
        this.quantite = uneQte;
    }


    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }
}
