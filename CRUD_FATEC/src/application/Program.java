package application;

import javax.swing.JOptionPane;

import model.entities.Pessoa;

public class Program {
   public static void main(String[] args) {
       String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
       int op = 0;
       do{
           try{
               op = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (op){
                    case 1:
                        String nome = JOptionPane.showInputDialog("Digite o nome");
                        String fone = JOptionPane.showInputDialog("Digite o fone");
                        String email = JOptionPane.showInputDialog("Digite o e-mail");
                        Pessoa p = new Pessoa(nome, fone, email);
                        if((nome == null && fone == null && email == null) || (nome.isBlank() || fone.isBlank() || email.isBlank())) {
                        	JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                        }else {
                        	p.inserir();
                            JOptionPane.showMessageDialog(null, "Pessoa Inserida");
                        }
                        break;
                    case 2:
                    	String result = Pessoa.listar();
                    	String codigo = JOptionPane.showInputDialog("Selecione uma pessoa para atualizar:\n\n"+result+"\nDigite o codigo da pessoa: ");
                    	p = new Pessoa(codigo);
                    	if(p.getNome() != null) {
                    		nome = JOptionPane.showInputDialog("Atual = "+p.getNome()+"\nDigite o novo nome");
                            fone = JOptionPane.showInputDialog("Atual = "+p.getFone()+"\nDigite o novo fone");
                            email = JOptionPane.showInputDialog("Atual = "+p.getEmail()+"\nDigite o novo e-mail");
                            if((nome == null || fone == null || email == null) || (nome.isBlank() || fone.isBlank() || email.isBlank())) {
                            	JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                            }else {
                            	int confirmar = JOptionPane.showConfirmDialog(null, "Atualização a ser feita:\n"
	                            		+ "Atual -> Novo\n"
	                            		+ p.getNome()+" -> "+nome+"\n"
	                            		+ p.getFone()+" -> "+fone+"\n"
	                            		+ p.getEmail()+" -> "+email);
	                    		if(confirmar == 0) {
	                    			p.setNome(nome);
	                    			p.setFone(fone);
	                    			p.setEmail(email);
	                    			p.atualizar();
	                    			JOptionPane.showMessageDialog(null, "Pessoa: "+p.getNome()+"\nCodigo: "+p.getCodigo()+"\nAtualizada");
	                    		}
                            }
                    	}else {
                    		JOptionPane.showMessageDialog(null, "Codigo não encontrado");
                    	}
                        break;
                    case 3:
                    	result = Pessoa.listar();
                    	codigo = JOptionPane.showInputDialog("Selecione uma pessoa para apagar:\n\n"+result+"\nDigite o codigo da pessoa: ");
                    	p = new Pessoa(codigo);
                    	if(p.getNome() != null) {
                    		int confirmar = JOptionPane.showConfirmDialog(null,"Pessoa a ser deletada:\n"
                    				+ "Codigo: "+p.getCodigo()+"\n"
                    				+ "Nome: "+p.getNome()+"\n" 
                    				+ "Fone: "+p.getFone()+"\n"
                    				+ "Email: "+p.getEmail()+"\n"
                    				+ "Deseja realmente deletar?");
                    		if(confirmar == 0) {
                    			p.deletar();
                    			JOptionPane.showMessageDialog(null, "Pessoa: "+p.getNome()+"\nCodigo: "+p.getCodigo()+"\nDeletada");
                    		}
                    	}else {
                    		JOptionPane.showMessageDialog(null, "Codigo não encontrado");
                    	}
                        break;
                    case 4:
                    	result = Pessoa.listar();
                    	JOptionPane.showMessageDialog(null, result);
                        break;
                    case 0:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao invalida");
               }
           }
           catch (Exception e){
                JOptionPane.showMessageDialog(null, "Falhou...");
                System.out.println(e.getMessage());
           }

       }while (op != 0);
   } 
}
