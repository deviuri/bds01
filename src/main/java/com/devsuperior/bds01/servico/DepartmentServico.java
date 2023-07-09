package com.devsuperior.bds01.servico;

import com.devsuperior.bds01.Rep.DepartmentRep;
import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServico {

    @Autowired
    private DepartmentRep rep;

    public List<DepartmentDTO> findAll(){
        List<Department> list = rep.findAll(Sort.by("name"));
        return list.stream().map(DepartmentDTO::new).collect(Collectors.toList());
    }
}
