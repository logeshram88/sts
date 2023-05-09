package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ModelLogin;

public interface RepoLogin extends JpaRepository<ModelLogin, Integer> {

	ModelLogin findByuname(String uname);
}
