package br.jus.tream.xibefood.DTO;

import br.jus.tream.xibefood.domain.Categoria;

import java.math.BigDecimal;

public record EstatisticasVenda(Categoria categoria, Long quantidadesVenda, BigDecimal faturamento) {
}