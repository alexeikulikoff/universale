package el.controllere.universale;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import el.controllere.universale.domain.Groups;
import el.controllere.universale.dto.Dto1;
import el.controllere.universale.dto.Dto2;
import el.controllere.universale.dto.Dto3;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.GroupRepository;
import el.controllere.universale.repo.Repository1;
import el.controllere.universale.repo.Repository2;
import el.controllere.universale.repo.Repository3;
import el.controllere.universale.serv.Service1;
import el.controllere.universale.serv.Service2;
import el.controllere.universale.serv.Service3;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	public Repository1 repository1;
	@Autowired
	public Repository2 repository2;

	@Autowired
	public Repository3 repository3;
	@Autowired
	public GroupRepository groupRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void initEntities() {
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

	public void initGroups() {

		groupRepository.save(new Groups(1L, "Приложение 1 – Значения справочника Должности", "", 0L));
		groupRepository.save(new Groups(2L, "Начальник МПСГ", "", 1L));
		groupRepository.save(new Groups(3L, "Начальник ОФПС", "", 1L));
		groupRepository.save(new Groups(4L, "Заместитель начальника ОФПС", "", 1L));

		groupRepository.save(new Groups(5L, "Приложение 2 – Виды пожарных стволов", "", 0L));
		groupRepository.save(new Groups(6L, "Ствол А", "", 5L));
		groupRepository.save(new Groups(7L, "Ствол Б", "", 5L));
		groupRepository.save(new Groups(8L, "Ствол лафетный", "", 5L));

		groupRepository.save(new Groups(8L, "Приложение 3 – Место пожара", "", 0L));

		groupRepository.save(new Groups(9L, "ПОМЕЩЕНИЯ В ЗДАНИИ (СООРУЖЕНИИ", "", 8L));
		groupRepository.save(new Groups(10L, "Электрощитовая", "10", 9L));
		groupRepository.save(new Groups(11L, "Гардероб, раздевалка", "11", 9L));
		groupRepository.save(new Groups(12L, "Складское помещение, кладовая", "15", 9L));
		groupRepository.save(new Groups(13L, "Основное производственное помещение, цех", "18", 9L));

		groupRepository.save(new Groups(14L, "ИНЖЕНЕРНЫЕ КОММУНИКАЦИИ ЗДАНИЯ (СООРУЖЕНИЯ)", "", 8L));
		groupRepository.save(new Groups(15L, "Галерея, эстакада", "12", 14L));
		groupRepository.save(new Groups(16L, "Пневмотранспортная коммуникация", "16", 14L));
		groupRepository.save(new Groups(17L, "Шахта дымоудаления, воздуховод", "17", 14L));

		groupRepository.save(new Groups(18L, "Приложение 4 – Причины пожара", "", 0L));
		groupRepository.save(new Groups(19L, "Умышленные действия ..., (поджог) ", "1", 18L));

		groupRepository.save(new Groups(20L, "НЕИСПРАВНОСТЬ ПРОИЗВОДСТВЕННОГО ОБОРУДОВАНИЯ,", "", 18L));
		groupRepository.save(new Groups(21L, "Недостаток конструкции, изготовления и монтажа...", "2", 20L));
		groupRepository.save(new Groups(22L, "Разряд статического электричества ", "4", 20L));

	}

	public void fillAll(Long p, GroupNode node) {

		List<Groups> groups = groupRepository.findByQ(p);

		for (int i = 0; i < groups.size(); i++) {
			Groups group = groups.get(i);
			GroupNode node1 = new GroupNode(group.getP(), group.getName(), group.getCode(), group.getQ());
			node.addNode(node1);
			fillAll(group.getP(), node1);
		}

	}

	@Override
	public void run(String... args) throws Exception {
		initGroups();

		GroupNode node = new GroupNode(Long.valueOf(0), "ROOT", "000", Long.valueOf(0));

		fillAll(0L, node);

		System.out.println(node);
		// initEntities();

	}

	private String randomStr() {
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

}
