package br.jus.tream.xibefood.repository;

import br.jus.tream.xibefood.domain.Estoque;
import br.jus.tream.xibefood.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Estoque findByProdutoId(Long idProduto);

    @Query("SELECT e FROM Estoque e WHERE e.produto.ativo=true")
    List<Estoque> findAll();
    @Query("SELECT e.produto FROM Estoque e WHERE e.quantidade = 0")
    List<Produto> produtosComEstoqueZerado();
}
