/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpexi
 */
public class Funcionario {
    private String nome;
    private String salario;
    private String area;
    private String cpf;

    
    public Funcionario(String nome,String salario, String area,String cpf){
        super();
        this.nome = nome;
        this.salario = salario;
        this.area = area;
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    
    
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }

    @Override
	public String toString() {
		return "Product [Nome = " + nome + ", CPF = " + cpf + ", Salario = " + salario + " Area = "+ area +"]";
	}
    
    
    
    
    
    
    
    
}
