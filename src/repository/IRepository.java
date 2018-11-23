package repository;

import java.util.ArrayList;

public interface IRepository <T>{
	
	public T get(int id);
	public ArrayList<T> getAll();
	public void add(T t);
	public void update(T t);
	public void remove(T t);

}
