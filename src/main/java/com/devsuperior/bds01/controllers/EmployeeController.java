package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.servico.EmployeeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServico servico;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> get(@PageableDefault(sort = "name") Pageable pageable){

        Page<EmployeeDTO> list = servico.get(pageable);

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> cadastro(@RequestBody EmployeeDTO employeeDTO, UriComponentsBuilder uri){
        employeeDTO = servico.cadastro(employeeDTO);

        URI link = uri.path("/employees/{id}").buildAndExpand(employeeDTO.getId()).toUri();

        return ResponseEntity.created(link).body(employeeDTO);
    }
}
