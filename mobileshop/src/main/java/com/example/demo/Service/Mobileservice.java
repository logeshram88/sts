package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Mobilegadgets;
import com.example.demo.Model.ModelLogin;
import com.example.demo.Repository.RepoLogin;
import com.example.demo.Repository.Storingdata;

import jakarta.transaction.Transactional;

@Service
public class Mobileservice {
	@Autowired
	Storingdata repository;
	
	public String addCustomer(Mobilegadgets customer)
	{
		repository.save(customer);
		return "Added";
	}
	public List<Mobilegadgets> getCustomer()
	{
		return repository.findAll();
	}
	public Optional<Mobilegadgets> getCustomerById(int id)
	{
		return repository.findById(id);
	}
	public String updateCustomer(Mobilegadgets customer)
	{
		repository.save(customer);
		return "Updated";
	}
	public void deleteById(int id)
	{
		repository.deleteById(id);
	}
	//Sorting
		public List<Mobilegadgets > getSorted(String field)
		{
			return repository.findAll(Sort.by(Direction.ASC,field));

		}
		public List<Mobilegadgets > getWithPagination(int offset, int pagesize)
		{
			Page<Mobilegadgets > pg = repository.findAll(PageRequest.of(offset, pagesize));
			return pg.getContent();
		}
		//delete queries
				@Transactional
				public int deletefoodByname(String model)
				{
					return repository.deletefoodByname(model);
				}
				
				//update queries
				@Transactional
				public int updatefood(String Brand,String Model)
				{
					return repository.updatefood(Brand,Model);
				}
				
				//native queries
				@Transactional
				public List<Mobilegadgets> fetchfoodBydays(String Model)
				{
					return repository.fetchfoodBydays(Model);
				}
				
				//select queries1
				public List<Mobilegadgets> getfoodByName(String Model,String Brand)
				{
					return repository.getfoodByName(Model,Brand);
				}
				
				//select query2
				public List<Mobilegadgets> getfoodByname(String Model)
				{
					return repository.getfoodByname(Model);
				}
				
				//fetch by name start
				public List<Mobilegadgets> fetchfoodBynamePrefix(String prefix)
				{
					return repository.findByModelStartingWith(prefix);
				}
				//fetch by name end
				public List<Mobilegadgets> fetchfoodBynameSuffix(String suffix)
				{
					  return repository.findByModelEndingWith(suffix);
				}
				//fetch by total days
//				public List<Mobilegadgets> fetchfoodBytotaldays(String price)
//				{
//					return repository.findByPrice(price);
//				}
				
}

	
