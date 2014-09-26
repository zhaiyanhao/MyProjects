package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Procedure;

@Repository
public class ProcedureDAOImpl implements ProcedureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProcedure(Procedure procedure) {
		
		//sessionFactory.getCurrentSession().flush();
		//sessionFactory.getCurrentSession().save(procedure);
			Query query = sessionFactory.getCurrentSession().createSQLQuery("insert into mojoping.procedure(checklist_id, step_title, step_details, procedure_file,tutoriol_video_url) values(:ID,:TI,:DE,:FI,:VI)" ).addEntity(Procedure.class);
			//query.setParameter("procedure", procedure);
	/*		if(procedure==null){
				procedure.setChecklist_id(1);
				procedure.setProcedure_file(null);
				procedure.setStep_details("null");
				procedure.setStep_title("null title");
				procedure.setTutoriol_video_url("null video");
				
			}*/
			
			query.setInteger("ID", procedure.getChecklist_id());
			query.setString("TI", procedure.getStep_title());
			query.setString("DE",procedure.getStep_details());
			query.setBinary("FI", procedure.getProcedure_file());
			query.setString("VI", procedure.getTutoriol_video_url());
			
			query.executeUpdate();
		
			
	
	}

	@SuppressWarnings("unchecked")
	public List<Procedure> listProcedure() {
		return sessionFactory.getCurrentSession().createSQLQuery("select * from mojoping.procedure").list();
	}

	public Procedure getProcedure(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from procedure where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		@SuppressWarnings("unchecked")
		List<Procedure> procedure = query.list();
		
		if (procedure.size() > 0)  
            return procedure.get(0);  
        else  
            return null;  
	}

	public List<Procedure> getProcedureWithChecklistId(Integer checklist_id) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from mojoping.procedure where checklist_id = :checklist_id");
		query.setParameter("checklist_id", checklist_id);
		query.executeUpdate();
		@SuppressWarnings("unchecked")
		List<Procedure> procedure = query.list();
		
		if (procedure.size() > 0)  
            return procedure;  
        else  
            return null;  
	}
	
	public void removeProcedure(Integer procedure_id) {
		Procedure procedure = (Procedure) sessionFactory.getCurrentSession().load(Procedure.class, procedure_id);
		
        if (null != procedure) {
            sessionFactory.getCurrentSession().delete(procedure);
        }
	}

}
