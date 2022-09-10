package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pessoa {
    private String codigo;
    private String nome;
    private String fone;
    private String email;

    public void inserir() throws Exception{
//        1. Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
//        2. Abrir uma conexãoo com o MySQL Server
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection conexao = factory.getConnection();
//        		3. Preparar o comando (solicitar ao MySQL Server que compile o comando SQL previamente)
        		PreparedStatement ps = conexao.prepareStatement(sql)){
//        	4. Substituir os eventuais placeholders
        	ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //5. Executar o comando
            ps.execute();
        }
//        6. Fechar os recursos (conexão e o comando preparado) try está fechando automaticamente{
//        ps.close();
//        conexao.close();
//    	  }
    }
    
    public void atualizar() throws Exception{
    	String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE cod_pessoa = ?";
    	ConnectionFactory factory = new ConnectionFactory();
    	try(Connection conexao = factory.getConnection();
    			PreparedStatement ps = conexao.prepareStatement(sql)){
    		ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setString(4, codigo);
            ps.execute();
    	}
    }
    
    public void deletar() throws Exception{
    	String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
    	ConnectionFactory factory = new ConnectionFactory();
    	try(Connection conexao = factory.getConnection();
    			PreparedStatement ps = conexao.prepareStatement(sql)){
    		ps.setString(1, codigo);
            ps.execute();
    	}
    }
    
    public static String listar() throws Exception {
    	StringBuilder sb = new StringBuilder();
    	String sql = "SELECT * FROM tb_pessoa";
    	ConnectionFactory factory = new ConnectionFactory();
    	try(Connection conexao = factory.getConnection();
    			PreparedStatement ps = conexao.prepareStatement(sql)){
    		ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
            	for(int i = 1; i <= 4; i++) {
            		sb.append(resultSet.getString(i)+" ");
            	}
            	sb.append("\n");
            }
            return sb.toString();
    	}
    }
    
    public Pessoa (String nome, String fone, String email){
        setNome(nome);
        setFone(fone);
        setEmail(email);
    }
    
    public Pessoa (String codigo) throws Exception {
    	String sql = "SELECT * FROM tb_pessoa WHERE cod_pessoa = ?";
    	ConnectionFactory factory = new ConnectionFactory();
    	try(Connection conexao = factory.getConnection();
    			PreparedStatement ps = conexao.prepareStatement(sql)){
    		ps.setString(1, codigo);
    		ResultSet resultSet = ps.executeQuery();
    		while(resultSet.next()) {
    			setCodigo(codigo);
        		setNome(resultSet.getString(2));
        		setFone(resultSet.getString(3));
        		setEmail(resultSet.getString(4));
    		}
    	}
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }
    public String getFone() {
        return fone;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
