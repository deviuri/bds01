package com.devsuperior.bds01.servico;

import com.devsuperior.bds01.Rep.EmployeeRep;
import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServico {

    @Autowired
    private EmployeeRep rep;

    public Page<EmployeeDTO> get(Pageable pag){
        Page<Employee> funcionarios = rep.findAll(pag);

        return funcionarios.map(EmployeeDTO::new);
    }

    public EmployeeDTO cadastro(EmployeeDTO dto){
        Employee fun = new Employee();
        fun.setEmail(dto.getEmail());
        fun.setName(dto.getName());
        fun.setDepartment(new Department(dto.getDepartmentId(), null));
        fun = rep.save(fun);

        return new EmployeeDTO(fun);
    }
}
