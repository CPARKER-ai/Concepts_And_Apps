import org.concepts3060.pa03project.DTO;

import java.util.*;
import java.util.stream.Collectors;

public class store {
    @Component
    public static class InMemoryResourceStore {

        private static final Logger logger = LoggerFactory.getLogger(InMemoryResourceStore.class);

        private final Map<String, DTO> byId = new HashMap<>();
        private final List<DTO> all = new ArrayList<>();

        // Constructorpublic InMemoryResourceStore() {
        //            //
         5 seeds
            DTO r1 = new DTO("1", "Java Tutorial", "Programming", "Online",
                    "https://example.com/java", "java,tutorial");
            DTO r2 = new DTO("2", "Spring Boot Guide/Tutorial", "Programming", "Online",
                    "https://example.com/spring", "spring,boot,java");
            DTO r3 = new DTO("3", "MySQL Introduction", "Database Management", "SQL Workbench Online",
                    "https://www.w3schools.com/sql/", "mysql,database,sql");
            DTO r4 = new DTO("4", "Chess", "Hobby", "Online",
                    "https://chess.com", "chess,game,hobby");
            DTO r5 = new DTO("5", "Bicycling", "Fitness", "Park",
                    "https://www.bicycling.com", "biking,exercise,fitness");

            List<DTO> seeds = Arrays.asList(r1, r2, r3, r4, r5);

            for (DTO r : seeds) {
                byId.put(r.getId(), r);
                all.add(r);
            }

            logger.info("InMemoryResourceStore initialized with {} resources", all.size());
        }

        // Returning
        public List<DTO> findAll() {
            return Collections.unmodifiableList(new ArrayList<>(all));
        }

        // Find my resource by id
        public Optional<DTO> findById(String id) {
            return Optional.ofNullable(byId.get(id));
        }

        // Find by filters
        public List<DTO> findByFilters(Optional<String> category, Optional<String> q) {
            return all.stream()
                    .filter(r -> category.map(c -> r.getCategory().equalsIgnoreCase(c)).orElse(true))
                    .filter(r -> q.map(query -> {
                        String lowerQuery = query.toLowerCase();
                        return r.getName().toLowerCase().contains(lowerQuery) || r.getTags().toLowerCase().contains(lowerQuery);
                    }).orElse(true))
                    .collect(Collectors.toList());
        }
}
}
