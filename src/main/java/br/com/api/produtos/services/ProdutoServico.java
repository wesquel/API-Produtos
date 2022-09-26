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

    // Metodo para cadastro ou alteração de produtos

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório !");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if (pm.getMarca().equals("")){
            rm.setMensagem("O Nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
        }

    }

    // Remoção de produtos

    public ResponseEntity<RespostaModelo> remover(long codigo){
        pr.deleteById(codigo);
        rm.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

}
