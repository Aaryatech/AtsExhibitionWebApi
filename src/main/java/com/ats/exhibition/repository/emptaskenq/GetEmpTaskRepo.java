package com.ats.exhibition.repository.emptaskenq;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.exhibition.model.emptaskenq.GetEmpTask;

public interface GetEmpTaskRepo extends JpaRepository<GetEmpTask, Integer> {
	
	@Query(value = "SELECT t_task.task_id, t_task.emp_id,t_task.date,t_task.task_desc,m_exh_employee.emp_name,t_task.status FROM m_exh_employee,t_task WHERE " + 
			" t_task.emp_id=:empId AND t_task.emp_id=m_exh_employee.emp_id AND t_task.is_used=1 AND t_task.date "
			+ " BETWEEN :fromDate AND :toDate ORDER BY t_task.date, t_task.emp_id " ,  nativeQuery = true)
	List<GetEmpTask> getEmpTask(@Param("empId") int empId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	@Query(value = "SELECT t_task.task_id, t_task.emp_id,t_task.date,t_task.task_desc,m_exh_employee.emp_name,t_task.status FROM m_exh_employee,t_task WHERE " + 
			" t_task.exh_id=:exhbId AND t_task.emp_id=m_exh_employee.emp_id AND t_task.is_used=1 AND t_task.date "
			+ " BETWEEN :fromDate AND :toDate ORDER BY t_task.date, t_task.emp_id ", nativeQuery = true)
	List<GetEmpTask> getEmpTaskAllEmp(@Param("exhbId") int exhbId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
}
