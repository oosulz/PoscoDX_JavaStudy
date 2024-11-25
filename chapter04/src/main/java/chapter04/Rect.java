package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w,int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(h, w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		
		// 비즈니스 로직에 따라 equals를 수정 가능
		return h == other.h && w == other.w;
	}

	@Override
	public String toString() {
		return "Rect [W: "+w+", H: "+h+"]";
	}
	
	

}
