package br.jus.tream.xibefood.DTO;

import java.math.BigDecimal;
import java.util.List;

public record RelatorioFaturamento(BigDecimal faturamentoTotal, List<EstatisticasVenda> estatisticas) {
}