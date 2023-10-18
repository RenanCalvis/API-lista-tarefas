package com.sic.listaTarefas.services;

import com.sic.listaTarefas.model.Tarefa;
import com.sic.listaTarefas.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class TarefaService {
    final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> getAll(){
        return tarefaRepository.findAll();
    }

    public Tarefa getByid(Integer id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Não foi encontrada uma tarefa com o id: "+id));

    }

    public Tarefa save(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void deletedById(Integer id){
        tarefaRepository.deleteById(id);
    }
}
