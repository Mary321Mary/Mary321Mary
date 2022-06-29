package spring.controllers;

import org.springframework.web.bind.annotation.*;
import spring.dto.IssuedDto;
import spring.models.Issued;
import spring.service.IssuedService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/issued")
public class IssuedController {

    private IssuedService issuedService;

    public IssuedController(IssuedService issuedService) {
        this.issuedService = issuedService;
    }

    @GetMapping("")
    public List<IssuedDto> findAllIssued() {
        return this.issuedService.findAllIssued();
    }

    @GetMapping("/all")
    public List<IssuedDto> findAllByDateReturnIsNull() {
        return this.issuedService.findByDateReturnIsNull();
    }

    @GetMapping("/book/{id}")
    public List<IssuedDto> findIssuedByBookId(@PathVariable long id) {
        return this.issuedService.findByBookId(id);
    }

    @GetMapping("/reader/{id}")
    public List<IssuedDto> findIssuedByReaderId(@PathVariable long id) {
        return this.issuedService.findByReaderId(id);
    }

    @GetMapping("/employee/{id}")
    public List<IssuedDto> findIssuedByEmployeeId(@PathVariable long id) {
        return this.issuedService.findByEmployeeId(id);
    }

    @PostMapping
    public IssuedDto createIssued(@RequestBody IssuedDto issued) {
        return this.issuedService.saveIssued(issued);
    }

    @PutMapping
    public IssuedDto closeIssued(@RequestBody IssuedDto issued) {
        return this.issuedService.saveIssued(issued);
    }

}
