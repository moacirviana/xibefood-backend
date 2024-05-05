package br.jus.tream.xibefood.DTO;

import br.jus.tream.xibefood.domain.Estoque;

public record EstoqueDTO(Long produtoId, Integer quantidade) {
    public EstoqueDTO(Estoque estoque){
        this(estoque.getProduto().getId(), estoque.getQuantidade());
    }
}
