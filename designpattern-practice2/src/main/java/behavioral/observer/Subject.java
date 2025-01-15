package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
	public T val;
	private List<Observer<T>> observerCollection = new ArrayList<>();
	
	public void registerObserver(Observer<T> observer) {
		observerCollection.add(observer);
	}
	
	public void unregisterObserver(Observer<T> observer) {
		observerCollection.remove(observer);
	}
	
	public void changeSubject(T val) {
		this.val = val;
		notifyObservers();
	}
	
	public void notifyObservers() {
		for(Observer<T> observer : observerCollection) {
			observer.update(val);
		}
	}

}
