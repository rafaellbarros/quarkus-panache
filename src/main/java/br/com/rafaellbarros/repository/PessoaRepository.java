package br.com.rafaellbarros.repository;

import br.com.rafaellbarros.model.entity.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 21/09/2022
 */

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

}
