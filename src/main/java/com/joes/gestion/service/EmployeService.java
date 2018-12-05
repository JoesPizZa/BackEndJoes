package com.joes.gestion.service;

import com.joes.gestion.dao.EmployeRepository;
import com.joes.gestion.entity.Employe;
import com.joes.gestion.entity.TypePost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class EmployeService {

    private final EmployeRepository employeRepository;
    @Autowired
    private TypePostService typepostservice;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getAll(){
        return employeRepository.findAll();
    }

    public Employe findEmployeById(int id){
        return employeRepository.findById(id).isPresent()? employeRepository.findById(id).get():null;
    }

    public Employe addEmploye(Employe employe){
    	TypePost p= typepostservice.find(employe.getTypePost().getDescription());
    	p.addEmploye(employe);
    	employe.setSolde(18);
    	employeRepository.save(employe);
    	typepostservice.update(p.getId(),p);
    	return employe;
    }

    public Employe updateEmploye(Employe employe, int id ){
        if(id!=employe.getCin()){
            employeRepository.deleteById(id);
        }
        return addEmploye(employe);
    }
    public void deleteEmplye(int id){
        employeRepository.deleteById(id);
    }

    public Employe login(String email, String pass){
        return getAll().stream().filter(user-> user.getLogin().equals(email)&& user.getMdp().equals(pass)).findAny().orElse(null);
    }

}
