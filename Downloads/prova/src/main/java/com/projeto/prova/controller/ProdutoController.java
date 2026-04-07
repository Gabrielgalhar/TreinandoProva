package com.projeto.prova.controller;


import com.projeto.prova.entity.Produto;
import com.projeto.prova.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto newProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(200).body(newProduto);

    }
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.status(201).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id){
        Optional<Produto> getProduto = produtoService.buscarPorId(id);
        return ResponseEntity.status(201).body(getProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto,@PathVariable Long id){
        Produto produto1 = produtoService.atualizarProduto(produto,id);
        return ResponseEntity.status(200).body(produto1);
    }

}
