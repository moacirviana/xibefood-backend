package br.jus.tream.xibefood.service;

import br.jus.tream.xibefood.DTO.CadastroPedidoDTO;
import br.jus.tream.xibefood.DTO.PedidoDTO;
import br.jus.tream.xibefood.domain.ItemPedido;
import br.jus.tream.xibefood.domain.Pedido;
import br.jus.tream.xibefood.domain.Usuario;
import br.jus.tream.xibefood.exception.ValidacaoException;
import br.jus.tream.xibefood.repository.EstoqueRepository;
import br.jus.tream.xibefood.repository.PedidoRepository;
import br.jus.tream.xibefood.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Transactional
    public PedidoDTO cadastrar(CadastroPedidoDTO dto, Usuario usuario) {
        var itens = new ArrayList<ItemPedido>();
        for (var itemDto : dto.itens()) {
            var estoque = estoqueRepository.findByProdutoId(itemDto.produtoId());
            if (estoque.getQuantidade() >= itemDto.quantidade()) {
                var produto = produtoRepository.findById(itemDto.produtoId()).get();
                if (!produto.getAtivo())
                    throw new ValidacaoException("Pedido contém produto excluído: " + produto.getId());
                var itemPedido = new ItemPedido(null, produto, itemDto.quantidade());
                itens.add(itemPedido);
                estoque.diminuir(itemDto.quantidade());
            } else {
                throw new ValidacaoException("Estoque indisponível para o produto: " + itemDto.produtoId());
            }
        }
        var pedido = new Pedido(itens, usuario);
        repository.save(pedido);
        return new PedidoDTO(pedido);
    }

    public PedidoDTO findById(Long pedido_id){
        PedidoDTO obj = new PedidoDTO(repository.findById(pedido_id).get());
        return obj;
    }

}