package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.exhibition.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query(value = "SELECT * FROM t_task WHERE emp_id=:empId AND exh_id=:exhId AND date <= :date", nativeQuery = true)
	List<Task> findByEmpIdAndExhIdAndDate(@Param("empId") int empId, @Param("exhId") int exhId,
			@Param("date") String date);

	Task findBytaskId(int taskId);

	@Transactional
	@Modifying
	@Query("UPDATE Task SET isUsed=0  WHERE task_id=:taskId")
	int deleteTask(@Param("taskId") int taskId);

	List<Task> findByIsUsed(int i);
}