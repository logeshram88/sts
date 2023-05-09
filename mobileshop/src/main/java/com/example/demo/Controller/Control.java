package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Mobilegadgets;
import com.example.demo.Model.ModelLogin;
import com.example.demo.Service.Mobileservice;

@RestController
@RequestMapping("/customer")
public class Control {
	@Autowired
	Mobileservice  Service;
	
	@PostMapping("/post")
	public String create(@RequestBody Mobilegadgets customer)
	{
		return Service.addCustomer(customer);
	}
	@GetMapping("")
	public List<Mobilegadgets> read()
	{
		return Service.getCustomer();
	}
	@GetMapping("/{id}")
	public Optional<Mobilegadgets>readById(@PathVariable int id)
	{
		return Service.getCustomerById(id);
	}
	@PutMapping("/put")
	public String update(@RequestBody Mobilegadgets customer)
	{
		return Service.updateCustomer(customer);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		Service.deleteById(id);
		return "Deleted";
	}
	//Sorting
		@GetMapping("/{field}")
		public List<Mobilegadgets> getProductsSorted(@PathVariable String field)
		{
			return Service.getSorted(field);
		}
		
		//Pagination
		@GetMapping("/page/{offset}/{pagesize}")
		public List<Mobilegadgets> getProductsPagination(@PathVariable int offset, @PathVariable int pagesize)
		{
			return Service.getWithPagination(offset, pagesize);
			//offset --> No of pages
			//pagesize -->No of data in a page
		}
		@DeleteMapping("/deletemapping1/{name}")
		public String deletefoodByname(@PathVariable("model") String model)
		{
			 int result=Service.deletefoodByname(model);
			 if(result>0)
				 return "Food record is deleted";
			 else
				 return"No record found";
		}
		
		//update queries
		@PutMapping("/updatebyquery/{model}/{id}")
		public String updatefood(@PathVariable String brand,@PathVariable String model)
		{
			int res=Service.updatefood(brand,model);
			if(res>0)
				return "food record updated";
			else
				return "Problem occured while updating";
		}
		
		//native queries
		@GetMapping("fetchbydays/{Model}")
		public List<Mobilegadgets> fetchfoodBydays(@PathVariable String model){
			return Service.fetchfoodBydays(model);
		}
		
		//select query1
		@GetMapping("getfoodByName/{model}/{id}")
		public List<Mobilegadgets> getfoodByName(@PathVariable String model,@PathVariable String id)
		{
			return Service.getfoodByName(model,id);
		}

		//select query2
		@GetMapping("getfoodByname/{model}")
		public List<Mobilegadgets> getfoodByname(@PathVariable String model)
		{
			return Service.getfoodByname(model);
		}
		
		//fetch by name start

		@GetMapping("/prefixname/{prefix}")
		public List<Mobilegadgets> fetchFoodDetailsBynamePrefix(@RequestParam String prefix)
		{
			 return Service.fetchfoodBynamePrefix(prefix);
		}
		//fetch by name end

		@GetMapping("/Suffixname/{suffix}")
		public List<Mobilegadgets>fetchfoodBynameSuffix(@RequestParam String suffix)
		{
			return Service.fetchfoodBynameSuffix(suffix);
		}
		//fetch by theme

//		@GetMapping("/gettheme/{Price}")
//		public List<Mobilegadgets> fetchfoodBytotaldays(@RequestParam String Price)
//		{
//			return Service.fetchfoodBytotaldays(Price);
//		}
	}
	