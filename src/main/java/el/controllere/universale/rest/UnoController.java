package el.controllere.universale.rest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import el.controllere.universale.Clazz;
import el.controllere.universale.dto.Dto1;
import el.controllere.universale.dto.RootDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;
import el.controllere.universale.repo.Repository2;
import el.controllere.universale.serv.RootService;
import el.controllere.universale.serv.Service1;
import el.controllere.universale.serv.Service2;

@Controller
public class UnoController {

	Map<String, Clazz> classMap = new HashMap<>();

	private Repository1 repository1;

	private Repository2 repository2;

	public UnoController(Repository1 repo1, Repository2 repo2) {

		repository1 = repo1;

		repository2 = repo2;

		classMap.put("Entity1", new Clazz("Entity1", Service1.class, Repository1.class, repository1));

		classMap.put("Entity2", new Clazz("Entity2", Service2.class, Repository2.class, repository2));

	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, CustomException {

		RootDto dto1 = new Dto1("Piter11", "Gast12");

		String entityName = "Entity1";

		RootService service = getService(entityName);

		service.save(dto1);

		model.addAttribute("name", name);

		return "greeting";
	}

	private RootService getService(String entityName) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Clazz clazz = classMap.get(entityName);

		CrudRepository<?, ?> repository = clazz.getRepository();

		Class<? extends RootService> serviceClass = clazz.getServiceClass();

		Constructor<?> constructor = serviceClass.getConstructor(clazz.getRepositoryClass());

		RootService service = (RootService) constructor.newInstance(repository);

		return service;
	}

}
