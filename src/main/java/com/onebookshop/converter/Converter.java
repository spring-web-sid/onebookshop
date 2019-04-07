package com.onebookshop.converter;

import java.util.List;

public interface Converter<SOURCE, TARGET> {

	TARGET convert(SOURCE source);
	List<TARGET> convertAll(List<SOURCE> sources);
}
