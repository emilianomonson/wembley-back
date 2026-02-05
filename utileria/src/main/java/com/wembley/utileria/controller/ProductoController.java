package com.wembley.utileria.controller;

import com.wembley.utileria.model.Producto;
import com.wembley.utileria.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200") // Para que Angular pueda conectarse sin problemas de permisos
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public void crear(@RequestBody Producto producto) {
        service.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public void actualizar(@RequestBody Producto producto, @PathVariable int id) {
        producto.setId(id);
        service.actualizar(producto);
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("uploads/" + file.getOriginalFilename());
            Files.write(path, bytes);
            return "/imagenes/" + file.getOriginalFilename(); // URL para Angular
        } catch (IOException e) {
            return "Error al subir";
        }
    }
}