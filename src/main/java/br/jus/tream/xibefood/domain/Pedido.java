package br.jus.tream.xibefood.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
    @ManyToOne
    private Usuario usuario;

    public Pedido(){}

    public Pedido(List<ItemPedido> itens, Usuario usuario) {
        this.data = LocalDate.now();
        this.itens = itens;
        this.itens.forEach(i -> i.setPedido(this));
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
