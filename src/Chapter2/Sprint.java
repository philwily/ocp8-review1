package Chapter2;

@FunctionalInterface
public interface Sprint<T,R>
{
	public R sprint(T t);
}
