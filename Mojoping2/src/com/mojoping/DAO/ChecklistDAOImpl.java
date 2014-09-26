package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Checklist;

@Repository
public class ChecklistDAOImpl implements ChecklistDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addChecklist(Checklist checklist) {
		sessionFactory.getCurrentSession().save(checklist);	
	}

	@SuppressWarnings("unchecked")
	public List<Checklist> listChecklist() {
		return sessionFactory.getCurrentSession().createQuery("from checklist").list();
	}

	public Checklist getChecklistByCategory(Integer category_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from category where category_id = :category_id");
		query.setParameter("category_id", category_id);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist.get(0);  
        else  
            return null;  
	}

	public Checklist getChecklistBySubCategory(Integer subcategory_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from category where subcategory_id = :subcategory_id");
		query.setParameter("subcategory_id", subcategory_id);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist.get(0);  
        else  
            return null;  
	}
	@SuppressWarnings("unchecked")
	public List<Checklist> listChecklistByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		//if (checklist.size() > 0)  
            return checklist;  
      //  else  
        //    return null;  
	}
	
	public Checklist getChecklistByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist.get(0);  
        else  
            return null;  
	}

	public void removeChecklist(Integer checklist_id) {
		Checklist checklist = (Checklist) sessionFactory.getCurrentSession().load(Checklist.class, checklist_id);
		
        if (null != checklist) {
            sessionFactory.getCurrentSession().delete(checklist);
        }

	}

}
