package utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

public final class DozerBeanCollectionMapper {

	public static <From, To> List<To> map(final List<From> source, final Class<To> destType) {
		final List<To> result = new ArrayList<To>();
		for (From element : source) {
			result.add(DozerBeanMapperSingletonWrapper.getInstance().map(element, destType));
		}
		return result;
	}

}
