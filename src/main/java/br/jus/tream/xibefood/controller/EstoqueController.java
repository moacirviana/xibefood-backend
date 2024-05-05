package br.jus.tream.xibefood.controller;

import br.jus.tream.xibefood.DTO.AtualizaEstoqueDTO;
import br.jus.tream.xibefood.DTO.EstoqueDTO;
import br.jus.tream.xibefood.service.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listar(){
        var estoques = service.listar();
        return ResponseEntity.ok(estoques);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(@RequestBody @Valid AtualizaEstoqueDTO dto){
        service.atualizarEstoque(dto);
        return ResponseEntity.ok().build();
    }
}
