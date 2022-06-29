package spring.controllers;

import org.springframework.web.bind.annotation.*;
import spring.dto.ReaderDto;
import spring.models.Reader;
import spring.service.ReaderService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/readers")
public class ReaderController {

    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/username/{username}")
    public ReaderDto findReaderByUsername(@PathVariable String username) {
        return this.readerService.findReaderByUsername(username);
    }

    @GetMapping("/{id}")
    public ReaderDto findReaderById(@PathVariable Long id) {
        return this.readerService.findReaderById(id);
    }

    @PostMapping
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return this.readerService.saveReader(readerDto);
    }

    @PutMapping
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return this.readerService.saveReader(readerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable long id) {
        this.readerService.deleteReader(id);
    }

}
