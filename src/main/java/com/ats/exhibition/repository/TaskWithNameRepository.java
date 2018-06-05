package com.ats.exhibition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.exhibition.model.TaskWithName;

public interface TaskWithNameRepository extends JpaRepository<TaskWithName, Integer> {

	@Query(value = "SELECT t.*, e.emp_name,x.exh_name FROM t_task t,m_exh_employee e,m_exhibitor x WHERE t.emp_id=e.emp_id AND x.exh_id=t.exh_id AND t.is_used=1", nativeQuery = true)
	List<TaskWithName> findByIsUsed();

	@Query(value = "SELECT t.*, e.emp_name,x.exh_name FROM t_task t,m_exh_employee e,m_exhibitor x WHERE t.emp_id=e.emp_id AND x.exh_id=t.exh_id AND t.is_used=1 AND t.exh_id=:exhId", nativeQuery = true)
	List<TaskWithName> findByExhId(@Param("exhId") int exhId);

	@Query(value = "SELECT t.*, e.emp_name,x.exh_name FROM t_task t,m_exh_employee e,m_exhibitor x WHERE t.emp_id=e.emp_id AND x.exh_id=t.exh_id AND t.is_used=1 AND t.task_id=:taskId", nativeQuery = true)
	TaskWithName findByTaskIdAndIsUsed(@Param("taskId") int taskId);

	@Query(value = "SELECT t.*, e.emp_name,x.exh_name FROM t_task t,m_exh_employee e,m_exhibitor x WHERE t.emp_id=e.emp_id AND x.exh_id=t.exh_id AND t.is_used=1 AND t.emp_id=:empId AND t.exh_id=:exhId AND t.status=1", nativeQuery = true)
	List<TaskWithName> findByEmpIdAndIsUsed(@Param("empId") int empId, @Param("exhId") int exhId);
	
	@Query(value = "SELECT t.*, e.emp_name,x.exh_name FROM t_task t,m_exh_employee e,m_exhibitor x WHERE t.emp_id=e.emp_id AND x.exh_id=t.exh_id AND t.is_used=1 AND t.exh_id=:exhId AND t.status=1", nativeQuery = true)
	List<TaskWithName> findAllEmpByIsUsed( @Param("exhId") int exhId);

}
