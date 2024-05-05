package br.jus.tream.xibefood.service;

import br.jus.tream.xibefood.DTO.AtualizaEstoqueDTO;
import br.jus.tream.xibefood.DTO.EstoqueDTO;
import br.jus.tream.xibefood.exception.ValidacaoException;
import br.jus.tream.xibefood.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository repository;

    public List<EstoqueDTO> listar(){
        return repository.findAll()
                .stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

    public void atualizarEstoque(AtualizaEstoqueDTO dto){
        var estoque = repository.findByProdutoId(dto.idProduto());
        if(!estoque.getProduto().getAtivo())
            throw new ValidacaoException("Produto excluído!");
        estoque.adicionar(dto.quantidade());
    }
}
