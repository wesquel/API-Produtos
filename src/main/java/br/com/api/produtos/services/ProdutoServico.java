package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.ProdutoModelo;
import br.com.api.produtos.models.RespostaModelo;
import br.com.api.produtos.repositories.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired RespostaModelo rm;

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    // Metodo para cadastro de produtos

    public ResponseEntity<?> cadastrar(ProdutoModelo pm){
        
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório !");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if (pm.getMarca().equals("")){
            rm.setMensagem("O Nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProdutoModelo>(this.pr.save(pm), HttpStatus.CREATED);
        }

    }

}
