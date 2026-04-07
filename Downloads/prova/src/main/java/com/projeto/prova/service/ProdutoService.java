package com.projeto.prova.service;


import com.projeto.prova.entity.Produto;
import com.projeto.prova.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Produto produto, Long id){
        Produto produto1 = produtoRepository.findById(id).get();
        produto1.setNome(produto.getNome());
        return produtoRepository.save(produto1);
    }
}
