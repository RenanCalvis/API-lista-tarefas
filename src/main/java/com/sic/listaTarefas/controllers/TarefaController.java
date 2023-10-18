package com.sic.listaTarefas.controllers;

import com.sic.listaTarefas.model.Tarefa;
import com.sic.listaTarefas.services.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin
@RequestMapping
public class TarefaController {
    final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas(){
        return tarefaService.getAll();
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<?> getTarefaById(@PathVariable("id") Integer id){
        try{
            Tarefa tarefa = tarefaService.getByid(id);
            return ResponseEntity.ok(tarefa);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tarefas")
    public ResponseEntity<?> save(@RequestBody @Valid Tarefa tarefa){
        try{
            tarefa = tarefaService.save(tarefa);
            return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<?> deletedById(@PathVariable Integer id){
        try{
            tarefaService.deletedById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

