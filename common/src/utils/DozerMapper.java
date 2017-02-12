package utils;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

public class DozerMapper {

	public static Mapper getInstance() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
}
