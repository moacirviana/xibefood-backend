package br.jus.tream.xibefood.service;

import br.jus.tream.xibefood.DTO.ProdutoDTO;
import br.jus.tream.xibefood.DTO.RelatorioEstoque;
import br.jus.tream.xibefood.DTO.RelatorioFaturamento;
import br.jus.tream.xibefood.repository.EstoqueRepository;
import br.jus.tream.xibefood.repository.PedidoRepository;
import br.jus.tream.xibefood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RelatorioService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private PedidoRepository pedidoRepository;
    @Async
    public CompletableFuture<RelatorioEstoque> infoEstoque(){
        var produtosSemEstoque = estoqueRepository.produtosComEstoqueZerado()
                .stream().map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(new RelatorioEstoque(produtosSemEstoque));
    }
    @Async
    public CompletableFuture<RelatorioFaturamento> faturamentoObtido() {
        //var dataOntem = LocalDate.now().minusDays(1);
        var dataOntem = LocalDate.now();
        System.out.println("Datadata = " + dataOntem);
        var faturamentoTotal = pedidoRepository.faturamentoTotalDoDia(dataOntem);
        var estatisticas = pedidoRepository.faturamentoTotalDoDiaPorCategoria(dataOntem);
        return CompletableFuture.completedFuture(new RelatorioFaturamento(faturamentoTotal, estatisticas));
    }
}