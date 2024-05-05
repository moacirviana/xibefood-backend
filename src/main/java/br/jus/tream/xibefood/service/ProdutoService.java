package br.jus.tream.xibefood.service;

import br.jus.tream.xibefood.DTO.CadastroProdutoDTO;
import br.jus.tream.xibefood.DTO.ProdutoDTO;
import br.jus.tream.xibefood.domain.Estoque;
import br.jus.tream.xibefood.domain.Produto;
import br.jus.tream.xibefood.exception.ValidacaoException;
import br.jus.tream.xibefood.repository.EstoqueRepository;
import br.jus.tream.xibefood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public ProdutoDTO cadastrar(CadastroProdutoDTO dto){
        var jaCadastrado = repository.existsByNomeIgnoringCase(dto.nome());
        if(jaCadastrado)
            throw new ValidacaoException("Produto já cadastrado!");

        var produto = new Produto(dto);
        repository.save(produto);

        var estoque = new Estoque(dto.estoqueInicial(), produto);
        estoqueRepository.save(estoque);
        return new ProdutoDTO(produto);
    }
    public ProdutoDTO findById(Long id){
        return new ProdutoDTO(repository.findById(id).get());
    }
    public Page<ProdutoDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(ProdutoDTO::new);
    }

    public void excluir(Long idProduto){
        var produto = repository.findById(idProduto).get();
        produto.desativar();
    }
}
