package com.iesjuanbosco.ejemploweb.repository;

import com.iesjuanbosco.ejemploweb.entity.Categoria;
import com.iesjuanbosco.ejemploweb.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Indica que esta clase es un repositorio
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findByCategoria(Categoria categoria);
    //nos devuelve el producto más caro
    Long countByCategoria(Categoria categoria); //numero de productos de cada categoria

//precio medio de los productos de una categoria concreta por id
    @Query("SELECT AVG(p.precio) FROM Producto p WHERE p.categoria.id = :categoriaId")
    Double AVGPrecioByCategoria(@Param("categoriaId") Long categoriaId);



}

