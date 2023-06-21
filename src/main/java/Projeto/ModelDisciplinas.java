package Projeto;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpexi
 */
public class ModelDisciplinas extends AbstractTableModel{

    ArrayList<Disciplina> disciplinas = new ArrayList();
    String[] colunas = {"Nome", "Area", "Horas", "ID"};
    
    public void cadastrarDisciplina(Disciplina h){
        disciplinas.add(h);
        this.fireTableDataChanged();
    }
    
    public Disciplina returnDisciplina(int index){
        return disciplinas.get(index);
    }
    
    public void alterarDisciplina(int index, Disciplina f){
        disciplinas.set(index, f);
        this.fireTableDataChanged();
    }
    
    public void removerDisciplina(int index){
        disciplinas.remove(index);
        this.fireTableDataChanged();
    }
    
    public void lerd(){
    String path = "C:\\Users\\jpexi\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoFinal\\Disciplinas.txt";
		List<Disciplina> list = new ArrayList<Disciplina>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String nome = vect[0];
                                String area = vect[1];
				Double horas = Double.valueOf(vect[2]);
				String id = vect[3];
                                Disciplina h = new Disciplina( nome, area,  horas,  id);
                               cadastrarDisciplina(h);
				line = br.readLine();
			}	
			
			System.out.println("PRODUCTS:");
			for (Disciplina p : list) {
				System.out.println(p);
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    
    
     public void gravard(int somaLinhas){
         
        try{
            FileWriter arq = new FileWriter("C:\\Users\\jpexi\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoFinal\\Disciplinas.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            System.out.print("Entrou\n");
            gravarArq.print("Nome, CPF, Salario, Area\n");
            for (int i=0; i < somaLinhas; i++){
                Disciplina f = returnDisciplina(i);
                /*
                gravarArq.print(f.getNome());
                gravarArq.print(f.getCpf());
                gravarArq.print(f.getSalario());
                gravarArq.print(f.getArea());
                gravarArq.printf("\n");*/
                String conteudo = f.getNome()+ ","+f.getArea()+","+f.getHoras()+","+f.getId()+"\n";
                System.out.print(conteudo);
                gravarArq.print(conteudo);
                
            }
            gravarArq.close();
        }catch (java.io.IOException er){
            System.out.println("OOOOps");
        }
    }
    
    
    @Override
    public int getRowCount() {
        return disciplinas.size();
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
           return disciplinas.get(rowIndex).getNome();
        }else if (columnIndex == 1){
            return disciplinas.get(rowIndex).getArea();
        }else if (columnIndex == 2){
            return disciplinas.get(rowIndex).getHoras();
        } else {
            return disciplinas.get(rowIndex).getId();
        }
    }
    
}
