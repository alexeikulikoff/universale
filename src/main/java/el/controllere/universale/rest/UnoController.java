package el.controllere.universale.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import el.controllere.universale.Response;
import el.controllere.universale.domain.UEntity;
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

	@RequestMapping("/table")
	public String table() {
		return "table";
	}

	@RequestMapping("/help")
	public String help() {
		return "help";
	}

	@PostMapping("/save")
	public @ResponseBody Response<UEntity> save(HttpServletRequest request) {
		String json;
		Response<UEntity> response = new Response<>();
		try {
			json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			Gson gson = new Gson();
			NameResolver nameResolver = gson.fromJson(json, NameResolver.class);
			String entityName = nameResolver.getName();
			ContentResolver contentResolver = gson.fromJson(json, gerContentResolverClass(entityName));
			response.setName(entityName);
			try {
				UService service = getService(entityName);
				Optional<UEntity> result = service.save(contentResolver.getContent());
				if (result.isPresent()) {
					response.setMessage("POST request is successful, data is saved");
					response.setContent(result.get());

				} else {
					response.setMessage("Error!");
				}

			} catch (CustomException e) {
				response.setMessage("Error!");
			}
		} catch (Exception e) {
			response.setMessage("Error!");
		}
		return response;
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

}
