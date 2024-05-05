package br.jus.tream.xibefood.controller;

import br.jus.tream.xibefood.DTO.CadastroProdutoDTO;
import br.jus.tream.xibefood.DTO.ProdutoDTO;
import br.jus.tream.xibefood.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody CadastroProdutoDTO dto) {
        var produto = this.service.cadastrar(dto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> listar(Pageable paginacao) {
        var produtos = this.service.listar(paginacao);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        var produto = this.service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
