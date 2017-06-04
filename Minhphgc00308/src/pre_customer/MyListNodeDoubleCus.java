package pre_customer;

public class MyListNodeDoubleCus<E> 
{
	@Override
	public String toString() {
		return (String) infor;
	}

	private int code(Object src) 
	{
		return src==null ? 0 : src.hashCode();
	}

	public E infor;
	public MyListNodeDoubleCus<E> next;
	public MyListNodeDoubleCus<E> prev;

	public MyListNodeDoubleCus(E x) 
	{
		infor = x;
	}
}
