package br.edu.ifpb.domain.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;
import br.edu.ifpb.infra.persistence.jdbc.PessoaJDBC;
import br.edu.ifpb.infra.persistence.memory.PessoasEmMemoria;

@RequestScoped
public class PessoaServico implements Pessoas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PessoasEmMemoria pessoaMemoria;
	PessoaJDBC pessoajdbc;
	
	public PessoaServico() {
		this.pessoaMemoria = new PessoasEmMemoria();
		this.pessoajdbc = new PessoaJDBC();
	}


	@Override
	public void nova(Pessoa pessoa) {
		Pessoa retorno = this.pessoaMemoria.localizarPessoaComId(pessoa.getId());
        if(Pessoa.fake().equals(retorno)){
        	pessoajdbc.nova(pessoa);
            pessoaMemoria.nova(pessoa);
           
        }else{
            pessoaMemoria.atualizar(pessoa);
        }
		
	}

	@Override
	public List<Pessoa> todas() {
		// TODO Auto-generated method stub
		return this.pessoaMemoria.todas();
	}

	@Override
	public void excluir(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.pessoaMemoria.excluir(pessoa);
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.pessoaMemoria.atualizar(pessoa);
		
	}

	@Override
	public Pessoa localizarPessoaComId(long id) {
		// TODO Auto-generated method stub
		return this.pessoaMemoria.localizarPessoaComId(id);
	}

	@Override
	public List<Dependente> todosOsDepentendes() {
		// TODO Auto-generated method stub
		return this.pessoaMemoria.todosOsDepentendes();
	}

	@Override
	public Dependente localizarDependenteComId(String uuid) {
		// TODO Auto-generated method stub
		return this.pessoaMemoria.localizarDependenteComId(uuid);
	}

	@Override
	public void novo(Dependente dependente) {
		// TODO Auto-generated method stub
		this.pessoaMemoria.novo(dependente);
		
	}
}
