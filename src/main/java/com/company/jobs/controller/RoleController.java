package com.company.jobs.controller;

import com.company.jobs.dto.RoleDTO;
import com.company.jobs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() {

        List<RoleDTO> roleDTOS = roleService.findAll();
        return ResponseEntity.ok(roleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {

        RoleDTO foundRole = roleService.findById(id);
        return ResponseEntity.ok(foundRole);
    }
}
