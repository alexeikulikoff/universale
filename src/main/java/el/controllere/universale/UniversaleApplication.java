package el.controllere.universale;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import el.controllere.universale.dto.Dto1;
import el.controllere.universale.dto.Dto2;
import el.controllere.universale.dto.Dto3;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;
import el.controllere.universale.repo.Repository2;
import el.controllere.universale.repo.Repository3;
import el.controllere.universale.serv.Service1;
import el.controllere.universale.serv.Service2;
import el.controllere.universale.serv.Service3;

@SpringBootApplication
public class UniversaleApplication implements CommandLineRunner {

	@Autowired
	public Repository1 repository1;
	@Autowired
	public Repository2 repository2;

	@Autowired
	public Repository3 repository3;

	public static void main(String[] args) {
		SpringApplication.run(UniversaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Service1 service1 = new Service1(repository1);

		Service2 service2 = new Service2(repository2);

		Service3 service3 = new Service3(repository3);

		Stream.of(1, 2, 3, 4).forEach((s) -> {

			Dto1 e1 = new Dto1(randomStr(), randomStr());

			Dto2 e2 = new Dto2(randomStr(), randomStr(), LocalDate.of(1970, 1, 1));

			Dto3 e3 = new Dto3(randomStr(), randomStr(), LocalDate.of(1970, 1, 1), Long.valueOf(s * 1000));

			try {
				service1.save(e1);
				service2.save(e2);
				service3.save(e3);
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	private String randomStr() {
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

}
