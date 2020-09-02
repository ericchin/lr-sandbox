package com.ericwchin.liferay.pwa.rest.client.function;

import javax.annotation.Generated;

/**
 * @author Eric Chin
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}