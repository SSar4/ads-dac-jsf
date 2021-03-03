package br.edu.ifpb.infra.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;

public class PessoaJDBC implements Pessoas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conexao;
	private Pessoa p;
	
	public PessoaJDBC() {
		abrirConexao();
	}

	@Override
	public void nova(Pessoa pessoa)  {
		String sql = "INSERT INTO integrante (nome,cpf ) VALUES(?,?)";
		abrirConexao();
		try {
	            PreparedStatement statement = conexao.prepareStatement(sql);
	            statement.setString(1, p.getNome());
	            statement.setString(2, p.getCpf().valor());
                statement.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(PessoaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
	        }
    }


	@Override
	public List<Pessoa> todas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa localizarPessoaComId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dependente> todosOsDepentendes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dependente localizarDependenteComId(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void novo(Dependente dependente) {
		// TODO Auto-generated method stub
		
	}
	 private void abrirConexao() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            this.conexao = DriverManager.getConnection(
	                    "jdbc:postgresql://localhost:5432/dac",
	                    "postgres", "06121995");
	        } catch (SQLException | ClassNotFoundException ex) {
	            Logger.getLogger(PessoaJDBC.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    private void fecharConexao() {
	        try {
	            this.conexao.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(PessoaJDBC.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

}
