package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Mobilegadgets;

public interface Storingdata extends JpaRepository<Mobilegadgets,Integer> {
	//delete queries
		@Modifying
		@Query("delete from Mobilegadgets s where s.model=?1")
		public int deletefoodByname(String model);
		
		//update queries
		@Modifying
		@Query("update Mobilegadgets s set s.brand=?1 where s.model=?2 ")
		public int updatefood(String Brand,String model);
		
		//native queries
		@Query(value="select*from food_details s where s.model=?1",nativeQuery=true)
		public List<Mobilegadgets>fetchfoodBydays(String model);
		
		//select queries1
		@Query("select s from Mobilegadgets s where s.model=?1 and s.brand=?2")
		public List<Mobilegadgets> getfoodByName(String model,String brand);

	    //select query2
		@Query("select s from Mobilegadgets s where s.model=:model")
		public List<Mobilegadgets> getfoodByname(String model);
		
		//fetch
		List<Mobilegadgets> findByModelStartingWith(String prefix);
		List<Mobilegadgets> findByModelEndingWith(String suffix);
		List<Mobilegadgets> findByPrice(String Price);

	
}

