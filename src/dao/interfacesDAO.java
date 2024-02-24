package dao;

import java.util.ArrayList;

public interface interfacesDAO<T> {
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);	

}
