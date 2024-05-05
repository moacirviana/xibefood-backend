package br.jus.tream.xibefood.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CadastroProdutoDTO(@NotBlank String nome,
                                 @NotBlank String descricao,
                                 @NotNull BigDecimal preco,
                                 @NotNull @Min(1) Integer estoqueInicial,
                                 @NotBlank String categoria ) {
}
