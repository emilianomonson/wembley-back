package com.wembley.utileria.service;

import com.wembley.utileria.model.Producto;
import com.wembley.utileria.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public void guardar(Producto producto) {
        // Aquí podrías validar que el precio no sea negativo, por ejemplo
        repository.save(producto);
    }

    public void eliminar(int id) { repository.delete(id); }
    public void actualizar(Producto p) { repository.update(p); }
}