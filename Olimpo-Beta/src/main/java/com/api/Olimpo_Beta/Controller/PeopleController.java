package com.api.Olimpo_Beta.Controller;

import com.api.Olimpo_Beta.Business.PeopleBusiness;
import com.api.Olimpo_Beta.Dto.PeopleDto;
import com.api.Olimpo_Beta.Utilities.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/people")
public class PeopleController {

    @Autowired
    PeopleBusiness peopleBusiness;

    @GetMapping
    public ResponseEntity<List<PeopleDto>> getAllPeople() {
        try {
            List<PeopleDto> people = peopleBusiness.findAll();
            return ResponseEntity.ok(people);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleDto> getPersonById(@PathVariable Long id) {
        try {
            PeopleDto person = peopleBusiness.getById(id);
            if (person != null) {
                return ResponseEntity.ok(person);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createPerson(@RequestBody PeopleDto peopleDto) {
        try {
            peopleBusiness.create(peopleDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{documentNumber}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long documentNumber, @RequestBody PeopleDto peopleDto) {
        try {
            // Set the ID of the DTO to ensure the update is correct
            peopleDto.setDocumentNumber(documentNumber);
            peopleBusiness.update(peopleDto);
            return ResponseEntity.ok().build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{documentNumber}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        try {
            peopleBusiness.delete(id);
            return ResponseEntity.noContent().build();
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
