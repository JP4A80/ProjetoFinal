/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jpexi
 */
public class ModelAtribuicao extends AbstractTableModel{
    
    ArrayList<Funcionario> funcionarios = new ArrayList();
    String[] colunas = {"Disciplina", "ID Disciplina","Professor", "ID Professor"};
    
    
   public void cadastrarFuncionario(Funcionario f){
        funcionarios.add(f);
        this.fireTableDataChanged();
    }
    
   public void ler(){
    String path = "C:\\Users\\jpexi\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoFinal\\Atribuicao.txt";
		List<Funcionario> list = new ArrayList<Funcionario>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String nome = vect[0];
                                String salario = vect[1];
                                String area = vect[2];
				String cpf = vect[3];
                                Funcionario f = new Funcionario( nome, salario, area,cpf);
                               cadastrarFuncionario(f);
				line = br.readLine();
			}	
			
			System.out.println("PRODUCTS:");
			for (Funcionario p : list) {
				System.out.println(p);
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
   
   
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
           return funcionarios.get(rowIndex).getNome();
        }else if (columnIndex == 1){
            return funcionarios.get(rowIndex).getSalario();
        }else if (columnIndex == 2){
            return funcionarios.get(rowIndex).getArea();
        } else {
            return funcionarios.get(rowIndex).getCpf();
        }
    }
    
}
