package br.jus.tream.xibefood.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CadastroPedidoDTO(@NotNull @Valid List<ItemPedidoDTO> itens) {
}
