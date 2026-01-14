package pl.edu.vistula.firstrestapi.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.vistula.firstrestapi.product.domain.Product;

import java.util.*;


@Repository
public class OldProductRepository {

    private final Map<Long, Product> map = new HashMap<>();
    private Long counter = 1L;

    public Product save(Product entity) {
        setId(entity);
        return entity;
    }

    private Product setId(Product entity) {
        if (entity.getId() != null) {
            map.put(entity.getId(), entity);
        } else {
            entity.setId(counter);
            map.put(counter, entity);
            counter++;
        }
        return entity;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }
    public void deleteById(Long id) {
        map.remove(id);
    }


}
