package br.com.rafaellbarros.service;

import br.com.rafaellbarros.model.dto.PessoaDTO;
import br.com.rafaellbarros.model.entity.Pessoa;
import br.com.rafaellbarros.model.mapper.PessoaMapper;
import br.com.rafaellbarros.repository.PessoaRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 21/09/2022
 */

@ApplicationScoped
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper mapper;

    public List<PessoaDTO> listarTodas() {
        final List<Pessoa> list = pessoaRepository.findAll().list();
        return mapper.toDTO(list);
    }

    public PessoaDTO obterPorId(final Long id) {
        final Pessoa pessoa = pessoaRepository.findById(id);

        if (pessoa == null) {
            throw new RuntimeException("Pessoa não encontrada!");
        }

        return mapper.toDTO(pessoa);
    }

    @Transactional
    public PessoaDTO inserir(final PessoaDTO pessoaDTO) {
        final Pessoa pessoa = mapper.toEntity(pessoaDTO);
        pessoaRepository.persist(pessoa);
        return mapper.toDTO(pessoa);
    }
}
