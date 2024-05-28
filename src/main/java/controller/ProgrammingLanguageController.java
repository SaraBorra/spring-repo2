package controller;

import entity.*;
import repo.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/programmingLanguage")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageRepo programmingLanguageRepo;

    @PostMapping("/addLanguage")
    public ResponseEntity<ProgrammingLanguage> createLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage savedLanguage = programmingLanguageRepo.save(programmingLanguage);
        return ResponseEntity.ok(savedLanguage);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProgrammingLanguage>> getAllLanguage() {
        List<ProgrammingLanguage> languages = programmingLanguageRepo.findAll();
        return ResponseEntity.ok(languages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> setInventor(@PathVariable Long id, @RequestParam String inventor) {
        Optional<ProgrammingLanguage> optionalLanguage = programmingLanguageRepo.findById(id);
        if (optionalLanguage.isPresent()) {
            ProgrammingLanguage existingLanguage = optionalLanguage.get();
            existingLanguage.setInventor(inventor);
            programmingLanguageRepo.save(existingLanguage);
            return ResponseEntity.ok(existingLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getTwoLanguage")
    public ResponseEntity<List<ProgrammingLanguage>> getTwoLanguage(@PageableDefault(size = 2) Pageable pageable) {
        List<ProgrammingLanguage> languages = programmingLanguageRepo.findAll(pageable).getContent();
        return ResponseEntity.ok(languages);
    }

}
