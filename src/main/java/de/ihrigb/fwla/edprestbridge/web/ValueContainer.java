package de.ihrigb.fwla.edprestbridge.web;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
class ValueContainer<T> {

	static <V> ValueContainer<V> build(V value) {
		return new ValueContainer<V>(value);
	}

	private final T value;
}
