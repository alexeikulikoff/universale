package el.controllere.universale.serv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;

abstract class AbstractService {

	public UEntity toEntity(UDto dto, Class<? extends UEntity> clazz) throws CustomException {
		Map<String, Method> mp = new HashMap<>();
		Method[] methods = dto.getClass().getDeclaredMethods();
		for (Method method : methods) {
			mp.put(method.getName(), method);
		}
		Method[] entMethods = clazz.getDeclaredMethods();
		Constructor<?> constructor = null;
		Object newEntity = null;
		try {
			constructor = clazz.getConstructor();
			try {
				newEntity = constructor.newInstance();
				for (Method setter : entMethods) {
					if (setter.getName().startsWith("set")) {
						String methodName = setter.getName().replace("set", "get");
						Method getter = mp.get(methodName);
						if (getter != null) {
							setter.invoke(newEntity, getter.invoke(dto));
						}
					}
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new CustomException(e.getMessage());
			}

		} catch (NoSuchMethodException | SecurityException e) {
			throw new CustomException(e.getMessage());
		}
		return (UEntity) newEntity;
	}
	public UEntity toEntity(UDto dto, Function<UDto, UEntity> func) {
		return func.apply(dto);
	}
}
