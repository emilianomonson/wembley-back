package com.wembley.utileria.repository;

import com.wembley.utileria.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Producto> findAll() {
        // Agregamos id_categoria y talles al SELECT para que Angular los reciba
        String sql = "SELECT id, nombre, precio, marca, imagen_url, id_categoria, talles FROM Productos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Producto p = new Producto();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            p.setMarca(rs.getString("marca"));
            p.setImagen_url(rs.getString("imagen_url"));
            p.setId_categoria(rs.getInt("id_categoria")); // <--- Agregado
            p.setTalles(rs.getString("talles"));           // <--- Agregado
            return p;
        });
    }

    public void save(Producto p) {
        // 6 signos de pregunta para 6 columnas
        String sql = "INSERT INTO Productos (nombre, marca, precio, id_categoria, imagen_url, talles) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                p.getNombre(),
                p.getMarca(),
                p.getPrecio(),
                p.getId_categoria(),
                p.getImagen_url(),
                p.getTalles()
        );
    }

    public void delete(int id) {
        // Usamos 'id' que es el nombre que unificamos en SQL
        String sql = "DELETE FROM Productos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Producto p) {
        // Corregimos 'id_producto' por 'id' y quitamos 'descripcion'
        String sql = "UPDATE Productos SET nombre=?, marca=?, precio=?, id_categoria=?, imagen_url=?, talles=? WHERE id=?";
        jdbcTemplate.update(sql,
                p.getNombre(),
                p.getMarca(),
                p.getPrecio(),
                p.getId_categoria(),
                p.getImagen_url(),
                p.getTalles(),
                p.getId()
        );
    }
}