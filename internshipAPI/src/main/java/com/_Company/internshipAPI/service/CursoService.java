package com._Company.internshipAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com._Company.internshipAPI.model.dao.CursoDAO;
import com._Company.internshipAPI.model.dao.EstudanteDAO;
import com._Company.internshipAPI.model.dao.VagaDAO;
import com._Company.internshipAPI.model.entities.Curso;

@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    @Autowired
    private EstudanteDAO estudanteDAO;

    @Autowired
    private VagaDAO vagaDAO;

    public Curso create(Curso curso) {
        if (cursoDAO.existsByNome(curso.getNome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um curso com esse nome");
        }

        return cursoDAO.save(curso);
    }

    public List<Curso> getAllCursos() {
        return cursoDAO.findAll();
    }

    public Curso getById(Long id) {
        return cursoDAO.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso com o ID " + id + " não encontrado"));
    }

    public void deleteById(Long id) {
        getById(id);

        if (estudanteDAO.existsByIdCurso(id) || vagaDAO.existsByCursos_Id(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível excluir curso vinculado a estudantes ou vagas");
        }

        cursoDAO.deleteById(id);
    }

    public Curso updateCurso(Long id, Curso newCurso) {
        Curso curso = getById(id);

        if (cursoDAO.existsByNomeAndIdNot(newCurso.getNome(), id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um curso com esse nome");
        }

        curso.setNome(newCurso.getNome());

        return cursoDAO.save(curso);
    }
}