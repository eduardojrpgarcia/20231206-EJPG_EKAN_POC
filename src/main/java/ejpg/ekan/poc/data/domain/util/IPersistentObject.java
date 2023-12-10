package ejpg.ekan.poc.data.domain.util;

/**
 * Functional interface for JPA Framework persistence purpose.
 *
 * @author earth
 *
 * @param <T> The instance persistence entity type.
 */
public interface IPersistentObject<T> {

	/**
	 * Getter method
	 * @return T The instance persistence entity type.
	 */
    T getId();

}
