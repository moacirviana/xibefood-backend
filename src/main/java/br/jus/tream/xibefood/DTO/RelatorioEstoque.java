package br.jus.tream.xibefood.DTO;

import java.util.List;

public record RelatorioEstoque (List<ProdutoDTO> produtosAusentes) {
}