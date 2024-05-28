package repo;


import entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages")
public interface ProgrammingLanguageRepo extends JpaRepository<ProgrammingLanguage, Long> {
}
