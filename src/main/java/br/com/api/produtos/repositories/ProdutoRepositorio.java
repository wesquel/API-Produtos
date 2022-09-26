package br.com.api.produtos.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.api.produtos.models.ProdutoModelo;


@org.springframework.stereotype.Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {
    
}
