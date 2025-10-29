import org.concepts3060.pa03project.DTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Service {

    private final store.InMemoryResourceStore store;

    // Constructor-based Dependency Injection
    public Service(store.InMemoryResourceStore store) {
        this.store = store;
    }

    // Wraps for findAll
    public List<DTO> findAll() {
        return store.findAll();
    }

    // Wraps for findById
    public Optional<DTO> findById(String id) {
        return store.findById(id);
    }

    // Wraps for findByFilters(Category, q)
    public List<DTO> findByFilters(Optional<String> category,
                                   Optional<String> q) {
        return store.findByFilters(category, q);
    }
}
