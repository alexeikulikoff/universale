package el.controllere.universale.rest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import el.controllere.universale.Response;
import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.Dto1;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;
import el.controllere.universale.repo.Repository2;
import el.controllere.universale.repo.Repository3;
import el.controllere.universale.resolvers.ContentResolver;
import el.controllere.universale.resolvers.NameResolver;
import el.controllere.universale.serv.UService;

@Controller
public class UnoController extends AbstractController {


	public UnoController(Repository1 repo1, Repository2 repo2, Repository3 repo3) {
		super(repo1, repo2, repo3);
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}


	@PostMapping("/save")
	public @ResponseBody Response<UEntity> save(HttpServletRequest request) {
		String json;
		Response<UEntity> response = new Response<>();
		try {
			json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			Gson gson = new Gson();
			NameResolver nameResolver = gson.fromJson(json, NameResolver.class);
			ContentResolver contentResolver = gson.fromJson(json, gerContentResolverClass(nameResolver.getName()));
			response.setName(nameResolver.getName());
			try {
				UService service = getService(nameResolver.getName());
				Optional<UEntity> result = service.save(contentResolver.getContent());
				if (result.isPresent()) {
					response.setMessage("POST request is successful, data is saved");
					response.setContent(result.get());
					return response;
				} else {
					response.setMessage("Error!");
					return response;
				}

			} catch (CustomException e) {
				response.setMessage("Error!");
				return response;
			}
		} catch (IOException e) {
			response.setMessage("Error!");
			return response;
		}
	}

	@PostMapping("/delete")
	public @ResponseBody Response<String> delete(@RequestBody DelRequest request) {
		Response<String> result = new Response<>();
		UService service;
		try {
			service = getService(request.getName());
			service.deleteEntity(request.getId());
			result.setMessage("Delete ok! ");
		} catch (CustomException e) {
			result.setMessage("Delete fail!");
		}

		return result;
	}

	@GetMapping("/getAll")
	public @ResponseBody Response<List<UEntity>> getAll(@RequestParam String name) {

		UService service;
		Response<List<UEntity>> result = new Response<List<UEntity>>();
		result.setName(name);
		try {
			service = getService(name);
			@SuppressWarnings("unchecked")
			List<UEntity> dtos = (List<UEntity>) service.getAll();
			result.setMessage("OK");
			result.setContent(dtos);
		} catch (CustomException e) {
			result.setMessage("error");
		}
		return result;

	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, CustomException {

		UDto dto1 = new Dto1("Piter11", "Gast12");

		String entityName = "Entity1";

		UService service = getService(entityName);

		service.save(dto1);

		model.addAttribute("name", name);

		return "greeting";
	}

}
