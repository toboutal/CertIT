package fr.tboutale.api.controllers;

import fr.tboutale.api.dtos.CandidateDto;
import fr.tboutale.api.dtos.CandidateViewDto;
import fr.tboutale.api.entities.Candidate;
import fr.tboutale.api.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("candidate")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    protected void create(@Valid @RequestBody CandidateDto dto) {
        candidateService.create(dto);
    }

    @GetMapping("/{id}")
    protected CandidateViewDto getOne(@PathVariable("id") Long id) {
        return candidateService.getOne(id);
    }

    @GetMapping
    protected List<CandidateViewDto> getAll() {
        return candidateService.getAll();
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id) {
        candidateService.delete(id);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id, CandidateDto dto) {
        candidateService.update(id, dto);
    }
}
