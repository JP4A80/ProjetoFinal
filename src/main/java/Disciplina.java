/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpexi
 */
public class Disciplina {
    private String nome;
    private String area;
    private double horas;
    private String id;
    
    public Disciplina(String nome, String area, double horas, String id){
        super();
        this.nome = nome;
        this.area = area;
        this.horas = horas;
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
    
    
    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
}
