package br.jus.tream.xibefood.domain;

import br.jus.tream.xibefood.DTO.CadastroProdutoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private BigDecimal preco;
    private Boolean ativo;

    public Produto(){}

    public Produto(CadastroProdutoDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.categoria = Categoria.valueOf(dto.categoria().toUpperCase());
        this.preco = dto.preco();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public Boolean getAtivo() {
        return ativo;
    }

    public void desativar(){
        this.ativo = false;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

}