package br.jus.tream.xibefood.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String email, @NotBlank String senha) {
}
