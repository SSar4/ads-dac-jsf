package br.edu.ifpb.infra.persistence.memory;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 11:01:12
 */
public class PessoasEmMemoria implements Pessoas {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<Pessoa> pessoas = new ArrayList<>();
    private final List<Dependente> dependentes = new ArrayList<>();

    public PessoasEmMemoria() {
       
    }


    public void nova(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas.add(pessoa);
    }

    public List<Pessoa> todas() {
        //TODO: implementar
        return Collections.unmodifiableList(pessoas);

    }

    public void excluir(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas.remove(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        //TODO: implementar
        this.pessoas
                .removeIf(p -> p.getId() == pessoa.getId());
        this.pessoas.add(pessoa);

    }

    @Override
    public Pessoa localizarPessoaComId(long id) {
        return todas()
                .stream()
                .filter(p->p.getId() == id)
                .findFirst()
                .orElse(Pessoa.fake());
    }

    @Override
    public List<Dependente> todosOsDepentendes() {
        return Collections.unmodifiableList(dependentes);
    }

    @Override
    public Dependente localizarDependenteComId(String uuid) {
        //TODO: implementar
        return todosOsDepentendes()
                .stream()
                .filter(d -> d.getUuid().equals(uuid))
                .findFirst()
                .orElse(Dependente.fake());
    }

    @Override
    public void novo(Dependente dependente) {
        this.dependentes.add(dependente);
    }

}
